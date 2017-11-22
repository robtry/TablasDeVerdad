import java.io.*;
public class Prueba {
  public static void main(String[] args)throws IOException {
    try {
            Process p = Runtime.getRuntime().exec("javac Resultados.java");
            Process p2 = Runtime.getRuntime().exec("java Resultados");
            BufferedReader in = new BufferedReader(new InputStreamReader(p2.getInputStream()));

            OutputStream out = p2.getOutputStream();

            String line = null;
            while ((line = in.readLine()) != null) {

                // line = in.read();
                System.out.println(line);
            }
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(input);
   
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
}