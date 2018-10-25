package Model;
import javafx.scene.control.Alert;

public interface ModelInit {
    boolean createTable(String[] args);
    boolean update(String[]args);
    boolean add(String[]args);
    boolean delete(String[] args);
    Alert getExitMessage();
}
