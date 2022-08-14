package com.idat.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idat.Client.OpenFeignClient;
import com.idat.DTO.Cliente;
import com.idat.DTO.HospitalDTORequest;
import com.idat.DTO.HospitalDTOResponse;
import com.idat.Model.Hospital;
import com.idat.Model.HospitalClienteFK;
import com.idat.Model.HospitalDetalle;
import com.idat.Repository.HospitalClienteRepository;
import com.idat.Repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalRepository repository;
	
	@Autowired
	private HospitalClienteRepository repositoryDetalle;
	
	
	@Autowired
	private OpenFeignClient feign;
	

	@Override
	public List<HospitalDTOResponse> listar() {

		List<HospitalDTOResponse> listar = new ArrayList<>();
		HospitalDTOResponse dto = null;
		List<Hospital> h= repository.findAll();
		
		for(Hospital hospital: h) {
			
			dto = new HospitalDTOResponse();
			
			
			dto.setIdHospital(hospital.getIdHospital());
			dto.setHospital(hospital.getHospital());
			
			listar.add(dto);
			
		}
		
		return listar;
	}

	@Override
	public HospitalDTOResponse ObtenerId(Integer id) {

		Hospital hospital = repository.findById(id).orElse(null);
		HospitalDTOResponse dto = new HospitalDTOResponse();
		dto= new HospitalDTOResponse();
		
		dto.setIdHospital(hospital.getIdHospital());
		dto.setHospital(hospital.getHospital());
		
		
		return dto;
	}

	@Override
	public void guardar(HospitalDTORequest hospital) {
		Hospital h= new Hospital();
		
		h.setHospital(hospital.getHospital());
		
		repository.save(h);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void actualizar(HospitalDTORequest hospital) {
		Hospital h= new Hospital();
		h.setIdHospital(hospital.getIdHospital());
		h.setHospital(hospital.getHospital());
		repository.saveAndFlush(h);

	}

	@Override
	public void asignarClienteaHospital() {
		
		List<Cliente> listado= feign.listarClientesSeleccionados();
		HospitalClienteFK fk= null;
		HospitalDetalle detalle = null;
		
		for(Cliente cliente: listado) {
			
			fk=new HospitalClienteFK();			
			fk.setIdCliente(cliente.getIdCliente());
			fk.setIdHospital(1);
			
			detalle = new HospitalDetalle();
			detalle.setFk(fk);
			
			repositoryDetalle.save(detalle);
			
		}
		
	}


}
