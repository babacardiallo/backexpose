package org.sn.tdsi.service;

import org.sn.tdsi.entiites.Etudiant;
import org.sn.tdsi.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        Etudiant et = etudiantRepository.findById(etudiant.getId()).orElse(new Etudiant());
        et.setId(etudiant.getId());
        et.setNom(etudiant.getNom());
        et.setPrenom(etudiant.getPrenom());
        et.setEmail(etudiant.getEmail());
        return etudiantRepository.save(et);
    }

    @Override
    public void deleteEtudiant(Etudiant etudiant) {
        etudiantRepository.delete(etudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }
}
