package robert.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import robert.db.entities.Note;
import robert.db.repo.NoteRepository;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/all")
    public Iterable<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping("/add-new")
    @ResponseStatus(HttpStatus.OK)
    public void addNewNote(@RequestBody Note note) {
        if ( note.getText()
                .length() < 3 )
            throw new RuntimeException("The Note is too short");

        noteRepository.save(note);
    }
}
