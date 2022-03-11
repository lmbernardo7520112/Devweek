package com.do_class.devweek.Controller;

import com.do_class.devweek.Entity.FaixaEtaria;
import com.do_class.devweek.Repository.FaixaEtariaRepo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ControllerFaixaEtaria {
    private final FaixaEtariaRepo frepository;


    public ControllerFaixaEtaria(FaixaEtariaRepo frepository) {
        this.frepository = frepository;
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa){
        return frepository.save(newFaixa);
    }

    @DeleteMapping("/faixaetaria/remover/{id}")
    public void deleteFaixaEtaria(@PathVariable long id){
        frepository.deleteById(id);
    }
}
