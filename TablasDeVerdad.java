import java.util.Scanner;
import java.util.Arrays;

class TablasDeVerdad
{
	public static void main(String[] args)
	{
		String funcion;
		int[] prop = new int[28];
		int cont=0;
		boolean existe=false;

		Scanner l = new Scanner(System.in);

		funcion = l.nextLine();

		for(int i=0;i<funcion.length();i++)
		{
			if (Character.isLetter(funcion.codePointAt(i)))
			{
				//es letra!
				System.out.print("Letra detectada: ");
				System.out.printf("%c con codepoint ",funcion.codePointAt(i));
				System.out.printf("%d%n",funcion.codePointAt(i));
				//ps lo agrergo
				while((cont<prop.length)&&(!existe))
				{
					if(prop[cont]==funcion.codePointAt(i))
					{
						//ya existe, ya no tiene caso comparar
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
		//ver las letras rescatadas
		int n0=0;
		double n=0;
		for (int i=0;i<prop.length;i++)
		{
			if(prop[i]!=0)
			{
				System.out.printf("%c ",prop[i]);
				System.out.printf("%d%n",prop[i]);
				n0++;
			}
		}
		System.out.println();
		//ordenarlas
		Arrays.sort(prop);
		for (int i=0;i<prop.length;i++)
		{
			if(prop[i]!=0)
			{
				System.out.printf("%c ",prop[i]);
				System.out.printf("%d%n",prop[i]);
			}
		}
		System.out.println();

		/// imprimir valores posibles
		n = Math.pow(2,n0);
		System.out.println("valores de verdad: "+ n);

		// valores de verdad y false que tendria cada prop
		int aux=(int)n/2,aux2cont=0,indiceletraAux=0;
		boolean turnar=false;
		boolean[][] valoresVerdad = new boolean[(int)n][n0];
		for (int i=0;i<prop.length;i++)
		{
			if(prop[i]!=0)
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
	}
}