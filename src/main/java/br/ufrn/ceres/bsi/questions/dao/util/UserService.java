package br.ufrn.ceres.bsi.questions.dao.util;

import br.ufrn.ceres.bsi.questions.model.Usuario;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author Emre Simtay <emre@simtay.com>
 */

@Stateless
public class UserService extends DataAccessService<Usuario>{


    public UserService(){
        super(Usuario.class);
    }

}
