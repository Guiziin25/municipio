package model;

import java.util.ArrayList;

import model.IModel;
import model.DadosObserver;

public class DadosSubject{

	protected ArrayList<DadosObserver> observers;
	protected IModel dados;

	/*public DadosSubject DadosSubject() {
		return new DadosSubject();
	}*/
	
	public DadosSubject() {
		observers = new ArrayList<DadosObserver>();
	}

	public void attach(DadosObserver observer) {
		observers.add(observer);
	}

	public void detach(int indice) {
		observers.remove(indice);
	}

	public void setState(IModel dados) {
		this.dados = dados;
		notifyObservers();
	}
	
	public void notif() {
		notifyObservers();
	}

	private void notifyObservers() {
		for (DadosObserver observer : observers) {
			observer.update();
		}
	}

	public IModel getState() {
		return dados;
	}


}
