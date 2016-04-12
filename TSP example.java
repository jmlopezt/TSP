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
		
		
		while(ciudadesRecorridas!=ciudades.size()-1){ //Cuando se hayan recorrido todas las ciudades el bucle while para.
		
			for (int i=0; i<ciudades.size();i++){
				distancia.add(i,ciudades.get(ciudadActual).getPosicion.distanciaEuclidea(ciudades.get(i).getPosicion));
				//"distancia" es un vector que contiene la distancia desde la ciudad inicial hasta cada una de las
				//ciudades que hay en la lista. En la posicion 0 esta la distancia desde ciudad 0 hasta ciudadInicial
				
			}
		//a continuación se calcula el mínimo valor de distancia, que sea distinto que cero y obtenemos su posición:
		//encontramos el valor minimo de distancia, y la posicion de distancia (posNext) se guarda "en ordenViaje"
		//seria algo asi: ordenViaje.add(posNext);
		
		//despues pasamos a la siguiente ciudad:
		posicionActual = ciudades.get(posNext).getPosicion;
		ciudadesRecorridas++;
		}
		
	return ordenViaje;	
	}
	
}

}

// hola hola
