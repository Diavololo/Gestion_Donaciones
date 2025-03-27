package Control;

import Modelo.Organizacion;
import Vista.Vista_Admin;
import Vista.Vista_Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Control_Admin implements ActionListener{

    Vista_Admin vista_admin;
    
    public Control_Admin(Vista_Admin vista_admin){
        this.vista_admin = vista_admin;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(vista_admin.jbMenuOrganizacion)){
            vista_admin.remove(vista_admin.jlTitulo);
            vista_admin.remove(vista_admin.jbVolver);
            vista_admin.remove(vista_admin.jbMenuCampañas);
            vista_admin.remove(vista_admin.jbMenuOrganizacion);
            vista_admin.remove(vista_admin.jbMenuUsuarios);
            
            vista_admin.Menu_Organizacion();
        }
        
        if(e.getSource().equals(vista_admin.jbAñadirOrg)){
            vista_admin.remove(vista_admin.jlMensajes);
            vista_admin.remove(vista_admin.jbMensajes);
            vista_admin.remove(vista_admin.jbAñadirOrg);
            vista_admin.remove(vista_admin.jbEliminarOrg);
            vista_admin.remove(vista_admin.jbVerOrg);
            vista_admin.remove(vista_admin.jlAñadirOrg);
            vista_admin.remove(vista_admin.jlEliminarOrg);
            vista_admin.remove(vista_admin.jlVerOrg);
            
            vista_admin.add(vista_admin.jlLlave);
            vista_admin.add(vista_admin.jtLlave);
            vista_admin.add(vista_admin.jlNombre);
            vista_admin.add(vista_admin.jtNombre);
            vista_admin.add(vista_admin.jlContacto);
            vista_admin.add(vista_admin.jtContacto);
            vista_admin.add(vista_admin.jbAñadir);
            
            vista_admin.revalidate();
            vista_admin.repaint();
        }
        
        if(e.getSource().equals(vista_admin.jbAñadir)){
            boolean existe = false;
            
            Organizacion organizacion = new Organizacion();
            
            List<Organizacion> resultados = organizacion.selectOrganizaciones();
            
            long llave = Long.parseLong(vista_admin.jtLlave.getText());
            
            for (Organizacion org : resultados) {
                if (org.getID() == llave){
                    existe = true;
                }
            }
            if(existe){JOptionPane.showMessageDialog(null, "Error Llave ya registrada");}
            else{
                
                long id = Long.parseLong(vista_admin.jtLlave.getText());
                String nombre = vista_admin.jtNombre.getText();
                String contacto = vista_admin.jtContacto.getText();
                
                Organizacion org = new Organizacion(id, nombre, contacto);
                boolean guardado = org.guardar();
                if(guardado){
                    JOptionPane.showMessageDialog(null, "se ha registrado con exito");
                    evento_volver_admin();
                }
                else{JOptionPane.showMessageDialog(null, "NO se ha podido registrar");}
            }
        }
        
        if(e.getSource().equals(vista_admin.jbEliminarOrg)){
            vista_admin.remove(vista_admin.jlMensajes);
            vista_admin.remove(vista_admin.jbMensajes);
            vista_admin.remove(vista_admin.jbAñadirOrg);
            vista_admin.remove(vista_admin.jbEliminarOrg);
            vista_admin.remove(vista_admin.jbVerOrg);
            vista_admin.remove(vista_admin.jlAñadirOrg);
            vista_admin.remove(vista_admin.jlEliminarOrg);
            vista_admin.remove(vista_admin.jlVerOrg);
            
            vista_admin.add(vista_admin.jlLlave);
            vista_admin.add(vista_admin.jtLlave);
            vista_admin.add(vista_admin.jbEliminar);
            
            vista_admin.revalidate();
            vista_admin.repaint();
        }
        
        if(e.getSource().equals(vista_admin.jbEliminar)){
            boolean existe = false;
            
            Organizacion organizacion = new Organizacion();
            
            List<Organizacion> resultados = organizacion.selectOrganizaciones();
            
            long llave = Long.parseLong(vista_admin.jtLlave.getText());
            
            for (Organizacion org : resultados) {
                if (org.getID() == llave){
                    existe = true;
                }
            }
            if(existe){
                long id = Long.parseLong(vista_admin.jtLlave.getText());
                
                Organizacion org = new Organizacion(id, "", "");
                boolean eliminado = org.eliminar(id);
                if(eliminado){
                    JOptionPane.showMessageDialog(null, "se ha eliminado con exito");
                    evento_volver_admin();
                }
                else{JOptionPane.showMessageDialog(null, "NO se ha podido eliminar");}}
            else{JOptionPane.showMessageDialog(null, "Organizacion no encontrada");}
        }
        
        if(e.getSource().equals(vista_admin.jbVolverOrg)){
            evento_volver_admin();
        }
        
        if(e.getSource().equals(vista_admin.jbVolver)){
            evento_volver();
        }
        
        if(e.getSource().equals(vista_admin.jbVerOrg)){
            vista_admin.remove(vista_admin.jlMensajes);
            vista_admin.remove(vista_admin.jbMensajes);
            vista_admin.remove(vista_admin.jbAñadirOrg);
            vista_admin.remove(vista_admin.jbEliminarOrg);
            vista_admin.remove(vista_admin.jbVerOrg);
            vista_admin.remove(vista_admin.jlAñadirOrg);
            vista_admin.remove(vista_admin.jlEliminarOrg);
            vista_admin.remove(vista_admin.jlVerOrg);
            
            String[] fila = new String[3];
            Organizacion organizacion = new Organizacion();
            List<Organizacion> resultados = organizacion.selectOrganizaciones();
            for (Organizacion resultado : resultados) {
                fila[0] = Long.toString(resultado.getID());
                fila[1] = resultado.getNombre();
                fila[2] = resultado.getContacto();
                vista_admin.dt.addRow(fila);
            }
            
            vista_admin.add(vista_admin.js);
            vista_admin.add(vista_admin.jbBuscar);
            vista_admin.add(vista_admin.jlBuscar);
            vista_admin.add(vista_admin.jtBuscar);
            
            vista_admin.revalidate();
            vista_admin.repaint();
        }
        
        if(e.getSource().equals(vista_admin.jbBuscar)){
            
            vista_admin.dt.setRowCount(0);
            
            Organizacion organizacion = new Organizacion();
            organizacion = organizacion.selectOrganizacion(Long.parseLong(vista_admin.jtBuscar.getText()));
            
            String[] fila = new String[3];
            fila[0] = Long.toString(organizacion.getID());
            fila[1] = organizacion.getNombre();
            fila[2] = organizacion.getContacto();
            
            vista_admin.dt.addRow(fila);
        }
        
        if(e.getSource().equals(vista_admin.jbMenuUsuarios)){
            vista_admin.remove(vista_admin.jlTitulo);
            vista_admin.remove(vista_admin.jbVolver);
            vista_admin.remove(vista_admin.jbMenuCampañas);
            vista_admin.remove(vista_admin.jbMenuOrganizacion);
            vista_admin.remove(vista_admin.jbMenuUsuarios);
            
            vista_admin.Menu_Usuarios();
        }
        
    }

    
    public void evento_volver_admin(){
            vista_admin.removeAll();
            vista_admin.setVisible(false);
            vista_admin.dispose();
            vista_admin = new Vista_Admin(vista_admin.main);
        }
    
    public void evento_volver(){
            vista_admin.setVisible(false);
            vista_admin.dispose();
            Vista_Main vista_main = new Vista_Main();
        }
}
