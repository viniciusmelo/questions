package br.ufrn.ceres.bsi.questions.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import br.ufrn.ceres.bsi.questions.model.Alternativa;
@Stateless
public class AlternativaService extends DataAccessService<Alternativa>{

    public AlternativaService(EntityManagerFactory emf){
        super(Alternativa.class, emf);
    }

}
