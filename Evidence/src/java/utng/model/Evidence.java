/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

/**
 *
 * @author PandithaGD
 */
public class Evidence {
    private int id;
    private String code;
    private String seq;
    private int association;
    
    public Evidence(int id, String code, String sq_acc,int association){
    this.id=id;
    this.code=code;
    this.seq=seq;
    this.association=association;
    }
    
    public Evidence(){
    this(0,"","",0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public int getAssociation() {
        return association;
    }

    public void setAssociation(int association) {
        this.association = association;
    }

    @Override
    public String toString() {
        return "Evidence{" + "id=" + id + ", code=" + code + ", seq=" + seq + ", association=" + association +'}';
    }
    
    
}
