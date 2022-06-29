package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.entity.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum,Long>{
    
}
