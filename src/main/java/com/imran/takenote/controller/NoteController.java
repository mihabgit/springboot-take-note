package com.imran.takenote.controller;

import com.imran.takenote.model.Note;
import com.imran.takenote.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> saveNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.saveNote(note), HttpStatus.CREATED);
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNote() {
        return new ResponseEntity<>(noteService.getAllNote(), HttpStatus.OK);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable int id, @RequestBody Note note) {
        return new ResponseEntity<>(noteService.updateNote(id, note), HttpStatus.OK);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable int id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>("Note deleted.", HttpStatus.NO_CONTENT);
    }


}
