package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import modele.pojo.AllumettesImpl;
import modele.pojo.PenduImpl;
import modele.pojo.TicTacToeImpl;

public class Serveur {
    public static void main(String[] args) {
        try {
            System.out.println("Le serveur est en cours de demarrage ...");
            String hote = "127.0.0.1";              // Initialisation de l'adresse du serveur
            int port = Integer.parseInt("8000");    // Initialisation du port du serveur
            LocateRegistry.createRegistry(port);

            AllumettesImpl allumettesImpl = new AllumettesImpl();   // Implementation du Jeu des Allumettes
            PenduImpl penduImpl = new PenduImpl();                  // Implementation du Pendu
            TicTacToeImpl ticTacToeImpl = new TicTacToeImpl();      // Implementation du Tic Tac Toe
            
            Naming.rebind("rmi://" + hote + ":" + port + "/Allumettes", allumettesImpl);    // Creation de la route du Jeu des Allumettes
            Naming.rebind("rmi://" + hote + ":" + port + "/Pendu", penduImpl);              // Creation de la route du Pendu
            Naming.rebind("rmi://" + hote + ":" + port + "/TicTacToe", ticTacToeImpl);      // Creation de la route du Tic Tac Toe
            
            System.out.println("Le serveur est operationnel !");      // Informe l'utilisateur
        } catch(Exception e) {
            System.out.println("Une erreur a ete rencontree :\n" + e.getMessage());
        }
    }
}
