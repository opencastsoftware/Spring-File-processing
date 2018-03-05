package com.opencast.SpringSample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HelloWorld {
    private String location;
    private IFileWriter writer;

    private ArrayList<String> messageData;

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

    public ArrayList<String> getMessageData() {
        return messageData;
    }

    public void read() {
        System.out.println("Read Start");
        ArrayList<String> messageread = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.location))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                messageread.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Read End");
        messageData = messageread;
    }

    public void check() {
        System.out.println("Check Start");
        for(String item : messageData) {
            System.out.println(item);
        }
        System.out.println("Check End ");
    }

    public void write() throws IOException{
        System.out.println("write Start");
	   	createFile("output", messageData);
	   	System.out.println("write End");
    }

    private void createFile(String file, ArrayList<String> arrData) throws IOException {
        FileWriter writer = new FileWriter(file + ".txt");
        int size = arrData.size();
        for (int i = 0; i < size; i++) {
            String str = arrData.get(i).toString();
            writer.write(str);
            if (i < size-1) {
                writer.write("\n");
            }
        }
        writer.close();
    }

    public void run() throws IOException {
        this.read();
        this.writer.setMessageData(messageData);
        this.writer.write();
        this.messageData = this.writer.getDataToWrite();
        this.write();
    }
}

