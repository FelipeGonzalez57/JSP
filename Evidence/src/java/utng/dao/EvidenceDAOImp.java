/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.model.Evidence;
import utng.util.UtilDB;

/**
 *
 * @author PandithaGD
 */
public class EvidenceDAOImp implements EvidenceDAO{
       private Connection connection;
    
    public EvidenceDAOImp(){
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarEvidence(Evidence evidence) {
         try {
            String query = "INSERT INTO evidencia (\n"+"code\", \"seq\", \"association\")\n "
                    + " VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, evidence.getCode());
            ps.setString(2, evidence.getSeq());
            ps.setInt(3, evidence.getAssociation());
            
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
    }

    @Override
    public void borrarEvidence(int id) {
        try {
            String query = "DELETE FROM evidencia WHERE "
                    + " id= ?";
            PreparedStatement ps = 
                    connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarEvidence(Evidence evidence) {
        try {
            String query = "UPDATE evidencia SET code = ?"
                    + ", seq = ?"
                    + ", association = ? "
                    + " WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, evidence.getCode());
            ps.setString(2, evidence.getSeq());
            ps.setInt(3, evidence.getAssociation());
            ps.setInt(4, evidence.getId());
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

   

    @Override
    public List<Evidence> desplegarEvidence() {
        List<Evidence> evidences = new ArrayList<Evidence>();
        try{
        Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    "SELECT * FROM evidencia");
            while(rs.next()){
                Evidence evidence = new Evidence(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("seq"),
                        rs.getInt("association"));
                evidences.add(evidence);
            }
            rs.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
      return evidences;
    }

    @Override
    public Evidence elegirEvidence(int id) {
       Evidence evidence = null;
        try{
        String query = "SELECT * FROM evidencia WHERE id= ?";
        PreparedStatement statement = 
                connection.prepareStatement(query);
        statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                 evidence = new Evidence(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("seq"),
                        rs.getInt("association"));
            }
            rs.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
      return evidence;
    }
}
