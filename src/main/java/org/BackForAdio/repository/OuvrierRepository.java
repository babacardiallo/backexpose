package org.BackForAdio.repository;


import org.BackForAdio.entiites.Ourvrier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OuvrierRepository extends JpaRepository<Ourvrier, String> {
	
	  @Query("select o from Ourvrier o where o.metier_ouvrier.nom_metier like :x")
	  public Page<Ourvrier> chercher(@Param("x")String mc, Pageable pageable);

}
