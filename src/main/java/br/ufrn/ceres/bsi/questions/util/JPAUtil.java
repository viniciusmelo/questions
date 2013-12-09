package br.ufrn.ceres.bsi.questions.util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	 public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("questionsPU");

}
