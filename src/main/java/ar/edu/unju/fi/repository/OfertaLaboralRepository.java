package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.entity.OfertaLaboral;
import ar.edu.unju.fi.entity.Usuario;

public interface OfertaLaboralRepository extends JpaRepository<OfertaLaboral, Long> {

    //todo recupera los datos entre dos fechas
    public List<OfertaLaboral> findByfechaPubBetween(LocalDate date1, LocalDate date2);

    //todo buscar por nombre

}
