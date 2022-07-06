package ar.edu.unju.fi.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.OfertaLaboral;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IOfertaLaboralService;
import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/ciudadano")
public class NuevoCiudadanoController {

	//
	@Autowired
	@Qualifier("CiudadanoServiceImp")
	private ICiudadanoService ciudadanoSvc;

	@Autowired
	@Qualifier("OfertaLaboralServiceImp")
	private IOfertaLaboralService ofertaLaboralSvc;

	@Autowired
	@Qualifier("UsuarioServiceImp")
	private IUsuarioService usuarioSvc;

	private static final Log LOGGER = LogFactory.getLog(NuevoCiudadanoController.class);

	@GetMapping("/nuevo")
	public String getFormNewCiuddanoPage(Model model) {
		model.addAttribute("ciudadano", new Ciudadano());
		return "ciudadanoForm";
	}

	@PostMapping("/guardar")
	public ModelAndView guardarCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las validaciones");
			ModelAndView mov = new ModelAndView("ciudadanoForm");
			return mov;

		}

		if (ciudadano.calcularEdad() < 18) {
			ModelAndView mave = new ModelAndView("errorEdad");
			mave.addObject("ciudadano", ciudadano);
			return mave;
		}

		ModelAndView mov = new ModelAndView("loginCiudadano");
		Usuario usuario = new Usuario();
		usuario.setUsername(ciudadano.getDni());
		usuario.setPassword(ciudadano.getContrasena());
		usuario.setTipo(ciudadano.getPerfil());
		usuarioSvc.saveUsuario(usuario);
		ciudadanoSvc.saveCiudadano(ciudadano);
		mov.addObject("inicio");
		return mov;
	}

	@GetMapping("/verEmpleo/{id}")
	public ModelAndView getEditOfertaLaboralPage(@PathVariable(value = "id") Long id) throws Exception {
		ModelAndView mov = new ModelAndView("verEmpleo");
		OfertaLaboral ofertaLaboral = ofertaLaboralSvc.findOfertaLaboral(id);
		mov.addObject("ofertaLaboral", ofertaLaboral);
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
	
	// @GetMapping("/contratado")
	// public String getContratadoPage(Model model) {
	// 	return "contratado";
	// }
}
