package com.serialisation.object;
// packages a importer pour l'object File
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DatainputStream {

	public static void main(String[] args) {
		// nous declarons nos objects en dehors du bloc try/catch
		DataInputStream DIS;
		DataOutputStream DOS;
		try {
			// on instancie nos objects dans le bloc try/catch
			DOS= new DataOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(
								new File("Toto.txt"))));
			// ecriture de donnes de type primitif  dans le flux
			DOS.writeBoolean(true);
			DOS.writeByte(100);
			DOS.writeChar('C');
			DOS.writeDouble(12367.45d);
			DOS.writeFloat(1234.89f);
			DOS.writeInt(1234);
			DOS.writeLong(1234556789L);
			DOS.writeShort(4);
			DOS.writeUTF("Bonjour Toto comment tu vas");
			DOS.close();
			// on recupere les donnes
			DIS = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("Toto.txt"))));
			// on lit les differentes donnes
			System.out.println(DIS.readBoolean());
			System.out.println(DIS.readByte());
			System.out.println(DIS.readChar());
			System.out.println(DIS.readDouble());
			System.out.println(DIS.readFloat());
			System.out.println(DIS.readInt());
			System.out.println(DIS.readLong());
			System.out.println(DIS.readShort());
			System.out.println(DIS.readUTF());
					
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
