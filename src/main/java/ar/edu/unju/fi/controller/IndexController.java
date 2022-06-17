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

    @GetMapping({"/loginCiu"})
    public String getLoginCiudadanoPage(Model model) {
        return "loginCiudadano";
    }
    
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "loginForm";
    }

    @GetMapping("/loginEmp")
    public String getLoginEmpleadorPage(Model model) {
        return "loginEmpleador";
    }

    @GetMapping("/registroCiu")
    public String getCiudadanoPage(Model model) {
        return "ciudadanoForm";
    }
    
    @GetMapping("/registroEmp")
    public String getEmpleadorPage(Model model) {
        return "empleadorForm";
    }
    
    @GetMapping("/ofertaLab")
    public String getListaEmpleoPage(Model model) {
        return "ofertaLaboral";
    }

    @GetMapping("/empresas")
    public String get404Page(Model model) {
        return "404";
    }

    @GetMapping("/sobreNosotros")
    public String getSobreNosotrosPage(Model model) {
        return "404";
    }

    
}