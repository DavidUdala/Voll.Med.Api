package med.voll.api.dto.medico;

import med.voll.api.dto.endereco.DadosEndereco;
import med.voll.api.enums.Especialidade;
public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
    
}
