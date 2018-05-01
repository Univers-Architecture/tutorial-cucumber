/**
 * 
 */
package fr.datafuture.testplus.api.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.datafuture.testplus.api.dao.IAccountRepository;
import fr.datafuture.testplus.api.model.Account;

/**
 * @author sabir
 *
 */
@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;

	@Autowired
	private BCryptPasswordEncoder cryptEncoderService;

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

		// TODO : il faut implémenter les règles indiquées dans la Javadoc

		account.setPassword(this.cryptEncoderService.encode(account.getPassword()));

		return this.accountRepository.save(account);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.datafuture.testplus.api.service.IAccountService#getAccountById(java.
	 * lang.Long)
	 */
	@Override
	public Account getAccountById(Long accountId) {

		Optional<Account> opAccount = this.accountRepository.findById(accountId);

		return opAccount.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.datafuture.testplus.api.service.IAccountService#updateAccountInfos(
	 * java.lang.Long, fr.datafuture.testplus.api.model.Account)
	 */
	@Override
	public Account updateBasicAccountInfos(Long accountId, Account accountDetails) {

		log.info("updateBasicAccountInfos for account {}", accountId);

		// Account existingAccount = this.getAccountById(accountId);

		// TODO : prendre les infos *non null* dans accountDetails et les mettre
		// dans existingAccount

		accountDetails.setId(accountId);

		return this.accountRepository.save(accountDetails);
	}

}
