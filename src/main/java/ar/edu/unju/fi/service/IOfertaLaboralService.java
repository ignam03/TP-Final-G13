package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.OfertaLaboral;

public interface IOfertaLaboralService {
    public void saveOfertaLaboral(OfertaLaboral ofertaLaboral);
    public List<OfertaLaboral> getOfertasLaborales();
    public void deleteOfertaLaboral(Long id);
    public OfertaLaboral modify(OfertaLaboral unaOfertaLaboral)throws Exception;
    public OfertaLaboral findOfertaLaboral(Long id)throws Exception;
}
