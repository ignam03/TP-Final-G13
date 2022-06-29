package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.repository.CurriculumRepository;
import ar.edu.unju.fi.service.ICurriculumService;

@Service("CurriculumServiceImp")
public class CurriculumServiceImp implements ICurriculumService{

    @Autowired
    CurriculumRepository curriculumDaoImp;

    @Override
    public void saveCurriculum(Curriculum curriculum) {
        curriculumDaoImp.save(curriculum);
    }
    
}
