package robert.db.entities;

import javax.persistence.Entity;

@Entity
public class Note extends BasicEntity {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
