package irose.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import me.gerenciar.sjson.parser.Reader;
import me.gerenciar.sjson.parser.Writer;
import me.gerenciar.sjson.util.Json;
import me.gerenciar.stp.gateway.Peer;
import me.gerenciar.stp.message.Message;
import me.gerenciar.stp.message.Payload;
import me.gerenciar.stp.parser.Parser;
import me.gerenciar.stp.system.STPException;
import me.gerenciar.stp.system.STPLogger;

public abstract class BaseParser extends Parser
{
	@SuppressWarnings("unchecked")
	@Override
	protected void read(Peer peer, Message message)
	{
		Json json = convert(Json.class, message);
		Map<String, Object> rootMap = (Map<String, Object>) json.get("ROOT");
		String className = ((String) rootMap.get("__className__")).split("\\;")[1];
		
		if(className.endsWith("Request"))
		{
			Request request = convert(Request.class, message);
			
			handleRead(peer, request);
			
			read(peer, request);
		}
		else if(className.endsWith("Response"))
		{
			Response response = convert(Response.class, message);
			
			handleRead(peer, response);
			
			read(peer, response);
		}
	}
	
	@Override
	protected void written(Peer peer, Message message)
	{
		Request request = convert(Request.class, message);
		Response response = convert(Response.class, message);
		
		if(request != null)
		{
			written(peer, request);
		}
		else if(response != null)
		{
			written(peer, response);
		}
	}
	
	private void handleRead(Peer peer, Request request)
	{
		try
		{
			Class<?> type = Class.forName(request.getRequestClassName());
			
			List<Class<?>> paramsClassNames = new ArrayList<>();
			
			for(String paramClassName : request.getRequestParamsClassNames())
			{
				try
				{
					paramsClassNames.add(Class.forName(paramClassName));
				}
				catch(ClassNotFoundException exception)
				{
				}
			}
			
			List<Class<?>> requestParamClassNamesWithPeer = new ArrayList<>();
			requestParamClassNamesWithPeer.addAll(paramsClassNames);
			requestParamClassNamesWithPeer.add(peer.getClass());
			
			Method methodWithPeer = getMethod(type, request.getRequestMethodName(), requestParamClassNamesWithPeer.toArray(new Class<?>[requestParamClassNamesWithPeer.size()]));
			Method method = getMethod(type, request.getRequestMethodName(), paramsClassNames.toArray(new Class<?>[paramsClassNames.size()]));
			
			Method invokeMethod = methodWithPeer != null ? methodWithPeer : method;
			
			List<Object> requestParamsWithPeer = new ArrayList<>(Arrays.asList(request.getRequestParams()));
			requestParamsWithPeer.add(peer);
			
			if(invokeMethod.isAnnotationPresent(Requestable.class))
			{
				write(peer, new Response(Response.Status.OK, methodWithPeer != null ? methodWithPeer.invoke(ServiceManager.get(type), requestParamsWithPeer.toArray(new Object[requestParamsWithPeer.size()])) : method.invoke(ServiceManager.get(type), request.getRequestParams())));
			}
			else
			{
				write(peer, new Response(Response.Status.ERROR, "Method is not @Requestable"));
			}
		}
		catch(ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException exception)
		{
			write(peer, new Response(Response.Status.ERROR, exception.getMessage()));
		}
	}
	
	private void handleRead(Peer peer, Response response)
	{
	
	}
	
	protected void write(Peer peer, Object object)
	{
		byte[] payloadContent = new Writer().write(object).getBytes();
		
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
	
	private <T> T convert(Class<T> type, Message message)
	{
		return new Reader().read(type, new String(message.getPayload().getContent(), Charset.forName(Constants.TEXT_CHARSET_UTF_8)));
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
	
	protected void read(Peer peer, Request request)
	{
	
	}
	
	protected void written(Peer peer, Request request)
	{
	
	}
	
	protected void read(Peer peer, Response response)
	{
	
	}
	
	protected void written(Peer peer, Response response)
	{
	
	}
}
