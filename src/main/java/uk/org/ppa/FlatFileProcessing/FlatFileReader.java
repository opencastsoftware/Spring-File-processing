package uk.org.ppa.FlatFileProcessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FlatFileReader {
    public ArrayList<String> read(File test) {
        ArrayList<String> read = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(test))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                read.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return read;
    }
}
