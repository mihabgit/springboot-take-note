package com.imran.takenote.service;

import com.imran.takenote.model.Note;
import com.imran.takenote.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNote() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(int id) {
        return noteRepository.findById(id);
    }

    public Note updateNote(int id, Note note) {
        Note existingNote = noteRepository.findById(id).orElseThrow();

        existingNote.setId(id);
        existingNote.setTitle(note.getTitle());
        existingNote.setMessage(note.getMessage());
        return noteRepository.save(existingNote);

    }

    public void deleteNote(int id) {
        noteRepository.deleteById(id);
    }

}
