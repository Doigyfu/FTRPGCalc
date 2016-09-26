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

/**
 * Classe que armazena os dados de atributos e efetua suas operações. Lista de
 * raças: 0 = Humano 1 = Espírito Estelar 2 = Humanóide 3 = Demônio (a definir
 * detalhes e implementar)
 *
 * Lista de subraças: 0 = Felinos 1 = Caninos 2 = Aves 3 = Anfíbios 4 = Répteis
 * 5 = Primatas 6 = Bovinos e Equinos
 *
 * @author Doigyfu
 */
public class Calculadora {

    private int forca, agilidade, vitalidade, inteligencia, destreza, percepcao,
            carisma, poderMagico, resistencia;
    private int hp, mp, st;
    private int dano, poderDeFogo, acerto, esquiva, bloqueio, controleMagico,
            concentracao, persuasao, velocidadeDeAtaque;
    private int raca, subraca;
    private boolean primeiroGrau;
    private boolean magico;
    private int pontosGastos;

    Calculadora() {
        magico = true;
        raca = 0;
        subraca = 0;
        addBonusRaca();
        calcularTudo();
        primeiroGrau = true;
    }

    //##########################################################################
    //##  MÉTODOS RELACIONADOS AOS ATRIBUTOS PRIMÁRIOS
    //##########################################################################
    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
        calcularDano();
        if(magico){
            calcularBloqueio();
        }
    }
    
    public void incForca(){
        forca++;
        calcularDano();
        if(magico){
            calcularBloqueio();
        }
    }
    
    public void decForca(){
        rmvBonusRaca();
        if(forca > 0){
            forca--;
        }
        addBonusRaca();
        calcularDano();
        if(magico){
            calcularBloqueio();
        }
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
        calcularDano();
        calcularEsquiva();
    }
    
    public void incAgilidade(){
        agilidade++;
        calcularDano();
        calcularEsquiva();
    }
    
    public void decAgilidade(){
        rmvBonusRaca();
        if(agilidade > 0){
            agilidade--;
        }
        addBonusRaca();
        calcularDano();
        calcularEsquiva();
    }

    public int getVitalidade() {
        return vitalidade;
    }

    public void setVitalidade(int vitalidade) {
        this.vitalidade = vitalidade;
        calcularHp();
        calcularBloqueio();
    }
    
    public void incVitalidade(){
        vitalidade++;
        calcularHp();
        calcularBloqueio();
    }
    
    public void decVitalidade(){
        rmvBonusRaca();
        if(vitalidade > 0){
            vitalidade--;
        }
        addBonusRaca();
        calcularHp();
        calcularBloqueio();
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
        calcularControleMagico();
        calcularPersuasao();
    }
    
    public void incInteligencia(){
        inteligencia++;
        calcularControleMagico();
        calcularPersuasao();
    }
    
    public void decInteligencia(){
        rmvBonusRaca();
        if(inteligencia > 0){
            inteligencia--;
        }
        addBonusRaca();
        calcularControleMagico();
        calcularPersuasao();
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
        calcularPoderDeFogo();
        calcularAcerto();
        calcularEsquiva();
    }
    
    public void incDestreza(){
        destreza++;
        calcularPoderDeFogo();
        calcularAcerto();
        calcularEsquiva();
    }
    
    public void decDestreza(){
        rmvBonusRaca();
        if(destreza > 0){
            destreza--;
        }
        addBonusRaca();
        calcularPoderDeFogo();
        calcularAcerto();
        calcularEsquiva();
    }

    public int getPercepcao() {
        return percepcao;
    }

    public void setPercepcao(int percepcao) {
        this.percepcao = percepcao;
        calcularPoderDeFogo();
        calcularAcerto();
    }
    
    public void incPercepcao(){
        percepcao++;
        calcularPoderDeFogo();
        calcularAcerto();
    }
    
    public void decPercepcao(){
        rmvBonusRaca();
        if(percepcao > 0){
            percepcao--;
        }
        addBonusRaca();
        calcularPoderDeFogo();
        calcularAcerto();
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
        calcularPersuasao();
    }
    
    public void incCarisma(){
        carisma++;
        calcularPersuasao();
    }
    
    public void decCarisma(){
        rmvBonusRaca();
        if(carisma > 0){
            carisma--;
        }
        addBonusRaca();
        calcularPersuasao();
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
        calcularMp();
        calcularControleMagico();
    }    
    
    public void incPoderMagico(){
        poderMagico++;
        calcularMp();
        calcularControleMagico();
    }
    
    public void decPoderMagico(){
        rmvBonusRaca();
        if(poderMagico > 0){
            poderMagico--;
        }
        addBonusRaca();
        calcularMp();
        calcularControleMagico();
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
        calcularSt();
        calcularBloqueio();
    }    
    
    public void incResistencia(){
        resistencia++;
        calcularSt();
        calcularBloqueio();
    }
    
    public void decResistencia(){
        rmvBonusRaca();
        if(resistencia > 0){
            resistencia--;
        }
        addBonusRaca();
        calcularSt();
        calcularBloqueio();
    }

    //##########################################################################
    //##  MÉTODOS RELACIONADOS AOS NÍVEIS
    //##########################################################################
    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void calcularHp() {
        hp = (int) ((vitalidade * 10) + 20);
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void calcularMp() {
        if (magico) {
            mp = (int) ((poderMagico * 5) + 20);
        } else {
            mp = 0;
        }
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public void calcularSt() {
        if (!magico) {
            st = (int) ((resistencia * 5) + 20);
        } else {
            st = 0;
        }
    }

    //##########################################################################
    //##  MÉTODOS RELACIONADOS AOS ATRIBUTOS SECUNDÁRIOS
    //##########################################################################
    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void calcularDano() {
        dano = (int) (forca + (0.5 * agilidade));
    }

    public int getPoderDeFogo() {
        return poderDeFogo;
    }

    public void setPoderDeFogo(int poderDeFogo) {
        this.poderDeFogo = poderDeFogo;
    }

    public void calcularPoderDeFogo() {
        poderDeFogo = (int) (destreza + (0.5 * percepcao));
    }

    public int getAcerto() {
        return acerto;
    }

    public void setAcerto(int acerto) {
        this.acerto = acerto;
    }

    public void calcularAcerto() {
        acerto = (int) (percepcao + (0.5 * destreza));
    }

    public int getEsquiva() {
        return esquiva;
    }

    public void setEsquiva(int esquiva) {
        this.esquiva = esquiva;
    }

    public void calcularEsquiva() {
        esquiva = (int) (agilidade + (0.5 * destreza));
    }

    public int getBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(int bloqueio) {
        this.bloqueio = bloqueio;
    }

    public void calcularBloqueio() {
        if (magico) {
            bloqueio = (int) (vitalidade + (0.5 * forca));
        } else {
            bloqueio = (int) (vitalidade + (0.5 * resistencia));
        }
    }

    public int getControleMagico() {
        return controleMagico;
    }

    public void setControleMagico(int controleMagico) {
        this.controleMagico = controleMagico;
    }

    public void calcularControleMagico() {
        if (magico) {
            controleMagico = (int) (inteligencia + (0.5 * poderMagico));
        } else {
            controleMagico = 0;
        }
    }

    public int getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(int concentracao) {
        this.concentracao = concentracao;
    }

    public void calcularConcentracao() {
        if (!magico) {
            concentracao = (int) (resistencia + (0.5 * inteligencia));
        } else {
            concentracao = 0;
        }
    }

    public int getPersuasao() {
        return persuasao;
    }

    public void setPersuasao(int persuasao) {
        this.persuasao = persuasao;
    }

    public void calcularPersuasao() {
        persuasao = (int) (carisma + (0.5 * inteligencia));
    }

    public int getVelocidadeDeAtaque() {
        return velocidadeDeAtaque;
    }

    public void setVelocidadeDeAtaque(int velocidadeDeAtaque) {
        this.velocidadeDeAtaque = velocidadeDeAtaque;
    }

    public void calcularVelocidadeDeAtaque() {
        velocidadeDeAtaque = 4;
    }

    public void calcularTudo() {
        calcularHp();
        calcularMp();
        calcularSt();
        calcularDano();
        calcularPoderDeFogo();
        calcularAcerto();
        calcularEsquiva();
        calcularBloqueio();
        calcularControleMagico();
        calcularConcentracao();
        calcularPersuasao();
        calcularVelocidadeDeAtaque();
    }

    //##########################################################################
    //##  MÉTODOS RELACIONADOS AOS OUTROS ATRIBUTOS
    //##########################################################################
    public boolean isMagico() {
        return magico;
    }

    public void setMagico(boolean magico) {
        if (magico != this.magico){
            this.magico = magico;
            if(magico){
                poderMagico = resistencia;
                resistencia = 0;
            } else {
                resistencia = poderMagico;
                poderMagico = 0;
            }
        }
    }

    public int getRaca() {
        return raca;
    }

    public void setRaca(int raca) {
        rmvBonusRaca();
        this.raca = raca;
        addBonusRaca();
    }

    public int getSubraca() {
        return subraca;
    }

    public void setSubraca(int subraca) {
        rmvBonusRaca();
        this.subraca = subraca;
        addBonusRaca();
    }

    public boolean isPrimeiroGrau() {
        return primeiroGrau;
    }

    public void setPrimeiroGrau(boolean primeiroGrau) {
        rmvBonusRaca();
        this.primeiroGrau = primeiroGrau;
        addBonusRaca();
    }

    public void addBonusRaca() {
        switch (raca) {
            case 0:
                //  HUMANOS
                carisma += 2;
                inteligencia += 2;
                destreza += 2;
                calcularTudo();
                break;

            case 1:
                //  ESPÍRITOS ESTELARES
                poderMagico += 3;
                carisma += 2;
                inteligencia += 1;
                calcularTudo();
                break;

            case 2:
                //  HUMANÓIDES
                int bonus = 3;
                if (primeiroGrau) {
                    bonus = 4;
                }
                switch (subraca) {
                    case 0:
                        //  FELINOS
                        agilidade += bonus;
                        destreza += bonus;
                        percepcao += bonus;
                        calcularTudo();
                        bloqueio -= bonus;
                        break;

                    case 1:
                        //  CANINOS
                        forca += bonus;
                        agilidade += bonus;
                        percepcao += bonus;
                        calcularTudo();
                        esquiva -= bonus;
                        break;

                    case 2:
                        //  AVES
                        inteligencia += bonus;
                        destreza += bonus;
                        percepcao += bonus;
                        calcularTudo();
                        bloqueio -= bonus;
                        break;

                    case 3:
                        //  ANFÍBIOS
                        vitalidade += bonus;
                        inteligencia += bonus;
                        percepcao += bonus;
                        calcularTudo();
                        esquiva -= bonus;
                        break;

                    case 4:
                        //  RÉPTEIS
                        forca += bonus;
                        destreza += bonus;
                        inteligencia += bonus;
                        calcularTudo();
                        break;

                    case 5:
                        //  PRIMATAS
                        agilidade += bonus;
                        destreza += bonus;
                        percepcao += bonus;
                        calcularTudo();
                        break;

                    case 6:
                        //  BOVINOS E EQUINOS
                        forca += bonus;
                        agilidade += bonus;
                        vitalidade += bonus;
                        calcularTudo();
                        break;
                        
                    default:
                        System.exit(-1);

                }
                break;
                
            case 3:
                //  DEMÔNIOS
                //  A IMPLEMENTAR
                break;
                
            default:
                System.exit(-1);
        }
    }
    
    public void rmvBonusRaca() {
        switch (raca) {
            case 0:
                //  HUMANOS
                carisma -= 2;
                inteligencia -= 2;
                destreza -= 2;
                break;

            case 1:
                //  ESPÍRITOS ESTELARES
                poderMagico -= 3;
                carisma -= 2;
                inteligencia -= 1;
                break;

            case 2:
                //  HUMANÓIDES
                int bonus = 3;
                if (primeiroGrau) {
                    bonus = 4;
                }
                switch (subraca) {
                    case 0:
                        //  FELINOS
                        agilidade -= bonus;
                        destreza -= bonus;
                        percepcao -= bonus;
                        bloqueio += bonus;
                        break;

                    case 1:
                        //  CANINOS
                        forca -= bonus;
                        agilidade -= bonus;
                        percepcao -= bonus;
                        esquiva += bonus;
                        break;

                    case 2:
                        //  AVES
                        inteligencia -= bonus;
                        destreza -= bonus;
                        percepcao -= bonus;
                        bloqueio += bonus;
                        break;

                    case 3:
                        //  ANFÍBIOS
                        vitalidade -= bonus;
                        inteligencia -= bonus;
                        percepcao -= bonus;
                        esquiva += bonus;
                        break;

                    case 4:
                        //  RÉPTEIS
                        forca -= bonus;
                        destreza -= bonus;
                        inteligencia -= bonus;
                        break;

                    case 5:
                        //  PRIMATAS
                        agilidade -= bonus;
                        destreza -= bonus;
                        percepcao -= bonus;
                        break;

                    case 6:
                        //  BOVINOS E EQUINOS
                        forca -= bonus;
                        agilidade -= bonus;
                        vitalidade -= bonus;
                        break;
                        
                    default:
                        System.exit(-1);

                }
                break;
                
            case 3:
                //  DEMÔNIOS
                //  A IMPLEMENTAR
                break;
                
            default:
                System.exit(-1);
        }
        calcularTudo();
    }
    
    //##########################################################################
    //##  OUTROS MÉTODOS
    //##########################################################################
    
    public void calcularPontosGastos(){
        rmvBonusRaca();
        pontosGastos = (forca + agilidade + vitalidade + inteligencia + destreza +
                percepcao + carisma + poderMagico + resistencia);
        addBonusRaca();
    }

    public int getPontosGastos() {
        return pontosGastos;
    }
    
    public void reiniciar(){
        rmvBonusRaca();
        magico = true;
        raca = 0;
        subraca = 0;
        setForca(0);
        setAgilidade(0);
        setVitalidade(0);
        setInteligencia(0);
        setDestreza(0);
        setPercepcao(0);
        setCarisma(0);
        setPoderMagico(0);
        setResistencia(0);
        addBonusRaca();
        calcularTudo();
        primeiroGrau = true;
    }
    
}
