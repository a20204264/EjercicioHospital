package com.idat.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.DTO.ClienteDTOResponse;
import com.idat.DTO.DoctorDTORequest;
import com.idat.DTO.DoctorDTOResponse;
import com.idat.Model.Cliente;
import com.idat.Model.Doctor;
import com.idat.Repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository repository;

	@Override
	public List<DoctorDTOResponse> listar() {
		List<DoctorDTOResponse> listar = new ArrayList<>();
		DoctorDTOResponse dto= null;
		List<Doctor> c=repository.findAll();
		
		for(Doctor doctor: c) {
			dto= new DoctorDTOResponse();
			
			dto.setIddoc(doctor.getIdDoctor());
			dto.setNombredoc(doctor.getNombre());
			dto.setDocumentodoc(doctor.getDocumento());
			
			
			listar.add(dto);
			
		}
		
		
		return listar;
	}

	@Override
	public DoctorDTOResponse ObtenerId(Integer id) {
		Doctor doctor = repository.findById(id).orElse(null);
		DoctorDTOResponse dto= new DoctorDTOResponse();
		
		dto= new DoctorDTOResponse();
		
		dto.setIddoc(doctor.getIdDoctor());
		dto.setNombredoc(doctor.getNombre());
		dto.setDocumentodoc(doctor.getDocumento());
		
		
		return dto;
	}

	@Override
	public void guardar(DoctorDTORequest doctor) {
		Doctor d= new Doctor();
		
		d.setNombre(doctor.getNombredoc());
		d.setDocumento(doctor.getDocumentodoc());		
		
		repository.save(d);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void actualizar(DoctorDTORequest doctor) {
		Doctor d= new Doctor();
		
		d.setIdDoctor(doctor.getIddoc());
		d.setNombre(doctor.getNombredoc());
		d.setDocumento(doctor.getDocumentodoc());
		
		
		repository.saveAndFlush(d);

	}

}
