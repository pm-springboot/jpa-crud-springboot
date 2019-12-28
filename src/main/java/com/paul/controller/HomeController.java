package com.paul.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paul.entity.Tipo;
import com.paul.response.ResponseInfo;
import com.paul.service.TipoService;

@RestController
@RequestMapping("/api")
public class HomeController {

	
	@Autowired
	private TipoService tipoService;
	
	@GetMapping("/tipo/{id}")
	public ResponseInfo getTipo(@PathVariable String id) {		
		Tipo tipo;
		try {
			tipo = tipoService.getTipo(id);
		} catch (Exception ex) {
			return new ResponseInfo(HttpStatus.CONFLICT, "Error al obtener el Tipo");
		}
		return new ResponseInfo(HttpStatus.OK, tipo);
	}
	

	@GetMapping("/tipo")
	public ResponseInfo getTipos() {
		List<Tipo> tipos = new ArrayList<Tipo>();
		try {
			tipos = tipoService.getTipos();		
		} catch (Exception ex) {
			return new ResponseInfo(HttpStatus.CONFLICT, "Error al obtener la lista de Tipos");
		}
		return new ResponseInfo(HttpStatus.OK, tipos);
	}
	
	
	@PostMapping("/tipo")
	public ResponseInfo saveTipo(@RequestBody Tipo tipoRequest) {
		
		Tipo tipoToSave = null;
		try {
			tipoToSave = tipoService.save(tipoRequest);
		} catch(Exception ex) {
			return new ResponseInfo(HttpStatus.CONFLICT, "Error guardar el nuevo Tipo");
		}
		return new ResponseInfo(HttpStatus.OK, tipoToSave);
	}
	
	
	@PutMapping("/tipo")
	public ResponseInfo updateTipo(@RequestBody Tipo tipoRequest) {
		
		Tipo tipoToUpdate = null;
		try {
			tipoToUpdate = tipoService.update(tipoRequest);
		} catch(Exception ex) {
			return new ResponseInfo(HttpStatus.CONFLICT, "Error actualizar el Tipo");
		}
		return new ResponseInfo(HttpStatus.OK, tipoToUpdate);
	}
	
	@DeleteMapping("/tipo")
	public ResponseInfo deleteTipo(@RequestBody Tipo tipoRequest) {
		
		try {
			tipoService.delete(tipoRequest);
		} catch(Exception ex) {
			return new ResponseInfo(HttpStatus.CONFLICT, "Error eliminar el Tipo");
		}
		return new ResponseInfo(HttpStatus.OK, "Tipo eliminado exitosamente");
	}
}
