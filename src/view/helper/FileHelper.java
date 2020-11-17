/*
 * JPass
 *
 * Copyright (c) 2009-2020 Gabor Bata
 * All rights reserved.
 *
 */
package view.helper;

import java.io.FileNotFoundException;

import data.DocumentRepository;
import view.mainView;

/**
 * Helper utils for file operations.
 *
 * @author Gabor_Bata
 * 
 * @author Michael Rizzoni
 * lots of type configuration modifications
 *
 */
public final class FileHelper {

    private FileHelper() {
        // not intended to be instantiated
    }

    /**
     * Shows a file chooser dialog and exports the file.
     *
     * @param parent parent component
     */
    public static void importFile(final mainView parent, String fileName) {
        if (parent.getModel().isModified()) {
            try {
                saveFile(parent, parent.getModel().getFileName());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        try {
        doImportFile(fileName, parent);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Imports the given file.
     *
     * @param fileName file name
     * @param parent   parent component
     * @throws Exception
     */
    static void doImportFile(final String fileName, final mainView parent) throws Exception {
        try {
            parent.getModel().setUser(DocumentRepository.newInstance(fileName).readDocument());
            parent.getModel().setModified(true);
            parent.getModel().setFileName(null);
        } catch (Exception e) {
            throw new Exception("An error occured during the import operation:\n" + e.getMessage());
        }
    }

    /**
     * Shows a file chooser dialog and saves a file.
     *
     * @param parent   parent component
     * @param saveAs   normal 'Save' dialog or 'Save as'
     * @param callback callback function with the result; the result is {@code true}
     *                 if the file successfully saved; otherwise {@code false}
     * @throws Exception
     */
    public static void saveFile(final mainView parent, String fileName)
            throws Exception {
        try {
            DocumentRepository.newInstance(fileName).writeDocument(parent.getModel().getUser());
            parent.getModel().setFileName(fileName);
            parent.getModel().setModified(false);
        } catch (Exception e) {
            throw new Exception("An error occured during the save operation:\n" + e.getMessage());
        }
    }

    /**
     * Loads a file and fills the data model.
     *
     * @param fileName file name
     * @param parent parent component
     */
    public static void doOpenFile(final String fileName, final mainView parent) {
        parent.clearModel();
        if (fileName == null) {
            return;
        }
        try {
            parent.getModel().setUser(DocumentRepository.newInstance(fileName).readDocument());
            parent.getModel().setFileName(fileName);
        } catch (FileNotFoundException e) {
            try {
                System.out.println("File not found. Creating new file...");
                DocumentRepository.newInstance(fileName).writeDocument(parent.getModel().getUser());
                parent.getModel().setFileName(fileName);
            } catch (Exception err) {
                System.err.println(err.getMessage());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}