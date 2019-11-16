import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentIterator implements Iterator<Student> {

    private static final String IP = "localhost";
    private static final String DATABASE = "University";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    private Connection conn;
    private List<Student> cache;

    public StudentIterator() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://" + IP + "/" + DATABASE + "?serverTimezone=UTC&user=" + USERNAME + "&password=" + PASSWORD);

        /** Holds all students in a cache generated at the specific time this Iterator<> was created. */
        this.initCache();
    }

    public boolean hasNext() {
        return this.cache.isEmpty() == false;
    }

    public Student next() {
        return this.cache.remove(0);
    }

    private void initCache() throws SQLException {

        this.cache = new ArrayList();

        Statement stm = this.conn.createStatement();
        String sql = "SELECT * FROM STUDENT";
        ResultSet rs = stm.executeQuery(sql);

        while(rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            Student student = new Student(id, name, age);
            this.cache.add(student);
        }

    }
}
