/**
 * 
 */
package fr.datafuture.testplus.api.dao;

import org.springframework.data.repository.CrudRepository;

import fr.datafuture.testplus.api.model.Account;

/**
 * @author sabir
 *
 */
public interface IAccountRepository extends CrudRepository<Account, Long> {

	public Account findByEmail(String email);

}
