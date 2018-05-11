package com.univers.architecture.tuto;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import com.univers.architecture.tuto.dao.IAccountRepository;
import com.univers.architecture.tuto.model.Account;
import com.univers.architecture.tuto.model.EmailAlreadyExistsException;
import com.univers.architecture.tuto.service.IAccountService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpSteps extends SpringBootBaseIntegrationTest {
	
	Account newAccount;
	Account firstAccount;
	String exceptionMessage;
    
	@Autowired
	IAccountRepository accountRepository;
	
	@Autowired
	IAccountService accountService;
	
	@Given("^Qu'il y'a aucun account avec l'email \"([^\"]*)\"$")
	public void quIlYAAucunAccountAvecLEmail(String email) throws Exception {
		Account account = this.accountRepository.findByEmail(email);
		
		if(account != null) {
			this.accountRepository.delete(account);
		}
		
		assertTrue(this.accountRepository.findByEmail(email) == null);
		
	   
	}

	@When("^Un nouveau user essaie de s'inscrire avec l'email \"([^\"]*)\"$")
	public void unNouveauUserEssaieDeSInscrireAvecLEmail(String email)  {
	    newAccount = new Account();
	    newAccount.setEmail(email);
	    try {
		    this.accountService.createNewAccount(newAccount);

	    }catch(EmailAlreadyExistsException e) {
	    	exceptionMessage = e.getMessage();
	    }
	}

	@Then("^Un nouveau compte est crée avec l'email \"([^\"]*)\"$")
	public void unNouveauCompteEstCréeAvecLEmail(String email) throws Exception {
	    assertTrue(this.accountRepository.findByEmail(email).getEmail().equals(email));
	}

	@Given("^Un premier user s'inscrit avec l'email \"([^\"]*)\"$")
	public void unPremierUserSInscritAvecLEmail(String email) throws Exception {
		firstAccount = new Account();
		firstAccount.setEmail(email);
	    this.accountService.createNewAccount(firstAccount);

	}

	@Then("^Une erreur indique que l'email  \"([^\"]*)\" est déjà utilisé$")
	public void uneErreurIndiqueQueLEmailEstDéjàUtilisé(String email) throws Exception {
	    assertTrue(exceptionMessage != null);
	    assertTrue(exceptionMessage.contains(email));
	    
	}
	
}
