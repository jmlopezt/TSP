/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

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
        HeuristicaVecinoMasCercano solucionHeuristica = new HeuristicaVecinoMasCercano(null);
        Problema problema=new Problema(0,null,null);
        problema.leerCiudades();
        solucionHeuristica = HeuristicaVecinoMasCercano(problema);
        ruta = solucionHeuristica.obtenerMejorRuta();
        double coste;
        coste = problema.coste(ruta);
    }
    
}
