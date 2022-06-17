package ar.edu.unju.fi.service;

import java.util.Optional;

import ar.edu.unju.fi.entity.Ciudadano;

public interface ILoginUsuario {
    public Optional<Ciudadano> findBydni(Long dni);
}
