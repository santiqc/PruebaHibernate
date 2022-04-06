
package clases;

import java.util.List;

import javax.swing.JOptionPane;

import com.santi.aplicacion.JPAUtil;
import com.santi.dao.ProductoDao;
import com.santi.entidades.Persona;
import com.santi.entidades.PersonasProductos;
import com.santi.entidades.Producto;

public class GestionProductos {
	
	ProductoDao miProductoDao=new ProductoDao();
	

	public GestionProductos() {
		
		String menu="MENU DE OPCIONES - GESTION PRODUCTOS\n\n";
		menu+="1. Registrar Producto\n";
		menu+="2. Consultar Producto\n";
		menu+="3. Consultar Lista de Productos\n";
		menu+="4. Comprar Productos\n";
		menu+="5. Actualizar Productos\n";
		menu+="6. Eliminar Productos\n";
		menu+="7. Salir\n";
		
		int opc=0;
		
		while (opc!=7) {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opc) {
			case 1: registrar();break;
			case 2: consultar();break;
			case 3: consultarLista();break;
			case 4: comprarProductos();break;
			case 5: actualizarNombre();break;
			case 6: eliminar();break;
			case 7: miProductoDao.close();;break;


			}
			
		}
		
	}
	
	private void eliminar() {
		 Long idProducto=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del Producto"));
			
			Producto miProducto= miProductoDao.consultarProducto(idProducto);
		
		if (miProducto !=null) {
			System.out.println(miProducto);
			System.out.println();
			
			
			System.out.println(miProductoDao.eliminarProducto(miProducto));
			System.out.println();
			
			
		}else {
			System.out.println();
			System.out.println("No se encontro el producto");
			
		}
		System.out.println();
		
	
		
	}

	private void consultar() {
     Long idProducto=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del Producto"));
		
		Producto miProducto= miProductoDao.consultarProducto(idProducto);
		
		if (miProducto!=null) {
			System.out.println(miProducto);
			System.out.println();
			
			
		}else {
			System.out.println();
			System.out.println("No se encontro el producto");
		}
		System.out.println();
		
	}

	private void actualizarNombre() {
		 Long idProducto=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del Producto"));
			
		Producto miProducto= miProductoDao.consultarProducto(idProducto);
		
		if (miProducto !=null) {
			System.out.println(miProducto);
			System.out.println();
			miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el nombre de la Persona"));
			
			System.out.println(miProductoDao.actualizarProducto(miProducto));
			System.out.println();
			
			
		}else {
			System.out.println();
			System.out.println("No se encontro el producto");
			
		}
		System.out.println();
		
	}

	private void consultarLista() {
		System.out.println("Lista de productos");
		List<Producto> listaPersonas= miProductoDao.consultarListaProducto();
		
		
		for (Producto producto : listaPersonas) {
			System.out.println(producto);
		}
		
		
	}

	private void registrar() {
		Producto miProducto= new Producto();
		miProducto.setIdProducto(null);
		miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el nombre del producto"));
		miProducto.setPrecioProducto(JOptionPane.showInputDialog("Ingrese el precio del producto"));
		
		
		System.out.println(miProductoDao.registraProducto(miProducto));
		System.out.println();
	
	}

	private void comprarProductos() {
		
		PersonasProductos producto;
		Long personaId;
		Long productoId;
		
		int opc=0;
		
		do {
			
			producto=new PersonasProductos();
			personaId=Long.parseLong(JOptionPane.showInputDialog("Ingrese el documento de la persona"));
			productoId=Long.parseLong(JOptionPane.showInputDialog("Ingrese el codigo del producto"));
			
			producto.setPersonaId(personaId);
			producto.setProductoId(productoId);
			System.out.println(miProductoDao.registrarCompra(producto));
			System.out.println();
			opc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea agregar otro producto"));
		} while (opc==1);
	}
	
	
}
