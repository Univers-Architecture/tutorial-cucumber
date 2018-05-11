Feature: User sign up
  --> L'utilisateur doit être inscrit avec succès si l'email n'existe pas déjà dans la base de données.
  --> un message d'erreur s'affiche si l'email existe déjà dans la base de données.


  	
  	
Scenario: Inscription réussie
  Given Qu'il y'a aucun account avec l'email "test@test.com"
  When Un nouveau user essaie de s'inscrire avec l'email "test@test.com"
  Then Un nouveau compte est crée avec l'email "test@test.com"
  
Scenario: Inscription impossible avec un email déjà utilisé
	Given Qu'il y'a aucun account avec l'email "another@another.com"
    Given Un premier user s'inscrit avec l'email "another@another.com"
    When Un nouveau user essaie de s'inscrire avec l'email "another@another.com"
    Then Une erreur indique que l'email  "another@another.com" est déjà utilisé
    
    


	
  
  
 

  
  
    

	