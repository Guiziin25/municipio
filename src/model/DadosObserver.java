package model;

import java.util.ArrayList;

import model.DadosSubject;

public abstract class DadosObserver {

	//protected ArrayList<DadosSubject> dados = new ArrayList<DadosSubject>();
	protected DadosSubject dados;

	public DadosObserver(DadosSubject d) {
		//dados.add(d);
		this.dados = d;
	}

	public abstract void update();
}
