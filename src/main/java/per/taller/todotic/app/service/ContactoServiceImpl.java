package per.taller.todotic.app.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import per.taller.todotic.app.model.entity.Contacto;
import per.taller.todotic.app.model.repository.ContactoRepository;
import per.taller.todotic.app.web.dto.ContactoDTO;

@Service
public class ContactoServiceImpl implements IContactoService {

	@Autowired
	private ContactoRepository contactoRepository;

	@Override
	public List<Contacto> findAll() {
		return contactoRepository.findAll();
	}

	@Override
	public Page<Contacto> findAllPage(Pageable pageable) {
		return contactoRepository.findAll(pageable);
	}

	@Override
	public Contacto findById(Integer id) {
		return contactoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public Contacto save(ContactoDTO contactoDto) {
		Contacto contacto = new ModelMapper().map(contactoDto, Contacto.class);
		return contactoRepository.save(contacto);
	}

	@Override
	public Contacto update(Integer id, ContactoDTO contactoDto) {
		Contacto contactoFromDb = findById(id);
		ModelMapper contactoMapper = new ModelMapper();
		contactoMapper.map(contactoDto, contactoFromDb);
		return contactoRepository.save(contactoFromDb);
	}

	@Override
	public void delete(Integer id) {
		Contacto contactoFromDb = findById(id);
		contactoRepository.delete(contactoFromDb);
	}
}
