package com.do_class.devweek.Controller;

import com.do_class.devweek.Entity.Regiao;
import com.do_class.devweek.Repository.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerRegiao {
    private final RegiaoRepo repository;

    public ControllerRegiao(RegiaoRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/regiao")
    public List<Regiao> getRegiao() {
        return repository.findAll();
    }

    @GetMapping("/regiao/{id")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id) {
        Optional regiaoEscolhidaOptional = repository.findById(id);

        if (regiaoEscolhidaOptional.isPresent()) {
            Object regiaoEscolhida = regiaoEscolhidaOptional.get();
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/regiao/novo")
    public  void  putRegiao(Regiao newRegiao) {
        repository.save(newRegiao);
    }

    @DeleteMapping("/regiao/delete/{id}")
    public void deleteRegiao(@PathVariable Long id) {
        repository.deleteById(id);

    }
}
