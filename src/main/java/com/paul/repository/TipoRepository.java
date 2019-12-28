package com.paul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.paul.entity.Tipo;


/***
 * Define los métodos de repositorio para la entidad Tipo
 * @author PM
 *
 */
@Component
public interface TipoRepository extends JpaRepository<Tipo, String> {

		    Tipo findByClave(String clave);

}
