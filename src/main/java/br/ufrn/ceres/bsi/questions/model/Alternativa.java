package br.ufrn.ceres.bsi.questions.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Alternativa extends BaseEntity implements Serializable{

    //public Alternativa(String a){

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Questao questao;


    private String descricao;



    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Questao getQuestao() {
        return questao;
    }


}
