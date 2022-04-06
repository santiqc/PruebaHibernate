package com.vista.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.santi.aplicacion.*;
import com.santi.dao.MascotaDao;
import com.santi.entidades.Mascota;
import com.santi.entidades.Persona;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ConsultarMascotasGui extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdDueno;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnCancelar;
	private JButton btnBuscar;


	private Coordinador miCoordinador;
	private JLabel lblRaza;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnActualizar;
	
	Mascota miMascota= new Mascota();
	MascotaDao miMascotaDao=new MascotaDao();
	private JTextField textSexo;
	private JTextField textColor;
	private JButton btnEliminar;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	public ConsultarMascotasGui(VentanaPrincipalGui ventanaPrincipal, boolean modal, String documento) {
		super(ventanaPrincipal,modal);
		setSize( 408, 288);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes(documento);
		
		
	}


	private void iniciarComponentes(String documento) {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("GESTIONAR MASCOTAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 370, 192);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDueno = new JLabel("Id Due\u00F1o:");
		lblDueno.setBounds(24, 17, 71, 21);
		panel.add(lblDueno);
		
		txtIdDueno = new JTextField();
		txtIdDueno.setText(documento);
		txtIdDueno.setBounds(88, 17, 86, 20);
		panel.add(txtIdDueno);
		txtIdDueno.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 49, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 49, 86, 20);
		panel.add(txtNombre);
		
		lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(214, 49, 71, 21);
		panel.add(lblRaza);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(269, 49, 86, 20);
		panel.add(txtTelefono);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 127, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(271, 150, 89, 23);
		panel.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(182, 16, 89, 23);
		btnBuscar.addActionListener(this);
		panel.add(btnBuscar);
		btnBuscar.addActionListener(this);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(24, 81, 71, 21);
		panel.add(lblSexo);
		

		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(214, 82, 71, 21);
		panel.add(lblColor);
		
		textSexo = new JTextField();
		textSexo.setColumns(10);
		textSexo.setBounds(59, 81, 86, 20);
		panel.add(textSexo);
		
		textColor = new JTextField();
		textColor.setColumns(10);
		textColor.setBounds(269, 81, 86, 20);
		panel.add(textColor);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(170, 150, 89, 23);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(59, 150, 89, 23);
		panel.add(btnEliminar);
		btnActualizar.addActionListener(this);
		btnEliminar.addActionListener(this);
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnBuscar) {
			Long idMascota=Long.parseLong(txtIdDueno.getText());
			miMascota= miMascotaDao.consultarMascota(idMascota);

			if(miMascota!=null){
				System.out.println(miMascota);
				txtIdDueno.setText(String.valueOf(miMascota.getIdMascota()));
				txtNombre.setText(miMascota.getNombre());
				txtTelefono.setText(miMascota.getRaza());
				textSexo.setText(miMascota.getSexo());
				textColor.setText(miMascota.getColorMascota());
				
				
			}else {
				JOptionPane.showMessageDialog(null, "No se encuentra la mascota, verifique el documento","ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
			}}
		if (e.getSource() == btnActualizar) {
			Long idMascota = Long.parseLong(txtIdDueno.getText());
			Mascota miMascota=miMascotaDao.consultarMascota(idMascota);
			
			if (miMascota!=null) {
				System.out.println(miMascota);
				System.out.println();
				miMascota.setNombre(txtNombre.getText());
				miMascota.setRaza(lblRaza.getText());
				miMascota.setColorMascota(textColor.getText());
				miMascota.setSexo(textSexo.getText());
				
				System.out.println(miMascotaDao.actualizarMascota(miMascota));
				System.out.println();
				

				Long idDuenio=Long.parseLong(txtIdDueno.getText());
				Persona duenio=new Persona();
				duenio.setIdPersona(idDuenio);
				miMascota.setDuenio(duenio);
				System.out.println(miMascotaDao.registrarMascota(miMascota));
				System.out.println();
				
				
			}else {
				System.out.println();
				System.out.println();
			}
			System.out.println();
		}
		if (e.getSource()==btnEliminar) {
			Long idMascota=Long.parseLong(txtIdDueno.getText());
			Mascota miMascota=miMascotaDao.consultarMascota(idMascota);
			
			if (miMascota !=null) {
				System.out.println(miMascotaDao);
				System.out.println();
				
				System.out.println(miMascotaDao.eliminarMascota(miMascota));
				System.out.println("Mascota eliminada");
				
			}else {
				System.out.println();
				System.out.println("No se encontro la mascota");
			}
			System.out.println();
			
		}
			
		}
			
		}
	