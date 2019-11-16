import java.util.Iterator;

public class StudentDAO implements Iterable<Student> {

    public Iterator<Student> iterator() {

        Iterator<Student> it = null;

        try {
            it = new StudentIterator();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return it;
    }
}
