package vista.alumnos;

import modelo.Alumno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultasAlumnos extends VentanaAlumnos {

    JRadioButton radioISC, radioIM, radioIIA, radioLA, radioLC;
    Alumno a2 = new Alumno();
    ButtonGroup radioCarreras;
    JButton btnBajar, btnSubir,btnPrimero, btnUltimo;
    JTextField cajaRow;
    JButton btnMostrarTodo;
    JCheckBox checkNumControl, checkNombre, checkApePaterno, checkApeMaterno, checkSemestre, checkCarrera, checkTodo, checkEdad;

    public ConsultasAlumnos() {

        txtTitulo.setText("Consultas Alumnos");
        btnAgregar.setText("consultar");
        JLabel txtSelecciona = new JLabel("Selecciona criterio de busqueda: ");

        btnMostrarTodo = new JButton("ver todos");


        btnMostrarTodo.addActionListener(this);

        txtSelecciona.setBounds(this.getWidth() / 10, 70, 200, 20);

        checkNumControl = new JCheckBox();
        checkNombre = new JCheckBox();
        checkApeMaterno = new JCheckBox();
        checkApePaterno = new JCheckBox();
        checkSemestre = new JCheckBox();
        checkCarrera = new JCheckBox();
        checkEdad = new JCheckBox();

        cajaNumControl.setEditable(false);
        cajaNombre.setEditable(false);
        cajaApePaterno.setEditable(false);
        cajaApeMaterno.setEditable(false);
        cajaEdad.setEditable(false);
        comboCarrera.setEnabled(false);
        comboSemestre.setEnabled(false);



        btnBajar = new JButton(">");
        btnSubir = new JButton("<");

        btnUltimo = new JButton(">|");
        btnPrimero = new JButton("|<");
        cajaRow = new JTextField();
        cajaRow.setEditable(false);

        checkNumControl.setBounds(getWidth() / 8, 100, 20, 20);

        checkNombre.setBounds(getWidth() / 8, 140, 20, 20);

        checkApePaterno.setBounds(getWidth() / 8, 180, 20, 20);

        checkApeMaterno.setBounds(getWidth() / 8, 220, 20, 20);

        checkSemestre.setBounds(getWidth() / 8, 260, 20, 20);

        checkCarrera.setBounds(getWidth() / 8, 300, 20, 20);

        checkEdad.setBounds(getWidth() / 8, 340, 20, 20);

        btnSubir.setBounds(getWidth() / 2 -100, 420 + 200, 50, 20);
        btnBajar.setBounds(getWidth() / 2 +100, 420 + 200, 50, 20);

        btnPrimero.setBounds(getWidth() / 2 -200, 420 + 200, 50, 20);
        btnUltimo.setBounds(getWidth() / 2 +200, 420 + 200, 50, 20);
        cajaRow.setBounds(getWidth() / 2 , 420 + 200, 50, 20);

        btnMostrarTodo.setBounds(getWidth() / 6 + 400, 140, 100, 20);


        add(checkNumControl);
        add(checkNombre);
        add(checkApePaterno);
        add(checkApeMaterno);
        add(checkSemestre);
        add(checkCarrera);
        add(checkEdad);
        add(btnMostrarTodo);

        btnSubir.addActionListener(this);
        btnBajar.addActionListener(this);
        btnPrimero.addActionListener(this);
        btnUltimo.addActionListener(this);

        add(cajaRow);
        add(btnSubir);
        add(btnBajar);
        add(btnUltimo);
        add(btnPrimero);

        checkNumControl.addActionListener(this);
        checkNombre.addActionListener(this);
        checkApePaterno.addActionListener(this);
        checkApeMaterno.addActionListener(this);
        checkSemestre.addActionListener(this);
        checkCarrera.addActionListener(this);
        checkEdad.addActionListener(this);

        radioISC = new JRadioButton("ISC");
        radioIM = new JRadioButton("IIM");
        radioIIA = new JRadioButton("IIA");
        radioLA = new JRadioButton("LA");
        radioLC = new JRadioButton("LC");

        radioCarreras = new ButtonGroup();

        radioCarreras.add(radioISC);
        radioCarreras.add(radioIM);
        radioCarreras.add(radioIIA);
        radioCarreras.add(radioLA);
        radioCarreras.add(radioLC);

        radioISC.setBounds(getWidth() / 6, 380, 50, 20);
        radioIM.setBounds(getWidth() / 6 + 100, 380, 50, 20);
        radioIIA.setBounds(getWidth() / 6 + 200, 380, 50, 20);
        radioLA.setBounds(getWidth() / 6 + 300, 380, 50, 20);
        radioLC.setBounds(getWidth() / 6 + 400, 380, 50, 20);

        radioISC.addActionListener(this);
        radioIM.addActionListener(this);
        radioIIA.addActionListener(this);
        radioLA.addActionListener(this);
        radioLC.addActionListener(this);

        add(radioISC);
        add(radioIM);
        add(radioIIA);
        add(radioLA);
        add(radioLC);

        add(txtSelecciona);

        tablaAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarDatosAlumnos(e);
                cajaRow.setText(String.valueOf(tablaAlumnos.getSelectedRow()));
                activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);
            }
        });

    }

    public void esChecked(JTextField caja, JCheckBox check) {
        if (check.isSelected()) caja.setEditable(true);
        else caja.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        funcionalidadBotones(e);

        if (e.getSource() == checkNumControl) esChecked(cajaNumControl, checkNumControl);

        else if (e.getSource() == checkNombre) esChecked(cajaNombre, checkNombre);

        else if (e.getSource() == checkApePaterno) esChecked(cajaApePaterno, checkApePaterno);

        else if (e.getSource() == checkApeMaterno) esChecked(cajaApeMaterno, checkApeMaterno);

        else if (e.getSource() == checkEdad) esChecked(cajaEdad, checkEdad);

        else if (e.getSource() == checkCarrera) {
            if (checkCarrera.isSelected()) comboCarrera.setEnabled(true);
            else comboCarrera.setEnabled(false);
        } else if (e.getSource() == checkSemestre) {
            if (checkSemestre.isSelected()) comboSemestre.setEnabled(true);
            else comboSemestre.setEnabled(false);
        } else if (e.getSource() == btnAgregar) {

            if (!cajaNumControl.getText().equals("") || !cajaNombre.getText().equals("") || !cajaApePaterno.getText().equals("") ||
                    !cajaApeMaterno.getText().equals("") || !cajaEdad.getText().equals("") || comboSemestre.getSelectedIndex() != 0 || comboCarrera.getSelectedIndex() != 0) {

                if (!cajaNumControl.getText().equals("")) a.setNumControl(cajaNumControl.getText());
                else a.setNumControl(null);

                if (!cajaNombre.getText().equals("")) a.setNombre(cajaNombre.getText());
                else a.setNombre(null);

                if (!cajaApePaterno.getText().equals("")) a.setPrimerAp(cajaApePaterno.getText());
                else a.setPrimerAp(null);

                if (!cajaApeMaterno.getText().equals("")) a.setSegundoAp(cajaApeMaterno.getText());
                else a.setSegundoAp(null);

                if (!cajaEdad.getText().equals("")) a.setEdad(Byte.parseByte(cajaEdad.getText()));
                else a.setEdad((byte) 0);

                if (comboSemestre.getSelectedIndex() != 0) a.setSemestre(Byte.parseByte((String) comboSemestre.getSelectedItem()));
                else a.setSemestre((byte) 0);

                if(comboCarrera.getSelectedIndex() != 0) a.setCarrera((String) comboCarrera.getSelectedItem());
                else a.setCarrera(null);

                actualizarTabla(alumnoDAO.obtenerConsulta(a));

            } else {
                JOptionPane.showMessageDialog(null, "agrega al menos un dato");
            }
        }

        else if (e.getSource() == btnBajar){
            try{
                cont = tablaAlumnos.getSelectedRow();

                if (tablaAlumnos.getSelectedRow() == -1 || tablaAlumnos.getSelectedRow() == tablaAlumnos.getRowCount()-1){
                    tablaAlumnos.setRowSelectionInterval(0,0);
                    cargarDatosAlumnos();
                    activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                    activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);
                    cajaRow.setText(String.valueOf(0));
                    cont = 0;

                } else{
                    cont++;
                    tablaAlumnos.setRowSelectionInterval(cont,cont);
                    activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                    activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);
                    cargarDatosAlumnos();
                    cajaRow.setText(String.valueOf(tablaAlumnos.getSelectedRow()));
                }

            } catch (Exception error){
                //System.out.println("tabla vacia");
            }


        }

        else if (e.getSource() == btnSubir){
            try{


                cont = tablaAlumnos.getSelectedRow();

                if (tablaAlumnos.getSelectedRow() == -1 || tablaAlumnos.getSelectedRow() == 0){
                    tablaAlumnos.setRowSelectionInterval(tablaAlumnos.getRowCount()-1,tablaAlumnos.getRowCount()-1);
                    cargarDatosAlumnos();
                    activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                    activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);
                    cajaRow.setText(String.valueOf(tablaAlumnos.getRowCount()-1));
                    cont = tablaAlumnos.getRowCount()-1;
                } else{
                    cont--;
                    tablaAlumnos.setRowSelectionInterval(cont,cont);
                    activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                    activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);

                    cajaRow.setText(String.valueOf(tablaAlumnos.getSelectedRow()));
                    cargarDatosAlumnos();
                }

            } catch (Exception error){
                //System.out.println("tabla vacia");
            }


        } else if (e.getSource() == btnPrimero){
            try{
                tablaAlumnos.setRowSelectionInterval(0,0);
                activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);

                cajaRow.setText(String.valueOf(tablaAlumnos.getSelectedRow()));
                cargarDatosAlumnos();
                cont = 0;
            }catch (Exception error){

            }

        }

        else if (e.getSource() == btnUltimo){
            try{
                listaAlumnos = alumnoDAO.buscarAlumnos();

                tablaAlumnos.setRowSelectionInterval(tablaAlumnos.getRowCount()-1,tablaAlumnos.getRowCount()-1);
                activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);

                cajaRow.setText(String.valueOf(tablaAlumnos.getSelectedRow()));
                cargarDatosAlumnos();

            }catch (Exception error){

            }

        } else if (e.getSource() == btnMostrarTodo){
            actualizarTablas(tablaAlumnos);
            radioCarreras.clearSelection();

        }

        try{
            if (e.getSource() == radioISC){
                a2.setCarrera(comboCarrera.getItemAt(1));
                actualizarTabla(alumnoDAO.obtenerConsulta(a2));
                tablaAlumnos.setRowSelectionInterval(0,0);
                cargarDatosAlumnos();
                activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);
            }

            else if (e.getSource() == radioIM){
                a2.setCarrera(comboCarrera.getItemAt(2));
                actualizarTabla(alumnoDAO.obtenerConsulta(a2));
                tablaAlumnos.setRowSelectionInterval(0,0);
                cargarDatosAlumnos();
                activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);
            }

            else if (e.getSource() == radioIIA){
                a2.setCarrera(comboCarrera.getItemAt(3));
                actualizarTabla(alumnoDAO.obtenerConsulta(a2));
                tablaAlumnos.setRowSelectionInterval(0,0);
                cargarDatosAlumnos();
                activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);
            }

            else if (e.getSource() == radioLA){
                a2.setCarrera(comboCarrera.getItemAt(4));
                actualizarTabla(alumnoDAO.obtenerConsulta(a2));
                tablaAlumnos.setRowSelectionInterval(0,0);
                cargarDatosAlumnos();
                activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);
            }
            else if (e.getSource() == radioLC){
                a2.setCarrera(comboCarrera.getItemAt(5));
                actualizarTabla(alumnoDAO.obtenerConsulta(a2));
                tablaAlumnos.setRowSelectionInterval(0,0);
                cargarDatosAlumnos();
                activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
                activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);
            }


        }catch (Exception er){
            //System.out.println("fuera de rango");
        }



        if(e.getSource() == btnBuscar && !cajaNumControl.getText().equals("")){
            activarCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
            activarCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);
        }

        if(e.getSource() == btnLimpiar){
            desCheck(checkNumControl,checkNombre,checkApePaterno,checkApeMaterno,checkEdad,checkSemestre,checkCarrera);
            desCajas(cajaNombre,cajaNumControl,cajaEdad,cajaApeMaterno,cajaApePaterno,comboCarrera,comboSemestre);
        }

    }



    public void desCheck(JComponent... componentes) {
        for (JComponent c : componentes) {

            if (c instanceof JCheckBox)
                ((JCheckBox) c).setSelected(false);

        }
    }

    public void desCajas(JComponent... componentes) {
        for (JComponent c : componentes) {

            if (c instanceof JTextField)
                ((JTextField) c).setEditable(false);

            else if (c instanceof JComboBox)
                ((JComboBox<String>) c).setEnabled(false);

        }
    }


}
