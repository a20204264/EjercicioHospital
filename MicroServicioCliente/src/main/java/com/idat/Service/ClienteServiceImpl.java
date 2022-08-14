package com.idat.Service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.DTO.ClienteDTORequest;
import com.idat.DTO.ClienteDTOResponse;
import com.idat.Model.Cliente;
import com.idat.Repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public List<ClienteDTOResponse> listar() {
		List<ClienteDTOResponse> listar = new ArrayList<>();
		ClienteDTOResponse dto = null;
		List<Cliente> c = repository.findAll();
		
		for(Cliente cliente :c) {
			
			dto = new ClienteDTOResponse();
			
			dto.setIdCliente(cliente.getIdCliente());
			dto.setNombre(cliente.getNombre());
			dto.setDocumento(cliente.getDocumento());
			dto.setDireccion(cliente.getDireccion());
			
			listar.add(dto);
			
		}
		
		return listar;
	}

	@Override
	public ClienteDTOResponse ObtenerId(Integer id) {
		Cliente cliente = repository.findById(id).orElse(null);
		ClienteDTOResponse dto = new ClienteDTOResponse();
		dto= new ClienteDTOResponse();
		
		dto.setIdCliente(cliente.getIdCliente());
		dto.setNombre(cliente.getNombre());
		dto.setDocumento(cliente.getDocumento());
		dto.setDireccion(cliente.getDireccion());
		
		return dto;
	}
	
	@Override
	public void guardar(ClienteDTORequest cliente) {

		Cliente c= new Cliente();
		
		c.setNombre(cliente.getNombre());
		c.setDocumento(cliente.getDocumento());
		c.setDireccion(cliente.getDireccion());
		
		repository.save(c);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public void actualizar(ClienteDTORequest cliente) {
		Cliente c= new Cliente();
		
		c.setIdCliente(cliente.getIdCliente());
		c.setNombre(cliente.getNombre());
		c.setDocumento(cliente.getDocumento());
		c.setDireccion(cliente.getDireccion());
		
		repository.saveAndFlush(c);
	}

	

	
	

}
