package questions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufrn.ceres.bsi.questions.model.Questao;
import br.ufrn.ceres.bsi.questions.dao.QuestaoService;
import br.ufrn.ceres.bsi.questions.util.*;

public class TesteQuestao {

    private Questao questao = new Questao();
    private QuestaoService service = = new QuestaoService(JPAUtil.EMF);

    @Test
    public void test() {
        questao.addAlternativa("alternativaTeste");
    }

    @Before
    public void antes(){
       questao.setPergunta("Teste");
       service.create(questao);
    }

    @After
    public void depois(){
       service.delete(questao.getId());
    }

}
