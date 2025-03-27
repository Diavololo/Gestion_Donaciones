package Control;

import Modelo.Organizacion;
import Modelo.Usuario;
import Vista.Vista_Admin;
import Vista.Vista_Main;
import Vista.Vista_Organizacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Control_Main implements ActionListener, WindowListener{

    public Vista_Main main;
    
    public Control_Main(Vista_Main main){
        this.main = main;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(main.jbIniciar_sesion)){
            
            boolean existe = false;
            
            Usuario user = new Usuario();
            List<Usuario> resultados = user.selectUsuarios();
            for (Usuario usuario : resultados) {
                if (usuario.getCorreo().equals(main.jtCorreo.getText())){
                    existe = true;
                }
            }
            if(existe){
                
                user = user.selectUsuario(main.jtCorreo.getText());
                String contraseñaIngresada = "";

                contraseñaIngresada = main.jtContraseña.getText();

                String contraseña = user.getContraseña();
                if(contraseña.equals(contraseñaIngresada)){
                    if(user.getTipo_usuario().equals("administrador")){
                        main.setVisible(false);
                        Vista_Admin vista_admin = new Vista_Admin(main);
                        main.dispose();
                    }
                }else{JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");}
            }
            else{JOptionPane.showMessageDialog(null, "Correo no registrado");}
        }
        if(e.getSource().equals(main.jbRegistrarse)){
            
            main.remove(main.jbIniciar_sesion);
            main.remove(main.jbRegistrarse);
            main.remove(main.jlOrganizacion);
            main.remove(main.jbOrganizacion);
            main.remove(main.jbRegistrarse);
            main.remove(main.jbSalir);
            
            main.add(main.jtApellido);
            main.add(main.jtNombre);
            main.add(main.jbRegistrar);
            main.add(main.jbVolverUser);
                
            main.revalidate();
            main.repaint();
        }
        
        if(e.getSource().equals(main.jbRegistrar)){
            boolean existe = false;
            
            Usuario usuario = new Usuario();
            List<Usuario> resultados = usuario.selectUsuarios();
            for (Usuario user : resultados) {
                if (user.getCorreo().equals(main.jtCorreo.getText())){
                    existe = true;
                }
            }
            if(existe){JOptionPane.showMessageDialog(null, "Correo ya registrado");}
            else{
                
                String nombre = main.jtNombre.getText();
                String apellido = main.jtApellido.getText();
                String correo = main.jtCorreo.getText();
                String contraseña = main.jtContraseña.getText();
                
                Usuario user = new Usuario(nombre, apellido, correo, contraseña, "donante");
                boolean guardado = user.guardar();
                if(guardado){JOptionPane.showMessageDialog(null, "se ha registrado con exito");}
                else{JOptionPane.showMessageDialog(null, "NO se ha podido registrar");}
            }
        }
        
        if(e.getSource().equals(main.jbOrganizacion)){
            main.remove(main.jtContraseña);
            main.remove(main.jtCorreo);
            main.remove(main.jlOrganizacion);
            main.remove(main.jbOrganizacion);
            main.remove(main.jbSalir);
            main.remove(main.jbRegistrarse);
            main.remove(main.jbIniciar_sesion);
            
            main.add(main.jbVolverOrg);
            main.add(main.jlLlave_acceso);
            main.add(main.jtLlave_acceso);
            main.add(main.jbIniciarOrg);
            
            main.revalidate();
            main.repaint();
        }
        if(e.getSource().equals(main.jbIniciarOrg)){
            
            boolean existe = false;
            
            Organizacion org = new Organizacion();
            List<Organizacion> resultados = org.selectOrganizaciones();
            for (Organizacion organizacion : resultados) {
                if (organizacion.getID() == Long.parseLong(main.jtLlave_acceso.getText())){
                    existe = true;
                    org = organizacion;
                }
            }
            if(existe){
                main.setVisible(false);
                Vista_Organizacion vista_org = new Vista_Organizacion(main, org);
                main.dispose();
                    
            }
            else{JOptionPane.showMessageDialog(null, "Correo no registrado");}
        }
        
        if(e.getSource().equals(main.jbVolverUser)){
            main.remove(main.jtCorreo);
            main.remove(main.jtContraseña);
            main.remove(main.jtApellido);
            main.remove(main.jtNombre);
            main.remove(main.jbRegistrar);
            main.remove(main.jbVolverUser);
            main.Start();
        }
        if(e.getSource().equals(main.jbVolverOrg)){
            main.remove(main.jlLlave_acceso);
            main.remove(main.jtLlave_acceso);
            main.remove(main.jbIniciarOrg);
            main.remove(main.jbVolverOrg);
            main.Start();
        }
        
        if(e.getSource().equals(main.jbSalir)){
            eventoSalir();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosing(WindowEvent e) {
        eventoSalir();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        eventoSalir();
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void eventoSalir() {
        int res = JOptionPane.showConfirmDialog(main, 
                "Desea realmente salir de la aplicación?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION);
        
        if(res == JOptionPane.YES_OPTION)
            System.exit(0);
    }
    
}
