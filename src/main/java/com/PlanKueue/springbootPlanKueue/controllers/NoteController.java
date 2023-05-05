package com.PlanKueue.springbootPlanKueue.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PlanKueue.springbootPlanKueue.models.Note;

@RestController
@RequestMapping("/note")
public class NoteController {
    private List<Note> notes = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping("")
    public List<Note> getNote() {
        return notes;
    }

    @PostMapping
    public Long createNote(String note) {
        Note newNote = new Note(note);
        newNote.setId(nextId++);
        notes.add(newNote);
        return newNote.getId();
    }

    @GetMapping("/note/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return notes.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        notes.removeIf(n -> n.getId().equals(id));
    }
}
