package org.zabalburu.survivalz;

import java.util.Scanner;

import org.zabalburu.ichueca.terminalUtils.utils.TerminalANSI;
import org.zabalburu.survivalz.domain.Personaje;
import org.zabalburu.survivalz.domain.Zombie;
import org.zabalburu.survivalz.ui.TarjetaJugador;

public class Main {

    public static final int TIPO_MEDICO = 1;
    public static final int TIPO_POLICIA = 2;
    public static final int TIPO_BOMBERO = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println(TerminalANSI.CYAN +"""
            =========================
                   SURVIVAL Z 
            =========================
        """ + TerminalANSI.RESET);
        
        

        System.out.println("Nombre");
        String nombre = sc.nextLine();
        System.out.println("""
           Selecciona una clase:

            1️⃣ Médico
            2️⃣ Policía
            3️⃣ Bombero 
            
        """);
        int tipo = sc.nextInt();
        sc.nextLine();

        int vida;
        int habilidad;
        int botiquines;
        String tipoTexto;

        switch (tipo) {
            case TIPO_MEDICO:
                tipoTexto = "Médico";
                vida = Personaje.VIDA_MAXIMA_MEDICO;
                habilidad = Personaje.HABILIDAD_INICIAL_MEDICO;
                botiquines = Personaje.BOTIQUINES_INICIALES_MEDICO;
                break;
            case TIPO_BOMBERO:
                tipoTexto = "Bombero";
                vida = Personaje.VIDA_MAXIMA_BOMBERO;
                habilidad = Personaje.HABILIDAD_INICIAL_BOMBERO;
                botiquines = Personaje.BOTIQUINES_INICIALES_BOMBERO;
                break;
            //case TIPO_POLICIA:
            default:
                tipoTexto = "Policía";
                vida = Personaje.VIDA_MAXIMA_POLICIA;
                habilidad = Personaje.HABILIDAD_INICIAL_POLICIA;
                botiquines = Personaje.BOTIQUINES_INICIALES_POLICIA;
                break;
        }



        Personaje personaje = new Personaje(
                nombre,
                tipoTexto,
                vida,
                habilidad,
                botiquines);

        TarjetaJugador tj = new TarjetaJugador();
        tj.mostrarPersonaje(personaje);

        for (int i=0; i<5; i++) {
            System.out.println(new Zombie());
        }

    }
}