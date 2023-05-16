package Vista;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class vPartidos {
    private JPanel pMenu;
    private JLabel lNombre;
    private JPanel pCombo;
    private JComboBox cbJornadas;
    private JPanel pPrincipal;
    private JPanel pHeader;
    private JPanel pContenedor;
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
    private JPanel pPartidos;
    private JMenu mIconoPerfil;

    public vPartidos(String admin) {
        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();
        try {
            inicializar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                Main.crearVentanaLogin();
            }
        });
        miEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                Main.crearVentanaEquipos(admin);
            }
        });

        miClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                Main.crearVentanaClasificacion(admin);
            }
        });

        miPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPartidos.dispose();
                Main.crearVentanaPartidos(admin);
            }
        });
        cbJornadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actualizarPosicion(cbJornadas.getSelectedIndex());
                try {
                    pPartidos.removeAll();
                    pPartidos.add(Main.crearPanelesJornadas());
                    Main.actualizarVPartidos();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void inicializar() throws Exception {
        lNombreMenu.setText(Main.buscarNombre());
        lNombre.setText(Main.buscarNombre());
        if (Main.buscarAdmin().equalsIgnoreCase("S")) {
            lTipoUsuario.setText("Administrador");
        } else {
            lTipoUsuario.setText("Usuario");
        }

        miPartidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miClasificacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miBaseDatos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mIconoPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miUsuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Main.buscarJornadasTemporada();
        pPartidos.add(Main.crearPanelesJornadas());
        inicializarCombo();
    }
    public void ocultarCosasAdmin(){
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

    public void inicializarCombo(){
        ArrayList<String> itemsCombo = Main.rellenarComboJornadas();
        itemsCombo.forEach(item -> cbJornadas.addItem(item));
        cbJornadas.setSelectedIndex(-1);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        pPartidos = new JPanel(new GridLayout(1,1));
    }
}
