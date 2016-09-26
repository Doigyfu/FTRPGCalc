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
    String versao;
    ImageIcon banner = criaImageIcon("banner.png");
    int w = 0, h = 0;

    JButton botaoBanner;

    JPanel painelBanner;

    JanelaSobre(GUI gui) {
        this.gui = gui;
        this.versao = gui.getVersao();
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        botaoBanner = new JButton(banner);
        botaoBanner.setIconTextGap(0);
        botaoBanner.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botaoBanner.setContentAreaFilled(false);
        botaoBanner.setMargin(new Insets(0, 0, 0, 0));
        botaoBanner.setSize(banner.getImage().getHeight(null), banner.getImage().getWidth(null));
        botaoBanner.setMaximumSize(botaoBanner.getSize());

        painelBanner = new JPanel(new FlowLayout());
        painelBanner.add(botaoBanner);
        w = max(w, painelBanner.getWidth());
        h += painelBanner.getHeight();

        setSize(banner.getImage().getWidth(null) + 40, banner.getImage().getHeight(null) + 80);
        //setLayout()
        add(painelBanner);
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
