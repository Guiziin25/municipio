package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import persistencia.IResiduosSerializableDao;

public class SerializableDao<T> implements IResiduosSerializableDao<T>{

	@Override
	public ArrayList<T> Importar(String file) {
		try {
			 ArrayList<T> arr = new ArrayList<T>();
	         FileInputStream fileIn = new FileInputStream(file);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         arr = (ArrayList<T>) in.readObject();
	         in.close();
	         return arr;	         
	      } catch (IOException i) {
	         return null;
	      } catch (ClassNotFoundException e) {
	    	 return null;
		}
	}

	@Override
	public void Exportar(String file,ArrayList<T> obj) {
		try
        {   
            FileOutputStream fileIn = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileIn);
             
            out.writeObject(obj);
             
            out.close();
            fileIn.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
	}

}
