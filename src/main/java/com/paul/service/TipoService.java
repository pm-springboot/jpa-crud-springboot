package com.paul.service;

import java.util.List;

import com.paul.entity.Tipo;

/***
 * Se definen los métodos de servicio para el catálogo TIPO
 * @author PM
 *
 */
public interface TipoService {

	/***
	 * Consultar Tipo
	 * @param clave cave del tipo
	 * @return El Tipo
	 */
	Tipo getTipo(String clave) throws Exception;
	
	/***
	 * Consultar la lista de Tipos
	 * @return lista de tipos
	 */
	List<Tipo> getTipos() throws Exception;
	
	/***
	 * Guardar un nuevo Tipo
	 * @param tipo la informacion del Tipo
	 * @return el nuevo Tipo
	 */
	Tipo save (Tipo tipo) throws Exception;
	
	/***
	 * Actualizar un Tipo
	 * @param tipo información del Tipo
	 * @return el Tipo actualizado
	 */
	Tipo update (Tipo tipo) throws Exception;
	
	
	/***
	 * Eliminar un tipo
	 * @param tipo
	 * @return
	 * @throws Exception
	 */
	void delete (Tipo tipo) throws Exception;
	
}