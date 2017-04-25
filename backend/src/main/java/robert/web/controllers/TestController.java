package robert.web.controllers;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import robert.db.entities.Note;
import robert.db.repo.NoteRepository;

@RestController
@RequestMapping("/test")
@Profile("dev")
public class TestController {

    private final Logger log = LoggerFactory.getLogger(TestController.class);

    private final NoteRepository noteRepository;

    public TestController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
        initNotes();
        log.info("Test controller initialized");
    }

    @GetMapping("/hello")
    public String hello() {
        log.info("hello method called");
        return "hello world";
    }

    private void initNotes() {
        List<Note> collected = Stream.of(new Note(), new Note(), new Note(), new Note(), new Note())
                .collect(Collectors.toList());

        Random random = new Random();
        collected.forEach(note -> note.setText(String.valueOf(random.nextInt(99999))));
        collected.forEach(note -> System.out.println(note.getText()));

        noteRepository.save(collected);
    }
}
