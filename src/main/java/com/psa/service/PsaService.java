package com.psa.service;

import com.psa.Entity.Psa;
import com.psa.PsaDto.PsaDto;
import com.psa.exception.ResourceNotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.psa.repository.PsaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PsaService {
     private PsaRepository pr;

    public PsaService(PsaRepository pr) {
        this.pr = pr;
    }

    public Psa showById(Long userid) {
        return pr.findById(userid).orElseThrow(() -> new ResourceNotFound("no student with such id"));

    }

    public PsaDto addPsa(PsaDto psa) {
     Psa p=dtoToEntity(psa);
     Psa pp=pr.save(p);
     PsaDto pd=entityToDto(pp);
     return pd;
    }
    public Psa dtoToEntity(PsaDto pp) {
        Psa pd=new Psa();
        pd.setId(pp.getId());
        pd.setName(pp.getName());
        pd.setMobile(pp.getMobile());
        pd.setEmail(pp.getEmail());
        pd.setCourse(pp.getCourse());
        return pd;
    }
    public PsaDto entityToDto(Psa psa) {
        PsaDto p=new PsaDto();
        p.setName(psa.getName());
        p.setMobile(psa.getMobile());
        p.setEmail(psa.getEmail());
        p.setCourse(psa.getCourse());
        return p;
    }
    public List<PsaDto> showAll(int pageSize, int pageNo) {

     Pageable pageable= (Pageable) PageRequest.of(pageSize,pageNo);
        Page<Psa> all= (Page<Psa>)pr.findAll();
       List<Psa> p= all.getContent();
         List<PsaDto> pd=p.stream().map(pp->entityToDto(pp)).collect(Collectors.toList());
        return pd;
    }

    public PsaDto updatePsa(PsaDto dto, long userid) {
        Optional<Psa> o=pr.findById(userid);
        Psa p=o.get();
        p.setName(dto.getName());
        p.setMobile(dto.getMobile());
        p.setEmail(dto.getEmail());
        p.setCourse(dto.getCourse());
        Psa pp=pr.save(p);
        PsaDto pd=entityToDto(pp);
        return pd;
    }

    public void deletePsa(Long id) {
        pr.deleteById(id);
    }
}
