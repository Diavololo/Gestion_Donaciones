package Vista;
import Control.Control_Main;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Vista_Main  extends JFrame{
    
    public Control_Main ctrl_main;
    public JButton jbRegistrarse, jbIniciar_sesion, jbRegistrar, jbSalir, jbVolverUser, jbVolverOrg, jbOrganizacion, jbIniciarOrg;
    public JTextField jtCorreo, jtContraseña, jtNombre, jtApellido, jtLlave_acceso;
    public JLabel jlTitulo, jlOrganizacion, jlLlave_acceso;
    
    public Vista_Main(){
        super("Gestor de donaciones");
        setSize(800, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        ctrl_main = new Control_Main(this);
        
        Start();
        setVisible(true);
    }

    public void Start() {
        
        
        jlTitulo = new JLabel("Bienvenido:");
        jlTitulo.setBounds(0, 5, 800, 40);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.LIGHT_GRAY);
        jlTitulo.setForeground(Color.DARK_GRAY);
        jlTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jlTitulo);
        
        jtCorreo = new JTextField("Ingrese el correo");
        jtCorreo.setBounds(15, 70, 190, 30);
        add(jtCorreo);
        
        jtContraseña = new JTextField("Ingrese la contraseña");
        jtContraseña.setBounds(15, 110, 130, 30);
        add(jtContraseña);
        
        jtNombre = new JTextField("Ingrese el nombre");
        jtNombre.setBounds(15, 150, 130, 30);
        
        jtApellido = new JTextField("Ingrese el apellido");
        jtApellido.setBounds(15, 190, 130, 30);
        
        jbRegistrar = new JButton("Registrar");
        jbRegistrar.setBounds(80, 390, 120, 30);
        jbRegistrar.addActionListener(ctrl_main);
        
        jbRegistrarse = new JButton("Registrarse");
        jbRegistrarse.setBounds(170, 390, 120, 30);
        jbRegistrarse.addActionListener(ctrl_main);
        add(jbRegistrarse);
        
        jbIniciar_sesion = new JButton("Iniciar Sesion");
        jbIniciar_sesion.setBounds(30, 390, 120, 30);
        jbIniciar_sesion.addActionListener(ctrl_main);
        add(jbIniciar_sesion);
        
        jlOrganizacion = new JLabel("Ingresar como:");
        jlOrganizacion.setBounds(530, 70, 100, 30);
        add(jlOrganizacion);
        jbOrganizacion = new JButton("Organizacion");
        jbOrganizacion.setBounds(620, 70, 120, 30);
        jbOrganizacion.addActionListener(ctrl_main);
        add(jbOrganizacion);
        
        jlLlave_acceso = new JLabel("Ingrese la llave de acceso:");
        jlLlave_acceso.setBounds(15, 70, 200, 30);
        
        jtLlave_acceso = new JTextField("########");
        jtLlave_acceso.setBounds(175, 70, 70, 30);
        
        jbIniciarOrg = new JButton("Ingresar");
        jbIniciarOrg.setBounds(80, 390, 120, 30);
        jbIniciarOrg.addActionListener(ctrl_main);
        
        
        jbSalir = new JButton("Salir");
        jbSalir.setBounds(650, 440, 120, 30);
        jbSalir.addActionListener(ctrl_main);
        add(jbSalir);
        
        jbVolverOrg = new JButton("Volver");
        jbVolverOrg.setBounds(650, 440, 120, 30);
        jbVolverOrg.addActionListener(ctrl_main);
        
        jbVolverUser = new JButton("Volver");
        jbVolverUser.setBounds(650, 440, 120, 30);
        jbVolverUser.addActionListener(ctrl_main);
        
        
        revalidate();
        repaint();
    }
}
