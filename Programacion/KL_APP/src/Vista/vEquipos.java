package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vEquipos {
    private JLabel lNombre;
    private JMenuItem miBaseDatos;
    private JMenuItem miUsuarios;
    private JLabel lNombreMenu;
    private JLabel lTipoUsuario;
    private JMenuItem miPerfil;
    private JMenuItem miPanel;
    private JMenuItem miCerrarSesion;
    private JMenuItem miClasificacion;
    private JMenuItem miPartidos;
    private JMenuItem miEquipo;
    private JPanel pTitulo;
    private JPanel pCombo;
    private JPanel pEquiposGeneral;
    private JPanel pColumnaIzq;
    private JPanel pJijantes;
    private JPanel pPIO;
    private JPanel p1KFC;
    private JButton b1KFC;
    private JPanel pSaiyans;
    private JPanel pKuni;
    private JPanel pPorcinos;
    private JPanel pAniquiladores;
    private JPanel pMostoles;
    private JPanel pColumnaCentral;
    private JPanel pColumnaDer;
    private JPanel pTroncos;
    private JPanel pRayo;
    private JPanel pBarrio;
    private JPanel pBuyer;
    private JPanel pPrincipal;
    private JScrollPane spScroll;

     public vEquipos(String admin) {
        inicializar();
         if (!admin.equalsIgnoreCase("S"))
             ocultarCosasAdmin();
         miCerrarSesion.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Main.vEquipos.dispose();;
                 Main.crearVentanaLogin();
             }
         });

         miClasificacion.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Main.vEquipos.dispose();;
                 Main.crearVentanaClasificacion(admin);
             }
         });

         miPartidos.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Main.vEquipos.dispose();;
                 Main.crearVentanaPartidos(admin);
             }
         });
     }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

    public void inicializar() {
        spScroll.getVerticalScrollBar().setUnitIncrement(20);
    }

}
