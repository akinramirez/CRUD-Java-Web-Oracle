package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class PersonaDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    
    public List listar(){
        List<Persona>lista = new ArrayList<>();
        String sql="select * from personas";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTelefono(rs.getString(4));
                lista.add(p); 
            }
            
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Persona p){
        int r = 0;
        String sql = "insert into personas(id, nombre, correo, telefono) values (?,?,?,?)";
        
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getTelefono());
            r=ps.executeUpdate();
            
            if(r==1){
                r = 1;
            }else{
                r=0;
            }
                        
        } catch (Exception e) {
        }
        return r;
    }
    
    public Persona listarId (int id ){
        String sql = "select * from personas where id="+id;
        Persona p = new Persona();
        
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTelefono(rs.getString(4));               
            }          
           
        } catch (Exception e) {
        }        
        
        return p;
    }
    
    public int actualizar (Persona p){
        int r = 0;
        String sql = "update personas set nombre = ?, correo = ?, telefono = ? where id = ? ";
        
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);            
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getCorreo() );
            ps.setString(3,p.getTelefono()); 
            ps.setInt(4, p.getId());
            r = ps.executeUpdate();       
            
            if(r==1){
                r = 1;
            }else{
                r=0;
            }           
            
        } catch (Exception e) {
        }
        
        return r;
    }
    
    public void delete (int id){
        String sql = "delete from personas where id="+id;
        
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();            
        } catch (Exception e) {
        }
    }
    
}
