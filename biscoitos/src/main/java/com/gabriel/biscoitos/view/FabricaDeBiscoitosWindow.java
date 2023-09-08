package com.gabriel.biscoitos.view;

import com.gabriel.biscoitos.model.Constantes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FabricaDeBiscoitosWindow implements ActionListener {

    JFrame window;
    JDialog constanteTDialog;
    JButton salvarConstanteButton;
    JTextField constanteTextField, ingrediente1TextField, ingrediente2, ingrediente3;
    JLabel constanteLabel, ingrediente1Label, ingrediente2Label, ingrediente3Label;
    JProgressBar JProgressBarForno1, JProgressBarForno2;

    public FabricaDeBiscoitosWindow() {
        window = new JFrame();

        configurarJanelaConstanteT();

        ingrediente1Label = new JLabel("Ingrediente 1");
        ingrediente1TextField = new JTextField();
        ingrediente1TextField.setBounds(170, 30, 150, 30);

        window.add(ingrediente1Label);
        window.add(ingrediente1TextField);

        window.setTitle("Fabrica de Biscoitos");
        window.setSize(1080, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setVisible(true);
        constanteTDialog.setVisible(true);
    }

    private void configurarJanelaConstanteT() {
        constanteTDialog = new JDialog(window, "Definindo constante inicial", true);
        constanteTDialog.setLayout(null);

        constanteLabel = new JLabel("Insira a constante:");
        constanteLabel.setBounds(30, 30, 150, 30);

        constanteTextField = new JTextField();
        constanteTextField.setBounds(30, 80, 150, 30);

        salvarConstanteButton = new JButton("Salvar");
        salvarConstanteButton.addActionListener(this);
        salvarConstanteButton.setBounds(210, 80, 100, 30 );

        constanteTDialog.add(constanteLabel);
        constanteTDialog.add(constanteTextField);
        constanteTDialog.add(salvarConstanteButton);
        constanteTDialog.setSize(340, 200);
    }

    public static void main(String[] args) {
        new FabricaDeBiscoitosWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Salvar")) {
            try {
                Constantes.T = Double.parseDouble(constanteTextField.getText());
                constanteTDialog.setVisible(false);
                System.out.println(Constantes.T);
            } catch (NumberFormatException ignored) {
            }
        }
    }
}
