package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCooked;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for(int i = 1 ; i < 6 ; i ++ ) {
			Thread tc = new ThreadCooked(i, semaforo);
			tc.start();
		}

	}

}
