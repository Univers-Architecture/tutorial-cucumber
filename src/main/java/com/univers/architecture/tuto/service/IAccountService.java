/**
 * 
 */
package com.univers.architecture.tuto.service;

import com.univers.architecture.tuto.model.Account;

/**
 * @author sabir
 *
 */
public interface IAccountService {

	/**
	 * Creation d'un compte 
	 * 
	 * @param account
	 *            the account
	 * @return the account
	 */
	public Account createNewAccount(Account account);

	
}
