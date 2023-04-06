package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.medico.DadosAtualizaMedico;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.dto.medico.DadosListagemMedico;
import med.voll.api.jpa.Medico;
import med.voll.api.repository.IMedico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private IMedico repo;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repo.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 2, sort = {"crm"}) Pageable paginacao){
        return repo.findAllbyAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaMedico dados){

        var medico = repo.getReferenceById(dados.id());

        medico.atualizarDados(dados);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void apagar(@PathVariable Long id){
        var medico = repo.getReferenceById(id);
        medico.excluir();
    }
}
