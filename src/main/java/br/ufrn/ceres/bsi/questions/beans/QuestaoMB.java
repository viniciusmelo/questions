package br.ufrn.ceres.bsi.questions.beans;


import java.util.List;





import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufrn.ceres.bsi.questions.dao.QuestaoService;
import br.ufrn.ceres.bsi.questions.model.Alternativa;
import br.ufrn.ceres.bsi.questions.model.Questao;
import br.ufrn.ceres.bsi.questions.util.*;

@ManagedBean
@RequestScoped
public class QuestaoMB{


    private Questao questao = new Questao();
    private List<Questao> questoes;
    private QuestaoService service;
    private String mensagem = "";

    public QuestaoMB(){
        service = new QuestaoService(JPAUtil.EMF);
        questoes = service.findEntities();
    }
    public void inserir(){
        try{
            service.create(questao);
            setMensagem("Questao '"+questao.getPergunta()+"' criado com sucesso");
        } catch (Exception e) {
            setMensagem("ERROR");
            e.printStackTrace();
        }

    }

    public void teste(){
        System.out.println(questao.getPergunta());
    }
    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setService(QuestaoService service) {
        this.service = service;
    }

    public QuestaoService getService() {
        return service;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void deletarQuestao(Questao q){
        try{
           setMensagem("Questao "+q.getPergunta()+" removido com sucesso!");
           service.delete(q.getId());
           }catch (Exception e) {
               setMensagem("Erro ao excluir");
               e.printStackTrace();
           }
    }

}
