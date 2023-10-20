package pr.edu.unicesumar.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pr.edu.unicesumar.crud.model.domain.Pessoa;
import pr.edu.unicesumar.crud.model.repository.PessoaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping()
    public List<Pessoa> all(){
        return pessoaRepository.findAll();

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
    @PutMapping
    public void create(@RequestBody Pessoa novaPessoa){
       Pessoa pessoa = new Pessoa(1L,novaPessoa.getNome(),novaPessoa.getDocumento()
        );
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id ,@RequestBody Pessoa editPessoa){
      Pessoa pessoa =   new Pessoa(id, editPessoa.getNome(), editPessoa.getDocumento());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        System.out.println("DELETADO");
    }

}
