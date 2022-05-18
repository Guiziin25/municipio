package model;

import model.DadosObserver;
import model.DadosSubject;
import controller.IController;
import controller.MunicipioController;


public class TabelaObserver extends DadosObserver {

	public TabelaObserver(DadosSubject dados) {
		super(dados);
	}

	@Override
	public void update() {
		
		IController con = new MunicipioController();
		
		con.atualizaTabela();
	}

}
