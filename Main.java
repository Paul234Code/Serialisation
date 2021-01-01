package com.serialisation.object;
// package a importer pour utiliser l'object file

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Main {

	public static void main(String[] args) {
		// nous declarons nos object en dehors du bloc Try catch
		ObjectInputStream ois;
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
					 new FileOutputStream(
						new File("paul.txt"))));
			// nous allons ecrire chaque object dans le fichier Paul
			oos.writeObject(new Game("UFC-MMA","freeFight",450d));
			oos.writeObject( new Game("Lutte USA","brutalite",348d));
			oos.writeObject(new Game("Tomb Raider", "Plateforme", 23.45));
			oos.writeObject(new Game("Tetris", "Stratégie", 2.50));
			// ne pas oublier de fermer le flux
			oos.close();
			// on recupere les donnes et on les affiche( deserialisation)
			// on ajuote un try au cas ou la classe Game n'existe pas
			ois= new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("paul.txt"))));
			
			try {
				System.out.println("Affichage des jeux :");
				System.out.println("*************************\n");
				System.out.println(ois.readObject().toString());
				System.out.println();
				System.out.println(((Game)ois.readObject()).toString());
				System.out.println();
				System.out.println(((Game)ois.readObject()).toString());
				System.out.println();
				System.out.println(((Game)ois.readObject()).toString());
				
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			ois.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
