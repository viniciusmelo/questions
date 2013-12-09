package br.ufrn.ceres.bsi.questions.dao;

import br.ufrn.ceres.bsi.questions.model.Usuario;



import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;


/**
 *
 * @author Emre Simtay <emre@simtay.com>
 */

@Stateless
public class UserService extends DataAccessService<Usuario>{


    public UserService(EntityManagerFactory emf){
        super(Usuario.class, emf);
    }

}
