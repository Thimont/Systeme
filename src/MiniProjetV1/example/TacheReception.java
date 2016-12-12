package MiniProjetV1.example;

import MiniProjetV1.example.SimpleFenetre;

public class TacheReception extends Thread {
	SimpleFenetre fenetre;

	public TacheReception() {
		fenetre = new SimpleFenetre("RECEPTION");
	}

	public void run() {
		int i = 0;
		fenetre.setVisible(true);
		while (1 == 1) {

			fenetre.updateMessage("RECEPTION" + i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}
