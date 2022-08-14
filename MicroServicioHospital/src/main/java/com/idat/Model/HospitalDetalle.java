package com.idat.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="hospital_clientes")
public class HospitalDetalle {
	
	@Id
	private HospitalClienteFK fk= new HospitalClienteFK();

}
