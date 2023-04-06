package med.voll.api.jpa;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.medico.DadosAtualizaMedico;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.enums.Especialidade;

@Table(name = "medicos")
@Entity(name = "Medico")

@Getter
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(of = "id")
public class Medico {
    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.crm = dados.crm();
        this.email = dados.email();
        this.endereco = new Endereco(dados.endereco());
        this.especialidade = dados.especialidade();
        this.telefone = dados.telefone();
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public void atualizarDados(@Valid DadosAtualizaMedico dados) {
        if(dados.nome() != null){    
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.atualizar(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
