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
 * Esta clase es la encargada de ejecutar los diferentes metodos de las otras 
 * clases para mostrar una solucion final.
 * Dependiendo de los argumentos de entrada, se mostrarán cierta informaciones
 * de la ruta o ejecutará un determinado algoritmo. 
 * 
 * Para más información, consultar la documentación disponible en el documento
 * "Manual de usuario".
 * 
 * @author Juan Manuel López Torralba - Santiago Juárez Rodríguez
 * 
 */
public class TSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 
        Problema problema;
        Ruta mejorRuta;
        boolean solución=false;
        boolean ruta=false;
        boolean coste=false;
        int algo=1;
        
        Scanner sc = null;
        problema.leerCiudades(sc);
        Heuristica solucionHeuristica = new Heuristica(problema);
        ruta = solucionHeuristica.obtenerMejorRuta();
        double coste;
        coste = problema.coste(ruta);
    }
    
}
