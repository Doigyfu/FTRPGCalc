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

import java.awt.*;
import javax.swing.*;

/**
 * Classe responsável pela janela que exibe o gráfico de atributos.
 *
 * @author Doigyfu
 */
public class Grafico extends JFrame {

    Calculadora calculadora;
    GUI gui;

    Grafico(GUI gui) {
        this.calculadora = gui.calculadora;
        this.gui = gui;
        setTitle("Gráfico");
        add(new PainelGrafico());
        setSize(400, 400);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private class PainelGrafico extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int xCenter = getWidth() / 2;
            int yCenter = getHeight() / 2;
            int raio = (int) (Math.min(getWidth(), getHeight()) * 0.4);
            double angulo = (2 * Math.PI / 8);
            int vAtr[] = {calculadora.getForca(), calculadora.getAgilidade(),
                calculadora.getVitalidade(), calculadora.getInteligencia(),
                calculadora.getDestreza(), calculadora.getPercepcao(),
                calculadora.getCarisma(), calculadora.getPoderMagico()};
            if (!calculadora.isMagico()) {
                vAtr[7] = calculadora.getResistencia();
            }
            int xAtr[] = new int[8];
            int yAtr[] = new int[8];
            int maxAtr = max(vAtr);
            int grandeza;
            grandeza = (10 * (1 + dezenas(maxAtr)));
            grandeza += grandeza / 10;
            System.out.println("GRANDEZA = " + grandeza);
            Polygon bordas = new Polygon();
            Polygon atributos = new Polygon();
            for (int i = 0; i < 8; i++) {
                bordas.addPoint(
                        (int) (xCenter + raio * Math.sin(i * angulo)),
                        (int) (yCenter - raio * Math.cos(i * angulo)));
                if (i < 7) {
                    g.drawString(gui.labelAtributoPrimario[i].getText().substring(0, 3).toUpperCase(),
                            (int) (xCenter - 10 + raio * Math.sin(i * angulo) * 1.15),
                            (int) (yCenter + 5 - raio * Math.cos(i * angulo) * 1.1));
                } else if (calculadora.isMagico()) {
                    g.drawString(gui.labelAtributoPrimario[i].getText().substring(0, 3).toUpperCase(),
                            (int) (xCenter - 10 + raio * Math.sin(i * angulo) * 1.15),
                            (int) (yCenter + 5 - raio * Math.cos(i * angulo) * 1.1));
                } else {
                    g.drawString(gui.labelAtributoPrimario[i + 1].getText().substring(0, 3).toUpperCase(),
                            (int) (xCenter - 10 + raio * Math.sin(i * angulo) * 1.15),
                            (int) (yCenter + 5 - raio * Math.cos(i * angulo) * 1.1));
                }
                xAtr[i] = (int) (xCenter + raio * ((Math.sin(i * angulo)) * ((double) vAtr[i] / (double) grandeza)));
                yAtr[i] = (int) (yCenter - raio * ((Math.cos(i * angulo)) * ((double) vAtr[i] / (double) grandeza)));
                atributos.addPoint(xAtr[i], yAtr[i]);
                System.out.println(((double) vAtr[i]) + " / " + ((double) grandeza) + " = " + ((double) vAtr[i]) / ((double) grandeza));
            }
            g.setColor(Color.red);
            g.fillPolygon(atributos);
            g.setColor(Color.gray);
            Polygon marcacoes[];
            marcacoes = new Polygon[(1 + dezenas(maxAtr))];
            for (int i = 1; i < marcacoes.length; i++) {
                marcacoes[i] = new Polygon();
                for (int j = 0; j < 8; j++) {
                    int xp = (int) (xCenter + raio * ((Math.sin(j * angulo)) * ((double) i / (double) (1.0 + marcacoes.length))));
                    int yp = (int) (yCenter - raio * ((Math.cos(j * angulo)) * ((double) i / (double) (1.0 + marcacoes.length))));
                    System.out.println("P"+ i + "-" + j +" = (" + xp + ", " + yp + ")");
                    marcacoes[i].addPoint(xp, yp);
                }
                System.out.println(((double) i / (double) (1.0 + marcacoes.length)));
                g.drawPolygon(marcacoes[i]);
            }
            g.setColor(Color.black);
            g.drawPolygon(bordas);
        }

        private int max(int[] v) {
            int max = 0;

            for (int i = 0; i < v.length; i++) {
                if (v[i] > max) {
                    max = v[i];
                }
            }
            System.out.println("MAX = " + max);
            return max;
        }

        private int dezenas(int i) {
            int dezenas = 0;
            int numero = i;
            while (true) {
                if (numero >= 10) {
                    numero = (int) (numero - 10);
                    dezenas++;
                } else {
                    break;
                }
            }
            System.out.println("DEZENAS = " + dezenas);
            return dezenas;
        }
    }
}
