package org.zabalburu.survivalz.ui;

import java.util.Scanner;

import org.zabalburu.ichueca.terminalUtils.utils.TerminalANSI;
import org.zabalburu.ichueca.terminalUtils.utils.VisorImagenes;
import org.zabalburu.survivalz.domain.Personaje;

public class PantallaMision {

    private static final int SEGMENTOS_BARRA = 30;

    private final VisorImagenes visor;

    public PantallaMision(){
        this.visor = new VisorImagenes();
        this.visor.establecerTamaño(64, 12);
        this.visor.alinearIzquierda();
    }

    public void mostrar(
        Personaje personaje,
        int dia,
        int totalDias,
        String mision,
        int puntosMision,
        int puntosAcumulados,
        int objetivo){
        
        System.out.print(
            TerminalANSI.RESET +
            TerminalANSI.CLEAR_SCREEN +
            TerminalANSI.GO_HOME
        );

        escribir(
            1,
            3,
            TerminalANSI.BOLD+
            TerminalANSI.CYAN +
            "Survival Z" +
            TerminalANSI.RESET +
            "    |   Día " + dia + " DE " + totalDias
        );

        dibujarMarco();

        escribir(
            4,
            6, 
            TerminalANSI.BOLD +
            TerminalANSI.CYAN +
            personaje.getNombre() +
            TerminalANSI.RESET +
            "    |  Vida : " + personaje.getVida() +
            "    |  Botiquines : " + personaje.getBotiquines()
        );

        escribir(5, 6, "Estado : " + obtenerEstado(personaje));

        escribir(7, 16, "");
        System.out.flush();

        visor.mostrar(obtenerRutaImagen(mision));

        escribir(
            20,
            6,
            TerminalANSI.BOLD +
            TerminalANSI.CYAN +
            mision +
            TerminalANSI.RESET
        );

        escribir(
            21,
            6,
            "Puntos obtenidos: " +
            TerminalANSI.BOLD + 
            TerminalANSI.GREEN +
            "+" + puntosMision +
            TerminalANSI.RESET);

        mostrarProgreso(puntosAcumulados, objetivo);

    }

    private void mostrarProgreso(int puntosAcumulados, int objetivo) {
        int segmentosLlenos =
            puntosAcumulados * SEGMENTOS_BARRA / objetivo;

        segmentosLlenos = Math.min(segmentosLlenos, SEGMENTOS_BARRA);

        String barra = 
            "▓".repeat(segmentosLlenos) +
            "░".repeat(SEGMENTOS_BARRA - segmentosLlenos);
        escribir(
            23,
            6,
            "Progreso: " +
            TerminalANSI.GREEN +
            "[" + barra + "]" +
            TerminalANSI.RESET +
            "  " + puntosAcumulados + " / " + objetivo
        );
    }

    private String obtenerRutaImagen(String mision) {
        return switch(mision){
            case "Combatir zombis" -> "imagenes/mision-combate.png";
            case "Explorar vivienda" -> "imagenes/mision-exploracion.png";
            default -> "imagenes/amanecer.png";
        };
    }

    private String obtenerEstado(Personaje personaje) {
        if (personaje.getVida() < 30){
            return TerminalANSI.BOLD +
                TerminalANSI.RED +
                "CRÍTICO" +
                TerminalANSI.RESET;
        }  else if (personaje.getVida() <= 70){
            return TerminalANSI.BOLD +
                TerminalANSI.YELLOW +
                "HERIDO" +
                TerminalANSI.RESET;
        }  else {
            return TerminalANSI.BOLD +
                TerminalANSI.GREEN +
                "ESTABLE" +
                TerminalANSI.RESET;
        }
    }

    private void escribir(int fila, int columna, String texto){
        System.out.print(
            TerminalANSI.goTo(fila, columna) +
            texto
        );
    }

    private void dibujarMarco(){
        escribir(
            3,
            3,
            TerminalANSI.CYAN +
            "┌" + "─".repeat(88) + "┐" +
            TerminalANSI.RESET
        );
        for(int fila=4; fila<=25; fila++){
            escribir(
                fila,
                3,
                TerminalANSI.CYAN +
                "│" +
                TerminalANSI.RESET);
            escribir(
                fila,
                92,
                TerminalANSI.CYAN +
                "│" +
                TerminalANSI.RESET);
        }
        escribir(
            26,
            3,
            TerminalANSI.CYAN +
            "└" + "─".repeat(88) + "┘" +
            TerminalANSI.RESET
        );
        
    }

    public static void main(String[] args) {
        PantallaMision pm = new PantallaMision();
        pm.mostrar(new Personaje(
                    "Alex",
                    "Médico",
                    90,
                    6,
                    3), 
                3, 
                5,
                "Explorar vivienda", 
                20, 
                20, 
                100);
        new Scanner(System.in).nextLine();
    }
    

}
