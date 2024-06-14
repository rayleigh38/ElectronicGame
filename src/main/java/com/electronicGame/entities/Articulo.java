package com.electronicGame.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ARTICULO")
@NamedQuery(name = "Articulo.findAll",query="SELECT a FROM Articulo a")
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ARTICULO_ID")
	private int id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="CODIGO")
	private String codigo;
	@Column(name="SECCION")
	private String seccion;			
	@Column(name="CATEGORIA")
	private String categoria;
	@Column(name="SUBCATEGORIA")
	private String subcategoria;
	@Column(name="PRECIO")
	private Float precio;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="STOCK")
	private Integer stock;
	@Column(name="VENDIDOS")
	private int vendidos;
	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Imagen> imagenes = new ArrayList<>();
	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Valoracion> valoraciones = new ArrayList<>();
	 // Campo transitorio para la media de valoraciones
    private transient double mediaValoraciones;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getSubcategoria() {
		return subcategoria;
	}
	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public int getVendidos() {
		return vendidos;
	}
	public void setVendidos(int vendidos) {
		this.vendidos = vendidos;
	}
	public List<Imagen> getImagenes() {
		return imagenes;
	}
	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}
	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}
	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}
	public double getMediaValoraciones() {
		return mediaValoraciones;
	}
	public void setMediaValoraciones(double mediaValoraciones) {
		this.mediaValoraciones = mediaValoraciones;
	}
	
			

}
