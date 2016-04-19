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
public class Problema {
    	private Ciudad[] listaCiudades;
	private double[][] distancia;

	public Problema(int n){

	//	bla bla bla
	}

	public static Problema leerCiudades(scanner sc){
		String etiqueta;
		double x,y;


		sc.next();// esto hace que nos lea hasta el espacio en blanco.
		var= sc.nexInt;
		for(int i= 0;i<var;i++){
			etiqueta=sc.next();
			x=sc.nextDouble();
			y=sc.nextDouble();
			ciudad=new Ciudad(eqtiqueta,x,y);// cambiar x e y a punto
			analdirCiudad(ciudad);

		}
	}
        
        int getCiudadMasCercana(int posCiudad, Boolean[] visitados){
    
   // viitado es aun array que contiene las posciones de las ciudades visitadas
       //     un uno si la has visitado y un 0 si no la has visitado
    
    return 1;
    }
    
    
}
