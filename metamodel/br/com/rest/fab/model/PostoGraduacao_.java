package br.com.rest.fab.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-07-08T16:16:33.283-0300")
@StaticMetamodel(PostoGraduacao.class)
public class PostoGraduacao_ {
	public static volatile SingularAttribute<PostoGraduacao, Long> identificador;
	public static volatile SingularAttribute<PostoGraduacao, String> dsPostoGraduacao;
	public static volatile SingularAttribute<PostoGraduacao, String> sgPostoGraduacao;
	public static volatile SingularAttribute<PostoGraduacao, Soldo> fkSoldo;
	public static volatile SingularAttribute<PostoGraduacao, Patente> patente;
	public static volatile SingularAttribute<PostoGraduacao, byte[]> insignia;
	public static volatile SingularAttribute<PostoGraduacao, ImagemInsigniaFAB> fkInsignia;
}