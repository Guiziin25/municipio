package controller;

import java.util.ArrayList;

import model.IModel;
import view.IView;;

public interface IController {
	
	public ArrayList<IModel> getMunicipios();
	public void setMunicipios(ArrayList<IModel> municipios);
	public IView getView();
	public void setView(IView view);
	public boolean isUsedCod(int cod);
	public void Inserir(int codigo, String nome,int populacaoTotal,int populacaoUrbana,float residuosTot);
	public void CarregarTodos();
	public void Pesquisar(int cod);
	public void atualizaTabela();

}
