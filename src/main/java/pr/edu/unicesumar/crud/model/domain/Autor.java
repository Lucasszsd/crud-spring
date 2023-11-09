package pr.edu.unicesumar.crud.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ES_AUTOR")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer anoNascimento;


}
