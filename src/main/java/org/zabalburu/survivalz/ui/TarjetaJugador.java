package org.zabalburu.survivalz.ui;

import java.util.Scanner;

import org.zabalburu.ichueca.terminalUtils.utils.TerminalANSI;
import org.zabalburu.ichueca.terminalUtils.utils.VisorImagenes;
import org.zabalburu.survivalz.domain.Personaje;


public class TarjetaJugador {
    private VisorImagenes visor;

    public TarjetaJugador(){
        this.visor = new VisorImagenes();
        visor.establecerTamaño(36,16);
        visor.alinearIzquierda();;
    }

    public void mostrarPersonaje(Personaje personaje){
        System.out.println(
            TerminalANSI.RESET +
            TerminalANSI.CLEAR_SCREEN +
            TerminalANSI.GO_HOME
        );
        escribir(
            1,
            2, 
            TerminalANSI.BOLD +
            TerminalANSI.CYAN +
            "SURVIVAL Z" +
            TerminalANSI.RESET
        );

        dibujarMarco();

        //escribir(6,3,"");
        System.out.print(TerminalANSI.goTo(6, 3));
        //System.out.flush();
        visor.mostrar("imagenes/superviviente.png");

        escribir(
            7,
            45,
            TerminalANSI.BOLD +
            TerminalANSI.WHITE +
            abreviar(personaje.getNombre(),20)
            + TerminalANSI.RESET
        );

        escribir(
            9,45, 
            TerminalANSI.YELLOW +
            personaje.getTipo() +
            TerminalANSI.RESET
        );  

        escribir(
            12,
            45,
            "❤️  Vida"
        );

        escribir(
            12,
            65,
            TerminalANSI.BOLD +
            TerminalANSI.GREEN +
            personaje.getVida() +
            TerminalANSI.RESET
        );

        escribir(
            14,
            45,
            "✨ Habilidad"
        );

        escribir(
            14,
            65,
            TerminalANSI.BOLD +
            TerminalANSI.GREEN +
            personaje.getHabilidad() +
            TerminalANSI.RESET
        );
        
        escribir(
            16,
            45,
            "🩹  Botiquines"
        );

        escribir(
            16,
            65,
            TerminalANSI.BOLD +
            TerminalANSI.GREEN +
            personaje.getBotiquines() +
            TerminalANSI.RESET
        );

        escribir(
            21,
            45,
            TerminalANSI.CYAN +
            "Preparado/a para sobrevivir." +
            TerminalANSI.RESET
        );

        escribir(
            26,
            3,
            TerminalANSI.MAGENTA +
            "✅  Personaje creado. La aventura está a punto de comezar" +
            TerminalANSI.RESET
        );

        escribir(28,1, TerminalANSI.RESET);
        System.out.flush();

    }

    private String abreviar(String texto, int longitudMaxima){
        if (texto.length() <= longitudMaxima){
            return texto;
        }
        return texto.substring(0, 20) +"...";
    }

    private void dibujarMarco(){
        escribir(
            3,
            3,
            TerminalANSI.CYAN +
            "┌" + "─".repeat(86) + "┐" +
            TerminalANSI.RESET
        );
        for(int fila=4; fila<24; fila++){
            escribir(
                fila,
                3,
                TerminalANSI.CYAN +
                "│" +
                TerminalANSI.RESET);
            escribir(
                fila,
                90,
                TerminalANSI.CYAN +
                "│" +
                TerminalANSI.RESET);
        }
        escribir(
            24,
            3,
            TerminalANSI.CYAN +
            "└" + "─".repeat(86) + "┘" +
            TerminalANSI.RESET
        );
        
    }

    private void escribir(int fila, int columna, String texto){
        System.out.println(
            TerminalANSI.goTo(fila, columna) +
            texto
        );
    }

    public static void main(String[] args) {
        Personaje jugador = new Personaje(
            "Alexander de Dios Madariaga y López",
            "Médico",
            Personaje.VIDA_MAXIMA_MEDICO,
            Personaje.HABILIDAD_INICIAL_MEDICO,
            Personaje.BOTIQUINES_INICIALES_MEDICO
        );
        TarjetaJugador tj = new TarjetaJugador();
        tj.mostrarPersonaje(jugador);
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

}
