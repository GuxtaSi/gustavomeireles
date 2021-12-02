package br.com.gustavomeireles.dao;

import org.springframework.stereotype.Repository;

import br.com.gustavomeireles.domain.Cliente;



@Repository
public class ClienteDaoImpl extends AbstractDao < Cliente , Long> implements ClienteDao {

}
