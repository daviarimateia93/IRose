package irose.client.stp.parser;

import irose.util.BaseParser;
import irose.util.Request;
import irose.util.Response;
import me.gerenciar.stp.gateway.Peer;
import me.gerenciar.stp.parser.ParserPeerKnown;

public class ClientAccountParser extends BaseParser implements ParserPeerKnown
{
	@Override
	public String getType()
	{
		return "ACCOUNT";
	}
	
	@Override
	public void onPeerStart(Peer peer)
	{
		write(peer, new Request("irose.server.service.AccountService", "login", "davi", "123"));
	}
	
	@Override
	public void onPeerEnd(Peer peer)
	{
	
	}
	
	@Override
	protected void read(Peer peer, Response response)
	{
		System.out.println("READ");
		System.out.println(response);
	}
}
