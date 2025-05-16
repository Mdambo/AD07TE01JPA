package eus.birt.dam.controller;

import eus.birt.dam.repository.AutorRepository;
import eus.birt.dam.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping({"/", "/welcome"})
    public String welcome() {
        return "index";
    }

    @GetMapping("/autores-principal")
    public String getAutores(Model model) {
        model.addAttribute("autores", autorRepository.findAll());
        return "autores";
    }

    @GetMapping("/libros-principal")
    public String getLibros(Model model) {
        model.addAttribute("libros", libroRepository.findAll());
        return "libros";
    }
}