package acessoBanco;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUIAcessoBanco extends JFrame implements ActionListener {
	private JButton ins = new JButton("Inseri"); 
	private JButton prox = new JButton("Proximo");
	private JLabel lCliente = new JLabel("Nome: ");
	private JTextField nomeCliente = new JTextField(15);
	private JLabel lIdade = new JLabel("Idade: ");
	private JTextField idadeCliente = new JTextField(5);
	private JLabel lProx = new JLabel("Próximo: ");
	private JLabel proxCliente = new JLabel();
	private JLabel insMsg = new JLabel("");
	private JLabel proxMsg = new JLabel("");
	
	ControleAcesso control = new ControleAcesso();
 
	GUIAcessoBanco()
	{	
		super("Controle de Acesso");
		
		JLabel dummy;
		
		JPanel painelBase = new JPanel();
		JPanel painelIns = new JPanel();
		JPanel painelProx = new JPanel();
		JPanel painelInsLabels = new JPanel();
		JPanel painelInsCampos = new JPanel();
		
		JPanel painelProxCampos = new JPanel();
		JPanel auxPanel;
		
		GridBagConstraints cons = new GridBagConstraints();
		
		painelBase.setLayout(new GridLayout(2,2));
		painelIns.setLayout(new GridBagLayout());
		painelProx.setLayout(new GridBagLayout());
		
		painelBase.add(painelIns);
		painelBase.add(painelProx);
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.EAST;
		painelIns.add(lCliente, cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.WEST;
		painelIns.add(nomeCliente, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;		
		cons.anchor = GridBagConstraints.EAST;		
		painelIns.add(lIdade, cons);

		cons.gridx = 1;
		cons.gridy = 1;		
		cons.anchor = GridBagConstraints.WEST;
		painelIns.add(idadeCliente, cons);
		
		cons.gridx = 0;
		cons.gridy = 2;		
		cons.anchor = GridBagConstraints.CENTER;
		painelIns.add(insMsg, cons);
		
		auxPanel = new JPanel();
		auxPanel.add(ins);
		painelBase.add(auxPanel);

		cons.gridx = 0;
		cons.gridy = 0;		
		cons.anchor = GridBagConstraints.EAST;
		painelProx.add(lProx, cons);
		
		cons.gridx = 1;
		cons.gridy = 0;		
		cons.anchor = GridBagConstraints.WEST;		
		painelProx.add(proxCliente, cons);

		cons.gridx = 0;
		cons.gridy = 1;		
		cons.anchor = GridBagConstraints.CENTER;		
		painelProx.add(proxMsg, cons);
		
		auxPanel = new JPanel();
		auxPanel.add(prox);
		painelBase.add(auxPanel);
	
		ins.addActionListener(this);
		prox.addActionListener(this);
		this.getContentPane().add(painelBase);
		
		pack();
		setSize(600,200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		Cliente cliAux;
		int auxIdade = 0;
		
		if (evt.getSource() == ins)
		{
			try {
				cliAux = new Cliente();
				cliAux.setNome(nomeCliente.getText());

				auxIdade = Integer.parseInt(idadeCliente.getText());

				cliAux.setIdade(auxIdade);
				control.addCliente(cliAux);
				
				insMsg.setText("");
			}
			catch (NumberFormatException e) {
				nomeCliente.setText("");
				idadeCliente.setText("");
				insMsg.setText("** Idade inválida!");
			}
						
			nomeCliente.setText("");
			idadeCliente.setText("");
		}
		else if (evt.getSource() == prox)
		{
			cliAux = control.getProxCliente();
			
			if (cliAux != null)
			{
				proxCliente.setText(cliAux.getNome());
				proxMsg.setText("");
			}
			else
			{
				proxCliente.setText("");
				proxMsg.setText("**Não há clientes!!");
			}
		}
	}
	
	public static void main(String[] argc)
	{	
		GUIAcessoBanco tela = new GUIAcessoBanco();
	}
}
