package br.com.rest.fab.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.rest.fab.model.PostoGraduacao;

@Local
public interface IGenericDao<T> {

	public List<PostoGraduacao> findAll();

	public PostoGraduacao findById(Long param);

	public void save(PostoGraduacao postoGraduacao);

	public PostoGraduacao update(PostoGraduacao postoGraduacao);

	public void delete(Long param);

	public PostoGraduacao findByRemuneracao(String soldo);

	public PostoGraduacao findByPostoGraduacao(String dsPostoGraduacao);

	public List<PostoGraduacao> findByPatente(String patente);

	public String findBySigla(String sgPostoGraduacao);

}