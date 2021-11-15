package per.taller.todotic.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import per.taller.todotic.app.model.entity.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

}
