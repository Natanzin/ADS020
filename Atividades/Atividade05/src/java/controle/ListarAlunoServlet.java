
package controle;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AlunoBO;
import modelo.NegocioException;
import modelo.entidades.Aluno;

@WebServlet(name = "ListarAlunoServlet", urlPatterns={"/aluno"})
public class ListarAlunoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Aluno> lista = new ArrayList<Aluno>();
        AlunoBO bo = new AlunoBO();
        
        try {
            lista = bo.listar();
        } catch (NegocioException e) {
            throw new ServletException("", e);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro de Aluno<title>");
            out.println("</head>");
            out.println("<body>");
            out.prin'tln("<h1>Servelet ListarAlunoServelet at" + request.getContextPath() + "</h1>");
            out.println("<h1> Listagem de alunos</h1>");
            out.println("<table>");
            out.println("<tr>");
            for(Aluno aluno:lista){
                out.println("<tr>");
                out.println("<td>" + aluno.getMatricula() + "</td>");
                out.println("<td>" + aluno.getMatricula() + "</td>");
                out.println("<td><a href=''>Alterar</a>");
                out.println("<a href=''>Excluir</a></td>");
                out.println("</tr>");
            }
            out.println("<th>Matrícula</th>");
            out.println("<th>Nome</th>");
            out.println("<th>Ações</th>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
