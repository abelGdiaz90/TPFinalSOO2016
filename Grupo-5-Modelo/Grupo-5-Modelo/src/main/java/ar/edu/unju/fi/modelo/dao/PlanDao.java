package ar.edu.unju.fi.modelo.dao;

import java.util.List;


import ar.edu.fi.unju.model.domian.Plan;

public interface PlanDao extends GenericDao<Plan, Long>{
	public  List<Plan> listarPlan();
	public long guardarPlan(Plan p);
	public void eliminarPlan(Plan p);
	public void actualizarPlan(Plan p);
	public Plan buscarPlan(long id );
}
