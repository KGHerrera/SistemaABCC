package vista;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import vista.alumnos.*;

@SuppressWarnings("serial")
public class VentanaInicio extends JFrame implements ActionListener {

    JInternalFrame internalFrameAltasAlumnos, internalFrameBajasAlumnos, internalFrameCambiosAlumnos, internalFrameConsultasAlumnos;

    JMenuItem itemAltasAlumnos, itemBajasAlumnos, itemCambiosAlumnos, itemConsultasAlumnos;


    JDesktopPane desktopPane;

    public void actualizarTablas(VentanaAlumnos va){
        va.actualizarTablas(va.tablaAlumnos);
    }

    public VentanaInicio() {

        getContentPane().setLayout(new BorderLayout());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sistema Escolares");
        setSize(1366, 768);
        setVisible(true);

        internalFrameAltasAlumnos = new AltasAlumnos();
        internalFrameBajasAlumnos = new BajasAlumnos();
        internalFrameConsultasAlumnos = new ConsultasAlumnos();
        internalFrameCambiosAlumnos = new CambiosAlumnos();

        JMenuBar menuBar = new JMenuBar();

        JMenu menuEmpleados = new JMenu("Alumnos");

        Dimension d1 = new Dimension(90, 25);
        Dimension d2 = new Dimension(87, 25);

        menuEmpleados.setPreferredSize(d1);


        itemAltasAlumnos = new JMenuItem("Agregar");
        itemBajasAlumnos = new JMenuItem("Eliminar");
        itemCambiosAlumnos = new JMenuItem("Modificar");
        itemConsultasAlumnos = new JMenuItem("Buscar");


        itemAltasAlumnos.addActionListener(this);
        itemBajasAlumnos.addActionListener(this);
        itemCambiosAlumnos.addActionListener(this);
        itemConsultasAlumnos.addActionListener(this);

        menuEmpleados.add(itemAltasAlumnos);
        menuEmpleados.add(itemBajasAlumnos);
        menuEmpleados.add(itemCambiosAlumnos);
        menuEmpleados.add(itemConsultasAlumnos);

        menuBar.add(menuEmpleados);


        setJMenuBar(menuBar);

        desktopPane = new JDesktopPane();

        desktopPane.add(internalFrameAltasAlumnos);



        desktopPane.add(internalFrameBajasAlumnos);

        desktopPane.add(internalFrameCambiosAlumnos);


        desktopPane.add(internalFrameConsultasAlumnos);

        esconderVentanas();

        add(desktopPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);

    }

    public void esconderVentanas() {
        internalFrameAltasAlumnos.setVisible(false);
        internalFrameBajasAlumnos.setVisible(false);
        internalFrameCambiosAlumnos.setVisible(false);
        internalFrameConsultasAlumnos.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == itemAltasAlumnos) {
            esconderVentanas();
            actualizarTablas((VentanaAlumnos) internalFrameAltasAlumnos);
            internalFrameAltasAlumnos.setVisible(true);
        } else if (e.getSource() == itemBajasAlumnos) {
            esconderVentanas();
            actualizarTablas((VentanaAlumnos) internalFrameBajasAlumnos);
            internalFrameBajasAlumnos.setVisible(true);
        } else if (e.getSource() == itemCambiosAlumnos) {
            esconderVentanas();
            actualizarTablas((VentanaAlumnos) internalFrameCambiosAlumnos);
            internalFrameCambiosAlumnos.setVisible(true);
        } else if (e.getSource() == itemConsultasAlumnos) {
            esconderVentanas();
            actualizarTablas((VentanaAlumnos) internalFrameConsultasAlumnos);
            internalFrameConsultasAlumnos.setVisible(true);
        }

    }


}