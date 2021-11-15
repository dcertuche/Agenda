package per.taller.todotic.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import per.taller.todotic.app.model.entity.Cliente;

public interface IClienteService {

	public Page<Cliente> findAllPage(Pageable pageable);

}
