package com.idat.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDTORequest {
	
	private Integer idCliente;
	private String Nombre;
	private String documento;
	private String direccion;

}
