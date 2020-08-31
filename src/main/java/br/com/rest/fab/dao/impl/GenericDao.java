package br.com.rest.fab.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;



import br.com.rest.fab.model.Patente;
import br.com.rest.fab.model.Patente_;
import br.com.rest.fab.model.PostoGraduacao;
import br.com.rest.fab.model.PostoGraduacao_;
import br.com.rest.fab.model.Soldo;
import br.com.rest.fab.model.Soldo_;
import br.com.rest.fab.util.EntityBase;

@Stateless
public class GenericDao <T extends EntityBase> implements br.com.rest.fab.dao.IGenericDao<T> {

	@PersistenceContext(name = "PERSISTENCE_UNIT_FAB")
	private EntityManager em;

	@Override
	public List<PostoGraduacao> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PostoGraduacao> cq = cb.createQuery(PostoGraduacao.class);
		Root<PostoGraduacao> postoGraduacao = cq.from(PostoGraduacao.class);
		
		cq.select(postoGraduacao);
		TypedQuery<PostoGraduacao> query = em.createQuery(cq);
		
		return query.getResultList();
	}
	
	@Override
	public PostoGraduacao findById(Long param) {
		return em.find(PostoGraduacao.class, param);
	}

	@Override
	public void save(PostoGraduacao postoGraduacao) {
		em.persist(postoGraduacao);
    }
	
	@Override
	public PostoGraduacao update(PostoGraduacao postoGraduacao) {
		return em.merge(postoGraduacao);
	}
	
	@Override
	public void delete(Long param) {
	    PostoGraduacao postoGraduacao = em.find(PostoGraduacao.class, param);  	
		em.remove(postoGraduacao);
	}
	
	
	@Override
	public PostoGraduacao findByRemuneracao(String remuneracao) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PostoGraduacao> cq = cb.createQuery(PostoGraduacao.class);
		Root<PostoGraduacao> postoGraduacao = cq.from(PostoGraduacao.class);
		Join<PostoGraduacao, Soldo> join = postoGraduacao.join(PostoGraduacao_.fkSoldo); 
		
		cq.select(postoGraduacao)
		  .where(cb.equal(join.get(Soldo_.remuneracao),remuneracao));
		
		TypedQuery<PostoGraduacao> query = em.createQuery(cq);
		
		return query.getSingleResult();	
	}

	@Override
	public PostoGraduacao findByPostoGraduacao(String dsPostoGraduacao) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PostoGraduacao> cq = cb.createQuery(PostoGraduacao.class);
		Root<PostoGraduacao> root = cq.from(PostoGraduacao.class);
		
        cq.select(root)
		  .where(cb.equal(root.get(PostoGraduacao_.dsPostoGraduacao), dsPostoGraduacao));
		
        TypedQuery<PostoGraduacao> query = em.createQuery(cq);
		
        return query.getSingleResult();
	}

	
	
	@Override
	public List<PostoGraduacao> findByPatente(String patentes) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PostoGraduacao> cq = cb.createQuery(PostoGraduacao.class);
		Root<PostoGraduacao> postoGraduacao = cq.from(PostoGraduacao.class);
		
		Path<Long> identificador = postoGraduacao.get(PostoGraduacao_.identificador); 		
		Path<String> posto = postoGraduacao.get(PostoGraduacao_.dsPostoGraduacao);
		Path<String> sigla = postoGraduacao.get(PostoGraduacao_.sgPostoGraduacao); 		
		Path<Patente> patente = postoGraduacao.get(PostoGraduacao_.patente);
		Path<Soldo> soldo = postoGraduacao.get(PostoGraduacao_.fkSoldo);
		
		Join<PostoGraduacao , Patente> join = postoGraduacao.join(PostoGraduacao_.patente);
		
		cq.multiselect(identificador,posto,sigla,patente,soldo)
		.where(cb.like(join.get(Patente_.patente), "%"+patentes+"%"));
		
		// Nome Exato com EQUAL cq.where(cb.like(pet.get(Pet_.name)), "*do");
		// .where(cb.equal(join.get(Patente_.patente), patentes));		  
		
		TypedQuery<PostoGraduacao> query = em.createQuery(cq);
		
		return query.getResultList();

	}
	
    public String findBySigla(String sgPostoGraduacao) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<PostoGraduacao> root = cq.from(PostoGraduacao.class);
		//ParameterExpression<String> parameter = cb.parameter(String.class);

		//cq.select(root.<String>get("sgPostoGraduacao")).where(cb.equal(root.get(PostoGraduacao_.dsPostoGraduacao),sgPostoGraduacao));
		cq.select(root.<String>get(PostoGraduacao_.dsPostoGraduacao)).where(cb.equal(root.get(PostoGraduacao_.sgPostoGraduacao),sgPostoGraduacao));
		TypedQuery<String> typedQuery = em.createQuery(cq);
		//typedQuery.setParameter(parameter, id);
		String descricao = (String)typedQuery.getSingleResult();
		return descricao;
	}

}