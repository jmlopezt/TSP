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
        
        Ruta ruta=null;
        Heuristica Heuristica=new Heuristica();
        Problema problema=new Problema();
 
        boolean argsolucion=false,argruta=false,argcoste=false,argAlg1=false,argAlg2=false,argAlg3=false
                ,argAlg4=false,argAlg5=false;

        long time_start, time_end;
        
        Scanner sc = new Scanner(System.in);
        problema.leerCiudades(sc);
        
        for (int i=0; i<args.length;i++){
            
            if(args[i].equals("solucion")){
                argsolucion=true;
            }		
            if(args[i].equals("ruta")){
                argruta=true;
            }		
            if(args[i].equals("coste")){
                argcoste=true;			
            }
                if(args[i].equals("solAlg1")){
                    argAlg1=true;			
                }
                if(args[i].equals("solAlg2")){
                    argAlg2=true;			
                }
                if(args[i].equals("solAlg3")){
                    argAlg3=true;			
                }
                if(args[i].equals("solAlg4")){
                    argAlg4=true;			
                }
            
        }
        time_start=System.currentTimeMillis();     

            if (argAlg1) {
                ruta = Heuristica.obtenerRutaAlgoritmo1(problema);
            }
            if (argAlg2){
                ruta = Heuristica.insercionEconomica(problema);
            }
            if (argAlg3){
                ruta = Heuristica.insercionLejana(problema);
            }
            if (argAlg4){
                ruta = Heuristica.obtenerRutaAlgoritmo4(problema);
               }
            if (argAlg5){
                ruta = Heuristica.obtenerRutaAlgoritmo5(problema);
            }
           
        time_end=System.currentTimeMillis(); 

     //   coste = problema.coste(mejorRuta);    
  
        if(argcoste){
            double coste=problema.coste(ruta);
            System.out.println("El coste de la ruta es "+"  =  "+coste);
        }
        if(argruta){ 
           ruta.muestraruta();
        }
        if(argsolucion){
            problema.muestraCoordenadasRuta(ruta);
        }
       
        System.out.println("El tiempo de ejecución del algoritmo seleccionado es: "+(time_end-time_start)+" milisegundos");
 
    }
}
    