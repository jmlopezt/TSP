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

import java.util.ArrayList;
import java.util.Collections;

/**
 * Esta clase implementa distintos algoritmos para resolver la ruta
 * a escoger
 * @author  Juan Manuel López Torralba - Santiago Juárez Rodríguez
 */
public class Heuristica {
    private Problema problema;
    private Ruta mejorRuta,ordenViaje;
   // private Boolean[] visitados;
	
    /**
     * Constructor vacío de Heurística
     */
    public Heuristica(){
    
        problema=null;
        mejorRuta=null;
        ordenViaje=null;
    }
    
    /**
     * Constructor de la clase heurística
     * @param p
     */
    public Heuristica(Problema p){
        
        problema=p;
    }

    /**
     * Este método resuelve la ruta mediante la Heurística del vecino
     * más cercano
     * @return mejorRuta
     */
    public Ruta obtenerRutaAlgoritmo1(){
        
        ArrayList<Ciudad> listaCiudadesAux = new ArrayList<>();
        listaCiudadesAux=problema.getListaCiudades();
        Boolean[] visitados;
        Ciudad ciudadInicial=new Ciudad();
        int anteriorCiudad;
        
        //Bucle para probar con todas las ciudades i como ciudad inicial
        for (int i=0;i<listaCiudadesAux.size();i++){
            
            visitados=new Boolean[listaCiudadesAux.size()];
            ciudadInicial=listaCiudadesAux.get(i);
            Ruta rutaActual=new Ruta(listaCiudadesAux.size());
            
            rutaActual.addCiudad(i);
            anteriorCiudad=i;
            visitados[anteriorCiudad]=true;
            
            for(int j=0;j<listaCiudadesAux.size()-1;j++){
                
                int ciudadMasCercana=problema.getCiudadMasCercana(anteriorCiudad, visitados);
                anteriorCiudad=ciudadMasCercana;
                visitados[ciudadMasCercana]=true;
                rutaActual.addCiudad(ciudadMasCercana);
            }
            if (problema.coste(mejorRuta)<problema.coste(rutaActual)){
                
                mejorRuta=rutaActual;
            }
        }	
	return mejorRuta;
    }
    /**
     * Este metodo calcula una ruta inicial triangular que consta de la ciudad
     * con la mayor coordenada Y, mayor coordenada X y menor coordenada X.
     * @param problema
     * @return mejorRuta
     * 
     */
    public Ruta obtenerRutaInicial(Problema problema){
        
        ArrayList<Ciudad> listaCiudadesAux = new ArrayList<>();
        listaCiudadesAux=problema.getListaCiudades();
	Ruta ordenViaje = new Ruta(listaCiudadesAux.size());
	double yMax =listaCiudadesAux.get(0).getPosicion().ObtieneCoordenada_y();
        double xMax =listaCiudadesAux.get(0).getPosicion().ObtieneCoordenada_x();
        double xMin =listaCiudadesAux.get(0).getPosicion().ObtieneCoordenada_x();
	int pos1=0,pos2=0,pos3=0;
        
		//Buscamos la coordenada Y mayor.
	for (int i=1;i<listaCiudadesAux.size();i++){
            if(listaCiudadesAux.get(i).getPosicion().ObtieneCoordenada_y()> yMax ){
		yMax=listaCiudadesAux.get(i).getPosicion().ObtieneCoordenada_y();
                pos1=i;
           //     visitados[i]=true;
            }
	}
		//Buscamos la coordenada X mayor.
	for (int j=1;j<listaCiudadesAux.size();j++){
            if(listaCiudadesAux.get(j).getPosicion().ObtieneCoordenada_x()> xMax ){
		xMax=listaCiudadesAux.get(j).getPosicion().ObtieneCoordenada_x();
                pos2=j;
            //    visitados[j]=true;
            }
	}
                //Buscamos la coordenada X menor.
	for (int k=1;k<listaCiudadesAux.size();k++){
            if(listaCiudadesAux.get(k).getPosicion().ObtieneCoordenada_x()< xMin ){
		xMin=listaCiudadesAux.get(k).getPosicion().ObtieneCoordenada_x();
                pos3=k;
          //      visitados[k]=true;
            }
	}
        
	ordenViaje.addCiudad(pos1);
	ordenViaje.addCiudad(pos2);
	ordenViaje.addCiudad(pos3);
		
	return ordenViaje;
    }
    /**
     * A partir de la ruta inicial calculada anteriormente, se obtiene una ruta 
     * con el método de la insercion más económica, donde se añade una ciudad a 
     * la ruta si cumple el requisito de que la distancia desde la ciudad actual 
     * a la ciudad propuesta es menor que la del triangulo inicial
     * @param problema
     * @return mejorRuta
     */
    public Ruta insercionEconomica(){
        
        int nCiudades=problema.getNumeroCiudades();
        int anteriorCiudad;
        
        Ciudad ciudadInicial = new Ciudad();
        Ciudad ciudadAux = new Ciudad();     
        
        ArrayList<Ciudad> listaCiudadesAux = new ArrayList<>();
        
        listaCiudadesAux=problema.getListaCiudades();
        
        Boolean[] visitados = new Boolean[nCiudades];
        
        Ruta rutaInicial = new Ruta(0);
        Ruta rutaAux = new Ruta(nCiudades);
        
		//rutaInicial=ordenViaje (el triangulo calculado anteriormente)
	rutaInicial=obtenerRutaInicial(problema);
                // Registramos el triangulo inicial en el booleano visitados
        for (int i=0;i<2;i++){
            
            visitados[(Integer)rutaInicial.getRuta().get(i)]=true;  
        }
                // Ahora elegímos qué ciudad insertar y dónde hacerlo
            
                // La ruta inicial tiene un ruta preestablecida por defecto que
                // corresponde con el triuangulo de mayor extensión.
                // Por lo tanto comenzando con la posición 1, inamovible que es
                // la ciudad más alta (coordenada y mayor), obtengo aquella ciudad
                // no vistada cuya distancia euclidea es menor que la del triangulo
                // inicial
        ciudadInicial=listaCiudadesAux.get(0);
        rutaAux=rutaInicial;
        
        int indexOfCityRef=1;
        
        for(int count=0;count<rutaInicial.getNumberCiudadesVisitadas();count++){
            
            for (int i=0;i<nCiudades;i++){
            
                ciudadInicial=listaCiudadesAux.get(i);
                double dist=0.0;
                if(visitados[i]==true){
            
                    int cityCloserAux=problema.getCiudadMasCercana(i, visitados);
                    ciudadAux=listaCiudadesAux.get(cityCloserAux);
                    dist=ciudadInicial.calculaDistancia(ciudadAux);
                    
                    if(dist<ciudadInicial.calculaDistancia(listaCiudadesAux.get(rutaInicial.getPosCiudad(indexOfCityRef)))){
                        
                        if(visitados[cityCloserAux]==false){
                            rutaAux.addCiudadInLocation(i+1, cityCloserAux);
                            visitados[(Integer)rutaAux.getRuta().get(i+1)]=true;  
                        }
                    }
                }
             
            }
            indexOfCityRef++;
            if(indexOfCityRef==3){
                
                indexOfCityRef=0;
            }
        }
            mejorRuta=rutaAux;
            return mejorRuta; 
	}
    /**
    * A partir de la ruta inicial calculada en obtenerRutaInicial, se obtiene una ruta 
    * con el método de la insercion más lejana, donde se añade una ciudad a 
    * la ruta si cumple el requisito de que la distancia desde la ciudad actual 
    * a la ciudad propuesta es mayor que la del triangulo inicial
    * @return mejorRuta 
    */
    public Ruta insercionLejana (){
        
        int nCiudades=problema.getNumeroCiudades();
        
        Ciudad ciudadInicial = new Ciudad();
        Ciudad ciudadAux = new Ciudad();     
        
        ArrayList<Ciudad> listaCiudadesAux = new ArrayList<>();
        
        listaCiudadesAux=problema.getListaCiudades();
        
        Boolean[] visitados = new Boolean[nCiudades];
        
        Ruta rutaInicial = new Ruta(0);
        Ruta rutaAux = new Ruta(nCiudades);
        
		//rutaInicial=ordenViaje (el triangulo calculado anteriormente)
	rutaInicial=obtenerRutaInicial(problema);
                // Registramos el triangulo inicial en el booleano visitados
        for (int i=0;i<2;i++){
            
            visitados[(Integer)rutaInicial.getRuta().get(i)]=true;  
        }
                // Ahora elegímos qué ciudad insertar y dónde hacerlo

        ciudadInicial=listaCiudadesAux.get(0);
        rutaAux=rutaInicial;
        
        int indexOfCityRef=1;
        
        for(int count=0;count<rutaInicial.getNumberCiudadesVisitadas();count++){
            
            for (int i=0;i<nCiudades;i++){
            
                ciudadInicial=listaCiudadesAux.get(i);
                double dist=0.0;
                if(visitados[i]==true){
            
                    int cityCloserAux=problema.getCiudadMasCercana(i, visitados);
                    ciudadAux=listaCiudadesAux.get(cityCloserAux);
                    dist=ciudadInicial.calculaDistancia(ciudadAux);
                    
                    if(dist>ciudadInicial.calculaDistancia(listaCiudadesAux.get(rutaInicial.getPosCiudad(indexOfCityRef)))){
                        
                        if(visitados[cityCloserAux]==false){
                            rutaAux.addCiudadInLocation(i+1, cityCloserAux);
                            visitados[(Integer)rutaAux.getRuta().get(i+1)]=true;  
                        }
                    }
                }
             
            }
            indexOfCityRef++;
            if(indexOfCityRef==3){
                
                indexOfCityRef=0;
            }
        }
            mejorRuta=rutaAux;

        return mejorRuta;
    }
    
    /**
     * En este metodo se calculan k ruta aleatorias y nos devuelve la ruta que 
     * presente menor coste
     * @return mejorRuta 
     */
    public Ruta obtenerRutaAlgoritmo4 (){
        
        int nCiudades=problema.getNumeroCiudades();
        int k=10000;
        Ruta rutaActual = new Ruta(nCiudades);
       
        //Ruta inicial
        for (int i=0; i<nCiudades; i++){
            rutaActual.addCiudad(i);
        }
        
        //Hay que crear k rutas aleatorias
        for (int i=0; i<k; i++){
            Collections.shuffle(rutaActual.getRuta()); //Obtenemos una ruta aleatoria con shuffle

            if (problema.coste(mejorRuta)<problema.coste(rutaActual)){
                
                mejorRuta=rutaActual;
            }

        }
        return mejorRuta;

    }
    /**
     * Metodo que obtiene una ruta aleatoria a la que se le realizan adiciones.
     * Se calcula el coste de la ruta con adición y sin adición y nos quedamos 
     * con la ruta de menor coste.
     * @return mejorRuta
     */
    public Ruta obtenerRutaAlgoritmo5 (){
        
        int contadorNoMejora = 0;
        int nIteraciones=100;
        int nCiudades=problema.getNumeroCiudades();
        int k=10000;
        Ruta rutaActual = new Ruta(nCiudades);
       
        //Ruta inicial
        for (int i=0; i<nCiudades; i++){
            rutaActual.addCiudad(i);
        }

        Collections.shuffle(rutaActual.getRuta());
        mejorRuta =rutaActual;
        do{
            Collections.shuffle(rutaActual.getRuta());
            mejorarLocalmente(rutaActual);
        if (problema.coste(rutaActual) < problema.coste(mejorRuta)) {
            mejorRuta =rutaActual;
            contadorNoMejora = 0;
        }
        else{
            contadorNoMejora++;
        }
        }while (contadorNoMejora < nIteraciones);
        
        return mejorRuta;
    }
    
    /**
     * Metodo utilizado en el metodo anterior para realizar las adiciones de 
     * ciudades a la ruta
     * @param ruta
     * @return ruta 
     */
    public Ruta mejorarLocalmente (Ruta ruta){
        
        Ruta rutaAux=new Ruta(ruta.getNumberCiudadesVisitadas());
        rutaAux=ruta;
        
        for (int i=0;i<ruta.getRuta().size();i++){
            int j=i+2;
            rutaAux.getRuta().add(i+1, ruta.getRuta().get(j));
            rutaAux.getRuta().remove(j);
            if (problema.coste(rutaAux) < problema.coste(mejorRuta)) {
            
                    ruta =rutaAux;
            }
        }
    
        return ruta;
    }
}

