package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.entity.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {

    // todo buscar perfiles por palabra clave
    @Query("SELECT p FROM Curriculum p WHERE" + " CONCAT(p.id,p.nombre,p.apellido)" + "LIKE %?1%")
    public List<Curriculum> filter(String filtro);

}
