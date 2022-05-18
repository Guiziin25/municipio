package persistencia;

import java.util.ArrayList;

public interface IResiduosSerializableDao<T>
{
	public ArrayList<T> Importar(String file);
	public void Exportar (String file,ArrayList<T> obj);
}
