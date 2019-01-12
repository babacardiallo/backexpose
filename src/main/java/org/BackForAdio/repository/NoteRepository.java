package org.BackForAdio.repository;


import org.BackForAdio.entiites.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long>{

}
