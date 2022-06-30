package ar.edu.unju.fi.service.imp;

import java.util.List;

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

    @Override
    public List<OfertaLaboral> getOfertasLaborales() {
        // TODO Auto-generated method stub
        return ofertaLaboralDaoImp.findAll();
    }
    
    @Override
    public void deleteOfertaLaboral(Long id) {
        ofertaLaboralDaoImp.deleteById(id);
    }

    @Override
    public OfertaLaboral modify(OfertaLaboral unaOfertaLaboral) throws Exception {
        // TODO Auto-generated method stub
        OfertaLaboral ofertaLaboralGuardar = findOfertaLaboral(unaOfertaLaboral.getOferNumber());
        mapearOfertaLaboral(ofertaLaboralGuardar,unaOfertaLaboral);
        return ofertaLaboralDaoImp.save(ofertaLaboralGuardar);
    }

    public void mapearOfertaLaboral(OfertaLaboral desde, OfertaLaboral hasta) {
        desde.setCantVacantes(hasta.getCantVacantes());
        desde.setPuesto(hasta.getPuesto());
        desde.setResumen(hasta.getResumen());
        desde.setDisponibilidad(hasta.getDisponibilidad());
        desde.setTareas(hasta.getTareas());
        desde.setDatos(hasta.getDatos());
        desde.setJornada(hasta.getJornada());
        desde.setRequisitos(hasta.getRequisitos());
        desde.setSalario(hasta.getSalario());
        desde.setBeneficios(hasta.getBeneficios());
        desde.setDisponibilidad(hasta.getDisponibilidad());
        desde.setProvincia(hasta.getProvincia());
        desde.setFechaPub(hasta.getFechaPub());
    }

    @Override
    public OfertaLaboral findOfertaLaboral(Long id) throws Exception {
        // TODO Auto-generated method stub
        return ofertaLaboralDaoImp.findById(id).orElseThrow(() -> new Exception("El Usuario no Existe"));
    }


}
