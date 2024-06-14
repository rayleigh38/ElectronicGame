package com.electronicGame.repositories;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.electronicGame.entities.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{
	
	Logger logger = LoggerFactory.getLogger(ArticuloRepository.class);

	@Query("SELECT a FROM Articulo a WHERE upper(a.nombre) LIKE upper(concat('%',:nombre,'%'))")
	//@Query(value = "SELECT * FROM ARTICULO WHERE UPPER(ARTICULO.NOMBRE) LIKE UPPER(CONCAT('%', :nombre ,'%'))", nativeQuery = true)
	List<Articulo> findByNameLike(@Param("nombre")String nombre);
	Articulo findByNombre(String nombre);
	
}
