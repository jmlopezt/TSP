/*
***************************************************************
 ************** Juan Manuel López Torralba ********************
 ************** Santiago Juárez Rodríguez *********************
 **************************************************************
 * 4ºCurso Grado Ingeniería de Tecnología de Telecomunicación *
 * ******** Especialidad: Sistemas de Telecomunicación ********
 ********* Asignatura: CP (Complementos de Programación) ******
 ***************** Optativa Telemática ************************
 **************************************************************
 */
package tsp;

import java.util.Scanner;

/**
 *
 * @author Juanma
 */
public class TSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 
        Ruta ruta=new Ruta(0);
        Scanner sc = null;
        Problema problema=new Problema(0,null,null);
        problema.leerCiudades(sc);
        HeuristicaVecinoMasCercano solucionHeuristica = new HeuristicaVecinoMasCercano(problema);
        ruta = solucionHeuristica.obtenerMejorRuta();
        double coste;
        coste = problema.coste(ruta);
    }
    
}
