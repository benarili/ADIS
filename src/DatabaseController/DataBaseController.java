package DatabaseController;

import Entries.DataBaseUsable;

public interface DataBaseController {

    public void insert(DataBaseUsable entry) throws Exception;
    public void delete(DataBaseUsable entry) throws Exception;

}
