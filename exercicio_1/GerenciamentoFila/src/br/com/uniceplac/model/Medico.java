package br.com.uniceplac.model;

public class Medico extends Pessoa{

    private String especialidade;
    private String CRM;

    public Medico(String nome, int idade, String CPF, String especialidade, String CRM) {
        super(nome, idade, CPF);
        this.especialidade = especialidade;
        this.CRM = CRM;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    @Override
    public String toString() {
        return "|Nome: " +nome+ " |Idade: " +idade+ " |Especialidade: " +especialidade;
    }
}
