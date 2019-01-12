package org.BackForAdio.repository;


import org.BackForAdio.entiites.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	  @Query("select p from Produit p where p.Ourvrier.username like :x")
	  public Page<Produit> chercher(@Param("x")String mc, Pageable pageable);
	  
}
