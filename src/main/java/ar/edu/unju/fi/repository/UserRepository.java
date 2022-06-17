package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Ciudadano;

@Repository
public interface UserRepository extends JpaRepository<Ciudadano, Long> {
    public Optional<Ciudadano> findBydni(Long dni);
}
