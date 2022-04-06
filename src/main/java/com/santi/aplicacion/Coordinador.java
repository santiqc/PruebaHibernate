package com.santi.aplicacion;

import java.awt.Dialog;
import java.util.ArrayList;

import com.santi.dao.MascotaDao;
import com.santi.dao.PersonaDao;
import com.santi.dao.ProductoDao;
import com.santi.entidades.Mascota;
import com.santi.entidades.Persona;
import com.vista.gui.ConsultarMascotasGui;
import com.vista.gui.ConsultarPersonasGui;
import com.vista.gui.ConsultarProductosGui;
import com.vista.gui.RegistrarMascotasGui;
import com.vista.gui.RegistrarPersonasGui;
import com.vista.gui.RegistrarProductosGui;
import com.vista.gui.VentanaPrincipalGui;



public class Coordinador {
	
	
	VentanaPrincipalGui miVentanaPrincipalGui;
	
	RegistrarPersonasGui miRegistrarPersonasGui;
	
	RegistrarMascotasGui miRegistrarMascotasGui;
	
	//RegistrarProductosGui miRegistrarProductosGui;
	
	PersonaDao miPersonaDao;
	
	MascotaDao miMascotaDao;
	
	ProductoDao miProductoDao;

	RegistrarProductosGui miRegistrarProductosGui;

	ConsultarPersonasGui miConsultarPersonasGui;
	
	ConsultarMascotasGui miConsultarMascotasGui;
	
	ConsultarProductosGui miConsultarProductosGui;


	

	
	
	public void setVentanaPrincipalGui(VentanaPrincipalGui miVentanaPrincipal) {
		this.miVentanaPrincipalGui = miVentanaPrincipal;
	}

	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
		this.miRegistrarPersonasGui = miRegistrarPersonasGui;
	}
	
	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		this.miRegistrarMascotasGui = miRegistrarMascotasGui;
		
	}
	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductosGui) {
		this.miRegistrarProductosGui= miRegistrarProductosGui;
		
	}
	public void setConsultarPersonasGui(ConsultarPersonasGui miConsultarPersonasGui) {
		this.miConsultarPersonasGui= miConsultarPersonasGui;
		
	}
	public void setConsultarMascotasGui(ConsultarMascotasGui miConsultarMascotasGui) {
		this.miConsultarMascotasGui= miConsultarMascotasGui;
	}



	public void setPersonaDao(PersonaDao miPersonaDao) {
		this.miPersonaDao = miPersonaDao;
	}

	public void setMascotaDao(MascotaDao miMascotaDao) {
		this.miMascotaDao = miMascotaDao;
	}

	public void setProductoDao(ProductoDao miProductoDao) {
		this.miProductoDao = miProductoDao;
	}

	public void mostrarVentanaRegistroPersonas() {
		miRegistrarPersonasGui.setVisible(true);
		
	}
	public void mostrarVentanaRegistroMacotas() {
		miRegistrarMascotasGui.setVisible(true);
		
	}
	public void mostrarVentanaRegistroProductos() {
		miRegistrarProductosGui.setVisible(true);
		
	}
	public void mostrarVentanaConsultaPersona() {
		miConsultarPersonasGui.setVisible(true);
		
	}
	public void mostrarVentanaConsultaMascotas() {
		miConsultarMascotasGui.setVisible(true);
		
	}

	public String registrarPersona(Persona miPersona) {
		return miPersonaDao.registrarPersona(miPersona);
		
	}

	public String registrarMascota(Mascota miMascota) {
		return miMascotaDao.registrarMascota(miMascota);
	}

	public void mostrarVentanaConsultaProductos() {
		miConsultarProductosGui.setVisible(true);
		
	}

	public void setConsultarProductosGui(ConsultarProductosGui miConsultarProductosGui) {
		this.miConsultarProductosGui= miConsultarProductosGui;
		
	}

	

	
		
	

	
	
}