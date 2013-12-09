package br.ufrn.ceres.bsi.questions.model;

import java.util.*;
import java.io.Serializable;

import javax.persistence.OneToMany;
import javax.persistence.*;

@Entity
public class Questao extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pergunta;

    @OneToMany(targetEntity = Alternativa.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    public  List<Alternativa> alternativas;

    public Questao(){

    }
    //public void addAlternativa(Alternativa a){
    //public void addAlternativaCorreta(Alternativa a){

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getPergunta() {
        return pergunta;
    }


    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }


    /*public void addAlternativa(String p) {
        Alternativa a = new Alternativa();
        a.setDescricao(p);
        alternativas.add(a);
    }*/


}
