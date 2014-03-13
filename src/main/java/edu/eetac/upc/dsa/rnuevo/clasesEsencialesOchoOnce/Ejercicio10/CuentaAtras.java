package edu.eetac.upc.dsa.rnuevo.clasesEsencialesOchoOnce.Ejercicio10;

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
					System.out.print("El contador " +id + " tiene valor " +segundos +" - ");
					System.out.println("Ultima Escritura " + Ejercicio10.UltimaEscritura);
					segundos--;
					Ejercicio10.UltimaEscritura=this.id;
				}else{ 
					System.out.print("Ultima Escritura " + Ejercicio10.UltimaEscritura  + " - ");
					int i = t.activeCount()-2;
					System.out.println("Quedan " + i + " Threads activos");
					Ejercicio10.UltimaEscritura=this.id;
					zero=true;
				}
				Thread.sleep(1200);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
