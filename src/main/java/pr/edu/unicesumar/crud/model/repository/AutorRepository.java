package pr.edu.unicesumar.crud.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pr.edu.unicesumar.crud.model.domain.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
