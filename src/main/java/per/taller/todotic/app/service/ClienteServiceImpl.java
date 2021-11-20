package per.taller.todotic.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import per.taller.todotic.app.model.entity.Cliente;
import per.taller.todotic.app.model.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Page<Cliente> findAllPage(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

}
