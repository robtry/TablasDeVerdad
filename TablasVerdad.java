/*=================================================
#>= Institution: ITESM CSF
#>= Function: 
#>= Input: --
#>= Output: 
#>= Author: Roberto Gervacio ~~ Mx ~~
#>= Start Data: 12-10-17
#>= Last Update: 12-10-17
#>= Aditional Comments: ---
===================================================*/
import javax.swing.*;
import java.awt.event.*;
class TablasVerdad extends JFrame
{
	public static void main(String[] args)
	{
		TablasVerdad ventanaGrafica = new TablasVerdad();
		ventanaGrafica.setVisible(true);
	}
	boolean modoPro = false;
	String funcion;
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~CREANDO LA INTEFAZ GRAFICA~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	JPanel panelField, panelOperadores, panelAcciones, panelMode, panelSalir;
	JButton btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK,
			btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV,
			btnW, btnX, btnY, btnZ,// preposisiones
			btnOR, btnAND, btnNOT, btnSE, btnSSI, btnParent, // operadores
			btnChageMode,// modos
			btnNuevo, btnValidar, btnCalcular, btnSalir; //acciones
	JLabel lblModo;
	JTextField txtFuncion;
	public TablasVerdad()
	{
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(new java.awt.Dimension(400, 430));
		setTitle("Tabla De Verdad");
		setLayout(new java.awt.FlowLayout());
		//panel field
		panelField = new JPanel();
			panelField.setLayout(new java.awt.BorderLayout());
			txtFuncion = new JTextField(35);
			txtFuncion.setHorizontalAlignment(SwingConstants.CENTER);
			txtFuncion.setPreferredSize( new java.awt.Dimension( 200, 35 ));
			panelField.add(new JLabel("Función a evaluar: "), java.awt.BorderLayout.NORTH);
			panelField.add(txtFuncion);
		getContentPane().add(panelField);
		//botones de letras
			btnA = new JButton("a");btnB = new JButton("b");btnC = new JButton("c");
			btnD = new JButton("d");btnE = new JButton("e");btnF = new JButton("f");
			btnG = new JButton("g");btnH = new JButton("h");btnI = new JButton("i");
			btnJ = new JButton("j");btnK = new JButton("k");btnL = new JButton("l");
			btnM = new JButton("m");btnN = new JButton("n");btnO = new JButton("o");
			btnP = new JButton("p");btnQ = new JButton("q");btnR = new JButton("r");
			btnS = new JButton("s");btnT = new JButton("t");btnU = new JButton("u");
			btnV = new JButton("v");btnW = new JButton("w");btnX = new JButton("x");
			btnY = new JButton("y");btnZ = new JButton("z");
			btnA.setPreferredSize(new java.awt.Dimension(46,46));
			btnB.setPreferredSize(new java.awt.Dimension(46,46));
			btnC.setPreferredSize(new java.awt.Dimension(46,46));
			btnD.setPreferredSize(new java.awt.Dimension(46,46));
			btnE.setPreferredSize(new java.awt.Dimension(46,46));
			btnF.setPreferredSize(new java.awt.Dimension(46,46));
			btnG.setPreferredSize(new java.awt.Dimension(46,46));
			btnH.setPreferredSize(new java.awt.Dimension(46,46));
			btnI.setPreferredSize(new java.awt.Dimension(46,46));
			btnJ.setPreferredSize(new java.awt.Dimension(46,46));
			btnK.setPreferredSize(new java.awt.Dimension(46,46));
			btnL.setPreferredSize(new java.awt.Dimension(46,46));
			btnM.setPreferredSize(new java.awt.Dimension(46,46));
			btnN.setPreferredSize(new java.awt.Dimension(46,46));
			btnO.setPreferredSize(new java.awt.Dimension(46,46));
			btnP.setPreferredSize(new java.awt.Dimension(46,46));
			btnQ.setPreferredSize(new java.awt.Dimension(46,46));
			btnR.setPreferredSize(new java.awt.Dimension(46,46));
			btnS.setPreferredSize(new java.awt.Dimension(46,46));
			btnT.setPreferredSize(new java.awt.Dimension(46,46));
			btnU.setPreferredSize(new java.awt.Dimension(46,46));
			btnV.setPreferredSize(new java.awt.Dimension(46,46));
			btnW.setPreferredSize(new java.awt.Dimension(46,46));
			btnX.setPreferredSize(new java.awt.Dimension(46,46));
			btnY.setPreferredSize(new java.awt.Dimension(46,46));
			btnZ.setPreferredSize(new java.awt.Dimension(46,46));
			getContentPane().add(btnA);getContentPane().add(btnB);getContentPane().add(btnC);
			getContentPane().add(btnD);getContentPane().add(btnE);getContentPane().add(btnF);
			getContentPane().add(btnG);getContentPane().add(btnH);getContentPane().add(btnI);
			getContentPane().add(btnJ);getContentPane().add(btnK);getContentPane().add(btnL);
			getContentPane().add(btnM);getContentPane().add(btnN);getContentPane().add(btnO);
			getContentPane().add(btnP);getContentPane().add(btnQ);getContentPane().add(btnR);
			getContentPane().add(btnS);getContentPane().add(btnT);getContentPane().add(btnU);
			getContentPane().add(btnV);getContentPane().add(btnW);getContentPane().add(btnX);
			getContentPane().add(btnY);getContentPane().add(btnZ);
		//panel de operdores
		panelOperadores = new JPanel();
		panelOperadores.setBackground(new java.awt.Color(174, 168, 211));
			btnOR = new JButton("|");
			btnOR.setToolTipText("OR v");
			btnNOT = new JButton("-");
			btnNOT.setToolTipText("NOT ¬");
			btnAND = new JButton("&");
			btnAND.setToolTipText("OR ^");
			btnSE = new JButton("->");
			btnSE.setToolTipText("SI ENTONCES =>");
			btnSSI = new JButton("<->");
			btnSSI.setToolTipText("SI SOLO SI <=>");
			btnParent = new JButton("( )");
			btnParent.setToolTipText("PARÉNTESIS");
			panelOperadores.add(btnNOT);panelOperadores.add(btnOR);
			panelOperadores.add(btnAND);panelOperadores.add(btnSE);
			panelOperadores.add(btnSSI);panelOperadores.add(btnParent);
		getContentPane().add(panelOperadores);
		//panel acciones
		panelAcciones = new JPanel();
			panelAcciones.setBackground(new java.awt.Color(191, 191, 191));
			btnNuevo = new JButton("Nuevo");
			btnValidar = new JButton("Validar");
			btnCalcular = new JButton("Calcular");
			panelAcciones.add(btnNuevo);
			panelAcciones.add(btnValidar);
			panelAcciones.add(btnCalcular);
		getContentPane().add(panelAcciones);

		// panel modos
		panelMode = new JPanel();
			panelMode.setBackground(new java.awt.Color(137, 196, 244));
			btnChageMode = new JButton("Cambiar modo");
			panelMode.add(btnChageMode);
			lblModo = new JLabel("Modo actual: CREATIVO        ");
			panelMode.add(lblModo);
		getContentPane().add(panelMode);

		//panel salir
		panelSalir = new JPanel();
			btnSalir = new JButton("Salir");
			panelSalir.add(btnSalir);
		getContentPane().add(panelSalir);

		setLocationRelativeTo(null);


		/* ==== Para arrancar ==== */
			txtFuncion.setText("Comience a teclear");
			txtFuncion.setEditable(false);
			btnValidar.setEnabled(false);
			btnCalcular.setEnabled(false);
			deshabilitaOperadores();
		/* ======================= */

		/* ==== Agregar eventos a los controles ==== */
			btnSalir.addActionListener(new salir());
			btnChageMode.addActionListener(new cambiaModo());

		/* ======================================== */
	}
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~FIN DE LA INTEFAZ GRAFICA~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~CREACIÓN DE MÉTODOS PARA LOS CONTROLES~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	public class cambiaModo implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(modoPro)//esta activado hay que quitarlo
			{
				txtFuncion.setText("Comience a teclear");
				txtFuncion.setEditable(false);
				btnValidar.setEnabled(false);
				btnCalcular.setEnabled(false);
				deshabilitaOperadores();
				habilitaLetras();
				lblModo.setText("Modo actual: CREATIVO        ");
				modoPro = !modoPro;
			}
			else//desactivado hay que activarlo
			{
				deshabilitaLetras();
				deshabilitaOperadores();
				txtFuncion.setText("");
				txtFuncion.setEditable(true);
				txtFuncion.requestFocus();
				btnValidar.setEnabled(true);
				btnCalcular.setEnabled(true);
				lblModo.setText("Modo actual: PROFESIONAL      ");
				modoPro = !modoPro;
			}
		}
	}

	public class salir implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
		}
	}

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~FIN CREACIÓN DE MÉTODOS PARA LOS CONTROLES~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~MÉTODOS AUXILIARES~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		public void deshabilitaOperadores()
		{
			btnOR.setEnabled(false);
			btnNOT.setEnabled(false);
			btnAND.setEnabled(false);
			btnSE .setEnabled(false);
			btnSSI .setEnabled(false);
			btnParent .setEnabled(false);
		}

		public void habilitaOperadores()
		{
			btnOR.setEnabled(true);
			btnNOT.setEnabled(true);
			btnAND.setEnabled(true);
			btnSE .setEnabled(true);
			btnSSI .setEnabled(true);
			btnParent .setEnabled(true);
		}

		public void deshabilitaLetras()
		{
			btnA.setEnabled(false);
			btnB.setEnabled(false);
			btnC.setEnabled(false);
			btnD.setEnabled(false);
			btnE.setEnabled(false);
			btnF.setEnabled(false);
			btnG.setEnabled(false);
			btnH.setEnabled(false);
			btnI.setEnabled(false);
			btnJ.setEnabled(false);
			btnK.setEnabled(false);
			btnL.setEnabled(false);
			btnM.setEnabled(false);
			btnN.setEnabled(false);
			btnO.setEnabled(false);
			btnP.setEnabled(false);
			btnQ.setEnabled(false);
			btnR.setEnabled(false);
			btnS.setEnabled(false);
			btnT.setEnabled(false);
			btnU.setEnabled(false);
			btnV.setEnabled(false);
			btnW.setEnabled(false);
			btnX.setEnabled(false);
			btnY.setEnabled(false);
			btnZ.setEnabled(false);
		}

		public void habilitaLetras()
		{
			btnA.setEnabled(true);
			btnB.setEnabled(true);
			btnC.setEnabled(true);
			btnD.setEnabled(true);
			btnE.setEnabled(true);
			btnF.setEnabled(true);
			btnG.setEnabled(true);
			btnH.setEnabled(true);
			btnI.setEnabled(true);
			btnJ.setEnabled(true);
			btnK.setEnabled(true);
			btnL.setEnabled(true);
			btnM.setEnabled(true);
			btnN.setEnabled(true);
			btnO.setEnabled(true);
			btnP.setEnabled(true);
			btnQ.setEnabled(true);
			btnR.setEnabled(true);
			btnS.setEnabled(true);
			btnT.setEnabled(true);
			btnU.setEnabled(true);
			btnV.setEnabled(true);
			btnW.setEnabled(true);
			btnX.setEnabled(true);
			btnY.setEnabled(true);
			btnZ.setEnabled(true);
		}
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~FIN MÉTODOS AUXILIARES~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}