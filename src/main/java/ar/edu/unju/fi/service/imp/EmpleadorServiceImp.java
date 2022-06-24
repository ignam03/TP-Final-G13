package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.repository.EmpleadorRepository;
import ar.edu.unju.fi.service.IEmpleadorService;

@Service("EmpleadorServiceImp")
public class EmpleadorServiceImp implements IEmpleadorService{

	@Autowired
	EmpleadorRepository empleadorDaoImp;

	@Override
	public void saveEmpleador(Empleador empleador) {
		String pw = empleador.getContrasena();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		empleador.setContrasena(bCryptPasswordEncoder.encode(pw));
		empleadorDaoImp.save(empleador);
	}

}
