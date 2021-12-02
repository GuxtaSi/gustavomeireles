package br.com.gustavomeireles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.gustavomeireles.dao.ProfissaoDao;
import br.com.gustavomeireles.domain.Profissao;

@Service @Transactional(readOnly = false)
public class ProfissaoServiceImpl implements ProfissaoService{
	
	@Autowired
	private ProfissaoDao dao;
	@Override
	public void salvar(Profissao profissao) {
		dao.save(profissao);
		
	}

	@Override
	public void editar(Profissao profissao) {
		dao.update(profissao);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly = true)
	public Profissao buscarPorId(Long id) {
		dao.findById(id);
		return null;
	}

	@Override @Transactional(readOnly = true)
	public List<Profissao> buscarTodos() {
		dao.findAll();
		return null;
	}

	@Override
	public boolean profissaoTemCliente(Long id) {
	if(buscarPorId(id).getClientes().isEmpty()) {
		return false;
	}
		return true;
	}


}
