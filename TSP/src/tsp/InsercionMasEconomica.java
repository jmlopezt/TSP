//Visualizacion grafica de la solucion

// MEJORAS PROPUESTAS

//1. Estrategias de insercion

public class InsercionMasEconomica{
	private Ruta ruta;
	//Hay que obtener una ruta inicial que es la siguiente: coordY mayor--coordX mayor--coordX menor
	
	public Ruta obtenerRutaInicial(ArrayList ciudades){
		Ruta ordenViaje = new Ruta();
		int yMax,xMax,xMin;
		int pos1,pos2,pos3;
		yMax=0;
		xMax=0;
		xMin=0;
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
		ordenViaje.add(pos1);
		ordenViaje.add(pos2);
		ordenViaje.add(pos3);
		
		return ordenViaje;
	}
	
	public Ruta obtenerRutaEconomica(ArrayList ciudades){
		//rutaInicial=ordenViaje (el triangulo calculado anteriormente)
		Ruta rutaInicial = new Ruta();
		Ruta rutaFinal = new Ruta();
		Ruta rutaAux = new Ruta();
		rutaInicial=obtenerRutaInicial(ciudades);
		
		//creamos una ruta auxiliar con las ciudades no pertenecientes a la ruta inicial
		rutaAux=obtenerMejorRuta(ArrayList ciudades);
		//a esta ruta auxiliar hay que quitarle las ciudades que pertenecen a la ruta inicial
		for (int i=0;i<rutaInicial.size(); i++){
			rutaAux.remove(rutaInicial.get(i));
		}
		//Por ultimo, "unimos" ruta inicial con la auxiliar
		for (int j=0;j<rutaInicial.size(); j++){
			rutaFinal.add(rutaInicial.get(j));
		} 
		for (int k=rutaInicial.size();k<rutaInicial.size()+rutaAux.size()-1; i++){
			rutaFinal.add(rutaAux.get(k));
		}
		return rutaFinal;
	}
	
	
}

