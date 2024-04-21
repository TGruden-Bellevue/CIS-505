import java.util.ArrayList;
import java.util.List;

public class MemComposerDao implements ComposerDao {
    private List<Composer> composers;

    public MemComposerDao() {
        composers = new ArrayList<>();
        // Default list of five composer objects
        composers.add(new Composer(1007, "Ludwig Van Beethoven", "Classical"));
        composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(1010, "Johannes Brahms", "Classical"));
        composers.add(new Composer(1011, "Joesph Hayden", "Classical"));
    }

    @Override
    public List<Composer> findAll() {
        return composers;
    }

    @Override
    public Composer findBy(Integer id) {
        for (Composer composer : composers) {
            if (composer.getId() == id) {
                return composer;
            }
        }
        return null; // If not found
    }

    @Override
    public void insert(Composer entity) {
        composers.add(entity);
    }
}
