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

    private ArrayList<String> getMessageData() {
        return messageData;
    }

    private void read() {
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

    private void write(String initialText, ArrayList<String> dataToWrite) throws IOException{
        System.out.println("write Start");
	   	createFile(this.writer.getFilename(), initialText, dataToWrite);
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

    public void run() throws IOException {
        this.read();
        this.writer.setMessageData(this.getMessageData());
        this.writer.processData();
        this.write(this.writer.getInitialText(), this.writer.getDataToWrite());
    }
}

