package ftrpgcalc;

import javax.swing.*;
import java.awt.*;

/**
 * Classe responsável por toda GUI da janela "Sobre".
 *
 * @author Doigyfu
 */
public class JanelaSobre extends JFrame {

    GUI gui;
    String versao = "2.1";
    ImageIcon banner = criaImageIcon("banner.png");
    ImageIcon icone = criaImageIcon("icon.png");
    int w = 0, h = 0;
    
    JLabel label1 = new JLabel("FTRPGCalc V." + versao);
    JLabel label2 = new JLabel("Por Doigyfu Abbot");
    JLabel label3 = new JLabel("Uso Exclusivo");
    JLabel label4 = new JLabel("Fairy Tail Adventure RPG");
    
    JButton botaoBanner;

    JPanel painelBanner;
    JPanel painelLabel1;
    JPanel painelLabel2;
    JPanel painelLabel3;
    JPanel painelLabel4;

    JanelaSobre(GUI gui) {
        this.gui = gui;
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        botaoBanner = new JButton(banner);
        botaoBanner.setIconTextGap(0);
        botaoBanner.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botaoBanner.setContentAreaFilled(false);
        botaoBanner.setMargin(new Insets(0, 0, 0, 0));
        botaoBanner.setSize(banner.getImage().getHeight(null), banner.getImage().getWidth(null));
        botaoBanner.setMaximumSize(botaoBanner.getSize());
        botaoBanner.addActionListener(new ListenerJanelaSobre(this));

        painelBanner = new JPanel(new FlowLayout());
        painelBanner.add(botaoBanner);
        w = max(w, (botaoBanner.getWidth() + 20));
        h += botaoBanner.getHeight();
        
        painelLabel1 = new JPanel(new FlowLayout());
        painelLabel1.add(label1);
        w = max(w, (label1.getWidth() + 20));
        h += 38;
        
        painelLabel2 = new JPanel(new FlowLayout());
        painelLabel2.add(label2);
        w = max(w, (label2.getWidth() + 20));
        h += 38;
        
        painelLabel3 = new JPanel(new FlowLayout());
        painelLabel3.add(label3);
        w = max(w, (label3.getWidth() + 20));
        h += 38;
        
        painelLabel4 = new JPanel(new FlowLayout());
        painelLabel4.add(label4);
        w = max(w, (label4.getWidth() + 20));
        h += 38;        

        setSize(w, h);
        setResizable(false);
        setTitle("Sobre");
        setIconImage(icone.getImage());
        setLayout(new FlowLayout(FlowLayout.CENTER, 200, 0));
        add(painelLabel1);
        add(painelLabel2);
        add(painelBanner);
        add(painelLabel3);
        add(painelLabel4);
        setLocationRelativeTo(null);
    }

    protected ImageIcon criaImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o banner.", "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public JButton getBotaoBanner(){
        return botaoBanner;
    }
    
    public int max(int x, int y){
        if(x > y){
            return x;
        } else {
            return y;
        }
    }
}
