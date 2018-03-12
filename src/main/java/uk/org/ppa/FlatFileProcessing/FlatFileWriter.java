package uk.org.ppa.FlatFileProcessing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FlatFileWriter {

    private String fileLocation;

    public void write(ArrayList<String> dataToWrite) throws IOException {
        System.out.println("write Start");
        createFile(fileLocation, dataToWrite);
        System.out.println("write End");
    }

    private void createFile(String fileLocation, ArrayList<String> dataToWrite) throws IOException {
        final File file = new File(fileLocation);
        final FileWriter writer = new FileWriter(file);
        int size = dataToWrite.size();
        writer.write("\r\n");
        for (int i = 0; i < size; i++) {
            String str = dataToWrite.get(i);
            writer.write(str);
            if (i < size-1) {
                writer.write("\r\n");
            }
        }
        writer.close();
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }
}
