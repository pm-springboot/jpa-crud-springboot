package com.paul.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paul.entity.Tipo;
import com.paul.repository.TipoRepository;


/***
 * Servicio del catálogo Tipo
 * @author PM
 *
 */
@Service("tipoServiceImpl")
public class TipoServiceImpl implements TipoService {

	private Logger LOG = LoggerFactory.getLogger(TipoServiceImpl.class);
	
	private TipoRepository tipoRepository;
	
	
	@Autowired(required=true)
	public TipoServiceImpl(TipoRepository tipoRepository) {
		super();
		this.tipoRepository = tipoRepository;
	}

	/**
	 * @see
	 */
	@Override
	public Tipo getTipo(String clave) throws Exception {
		LOG.info("getTipo");
		Tipo tipo = tipoRepository.findByClave(clave);	
		if (tipo == null) {
			throw new Exception("No se encontró el Tipo con clave " + clave);			
		}
		return tipo;
	}

	/**
	 * @see
	 */
	@Override
	public List<Tipo> getTipos() throws Exception {
		
		List<Tipo> tipos = tipoRepository.findAll();
		if(tipos.isEmpty()) {
			throw new Exception("No se encontraron Tipos");
		}
		return tipos;
	}
	
	/***
	 * @see
	 */
	@Override
	public Tipo save(Tipo tipo) throws Exception {
		
		Tipo findTipo = tipoRepository.findByClave(tipo.getClave());
		if(!Objects.isNull(findTipo)) {
			throw new Exception("El Tipo " + tipo.getClave() + " ya se encuentra registrado");
		}
		return tipoRepository.save(tipo);
	}

	/***
	 * @see
	 */
	@Override
	public Tipo update(Tipo tipo) throws Exception {
		Tipo findTipo = tipoRepository.findByClave(tipo.getClave());
		if(Objects.isNull(findTipo)) {
			throw new Exception("El Tipo " + tipo.getClave() + " no existe");
		}
		return tipoRepository.save(tipo);
	}
	
	/***
	 * @see
	 */
	@Override
	public void delete(Tipo tipo) throws Exception {
		Tipo findTipo = tipoRepository.findByClave(tipo.getClave());
		if(Objects.isNull(findTipo)) {
			throw new Exception("El Tipo " + tipo.getClave() + " no existe");
		}
		tipoRepository.delete(tipo);
	}
}