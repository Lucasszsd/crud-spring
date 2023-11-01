package pr.edu.unicesumar.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pr.edu.unicesumar.crud.model.domain.Pessoa;
import pr.edu.unicesumar.crud.model.repository.PessoaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping()
    public ResponseEntity<List<Pessoa>> all(){
        return ResponseEntity.ok(pessoaRepository.findAll());

    }
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById (@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            return ResponseEntity.ok(pessoa.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> edit(@PathVariable Long id ,@RequestBody Pessoa editPessoa){
      Pessoa pessoaDb = pessoaRepository.findById(id).orElse(new Pessoa());
      pessoaDb.setId(editPessoa.getId());
      pessoaDb.setNome(editPessoa.getNome());
      pessoaDb.setDocumento(editPessoa.getDocumento());
      pessoaDb.setUserName(editPessoa.getUserName());
      return ResponseEntity.ok(pessoaRepository.save(pessoaDb));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        pessoaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa nova){
       return pessoaRepository.save(nova);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Pessoa> getByUsername(@PathVariable String username) {
       return ResponseEntity.ok(pessoaRepository.findByUserName(username));
    }
    @GetMapping("/nativo")
    public ResponseEntity<List<Pessoa>> getNativo(@RequestParam("nome") String nome){
        return ResponseEntity.ok(pessoaRepository.buscaPorNome(nome));
    }
    @GetMapping("/hql")
    public ResponseEntity<List<Pessoa>> pesquisaPorNomeHql(@RequestParam("nome") String nome){
        return ResponseEntity.ok(pessoaRepository.pesquisaPorNomeHql(nome));
    }
    @GetMapping("spring-data")
    public ResponseEntity<List<Pessoa>>buscaPorNome(@RequestParam("nome") String nome){
        return ResponseEntity.ok(pessoaRepository.findByNomeEquals(nome));
    }
}
