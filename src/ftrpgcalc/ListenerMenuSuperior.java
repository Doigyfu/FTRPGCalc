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
 * Classe que trabalha os eventos do menu superior da GUI.
 * @author Doigyfu
 */

public class ListenerMenuSuperior implements ActionListener{
    GUI gui;
    Calculadora calculadora;
    
    ListenerMenuSuperior(GUI gui){
        this.gui = gui;
        this.calculadora = gui.calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == gui.itemSair){
            System.exit(0);
        } else if (e.getSource() == gui.itemReiniciar){
            calculadora.reiniciar();
            gui.atualizarValores();
        } else if (e.getSource() == gui.itemAjuda){

        } else if (e.getSource() == gui.itemGraficos){
            gui.g.setVisible(true);
        } else if (e.getSource() == gui.itemSobre){
            gui.js.setVisible(true);
        }
    }
    
}
