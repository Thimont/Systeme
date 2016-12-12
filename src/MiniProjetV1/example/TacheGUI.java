import MiniProjetV1.example.SimpleFenetre;

public class TacheGUI extends Thread {
	SimpleFenetre fenetre;

	public TacheGUI(SimpleFenetre fenetre) {
		this.fenetre = fenetre;
	}

	public void run() {
		fenetre.setVisible(true);
		fenetre.updateMessage("TATA");
	}

}
