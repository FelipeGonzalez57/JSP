/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.util.List;
import utng.model.Evidence;

/**
 *
 * @author PandithaGD
 */
public interface EvidenceDAO {
    void agregarEvidence(Evidence evidence);
    void borrarEvidence(int id);
    void cambiarEvidence(Evidence evidence);
    List<Evidence> desplegarEvidence();
    Evidence elegirEvidence(int id);
}
