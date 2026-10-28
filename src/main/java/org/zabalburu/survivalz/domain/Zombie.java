package org.zabalburu.survivalz.domain;

public class Zombie {
    public static final int VIDA_INICIAL_CAMINANTE = 20;
    public static final int VIDA_INICIAL_CORREDOR = 35;
    public static final int VIDA_INICIAL_TANQUE = 50;

    private String tipo;
    private int vida;

    public Zombie(){
        int tipoZ = (int) (Math.random() * 3) + 1;
        switch (tipoZ) {
            case 1:
                this.tipo = "Caminante";
                this.vida = VIDA_INICIAL_CAMINANTE;
                break;
            case 2:
                this.tipo = "Corredor";
                this.vida = VIDA_INICIAL_CORREDOR;
                break;
            default:
                this.tipo = "Tanque";
                this.vida = VIDA_INICIAL_TANQUE;
                break;
        }
    }


    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }


    @Override
    public String toString() {
        return "Zombie [tipo=" + tipo + ", vida=" + vida + "]";
    }

}
