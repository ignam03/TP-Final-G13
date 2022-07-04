package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Ciudadano> getCiudadanos() {
		return ciudadanoDaoImp.findAll();
	}

	@Override
	public Ciudadano findCiudadano(Long id) throws Exception {
		// TODO Auto-generated method stub
		return ciudadanoDaoImp.findById(id).orElseThrow(() -> new Exception("El Usuario no Existe"));
	}

	@Override
	public Ciudadano getCiudadanoByDni(Long dni) throws Exception {
		// TODO Auto-generated method stub
		return ciudadanoDaoImp.findByDni(dni).orElseThrow(() -> new Exception("El Usuario no Existe"));
	}

	
}
