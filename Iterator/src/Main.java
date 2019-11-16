import java.util.Iterator;

public class Main {

    public static void main(String[] agrs) throws Exception {

        /** DAO - Data Access Object - implements Data Base access. */
        Iterable<Student> students = new StudentDAO();

        /** This for() is possible because StudentDAO implements Iterable<> and consequently Iterator<> interfaces.
         * Otherwise it would get an error telling foreach is not applicable.
         *
         * Note: Iterator pattern is really important because it hides internal class structure complexity from clients,
         * for example in this case clients can iterate Students as it was a List and don't even realise that data is being
         * accessed remotely from a data base.
         * */
        for(Student s: students) {
            System.out.println(s);
        }

        /** Previous for() uses Iterator<> as follows. */
        Iterator<Student> it = new StudentIterator();
        while(it.hasNext()) {
            Student s = it.next();
            System.out.println(s);
        }
    }
}