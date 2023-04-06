package med.voll.api.jpa;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.endereco.DadosEndereco;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    public Endereco(DadosEndereco endereco) {
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.complemento = endereco.complemento();
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.uf = endereco.uf();
    }
    private String logradouro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public void atualizar(DadosEndereco dados) {
        if (dados.cep() != null) {
            this.cep = dados.cep();            
        }
        if (dados.cidade() != null)  {
            this.cidade = dados.cidade();            
        }
        if (dados.complemento() != null) {            
            this.complemento = dados.complemento();        }
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();            
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();            
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();            
        }
    }
}
