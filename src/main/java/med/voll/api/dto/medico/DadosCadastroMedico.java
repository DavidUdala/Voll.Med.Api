package med.voll.api.dto.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import med.voll.api.dto.endereco.DadosEndereco;
import med.voll.api.enums.Especialidade;
public record DadosCadastroMedico(
    @NotBlank
    String nome, 
    @Email
    @NotBlank
    String email, 
    @NotBlank    
    String telefone,
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String crm, 
    @NotNull
    Especialidade especialidade, 
    @NotNull
    @Valid
    DadosEndereco endereco) {
    
}
