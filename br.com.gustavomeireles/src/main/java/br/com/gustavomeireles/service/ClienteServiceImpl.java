package br.com.gustavomeireles.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gustavomeireles.dao.ClienteDao;
import br.com.gustavomeireles.domain.Cliente;

@Transactional (readOnly = true)
@Service
public class ClienteServiceImpl implements ClienteService{
 private ClienteDao dao;
	@Override
	public void salvar(Cliente cliente) {
		dao.save(cliente);
		
	}

	@Override @Transactional (readOnly = false)
	public void editar(Cliente cliente) {
		dao.update(cliente);
		
	}

	@Override @Transactional (readOnly = false)
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Cliente buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Cliente> buscarTodos() {
		
		return dao.findAll();
	}

}
