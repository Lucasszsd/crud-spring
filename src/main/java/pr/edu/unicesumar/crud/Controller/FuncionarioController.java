package pr.edu.unicesumar.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pr.edu.unicesumar.crud.model.domain.Funcionario;
import pr.edu.unicesumar.crud.model.repository.FuncionarioRepository;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcRepository;

    @GetMapping()
    public ResponseEntity<List<Funcionario>> all(){
        return ResponseEntity.ok(funcRepository.findAll());
    }
}
