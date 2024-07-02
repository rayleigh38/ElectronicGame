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
	//Consulta personalizada para buscar los articulos que en el campo nombre de la tabla Articulo
	//contienen la cadena buscada
	@Query("SELECT a FROM Articulo a WHERE upper(a.nombre) LIKE upper(concat('%',:cadena,'%'))")
	List<Articulo> findByNameLike(@Param("cadena")String cadena);
	@Query("SELECT DISTINCT a.seccion FROM Articulo a")
	List<String> listaSecciones();
	@Query("SELECT DISTINCT a.categoria FROM Articulo a where a.seccion= :seccion")
	List<String> datosCategoria(@Param("seccion")String seccion);
	@Query("SELECT DISTINCT a.subcategoria FROM Articulo a where a.categoria=:categoria")
	List<Articulo> datosSubCategoria(@Param("categoria")String seccion);
}
