package pr.edu.unicesumar.crud.Controller;

import org.springframework.web.bind.annotation.*;
import pr.edu.unicesumar.crud.model.Pessoa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @GetMapping()
    public List<Pessoa> all(){
        return mock();

    }
    @GetMapping("/{id}")
    public Pessoa getId (@PathVariable Long id){
        return mock()
                .stream()
                .filter(pessoa -> pessoa.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @GetMapping("/pesquisa")
    public List<Pessoa> getByNome(@RequestParam("search") String pesquisa){
        return mock()
                .stream()
                .filter(pessoa -> pessoa.getNome().toLowerCase().contains(pesquisa.toLowerCase()))
                .collect(Collectors.toList());
    }
    private List<Pessoa> mock() {
        return Arrays.asList(new Pessoa(1L, "Lucas", "123"),
        new Pessoa(2L, "Paulo", "456"),
        new Pessoa(3L, "Pedro", "789"),
        new Pessoa(4L, "Joao", "111"),
        new Pessoa(5L, "Carlos", "222"),
        new Pessoa(6L, "Maria", "333")
        );
    }
}
