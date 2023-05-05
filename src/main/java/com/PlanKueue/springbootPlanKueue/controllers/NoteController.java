package com.PlanKueue.springbootPlanKueue.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PlanKueue.springbootPlanKueue.models.Note;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private List<Note> notes = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<Note> getAllNotes() {
        return notes;
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        note.setId(nextId++);
        notes.add(note);
        return note;
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) {
        Note existingNote = notes.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));
        existingNote.setNoteDesc(note.getNoteDesc());
        return existingNote;
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        notes.removeIf(n -> n.getId().equals(id));
    }
}
