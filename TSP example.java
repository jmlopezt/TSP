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
	private int[] ruta;// este metodo devuelve la ruta calculada ya, pero no el string;n sino su posicion en el vector listaciudades.


}

}
