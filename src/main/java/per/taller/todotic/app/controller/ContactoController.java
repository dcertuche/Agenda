package per.taller.todotic.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import per.taller.todotic.app.model.entity.Contacto;
import per.taller.todotic.app.service.IContactoService;
import per.taller.todotic.app.web.dto.ContactoDTO;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

	@Autowired
	private IContactoService contactoService;

	@GetMapping
	public Page<Contacto> index(
			@PageableDefault(sort = "nombreCompleto", size = 5, direction = Direction.ASC) Pageable pageable) {
		return contactoService.findAllPage(pageable);
	}

	@GetMapping("/{id}")
	public Contacto ver(@PathVariable Integer id) {
		return contactoService.findById(id);
	}

	@PostMapping
	public Contacto crear(@RequestBody @Validated ContactoDTO contactoDto) {
		return contactoService.save(contactoDto);
	}

	@PutMapping("/{id}")
	public Contacto actualizar(@PathVariable Integer id, @RequestBody ContactoDTO contactoDto) {
		return contactoService.update(id, contactoDto);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		contactoService.delete(id);
	}

}
