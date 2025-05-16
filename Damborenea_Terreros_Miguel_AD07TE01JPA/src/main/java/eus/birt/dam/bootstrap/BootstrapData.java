package eus.birt.dam.bootstrap;

import eus.birt.dam.domain.Autor;
import eus.birt.dam.domain.Libro;
import eus.birt.dam.repository.AutorRepository;
import eus.birt.dam.repository.LibroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AutorRepository autorRepository;
    private final LibroRepository libroRepository;

    public BootstrapData(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Cargando datos de prueba...");

        Autor autor1 = new Autor();
        autor1.setNombre("Gabriel García Márquez");
        autorRepository.save(autor1);

        Autor autor2 = new Autor();
        autor2.setNombre("J.K. Rowling");
        autorRepository.save(autor2);

        Libro libro1 = new Libro();
        libro1.setTitulo("Cien años de soledad");
        libro1.setAutor(autor1);
        libroRepository.save(libro1);

        Libro libro2 = new Libro();
        libro2.setTitulo("Harry Potter y la piedra filosofal");
        libro2.setAutor(autor2);
        libroRepository.save(libro2);
        
        Libro libro3 = new Libro();
        libro3.setTitulo("El amor en los tiempos del cólera");
        libro3.setAutor(autor1);
        libroRepository.save(libro3);

        Libro libro4 = new Libro();
        libro4.setTitulo("Harry Potter y la cámara secreta");
        libro4.setAutor(autor2);
        libroRepository.save(libro4);


        System.out.println("Datos de prueba cargados correctamente.");
    }
}
