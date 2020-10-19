package data;

import model.User;

public class DataModel {

    private static DataModel INSTANCE;

    private User user = null;
    private String fileName = null;
    private boolean modified = false;

    private DataModel() {
        //private constructor to prevent instantiation
    }

    public static synchronized DataModel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataModel();
        }
        return INSTANCE;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(final User user) {
        this.user = user;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private final boolean isModified() {
        return this.modified;
    }

    private final void setModified(final boolean modified) {
        this.modified = modified;
    }

    public final void clear() {
        this.user = null;
        this.fileName = null;
        this.modified = false;
    }
    
}
