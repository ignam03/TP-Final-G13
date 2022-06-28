package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.util.ListaProvincia;

@Controller
@RequestMapping("/ciudadano")
public class NuevoCiudadanoController {

	@Autowired
	@Qualifier("CiudadanoServiceImp")
	private ICiudadanoService ciudadanoSvc;

	@Autowired
	@Qualifier("UsuarioServiceImp")
	private IUsuarioService usuarioSvc;

	private static final Log LOGGER = LogFactory.getLog(NuevoCiudadanoController.class);

	@GetMapping("/nuevo")
	public String getFormNewCiuddanoPage(Model model) {
		model.addAttribute("ciudadano", new Ciudadano());
		ListaProvincia listaProvincia = new ListaProvincia();
		model.addAttribute("provincias", listaProvincia.getProvincias());
		return "ciudadanoForm";
	}

	@PostMapping("/guardar")
	public ModelAndView guardarCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las validaciones");
			ModelAndView mov = new ModelAndView("ciudadanoForm");
			ListaProvincia listaProvincia = new ListaProvincia();
			mov.addObject("provincias", listaProvincia.getProvincias());
			return mov;

		}

		ModelAndView mov = new ModelAndView("loginCiudadano");
		// ListaProvincia listaProvincia = new ListaProvincia();
		// Optional<Provincia> provincia = listaProvincia.getProvincias().stream()
		// .filter(d -> d.getCodigo() ==
		// ciudadano.getProvincia().getCodigo()).findFirst();
		// LOGGER.info("Provincia"+ provincia.get().getNombreP());
		// ciudadano.setProvincia(provincia.get());
		// LOGGER.info("ciudadano pr " + ciudadano.getProvincia().getNombreP());
		Usuario usuario = new Usuario();
		usuario.setUsername(ciudadano.getDni());
		usuario.setPassword(ciudadano.getContrasena());
		usuario.setTipo(ciudadano.getPerfil());
		usuarioSvc.saveUsuario(usuario);
		ciudadanoSvc.saveCiudadano(ciudadano);
		mov.addObject("inicio");
		return mov;
	}


	@GetMapping("/cargarCv")
	public String getCargarCvPage(Model model) {
		return "cargarCv";
	}

	@GetMapping("/verCv")
	public String getCvPage(Model model) {
		return "cv";
	}
}
