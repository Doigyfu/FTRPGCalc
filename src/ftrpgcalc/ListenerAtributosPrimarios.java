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

import javax.swing.event.*;

/**
 * Classe que trata dos eventos gerados a partir dos JSpinners de atributos
 * primários da classe GUI.
 *
 * @author Doigyfu
 */
public class ListenerAtributosPrimarios implements ChangeListener {

    Calculadora calculadora;
    GUI gui;

    ListenerAtributosPrimarios(GUI gui) {
        this.calculadora = gui.calculadora;
        this.gui = gui;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == gui.valorAtributoPrimario[0]) {
            while (((int) (gui.valorAtributoPrimario[0].getValue()) < calculadora.getForca()) && (calculadora.getForca() >= 0)) {
                calculadora.decForca();
            }
            while ((int) (gui.valorAtributoPrimario[0].getValue()) > calculadora.getForca()) {
                calculadora.incForca();
            }
            gui.atualizarValores();
        }

        if (e.getSource() == gui.valorAtributoPrimario[1]) {
            while (((int) (gui.valorAtributoPrimario[1].getValue()) < calculadora.getAgilidade()) && (calculadora.getAgilidade() >= 0)) {
                calculadora.decAgilidade();
            }
            while ((int) (gui.valorAtributoPrimario[1].getValue()) > calculadora.getAgilidade()) {
                calculadora.incAgilidade();
            }
            gui.atualizarValores();
        }

        if (e.getSource() == gui.valorAtributoPrimario[2]) {
            while (((int) (gui.valorAtributoPrimario[2].getValue()) < calculadora.getVitalidade()) && (calculadora.getVitalidade() >= 0)) {
                calculadora.decVitalidade();
            }
            while ((int) (gui.valorAtributoPrimario[2].getValue()) > calculadora.getVitalidade()) {
                calculadora.incVitalidade();
            }
            gui.atualizarValores();
        }

        if (e.getSource() == gui.valorAtributoPrimario[3]) {
            while (((int) (gui.valorAtributoPrimario[3].getValue()) < calculadora.getInteligencia()) && (calculadora.getInteligencia() >= 0)) {
                calculadora.decInteligencia();
            }
            while ((int) (gui.valorAtributoPrimario[3].getValue()) > calculadora.getInteligencia()) {
                calculadora.incInteligencia();
            }
            gui.atualizarValores();
        }

        if (e.getSource() == gui.valorAtributoPrimario[4]) {
            while (((int) (gui.valorAtributoPrimario[4].getValue()) < calculadora.getDestreza()) && (calculadora.getDestreza() >= 0)) {
                calculadora.decDestreza();
            }
            while ((int) (gui.valorAtributoPrimario[4].getValue()) > calculadora.getDestreza()) {
                calculadora.incDestreza();
            }
            gui.atualizarValores();
        }

        if (e.getSource() == gui.valorAtributoPrimario[5]) {
            while (((int) (gui.valorAtributoPrimario[5].getValue()) < calculadora.getPercepcao()) && (calculadora.getPercepcao() >= 0)) {
                calculadora.decPercepcao();
            }
            while ((int) (gui.valorAtributoPrimario[5].getValue()) > calculadora.getPercepcao()) {
                calculadora.incPercepcao();
            }
            gui.atualizarValores();
        }

        if (e.getSource() == gui.valorAtributoPrimario[6]) {
            while (((int) (gui.valorAtributoPrimario[6].getValue()) < calculadora.getCarisma()) && (calculadora.getCarisma() >= 0)) {
                calculadora.decCarisma();
            }
            while ((int) (gui.valorAtributoPrimario[6].getValue()) > calculadora.getCarisma()) {
                calculadora.incCarisma();
            }
            gui.atualizarValores();
        }

        if (e.getSource() == gui.valorAtributoPrimario[7]) {
            while (((int) (gui.valorAtributoPrimario[7].getValue()) < calculadora.getPoderMagico()) && (calculadora.getPoderMagico() >= 0)) {
                calculadora.decPoderMagico();
            }
            while ((int) (gui.valorAtributoPrimario[7].getValue()) > calculadora.getPoderMagico()) {
                calculadora.incPoderMagico();
            }
            gui.atualizarValores();
        }

        if (e.getSource() == gui.valorAtributoPrimario[8]) {
            while (((int) (gui.valorAtributoPrimario[8].getValue()) < calculadora.getResistencia()) && (calculadora.getResistencia() >= 0)) {
                calculadora.decResistencia();
            }
            while ((int) (gui.valorAtributoPrimario[8].getValue()) > calculadora.getResistencia()) {
                calculadora.incResistencia();
            }
            gui.atualizarValores();
        }
    }

}
