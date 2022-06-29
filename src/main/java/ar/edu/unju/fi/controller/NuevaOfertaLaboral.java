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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.OfertaLaboral;
import ar.edu.unju.fi.service.IOfertaLaboralService;

@Controller
@RequestMapping("/ofertaLaboral")
public class NuevaOfertaLaboral {

    @Autowired
    @Qualifier("OfertaLaboralServiceImp")
    private IOfertaLaboralService ofertaLaboralSvc;

    private static final Log LOGGER = LogFactory.getLog(NuevaOfertaLaboral.class);

    @GetMapping("/nuevo")
    public String getForNewEmpleoPage(Model model) {
        model.addAttribute("ofertaLaboral", new OfertaLaboral());
        return "oferLabForm";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarOfertaLaboral(@Validated @ModelAttribute("ofertaLaboral") OfertaLaboral ofertaLaboral,
            BindingResult bindingResult) {


        ModelAndView model = new ModelAndView("ofertaLaboral");
        ofertaLaboralSvc.saveOfertaLaboral(ofertaLaboral);
        return model;
    }

    @GetMapping("/misPublicaciones")
    public String getCvPage(Model model) {
        List<OfertaLaboral> listaLaborales = ofertaLaboralSvc.getOfertasLaborales();
        model.addAttribute("ofertasLaborales", listaLaborales);
        for (OfertaLaboral ofertaLaboral : listaLaborales) {

        }
        return "publicaciones";
    }

    @GetMapping("/verEmpleos")
    public String getListaEmpleoPage(Model model) {
        List<OfertaLaboral> listaLaborales = ofertaLaboralSvc.getOfertasLaborales();
        model.addAttribute("ofertasLaborales", listaLaborales);
        for (OfertaLaboral ofertaLaboral : listaLaborales) {

        }
        return "ofertaLaboral";
    }

    @GetMapping("/verEmpleo")
    public ModelAndView verEmpleoPage(@RequestParam(name = "oferNumber") Long oferNumber) {
        ModelAndView model = new ModelAndView("empleo");
        List<OfertaLaboral> listaLaborales = ofertaLaboralSvc.getOfertasLaborales();
        Optional<OfertaLaboral> o = listaLaborales.stream().filter(empleo -> oferNumber == empleo.getOferNumber())
                .findFirst();
        model.addObject("empleo", o);
        return model;
    }

}
