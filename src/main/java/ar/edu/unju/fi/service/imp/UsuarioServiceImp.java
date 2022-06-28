package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.UserRepository;
import ar.edu.unju.fi.service.IUsuarioService;

@Service("UsuarioServiceImp")
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    UserRepository usuarioDaoImp;

    @Override
    public void saveUsuario(Usuario usuario) {
        String pw = usuario.getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        usuario.setPassword(bCryptPasswordEncoder.encode(pw));
        usuarioDaoImp.save(usuario);

    }

}
