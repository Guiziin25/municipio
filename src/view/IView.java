package view;

public interface IView {
	public void MostrarMensagem(String s);
	public boolean Numero(String value);
	public boolean CodigoEstaVazio();
	public boolean TodosNumeros();
	public boolean TudoVazio();
	public void LimpaCampos();
	public void RecebeTodosCampos(String cod, String nome, String popTot, String popUrb, String resid);
	public void setVisible(boolean b);
	public void atualizaTabela();
}
