package eus.birt.dam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eus.birt.dam.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	@Query(value = "SELECT * FROM autor a WHERE a.nombre LIKE %:keyword%", nativeQuery = true)
    List<Autor> findByKeyword(@Param("keyword") String keyword);
}
