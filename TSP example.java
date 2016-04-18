public class Ciudad {
	private string etiqueta;
	private double x,y;
	
	Punto getPosicion(){
		Punto posicion = new Punto();
		posicion.x=x;
		posicion.y=y;
		return posicion; //ESTA PARTE CREO QUE NO LA HE HECHO BIEN
	}
}

public class Problema {
	private Ciudad[] listaCiudades;
	private double[][] distancia;

	public Problema(int n){

		bla bla bla
		//METE AQUI LO QUE PUSO EL PROFESOR EN CLASE EL MARTES 12
	}

	public static Problema leerCiudades(scanner sc){
		string etiqueta;
		double x,y;


		sc.next();// esto hace que nos lea hasta el espacio en blanco.
		var= sc.nexInt;
		for(int i= 0;i<var;i++){
			etiqueta=sc.next();
			x=sc.nextDouble();
			y=sc.nextDouble();
			ciudad=new Ciudad(eqtiqueta,x,y);
			analdirCiudad(ciudad);
		}
	}
	public static int getNumeroCiudades(){
		int nCiudades=ciudades.size(); //hay que crear un arrayList que se llame cuidades donde 
					       //metemos la posicion y el nombre de cada ciudad
	}
	
	public static Ciudad getCiudad(int pos){
		Ciudad ciudadAux= new Ciudad();
		ciudadAux= ciudades.get(pos);
		return ciudadAux;
	}
	
	public double getDistancia(int pos1, int pos2){
		double distancia;
	 	Ciudad ciudadAux1 = new Ciudad();
	 	Ciudad ciudadAux2 = new Ciudad();
	 	
	 	ciudadAux1= ciudades.get(pos1);
		ciudadAux2= ciudades.get(pos2);
		
		distancia= ciudadAux1.getPosicion.distanciaEublidea(ciudadAux2.getPosicion);
		
		return distancia;
	}
	
	

			
	}

public class Ruta {
	
	private int[] ruta;//que sea mejor un arrayList
	// este metodo devuelve la ruta calculada ya, pero no el string;n sino su posicion en el vector listaciudades.
	
	private int nCiudades; //ciudades.size
}

public class HeuristicaVecinoMasCercano {

	private Ruta ruta;
	
	public Ruta obtenerMejorRuta(ArrayList ciudades){
		Ruta ordenViaje = new Ruta();
		Ciudad ciudadActual; // hay que introducir la ciudad desde donde sale el comerciante.
					//Creo que esto se añade en otra clase que pida la ciudad inicial.
		Punto posicionActual = new Punto();
		posicionActual = ciudadActual.getPosicion;
		ordenViaje.add(0,posicionActual);
		int ciudadesRecorridas = 0;
		ArrayList<double> distancia = new ArrayList<double>();
		int posNext;
		
		while(ciudadesRecorridas!=ciudades.size()-1){ //Cuando se hayan recorrido todas las ciudades el bucle while para
		
		
			for (int i=0; i<ciudades.size();i++){
				distancia.add(i,ciudades.get(ciudadActual).getPosicion.distanciaEuclidea(ciudades.get(i).getPosicion));
				/*"distancia" es un vector que contiene la distancia desde la ciudad inicial hasta cada una de las
				ciudades que hay en la lista. En la posicion 0 esta la distancia desde ciudad 0 hasta ciudadInicial*/
				
			}
		/*a continuación se calcula el mínimo valor de distancia, que sea distinto que cero y obtenemos su posición:
		encontramos el valor minimo de distancia, y la posicion de distancia (posNext) se guarda "en ordenViaje"
		seria algo asi: ordenViaje.add(posNext);*/
			for (int j=0;j<distancia.size()-2;j++){
				if(distancia.get(j)!=0){ /*si la distancia es 0 es que se esta calculando la distancia entre
				ciudadActual y ciudadActual*/
					if (distancia.get(j)<distancia.get(j+1)){
						posNext=j;		//posNext=siguiente ciudad a la que va el viajero.
					}	
				}
			}
		
		/*Antes de calcular la distancia entre ciudades, hay que eliminar del arrayList llamado "ciudades" las ciudades que
		se han recorrido porque puede haber un caso en el que la distancia mas pequeña sea a una ciudad ya recorrida y, por
		tanto se esta haciendo mal el problema. */
		ciudades.remove(posicionActual);
		ordenViaje.add(posNext);
		//despues pasamos a la siguiente ciudad:
		posicionActual = ciudades.get(posNext).getPosicion;
		ciudadesRecorridas++;
		}
		ordenViaje.add(ciudades.size(),ordenViaje.get(0)); /*Se añade en la ruta la ciudad inicial, que es a la que hay que
		volver una vez finalizado el viaje*/
	return ordenViaje;
	//Esta clase esta casi terminada (o casi) yo creo.
	}
	
}

}
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


