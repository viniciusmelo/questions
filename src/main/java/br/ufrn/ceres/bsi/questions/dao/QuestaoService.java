package br.ufrn.ceres.bsi.questions.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;

import br.ufrn.ceres.bsi.questions.model.Questao;


@Stateless
public class QuestaoService extends DataAccessService<Questao>{

    public QuestaoService(EntityManagerFactory emf) {
        super(Questao.class, emf);
    }

}
