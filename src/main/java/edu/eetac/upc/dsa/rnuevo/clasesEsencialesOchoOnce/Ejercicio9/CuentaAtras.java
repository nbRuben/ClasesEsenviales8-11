package edu.eetac.upc.dsa.rnuevo.clasesEsencialesOchoOnce.Ejercicio9;
import java.io.IOException;
import java.lang.InterruptedException;


public class CuentaAtras  implements Runnable{

	private int segundos=0;
	private String id;
	Boolean zero = false;
	Thread t;
	
	public CuentaAtras(String id, int segundos){
		this.segundos=segundos;
		this.id=id;
		t = new Thread(this, id);
		t.start();
	}
	
	public void run(){
		try{
			while(zero==false){
				if(segundos!=0){
					System.out.println("El contador " +id + " tiene valor " +segundos);
					segundos--;
				}else{ 
					zero=true;
				}
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
