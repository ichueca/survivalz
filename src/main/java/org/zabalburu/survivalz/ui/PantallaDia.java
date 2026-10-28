package org.zabalburu.survivalz.ui;

import org.zabalburu.ichueca.terminalUtils.utils.TerminalANSI;
import org.zabalburu.ichueca.terminalUtils.utils.VisorImagenes;

public class PantallaDia {

    private final VisorImagenes visor;

    public PantallaDia(){
        this.visor = new VisorImagenes();
        this.visor.establecerTamaño(80, 16);
        this.visor.alinearIzquierda();
    }

    public void mostrar(int dia, int totalDias){
        System.out.print(
            TerminalANSI.RESET +
            TerminalANSI.CLEAR_SCREEN +
            TerminalANSI.GO_HOME
        );

        escribir(1,3, 
            TerminalANSI.BOLD +
            TerminalANSI.CYAN +
            "Survival Z" +
            TerminalANSI.RESET
        );

        escribir(1,3, 
            TerminalANSI.BOLD +
            TerminalANSI.YELLOW +
            "DÍA " + dia + " DE " + totalDias +
            TerminalANSI.RESET
        );

        dibujarMarco();

        escribir(5,8, "");
        System.out.flush();

        visor.mostrar("imagenes/amanecer.png");

        escribir(22,8, 
            TerminalANSI.BOLD +
            TerminalANSI.CYAN +
            "UN NUEVO AMANECER" +
            TerminalANSI.RESET
        );

        escribir(24,8, 
            "La ciudad sigue en silencio. Comienza una nueva jornada"
        );

        escribir(28,3, 
            TerminalANSI.MAGENTA +
            "Pulsa INTRO para continuar" +
            TerminalANSI.RESET
        );
        System.out.flush();
    }

    private void dibujarMarco(){
        escribir(
            3,
            3,
            TerminalANSI.CYAN +
            "┌" + "─".repeat(88) + "┐" +
            TerminalANSI.RESET
        );
        for(int fila=4; fila<25; fila++){
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
            24,
            3,
            TerminalANSI.CYAN +
            "└" + "─".repeat(88) + "┘" +
            TerminalANSI.RESET
        );
        
    }

    private void escribir(int fila, int columna, String texto){
        System.out.print(
            TerminalANSI.goTo(fila, columna) +
            texto
        );
    }

    public static void main(String[] args) {
        new PantallaDia().mostrar(1, 5);
    }
}
