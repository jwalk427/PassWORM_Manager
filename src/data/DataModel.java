package data;

public class DataModel {

    private static DataModel INSTANCE;

    private Account account = new Account();
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

    public final Account getAccount() {
        return this.account;
    }

    public final void setAccount(final Account account) {
        this.account = account;
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
        this.account = new Account();
        this.fileName = null;
        this.modified = false;
    }
    
}
