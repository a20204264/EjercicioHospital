package com.idat.Service;

import java.util.List;

import com.idat.DTO.ClienteDTORequest;
import com.idat.DTO.ClienteDTOResponse;





public interface ClienteService {
	
	List<ClienteDTOResponse> listar();
	ClienteDTOResponse ObtenerId(Integer id);	
	void guardar(ClienteDTORequest cliente);
	void eliminar(Integer id);
	void actualizar(ClienteDTORequest cliente);	
	

}
