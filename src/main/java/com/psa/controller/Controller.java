package com.psa.controller;

import com.psa.Entity.Psa;
import com.psa.PsaDto.PsaDto;
import com.psa.service.PsaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/psa")
public class Controller {
    private PsaService ps;

    public Controller(PsaService ps) {
        this.ps = ps;
    }
    @PostMapping("/save")
    public ResponseEntity<?> addPsa(@Valid @RequestBody PsaDto dto, BindingResult br)
    {
        if(br.hasErrors()){
            return new ResponseEntity<>(br.getFieldError().getDefaultMessage(),HttpStatus.OK);
        }
        PsaDto p=ps.addPsa(dto);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    @GetMapping("/{userid}")
    public ResponseEntity<Psa> showById(@PathVariable Long userid) {
        Psa p=ps.showById(userid);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PsaDto>> showAll(@RequestParam(name="pageSize",defaultValue="5",required=false)int pageSize,
                                                @RequestParam(name="pageNo",defaultValue = "0",required=false)int pageNo) {

        List<PsaDto> p=ps.showAll(pageSize, pageNo);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updatePsa(@Valid @RequestBody PsaDto dto, BindingResult br, @RequestParam long userid)
    {
       if(br.hasErrors()){
            return new ResponseEntity<>(br.getFieldError().getDefaultMessage(),HttpStatus.OK);
        }
        PsaDto p=ps.updatePsa(dto,userid);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePsa(@PathVariable Long id)
    {
        ps.deletePsa(id);
        return new ResponseEntity<>("Psa Deleted",HttpStatus.OK);
    }

}

