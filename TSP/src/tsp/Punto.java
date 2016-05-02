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

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import java.util.*;

/**
 *La clase punto representa las coordenadas en 2D de un punto:
 * las coordenadas x e y.
 * @author Juan Manuel López Torralba - Santiago Juárez Rodríguez
 */
public class Punto {
 /*
  * Las coordenadas x e y son miembros privados de tipo double
  * y al ser privadas, solo los métodos de su propia clase tienen 
  * acceso a ellos.
 */
    Scanner numbin = new Scanner(System.in);       
    private double x,y;
    
    /**
    * Esto es un constructor que inicializa un punto con 
    * coordenadas (0,0)
    */
    Punto(){
        x=0;
        y=0;
    }
    
 /**
 * Los valores leídos de coordenada_x de coordenada_y se guardan 
 * en los datos miembro x e y.
 */
    Punto(double coordenada_x,double coordenada_y){
        this.x=coordenada_x;
        this.y=coordenada_y;
    }
    
    
 /**
 * Este método permite al usuario introducr las
 * coordenadas del punto separadas por espacios
 */
    Punto LeePunto(){
        System.out.println("Introduzca la coordenada X: ");
        try{
            x=numbin.nextDouble();
            System.out.println("Introduce coordenada en Y");
            y=numbin.nextDouble(); 
        }
        catch (InputMismatchException ex){
            System.out.println("Haga el favor de usar coma  no punto para los decimales, gracias");
        }
        Punto punto=new Punto(x,y);
        return punto;
    }
    
    
/**
 * Este método escribe en pantalla las coordenadas 
 * del punto separadas por espacios
 */
    void EscribePunto(){
        System.out.println(x+" "+y);
    }
    
    
/**
 * Estos métodos devuelven las coordenadas x e y 
 */
    double ObtieneCoordenada_x(){
        return x;
    }
    
    double ObtieneCoordenada_y(){
        return y;
    }
  
    /**
     * Este método obtiene la distancia euclidea entre un 
     * punto introducido y el que guarda la clase punto
     */
    double CalcDistEuclid(double a,double b){
        double distancia;
        distancia=Math.sqrt(pow(x-a,2)+ pow(y-b,2));
        return distancia;
    }
    
    
/**
 * Se obtiene el punto medio entre el introducido 
 * y el almacenado en punto, para ello obtengo 
 * el menor de los dos en cada coordenada con los bucles if
 * y luego se hace la operación
 */
    Punto PuntoMedio(double a,double b){
        double aux,aux2;
            if(x<a)
                aux=x;
            else
                aux=a;
            if(y<b)
                aux2=y;
            else
                aux2=b;
            
           Punto puntomedio=new Punto(aux+abs((x-a)/2),aux2+abs((y-b)/2));
           return puntomedio;
    }
}

