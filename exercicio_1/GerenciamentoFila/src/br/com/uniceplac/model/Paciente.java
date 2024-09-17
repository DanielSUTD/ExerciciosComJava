package br.com.uniceplac.model;

import br.com.uniceplac.model.enums.Prioridade;
import java.util.Comparator;

public class Paciente extends Pessoa implements Comparable<Paciente>{

    private String tipoConsulta;
    private Prioridade prioridade;

    public Paciente(String nome, int idade, String CPF, String tipoConsulta, Prioridade prioridade) {
        super(nome, idade, CPF);
        this.tipoConsulta = tipoConsulta;
        this.prioridade = prioridade;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public int compareTo(Paciente outroPaciente) {
        return this.prioridade.compareTo(outroPaciente.getPrioridade());
    }

    @Override
    public String toString() {
        return "|Nome: " +nome+ " |Idade: " +idade+ " |Consulta: " +tipoConsulta+ " |Prioridade: " +prioridade;
    }

}
