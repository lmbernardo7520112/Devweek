package com.do_class.devweek.Controller;

import com.do_class.devweek.Entity.Regiao;
import com.do_class.devweek.Repository.RegiaoRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public Optional getRegiaoById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/regiao/novo")
    public  void  putRegiao(Regiao newRegiao) {
        repository.save(newRegiao);
    }
}
