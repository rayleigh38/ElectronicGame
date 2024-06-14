package com.electronicGame.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.electronicGame.entities.Imagen;
import com.electronicGame.entities.Valoracion;

public interface ValoracionRepository extends JpaRepository<Valoracion, Integer> {
	@Query("SELECT v FROM Valoracion v WHERE v.articulo.id = :articuloId")
    List<Valoracion> findByArticuloId(@Param("articuloId") int articuloId);
}