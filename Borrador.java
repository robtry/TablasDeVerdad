import javax.swing.*;
import java.awt.event.*;
class Borrador extends JFrame
{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args)
	{
		Borrador interfaz = new Borrador();
		interfaz.setVisible(true);
	}

	public Borrador()
	{
		/* ===Propiedades de Ventana=== */
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
		setResizable(false);
		setSize(new java.awt.Dimension(300, 330));
		setTitle("Resultado");
		/* =========================== */
		DefaultListModel<String> listModel = new DefaultListModel<>();
		/* ===Iterando=== */
		listModel.addElement("holo");
		/* ============== */
		JList<String> list = new JList<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane listScroller = new JScrollPane();
		listScroller.setViewportView(list);
		list.setModel(listModel);
		getContentPane().add(listScroller);
		setLocationRelativeTo(null);
	}
}