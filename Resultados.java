import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class Resultados
{
	public static void main(String[] args)
	{
		try
		{
			File archivo;
			archivo = new File("Resultados.txt");
			archivo.createNewFile();
			FileWriter escritor = new FileWriter(archivo);
			PrintWriter pw = new PrintWriter(escritor);
			pw.printf("p\t");
			pw.printf("q\t");
			pw.printf("|\tp->q");
			pw.printf("%n----------------------------------%n");
			pw.printf("f\t");
			pw.printf("f\t");
			pw.printf("|\t%n----------------------------------%n");
			pw.printf("f\t");
			pw.printf("v\t");
			pw.printf("|\t%n----------------------------------%n");
			pw.printf("v\t");
			pw.printf("f\t");
			pw.printf("|\t%n----------------------------------%n");
			pw.printf("v\t");
			pw.printf("v\t");
			pw.printf("|\t%n----------------------------------%n");
			escritor.close();
		}
		catch(IOException ev)
		{
			ev.printStackTrace();
		}
	}
}