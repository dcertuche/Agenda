package per.taller.todotic.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import per.taller.todotic.app.model.entity.Cliente;
import per.taller.todotic.app.service.IClienteService;

@RestController
@RequestMapping("/api/clients")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping()
	public Page<Cliente> getAllClientes(Pageable pageable) {
		System.out.println("getPageSize: " + pageable.getPageSize() + " getPageNumber: " + pageable.getPageNumber()
				+ " getSort(): " + pageable.getSort() + " numSap: ");
		return clienteService.findAllPage(pageable);
	}

}
