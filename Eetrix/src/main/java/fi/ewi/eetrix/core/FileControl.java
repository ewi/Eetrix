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

    public ArrayList<String> getFileContents() {
        return fileContents;
    }

    public void setFileContents(ArrayList<String> contents) {
        this.fileContents = contents;
        writeFileContents();
    }

    public boolean fileIsWritable() {
        return inFilePointer.canWrite();
    }

    private void setFilepointer() {
        inFilePointer = new File(fileName);
    }

    private void openFileforReading() throws Exception {
        if (!inFilePointer.exists()) {
            inFilePointer.createNewFile();
        }
        // createFile();
    }

    private boolean createFile() throws Exception {
        try {
            outFilePointer = new PrintWriter(new FileOutputStream(fileName), true);
        } catch (Exception poikkeus) {
            return false;
        }
        return true;
    }

    private void writeFileContents() {
//        inFilePointer.close();
        try {
            createFile();
            fileContents.stream()
                    .forEach(n -> outFilePointer.println(n));
        } catch (Exception e) {

        }
    }

    private void readFileContents() throws Exception {
        Scanner reader = new Scanner(inFilePointer);
        outFilePointer.close();
        while (reader.hasNextLine()) {
            fileContents.add(reader.nextLine());
        }
    }
}
