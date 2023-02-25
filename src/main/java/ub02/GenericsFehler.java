package ub02;
public class GenericsFehler{
	public static void main(String[] args){
		MyObject mo = new MyObject(); //MyObjet Instanz wird erstellt und in der Variable mo gespeichert
		MyGeneric<String> mg = new MyGeneric<>(); //MyGeneric<String> Instanz wird erstellt und in 
												//Variable mg gespeichert
		String s1 = "Hallo";	/*In die String Variable s1 wird "Hallo" gespeichert*/
		Integer i1 = 42; //In die Integer Variable i1 wird 42 gespeichert

		mo.set(i1); //Der Methode set der MyObject Instanz wird i1 als Referenz übergeben. 
		mo.set(s1); //Der Methode set der MyObject Instanz wird s1 = "Hallo" übergeben. 
		s1 = "Hello";
        String s2 = (String) mo.get(); 
		/*	Die Methode get der MyObject Instanz mo gibt den gespeicherten wert "Hello"
		*	zurück. Dieser wird in die String Variable s2 gespeichert. 
		*	Davor wird der in ein String gecastet.							
		*/

		mg.set(s1); //Der Methode set der MyGeneric<String> Instanz wird s1 = "Hallo" übergeben.
		//mg.set(i1);				//Hier würde ein Fehler auftreten: i1 ist ein Integer!
		String s3 = mg.get();	
					//		Integer i3 = (Integer)mg.get(); 
					
		System.out.println(s2 + ", " + s3);
	}	
}

/** This class is a simplified 'container' for objects of type Object
    thus all subtypes of Object can be stored
    so in Java every kind of type   */
class MyObject{
	private Object o;
	public void set(Object o){
		this.o = o;
	}
	public Object get(){
		return o;
	}
}

/** This is a simple container for storing an object of a generic type
    so any given type (and it's subclasses) */
class MyGeneric<T>{
	private T o;
	public void set(T o){
		this.o = o;
	}
	public T get(){
		return o;
	}
}