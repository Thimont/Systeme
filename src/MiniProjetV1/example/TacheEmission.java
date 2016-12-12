package MiniProjetV1.example;

import MiniProjetV1.example.SimpleFenetre;

public class TacheEmission extends Thread {
	SimpleFenetre fenetre;

	public TacheEmission() {
		fenetre = new SimpleFenetre("EMISSION");
	}

	public void run() {
		int i=0;
		fenetre.setVisible(true);
		while (1 == 1) {
			fenetre.updateMessage("EMISSION"+i++);
			try {
				Thread.sleep(1110);
			} catch (InterruptedException e) {}

		}
	}

}
