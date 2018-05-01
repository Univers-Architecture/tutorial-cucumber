/**
 * 
 */
package fr.datafuture.testplus.api.service;

import fr.datafuture.testplus.api.model.Account;
import fr.datafuture.testplus.api.model.AccountPlan;
import fr.datafuture.testplus.api.model.AccountRole;
import fr.datafuture.testplus.api.model.AccountStatus;

/**
 * @author sabir
 *
 */
public interface IAccountService {

	/**
	 * Creation d'un compte simple sans lui associer un {@link AccountPlan},
	 * avec un rôle {@link AccountRole#OWNER} et un status
	 * {@link AccountStatus#CREATED}
	 * 
	 * 0) L'email ne doit pas déjà exister
	 * 
	 * 1) Il faut controller la taille des champs: A faire peut être coté
	 * Controller ...
	 * 
	 * 2) Le password doit être hashé
	 * 
	 * 3) Bien renseigner creationDate et modifDate
	 *
	 * @param account
	 *            the account
	 * @return the account
	 */
	public Account createNewAccount(Account account);

	/**
	 * Gets the account by id.
	 *
	 * @param accountId
	 *            the account id
	 * @return the account by id
	 */
	public Account getAccountById(Long accountId);

	/**
	 * Update account infos.
	 * 
	 * 0) S'assurer que les champs ont bien été mis à jour 1) Modifier la date
	 * de modification
	 *
	 * @param accountId
	 *            the account id
	 * @param accountDetails
	 *            the account details
	 * @return the account
	 */
	public Account updateBasicAccountInfos(Long accountId, Account accountDetails);
}
