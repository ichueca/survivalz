package org.zabalburu.survivalz.ui;

import org.zabalburu.ichueca.terminalUtils.utils.TerminalANSI;
import org.zabalburu.ichueca.terminalUtils.utils.VisorImagenes;
import org.zabalburu.survivalz.domain.Personaje;


public class TarjetaJugador {
    private VisorImagenes visor;

    public TarjetaJugador(){
        this.visor = new VisorImagenes();
        visor.establecerTamaño(36,16);
        visor.alinearIzquierda();
    }

    public void mostrarPersonaje(Personaje personaje){
        System.out.println(
            TerminalANSI.RESET +
            TerminalANSI.CLEAR_SCREEN +
            TerminalANSI.GO_HOME
        );
    }

    public static void main(String[] args) {
        Personaje jugador = new Personaje(
            "Alex",
            "Médico",
            Personaje.VIDA_MAXIMA_MEDICO,
            Personaje.HABILIDAD_INICIAL_MEDICO,
            Personaje.BOTIQUINES_INICIALES_MEDICO
        );
        TarjetaJugador tj = new TarjetaJugador();
        tj.mostrarPersonaje(jugador);
    }

}
