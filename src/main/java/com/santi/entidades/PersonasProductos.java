package com.santi.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "personas_productos")
public class PersonasProductos implements Serializable{
		
		private static final long serialVersionUID=1L;
		 
		@Id
		@Column(name = "persona_id")
		private Long personaId;
		
		@Id
		@Column(name = "producto_id")
		private Long productoId;
		
		public PersonasProductos() {
}

		public PersonasProductos(Long personaId, Long productoId) {
			super();
			this.personaId = personaId;
			this.productoId = productoId;
		}

		public Long getPersonaId() {
			return personaId;
		}

		public void setPersonaId(Long personaId) {
			this.personaId = personaId;
		}

		public Long getProductoId() {
			return productoId;
		}

		public void setProductoId(Long productoId) {
			this.productoId = productoId;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "PersonasProductos [personaId=" + personaId + ", productoId=" + productoId + "]";
		}
		
		
}