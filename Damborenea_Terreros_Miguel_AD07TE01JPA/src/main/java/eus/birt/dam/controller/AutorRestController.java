package eus.birt.dam.controller;

import eus.birt.dam.domain.Autor;
import eus.birt.dam.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/autores")
public class AutorRestController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable("id") Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Autor createAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @PutMapping("/{id}")
    @ResponseStatus (HttpStatus.CREATED)
    public Autor updateAutor(@RequestBody Autor autor, @PathVariable("id") Long id) {
        Autor tempAutor = autorRepository.findById(id).orElse(null);
        
        tempAutor.setNombre(autor.getNombre());
        tempAutor.setLibros(autor.getLibros());
        
        return autorRepository.save(tempAutor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deleteAutor(@PathVariable("id") Long id) {
        autorRepository.deleteById(id);
    }
}