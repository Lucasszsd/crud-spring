package pr.edu.unicesumar.crud.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pr.edu.unicesumar.crud.model.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
