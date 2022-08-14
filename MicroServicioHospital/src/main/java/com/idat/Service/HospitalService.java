package com.idat.Service;

import java.util.List;

import com.idat.DTO.HospitalDTORequest;
import com.idat.DTO.HospitalDTOResponse;




public interface HospitalService {
	
	List<HospitalDTOResponse> listar();
	HospitalDTOResponse ObtenerId(Integer id);	
	void guardar(HospitalDTORequest hospital);
	void eliminar(Integer id);
	void actualizar(HospitalDTORequest hospital);	
	
	void asignarClienteaHospital();

}
