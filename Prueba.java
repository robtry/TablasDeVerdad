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
	archivo = new File("Principal.java");
	archivo.createNewFile();
	FileWriter escritor = new FileWriter(archivo);
	PrintWriter pw = new PrintWriter(escritor);

	String programa = "import javax.swing.*; %n";
	programa += "import java.awt.event.*; %n";
	programa += "import java.io.*;%n";
	programa += "class Principal extends JFrame %n"; 
	programa += "{%n";
	programa += "\tpublic static void main(String[] args)%n";
	programa += "\t{%n";
	programa += "\t\tPrincipal interfaz = new Principal();%n";
	programa += "\t\tinterfaz.setVisible(true);%n";
	programa += "\t\tSystem.out.println(\"trabaja?\");%n";
	programa += "\t}";
	programa += "%n\tpublic Principal()%n\t{%n";
	programa += "\t\tsetDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);%n";
	programa += "\t\tsetResizable(false);%n";
	programa += "\t\tsetSize(new java.awt.Dimension(300, 330));%n";
	programa += "\t\tsetTitle(\"Resultado\");%n";
	programa += "\t\tDefaultListModel<String> listModel = new DefaultListModel<>();%n";
	/* ===Aqui va haber que iterar === */
	programa += "\t\t\tlistModel.addElement(\"holo\");%n";
	/* =============================== */
	programa += "\t\tJList<String> list = new JList<>();%n";
	programa += "\t\tlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);%n";
	programa += "\t\tJScrollPane listScroller = new JScrollPane();%n";
	programa += "\t\tlistScroller.setViewportView(list);%n";
	programa += "\t\tlist.setModel(listModel);%n";
	programa += "\t\tgetContentPane().add(listScroller);%n";
	programa += "\t\tsetLocationRelativeTo(null);%n";
	//programa += "\t\t%n";
	programa += "\t}";
	programa += "%n}";

	pw.printf(programa);
	escritor.close();
	
	try {
	  Process pro = Runtime.getRuntime().exec("javac Principal.java");
	  pro = Runtime.getRuntime().exec("java Principal");
	  printLines(pro.getInputStream());
	} catch (Exception e) {
	  e.printStackTrace();
	}
  }
}