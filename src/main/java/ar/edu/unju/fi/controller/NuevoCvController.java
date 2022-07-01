package ar.edu.unju.fi.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		List<Ciudadano> ciudadanos = ciudadanoSvc.getCiudadanos();
		model.addAttribute("ciudadano", ciudadanos);
		return "createCv";
	}

	@PostMapping("/guardar")
	public ModelAndView guardarCurriculum(@Validated @ModelAttribute("curriculum") Curriculum curriculum,
			BindingResult bindingResult) {
		LOGGER.info("cirruculum" + curriculum);
		List<Ciudadano> ciudadanos = ciudadanoSvc.getCiudadanos();
		ModelAndView model = new ModelAndView("cv");
		LOGGER.info("cirruculum" + curriculum.getApellido());
		curriculumSvc.saveCurriculum(curriculum);
		return model;
	}

	@GetMapping("/verCv")
	public String getCvPage(Model model) {
		model.addAttribute("attributeValue");
		return "cv";
	}
}
