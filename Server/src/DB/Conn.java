package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

/**
 * Takes care of the database access read/write
 *
 * @version 1.0
 */
public class Conn {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=dbo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Kaja1806";
    private static Conn conn;
    private final String url;
    private final String user;
    private final String pw;
    private Connection connection;

    /**
     * Constructor that uses driver, url, user and password
     *
     * @param driver the driver for postgressql
     * @param url    the url for accessing the host
     * @param user   the username to access the database
     * @param pw     the password to access the database
     * @throws ClassNotFoundException
     */
    private Conn(String driver, String url, String user, String pw) throws ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.pw = pw;
        connection = null;
        Class.forName(driver);
    }


    /**
     * Constructor that uses database name, user and password
     *
     * @param databaseName database name
     * @param user         the username to access the database
     * @param pw           the password to access the database
     * @throws ClassNotFoundException
     */
    private Conn(String databaseName, String user, String pw) throws ClassNotFoundException {
        this(DRIVER, URL + databaseName, user, pw);
    }

    /**
     * Constructor that uses database name
     *
     * @param databaseName database name
     * @throws ClassNotFoundException
     */
    private Conn(String databaseName) throws ClassNotFoundException {
        this(DRIVER, URL + databaseName, USER, PASSWORD);
    }

    /**
     * Constructor uses local variables
     *
     * @throws ClassNotFoundException
     */
    private Conn() throws ClassNotFoundException {
        this(DRIVER, URL, USER, PASSWORD);
    }

    /*Singleton  Lazy instantiation*/
    public static Conn getInstance() {

        if (conn == null) {
            try {
                conn = new Conn();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * @param sql
     * @throws SQLException
     */
    public void update(String sql) throws SQLException {
        openDatabase();
        Statement stm = connection.createStatement();
        stm.executeUpdate(sql);
        closeDatabase();

    }

    public int delete(String sql) throws SQLException {
        openDatabase();
        Statement stm = connection.createStatement();
        int delete = stm.executeUpdate(sql);
        closeDatabase();
        return delete;

    }

    /**
     * @throws SQLException
     */
    private void openDatabase() throws SQLException {
        connection = getConnection(url, user, pw);
    }

    /**
     * @throws SQLException
     */
    private void closeDatabase() throws SQLException {
        connection.close();
    }

    /**
     * @param sql
     * @return ResultSet
     * @throws SQLException
     */
    public ResultSet query(String sql) throws SQLException {
        openDatabase();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        closeDatabase();
        return rs;

    }

}
