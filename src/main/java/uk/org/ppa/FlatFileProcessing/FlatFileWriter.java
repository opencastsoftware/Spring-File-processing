package uk.org.ppa.FlatFileProcessing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FlatFileWriter {
    public void write(ArrayList<String> test) throws IOException {
        System.out.println("write Start");
        createFile("output.txt", "gdfgd", test);
        System.out.println("write End");
    }

    private void createFile(String file, String initialText, ArrayList<String> arrData) throws IOException {
        final FileWriter writer = new FileWriter(file);
        int size = arrData.size();
        writer.write(initialText);
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
}
