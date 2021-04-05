package modele.pojo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import modele.interfaceRMI.InterfacePendu;

public class PenduImpl extends UnicastRemoteObject implements InterfacePendu{
    
    private static final long serialVersionUID = 1L;

    public PenduImpl() throws RemoteException {
        super();
    }

    public int randInt(int max) throws RemoteException {
        Random rand = new Random();
        int n = rand.nextInt(max);
        return n;
    }

    public String motAleatoire() throws RemoteException {
        Dictionnaire[] dictionnaire = Dictionnaire.values();        // Recupere ce qu'il y a dans le Dictionnaire
        int entierAleatoire = randInt(dictionnaire.length);         // Creation d'un nombre de la taille du dictionnaire
        String mot = dictionnaire[entierAleatoire].toString();      // Genere le mot
        return mot;
    }

    public String changeMot(String mot, char[] lettres) throws RemoteException {
        String motAffichage = "";   // Initialisation
        String lettre = "";
        char[] motDecompose = mot.toCharArray();    // Decomposition du mot
        
        for(int i = 0; i < motDecompose.length; i++) {      // Permet de savoir si la lettre choisie appartient au mot
            lettre = "_ ";      // Initialisation lettre par defaut
            for(int j = 0; j < lettres.length; j++) {
                if(motDecompose[i] == lettres[j]) {
                    lettre = lettres[j] + " ";      // La lettre correspond
                }
            }
            motAffichage += lettre;     // Ajout de la lettre au mot
        }
        return motAffichage;    // Retourner le mot
    }

    public boolean contientChar(char[] tab, char c) throws RemoteException {
        for(int i = 0; i < tab.length; i++){
            if(tab[i] == c){
                return true;
            }
        }
        return false;
    }

    public char[] ajouterChar(char[] tab, char c) throws RemoteException {
        char[] testNull = new char[1];
        for(int i = 0; i < tab.length; i++){
            if(tab[i] == testNull[0]){
                if(!contientChar(tab, c)){
                    tab[i] = c;
                }
            }
        }
        return tab;
    }
}
