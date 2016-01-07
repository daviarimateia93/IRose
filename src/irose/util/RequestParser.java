package irose.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import irose.server.stp.parser.ServerResponseParser;
import me.gerenciar.stp.gateway.Peer;
import me.gerenciar.stp.message.Message;
import me.gerenciar.stp.message.Payload;
import me.gerenciar.stp.parser.Parser;
import me.gerenciar.stp.system.STPException;
import me.gerenciar.stp.system.STPLogger;

public class RequestParser extends Parser
{
	@Override
	protected void read(Peer peer, Message message)
	{
		read(peer, getRequest(message));
	}
	
	@Override
	protected void written(Peer peer, Message message)
	{
		written(peer, getRequest(message));
	}
	
	protected void read(Peer peer, Request request)
	{
		try
		{
			Class<?> type = Class.forName(request.getClassName());
			
			List<Class<?>> paramsClassNames = new ArrayList<>();
			
			for(String paramClassName : request.getParamsClassNames())
			{
				try
				{
					paramsClassNames.add(Class.forName(paramClassName));
				}
				catch(ClassNotFoundException exception)
				{
				}
			}
			
			List<Class<?>> paramClassNamesWithPeer = new ArrayList<>();
			paramClassNamesWithPeer.addAll(paramsClassNames);
			paramClassNamesWithPeer.add(peer.getClass());
			
			Method methodWithPeer = getMethod(type, request.getMethodName(), paramClassNamesWithPeer.toArray(new Class<?>[paramClassNamesWithPeer.size()]));
			Method method = getMethod(type, request.getMethodName(), paramsClassNames.toArray(new Class<?>[paramsClassNames.size()]));
			
			Method invokeMethod = methodWithPeer != null ? methodWithPeer : method;
			
			List<Object> paramsWithPeer = new ArrayList<>(Arrays.asList(request.getParams()));
			paramsWithPeer.add(peer);
			
			if(invokeMethod.isAnnotationPresent(Requestable.class))
			{
				ServerResponseParser.getInstance().write(peer, new Response(Response.Status.OK, methodWithPeer != null ? methodWithPeer.invoke(ServiceManager.get(type), paramsWithPeer.toArray(new Object[paramsWithPeer.size()])) : method.invoke(ServiceManager.get(type), request.getParams())));
			}
			else
			{
				ServerResponseParser.getInstance().write(peer, new Response(Response.Status.ERROR, "Method is not @Requestable"));
			}
		}
		catch(ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException exception)
		{
			ServerResponseParser.getInstance().write(peer, new Response(Response.Status.ERROR, exception));
		}
	}
	
	protected void written(Peer peer, Request request)
	{
	}
	
	public void write(Peer peer, Request request)
	{
		byte[] payloadContent = request.toString().getBytes();
		
		Payload payload = new Payload();
		payload.setContent(payloadContent);
		payload.setLength(payloadContent.length);
		payload.setPosition(0);
		payload.setTotalLength(payloadContent.length);
		
		Message message = new Message();
		message.setType(getType());
		message.setPayload(payload);
		
		try
		{
			peer.getTransporter().send(message);
		}
		catch(STPException exception)
		{
			STPLogger.exception(exception);
		}
	}
	
	private Request getRequest(Message message)
	{
		return new Request().toObject(new String(message.getPayload().getContent(), Charset.forName("UTF-8")));
	}
	
	private Method getMethod(Class<?> type, String methodName, Class<?>[] parameterTypes)
	{
		boolean hasSuperclass = type.getSuperclass() != null;
		
		try
		{
			return type.getMethod(methodName, parameterTypes);
			
		}
		catch(NoSuchMethodException exception)
		{
			if(hasSuperclass)
			{
				return getMethod(type.getSuperclass(), methodName, parameterTypes);
			}
			else
			{
				return null;
			}
		}
	}
	
	@Override
	public String getType()
	{
		return "REQUEST";
	}
}
