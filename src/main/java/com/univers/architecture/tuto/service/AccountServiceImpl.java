/**
 * 
 */
package com.univers.architecture.tuto.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univers.architecture.tuto.dao.IAccountRepository;
import com.univers.architecture.tuto.model.Account;
import com.univers.architecture.tuto.model.EmailAlreadyExistsException;

/**
 * @author sabir
 *
 */
@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;

	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.datafuture.testplus.api.service.IAccountService#createNewAccount(fr.
	 * datafuture.testplus.api.model.Account)
	 */
	@Override
	public Account createNewAccount(Account account) {
		
		log.info("Creating account: "+account);

		Account accountFound = this.accountRepository.findByEmail(account.getEmail());
		if(accountFound!=null) {
			throw new EmailAlreadyExistsException(account.getEmail());
		}
		
		return this.accountRepository.save(account);
	}

	
}
