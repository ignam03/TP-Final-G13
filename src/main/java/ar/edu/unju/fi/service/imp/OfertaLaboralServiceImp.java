package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.OfertaLaboral;
import ar.edu.unju.fi.repository.OfertaLaboralRepository;
import ar.edu.unju.fi.service.IOfertaLaboralService;

@Service("OfertaLaboralServiceImp")
public class OfertaLaboralServiceImp implements IOfertaLaboralService {

    @Autowired
    OfertaLaboralRepository ofertaLaboralDaoImp;

    @Override
    public void saveOfertaLaboral(OfertaLaboral ofertaLaboral) {
        ofertaLaboralDaoImp.save(ofertaLaboral);
    }

}
