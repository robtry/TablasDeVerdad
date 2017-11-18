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
//Librerias
import java.util.Scanner;
import java.util.Arrays;
//Inicio de la clase
class TablasDeVerdad
{
	public static void main(String[] args)
	{
		String funcion;
		int[] prop = new int[28];
		int cont=0;
		boolean existe=false;


		Scanner l = new Scanner(System.in);


		String caracteresPermitidos="()<->|&abcdefghijklmnñopqrstuvwxyz";

		int[] caracteresPermitidosCC = new int[caracteresPermitidos.length()];
		for (int i=0;i<caracteresPermitidos.length();i++){
			//System.out.printf("%d : %c %n",caracteresPermitidos.codePointAt(i),caracteresPermitidos.codePointAt(i));
			caracteresPermitidosCC[i]=caracteresPermitidos.codePointAt(i);
		}
		
		funcion = l.nextLine();

		//validar solo haya caracteres permitidos simbolos y minisculas
		int parentesisAbiertos=0, parentesisCerrados=0;
		boolean valido=false, sehace=true;
		for (int i=0;i<funcion.length();i++)
		{ //recorriendo toda la cadena
			if(sehace) // ver si vale la pena seguir comparando
			{				
				for (int j=0;j<caracteresPermitidosCC.length;j++) 
				{
					//ver si la letra actual es igual a una de las validas
					if((funcion.codePointAt(i)==caracteresPermitidosCC[j])&&!valido)
					{
						valido = true; //ps si lo fue
						if((funcion.codePointAt(i))==40)
						{
							parentesisAbiertos++;
						}
						else if(funcion.codePointAt(i)==41)
						{
							parentesisCerrados++;
						}
					}
				}		
				if(valido&&sehace)
				{
					//pues si existio, fue un caracter valido
					//System.out.println("Si existio");
					valido = false; //resetear para la siguiente vez
					//sehace = true;
				}
				else
				{	
					//ps no fue valido				
					//System.out.println("pinche cadena inválida");
					sehace = false;//// no se va a hacer!
				}
			}
		}

		if(sehace)
		{
			//simbolos validos
			System.out.println("ps podria hacerse todos los simbolos son validos");
			// ahora validar que el numero de parentesis sea igual
			if(parentesisCerrados==parentesisAbiertos)
			{
				System.out.println("todo bien con num de parentesis");
				//validar tenga sintaxis correcta
				/*
				40 : ( 
				41 : ) 
				60 : < 
				45 : - 
				62 : > 
				124 : | 
				38 : & 
				*/
				//recorrer toda la cadena
				for (int i=0;i<funcion.length();i++)
				{
					int letraAct= funcion.codePointAt(i);

					//despues de estos no puede haber vacio u otro simbolo, lo estar al pricipio
					//|,&,>,-
					if( letraAct == 124|| //|
						letraAct == 38 || //&
						letraAct == 62 || //>
						letraAct == 60 || //<
						letraAct == 45) //-
					{
						//si es uno de esos simbolos
						if(i==funcion.length()-1) //si es ultimo ya esta mal
						{
							System.out.println("error de sinxis simbolo al final");
						}else//no esta al ultimo , pero.. despues hay simbolo?
						{
							int siguienteLetra = funcion.codePointAt(i+1);
							//caso especial 1: <->
							if(letraAct == 60)// <
							{
								//depues de < debe haber si o si ->
								// ver si hay 2 espacios disponibles que iterar en la cadena
								if((i+2)<funcion.length())
								{
									//puedo ver que pasa despues de <
									System.out.println("puedo ver quien hay depues de <");
									//ps lo hago
									if((funcion.codePointAt(i+1))==45) //-
									{
										//okay solo falta ver el ultimo
										if((funcion.codePointAt(i+2))==62)//>
										{
											System.out.println("simbolo valido");
											//si ya todo bien no esta al final y es valido perola pregunta inicial era: depues hay un simbolo?
											siguienteLetra = funcion.codePointAt(i+3);
											if( siguienteLetra == 124|| //|
												siguienteLetra == 38 || //&
												siguienteLetra == 62 || //>
												siguienteLetra == 60 || //<
												siguienteLetra == 45) //-
											{
												//muy valido y todo pero hay un simbolo invalido
												System.out.println("despues de <-> no puede haber simbolos");
											}
											else
											{
												//no hubo nada pero antes?
												System.out.println("podria proceder falta ver que hay antes");

											}


										}
										else
										{
											System.out.println("casi pero nah, falta > depues de <-");
										}
									}
									else
									{
										//hay un <, pero el sig no es - no sirve entonces
										System.out.println("no hay - despues de <");
									}
								}
								else
								{
									// no me alcanza la cadena para ver
									System.out.println("Ni si quiera puedo validar que < esta completo esto esta mas que mal!");
								}
							}//fin de ver que pasa si es: <->
							//caso especial 2: ->



						}//fin de else verificando que hay despues del simbol
					}//if de simbolos, else pues no es caracter a checar por ahora no me importa
				}//for para validacion de sintaxis

			}//if de parentesis
			else
			{
				//hay parentesis de mas o de menos
				System.out.println("hay algo que no concuerda");
			}
		}
		else
		{
			//hubo simbolos invalidos
			System.out.println("no se hace prro de ninguna manerA");
		}


		/*
		//extraer solo las letras
		for(int i=0;i<funcion.length();i++)
		{
			if (Character.isLetter(funcion.codePointAt(i)))
			{
				//es letra!
				//System.out.print("Letra detectada: ");
				//System.out.printf("%c con codepoint ",funcion.codePointAt(i));
				//System.out.printf("%d%n",funcion.codePointAt(i));
				//ps lo agrergo
				while((cont<prop.length)&&(!existe))
				{
					if(prop[cont]==funcion.codePointAt(i))
					{
						//ya existe, ya no tiene caso seguir comparando
						existe = !existe;//false para que exista
					}
					else if(prop[cont]==0)//no son iguales pero es 0?
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
		//ver las letras rescatadas y contar cuantas fueron
		int n0=0;
		for (int i=0;i<prop.length;i++)
		{
			if(prop[i]!=0)
			{
				//System.out.printf("%c ",prop[i]);
				//System.out.printf("%d%n",prop[i]);
				n0++;
			}
		}
		System.out.println();

		//ordenarlas y verlas ordenadasd
		Arrays.sort(prop);
		for (int i=0;i<prop.length;i++)
		{
			if(prop[i]!=0)
			{
				//System.out.printf("%c ",prop[i]);
				//System.out.printf("%d%n",prop[i]);
			}
		}
		System.out.println();


		/// imprimir valores posibles
		double n=0;
		n = Math.pow(2,n0);
		System.out.println("valores de verdad: "+ n);

		// valores de verdad y false que tendria cada prop
		int aux=(int)n/2,aux2cont=0,indiceletraAux=0;
		boolean turnar=false;
		boolean[][] valoresVerdad = new boolean[(int)n][n0];
		for (int i=0;i<prop.length;i++)
		{
			if(prop[i]!=0)// si hay algo en el arreglo
			{
				//System.out.println("aux: "+aux);
				System.out.printf("%c\t",prop[i]);
				for(int j=0;j<n;j++)
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
				//System.out.println();
				aux/=2;
				aux2cont=0;
				turnar = false;
				indiceletraAux++;
			}
		}
		System.out.println();
		//valores en la matriz
		for (int i=0; i<valoresVerdad.length;i++ )
		{
			for (int j=0;j<valoresVerdad[0].length;j++)
			{
				System.out.print(valoresVerdad[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		*/

	}// del main
}// del class