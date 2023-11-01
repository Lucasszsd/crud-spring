package pr.edu.unicesumar.crud.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pr.edu.unicesumar.crud.Controller.PessoaController;
import pr.edu.unicesumar.crud.model.domain.Pessoa;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByUserName(String userName);

    @Query(nativeQuery = true, value = "select * from ES_PESSOA p where p.nome = :name")
    List<Pessoa> buscaPorNome(@Param("name") String nome);
    @Query(value = "select p from Pessoa p " + " where p.nome = :nome")
    List<Pessoa> pesquisaPorNomeHql(@Param("nome") String nome);

    List<Pessoa> findByNomeEquals(String nome);


}
