package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.jpa.Medico;
import med.voll.api.repository.IMedico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private IMedico repo;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        repo.save(new Medico(dados));
    }
}
