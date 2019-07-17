package org.sn.tdsi.service;

import org.sn.tdsi.entiites.Etudiant;

import java.util.List;

public interface EtudiantService {

    public Etudiant saveEtudiant(Etudiant etudiant);
    public Etudiant updateEtudiant(Etudiant etudiant);
    public void deleteEtudiant(Etudiant etudiant);
    public List<Etudiant> getAllEtudiant();
}
