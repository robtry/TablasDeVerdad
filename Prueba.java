import java.io.*;
public class Prueba {

  private static void printLines(InputStream ins) throws Exception {
    String line = null;
    BufferedReader in = new BufferedReader(new InputStreamReader(ins));
    while ((line = in.readLine()) != null) {
        System.out.println(line);
    }
  }

  public static void main(String[] args)throws IOException {
    File archivo;
    archivo = new File("Main.java");
    archivo.createNewFile();
    FileWriter escritor = new FileWriter(archivo);
    PrintWriter pw = new PrintWriter(escritor);

    String programa="class Main{%npublic static void main(String[] args){%n";
    programa+="//Tabla ventanaGrafica = new Tabla();";
    programa+="//ventanaGrafica.setVisible(true);"
    programa+="%n}%n}";

    pw.printf(programa);
    escritor.close();
    try {
      Process pro = Runtime.getRuntime().exec("javac Main.java");
      pro = Runtime.getRuntime().exec("java Main");
      printLines(pro.getInputStream());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}