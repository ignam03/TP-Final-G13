package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleos")
public class IndexController {
    

    @GetMapping("/inicio")
    public String getInicioPage(Model model) {
        return "index";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "loginForm";
    }
    @GetMapping("/ciudadano")
    public String getCiudadanoPage(Model model) {
        return "ciudadanoForm";
    }
    @GetMapping("/empleador")
    public String getEmpleadorPage(Model model) {
        return "empleadorForm";
    }
    @GetMapping("/oferta")
    public String getoferLabFormPage(Model model) {
        return "oferLabForm";
    }
    @GetMapping("/login4")
    public String getPlantillaPage(Model model) {
        return "plantilla";
    }

}