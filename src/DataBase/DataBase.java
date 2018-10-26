package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase implements IRelationalDB {
    /**
     * a sample database
     */
    private String location;
    private String fileName;
    private Connection conn;


    public DataBase(String fileName) {
        this.fileName=fileName;
        this.conn = null;
        location = "jdbc:sqlite:" + fileName;
    }

    protected Connection connect() {

        conn = null;
        try {
            // db parameters
            //String url = "jdbc:sqlite:nituzDB.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(location);

            if (conn != null) {

                System.out.println("A new database, " + fileName + ", has been connected to.");
            }

            System.out.println("Connection to " + fileName + " has been established.");

        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    protected void disConnect() {
        try {
            if (conn != null) {
                conn.close();
                this.conn = null;
                System.out.print("Disconmected from " + fileName );
            }
        } catch (java.sql.SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Create a new table in the test database
     *
     */
    @Override
    public boolean executeSQLCommand(String toExecute)
    {
        if (!isValidInput(toExecute)) {
            System.out.println("invalid command");
            return false;
        }
        try {
            conn = connect();
            Statement stmt = conn.createStatement();
            // create a new table
            stmt.execute(toExecute);
            disConnect();
            return true;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     *
     * @param toCheck input to check
     * @return
     */
    private boolean isValidInput(String toCheck){
        return toCheck != null && toCheck != "";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataBase db = new DataBase("test.sqlite");
        db.connect();
        db.disConnect();
    }
}
