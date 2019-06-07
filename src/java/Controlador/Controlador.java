package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Akin Ramirez
 */
public class Controlador extends HttpServlet {
    
    PersonaDAO dao = new PersonaDAO();
    Persona p = new Persona();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "Listar":
                List<Persona>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                dao.listar();
                break;
            case "Nuevo":
                request.getRequestDispatcher("add.jsp").forward(request, response);
            case "Guardar":
                int id = Integer.parseInt(request.getParameter("txtid"));
                String nombre = request.getParameter("txtnombre");
                String correo = request.getParameter("txtcorreo");
                String telefono = request.getParameter("txttelefono");
                
                p.setId(id);
                p.setNombre(nombre);
                p.setCorreo(correo);
                p.setTelefono(telefono);
                dao.agregar(p);
                
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);                
                break;
            case "Editar":
                int ide = Integer.parseInt(request.getParameter("id"));
                Persona pe = dao.listarId(ide);
                request.setAttribute("persona", pe);                
                request.getRequestDispatcher("edit.jsp").forward(request, response);
                break;
            case "Actualizar":
                int id1 = Integer.parseInt(request.getParameter("txtid"));
                String nombre1 = request.getParameter("txtnombre");
                String correo1 = request.getParameter("txtcorreo");
                String telefono1 = request.getParameter("txttelefono");
                
                p.setId(id1);
                p.setNombre(nombre1);
                p.setCorreo(correo1);
                p.setTelefono(telefono1);
                dao.actualizar(p);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;           
            case "Eliminar":
                int ide2 = Integer.parseInt(request.getParameter("id"));
                dao.delete(ide2);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
           default:
                throw new AssertionError();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
