package backend.controllers;

import backend.Account;
import backend.brokers.LoginBroker;
import backend.handlers.AccountDTO;

public class LoginController {

	public boolean checkCredentials(AccountDTO credentials) {
		boolean value = false;
		LoginBroker lb = new LoginBroker();
		Account account = lb.loadAccount(credentials.username);

		if (account != null
				&& account.getPassword() == account
						.generatePassword(credentials.password)) {
			value = true;
		}
		return value;
	}

}
