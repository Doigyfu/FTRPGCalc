/*
 * Copyright (C) 2016 Doigyfu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ftrpgcalc;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.event.AncestorListener;

/**
 * Classe que trata de toda a interface gráfica da aplicação.
 *
 * @author Doigyfu
 */
public class GUI {

    private String STRING_VERSAO = "0.1";

    Calculadora calculadora;
    
    Grafico g;
    JanelaSobre js;

    private final String[] STRING_ATRIBUTO_PRIMARIO = {"Força:", "Agilidade:",
        "Vitalidade:", "Inteligência:", "Destreza:", "Percepção:", "Carisma:",
        "Poder Mágico:", "Resistência:"};
    private final String[] STRING_ATRIBUTO_SECUNDARIO = {"Dano:",
        "Poder de Fogo:", "Acerto:", "Esquiva:", "Bloqueio:",
        "Controle Mágico:", "Persuasão:", "Velocidade de Ataque:",
        "Concentração:"};
    private final String[] STRING_NIVEIS = {"    HP:", "    PM:", "    ST:"};
    private final String[] STRING_PAINEL_RACA = {"Raça:", "Subraça:", "Magia:"};
    private final String[] STRING_RACA = {"Humano", "Espírito Estelar",
        "Humanóide", "Demônio"};
    private final String[] STRING_SUBRACA = {"Felino", "Canino", "Ave",
        "Anfíbio", "Réptil", "Primata", "Bovino/Equino"};
    private final String[] STRING_GRAU = {"Primeiro Grau", "Segundo Grau"};

    JFrame janela;

    Color[] cor = {new Color(54, 177, 0), new Color(45, 115, 200), new Color(224, 148, 0)};

    JPanel painelAtributosPrimarios;
    JPanel painelAtributosSecundarios;
    JPanel painelRacas;
    JPanel painelNiveis;
    JPanel painelPontos;
    JPanel painelNiveisEPontos;

    JLabel[] labelAtributoPrimario;
    JLabel[] labelNiveis;
    JLabel[] labelAtributoSecundario;
    JLabel[] labelPainelRacas;

    JLabel labelPontosGastos;
    JLabel labelRaca;
    JLabel labelSubraca;
    JLabel labelGrauDeDeformidade;
    JLabel labelPontos;

    JSpinner[] valorAtributoPrimario;
    JFormattedTextField[] valorAtributoSecundario;
    JFormattedTextField[] valorNiveis;
    JFormattedTextField valorPontos;

    JMenuBar barraDeMenu;
    JMenu menuOpcoes, menuAjuda;
    JMenuItem itemReiniciar, itemGraficos, itemSobre, itemAjuda, itemSair;

    JComboBox seletorRacas;
    JComboBox seletorSubracas;

    JRadioButton[] botoesGraus;
    ButtonGroup grupoGraus;

    JToggleButton botaoMagico;

    private int alturaJanela = 0;
    private int larguraJanela = 300;

    private ListenerRacas listenerRacas;
    private ListenerMenuSuperior listenerMenu;
    private ListenerAtributosPrimarios listenerPrimarios;

    GUI(Calculadora calculadora) {
        this.calculadora = calculadora;
        listenerRacas = new ListenerRacas(this);
        listenerMenu = new ListenerMenuSuperior(this);

        barraDeMenu = new JMenuBar();
        menuOpcoes = new JMenu("Opções");
        menuAjuda = new JMenu("Ajuda");
        itemReiniciar = new JMenuItem("Reiniciar");
        itemGraficos = new JMenuItem("Gráficos");
        itemSobre = new JMenuItem("Sobre");
        itemAjuda = new JMenuItem("Ajuda");
        itemSair = new JMenuItem("Sair");

        alturaJanela += 20;
        
        itemReiniciar.addActionListener(listenerMenu);
        itemGraficos.addActionListener(listenerMenu);
        itemSobre.addActionListener(listenerMenu);
        itemAjuda.addActionListener(listenerMenu);
        itemSair.addActionListener(listenerMenu);

        menuOpcoes.add(itemReiniciar);
        menuOpcoes.add(itemGraficos);

        menuAjuda.add(itemSobre);
        menuAjuda.add(itemAjuda);

        barraDeMenu.add(menuOpcoes);
        barraDeMenu.add(menuAjuda);
        barraDeMenu.add(itemSair);

        painelRacas = new JPanel(new GridLayout(4, 2, 5, 5));
        labelPainelRacas = new JLabel[STRING_PAINEL_RACA.length];
        for (int i = 0; i < STRING_PAINEL_RACA.length - 1; i++) {
            labelPainelRacas[i] = new JLabel(STRING_PAINEL_RACA[i]);
            painelRacas.add(labelPainelRacas[i]);
            alturaJanela += 25;
        }
        seletorRacas = new JComboBox(STRING_RACA);
        painelRacas.add(seletorRacas, 1);
        seletorSubracas = new JComboBox(STRING_SUBRACA);
        painelRacas.add(seletorSubracas, 3);
        seletorRacas.addActionListener(listenerRacas);
        seletorSubracas.addActionListener(listenerRacas);
        alturaJanela += 50;

        grupoGraus = new ButtonGroup();
        botoesGraus = new JRadioButton[STRING_GRAU.length];
        for (int i = 0; i < STRING_GRAU.length; i++) {
            botoesGraus[i] = new JRadioButton(STRING_GRAU[i]);
            grupoGraus.add(botoesGraus[i]);
            painelRacas.add(botoesGraus[i]);
            botoesGraus[i].addActionListener(listenerRacas);
            alturaJanela += 25;
        }

        botaoMagico = new JToggleButton("Mágico");
        botaoMagico.addActionListener(listenerRacas);
        labelPainelRacas[2] = new JLabel(STRING_PAINEL_RACA[2]);
        painelRacas.add(labelPainelRacas[2]);
        painelRacas.add(botaoMagico);
        alturaJanela += 30;
        painelRacas.setBorder(new TitledBorder("Raça"));
        alturaJanela += 20;
        
        listenerPrimarios = new ListenerAtributosPrimarios(this);
        
        painelAtributosPrimarios = new JPanel(new GridLayout((STRING_ATRIBUTO_PRIMARIO.length - 1), 2, 5, 5));
        labelAtributoPrimario = new JLabel[STRING_ATRIBUTO_PRIMARIO.length];
        valorAtributoPrimario = new JSpinner[STRING_ATRIBUTO_PRIMARIO.length];
        for (int i = 0; i < STRING_ATRIBUTO_PRIMARIO.length; i++) {
            labelAtributoPrimario[i] = new JLabel(STRING_ATRIBUTO_PRIMARIO[i]);
            valorAtributoPrimario[i] = new JSpinner(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
            valorAtributoPrimario[i].addChangeListener(listenerPrimarios);
            if (i < (STRING_ATRIBUTO_PRIMARIO.length - 1)) {
                painelAtributosPrimarios.add(labelAtributoPrimario[i]);
                painelAtributosPrimarios.add(valorAtributoPrimario[i]);
                alturaJanela += 25;
            }
        }
        painelAtributosPrimarios.setBorder(new TitledBorder("Atributos Primários"));
        alturaJanela += 20;

        painelNiveis = new JPanel(new GridLayout(STRING_NIVEIS.length - 1, 2, 5, 5));
        labelNiveis = new JLabel[STRING_NIVEIS.length];
        valorNiveis = new JFormattedTextField[STRING_NIVEIS.length];

        for (int i = 0; i < STRING_NIVEIS.length; i++) {
            labelNiveis[i] = new JLabel(STRING_NIVEIS[i]);
            labelNiveis[i].setForeground(cor[i]);
            valorNiveis[i] = new JFormattedTextField(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
            valorNiveis[i].setEditable(false);
            valorNiveis[i].setText("0");
            valorNiveis[i].setForeground(cor[i]);
            valorNiveis[i].setHorizontalAlignment(JTextField.RIGHT);

            if (i < (STRING_NIVEIS.length - 1)) {
                painelNiveis.add(labelNiveis[i]);
                painelNiveis.add(valorNiveis[i]);
                alturaJanela += 25;
            }
        }
        painelNiveis.setBorder(new TitledBorder("Níveis"));

        painelPontos = new JPanel(new BorderLayout());
        valorPontos = new JFormattedTextField(
                new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        valorPontos.setHorizontalAlignment(JTextField.CENTER);
        valorPontos.setEditable(false);
        valorPontos.setFont(new Font("Arial", Font.PLAIN, 24));
        valorPontos.setValue(0);
        painelPontos.add(valorPontos, BorderLayout.CENTER);
        painelPontos.setBorder(new TitledBorder("Pontos Gastos"));

        painelNiveisEPontos = new JPanel(new GridLayout(1, 2, 3, 5));
        painelNiveisEPontos.add(painelNiveis);
        painelNiveisEPontos.add(painelPontos);

        alturaJanela += 20;

        painelAtributosSecundarios = new JPanel(new GridLayout(STRING_ATRIBUTO_SECUNDARIO.length - 1, 2, 5, 5));
        labelAtributoSecundario = new JLabel[STRING_ATRIBUTO_SECUNDARIO.length];
        valorAtributoSecundario = new JFormattedTextField[STRING_ATRIBUTO_SECUNDARIO.length];

        for (int i = 0; i < STRING_ATRIBUTO_SECUNDARIO.length; i++) {
            labelAtributoSecundario[i] = new JLabel(STRING_ATRIBUTO_SECUNDARIO[i]);
            valorAtributoSecundario[i] = new JFormattedTextField(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
            valorAtributoSecundario[i].setEditable(false);
            valorAtributoSecundario[i].setText("0");
            valorAtributoSecundario[i].setHorizontalAlignment(JTextField.RIGHT);

            if (i < STRING_ATRIBUTO_SECUNDARIO.length - 1) {
                painelAtributosSecundarios.add(labelAtributoSecundario[i]);
                painelAtributosSecundarios.add(valorAtributoSecundario[i]);
                alturaJanela += 25;
            }
        }
        painelAtributosSecundarios.setBorder(new TitledBorder("Atributos Secundários"));
        alturaJanela += 25;

        janela = new JFrame("Calculadora de Atributos V." + STRING_VERSAO);
        janela.setSize(larguraJanela, alturaJanela);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setLayout(null);
        int espacoGasto = 0;

        barraDeMenu.setSize(janela.getWidth(), 20);
        janela.add(barraDeMenu);

        espacoGasto += 20;

        painelRacas.setSize(janela.getWidth() - 5, (30 * 4));
        painelRacas.setBounds(0, espacoGasto, painelRacas.getWidth(), painelRacas.getHeight());
        janela.add(painelRacas);
        espacoGasto += painelRacas.getHeight() + 5;

        painelAtributosPrimarios.setSize(janela.getWidth() - 5, ((STRING_ATRIBUTO_PRIMARIO.length - 1) * 30));
        painelAtributosPrimarios.setBounds(0, espacoGasto, painelAtributosPrimarios.getWidth(), painelAtributosPrimarios.getHeight());
        janela.add(painelAtributosPrimarios);
        espacoGasto += painelAtributosPrimarios.getHeight() + 5;

        painelNiveisEPontos.setSize(janela.getWidth() - 5, ((STRING_NIVEIS.length - 1) * 35));
        painelNiveisEPontos.setBounds(0, espacoGasto, painelNiveisEPontos.getWidth(), painelNiveisEPontos.getHeight());
        janela.add(painelNiveisEPontos);
        espacoGasto += painelNiveisEPontos.getHeight() + 5;

        painelAtributosSecundarios.setSize(janela.getWidth() - 5, ((STRING_ATRIBUTO_SECUNDARIO.length - 1) * 30));
        painelAtributosSecundarios.setBounds(0, espacoGasto, painelAtributosSecundarios.getWidth(), painelAtributosSecundarios.getHeight());
        janela.add(painelAtributosSecundarios);
        espacoGasto += painelAtributosSecundarios.getHeight() + 5;

        janela.setVisible(true);
        g = new Grafico(this);
        js = new JanelaSobre(this);
        atualizarValores();
    }

    public void atualizarValores() {
        seletorRacas.setSelectedIndex(calculadora.getRaca());

        seletorSubracas.setEnabled((calculadora.getRaca() == 2));
        botoesGraus[0].setEnabled((calculadora.getRaca() == 2));
        botoesGraus[1].setEnabled((calculadora.getRaca() == 2));

        seletorSubracas.setSelectedIndex(calculadora.getSubraca());
        botoesGraus[0].setSelected(calculadora.isPrimeiroGrau());
        botoesGraus[1].setSelected(!calculadora.isPrimeiroGrau());
        botaoMagico.setSelected(calculadora.isMagico());

        valorNiveis[0].setValue(calculadora.getHp());
        valorNiveis[1].setValue(calculadora.getMp());
        valorNiveis[2].setValue(calculadora.getSt());

        valorAtributoPrimario[0].setValue(calculadora.getForca());
        valorAtributoPrimario[1].setValue(calculadora.getAgilidade());
        valorAtributoPrimario[2].setValue(calculadora.getVitalidade());
        valorAtributoPrimario[3].setValue(calculadora.getInteligencia());
        valorAtributoPrimario[4].setValue(calculadora.getDestreza());
        valorAtributoPrimario[5].setValue(calculadora.getPercepcao());
        valorAtributoPrimario[6].setValue(calculadora.getCarisma());
        valorAtributoPrimario[7].setValue(calculadora.getPoderMagico());
        valorAtributoPrimario[8].setValue(calculadora.getResistencia());

        valorAtributoSecundario[0].setValue(calculadora.getDano());
        valorAtributoSecundario[1].setValue(calculadora.getPoderDeFogo());
        valorAtributoSecundario[2].setValue(calculadora.getAcerto());
        valorAtributoSecundario[3].setValue(calculadora.getEsquiva());
        valorAtributoSecundario[4].setValue(calculadora.getBloqueio());
        valorAtributoSecundario[5].setValue(calculadora.getControleMagico());
        valorAtributoSecundario[8].setValue(calculadora.getConcentracao());
        valorAtributoSecundario[6].setValue(calculadora.getPersuasao());
        valorAtributoSecundario[7].setValue(calculadora.getVelocidadeDeAtaque());
        
        calculadora.calcularPontosGastos();
        valorPontos.setValue(calculadora.getPontosGastos());

        if (botaoMagico.isSelected() && calculadora.isMagico()) {
            painelAtributosPrimarios.remove(15);
            painelAtributosPrimarios.remove(14);
            painelNiveis.remove(3);
            painelNiveis.remove(2);
            painelAtributosSecundarios.remove(11);
            painelAtributosSecundarios.remove(10);

            painelAtributosPrimarios.add(labelAtributoPrimario[7], 14);
            painelAtributosPrimarios.add(valorAtributoPrimario[7], 15);
            painelNiveis.add(labelNiveis[1], 2);
            painelNiveis.add(valorNiveis[1], 3);
            painelAtributosSecundarios.add(labelAtributoSecundario[5], 10);
            painelAtributosSecundarios.add(valorAtributoSecundario[5], 11);

        } else {
            painelAtributosPrimarios.remove(15);
            painelAtributosPrimarios.remove(14);
            painelNiveis.remove(3);
            painelNiveis.remove(2);
            painelAtributosSecundarios.remove(11);
            painelAtributosSecundarios.remove(10);

            painelAtributosPrimarios.add(labelAtributoPrimario[8], 14);
            painelAtributosPrimarios.add(valorAtributoPrimario[8], 15);
            painelNiveis.add(labelNiveis[2], 2);
            painelNiveis.add(valorNiveis[2], 3);
            painelAtributosSecundarios.add(labelAtributoSecundario[8], 10);
            painelAtributosSecundarios.add(valorAtributoSecundario[8], 11);
        }
        painelAtributosPrimarios.updateUI();
        painelAtributosSecundarios.updateUI();
        painelNiveis.updateUI();
        g.repaint();
    }
    
    public String getVersao(){
        return STRING_VERSAO;
    }
}
