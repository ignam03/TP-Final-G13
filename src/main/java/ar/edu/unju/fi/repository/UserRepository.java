package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ar.edu.unju.fi.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findByUsername(Long dni);
}
