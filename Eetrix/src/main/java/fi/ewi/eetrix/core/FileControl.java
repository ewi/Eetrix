package fi.ewi.eetrix.core;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class for opening files and reading their contents.
 *
 * @author ewi
 */
public class FileControl {

    private String fileName;
    private File inFilePointer;
    private PrintWriter outFilePointer;
    private ArrayList<String> fileContents;

    /**
     * Constructor for file operations. 
     * 
     * @param fileName File name.
     */
    public FileControl(String fileName) {
        this.fileName = fileName;
        fileContents = new ArrayList<>();
        setFilepointer();

        try {
            openFileforReading();
        } catch (Exception e) {
            //if (e.equals(FileNotFoundException))
            //createFile();
        }
    }
    
    /**
     * Return file contents as list of strings in arraylist.
     *
     * @return ArrayList of file contents.
     */
    public ArrayList<String> getFileContents() {
        return fileContents;
    }

    /**
     * Set fileContents array contents and write to file.
     *
     * @param contents Contents of scorelist.
     */
    public void setFileContents(ArrayList<String> contents) {
        this.fileContents = contents;
        writeFileContents();
    }

    /**
     * Test if file is writable.
     *
     * @return true if can write
     */
    public boolean fileIsWritable() {
        return inFilePointer.canWrite();
    }

    /**
     * Set input file variable.
     */
    private void setFilepointer() {
        inFilePointer = new File(fileName);
    }

    /**
     * Open file for reading. If file does not exist create it.
     *
     * @throws Exception
     */
    private void openFileforReading() throws Exception {
        if (!inFilePointer.exists()) {
            inFilePointer.createNewFile();
        }
    }

    /**
     * Create file with exceptions. Return true if success, false otherwise.
     *
     * @return success value
     */
    private boolean createFile() {
        try {
            outFilePointer = new PrintWriter(new FileOutputStream(fileName), true);
        } catch (Exception poikkeus) {
            return false;
        }
        return true;
    }

    /**
     * Write fileContents array variable to outputfile.
     */
    private void writeFileContents() {
        try {
            createFile();
            fileContents.stream()
                    .forEach(n -> outFilePointer.println(n));
        } catch (Exception e) {

        }
    }

    /**
     * Read file contents to variable.
     * @throws Exception 
     */
    private void readFileContents() throws Exception {
        Scanner reader = new Scanner(inFilePointer);
        outFilePointer.close();
        while (reader.hasNextLine()) {
            fileContents.add(reader.nextLine());
        }
    }
}
