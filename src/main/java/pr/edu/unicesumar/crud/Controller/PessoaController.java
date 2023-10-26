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
    public Pessoa getById (@PathVariable Long id){
        return pessoaRepository.findById(id).orElse(null);
    }
    @GetMapping("/pesquisa")
    public List<Pessoa> getByNome(@RequestParam("search") String pesquisa){
        return null;
    }
    @PutMapping("/{id}")
    public Pessoa edit(@PathVariable Long id ,@RequestBody Pessoa editPessoa){
      Pessoa pessoaDb = pessoaRepository.findById(id).orElse(new Pessoa());
      pessoaDb.setId(editPessoa.getId());
      pessoaDb.setNome(editPessoa.getNome());
      pessoaDb.setDocumento(editPessoa.getDocumento());


      return pessoaRepository.save(pessoaDb);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        pessoaRepository.deleteById(id);
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa nova){
       return pessoaRepository.save(nova);
    }
}
