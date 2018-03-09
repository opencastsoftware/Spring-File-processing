package uk.org.ppa.SpringSample;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;


public class HelloWorld {
    private String location;
    public static String fileName;
    public static String fileLocation;
    private static IFileWriter writer;

    private static  ArrayList<String> messageData;

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWriter(IFileWriter writer) {
        this.writer = writer;
    }

    public void setMessageData(ArrayList<String> messageData) {
        this.messageData  = messageData;
    }

    public IFileWriter getWriter() {
        return writer;
    }

    private ArrayList<String> getMessageData() {
        return messageData;
    }

    public  ArrayList<String> read(File test) {
        System.out.println("Read Start");
        ArrayList<String> messageread = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(test))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                messageread.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Read End");
        messageData = messageread;
        return messageread;
    }

    public void write(ArrayList<String> test) throws IOException{
        System.out.println("write Start");
	   	createFile(fileName, "gdfgd", test);
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
    public ArrayList<String> run(ArrayList<String>  test) throws IOException {
        System.out.println("Run Start");
        for (String item:
             test) {
            System.out.println(item);

        }
        if(this.writer == null) {
            System.out.println("not there");
        }
        else
        {
            System.out.println("found");
        }
//        this.writer.setMessageData(test);
//        this.writer.processData();
        System.out.println("Run End");
        return test;
    }


}

