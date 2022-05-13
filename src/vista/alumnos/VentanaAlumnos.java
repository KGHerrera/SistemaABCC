package vista.alumnos;

import controlador.AlumnoDAO;
import modelo.Alumno;
import vista.ResultSetTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaAlumnos extends JInternalFrame implements ActionListener, KeyListener {

    JTextField cajaNumControl, cajaNombre, cajaApePaterno, cajaApeMaterno, cajaEdad;
    JComboBox<String> comboSemestre, comboCarrera;


    ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

    JLabel txtTitulo;

    AlumnoDAO alumnoDAO = new AlumnoDAO();
    Alumno a = new Alumno();

    JButton btnAgregar, btnLimpiar, btnCancelar, btnBuscar;
    int cont = 0;

    public JTable tablaAlumnos;
    JScrollPane scrollAlumnos;



    public VentanaAlumnos() {

        getContentPane().setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Alumnos");
        setSize(1366 / 2, 710);


        txtTitulo = new JLabel("Altas Alumnos");

        cajaNumControl = new JTextField(15);
        cajaNombre = new JTextField(15);
        cajaApePaterno = new JTextField(15);
        cajaApeMaterno = new JTextField(15);

        scrollAlumnos = new JScrollPane();

        cajaEdad = new JTextField(15);

        comboSemestre = new JComboBox<String>();
        comboCarrera = new JComboBox<String>();

        comboCarrera.addItem("selecciona opcion...");
        comboCarrera.addItem("ISC");
        comboCarrera.addItem("IIM");
        comboCarrera.addItem("IIA");
        comboCarrera.addItem("LA");
        comboCarrera.addItem("LC");


        comboSemestre.addItem("selecciona opcion...");
        for (int i = 1; i < 10; i++) {
            comboSemestre.addItem(String.valueOf(i));
        }


        Font fontTitulo = new Font("calibri", Font.BOLD, 20);

        JLabel txtNumControl = new JLabel("numero de control: ");
        JLabel txtNombre = new JLabel("nombre: ");
        JLabel txtApePaterno = new JLabel("apellido paterno: ");
        JLabel txtApeMaterno = new JLabel("apellido materno: ");
        JLabel txtSemestre = new JLabel("semestre: ");
        JLabel txtCarrera = new JLabel("carrera: ");
        JLabel txtEdad = new JLabel("edad: ");

        btnAgregar = new JButton("Agregar");
        btnCancelar = new JButton("Cancelar");
        btnLimpiar = new JButton("Limpiar");
        btnBuscar = new JButton("Buscar");


        tablaAlumnos = new JTable();

        txtTitulo.setFont(fontTitulo);


        txtTitulo.setBounds(this.getWidth() / 10, 40, 200, 20);

        txtNumControl.setBounds(getWidth() / 6, 100, 200, 20);

        txtNombre.setBounds(getWidth() / 6, 140, 200, 20);

        txtApePaterno.setBounds(getWidth() / 6, 180, 200, 20);

        txtApeMaterno.setBounds(getWidth() / 6, 220, 200, 20);

        txtSemestre.setBounds(getWidth() / 6, 260, 200, 20);

        txtCarrera.setBounds(getWidth() / 6, 300, 200, 20);

        txtEdad.setBounds(getWidth() / 6, 340, 200, 20);


        cajaNumControl.setBounds(getWidth() / 6 + 200, 100, 100, 20);

        cajaNombre.setBounds(getWidth() / 6 + 200, 140, 100, 20);

        cajaApePaterno.setBounds(getWidth() / 6 + 200, 180, 100, 20);

        cajaApeMaterno.setBounds(getWidth() / 6 + 200, 220, 100, 20);

        comboSemestre.setBounds(getWidth() / 6 + 200, 260, 100, 20);

        comboCarrera.setBounds(getWidth() / 6 + 200, 300, 100, 20);

        cajaEdad.setBounds(getWidth() / 6 + 200, 340, 100, 20);


        btnBuscar.setBounds(getWidth() / 6 + 400, 100, 100, 20);

        btnAgregar.setBounds(getWidth() / 6 + 400, 220, 100, 20);

        btnLimpiar.setBounds(getWidth() / 6 + 400, 260, 100, 20);

        btnCancelar.setBounds(getWidth() / 6 + 400, 300, 100, 20);

        scrollAlumnos.setBounds(getWidth() / 6, 420, 500, 170);





        add(txtTitulo);
        add(txtNumControl);
        add(txtNombre);
        add(txtApePaterno);
        add(txtApeMaterno);
        add(txtSemestre);
        add(txtCarrera);

        add(txtEdad);

        add(cajaNumControl);
        add(cajaNombre);
        add(cajaApePaterno);
        add(cajaApeMaterno);
        add(comboSemestre);
        add(comboCarrera);
        add(cajaEdad);


        cajaNumControl.addKeyListener(this);
        cajaNombre.addKeyListener(this);
        cajaApePaterno.addKeyListener(this);
        cajaApeMaterno.addKeyListener(this);
        cajaEdad.addKeyListener(this);

        btnAgregar.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnLimpiar.addActionListener(this);
        btnCancelar.addActionListener(this);

        add(btnCancelar);
        add(btnLimpiar);
        add(btnAgregar);
        add(btnBuscar);




        setResizable(true);
        setVisible(true);
        setClosable(true);

        setLocation(getWidth() / 2, 2);

        scrollAlumnos.setViewportView(tablaAlumnos);
        add(scrollAlumnos);
        actualizarTablas(tablaAlumnos);



        tablaAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarDatosAlumnos(e);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == cajaNombre || e.getSource() == cajaApeMaterno || e.getSource() == cajaApePaterno) {
            if (!Character.isLetter(e.getKeyChar())) {
                e.consume();
            }
        }

        if (/*e.getSource() == cajaNumControl ||*/ e.getSource() == cajaEdad) {
            if (!Character.isDigit(e.getKeyChar())) {
                e.consume();
            }
        }
    }

    public void actualizarTabla(ResultSetTableModel rs) {
        try {
            tablaAlumnos.setModel(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void actualizarTablas(JTable tabla) {

        try {
            String consulta = "SELECT * FROM alumnos";
            ResultSetTableModel modeloDatos = null;

            try {
                modeloDatos = new ResultSetTableModel("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/Escuela_Topicos?useTimezone=true&serverTimezone=UTC",
                        consulta);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            tabla.setModel(modeloDatos);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void restablecerComponentes(JComponent... componentes) {
        for (JComponent c : componentes) {

            if (c instanceof JTextField)
                ((JTextField) c).setText("");

            else if (c instanceof JComboBox)
                ((JComboBox) c).setSelectedIndex(0);

            else if (c instanceof JCheckBox)
                ((JCheckBox) c).setSelected(false);
        }
    }

    public void activarCheck(JComponent... componentes) {
        for (JComponent c : componentes) {

            if (c instanceof JCheckBox)
                ((JCheckBox) c).setSelected(true);

        }
    }

    public void activarCajas(JComponent... componentes) {
        for (JComponent c : componentes) {

            if (c instanceof JTextField)
                ((JTextField) c).setEditable(true);

            else if (c instanceof JComboBox)
                ((JComboBox<String>) c).setEnabled(true);

        }
    }

    public void cargarDatosAlumnos(java.awt.event.MouseEvent evt){
        cajaNumControl.setText((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 0));
        cajaNombre.setText((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 1));
        cajaApePaterno.setText((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 2));
        cajaApeMaterno.setText((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 3));
        cajaEdad.setText(String.valueOf(tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 4)));
        comboSemestre.setSelectedItem((String.valueOf(tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 5))));
        comboCarrera.setSelectedItem((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 6));
    }

    public void cargarDatosAlumnos(){
        cajaNumControl.setText((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 0));
        cajaNombre.setText((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 1));
        cajaApePaterno.setText((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 2));
        cajaApeMaterno.setText((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 3));
        cajaEdad.setText(String.valueOf(tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 4)));
        comboSemestre.setSelectedItem((String.valueOf(tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 5))));
        comboCarrera.setSelectedItem((String) tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 6));
    }

    public void funcionalidadBotones(ActionEvent e) {

        if (e.getSource() == btnBuscar && !cajaNumControl.getText().equals("")) {

            Alumno a1 = alumnoDAO.buscarAlumnoID(cajaNumControl.getText());

            if (a1 != null) {
                cajaNombre.setText(a1.getNombre());
                cajaApePaterno.setText(a1.getPrimerAp());
                cajaApeMaterno.setText(a1.getSegundoAp());
                cajaEdad.setText(String.valueOf(a1.getEdad()));
                comboSemestre.setSelectedItem(String.valueOf(a1.getSemestre()));
                comboCarrera.setSelectedItem(a1.getCarrera());
            }
        }

        else if (e.getSource() == btnLimpiar) {
            restablecerComponentes(cajaNumControl, cajaNombre, cajaApePaterno, cajaApeMaterno, cajaEdad, comboCarrera, comboSemestre);
        }
    }



    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
