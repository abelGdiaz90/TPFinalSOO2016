package ar.edu.unju.fi.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.fi.unju.model.domian.Plan;
import ar.edu.unju.fi.modelo.dao.PlanDao;
@Repository
@Transactional
public class PlanDaoImpl extends GenericDaoImpl<Plan, Long> implements PlanDao {

	public List<Plan> listarPlan() {
		return listar();
	}

	public long guardarPlan(Plan p) {
		return guardar(p);
	}

	public void eliminarPlan(Plan p) {
		eliminar(p);
	}

	public void actualizarPlan(Plan p) {
		actualizar(p);
	}

	public Plan buscarPlan(long id) {
		return buscar(id);
	}


}
