package ftrpgcalc;

/**
 * Classe que armazena os dados de atributos e efetua suas operações.
 *
 * @author Doigyfu
 */
public class Calculadora {

    int forca, agilidade, vitalidade, inteligencia, destreza, percepcao, carisma,
            poderMagico, resistencia;
    int hp, mp, st;
    int dano, poderDeFogo, acerto, esquiva, bloqueio, controleMagico, concentracao,
            persuasao, velocidadeDeAtaque;
    int raca, subraca;
    boolean magico;

    Calculadora() {
        magico = true;
        raca = 0;
        subraca = 0;
        calcularTudo();
    }

    //##########################################################################
    //##  MÉTODOS RELACIONADOS AOS ATRIBUTOS PRIMÁRIOS
    //##########################################################################
    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getVitalidade() {
        return vitalidade;
    }

    public void setVitalidade(int vitalidade) {
        this.vitalidade = vitalidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getPercepcao() {
        return percepcao;
    }

    public void setPercepcao(int percepcao) {
        this.percepcao = percepcao;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    //##########################################################################
    //##  MÉTODOS RELACIONADOS AOS NÍVEIS
    //##########################################################################
    public int getHp() {
        return hp;
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
        this.magico = magico;
    }

    public int getRaca() {
        return raca;
    }

    public void setRaca(int raca) {
        this.raca = raca;
    }

    public int getSubraca() {
        return subraca;
    }

    public void setSubraca(int subraca) {
        this.subraca = subraca;
    }
}
