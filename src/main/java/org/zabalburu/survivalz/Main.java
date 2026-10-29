package org.zabalburu.survivalz;

import java.util.Scanner;

import org.zabalburu.ichueca.terminalUtils.utils.TerminalANSI;
import org.zabalburu.survivalz.domain.Personaje;
import org.zabalburu.survivalz.domain.Zombie;
import org.zabalburu.survivalz.ui.PantallaDia;
import org.zabalburu.survivalz.ui.TarjetaJugador;

public class Main {

    public static final int TIPO_MEDICO = 1;
    public static final int TIPO_POLICIA = 2;
    public static final int TIPO_BOMBERO = 3;
    private static final int TOTAL_DIAS = 5;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(TerminalANSI.CYAN +"""
            =========================
                   SURVIVAL Z 
            =========================
        """ + TerminalANSI.RESET);
        
        

        System.out.println("Nombre");
        String nombre = teclado.nextLine();
        System.out.println("""
           Selecciona una clase:

            1️⃣  Médico
            2️⃣  Policía
            3️⃣  Bombero 
            
        """);
        int tipo = teclado.nextInt();
        teclado.nextLine();

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
        System.out.println("Pulsa INTRO para comenzar la aventura...");
        teclado.nextLine();

        PantallaDia pantallaDia = new PantallaDia();

        for(int dia=1; dia <= TOTAL_DIAS; dia++){
            pantallaDia.mostrar(dia, TOTAL_DIAS);
            mostrarEstado(personaje);
            teclado.nextLine();
            realizarMisionesDiarias(dia);
            teclado.nextLine();
        }

    }

    private static void mostrarEstado(Personaje personaje) {
        if (personaje.getVida() < 30){
            System.out.println("🚨  ESTADO CRÍTICO");
        } else if (personaje.getVida() < 70){
            System.out.println("⚠️  HERIDO");
        } else {
            System.out.println("✅  ESTABLE");
        }
        System.out.println("🩹  Botiquines: %d".formatted(personaje.getBotiquines()));
    }

    private static String obtenerNombreMision(){
        int opcion = (int) (Math.random() * 2) + 1;
        return switch(opcion){
            case 1 -> "Combatir zombis";
            default -> "Explorar vivienda";
        };
    }

    private static int generarPuntosMision() {
        return (int) (Math.random() * 21) + 10;
    }

    private static void realizarMisionesDiarias(int dia) {
        int puntos = 0;

        System.out.println();
        System.out.println("📆  DÍA " + dia);
        System.out.println("Objetivo: conseguir 100 puntos.");
        System.out.println();
        do {
            String mision = obtenerNombreMision();
            int puntosMision = generarPuntosMision();

            puntos += puntosMision;

            System.out.println("Misión: " + mision);
            System.out.println("Puntos obtenidos: " + puntosMision);
            System.out.println("Puntos acumulados: %d / 100".formatted(puntos ));
            System.out.println();
        } while (puntos <= 100);
        System.out.println("🎯  ¡Objetivo diario conseguido!");
    }

}