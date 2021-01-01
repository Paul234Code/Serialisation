package com.serialisation.object;
// importations pour l'object file
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
// dans cette classe nous comparons le temps d'execution(lecture+ ecriture) 
// de File(Input/Output)Stream avec celle des buffers
//
public class LectureEcriture {

	public static void main(String[] args) {
		// declarons nos object en dehors du bloc try/catch
		FileInputStream FIS;
		FileOutputStream FOS;
		BufferedInputStream BIS;
		BufferedOutputStream BOS;
		// on les instancie dans le bloc try
		try {
			//ouverture du fichier en lecture
			FIS= new FileInputStream(new File("test.txt"));
			//ouverture du fichier en ecriture ou creation si ca nexistepas
			FOS = new FileOutputStream(new File("test1.txt"));
			// un tampon en lecture du flux
			BIS= new BufferedInputStream(
					new FileInputStream(
					 new File("test.txt")));
			//un autre tampom mais en ecriture
			BOS= new BufferedOutputStream(new FileOutputStream(new File("test3.txt")));
			// creation d'un tableau de bytes pour remplir le buffer
			byte [] buffer = new byte[8];
			// on initialise le temps de depart 
			long StarTime= System.currentTimeMillis();
			// on copie le fichier test.txt dans test1.txt a l'aide de fos et fis
			while(FIS.read(buffer)!=-1) {
				FOS.write(buffer);
			}
			// affichage du temps d'execution
			System.out.println("le temps execution Lecture +Ecriture avec FIS et FOS :"+
			(System.currentTimeMillis()- StarTime));
			// on reinitialise a nouveau le timing
			StarTime= System.currentTimeMillis();
			// on effectue la copie avec les BIS et BOS a l'aide d'une boucle while
			//test.txt dans test3,txt
			while(BIS.read(buffer)!=-1) {
				BOS.write(buffer);
			}
			// on affiche le temps d'execution avec les buffers
			System.out.println("le temps execution Lecture +Ecriture avec BIS et BOS :"+
					(System.currentTimeMillis()- StarTime));
			// on ferme nos flux ouvert
			FIS.close();
			BIS.close();
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
