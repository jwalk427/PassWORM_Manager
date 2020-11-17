package data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import model.User;
import xml.XmlConverter;

/**
 * Repository class for reading and writing (encrypted) XML documents.
 *
 * @author Gabor_Bata
 * https://github.com/gaborbata/jpass/tree/master/src/main/java/jpass
 *
 * @author Michael Rizzoni
 * Type compatibility modifications.
 * 
 */
public final class DocumentRepository {

    /**
     * File name to read/write.
     */
    private final String fileName;

    /**
     * Converter between document objects and streams representing XMLs
     */
    private static final XmlConverter<User> CONVERTER = new XmlConverter<>(User.class);

    /**
     * Creates a DocumentRepository instance.
     *
     * @param fileName file name
     * @param key key for encryption
     */
    private DocumentRepository(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Creates a document repository with no encryption.
     *
     * @param fileName file name
     * @return a new DocumentHelper object
     */
    public static DocumentRepository newInstance(final String fileName) {
        return new DocumentRepository(fileName);
    }

    /**
     * Reads and XML file to an {@link User} object.
     *
     * @return the document
     * @throws FileNotFoundException if file is not exists
     * @throws IOException when I/O error occurred
     * @throws DocumentProcessException when file format or password is incorrect
     */
    public User readDocument() throws IOException, DocumentProcessException {
        InputStream inputStream = null;
        User entries;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(this.fileName));
            entries = CONVERTER.read(inputStream);
        } catch (Exception e) {
            throw new DocumentProcessException(e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return entries;
    }

    /**
     * Writes a document into an XML file.
     *
     * @param document the document
     * @throws DocumentProcessException when document format is incorrect
     * @throws IOException when I/O error occurred
     */
    public void writeDocument(final User document) throws DocumentProcessException, IOException {
        OutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(this.fileName));
            CONVERTER.write(document, outputStream);
        } catch (Exception e) {
            throw new DocumentProcessException(e.getMessage());
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
