package br.com.rest.fab.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PostoGraduacao.class)
public abstract class PostoGraduacao_ {

	public static volatile SingularAttribute<PostoGraduacao, Soldo> fkSoldo;
	public static volatile SingularAttribute<PostoGraduacao, String> dsPostoGraduacao;
	public static volatile SingularAttribute<PostoGraduacao, ImagemInsigniaFAB> fkInsignia;
	public static volatile SingularAttribute<PostoGraduacao, Long> identificador;
	public static volatile SingularAttribute<PostoGraduacao, String> sgPostoGraduacao;
	public static volatile SingularAttribute<PostoGraduacao, Patente> patente;

}

