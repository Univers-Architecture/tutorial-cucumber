/**
 * 
 */
package com.univers.architecture.tuto.dao;

import org.springframework.data.repository.CrudRepository;

import com.univers.architecture.tuto.model.Account;

/**
 * Account Repository
 *
 */
public interface IAccountRepository extends CrudRepository<Account, Long> {

	public Account findByEmail(String email);

}
