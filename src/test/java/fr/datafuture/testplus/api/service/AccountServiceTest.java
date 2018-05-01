/**
 * 
 */
package fr.datafuture.testplus.api.service;

import org.junit.Test;

import fr.datafuture.testplus.api.model.Account;

/**
 * @author sabir
 *
 */
public class AccountServiceTest {

	@Test
	public void testCreateNewAccount() {
		IAccountService accountService = new AccountServiceImpl();
		Account account = new Account();
		accountService.createNewAccount(account);

		// TODO mocker les repo
		// TODO faire le asserts
	}
}
