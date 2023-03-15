package med.voll.api.dto.medico;

import med.voll.api.enums.Especialidade;
import med.voll.api.jpa.Medico;

public record DadosListagemMedico(String nome, String email, String crm, Especialidade especialidade) {
    public DadosListagemMedico(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
