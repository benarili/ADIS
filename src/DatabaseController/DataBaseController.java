package DatabaseController;

import Entries.DataBaseUsable;

public interface DataBaseController {

    public boolean insert(DataBaseUsable entry) throws Exception;
    public String read(String username) throws Exception;
    public void delete(String sql) throws Exception;
    public String readPW(String oldUser);
    public void update(String sql);
}
