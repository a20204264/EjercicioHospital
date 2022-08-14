package com.idat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.DTO.HospitalDTORequest;
import com.idat.DTO.HospitalDTOResponse;
import com.idat.Service.HospitalService;

@Controller
@RequestMapping("/hospital/v1")
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity<List<HospitalDTOResponse>>  listar(){
		return new ResponseEntity<List<HospitalDTOResponse>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody HospitalDTOResponse ObtenerItemId(@PathVariable Integer id) {
		return service.ObtenerId(id);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void>  guardar(@RequestBody HospitalDTORequest hospital) {
		service.guardar(hospital);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody HospitalDTORequest hospital){
		
		HospitalDTOResponse hospitales= service.ObtenerId(hospital.getIdHospital());
		
		if(hospitales !=null) {
			service.actualizar(hospital);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		HospitalDTOResponse cliente= service.ObtenerId(id);
		if(cliente != null) {
			service.eliminar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}		
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<HospitalDTOResponse> obtenerId(@PathVariable Integer id){
		
		HospitalDTOResponse hospitales=service.ObtenerId(id);
		
		if(hospitales!= null) {
			return new ResponseEntity<HospitalDTOResponse>(service.ObtenerId(id), HttpStatus.OK);
		}
		return new ResponseEntity<HospitalDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/asignar")
	public @ResponseBody void asignarClientesAhospital() {
		service.asignarClienteaHospital(); 
		
	}
	
	
	
}
