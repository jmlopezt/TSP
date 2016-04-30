

package tsp;
import java.util.ArrayList;
public class InsercionMasEconomica{
	private Ruta ordenViaje;
	private Problema problema;
	//Hay que obtener una ruta inicial que es la siguiente: coordY mayor--coordX mayor--coordX menor
	public InsercionMasEconomica(Problema p){
		problema = p;
	}

	public Ruta obtenerRutaInicial(ArrayList<Ciudad> ciudades){
		Ruta ordenViaje = new Ruta(ciudades.size());
		int yMax,xMax,xMin;
		int pos1=0,pos2=0,pos3=0;
		//Buscamos la coordenada Y mayor.
		for (int i=0;i<ciudades.size()-2;i++){
			if(ciudades.get(i).getPosicion.obtenerY()>ciudades.get(i+1).getPosicion.obtenerY()){
				yMax=ciudades.get(i).getPosicion.obtenerY();
				pos1=i;
			}
		}
		//Buscamos la coordenada X mayor.
		for (int j=0;j<ciudades.size()-2;j++){
			if(ciudades.get(j).getPosicion.obtenerY()>ciudades.get(j+1).getPosicion.obtenerY()){
				yMax=ciudades.get(j).getPosicion.obtenerY();
				pos2=j;
			}
		}
		//Buscamos la coordenada X menor.
		for (int k=0;k<ciudades.size()-2;k++){
			if(ciudades.get(k).getPosicion.obtenerY()>ciudades.get(k+1).getPosicion.obtenerY()){
				yMax=ciudades.get(k).getPosicion.obtenerY();
				pos3=k;
			}
		}
		ordenViaje.addCiudad(pos1);
		ordenViaje.addCiudad(pos2);
		ordenViaje.addCiudad(pos3);
		
		return ordenViaje;
	}
	
	public Ruta obtenerRutaEconomica(ArrayList<Ciudad> ciudades){
		//rutaInicial=ordenViaje (el triangulo calculado anteriormente)
		Ruta rutaInicial = new Ruta(0);
		Ruta rutaFinal = new Ruta(0);
		Ruta rutaAux = new Ruta(0);
		rutaInicial=obtenerRutaInicial(ciudades);
                Boolean[] visitados = new Boolean[ciudades.size()];
                //Ahora ponemos la ciudades visitadas, las de la ruta inicial
                visitados[rutaInicial.getRuta().get(1)]=true;
                //En los corchetes quiero poner las ciudades que pertenecen a la
                //ruta inicial pero me da error
            
                //Una vez que se han puesto las ciudades visitadas creo que se
                //hace la heuristicavecinomascercano
           
	}
}

