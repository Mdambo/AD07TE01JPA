package eus.birt.dam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
	// Método para buscar libros por título
    List<Libro> findByTituloContaining(String titulo);
}

