package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Curriculum;

public interface ICurriculumService {
    public void saveCurriculum(Curriculum curriculum);

    public Curriculum findCurriculum(Long id) throws Exception;

    public Curriculum modify(Curriculum curriculum)throws Exception;

    public List<Curriculum> getCurrriculums();

    public List<Curriculum> getOCurriculm(String filtro);

    public List<Curriculum> getCurriculumPronvicas(String provincia);

}
