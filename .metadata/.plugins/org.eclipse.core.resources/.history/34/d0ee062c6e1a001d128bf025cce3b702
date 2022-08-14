package com.idat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.DTO.DoctorDTORequest;
import com.idat.DTO.DoctorDTOResponse;
import com.idat.Service.DoctorService;

@Controller
@RequestMapping("/doctor/v1")
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	//LISTAR TODO
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<DoctorDTOResponse>> listar() {				
		
		return new ResponseEntity<List<DoctorDTOResponse>>( service.listar(), HttpStatus.OK);
	}
	
	
	//OBTENER POR ID:
	@GetMapping("/{id}")
	public  @ResponseBody DoctorDTOResponse ObtenerProductoId(@PathVariable Integer id) {
		return service.ObtenerId(id);
	}
	
		
	
	//GUARDAR
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody DoctorDTORequest doctor) {
		service.guardar(doctor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	//ELIMINAR
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		
		DoctorDTOResponse doctor=service.ObtenerId(id);
		
		if(doctor != null) {
			service.eliminar(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	//ACTUALIZAR
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody DoctorDTORequest doctor) {
		
		DoctorDTOResponse doctores=service.ObtenerId(doctor.getIddoc());
		
		if(doctores != null) {
			service.actualizar(doctor);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	//LISTAR POR ID
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<DoctorDTOResponse> obtenerId(@PathVariable Integer id) {
		
		DoctorDTOResponse d=service.ObtenerId(id);
		
		if(d != null) {			
			
			return new ResponseEntity<DoctorDTOResponse>(service.ObtenerId(id), HttpStatus.OK);
		}
		return new ResponseEntity<DoctorDTOResponse>(HttpStatus.NOT_FOUND);
	}


}
