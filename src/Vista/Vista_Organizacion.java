package Vista;
import Modelo.Organizacion;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Vista_Organizacion extends JFrame{
    
    public JLabel jlTitulo, jlSubTitulo, jlCampañas;
    public JButton jbCampañas;
    public Vista_Main vista_main;
    public Organizacion organizacion;
    
    public Vista_Organizacion(Vista_Main vista_main, Organizacion organizacion){
        super("Gestor de donaciones");
        this.vista_main = vista_main;
        this.organizacion = organizacion;
        setSize(800, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        Menu();
        setVisible(true);
    }

    public void Menu() {
        
        jlTitulo = new JLabel(organizacion.getNombre());
        jlTitulo.setBounds(0, 5, 800, 50);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.LIGHT_GRAY);
        jlTitulo.setForeground(Color.DARK_GRAY);
        jlTitulo.setFont(new Font("Tahoma", Font.BOLD, 35));
        add(jlTitulo);
        
        jlSubTitulo = new JLabel("Administrar organizacion");
        jlSubTitulo.setBounds(0, 65, 800, 30);
        jlSubTitulo.setOpaque(true);
        jlSubTitulo.setBackground(Color.LIGHT_GRAY);
        jlSubTitulo.setForeground(Color.DARK_GRAY);
        jlSubTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jlSubTitulo);
        
        jlCampañas = new JLabel("Campañas relacionadas:");
        jlCampañas.setBounds(15, 90, 200, 30);
        add(jlCampañas);
        jbCampañas = new JButton("Campañas");
        jbCampañas.setBounds(190, 90, 100, 30);
        add(jbCampañas);
        
        
        revalidate();
        repaint();
    }
}
