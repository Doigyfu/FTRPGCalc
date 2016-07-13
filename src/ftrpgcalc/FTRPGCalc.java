package ftrpgcalc;

/**
 * Classe principal que inicializa a aplicação.
 * @author Doigyfu
 */
public class FTRPGCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI interfaceGrafica = new GUI(new Calculadora());
    }
}
