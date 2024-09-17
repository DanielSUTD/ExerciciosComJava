package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Biblioteca {
    private ArrayList<ItemBiblioteca> itens = new ArrayList<ItemBiblioteca>();
    private Queue<ItemBiblioteca> filaEspera = new LinkedList<ItemBiblioteca>();

    public void adicionarItem(ItemBiblioteca item) {
        itens.add(item);
    }

    public void removerItem(ItemBiblioteca item) {
        itens.remove(item);
    }

    public void listarItens() {
        for (ItemBiblioteca item : itens) {
            System.out.println(item.toString());
        }
    }


    public ArrayList<ItemBiblioteca> getItens() {
        return itens;
    }

    public void adicionarNaFila(ItemBiblioteca item) {
        filaEspera.add(item);
    }

    public void atenderFila() {
        if (!filaEspera.isEmpty()) {
            ItemBiblioteca item = filaEspera.poll();
            System.out.println("Atendendo: ");
            System.out.println(item.toString());
        } else {
            System.out.println("Não há itens na fila.");
        }
    }
}