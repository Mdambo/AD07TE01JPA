package eus.birt.dam.controller;

import eus.birt.dam.repository.LibroRepository;
import eus.birt.dam.domain.Autor;
import eus.birt.dam.domain.Libro;
import eus.birt.dam.repository.AutorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;
    
    @GetMapping
    public String listarLibros(@RequestParam(name = "search", required = false, defaultValue = "") String search, Model model) {
        List<Libro> libros;
        if (search.isEmpty()) {
            libros = libroRepository.findAll();
        } else {
            libros = libroRepository.findByTituloContaining(search);
        }
        model.addAttribute("libros", libros);
        model.addAttribute("search", search);
        return "libros"; // Devuelve la vista libros.html
    }
    
    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("autores", autorRepository.findAll());
        return "libroForm";
    }

    @PostMapping("/new/submit")
    public String submitCreationForm(@ModelAttribute Libro libro) {
        libroRepository.save(libro);  // Guardamos el libro sin necesidad de capturar autorId explícitamente
        return "redirect:/libros";
    }

    @GetMapping("/edit/{id}")
    public String initEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("libro", libroRepository.findById(id).orElse(null));
        model.addAttribute("autores", autorRepository.findAll());
        return "libroForm";
    }

    @GetMapping("/delete/{id}")
    public String initDelete(@PathVariable("id") Long id) {
        libroRepository.deleteById(id);
        return "redirect:/libros";
    }
}