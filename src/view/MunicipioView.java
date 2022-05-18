package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import controller.IController;
import view.IView;
import model.DadosSubject;
import model.IModel;
import model.MunicipioModel;
import model.TabelaObserver;


public class MunicipioView extends JFrame implements IView{

	private static final long serialVersionUID = 1L;
	private IController contr;
	private JPanel panel;
	
	/*private JPanel painelcodText;
	private JPanel painelpopTotTexts;
	private JPanel painelnomeText;
	private JPanel painelpopUrbText;*/
	
	private JTextField codText;
	private JTextField popTotText;
	private JTextField nomeText;
	private JTextField popUrbText;
	private JTextField resText;
	private JButton btnInserir;
	private JButton btnPesquisar;
	private JScrollPane painelTabela;
	
	
	
	private JTable tabela;
	private Object[][] tabelaDados;
	private String[] tabelaCabecalho = {"Cidade", "População", "Geração per capita"};
	
//	DadosSubject dados = new DadosSubject();
	
	/*Construtor*/
    public MunicipioView(IController contr) {
		this.contr = contr;
        initUI();
    }
	
	/* Metodos */
	public void MostrarMensagem(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	
	public boolean Numero(String value) {
		 try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	
	public boolean CodigoEstaVazio() {
		if(codText.getText().equals("") ||    codText.getText().equals(null) ) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean TodosNumeros() {
		return Numero(codText.getText()) && Numero(popTotText.getText()) && Numero(popUrbText.getText()) && Numero(resText.getText());
	}
	
	public boolean TudoVazio() {
		if(     codText.getText().equals("") ||    codText.getText().equals(null) &&
		     popTotText.getText().equals("") || popTotText.getText().equals(null) &&
		       nomeText.getText().equals("") ||   nomeText.getText().equals(null) && 
		     popUrbText.getText().equals("") || popUrbText.getText().equals(null) &&
		     resText.getText().equals("") || resText.getText().equals(null)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void LimpaCampos() {
		codText.setText("");
    	nomeText.setText("");
    	popTotText.setText("");
    	popUrbText.setText("");
    	resText.setText("");
	}
	
	public void RecebeTodosCampos(String cod, String nome, String popTot, String popUrb, String resid) {
		codText.setText(cod);
    	nomeText.setText(nome);
    	popTotText.setText(popTot);
    	popUrbText.setText(popUrb);
    	resText.setText(resid);
	}
	
    private final void initUI() {
 
    	panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new GridLayout(10, 3));
		
		
        tabelaDados = new Object[contr.getMunicipios().size()][3];
        
        this.atualizaTabelaDados();
        
       // System.out.println("Tabela " + this.tabelaDados[0][0]);
        
		DefaultTableModel model = new DefaultTableModel(this.tabelaDados, this.tabelaCabecalho);
		
		/*this.painelcodText = new JPanel();
		this.painelpopTotTexts = new JPanel();
		this.painelnomeText = new JPanel();
		this.painelpopUrbText = new JPanel();*/
		
		tabela = new JTable(model);
		painelTabela = new JScrollPane(tabela);
		
		//desenhaCampos();
		desenhaTabela();
		
		
		int altura = Math.max(
				(int) (this.painelTabela.getBounds().getMaxY() + 40), 
				(int) (this.panel.getBounds().getMaxY() + 40));
		this.setBounds(200, 25, (int) (this.painelTabela.getBounds().getMaxX() + 10), altura);
        
		
        codText =new JTextField();
        nomeText =new JTextField();
        popTotText =new JTextField();
        popUrbText =new JTextField();
        resText =new JTextField(); 
        
        btnInserir  = new JButton("Inserir");
        btnPesquisar = new JButton("Pesquisar");
        
        btnInserir.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            { 
            	if(TudoVazio()) {
            		MostrarMensagem("Para inserir, preencha todos os campos.");
            	}else if(!TodosNumeros()){
            		MostrarMensagem("Os campos: Código, População Total e População Urbana necessitam ser números.");
            	}else{
            		contr.Inserir(Integer.parseInt(codText.getText()), nomeText.getText(), Integer.parseInt(popTotText.getText()), Integer.parseInt(popUrbText.getText()),Integer.parseInt(resText.getText()));
            		
            		//dados.setState(new MunicipioModel(Integer.parseInt(codText.getText()), nomeText.getText(), Integer.parseInt(popTotText.getText()), Integer.parseInt(popUrbText.getText()),Integer.parseInt(resText.getText())));
            		
            	}

            }
        });
        
        btnPesquisar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	if(CodigoEstaVazio()) {
            		MostrarMensagem("Preencha o campo código para pesquisar.");
            	}else if(!Numero(codText.getText())){
            		MostrarMensagem("O campo código deve ser numérico.");
            	}else{
            		contr.Pesquisar(Integer.parseInt(codText.getText()));
            	}
             
            }
        });
        
        
        panel.add(new JLabel("Código"));
        panel.add(codText);
        panel.add(new JLabel("Nome"));
        panel.add(nomeText);
        panel.add(new JLabel("População Total:"));
        panel.add(popTotText);
        panel.add(new JLabel("População Urbana:"));
        panel.add(popUrbText);
        panel.add(new JLabel("Residuos:"));
        panel.add(resText);
        panel.add(btnInserir);
        panel.add(btnPesquisar);
        
        add(panel);

        setTitle("Municípios");
        setSize(250,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
	public void desenhaTabela(){
		this.tabela.getColumnModel().getColumn(0).setPreferredWidth(15);
		this.tabela.getColumnModel().getColumn(1).setPreferredWidth(20);
		this.tabela.getColumnModel().getColumn(2).setPreferredWidth(60);
		
		this.tabela.setFillsViewportHeight(true);
		
		this.painelTabela.setBounds(100 + 20, 10, 250, 500);
		this.add(this.painelTabela);
	}
   
	public void atualizaTabelaDados(){
		
		for(int i = 0; i < contr.getMunicipios().size(); i++){
			
			 //System.out.println("Tabela " + new Float(contr.getMunicipios().get(i).getPopulacaoTotal())/contr.getMunicipios().get(i).getResiduos());
			
			this.tabelaDados[i][0] = contr.getMunicipios().get(i).getNome();
			this.tabelaDados[i][1] = new Integer(contr.getMunicipios().get(i).getPopulacaoTotal());
			this.tabelaDados[i][2] = new Float(contr.getMunicipios().get(i).getPopulacaoTotal()/contr.getMunicipios().get(i).getResiduos());
		}
	}
	
	public void atualizaTabela(){
		atualizaTabelaDados();
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.setDataVector(tabelaDados, tabelaCabecalho);
		model.fireTableDataChanged();
		
		this.tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.tabela.getColumnModel().getColumn(1).setPreferredWidth(10);
		this.tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
	}


	
}
