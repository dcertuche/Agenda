package per.taller.todotic.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import per.taller.todotic.app.model.entity.Contacto;
import per.taller.todotic.app.web.dto.ContactoDTO;

public interface IContactoService {

	/*
	 * Listar todos los contactos
	 */

	public List<Contacto> findAll();

	/*
	 * listar page de contactos
	 */
	public Page<Contacto> findAllPage(Pageable pageable);

	/*
	 * buscar por Id contacto
	 */

	public Contacto findById(Integer id);

	/*
	 * crea contacto
	 */
	public Contacto save(ContactoDTO contactoDto);

	/*
	 * edita contacto
	 */
	public Contacto update(Integer id, ContactoDTO contactoDto);

	/*
	 * eliminar contacto
	 */
	public void delete(Integer id);

}
