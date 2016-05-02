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

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Esta clase almacenará un par (x,y) asociado a la posición de una ciudad
 * además de una etiqueta (String) asociada a cada ciudad
 * @author Juan Manuel López Torralba - Santiago Juárez Rodríguez
 */
public class Ciudad {
    
    private String etiqueta;
    private Punto posicion;
    
    Scanner numbin = new Scanner(System.in);  

    /**
     * Constructor de la clase Ciudad que inicializa a 0 tanto
     * la posición como su etiqueta
     */
    public Ciudad(){
        
        Punto punto=new Punto();
        posicion=punto;
        etiqueta="0";
    }
    
    /**
     * Constructor de Ciudad que se le pasa un objeto de la clase punto
     * conteniendo su posición, ademas de su etiqueta
     * @param nombre etiqueta de la ciudad
     * @param punto coordenadas x e y de la ciudad
     */
    public Ciudad(String nombre,Punto punto){
        
        this.etiqueta=nombre;
        this.posicion=punto;
    
    }
    
    /**
     * Método que lee la ciudad y sus parámetros desde la 
     * entrada 
     */
    public void LeeCiudad(){
        
        posicion.LeePunto();
        System.out.println("Introduce el nombre de la ciudad");
        etiqueta=numbin.next();     
    }
    
    /**
     * Método que escribe la ciudad y sus objetos por pantalla
     */
    public void EscribeCiudad(){
        
        posicion.EscribePunto();
        System.out.println("  "+etiqueta);
    }
    
    /**
     * Método que devuelve la posición de una ciudad
     * @return posicion coordenadas x e y de la ciudad
     */
    public Punto getPosicion(){
        
        return posicion;
    }
    /**
    * 
    * @param ciudad Objeto Ciudad 
    * @return  Devuelve la distancia entre dos ciudades, por ejemplo distancia=Ciudad1.calculaDistancia(Ciudad2) -Double
    */
    public double calculaDistancia(Ciudad ciudad){
        double dist=0;
        dist=Math.sqrt(Math.pow(getPosicion().ObtieneCoordenada_x()-ciudad.getPosicion().ObtieneCoordenada_x(), 2) + Math.pow(getPosicion().ObtieneCoordenada_y()-ciudad.getPosicion().ObtieneCoordenada_y(), 2));
        
        return dist;  
    }
 
}
