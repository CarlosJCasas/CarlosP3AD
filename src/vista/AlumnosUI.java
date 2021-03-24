package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.vo.AlumnoVO;
import modelo.vo.CursaVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public abstract class AlumnosUI extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField nombreTextField;
	private JTextField primerApTextField;
	private JTextField segundoApTextField;
	private JTextField dniTextField;
	private JTextField fniceTextField;
	private JTextField telfTextField;
	private JTextField anhoTextField = new JTextField();
	private JTextField notaTextField = new JTextField();
	private JTable table;
	private Integer idModulo;
	private boolean control = false;
	private JButton btnEliminar, btnAceptar, btnLimpiar;

	/**
	 * Create the frame.
	 */
	public AlumnosUI() {
		anhoTextField.setEnabled(false);
		notaTextField.setEnabled(false);
		initialize();
	}

	public AlumnosUI(Integer idModulo2) {
		this.idModulo = idModulo2;
		initialize();
	}

	public void show() {
		frame.setVisible(true);
	}

	protected abstract void addAlumno(String dni, String nombre, String ap1, String ap2, int telefono, Date fecha) throws SQLException;

	protected abstract void actualizarAlumno(String dni, String nombre, String ap1, String ap2, int telefono,
			Date fecha);

	protected abstract void eliminarAlumno(String dni);

	protected abstract List<AlumnoVO> listadoAlumnos();

	protected abstract void addCursa(CursaVO cursa);

	protected abstract void actualizarCursa(Integer idmod, String dnial, String anho, Double nota);

	protected abstract void eliminarCursa(Integer id, String dni);

	protected abstract List<CursaVO> listadoCursa();

	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(150, 150, 933, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(35, 23, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setBounds(226, 23, 88, 14);
		contentPane.add(lblPrimerApellido);

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(421, 23, 106, 14);
		contentPane.add(lblSegundoApellido);

		nombreTextField = new JTextField();
		nombreTextField.setBounds(35, 45, 181, 20);
		contentPane.add(nombreTextField);
		nombreTextField.setColumns(10);

		primerApTextField = new JTextField();
		primerApTextField.setBounds(226, 45, 185, 20);
		contentPane.add(primerApTextField);
		primerApTextField.setColumns(10);

		segundoApTextField = new JTextField();
		segundoApTextField.setBounds(421, 45, 173, 20);
		contentPane.add(segundoApTextField);
		segundoApTextField.setColumns(10);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(35, 76, 46, 14);
		contentPane.add(lblDni);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(226, 76, 150, 14);
		contentPane.add(lblFechaDeNacimiento);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(421, 76, 64, 14);
		contentPane.add(lblTelefono);

		dniTextField = new JTextField();
		dniTextField.setBounds(35, 101, 181, 20);
		contentPane.add(dniTextField);
		dniTextField.setColumns(10);

		fniceTextField = new JTextField();
		fniceTextField.setBounds(226, 101, 185, 20);
		contentPane.add(fniceTextField);
		fniceTextField.setColumns(10);

		telfTextField = new JTextField();
		telfTextField.setBounds(421, 101, 173, 20);
		contentPane.add(telfTextField);
		telfTextField.setColumns(10);

		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(604, 76, 46, 14);
		contentPane.add(lblAo);

		JLabel lblNota = new JLabel("Nota");
		lblNota.setBounds(672, 76, 46, 14);
		contentPane.add(lblNota);

		
		anhoTextField.setBounds(604, 101, 58, 20);
		contentPane.add(anhoTextField);
		anhoTextField.setColumns(10);

		
		notaTextField.setBounds(672, 101, 58, 20);
		contentPane.add(notaTextField);
		notaTextField.setColumns(10);
		/*
		 * ACEPTAR
		 */
		btnAceptar = new JButton("Añadir");
		btnAceptar.setBounds(800, 33, 89, 23);
		btnAceptar.addMouseListener(new MouseAdapter() {
			// Añade un nuevo alumno al modulo o a la base de datos en general
			@Override
			public void mouseClicked(MouseEvent e) {
				if (dniTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "El campo DNI es obligatorio.");
				} else {
					if (control) {
						// Aqui esta editando un alumno ya creado, no permitir cambiar el DNI
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaNacimiento = null;
						try {
							if(!fniceTextField.getText().isEmpty()) {
								fechaNacimiento = format.parse(fniceTextField.getText());
							}
							actualizarAlumno(dniTextField.getText(), nombreTextField.getText(),
									primerApTextField.getText(), segundoApTextField.getText(),
									Integer.parseInt(telfTextField.getText()), fechaNacimiento);
							limpiarCampos();
							recargarTabla();
							dniTextField.setEditable(true);
						} catch (ParseException e1) {
							JOptionPane.showMessageDialog(frame,
									"El DNI está vacio o el formato de la fecha es incorrecto (dd/MM/aaaa)");
						}
					}

					if (!control && !dniTextField.getText().isEmpty()) {
						// Si control es false y dni es no null, está agregando uno nuevo
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaNacimiento = null;
						try {
							
							fechaNacimiento = format.parse(fniceTextField.getText());
							
							
							addAlumno(dniTextField.getText(), nombreTextField.getText(),
									primerApTextField.getText(), segundoApTextField.getText(),
									Integer.parseInt(telfTextField.getText()), fechaNacimiento);
							if(idModulo != null && !anhoTextField.getText().isEmpty() && !notaTextField.getText().isEmpty() ) {
								try {
									double nota = Double.parseDouble(notaTextField.getText());
									CursaVO cursa = new CursaVO(dniTextField.getText(), idModulo, anhoTextField.getText(), nota);
									addCursa(cursa);
								} catch (NumberFormatException e1) {
									JOptionPane.showMessageDialog(frame,
											"La nota debe ser un número.");
								}
							}
							
							limpiarCampos();
							recargarTabla();
							dniTextField.setEditable(true);
						} catch (ParseException e1) {
							if(fniceTextField.getText().isEmpty()) {
								JOptionPane.showMessageDialog(frame,
										"La fecha es obligatoria.");
							}
							JOptionPane.showMessageDialog(frame,
									"El formato de la fecha es incorrecto (dd/MM/aaaa)");
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(frame,
									"El telefono ha de ser un número");
						} catch (SQLException e2) {
							JOptionPane.showMessageDialog(frame,
									"El alumno con el DNI "+ dniTextField.getText()+ " ya existe.");
						}
					}
				}

			}

		});
		contentPane.add(btnAceptar);

		/*
		 * LIMPIAR
		 */
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(800, 67, 89, 23);
		btnLimpiar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				limpiarCampos();
				dniTextField.setEditable(true);
				control = false;
			}

		});
		contentPane.add(btnLimpiar);
		/*
		 * ELIMINAR
		 */
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (dniTextField.getText() != null) {
					int resultado = JOptionPane.showConfirmDialog(null,
							"¿Quieres eliminar a " + nombreTextField.getText() + " de la base de datos?", "Eliminar",
							JOptionPane.OK_CANCEL_OPTION);
					if (resultado == JOptionPane.OK_OPTION) {
						eliminarAlumno(dniTextField.getText());
						if (idModulo != null) {
							eliminarCursa(idModulo, dniTextField.getText());
						}
						limpiarCampos();
						recargarTabla();
					}
				}

			}
		});

		btnEliminar.setBounds(800, 100, 89, 23);
		contentPane.add(btnEliminar);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 142, 897, 2);
		contentPane.add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 161, 897, 332);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				btnEliminar.setEnabled(true);
				btnAceptar.setText("Actualizar");
				control = true;
				dniTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 0));
				dniTextField.setEditable(false);
				nombreTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 1));
				primerApTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 2));
				segundoApTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 3));
				fniceTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 4));
				telfTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 5));
				anhoTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 6));
				notaTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 7));

			}

		});
		scrollPane.setViewportView(table);

		recargarTabla();

	}

	private void recargarTabla() {
		DefaultTableModel tablemodel = new DefaultTableModel();
		tablemodel.addColumn("DNI");
		tablemodel.addColumn("Nombre");
		tablemodel.addColumn("Primer apellido");
		tablemodel.addColumn("Segundo apellido");
		tablemodel.addColumn("Fecha nacimiento");
		tablemodel.addColumn("Teléfono");
		tablemodel.addColumn("Año");
		tablemodel.addColumn("Nota");
		if (idModulo == null) {
			for (AlumnoVO alumno : listadoAlumnos()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String fechanacimiento = dateFormat.format(alumno.getFnacimiento());
				String[] row = new String[] { alumno.getDni(), alumno.getNombre(), alumno.getApellido1(),
						alumno.getApellido2(), fechanacimiento, String.valueOf(alumno.getTelf()), "", "" };
				tablemodel.addRow(row);
			}
		} else {
			for (AlumnoVO alumno : listadoAlumnos()) {
				for (CursaVO cursa : listadoCursa()) {
					if (alumno.getDni().equalsIgnoreCase(cursa.getDni()) && idModulo == cursa.getIdModulo()) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						String fechanacimiento = dateFormat.format(alumno.getFnacimiento());
						String[] row = new String[] { alumno.getDni(), alumno.getNombre(), alumno.getApellido1(),
								alumno.getApellido2(), fechanacimiento, String.valueOf(alumno.getTelf()),
								cursa.getAnho(), String.valueOf(cursa.getNota()) };
						tablemodel.addRow(row);
					}
				}
			}
		}

		table.setModel(tablemodel);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(170);
		table.getColumnModel().getColumn(3).setPreferredWidth(170);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(40);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}

	private void limpiarCampos() {
		btnAceptar.setText("Añadir");
		btnEliminar.setEnabled(false);
		dniTextField.setText("");
		nombreTextField.setText("");
		primerApTextField.setText("");
		segundoApTextField.setText("");
		telfTextField.setText("");
		notaTextField.setText("");
		anhoTextField.setText("");
		fniceTextField.setText("");

	}
}
