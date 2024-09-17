package br.com.uniceplac.service;

import br.com.uniceplac.model.Paciente;
import java.util.PriorityQueue;

public class GerenciadorFila {
    private final PriorityQueue<Paciente> filaPacientes = new PriorityQueue<>();


    public void adicionarPaciente(Paciente paciente) {
        filaPacientes.offer(paciente);
        System.out.println("Paciente adicionado à fila: " + paciente.getNome());
    }


    public Paciente chamarProximoPaciente() {
        Paciente paciente = filaPacientes.poll();
        if (paciente != null) {
            System.out.println("Próximo paciente: " + paciente.getNome());
        } else {
            System.out.println("Não há pacientes na fila.");
        }
        return paciente;
    }


    public void exibirFila() {
        if (filaPacientes.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Pacientes na fila: ");
            filaPacientes.forEach(System.out::println);
        }
    }
}
