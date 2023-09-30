package controller;

import java.util.concurrent.Semaphore;

public class ThreadCooked extends Thread {

	private int idPrato;
	private Semaphore semaforo;

	public ThreadCooked(int idPrato, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}

	public void run() {
		Cozinha();
		try {
			semaforo.acquire();
			Entrega();
		} catch (InterruptedException e) {
			System.err.println(e);
		}finally {
			semaforo.release();
		}
	}

	private void Entrega() {
		if (idPrato % 2 == 0) {
			System.out.println("A Sopa de Cebola está sendo entregue.");
			try {
				sleep(500);
				System.out.println("A Sopa de Cebola foi entregue");
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		} else {
			System.out.println("A Lasanha de Bolonhesa está sendo entregue.");
			try {
				sleep(500);
				System.out.println("A Lasanha de Bolonhesa foi entregue");
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}

	}

	private void Cozinha() {
		if (idPrato % 2 == 0) {
			int random = (int) (Math.random() * 300) + 500;
			int porcentagem = random / 10;
			int porcAtual = 0;
			System.out.println("O cozimento da Sopa de Cebola começou!");
			for (int i = 0; i < 10; i++) {
				try {
					sleep(porcentagem);
					porcAtual += 10;
					System.out.println("A porcentagem do cozimento do prato Sopa de Cebola é de " + porcAtual + "%.");
				} catch (InterruptedException e) {
					System.err.println(e);
				}
			}
			System.out.println("A Sopa de Cebola está pronta");
		} else {
			int random = (int) (Math.random() * 600) + 600;
			int porcentagem = random / 10;
			int porcAtual = 0;
			System.out.println("O cozimento da Lasanha de Bolonhesa começou!");
			for (int i = 0; i < 10; i++) {
				try {
					sleep(porcentagem);
					porcAtual += 10;
					System.out.println(
							"A porcentagem do cozimento do prato Lasanha de Bolonhesa é de " + porcAtual + "%.");
				} catch (InterruptedException e) {
					System.err.println(e);
				}
			}
			System.out.println("A Lasanha de Bolonhesa está pronta.");
		}

	}

}
