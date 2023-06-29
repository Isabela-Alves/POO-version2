package org.exemplo.persistencia.database.facade;

import java.util.List;

import org.exemplo.persistencia.database.dao.IEntityDAO;
import org.exemplo.persistencia.database.dao.PacienteDAO;//nao esquecer de mudar pra ClienteDao
import org.exemplo.persistencia.database.db.ConexaoBancoHibernate;
import org.exemplo.persistencia.database.db.ConexaoBancoMySQL;//nao sei se esse continua aqui mesmo
import org.exemplo.persistencia.database.model.Cliente;
import org.exemplo.persistencia.database.model.IConta;

public class ClienteFacade {
	//mudar tudo quando eu ja tiver o ClienteDao

	private IEntityDAO<Paciente> pacienteDao; //mudar quando eu criar ClienteDao
	private static ClienteFacade instance;

	private ClienteFacade() {
		pacienteDao = new PacienteDAO(new ConexaoBancoHibernate());
	}

	public static ClienteFacade getInstance() {

		if (instance != null)
			return instance;
		else {
			instance = new ClienteFacade();
			return instance;
		}
	}

	public void save(Integer id, String nome, Float altura, Float peso) {
		pacienteDao.save(new Paciente(id, nome, altura, peso));
	}

	public void delete(Integer id) {
		pacienteDao.delete(new Paciente(id));
	}

	public void update(Integer id, String nome, Float altura, Float peso, List<Cliente> exames) {
		pacienteDao.update(new Paciente(id, nome, altura, peso));

	}

	public Paciente findById(Integer id) {
		return pacienteDao.findById(id);
	}

	public List<Paciente> findAll() {
		return pacienteDao.findAll();
	}
}
