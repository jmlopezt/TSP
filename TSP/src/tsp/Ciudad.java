package tsp;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juanma
 */
public class Ciudad {
    
    private String etiqueta;
    private Punto posicion;
    
    Scanner numbin = new Scanner(System.in);  

    
    Ciudad(){
        
        Punto punto=new Punto();
        posicion=punto;
        etiqueta="0";
    }
    
    Ciudad(String nombre,Punto punto){
        
        this.etiqueta=nombre;
        this.posicion=punto;
    
    }
    
    void LeeCiudad(){
        
        posicion.LeePunto();
        System.out.println("Introduce el nombre de la ciudad");
        etiqueta=numbin.next();     
    }
    
    void EscribeCiudad(){
        
        posicion.EscribePunto();
        System.out.println("  "+etiqueta);
    }
    
    Punto getPosicion(){
        
        return posicion;
    }
}
