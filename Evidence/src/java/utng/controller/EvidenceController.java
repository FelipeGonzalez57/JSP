/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utng.dao.EvidenceDAO;
import utng.dao.EvidenceDAOImp;
import utng.model.Evidence;

/**
 *
 * @author PandithaGD
 */
@WebServlet(name = "EvidenceController", urlPatterns = {"/EvidenceController"})
public class EvidenceController extends HttpServlet {
    
      private static final String LISTA_EVIDENCE = 
            "/listarEvidences.jsp";
    private static final String AGREGAR_O_CAMBIAR = 
            "/evidences.jsp";
    private EvidenceDAO dao;
    
    public EvidenceController(){
        dao = new EvidenceDAOImp();
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward ="";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("borrar")){
           forward = LISTA_EVIDENCE;
           int id = Integer.parseInt(
                   request.getParameter("id"));
           dao.borrarEvidence(id);
           request.setAttribute("evicences", dao.desplegarEvidence());
        }else if(action.equalsIgnoreCase("cambiar")){
            forward = AGREGAR_O_CAMBIAR;
            int id= Integer.parseInt(
                   request.getParameter("id"));
            Evidence evidence = dao.elegirEvidence(id);
            request.setAttribute("evidence", evidence);
            
        }else if(action.equalsIgnoreCase("agregar")){
            forward = AGREGAR_O_CAMBIAR;
        }else{
            forward = LISTA_EVIDENCE;
            request.setAttribute("evicences", dao.desplegarEvidence());
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Evidence evidence = new Evidence();
        String id = request.getParameter("id");
        evidence.setCode(request.getParameter("code"));
        evidence.setSeq(request.getParameter("seq"));
        evidence.setAssociation(Integer.parseInt(request.getParameter("association")));
        if(id==null || id.isEmpty()){
            dao.agregarEvidence(evidence);
        }else{
            evidence.setId(Integer.parseInt(id));
            dao.cambiarEvidence(evidence);
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_EVIDENCE);
         request.setAttribute("evicences", dao.desplegarEvidence());
         view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
