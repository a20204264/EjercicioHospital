package com.idat.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class HospitalClienteFK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3236269991492678489L;

	@Column(name="id_hospital", nullable = false, unique = true)
	private Integer idHospital;
	
	@Column(name="id_cliente", nullable = false, unique = true)
	private Integer idCliente;
	

}
