package MiniProjetV1.example;

import MiniProjetV1.example.SimpleFenetre;

import java.util.Scanner;

public class TheMain {
	public static void main(String[] args) {

		SimpleFenetre fenetre = new SimpleFenetre("Main");
		int i = 0;
		Scanner sc = new Scanner(System.in);
		
		//SwingUtilities.invokeLater(new TacheGUI(fenetre));
		TacheEmission TE = new TacheEmission();
		
		TacheReception TR = new TacheReception();

		TE.start();
		TR.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}

		while (1 == 1) {
			String s = sc.next();
			
			System.out.println(s);
			
			fenetre.updateMessage(s);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}
