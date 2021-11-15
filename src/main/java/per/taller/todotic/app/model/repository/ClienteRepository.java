package per.taller.todotic.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import per.taller.todotic.app.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
