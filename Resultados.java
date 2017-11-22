import javax.swing.*; 
import java.awt.event.*; 
import java.io.*;
class Main extends JFrame 
{
	public static void main(String[] args)
	{
		Resultado interfaz = new Resultado();
		interfaz.setVisible(true);
	}
	public Resultados()
	{
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(new java.awt.Dimension(300, 330));
		setTitle("Resultado");
		DefaultListModel<String> listModel = new DefaultListModel<>();
			listModel.addElement("holo");
		JList<String> list = new JList<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane listScroller = new JScrollPane();
		listScroller.setViewportView(list);
		list.setModel(listModel);
		getContentPane().add(listScroller);
		setLocationRelativeTo(null);
	}
}