import java.util.Scanner;
import java.util.Arrays;
class TablasDeVerdad
{
	public static void main(String[] args)
	{
		String funcion;
		int[] prop = new int[28];
		int propsize= prop.length,cont=0;
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
				while((cont<propsize)&&(!existe))
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
		//ver las cletras rescatadas
		for (int i=0;i<prop.length;i++)
		{
			if(prop[i]!=0)
			{
				System.out.printf("%c ",prop[i]);
				System.out.printf("%d%n",prop[i]);
			}
		}
		System.out.println();
		Arrays.sort(prop);
		//ordenadas
		for (int i=0;i<prop.length;i++)
		{
			if(prop[i]!=0)
			{
				System.out.printf("%c ",prop[i]);
				System.out.printf("%d%n",prop[i]);
			}
		}
		System.out.println();
		///
	}
}