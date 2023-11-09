package pr.edu.unicesumar.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pr.edu.unicesumar.crud.model.repository.AutorRepository;

@Controller
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;
    @GetMapping
    public ModelAndView all(){

       ModelAndView view = new ModelAndView("lista-autor");
       view.addObject("autores",autorRepository.findAll());
       return view;

    }

    @GetMapping("/form")
    public ModelAndView create(){
        ModelAndView view = new ModelAndView("form-autor");
        return view;
    }

}
