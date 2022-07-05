package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.service.ICurriculumService;

@Controller
@RequestMapping("/empleos")
public class IndexController {

    @Autowired
    @Qualifier("CurriculumServiceImp")
    private ICurriculumService curriculumSvc;

    @GetMapping("/inicio")
    public String getInicioPage(Model model) {
        return "index";
    }

    @GetMapping({ "/loginCiu", "/login?error=true" })
    public String getLoginCiudadanoPage(Model model) {
        return "loginCiudadano";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "loginCiudadano";
    }

    @GetMapping({ "/loginEmp", "/login?error=true" })
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
        return "nosotros";
    }

    @GetMapping("/perfilesLaborales")
    public String getPerfilesLaboralesPage(Model model, @Param("filtro") String filtro,
            @Param("provincia") String provincia) {
        List<Curriculum> listaCurriculums = curriculumSvc.getOCurriculm(filtro);
        // List<Curriculum> listaCurriculumsProv =
        // curriculumSvc.getCurriculumPronvicas(provincia);
        model.addAttribute("perfiles", listaCurriculums);
        // model.addAttribute("perfiles",listaCurriculumsProvs);
        for (Curriculum curriculum : listaCurriculums) {

        }
        return "busquedaPerfiles";
    }

    // Tabla y muestra de Cursos

    public List<Curso> getCursos() {
        List<Curso> listaCurso = new ArrayList<>();
        listaCurso.add(new Curso(1, "Curso de Programacion",
                "Deberías Aprovechar la Oportunidad de Aprender con la Modalidad Online en Vivo de Coder. Suma conocimientos en Diseño, Marketing Digital, Community Manager y Programación. Posibilidad de Becas. Proyectos reales. Tu Carrera a Otro Nivel. La Educación del Futuro.",
                "Grupal", ""));
        listaCurso.add(new Curso(2, "Curso de Matematica",
                "Aprovecha este mes y suscríbete para aprender por todo 1 año. Súbete a +1000 cursos, 21 escuelas, 365 días, 24 horas. Invierte en tu educación. Aprende a tu ritmo. Incrementa tu salario. Estudia Cuando Quieras. De Principiante a Experto. Fortalece Habilidades.",
                "Individual", ""));
        listaCurso.add(new Curso(3, "Curso de Ingles Tecnico",
                "Prueba El Método Más Innovador De Aprendizaje De Inglés Online! Profesores Americanos. Clases Privadas. 100% Online. Clases en Vivo 24x7. Cursos: Vocabulario de inglés, Expresiones Idiomáticas, inglés para el Trabajo, Gramática De Inglés.",
                "Individual", ""));
        listaCurso.add(new Curso(4, "Curso de Estadistica",
                "Encuentra Resultados De Calidad Al Instante. Consigue Estadistica Curso. Consigue Estadistica Curso. Resultados De Calidad Al Instante Con iZito. La Mejor Información Aquí. Más Información. Resultados Relacionados. Resultados Cualitativos.",
                "Grupal", ""));
        listaCurso.add(new Curso(5, "Curso de Frances",
                "Ingresá A platzi.com Y Conocé Nuestros Cursos Para Aprender Inglés junto a profesionales. Desarrollate En El Área De Inglés Y Maximiza Tus Saberes Con Los Cursos Más Completos. Planes Disponibles. Cursos Disponibles 24/7. Test De Nivel.",
                "Individual", ""));
        listaCurso.add(new Curso(6, "Curso de Diseño Grafico",
                "Comunicá visualmente a través de diseños publicitarios, ilustraciones y branding. ¡Formáte en Diseño UX y creá soluciones innovadoras que perduren en el tiempo! Personas Y Empresas. Varios Medios De Pago. Planes Disponibles.",
                "Individual", ""));
        listaCurso.add(new Curso(7, "Curso de Electronica",
                "Comunicá visualmente a través de diseños publicitarios, ilustraciones y branding. ¡Formáte en Diseño UX y creá soluciones innovadoras que perduren en el tiempo! Personas Y Empresas. Varios Medios De Pago. Planes Disponibles.Metodología y materiales de estudio de vanguardia. Más de 35 años te Trayectoria Educativa. Inscribite hoy y comenzá una carrera de gran Presente y Futuro. Toma hoy una gran decisión. Atención personalizada. 33 Años de Trayectoria.",
                "Grupal", ""));
        listaCurso.add(new Curso(8, "Curso de Computacion",
                "Aprende a escribir tu CV, negociar tu salario y otras habilidades que impulsen tu carrera. Aprende habilidades digitales prácticas con lecciones gratuitas en línea. Áreas De Trabajo: Alumnos, Profesionales, Dirigido A Profesores.",
                "Grupal", ""));
        return listaCurso;
    }

    @GetMapping("/cursos")
    public String visualizarPaginaCursos(Model model) {
        model.addAttribute("curso", this.getCursos());
        return "curso";
    }

    @GetMapping("/verC")
    public ModelAndView visualizarCursos(@RequestParam(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("vermasC");

        Optional<Curso> p = this.getCursos().stream().filter(curso -> id == curso.getId()).findFirst();

        modelAndView.addObject("curso", p.get());

        return modelAndView;
    }
    
    @GetMapping("/cursoI")
    public ModelAndView visualizarCursosI(@RequestParam(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("feli");

        Optional<Curso> p = this.getCursos().stream().filter(curso -> id == curso.getId()).findFirst();

        modelAndView.addObject("feli", p.get());

        return modelAndView;
    }

}