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

}
