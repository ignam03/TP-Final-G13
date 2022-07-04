package ar.edu.unju.fi.controller;

import java.security.Principal;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
=======
<<<<<<< HEAD


=======
>>>>>>> parent of f54fcb7 (valid)
>>>>>>> branch 'master' of https://github.com/ignam03/TP-FinalPV-G13.git
import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICurriculumService;

@Controller
@RequestMapping("/curriculum")
public class NuevoCvController {

	@Autowired
	@Qualifier("CurriculumServiceImp")
	private ICurriculumService curriculumSvc;

	@Autowired
	@Qualifier("CiudadanoServiceImp")
	private ICiudadanoService ciudadanoSvc;

	private static final Log LOGGER = LogFactory.getLog(NuevoCvController.class);

	@GetMapping("/nuevo")
	public String getFormNewCurriculumPage(Model model) {
		model.addAttribute("curriculum", new Curriculum());
		// List<Ciudadano> ciudadanos = ciudadanoSvc.getCiudadanos();
		// model.addAttribute("ciudadano", ciudadanos);
		return "createCv";
	}

	@PostMapping("/guardar")
<<<<<<< HEAD
	public ModelAndView guardarCurriculum(@Validated @ModelAttribute("curriculum") Curriculum curriculum, Model model,
=======
	public ModelAndView guardarCurriculum(@Validated @ModelAttribute("curriculum") Curriculum curriculum,
>>>>>>> branch 'master' of https://github.com/ignam03/TP-FinalPV-G13.git
			BindingResult bindingResult) {
		LOGGER.info("cirruculum" + curriculum);
		if (bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las validaciones");
			ModelAndView mov = new ModelAndView("cv");
			return mov;
		}
		// List<Ciudadano> ciudadanoss = ciudadanoSvc.getCiudadanos();
		ModelAndView mod = new ModelAndView("cv");
		LOGGER.info("cirruculum" + curriculum.getApellido());
		curriculumSvc.saveCurriculum(curriculum);
<<<<<<< HEAD
		return mod;
=======
		return model;
>>>>>>> branch 'master' of https://github.com/ignam03/TP-FinalPV-G13.git
	}

	@GetMapping("/verCv")
	public String getVerCvPage(Model model, Principal principal) throws Exception {
		try {
			// LOGGER.info(principal);
			Ciudadano existe = ciudadanoSvc.getCiudadanoByDni(Long.parseLong(principal.getName()));
			// LOGGER.info(existe.getDni());
			LOGGER.info(existe.getCurriculum());
			model.addAttribute("ciudadanoActual", existe);

			return "cv";
		} catch (Exception e) {
			model.addAttribute("usuarioErrorMensaje", e.getMessage());
		}
		model.addAttribute("attributeValue");
		return "cv";
	}
<<<<<<< HEAD

	@GetMapping("/editar/{id}")
	public ModelAndView getEditOfertaLaboralPage(@PathVariable(value = "id") Long id) throws Exception {
		ModelAndView mov = new ModelAndView("editarCv");
		Curriculum curriculum = curriculumSvc.findCurriculum(id);
		mov.addObject("curriculum", curriculum);
		return mov;
	}

	@PostMapping("/modificar")
	public ModelAndView editarDatosOfertaLaboral(
			@Validated @ModelAttribute("curriculum") Curriculum curriculum,
			BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			LOGGER.info("ocurrio un error " + curriculum);
			ModelAndView mav = new ModelAndView("editarOfertaLaboral");
			mav.addObject("curriculum", curriculum);
			return mav;
		}
		;
		ModelAndView mav = new ModelAndView("redirect:/curriculum/verCv");
		try {
			curriculumSvc.modify(curriculum);
			LOGGER.info("oferta " + curriculum.getApellido());
			LOGGER.info("oferta " + curriculum.getConocimientos());
		} catch (Exception e) {
			LOGGER.info("erorr" + e.getMessage());
		}
		LOGGER.info("guardado");
		return mav;
	}
=======
>>>>>>> branch 'master' of https://github.com/ignam03/TP-FinalPV-G13.git
}
