package com.electronicGame.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="VALORACION")
public class Valoracion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="VALORACION_ID")
	private int id;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="ARTICULO_ID")
	private Articulo articulo;
	
	@Column(name="COMENTARIO", length = 1000)
	private String comentario;
	
	@Column(name="ESTRELLAS")
	private int estrellas;
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", comentario=" + comentario + ", estrellas=" + estrellas + ", articulo="
				+ articulo + "]";
	}

	

}
