package br.com.rest.fab.util;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.rest.fab.dao.IGenericDao;
import br.com.rest.fab.model.PostoGraduacao;

@Path("/fab")
@Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
public class FabResources {

	@Inject
	private IGenericDao<PostoGraduacao> dao;
	 
    @GET
	public List<PostoGraduacao> findAll(){
		List<PostoGraduacao> postosGraduacoes = dao.findAll();
	 	return postosGraduacoes;
	}
	
	@GET
	@Path("/{id}")
	public PostoGraduacao findById(@PathParam("id") Long id) {
		return dao.findById(id);
	}
	
	@POST
    public Response save(PostoGraduacao postoGraduacao) {
		dao.save(postoGraduacao);
		return Response.status(Status.OK).build();
	}
	
	@PUT
    public Response update(PostoGraduacao postoGraduacao) {
		dao.update(postoGraduacao);
		return Response.status(Status.OK).build();
	}
	
	@DELETE
    @Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		dao.delete(id);
		return Response.status(Status.OK).build();
	}
	
	
	/*
	 * @GET
	 * 
	 * @Path("/remuneracao/{remuneracao}") public PostoGraduacao findById
	 * (@PathParam("remuneracao")String remuneracao){ PostoGraduacao postosGraduacao
	 * = dao.findByRemuneracao(remuneracao); return postosGraduacao; }
	 * 
	 * @GET
	 * 
	 * @Path("/posto/{posto}") public PostoGraduacao
	 * findByPostoGraduacao(@PathParam("posto")String posto) { PostoGraduacao
	 * postoGraduacao = dao.findByPostoGraduacao(posto); return postoGraduacao; }
	 * 
	 * 
	 * 
	 * @GET
	 * 
	 * @Path("/patente/{patentes}") public List<PostoGraduacao> findByPatente
	 * (@PathParam("patentes") String patentes){ List<PostoGraduacao> patente =
	 * dao.findByPatente(patentes); return patente; }
	 * 
	 * @GET
	 * 
	 * @Path("/sigla/{sigla}") public String findBySigla(@PathParam("sigla")String
	 * sigla) { String sgPostoGraduacao = dao.findBySigla(sigla); return
	 * sgPostoGraduacao; }
	 */
}