package controller;

import java.util.ArrayList;

import controller.IController;
import persistencia.SerializableDao;
import persistencia.IResiduosSerializableDao;
import model.MunicipioModel;
import model.TabelaObserver;
import model.IModel;
import view.IView;
import model.DadosSubject;

public class MunicipioController implements IController {
	//Properties
	private IResiduosSerializableDao<IModel> dao = new SerializableDao<IModel>();
	private ArrayList<IModel> municipios = new ArrayList<IModel>();
	private IView view;
	private static String arqName = "C:\\Temp\\municipios.dat";
	DadosSubject dados = new DadosSubject();
	
	
	//Getters and Setters
	public ArrayList<IModel> getMunicipios() {
		return municipios;
	}
	public void setMunicipios(ArrayList<IModel> municipios) {
		this.municipios = municipios;
	}
	public IView getView() {
		return view;
	}
	public void setView(IView view) {
		this.view = view;
	}
	
	//Methods
	public boolean isUsedCod(int cod) {
		boolean isUsed = false;
		for(IModel m : this.municipios) {
			if(m.getCodigo()==cod) {
				isUsed = true;
			}
		}
		return isUsed;
	}
	
	public void Inserir(int codigo, String nome,int populacaoTotal,int populacaoUrbana,float residuosTot) {
		if(isUsedCod(codigo)) {
			view.RecebeTodosCampos("", nome,  String.valueOf(populacaoTotal), String.valueOf(populacaoUrbana),String.valueOf(residuosTot) );
			view.MostrarMensagem("Esse código já foi utilizado \n Insira outro:");
		}else {
			//dados.attach(new TabelaObserver(dados));
			MunicipioModel m = new MunicipioModel(codigo,nome,populacaoTotal,populacaoUrbana,residuosTot);
			dados.setState(m);
			municipios.add(m);
			dao.Exportar(arqName,municipios);
			view.LimpaCampos();
			view.MostrarMensagem("Município inserido com sucesso");
		}
	}
	
	public void CarregarTodos() {
		municipios = dao.Importar(arqName);
		if(municipios == null) {
			municipios = new ArrayList<IModel>(); 
		}
	}
	
	public void Pesquisar(int cod) {
		IModel mun = null;
		for(IModel m : this.municipios) {
			if(m.getCodigo()==cod) {
				mun = m;
			}
		}
		
		if(mun == null) {
			view.MostrarMensagem("Município não encontrado");
			view.LimpaCampos();
			}else {
			view.RecebeTodosCampos(String.valueOf(mun.getCodigo()), mun.getNome(), String.valueOf(mun.getPopulacaoTotal()),String.valueOf(mun.getPopulacaoUrbana()),String.valueOf(mun.getResiduos()));
		}
	}
	
	public void atualizaTabela() {
             view.atualizaTabela();		
	}
	
}

