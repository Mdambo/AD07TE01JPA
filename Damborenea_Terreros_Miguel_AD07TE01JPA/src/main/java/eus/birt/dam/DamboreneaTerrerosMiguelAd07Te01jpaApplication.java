package eus.birt.dam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "eus.birt.dam")
@EnableJpaRepositories(basePackages = "eus.birt.dam.repository")
@EntityScan(basePackages = "eus.birt.dam.domain")
public class DamboreneaTerrerosMiguelAd07Te01jpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DamboreneaTerrerosMiguelAd07Te01jpaApplication.class, args);
	}

}
