/*=================================================
#>= Institution: ITESM CSF
#>= Function: 
#>= Input: --
#>= Output: 
#>= Author: Roberto Gervacio ~~ Mx ~~
#>= Start Data: 12-10-17
#>= Last Update: 22-10-17
#>= Aditional Comments: El modo profesional es solo una idea
===================================================*/
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
class TablasVerdad extends JFrame
{
	boolean modoPro = false, estoyAdentroDeParent = false, sePuedeHacer = true;
	int parentClosetoIgnore=0;
	String funcion = "", os =System.getProperty("os.name"), cadenaBooleana="";

	public static void main(String[] args) throws Exception
	{
		TablasVerdad ventanaGrafica = new TablasVerdad();
		ventanaGrafica.setVisible(true);
	}
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~CREANDO LA INTEFAZ GRAFICA~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	JPanel panelField, panelOperadores, panelAcciones, panelMode, panelSalir;
	JButton btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK,
			btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV,
			btnW, btnX, btnY, btnZ,// preposisiones
			btnOR, btnAND, btnNOT, btnSE, btnSSI, btnParent, btnOutParent, // operadores
			btnChageMode,// modos
			btnNuevo, btnCalcular, btnMostrar, btnSalir; //acciones
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
			btnParent = new JButton("( ");
			btnParent.setToolTipText("ABRIR PARÉNTESIS");
			btnOutParent = new JButton(")");
			btnOutParent.setToolTipText("SALIR DE PARENTESIS");
			panelOperadores.add(btnNOT);panelOperadores.add(btnOR);
			panelOperadores.add(btnAND);panelOperadores.add(btnSE);
			panelOperadores.add(btnSSI);panelOperadores.add(btnParent);
			panelOperadores.add(btnOutParent);
		getContentPane().add(panelOperadores);
		//panel acciones
		panelAcciones = new JPanel();
			panelAcciones.setBackground(new java.awt.Color(191, 191, 191));
			btnNuevo = new JButton("Nuevo");
			btnCalcular = new JButton("Calcular");
			btnMostrar = new JButton("Mostrar");
			panelAcciones.add(btnNuevo);
			panelAcciones.add(btnCalcular);
			panelAcciones.add(btnMostrar);
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
			modoCreativo();
			btnOutParent.setEnabled(false);
		/* ======================= */

		/* ==== Agregar eventos a los controles ==== */
			btnSalir.addActionListener(new salir());
			btnChageMode.addActionListener(new cambiaModo());
			btnNuevo.addActionListener(new Nuevo());
			btnA.addActionListener(new Apress());
			btnB.addActionListener(new Bpress());
			btnC.addActionListener(new Cpress());
			btnD.addActionListener(new Dpress());
			btnE.addActionListener(new Epress());
			btnF.addActionListener(new Fpress());
			btnG.addActionListener(new Gpress());
			btnH.addActionListener(new Hpress());
			btnI.addActionListener(new Ipress());
			btnJ.addActionListener(new Jpress());
			btnK.addActionListener(new Kpress());
			btnL.addActionListener(new Lpress());
			btnM.addActionListener(new Mpress());
			btnN.addActionListener(new Npress());
			btnO.addActionListener(new Opress());
			btnP.addActionListener(new Ppress());
			btnQ.addActionListener(new Qpress());
			btnR.addActionListener(new Rpress());
			btnS.addActionListener(new Spress());
			btnT.addActionListener(new Tpress());
			btnU.addActionListener(new Upress());
			btnV.addActionListener(new Vpress());
			btnW.addActionListener(new Wpress());
			btnX.addActionListener(new Xpress());
			btnY.addActionListener(new Ypress());
			btnZ.addActionListener(new Zpress());
			btnOR.addActionListener(new ORpress());
			btnAND.addActionListener(new ANDpress());
			btnNOT.addActionListener(new NOTpress());
			btnSSI.addActionListener(new SSIpress());
			btnSE.addActionListener(new SEpress());
			btnParent.addActionListener(new AbrirParent());
			btnOutParent.addActionListener(new SalirParent());
			btnCalcular.addActionListener(new Calcular());
			btnMostrar.addActionListener(new Mostrar());
		/* ======================================== */
	}
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~FIN DE LA INTEFAZ GRAFICA~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~CREACIÓN DE MÉTODOS PARA LOS CONTROLES~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	public class Calcular implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			sePuedeHacer = true;
			cadenaBooleana = "";
			try
			{
				File archivo;
				archivo = new File("Resultados.java");
				archivo.createNewFile();
				FileWriter escritor = new FileWriter(archivo);
				PrintWriter pw = new PrintWriter(escritor);
				String textExport = "";
				pw.printf("import java.io.File;%n");
				pw.printf("import java.io.FileWriter;%n");
				pw.printf("import java.io.PrintWriter;%n");
				pw.printf("import java.io.IOException;%n");
				pw.printf("public class Resultados");
				pw.printf("%n{");
				pw.printf("%n\tpublic static void main(String[] args)");
				pw.printf("%n\t{");
				pw.printf("%n\t\ttry");
				pw.printf("%n\t\t{");
				pw.printf("%n\t\t\tFile archivo;");
				pw.printf("%n\t\t\tarchivo = new File(\"Resultados.txt\");");
				pw.printf("%n\t\t\tarchivo.createNewFile();");
				pw.printf("%n\t\t\tFileWriter escritor = new FileWriter(archivo);");
				pw.printf("%n\t\t\tPrintWriter pw = new PrintWriter(escritor);");				
				/* === Reuperar letras ===*/
					int[] prop = new int[28];// se guardaran las letars rescatadas
					int cont=0;// auxiliar para iterar a prop[]
					boolean existe=false;// aux para ver si la letra ya existe en prop[]
					int n0=0;// numero de letras para saber las combinaiciones
					double n=0;// 2^n
					// solo letras
					for(int i=0;i<funcion.length();i++)
					{
						if (Character.isLetter(funcion.codePointAt(i)))
						{
							//es letra!
							//System.out.print("Letra detectada: ");
							//ps veo si se puede agregar
							while((cont<prop.length)&&(!existe))
							{
								if(prop[cont]==funcion.codePointAt(i))
								{
									//ya existe, ya no tiene caso seguir comparando
									existe = !existe;//false para que exista y se ropa el while
								}
								else if(prop[cont]==0)//no son iguales okay, pero es 0?
								{
									//si es 0 esta vacio, no va a ser igual a vacio
									//si habia algo ya paso, entonces debemos meterlo
									prop[cont]=funcion.codePointAt(i);
									existe = !existe; // para igual se salga
								}
								//no son igual y no es 0 entonces es una letra ya guardada
								//continuemos
								cont++;
							}
							cont=0;
							existe = false;
						}
						
					}
					//contar letras rescatadas 
					for (int i=0;i<prop.length;i++)
					{
						if(prop[i]!=0)
						{
							//System.out.printf("%c ",prop[i]);
							//System.out.printf("%d%n",prop[i]);
							n0++;
						}
					}
					//ordenarlas 
					Arrays.sort(prop);

					/// calcular total de combinaciones
					n = Math.pow(2,n0);

					// valores de verdad y false que tendria cada prop
					int aux=(int)n/2,aux2cont=0,indiceletraAux=0;
					boolean turnar=false;
					boolean[][] valoresVerdad = new boolean[(int)n][n0];
					System.out.print("filas: "+ n);
					System.out.println("\tcolumnas: "+ n0);

					for (int i=0;i<prop.length;i++)
					{
						if(prop[i]!=0)// si hay algo en el arreglo
						{
							//ps quien es
							//System.out.printf("%c\t",prop[i]);
							pw.printf("%n\t\t\tpw.printf(\"%c\\t\");",prop[i]);

							textExport += "----";


							for(int j=0;j<n;j++) // todas las posibilidades
							{
								aux2cont++;
								//System.out.print("aux2:"+aux2cont);
								if(aux2cont>aux)
								{
									turnar = !turnar;
									aux2cont=1;
								}
								if(turnar)// ps verdaderos
								{
									//System.out.print("t\t");
									valoresVerdad[j][indiceletraAux] = true;
								}
								else // ps falsos
								{
									//System.out.print("f\t");
									valoresVerdad[j][indiceletraAux] = false;
								}						
							}
							aux/=2;
							aux2cont=0;
							turnar = false;
							indiceletraAux++;
						}
					}
					//System.out.println();
					pw.printf("%n\t\t\tpw.printf(\"|\\t%s\");", funcion);
					textExport += "----";
					//ver si se puede hacer o no y agregar mas espacio al ----
					for (int i=0;i<funcion.length();i++)
					{
						if(funcion.charAt(i)=='>' || funcion.charAt(i)=='<')
						{
							sePuedeHacer = false;
						}
						textExport += "---------";
					}

					pw.printf("%n\t\t\tpw.printf(\"%%n%s%%n\");",textExport);
					//valores en la matriz
					for (int i=0; i<valoresVerdad.length;i++ )
					{
						for (int j=0;j<valoresVerdad[0].length;j++)
						{
							//System.out.print(valoresVerdad[i][j]+"\t");
							if(valoresVerdad[i][j]==true)
							{
								pw.printf("%n\t\t\tpw.printf(\"v\\t\");");
							}
							else
							{
								pw.printf("%n\t\t\tpw.printf(\"f\\t\");");
							}
						/*============================
							if(sePuedeHacer)
							{
								// si se pudo hacer
								for(int k=0;k<funcion.length();k++)
								{
									if(Character.isLetter(funcion.codePointAt(k)))
									{
										cadenaBooleana = "";
										cadenaBooleana += Boolean.toString(valoresVerdad[i][j]);
									}
									else if(funcion.charAt(k)=='&')
									{
										cadenaBooleana += "&&";
									}
									else if(funcion.charAt(k)=='|')
									{
										cadenaBooleana += "||";
									}
									else if(funcion.charAt(k)=='-')
									{
										cadenaBooleana += "!";
									}
									else // debe de ser parentesis
									{
										cadenaBooleana += funcion.charAt(k);
									}

								}
							}
							//else ps no se va a poder hacer :(
							//no hay cadena booleana que evaluar
						/*============================*/
						}
						//aqui va un salto de linea
						//if(sePuedeHacer)
						//{
						//	pw.printf("%n\t\t\tpw.printf(\"|\\t%%b%%n%s%%n\",%s);",textExport,cadenaBooleana);
						//}
						//else
						//{
							pw.printf("%n\t\t\tpw.printf(\"|\\t%%n%s%%n\");",textExport);
						//}

					}
					//System.out.println();

				/* ======================= */
				pw.printf("%n\t\t\tescritor.close();");
				pw.printf("%n\t\t}");
				pw.printf("%n\t\tcatch(IOException ev)");
				pw.printf("%n\t\t{");
				pw.printf("%n\t\t\tev.printStackTrace();");				
				pw.printf("%n\t\t}");
				pw.printf("%n\t}");
				pw.printf("%n}");
				escritor.close();
				btnMostrar.setEnabled(true);
			}
			catch(IOException ev)
			{
				ev.printStackTrace();
			}

			abrirResultados();
		}
	}

	public class Mostrar implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			abrirResultados();

			try
			{
				if (os.equals("Mac OS X"))
				{
					Runtime.getRuntime().exec(new String[]{"open","Resultados.txt"});
				}
				else if (os.equals("Linux"))
				{
					Runtime.getRuntime().exec(new String[]{"xdg-open","Resultados.txt"});
				}
				else if(os.contains("Windows")) 
				{
					Runtime.getRuntime().exec(new String[]{"notepad","Resultados.txt"});
				}
				
			}
			catch (IOException es)
			{
				es.printStackTrace();
			}
		}
	}

	public class Nuevo implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(modoPro)
			{
				modoProf();
			}
			else
			{
				modoCreativo();
			}
		}
	}

	public class cambiaModo implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(modoPro)//esta activado hay que quitarlo
			{
				modoCreativo();
				modoPro = !modoPro;
			}
			else//desactivado hay que activarlo
			{
				modoProf();
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

	public class Apress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("a");
			}
			else
			{
				funcion += 'a';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Bpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("b");
			}
			else
			{
				funcion += 'b';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Cpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("c");
			}
			else
			{
				funcion += 'c';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Dpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("d");
			}
			else
			{
				funcion += 'd';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Epress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("e");
			}
			else
			{
				funcion += 'e';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Fpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("f");
			}
			else
			{
				funcion += 'f';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Gpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("g");
			}
			else
			{
				funcion += 'g';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Hpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("h");
			}
			else
			{
				funcion += 'h';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Ipress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("i");
			}
			else
			{
				funcion += 'i';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Jpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("j");
			}
			else
			{
				funcion += 'j';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Kpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("k");
			}
			else
			{
				funcion += 'k';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Lpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("l");
			}
			else
			{
				funcion += 'l';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Mpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("m");
			}
			else
			{
				funcion += 'm';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Npress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("n");
			}
			else
			{
				funcion += 'n';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Opress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("o");
			}
			else
			{
				funcion += 'o';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Ppress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("p");
			}
			else
			{
				funcion += 'p';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Qpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("q");
			}
			else
			{
				funcion += 'q';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Rpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("r");
			}
			else
			{
				funcion += 'r';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Spress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("s");
			}
			else
			{
				funcion += 's';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Tpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("t");
			}
			else
			{
				funcion += 't';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Upress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("u");
			}
			else
			{
				funcion += 'u';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Vpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("v");
			}
			else
			{
				funcion += 'v';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Wpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("w");
			}
			else
			{
				funcion += 'w';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Xpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("x");
			}
			else
			{
				funcion += 'x';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Ypress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("y");
			}
			else
			{
				funcion += 'y';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class Zpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("z");
			}
			else
			{
				funcion += 'z';
			}
			txtFuncion.setText(funcion);
			deshabilitaLetras();
			habilitaOperadores();
			btnCalcular.setEnabled(true);
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
		}
	}

	public class ORpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("|");
			}
			else
			{
				funcion += '|';
			}
			txtFuncion.setText(funcion);
			habilitaLetras();
			deshabilitaOperadores();
		}
	}

	public class ANDpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("&");

			}
			else
			{
				funcion += '&';
			}
			txtFuncion.setText(funcion);
			habilitaLetras();
			deshabilitaOperadores();
		}
	}

	public class NOTpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("-");

			}
			else
			{
				funcion += '-';
			}
			txtFuncion.setText(funcion);
			habilitaLetras();
			deshabilitaOperadores();
		}
	}

	public class SEpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("->");
			}
			else
			{
				funcion += "->";
			}

			txtFuncion.setText(funcion);
			habilitaLetras();
			deshabilitaOperadores();
		}
	}

	public class SSIpress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("<->");

			}
			else
			{
				funcion += "<->";
			}
			txtFuncion.setText(funcion);
			habilitaLetras();
			deshabilitaOperadores();
		}
	}

	public class AbrirParent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			estoyAdentroDeParent = amIinsideAparent();
			if(estoyAdentroDeParent)
			{
				funcion = agregaInParent("()");
			}
			else
			{
				funcion += "()";
			}
			txtFuncion.setText(funcion);
			habilitaLetras();
			deshabilitaOperadores();
			parentClosetoIgnore++;
			btnCalcular.setEnabled(false);
		}
	}

	public class SalirParent implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			parentClosetoIgnore--;
			if(parentClosetoIgnore==0)
			{
				btnOutParent.setEnabled(false);
			}
		}
	}

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~FIN CREACIÓN DE MÉTODOS PARA LOS CONTROLES~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~MÉTODOS AUXILIARES~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		public boolean amIinsideAparent()
		{
			boolean adentro=false;
			if(parentClosetoIgnore == 0)
			{
				adentro = false;
			}
			else
			{
				adentro = true;	
			}
			return adentro;
		}

		public String agregaInParent(String cadenaAMeter)
		{
			String cadenaNueva="";
			//System.out.println("vale: "+parentClosetoIgnore);
			for(int i=0;i<funcion.length();i++)
			{
				if(i==funcion.length()-parentClosetoIgnore)
				{
					//System.out.println("entro en pos: " + i);
					cadenaNueva += cadenaAMeter;
					for (int j=1;j<=parentClosetoIgnore;j++)
					{
						cadenaNueva += ")"; // los de adentro
					}
				}
				else
				{
					if((funcion.charAt(i)!=')')||i<=(funcion.length()-parentClosetoIgnore))
					{
						cadenaNueva += funcion.charAt(i);
					}
				}
			}
			return cadenaNueva;
		}

		public  void modoCreativo()
		{
			txtFuncion.setText("Comience a teclear");
			txtFuncion.setEditable(false);
			btnCalcular.setEnabled(false);
			btnMostrar.setEnabled(false);
			deshabilitaOperadores();
			habilitaLetras();
			lblModo.setText("Modo actual: CREATIVO        ");
			funcion = "";
			parentClosetoIgnore = 0;
			btnOutParent.setEnabled(false);
			btnMostrar.setEnabled(false);
		}

		public void modoProf()
		{
			deshabilitaLetras();
			deshabilitaOperadores();
			txtFuncion.setText("");
			txtFuncion.setEditable(true);
			txtFuncion.requestFocus();
			btnCalcular.setEnabled(true);
			btnMostrar.setEnabled(true);
			lblModo.setText("Modo actual: PROFESIONAL      ");
			funcion = "";
			JOptionPane.showMessageDialog(null,"Por el momento esto no hace nada :( \n", "Modo Profesional",
                JOptionPane.WARNING_MESSAGE);
		}

		public void deshabilitaOperadores()
		{
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(false);
			}
			btnOR.setEnabled(false);
			btnAND.setEnabled(false);
			btnSE.setEnabled(false);
			btnSSI.setEnabled(false);

		}

		public void habilitaOperadores()
		{
			if(parentClosetoIgnore != 0)
			{
				btnOutParent.setEnabled(true);
			}
			btnOR.setEnabled(true);
			btnAND.setEnabled(true);
			btnSE .setEnabled(true);
			btnSSI .setEnabled(true);
		}

		public void deshabilitaLetras()
		{
			btnNOT.setEnabled(false);
			btnParent.setEnabled(false);
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
			btnCalcular.setEnabled(false);
			btnNOT.setEnabled(true);
			btnParent.setEnabled(true);
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

		public void abrirResultados()
		{
			try
			{
				Process p = Runtime.getRuntime().exec("javac Resultados.java");
				Process p2 = Runtime.getRuntime().exec("java Resultados");
				BufferedReader in = new BufferedReader(new InputStreamReader(p2.getInputStream()));

				OutputStream out = p2.getOutputStream();

				String line = null;
				while ((line = in.readLine()) != null)
				{
					 // line = in.read();
					 System.out.println(line);
				}
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(input);
	
			} 
			catch (IOException ep)
			{
				ep.printStackTrace();
			}
		}
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~FIN MÉTODOS AUXILIARES~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}