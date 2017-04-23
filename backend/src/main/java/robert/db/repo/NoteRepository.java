package robert.db.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import robert.db.entities.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
