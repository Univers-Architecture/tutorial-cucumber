package fr.datafuture.testplus.api.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.datafuture.testplus.api.model.Account;
import fr.datafuture.testplus.api.service.IAccountService;

/**
 * Une URL non protégé commence par /api/public
 */
@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private IAccountService accountService;

	@PostMapping("/public/accounts")
	public AccountDTO createNewAccount(@RequestBody Account account) {

		Account newAccount = this.accountService.createNewAccount(account);

		return this.accountToDTO(newAccount);

	}

	@GetMapping("/private/accounts/{id}")
	public AccountDTO getAccountById(@PathVariable(value = "id") Long accountId) {

		Account account = this.accountService.getAccountById(accountId);

		return this.accountToDTO(account);
	}

	@PutMapping("/private/accounts/{id}")
	public AccountDTO updateAccount(@PathVariable(value = "id") Long accountId, @RequestBody Account accountDetails) {

		Account account = this.accountService.updateBasicAccountInfos(accountId, accountDetails);

		return this.accountToDTO(account);
	}

	/**
	 * Account to DTO.
	 * 
	 * Account est un objet sensible qu'il ne faut jamais retourner au front !
	 *
	 * @param account
	 *            the account
	 * @return the account DTO
	 */
	protected AccountDTO accountToDTO(Account account) {

		AccountDTO dto = new AccountDTO();

		BeanUtils.copyProperties(account, dto);

		return dto;
	}
}
