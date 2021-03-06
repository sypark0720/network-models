package soc.pr2.application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import soc.pr2.models.BarabasiAlbert;
import soc.pr2.models.ErdosRenyi;

public class Interfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public static JTextArea textArea;
	public static JButton btndoneal;
	public static JButton btndonebar;
	public static JProgressBar barra;

	/**
	 * Create the frame.
	 */
	public Interfaz() {

		super("Generador De Redes Gephi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setUndecorated(true);
		setBounds(100, 100, 575, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// *************** Panel acciones principales

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(null,
				"Acciones Inmediatas", TitledBorder.LEFT, TitledBorder.TOP,
				new Font("times new roman", Font.PLAIN, 19), Color.white));
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();

		panel_3.setBackground(Color.BLACK);
		panel.add(panel_3);

		final JButton btnexportar = new JButton(new ImageIcon(getClass()
				.getResource("/soc/pr2/media/play.png")));
		panel_3.add(btnexportar);

		final JButton btnresetear = new JButton(new ImageIcon(getClass()
				.getResource("/soc/pr2/media/off.png")));
		panel_3.add(btnresetear);

		final JButton btnenlazar = new JButton(new ImageIcon(getClass()
				.getResource("/soc/pr2/media/firefox.png")));
		panel_3.add(btnenlazar);

		// Acciones Botones superiores

		btnexportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								btnexportar,
								"== ¿Qué podemos realizar con la aplicación? ==\n\n"
										+ "Podremos generar redes en formato csv\n\n"
										+ "== Paneles de la Aplicación ==============\n"
										+ "\n"
										+ "Panel de acciones inmediatas:\n"
										+ "\n"
										+ "		1. Ayuda de la aplicación.\n"
										+ "		2. Cierre rápido de la aplicación.\n"
										+ "		3. Redirección a sitios externos de interés.\n"
										+ "\n"
										+ " Panel Modelo Aleatorio:\n"
										+ "\n"
										+ "		1. Ayuda de cómo funciona el modelo.\n"
										+ "		2. Ejecutar el modelo Aleatorio.\n\n"
										+ "Panel Modelo Barabasi:\n"
										+ "\n"
										+ "		1. Ayuda de cómo funciona el modelo.\n"
										+ "		2. Ejecutar el modelo de Barabasi.\n\n"
										+ "Panel Información del sistema:\n"
										+ "\n"
										+ "		1. Mensajes de información de la propia aplicación.\n\n"
										+ "Panel de estado\n\n"
										+ "		1. Licencia de la aplicación.\n"
										+ "		2. Último modelo utilizado.\n"
										+ "		3. Barra de Progreso del modelo ejecutado.\n",
								"Generador De Redes",
								JOptionPane.OK_CANCEL_OPTION,
								new ImageIcon(getClass().getResource(
										"/soc/pr2/media/captura.png")));

			}
		});

		btnresetear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(btnresetear,
						"¿Desea cerrar la aplicación?", "Cierre rápido", 0,
						JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass()
								.getResource("/soc/pr2/media/off.png"))) == 0)
					System.exit(0);
			}
		});

		btnenlazar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog(
						btnenlazar,
						"Seleccione opcion",
						"Selector de opciones",
						JOptionPane.QUESTION_MESSAGE,
						new ImageIcon(getClass().getResource(
								"/soc/pr2/media/firefox.png")), // null
																// para
																// icono
																// defecto
						new Object[] { "www.github.com", "www.gephi.com",
								"www.otroejemplo.com" }, "opcion 1");
			}
		});

		// **************************** Panel modelo aleatorio

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_1.add(panel_4);
		panel_4.setBorder(BorderFactory.createTitledBorder(null,
				"Modelo Aleatorio", TitledBorder.LEFT, TitledBorder.TOP,
				new Font("times new roman", Font.PLAIN, 19), Color.white));
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.BLACK);
		panel_4.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_9 = new JPanel();
		panel_9.setForeground(Color.WHITE);
		panel_9.setBackground(Color.BLACK);
		panel_8.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Número Nodos (n)");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		panel_9.add(lblNewLabel);

		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		panel_9.add(textField);
		textField.setColumns(10);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.BLACK);
		panel_8.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Probabilidad (p)");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(SystemColor.activeCaption);
		panel_11.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setBackground(Color.WHITE);
		panel_11.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLACK);
		panel_4.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(1, 2, 0, 0));

		final JButton btninfoal = new JButton(new ImageIcon(getClass()
				.getResource("/soc/pr2/media/info_icon.png")));

		panel_6.add(btninfoal);

		btndoneal = new JButton(new ImageIcon(getClass().getResource(
				"/soc/pr2/media/int.png")));

		panel_6.add(btndoneal);

		// Acciones de los botones del panel aleatorio

		btninfoal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								btninfoal,
								"== Modelo ==\n"
										+ "\n"
										+ " Una red aleatoria es una red en la que cada uno de los enlaces entre dos nodos se ha creado siguiendo un proceso\n"
										+ " completamente aleatorio.\n"
										+ "\n"
										+ " De manera más matemática podemos decir que una red aleatoria es una red que tiene N nodos donde cada nodo puede\n"
										+ " puede estar conectado con otro con una probabilidad p.\n"
										+ "\n"
										+ "== Cómo funciona el panel ==\n"
										+ "\n"
										+ "  1. Debemos de introducir un número de nodos iniciales en el primer campo (debe de ser mayor que 1.\n"
										+ "  2. Acto seguido introducimos la probabilidad  en el segundo campo (debe de ser mayor que 0 y menor que 1).\n"
										+ "  3. Una vez realizado esto pulsamos en el botón de ejecutar.\n"
										+ "  4. Podremos observar como va el progreso de nuestro proceso en la barra de progreso inferior.\n"
										+ "  5. Por último debemos guardar nuestro archivo en formato .csv donde nosotros deseemos."
										+ "\n\n",
								"Modelo Barabasi",
								JOptionPane.OK_CANCEL_OPTION,
								new ImageIcon(getClass().getResource(
										"/soc/pr2/media/Erdos.png")));

			}
		});

		// el botón play está implementado en la zona panel información
		// sistema

		// ********************** Panel Barabasi

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setBorder(BorderFactory.createTitledBorder(null,
				"Modelo Barabasi", TitledBorder.LEFT, TitledBorder.TOP,
				new Font("times new roman", Font.PLAIN, 19), Color.white));
		panel_1.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.BLACK);
		panel_10.add(panel_12);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_2 = new JLabel("Nodos Iniciales (m)");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.WHITE);
		panel_12.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setBackground(Color.WHITE);
		panel_12.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.BLACK);
		panel_10.add(panel_13);
		panel_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_3 = new JLabel("Nodos a Insertar (t)");
		lblNewLabel_3.setForeground(Color.WHITE);
		panel_13.add(lblNewLabel_3);

		textField_3 = new JTextField();
		panel_13.add(textField_3);
		textField_3.setColumns(10);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.BLACK);
		panel_5.add(panel_14, BorderLayout.SOUTH);
		panel_14.setLayout(new GridLayout(0, 2, 0, 0));

		final JButton btninfobar = new JButton(new ImageIcon(getClass()
				.getResource("/soc/pr2/media/info_icon.png")));

		panel_14.add(btninfobar);

		btndonebar = new JButton(new ImageIcon(getClass().getResource(
				"/soc/pr2/media/int.png")));

		panel_14.add(btndonebar);

		// Accciones botones Panel Barabasi

		UIManager.put("OptionPane.background", Color.WHITE);
		UIManager.put("Panel.background", Color.WHITE);
		UIManager.put("OptionPane.messageForeground", Color.black);

		btninfobar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								btninfobar,
								"== Modelo ==\n"
										+ "\n"
										+ " Partimos de una distribución inicial aleatoria de nodos y todos los nodos tienen al menos un enlace.\n"
										+ "\n"
										+ " La red evoluciona añadiendo en cada tiempo determinado un nuevo nodo a la red con un número de enlaces\n"
										+ " menor al de los iniciales y se unirá al mismo número de nodos que enlaces tiene.\n"
										+ "\n"
										+ " La probabilidad de establecer un enlace con uno de los nodos iniciales dependerá del grado del propio nodo inicial.\n"
										+ "\n"
										+ "== Cómo funciona el panel ==\n"
										+ "\n"
										+ "  1. Debemos de introducir un número de nodos iniciales en el primer campo.\n"
										+ "  2. Acto seguido introducimos un número de nodos a añadir en el segundo campo.\n"
										+ "  3. Una vez realizado esto pulsamos en el botón de ejecutar.\n"
										+ "  4. Podremos observar como va el progreso de nuestro proceso en la barra de progreso inferior.\n"
										+ "  5. Por último debemos guardar nuestro archivo en formato .csv donde nosotros deseemos."
										+ "\n\n",
								"Modelo Barabasi",
								JOptionPane.OK_CANCEL_OPTION,
								new ImageIcon(getClass().getResource(
										"/soc/pr2/media/Barabasi_Albert.png")));

			}
		});

		// **********************Panel Información del sistema

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBorder(BorderFactory.createTitledBorder(null,
				"Información Del Sistema", TitledBorder.LEFT, TitledBorder.TOP,
				new Font("times new roman", Font.PLAIN, 19), Color.white));
		textArea.setForeground(Color.CYAN);
		textArea.setBackground(Color.BLACK);
		panel_2.add(textArea);

		// ********************** Panel de estado

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(BorderFactory.createTitledBorder(null, null,
				TitledBorder.LEFT, TitledBorder.TOP, new Font(
						"times new roman", Font.PLAIN, 19), Color.white));
		panel_7.setBackground(Color.BLACK);
		panel_2.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 3, 0, 0));

		final JButton btnnosotros = new JButton("Sobre Nosotros");
		btnnosotros.setBackground(Color.BLACK);
		btnnosotros.setForeground(Color.WHITE);
		panel_7.add(btnnosotros);

		final JLabel lblModelo = new JLabel("  Sin previo Modelo");
		lblModelo.setBackground(Color.BLACK);
		lblModelo.setForeground(Color.CYAN);
		panel_7.add(lblModelo);

		barra = new JProgressBar();
		panel_7.add(barra);
		barra.setValue(0);
		barra.setMaximum(100);
		barra.setMinimum(0);
		barra.setStringPainted(true);

		// Accion Botón Sobre Nosotros

		btnnosotros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								btnnosotros,
								" Esta aplicación tiene una licencia GPL3 y ha sido desarrollada\n por "
										+ " los siguientes alumnos de la Universidad Complutense de Madrid\n"
										+ " como práctica dos, de la asignatura Análisis de Redes Sociales.\n\n"
										+ " Jaime Ramos\n"
										+ " Alejandro Pequeño Pulleiro\n"
										+ " Roberto García Sánchez\n" + "\n\n",
								"Licencia Aplicación",
								JOptionPane.OK_CANCEL_OPTION,
								new ImageIcon(getClass().getResource(
										"/soc/pr2/media/GPLv3.png")));

			}

		});

		btndoneal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				if (textField.getText().trim().length() == 0
						|| textField_1.getText().trim().length() == 0)
					JOptionPane.showMessageDialog(
							null,
							"Debes introducir valores en ambos campos",
							"Mensaje Informativo",
							JOptionPane.OK_CANCEL_OPTION,
							new ImageIcon(getClass().getResource(
									"/soc/pr2/media/warning.gif")));
				else if (textField_1.getText().contains(","))
					JOptionPane
							.showMessageDialog(
									null,
									"El formato decimal sólo se acepta por punto ('.')",
									"Mensaje Informativo",
									JOptionPane.OK_CANCEL_OPTION,
									new ImageIcon(getClass().getResource(
											"/soc/pr2/media/warning.gif")));
				else {
					long nodosAl = (long) Long.parseLong(textField.getText());
					float probabilidad = (float) Float.parseFloat(textField_1
							.getText());

					if (nodosAl < 2) {
						textArea.setText("Número de nodos introducido no válido: ["
								+ nodosAl + "] Debe de ser mayor que 2");
						JOptionPane.showMessageDialog(
								null,
								"Número de nodos introducido no válido",
								"Mensaje Informativo",
								JOptionPane.OK_CANCEL_OPTION,
								new ImageIcon(getClass().getResource(
										"/soc/pr2/media/warning.gif")));
					} else if (probabilidad < 0 || probabilidad > 1) {
						textArea.setText("Probabilidad introducida no válida: ["
								+ probabilidad
								+ "] Debe de ser un valor entre 0 y 1");
						JOptionPane.showMessageDialog(
								null,
								"Probabilidad introducida no válida",
								"Mensaje Informativo",
								JOptionPane.OK_CANCEL_OPTION,
								new ImageIcon(getClass().getResource(
										"/soc/pr2/media/warning.gif")));
					} else {
						textArea.setText("Ha ejecutado la aplicación usando el modelo aleatorio");
						/*
						 * SwingUtilities.invokeLater(new ErdosRenyi(nodosAl,
						 * probabilidad, textArea));
						 */

						ErdosRenyi model = new ErdosRenyi(nodosAl, probabilidad);
						model.execute();

						setRunButton(false);
						lblModelo.setText(" Utilizado: Aleatorio");

					}
				}
			}
		});

		btndonebar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				if (textField_2.getText().trim().length() == 0
						|| textField_3.getText().trim().length() == 0)
					JOptionPane.showMessageDialog(
							null,
							"Debes introducir valores en ambos campos",
							"Mensaje Informativo",
							JOptionPane.OK_CANCEL_OPTION,
							new ImageIcon(getClass().getResource(
									"/soc/pr2/media/warning.gif")));
				else {
					long nodosIniBar = (long) Long.parseLong(textField_2
							.getText());
					int nodosNuevBar = Integer.parseInt(textField_3.getText());

					if (nodosIniBar < 2) {
						textArea.setText("Número de nodos iniciales introducido no válido: ["
								+ nodosIniBar + "] Debe de ser mayor que 2");
						JOptionPane.showMessageDialog(
								null,
								"Número de nodos iniciales no válido.",
								"Mensaje Informativo",
								JOptionPane.OK_CANCEL_OPTION,
								new ImageIcon(getClass().getResource(
										"/soc/pr2/media/warning.gif")));
					}

					else if (nodosNuevBar < 0) {
						textArea.setText("Número de nodos nuevos a introducir no válido: ["
								+ nodosNuevBar + "] Debe de ser positivo o 0");
						JOptionPane.showMessageDialog(
								null,
								"Número de nodos a insertar no válido.",
								"Mensaje Informativo",
								JOptionPane.OK_CANCEL_OPTION,
								new ImageIcon(getClass().getResource(
										"/soc/pr2/media/warning.gif")));
					} else {
						textArea.setText("Ha ejecutado el programa mediante la opción modelo Barabasi");
						BarabasiAlbert model = new BarabasiAlbert(nodosIniBar,
								nodosNuevBar);
						model.execute();
						setRunButton(false);
						lblModelo.setText(" Utilizado: Barabasi");
					}
				}
			}
		});

		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public static void setRunButton(boolean b) {
		btndoneal.setEnabled(b);
		btndonebar.setEnabled(b);
	}

	public static void setStatusProgress(int status) {
		barra.setValue(status);
		if (status == 100)
			textArea.setText(" Red Generada con éxito");

	}

}
