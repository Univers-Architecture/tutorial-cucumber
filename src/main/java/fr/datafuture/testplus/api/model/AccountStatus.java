/**
 * 
 */
package fr.datafuture.testplus.api.model;

/**
 * Les différents status qu'un compte peut avoir
 * 
 * @author sabir
 *
 */
public enum AccountStatus {

	CREATED,
	/* On a validé l'email de l'utilisateur */
	EMAIL_ACTIVATED,
	/* L'utilisateur a saisi le détail de son compte */
	DETAIL_OK;
}
