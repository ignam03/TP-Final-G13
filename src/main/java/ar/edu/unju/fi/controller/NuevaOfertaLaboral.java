package ar.edu.unju.fi.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

        ModelAndView model = new ModelAndView("redirect:/ofertaLaboral/verEmpleos");
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

    @GetMapping("/editar/{id}")
    public ModelAndView getEditOfertaLaboralPage(@PathVariable(value = "id") Long id) throws Exception {
        ModelAndView mov = new ModelAndView("editarOfertaLaboral");
        OfertaLaboral ofertaLaboral = ofertaLaboralSvc.findOfertaLaboral(id);
        mov.addObject("ofertaLaboral", ofertaLaboral);
        return mov;
    }

    @PostMapping("/modificar")
    public ModelAndView editarDatosOfertaLaboral(
            @Validated @ModelAttribute("ofertaLaboral") OfertaLaboral ofertaLaboral,
            BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            LOGGER.info("ocurrio un error " + ofertaLaboral);
            ModelAndView mav = new ModelAndView("editarOfertaLaboral");
            mav.addObject("ofertaLaboral", ofertaLaboral);
            return mav;
        }
        ;
        ModelAndView mav = new ModelAndView("redirect:/ofertaLaboral/misPublicaciones");
        try {
            ofertaLaboralSvc.modify(ofertaLaboral);
            LOGGER.info("oferta " + ofertaLaboral.getCantVacantes());
            LOGGER.info("oferta " + ofertaLaboral.getOferNumber());
        } catch (Exception e) {
            LOGGER.info("erorr" + e.getMessage());
        }
        LOGGER.info("guardado");
        return mav;
    }

    @GetMapping("/eliminar/{id}")
    public String deleteOfertaLaboral(Model model, @PathVariable(name = "id") Long id) {
        try {
            ofertaLaboralSvc.deleteOfertaLaboral(id);
        } catch (Exception e) {
            model.addAttribute("Errorr", e.getMessage());
        }
        return "redirect:/ofertaLaboral/misPublicaciones";
    }

    // @GetMapping("/eliminar/{id}")
    // @ResponseBody // Usos response para ver resultado de consultas rapido
    // public List<OfertaLaboral> mostrar(@RequestParam(value = "desde", defaultValue = "01/01/1800") String desde,
    //     @RequestParam(value = "hasta") String hasta, ModelAndView mp) throws ParseException {
    //     // Paso fechas a servicio
    //     mp.addObject("hola", movimientoServicio.buscarFecha(desde, hasta));
    //     System.out.println(desde + "    " + hasta);
    //     return movimientoServicio.buscarFecha(desde, hasta);

    // }
}
