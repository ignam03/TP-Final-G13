package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Empleador;

@Repository
public interface EmpleadorRepository extends JpaRepository<Empleador, Long>{
	

}
