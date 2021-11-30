package com.demoGadd.tusEventos.model.pojo;

import java.sql.Date;

public class Evento {
	
	private int id;
	private String nombre;
	private String lugar;
	private Date fecha;
	private Double precio;
	private int disponibles;
	private int vendidas;
	private int aforo;
	private String portadaImg;
	
	public Evento() {
		super();
		this.id = -1;
	}
	
	public Evento(int id, String nombre, String lugar, Date fecha, Double precio, int disponibles, int vendidas,
			int aforo, String portadaImg) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lugar = lugar;
		this.fecha = fecha;
		this.precio = precio;
		this.disponibles = disponibles;
		this.vendidas = vendidas;
		this.aforo = aforo;
		this.portadaImg = portadaImg;
	}
	
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
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getDisponibles() {
		return disponibles;
	}
	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}
	public int getVendidas() {
		return vendidas;
	}
	public void setVendidas(int vendidas) {
		this.vendidas = vendidas;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	public String getPortadaImg() {
		return portadaImg;
	}
	public void setPortadaImg(String portadaImg) {
		this.portadaImg = portadaImg;
	}
	
	
	

}
