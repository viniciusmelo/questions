package br.ufrn.ceres.bsi.questions.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufrn.ceres.bsi.questions.model.Questao;
import br.ufrn.ceres.bsi.questions.model.Alternativa;
import br.ufrn.ceres.bsi.questions.dao.AlternativaService;
import br.ufrn.ceres.bsi.questions.dao.QuestaoService;
import br.ufrn.ceres.bsi.questions.util.JPAUtil;

@ManagedBean
@RequestScoped
public class AlternativaMB {

    private Alternativa alternativa = new Alternativa();
    private Questao questao = new Questao();
    private AlternativaService service;
    private QuestaoService serviceQuestao;
    private String mensagem = "";

    public AlternativaMB(){
        service = new AlternativaService(JPAUtil.EMF);
        serviceQuestao = new QuestaoService(JPAUtil.EMF);
    }

    public void inserir(){
        try{
            questao = serviceQuestao.findQuestao(questao.getId());
            alternativa.setQuestao(questao);
            questao.addAlternativa(alternativa.getDescricao());
            service.create(alternativa);
            setMensagem("Alternativa '"+alternativa.getDescricao()+"' criado com sucesso na questao '"+questao.getPergunta()+"'");
        }catch(Exception e){
            setMensagem("ERROR");
            e.printStackTrace();
        }
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }

    public Alternativa getAlternativa() {
        return alternativa;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setService(AlternativaService service) {
        this.service = service;
    }

    public AlternativaService getService() {
        return service;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setServiceQuestao(QuestaoService serviceQuestao) {
        this.serviceQuestao = serviceQuestao;
    }

    public QuestaoService getServiceQuestao() {
        return serviceQuestao;
    }
}
