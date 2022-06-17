package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.repository.UserRepository;

@Service
public class LoginUsuarioImp implements UserDetailsService {

    @Autowired
    UserRepository ciudadanoRepo;

    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {

        Ciudadano ciudadanoEncontrado = ciudadanoRepo.findBydni(Long.parseLong(dni))
                .orElseThrow(() -> new UsernameNotFoundException("Usuario inválido"));

        List<GrantedAuthority> perfiles = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ciudadanoEncontrado.getPerfil());
        perfiles.add(grantedAuthority);

        UserDetails user = (UserDetails) new User(dni, ciudadanoEncontrado.getContrasena(), perfiles);
        return user;
    }

}
