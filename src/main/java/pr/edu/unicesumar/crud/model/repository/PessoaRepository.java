package pr.edu.unicesumar.crud.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pr.edu.unicesumar.crud.Controller.PessoaController;
import pr.edu.unicesumar.crud.model.domain.Pessoa;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByUserName(String userName);
    @Query(" select p from Pessoa p " + " where p.nome = :name ")
    Pessoa buscaPorNome(@Param("name") String nome);


}
