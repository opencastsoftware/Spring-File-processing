package uk.org.ppa.SpringSample;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {

    public void write(List<String> dataToWrite) throws IOException {
        System.out.println("write Start");
        createFile("Output.txt", "Header", dataToWrite);
        System.out.println("write End");
    }

    private void createFile(String file, String initialText, List<String> arrData) throws IOException {
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
