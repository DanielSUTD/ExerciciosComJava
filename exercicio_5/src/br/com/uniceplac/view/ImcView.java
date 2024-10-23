package br.com.uniceplac.view;

import br.com.uniceplac.model.ImcModel;
import br.com.uniceplac.model.enums.Categoria;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImcView {
    private JPanel panelMain;
    private JLabel labelWeight;
    private JTextField txtWeight;
    private JLabel labelCalculator;
    private JTextField txtHeight;
    private JLabel labelHeight;
    private JButton btnCalc;
    private JLabel labelResult;
    private JTextField txtResult;

    public ImcView() {
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularImc();
            }
        });
    }

    //Obs: Função muito grande!
    private void calcularImc() {
        try {
            double peso = Double.parseDouble(txtWeight.getText());
            double altura = Double.parseDouble(txtHeight.getText());

            /*
            System.out.println("Peso: " + peso);
            System.out.println("Altura: " + altura);
            */


            if (peso <= 0 || altura <= 0) {
                JOptionPane.showMessageDialog(panelMain, "Valores inválidos! O peso e a altura devem ser maiores que 0.");
                return;
            }


            ImcModel imcModel = new ImcModel(peso, altura);


            double imc = imcModel.calcularImc();
            Categoria categoria = imcModel.getCategoriaImc();


            txtResult.setText(String.format("IMC: %.2f - Categoria: %s", imc, categoria));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panelMain, "Por favor, insira valores numéricos válidos para peso e altura.");
        }
    }

    public JPanel getPainelPrincipal() {

        return panelMain;
    }
}
