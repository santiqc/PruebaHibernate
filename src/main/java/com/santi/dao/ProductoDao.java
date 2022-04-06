package com.santi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.santi.aplicacion.JPAUtil;
import com.santi.entidades.Persona;
import com.santi.entidades.PersonasProductos;
import com.santi.entidades.Producto;

public class ProductoDao {

	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public String registraProducto(Producto miProducto) {
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(miProducto);
			entityManager.getTransaction().commit();
			
			resp="Producto Registrado";
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede registrar"+"el producto verifique que el dueño exista","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return resp;
	}
	public String registrarCompra(PersonasProductos producto) {
		
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(producto);
			entityManager.getTransaction().commit();
			
			resp="Se realizo la compra del producto";
			
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "no se puede registrar la compra del producto","ERROR",JOptionPane.ERROR_MESSAGE);
			
		}
		return resp;
	}
	
	public List<Producto> consultarListaProducto(){
		
		List<Producto> listaProducto=new ArrayList<Producto>();
		Query query=entityManager.createQuery("SELECT p FROM Producto p");
		listaProducto=query.getResultList();
		
		return listaProducto;
	}
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}
	public Producto consultarProducto(Long idProducto) {
		Producto miProducto=entityManager.find(Producto.class, idProducto);
		
		if (miProducto!=null) {
			return miProducto;
			
			
		}else {
			return null;
		}

	}
	
  public String actualizarProducto(Producto miProducto) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(miProducto);
		entityManager.getTransaction().commit();
		

		String resp="Producto Actualizado!";
		
		return resp;
	}
  
  public String eliminarProducto(Producto miProducto) {
	String resp="";
	try {
		entityManager.getTransaction().begin();
		entityManager.remove(miProducto);
		entityManager.getTransaction().commit();
		

		resp="Producto Eliminado!";
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se puede eliminar la persona"+" verifique que no tena registros pendientes","ERROR",JOptionPane.ERROR_MESSAGE);
	}
	
	
	return resp;
  }

}
