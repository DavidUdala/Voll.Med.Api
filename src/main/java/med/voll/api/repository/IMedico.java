package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.jpa.Medico;

public interface IMedico extends JpaRepository<Medico, Long> {
}
