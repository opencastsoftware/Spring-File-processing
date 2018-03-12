package uk.org.ppa.FlatFileProcessing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FlatFileWriter {

    private String location;

    private String fileName;

    public void write(ArrayList<String> test) throws IOException {
        System.out.println("write Start");
        createFile(fileName, location, test);
        System.out.println("write End");
    }

    private void createFile(String fileName, String location, ArrayList<String> arrData) throws IOException {
        final File file = new File(fileName, location);
        final FileWriter writer = new FileWriter(file);
        int size = arrData.size();
        writer.write("\n");
        for (int i = 0; i < size; i++) {
            String str = arrData.get(i);
            writer.write(str);
            if (i < size-1) {
                writer.write("\n");
            }
        }
        writer.close();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
