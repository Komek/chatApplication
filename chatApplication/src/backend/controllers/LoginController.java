package backend.controllers;

import backend.Account;
import backend.brokers.AccountBroker;
import backend.brokers.PersonBroker;
import backend.handlers.AccountDTO;
import backend.handlers.PersonDTO;

public class LoginController {
	private Account account;

	public boolean checkCredentials(AccountDTO credentials) {
		boolean value = false;
		AccountBroker ab = new AccountBroker();
		account = ab.loadAccount(credentials.username);

		if (account != null
				&& account.getPassword() == account
						.generatePassword(credentials.password)) {
			value = true;
		}
		return value;
	}

	public boolean createUser(AccountDTO accountDto, PersonDTO personDto) {
		boolean ret = false;

		AccountBroker ab = new AccountBroker();
		PersonBroker pb = new PersonBroker();

		if (pb.createPerson(personDto.firstname, personDto.lastname,
				personDto.email)) {
			if (ab.createAccount(accountDto.username, accountDto.password,
					pb.getPerson(personDto.email))) {
				ret = true;
			}

		}
		return ret;

	}

}
