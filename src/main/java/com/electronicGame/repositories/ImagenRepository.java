package com.electronicGame.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.electronicGame.entities.Imagen;

public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
	@Query("SELECT i FROM Imagen i WHERE i.articulo.id = :articuloId")
    List<Imagen> findByArticuloId(@Param("articuloId") int articuloId);
}