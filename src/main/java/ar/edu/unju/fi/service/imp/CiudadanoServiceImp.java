package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.repository.CiudadanoRepository;
import ar.edu.unju.fi.service.ICiudadanoService;

@Service("CiudadanoServiceImp")
public class CiudadanoServiceImp implements ICiudadanoService{
	
	@Autowired
	CiudadanoRepository ciudadanoDaoImp;

	@Override
	public void saveCiudadano(Ciudadano ciudadano) {
		String pw = ciudadano.getContrasena();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		ciudadano.setContrasena(bCryptPasswordEncoder.encode(pw));
		ciudadanoDaoImp.save(ciudadano);

	}

	
}
