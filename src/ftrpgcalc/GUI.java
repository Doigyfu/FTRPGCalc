package ftrpgcalc;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que trata de toda a interface grÃ¡fica da aplicaÃ§Ã£o.
 *
 * @author Felipe
 */
public class GUI {
    Calculadora calculadora;
    
    private final String[] STRING_ATRIBUTO_PRIMARIO = {"ForÃ§a:", "Agilidade:", 
        "Vitalidade:", "InteligÃªncia:", "Destreza:", "PercepÃ§Ã£o:", "Carisma:", 
    "Poder MÃ¡gico:", "ResistÃªncia:"};
    private final String[] STRING_ATRIBUTO_SECUNDARIO = {"Dano:", 
        "Poder de Fogo:", "Acerto:", "Esquiva:", "Bloqueio:", 
        "Controle MÃ¡gico:", "PersuasÃ£o:", "Velocidade de Ataque:", 
        "ConcentraÃ§Ã£o:"};
    private final String[] STRING_NIVEIS = {"HP:", "PM:", "ST:"};
    
    private JFrame janela;

    private JPanel painelAtributosPrimarios;
    private JPanel painelAtributosSecundarios;
    private JPanel painelRacas;

    private JLabel[] labelAtributoPrimario;    
    private JLabel[] labelNiveis;    
    private JLabel[] labelAtributoSecundario;
    
    private JLabel labelPontosGastos;
    private JLabel labelRaca;
    private JLabel labelSubraca;
    private JLabel labelGrauDeDeformidade;
    
    private JSpinner[] valorAtributoPrimario;
    private JFormattedTextField[] valorAtributoSecundario;
    private JFormattedTextField[] valorNiveis;
    
    private JMenuBar barraDeMenu;
    private JMenu menuOpcoes, menuAjuda;
    private JMenuItem itemReiniciar, itemGraficos, itemSobre, itemAjuda, itemSair;
    
    GUI(Calculadora calculadora){
        this.calculadora = calculadora;
        
        labelAtributoPrimario = new JLabel[STRING_ATRIBUTO_PRIMARIO.length];
        valorAtributoPrimario = new JSpinner[STRING_ATRIBUTO_PRIMARIO.length];
        painelAtributosPrimarios = new JPanel(new GridLayout(STRING_ATRIBUTO_PRIMARIO.length, 2, 5, 5));
        for(int i = 0; i < STRING_ATRIBUTO_PRIMARIO.length; i++){
            labelAtributoPrimario[i] = new JLabel(STRING_ATRIBUTO_PRIMARIO[i]);
            valorAtributoPrimario[i] = new JSpinner(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
            painelAtributosPrimarios.add(labelAtributoPrimario[i]);
            painelAtributosPrimarios.add(valorAtributoPrimario[i]);
        }
        
        labelAtributoSecundario = new JLabel[STRING_ATRIBUTO_SECUNDARIO.length];
        valorAtributoSecundario = new JFormattedTextField[STRING_ATRIBUTO_SECUNDARIO.length];
        painelAtributosSecundarios = new JPanel(new GridLayout(STRING_ATRIBUTO_SECUNDARIO.length, 2, 5, 5));
        for(int i = 0; i < STRING_ATRIBUTO_SECUNDARIO.length; i++){
            labelAtributoSecundario[i] = new JLabel(STRING_ATRIBUTO_SECUNDARIO[i]);
            valorAtributoSecundario[i] = new JFormattedTextField(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
            painelAtributosSecundarios.add(labelAtributoSecundario[i]);
            painelAtributosSecundarios.add(valorAtributoSecundario[i]);
        }
        
        labelNiveis = new JLabel[STRING_NIVEIS.length];
        valorNiveis = new JFormattedTextField[STRING_NIVEIS.length];
        for(int i = 0; i < STRING_NIVEIS.length; i++){
            labelNiveis[i] = new JLabel(STRING_NIVEIS[i]);
            valorNiveis[i] = new JFormattedTextField(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        }        
    }
}
