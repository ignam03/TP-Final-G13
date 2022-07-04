package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.repository.CurriculumRepository;
import ar.edu.unju.fi.service.ICurriculumService;

@Service("CurriculumServiceImp")
public class CurriculumServiceImp implements ICurriculumService {

    @Autowired
    CurriculumRepository curriculumDaoImp;

    @Override
    public void saveCurriculum(Curriculum curriculum) {
        curriculumDaoImp.save(curriculum);
    }

    @Override
    public Curriculum findCurriculum(Long id) throws Exception {
        // TODO Auto-generated method stub
        return curriculumDaoImp.findById(id).orElseThrow(() -> new Exception("El Usuario no Existe"));
    }

    @Override
    public List<Curriculum> getCurrriculums() {
        // TODO Auto-generated method stub
        return curriculumDaoImp.findAll();
    }

    @Override
    public List<Curriculum> getOCurriculm(String filtro) {
        // TODO Auto-generated method stub
        if (filtro != null) {
            return curriculumDaoImp.filter(filtro);
        }
        return curriculumDaoImp.findAll();
    }

    @Override
    public Curriculum modify(Curriculum curriculum) throws Exception {
        Curriculum curriculumGuardar = findCurriculum(curriculum.getCurriculumNumber());
        mapearCurriculum(curriculumGuardar, curriculum);
        return curriculumDaoImp.save(curriculumGuardar);
    }

    public void mapearCurriculum(Curriculum desde, Curriculum hasta) {
        desde.setNombre(hasta.getNombre());
        desde.setApellido(hasta.getApellido());
        desde.setCiudadano(hasta.getCiudadano());
        desde.setConocimientos(hasta.getConocimientos());
        desde.setDatoAdicionales(hasta.getDatoAdicionales());
        desde.setIdioma(hasta.getIdioma());
        desde.setDireccion(hasta.getDireccion());
        desde.setPais(hasta.getPais());
        desde.setInfoComplementaria(hasta.getInfoComplementaria());
    }

    @Override
    public List<Curriculum> getCurriculumPronvicas(String provincia) {
        if (provincia != null) {
            return curriculumDaoImp.filterProvincia(provincia);
        }
        return curriculumDaoImp.findAll();
    }

}
