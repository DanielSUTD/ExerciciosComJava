package br.com.uniceplac.application;

import br.com.uniceplac.view.ImcView;

import javax.swing.*;

public class Main {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Calculadora de IMC");
            frame.setContentPane(new ImcView().getPainelPrincipal());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(300,300);
            frame.setVisible(true);
        }
}
