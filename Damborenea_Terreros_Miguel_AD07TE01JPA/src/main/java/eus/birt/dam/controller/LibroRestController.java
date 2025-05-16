package eus.birt.dam.controller;

import eus.birt.dam.domain.Autor;
import eus.birt.dam.domain.Libro;
import eus.birt.dam.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libros")
public class LibroRestController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable("id") Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Libro createLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @PutMapping("/{id}")
    @ResponseStatus (HttpStatus.CREATED)
    public Libro updateLibro(@RequestBody Libro libro, @PathVariable("id") Long id) {
        Libro templibro = libroRepository.findById(id).orElse(null);
        
        templibro.setTitulo(libro.getTitulo());
        templibro.setAutor(libro.getAutor());
        
        return libroRepository.save(templibro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deleteLibro(@PathVariable("id") Long id) {
        libroRepository.deleteById(id);
    }
}