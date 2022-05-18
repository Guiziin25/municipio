package model;
import java.io.Serializable;

import model.IModel;


public class MunicipioModel implements IModel, Serializable{
	//Properties
	private int codigo;
	private String nome;
	private int populacaoTotal;
	private int populacaoUrbana;
	private float residuosTot;
	
	//Getters and Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPopulacaoTotal() {
		return populacaoTotal;
	}
	public void setPopulacaoTotal(int populacaoTotal) {
		this.populacaoTotal = populacaoTotal;
	}
	public int getPopulacaoUrbana() {
		return populacaoUrbana;
	}
	public void setPopulacaoUrbana(int populacaoUrbana) {
		this.populacaoUrbana = populacaoUrbana;
	}
	public float getResiduos() {
		return residuosTot;
	}
	public void setResiduos(float residuosTot) {
		this.residuosTot = residuosTot;
	}
	
	//Constructors
	public MunicipioModel(int codigo, String nome,int populacaoTotal,int populacaoUrbana,float residuosTot) {
		this.codigo = codigo;
		this.nome = nome;
		this.populacaoTotal = populacaoTotal;
		this.populacaoUrbana = populacaoUrbana;
		this.residuosTot = residuosTot;
	}
	
}
