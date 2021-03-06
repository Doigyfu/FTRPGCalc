/*
 * Copyright (C) 2016 aluno
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

import java.net.URI;
import java.awt.Desktop;
import java.awt.event.*;

/**
 * Listener para os eventos da janela Sobre
 *
 * @author Doigyfu
 */
public class ListenerJanelaSobre implements ActionListener {

    JanelaSobre js;

    ListenerJanelaSobre(JanelaSobre js) {
        this.js = js;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == js.getBotaoBanner()) {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("http://www.fairytailadventure.net/"));
                } catch (Exception ex) {
                    
                }
            }
        }
    }

}
