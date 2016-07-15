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

import java.awt.event.*;

/**
 * Classe responsável por tratar todos os eventos relacionados à parte de raças
 * da classe GUI.
 *
 * @author Doigyfu
 */
public class ListenerRacas implements ActionListener {

    Calculadora calculadora;
    GUI gui;

    ListenerRacas(GUI gui) {
        super();
        this.gui = gui;
        this.calculadora = gui.calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.seletorRacas) {
            calculadora.setRaca(gui.seletorRacas.getSelectedIndex());
            if (gui.seletorRacas.getSelectedIndex() != 2) {
                gui.seletorSubracas.setSelectedIndex(0);
                gui.seletorSubracas.setEnabled(false);
                gui.botoesGraus[0].setEnabled(false);
                gui.botoesGraus[0].setSelected(true);
                gui.botoesGraus[1].setEnabled(false);
            } else {
                gui.seletorSubracas.setEnabled(true);
                gui.botoesGraus[0].setEnabled(true);
                gui.botoesGraus[1].setEnabled(true);
            }
            gui.atualizarValores();

        } else if (e.getSource() == gui.seletorSubracas) {
            if (gui.seletorSubracas.isEnabled()) {
                calculadora.setSubraca(gui.seletorSubracas.getSelectedIndex());
            }
            gui.atualizarValores();

        } else if (e.getSource() == gui.botoesGraus[0]) {
            calculadora.setPrimeiroGrau(true);
            gui.atualizarValores();

        } else if (e.getSource() == gui.botoesGraus[1]) {
            calculadora.setPrimeiroGrau(false);
            gui.atualizarValores();

        } else if (e.getSource() == gui.botaoMagico) {
            if (gui.botaoMagico.isSelected()) {
                gui.botaoMagico.setText("Mágico");
                calculadora.setMagico(true);
            } else {
                gui.botaoMagico.setText("Não-Mágico");
                calculadora.setMagico(false);
            }
            gui.atualizarValores();
        }
    }
}
