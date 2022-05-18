package aPrincipal;
import java.util.ArrayList;

import model.DadosSubject;
import model.MunicipioModel;
import model.TabelaObserver;
import view.IView;
import view.MunicipioView;
import controller.IController;
import controller.MunicipioController;

public class Principal {
	
	
	public static void main(String[] args) {
		IController munController = new MunicipioController();
		
		munController.CarregarTodos();
		IView ex = new MunicipioView(munController);
		
		munController.setView(ex);
        ex.setVisible(true);

	}

}
