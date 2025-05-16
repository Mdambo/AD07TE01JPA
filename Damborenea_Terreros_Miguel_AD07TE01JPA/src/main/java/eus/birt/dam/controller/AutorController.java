package eus.birt.dam.controller;

import eus.birt.dam.domain.Autor;
import eus.birt.dam.repository.AutorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping({"", "/search"})
    public String listarAutores(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
        List<Autor> autores;

        if (keyword != null && !keyword.trim().isEmpty()) {
            autores = autorRepository.findByKeyword(keyword);
            model.addAttribute("keyword", keyword);
        } else {
            autores = autorRepository.findAll();
        }

        model.addAttribute("autores", autores);
        return "autores"; // Vista de autores
    }
    
    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("autor", new Autor());
        return "autorForm";
    }

    @PostMapping("/new/submit")
    public String submitCreationForm(@ModelAttribute Autor autor) {
        autorRepository.save(autor);
        return "redirect:/autores";
    }

    @GetMapping("/edit/{id}")
    public String initEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("autor", autorRepository.findById(id).orElse(null));
        return "autorForm";
    }

    @GetMapping("/delete/{id}")
    public String initDelete(@PathVariable("id") Long id) {
        autorRepository.deleteById(id);
        return "redirect:/autores";
    }
}


