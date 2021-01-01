package com.serialisation.object;
// packages a importer pour l'object File
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
// dans ce programme nous voulons comparer le temps de lecture
// avec FileInputStream et BufferedInputStream

public class Lecture1 {

	public static void main(String[] args) {
		// declarons nos objects en dehors du bloc try/catch
		BufferedInputStream bis;
		FileInputStream fis;
		try {
			//on les instancies dans le bloc try
			fis= new FileInputStream(new File("test.txt"));
			bis = new BufferedInputStream(
					new DataInputStream(
							new FileInputStream(
									new File("test.txt"))));
			// creation d'un tableau de byte pour stocker temporairement
			byte [] buffer = new byte[8];
			// on initialise le temps d'execution au depart
			long StarTime = System.currentTimeMillis();
			//inutile deffectuer des traitements dans notre boucle tout est gerer
			while(fis.read(buffer)!=-1);
				
		    System.out.println("le temps d'excution avec FileInputSteam:  "+
		   (System.currentTimeMillis() - StarTime ));
			
			// on reinitialise notre chrono pour le bufferedInputStream
			StarTime = System.currentTimeMillis();
			while(bis.read(buffer)!= -1);
			// affichage du temps d'excetion avec le buffered
		     System.out.println("le temps d'excusion avec Buffered:  "+
		    (System.currentTimeMillis()- StarTime));
			// on ferme nos flux
			fis.close();
			bis.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		

	}
	

}
