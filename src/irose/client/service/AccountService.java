package irose.client.service;

import irose.client.IRoseClient;
import irose.util.Request;

public class AccountService
{
	public void login(String nickname, String password)
	{
		IRoseClient.getInstance().write(new Request("irose.server.service.AccountService", "login", nickname, password));
	}
}
