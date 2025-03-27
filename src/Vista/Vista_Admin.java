package Vista;

import Control.Control_Admin;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Vista_Admin extends JFrame{
    
    public Control_Admin ctrl_admin;
    public JButton jbVolver, jbMenuOrganizacion, jbMenuUsuarios, jbMenuCampañas, jbMensajes;
    public JButton jbAñadirOrg, jbEliminarOrg, jbVerOrg, jbVolverOrg, jbAñadir, jbEliminar, jbBuscar;
    public JTextField jtLlave,jtNombre, jtContacto, jtBuscar;
    public JLabel jlTitulo, jlAñadirOrg, jlEliminarOrg, jlVerOrg, jlLlave, jlNombre, jlContacto, jlBuscar, jlMensajes;
    public DefaultTableModel dt = new DefaultTableModel(new Object[]{"Llave", "Nombre", "Contacto"}, 0);
    public JTable table;
    public JScrollPane js;
    public Vista_Main main;
    
    public Vista_Admin(Vista_Main main){
        super("Gestor de donaciones");
        ctrl_admin = new Control_Admin(this);
        this.main = main;
        setSize(800, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        Menu_Principal();
        setVisible(true);
    }
    
    public void Menu_Principal(){
        jlTitulo = new JLabel("Bienvenido Señor Administrador");
        jlTitulo.setBounds(0, 5, 800, 40);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.LIGHT_GRAY);
        jlTitulo.setForeground(Color.DARK_GRAY);
        jlTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jlTitulo);
        
        jbMenuOrganizacion = new JButton("Organizacion");
        jbMenuOrganizacion.setBounds(15,70, 130, 30);
        jbMenuOrganizacion.addActionListener(ctrl_admin);
        add(jbMenuOrganizacion);
        
        jbMenuUsuarios = new JButton("Usuarios");
        jbMenuUsuarios.setBounds(15,110, 130, 30);
        add(jbMenuUsuarios);
        
        jbMenuCampañas = new JButton("Campañas");
        jbMenuCampañas.setBounds(15,110, 130, 30);
        add(jbMenuCampañas);
        
        jbVolver = new JButton("Volver");
        jbVolver.setBounds(650, 440, 120, 30);
        jbVolver.addActionListener(ctrl_admin);
        add(jbVolver);
        
        revalidate();
        repaint();
    }
    
    public void Menu_Organizacion(){
        jlTitulo = new JLabel("Opciones para administrar organizaciones");
        jlTitulo.setBounds(0, 5, 800, 40);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.LIGHT_GRAY);
        jlTitulo.setForeground(Color.DARK_GRAY);
        jlTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jlTitulo);
        
        jlAñadirOrg = new JLabel("Añadir nueva organizacion:");
        jlAñadirOrg.setBounds(15, 70, 190, 30);
        add(jlAñadirOrg);
        jbAñadirOrg = new JButton("Añadir");
        jbAñadirOrg.setBounds(180, 70, 100, 30);
        jbAñadirOrg.addActionListener(ctrl_admin);
        add(jbAñadirOrg);
        
        jlEliminarOrg = new JLabel("Eliminar organizacion:");
        jlEliminarOrg.setBounds(44, 110, 190, 30);
        add(jlEliminarOrg);
        jbEliminarOrg = new JButton("Eliminar");
        jbEliminarOrg.setBounds(180, 110, 100, 30);
        jbEliminarOrg.addActionListener(ctrl_admin);
        add(jbEliminarOrg);
        
        jlVerOrg = new JLabel("Ver las organizaciones:");
        jlVerOrg.setBounds(34, 150, 190, 30);
        add(jlVerOrg);
        jbVerOrg = new JButton("Ver");
        jbVerOrg.setBounds(180, 150, 100, 30);
        jbVerOrg.addActionListener(ctrl_admin);
        add(jbVerOrg);
        
        jbVolverOrg = new JButton("Volver");
        jbVolverOrg.setBounds(650, 440, 120, 30);
        jbVolverOrg.addActionListener(ctrl_admin);
        add(jbVolverOrg);
        
        jlMensajes = new JLabel("Mensajeria:");
        jlMensajes.setBounds(105, 190, 190, 30);
        add(jlMensajes);
        jbMensajes = new JButton("Mensajes");
        jbMensajes.setBounds(180, 190, 100, 30);
        jbMensajes.addActionListener(ctrl_admin);
        add(jbMensajes);
        
        jlLlave = new JLabel("Asignar Llave de acceso(numerico):");
        jlLlave.setBounds(400, 70, 250, 30);
        jtLlave = new JTextField("##########");
        jtLlave.setBounds(610, 70, 80, 30);
        
        jlNombre = new JLabel("Nombre de la Organizacion:");
        jlNombre.setBounds(450, 110, 250, 30);
        jtNombre = new JTextField();
        jtNombre.setBounds(610, 110, 110, 30);
        
        jlContacto = new JLabel("Contacto(Correo Electronico):");
        jlContacto.setBounds(443, 150, 250, 30);
        jtContacto = new JTextField();
        jtContacto.setBounds(610, 150, 110, 30);
        
        jbAñadir = new JButton("Añadir");
        jbAñadir.setBounds(15, 70, 100, 30);
        jbAñadir.addActionListener(ctrl_admin);
        
        jbEliminar = new JButton("Eliminar");
        jbEliminar.setBounds(15, 70, 100, 30);
        jbEliminar.addActionListener(ctrl_admin);
        
        jlBuscar = new JLabel("Buscar por:");
        jlBuscar.setBounds(560, 70, 250, 30);
        jtBuscar = new JTextField("LLAVE");
        jtBuscar.setBounds(650, 70, 80, 30);
        
        jbBuscar = new JButton("Buscar");
        jbBuscar.setBounds(650, 110, 80, 30);
        jbBuscar.addActionListener(ctrl_admin);
        
        table = new JTable(dt);
        js = new JScrollPane(table);
        js.setBounds(15, 70, 500, 400);
        
        revalidate();
        repaint();
    }
    
    public void Menu_Usuarios(){
        jlTitulo = new JLabel("Opciones para administrar usuarios");
        jlTitulo.setBounds(0, 5, 800, 40);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.LIGHT_GRAY);
        jlTitulo.setForeground(Color.DARK_GRAY);
        jlTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jlTitulo);
    }

}
