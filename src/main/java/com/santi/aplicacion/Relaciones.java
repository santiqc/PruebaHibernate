package com.santi.aplicacion;

import com.vista.gui.ConsultarMascotasGui;
import com.vista.gui.ConsultarPersonasGui;
import com.vista.gui.ConsultarProductosGui;
import com.vista.gui.RegistrarMascotasGui;
import com.vista.gui.RegistrarPersonasGui;
import com.vista.gui.RegistrarProductosGui;
import com.vista.gui.VentanaPrincipalGui;

import com.santi.dao.*;





public class Relaciones {
	
	
	


	public Relaciones() {
		
		VentanaPrincipalGui miVentanaPrincipalGui;
		
		RegistrarPersonasGui miRegistrarPersonasGui;
		
		RegistrarMascotasGui miRegistrarMascotasGui;
		
		RegistrarProductosGui miRegistrarProductosGui;
		
		ConsultarPersonasGui miConsultarPersonasGui;
		
		ConsultarMascotasGui miConsultarMascotasGui;
		
		ConsultarProductosGui miConsultarProductosGui;
		
		Coordinador miCoordinador;
		
		PersonaDao miPersonaDao;
		
		MascotaDao miMascotaDao;
		
		ProductoDao miProductoDao;
		
	
		
		
		
		
		
		miVentanaPrincipalGui=new VentanaPrincipalGui();
		
		miRegistrarPersonasGui=new RegistrarPersonasGui(miVentanaPrincipalGui, true);
		
		miRegistrarMascotasGui= new RegistrarMascotasGui(miVentanaPrincipalGui, true, null);
		
		miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipalGui, true);
		
		miConsultarPersonasGui= new ConsultarPersonasGui(miVentanaPrincipalGui, true);
		
		miConsultarMascotasGui= new ConsultarMascotasGui(miVentanaPrincipalGui, true, null);
		
		miConsultarProductosGui=new ConsultarProductosGui(miVentanaPrincipalGui, true);
		
		
		
		
		miCoordinador=new Coordinador();
		
		miPersonaDao=new PersonaDao();
		
		miMascotaDao=new MascotaDao();
		
		miProductoDao= new ProductoDao();
		
		miCoordinador.setVentanaPrincipalGui(miVentanaPrincipalGui);
		
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		
		miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
		
		miCoordinador.setConsultarPersonasGui(miConsultarPersonasGui);
		
		miCoordinador.setConsultarMascotasGui(miConsultarMascotasGui);
		
		miCoordinador.setConsultarProductosGui(miConsultarProductosGui);
		
		
				
	
		
		
		
		
		miVentanaPrincipalGui.setCoordinador(miCoordinador);
		
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		
		miRegistrarProductosGui.setCoordinador(miCoordinador);
		
		miConsultarPersonasGui.setCoordinador(miCoordinador);
		
		miConsultarMascotasGui.setCoordinador(miCoordinador);
		
		miConsultarProductosGui.setCoordinador(miCoordinador);
		
	
		
		

		

		
		
		
		miVentanaPrincipalGui.setVisible(true);
	
	}

}
