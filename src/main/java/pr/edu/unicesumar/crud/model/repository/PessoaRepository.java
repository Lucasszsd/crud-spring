package pr.edu.unicesumar.crud.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pr.edu.unicesumar.crud.Controller.PessoaController;
import pr.edu.unicesumar.crud.model.domain.Pessoa;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
