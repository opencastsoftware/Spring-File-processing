package com.opencast.SpringSample;

import org.springframework.context.ApplicationEvent;

import java.io.File;
import java.io.OutputStream;
import java.util.Map;

public class FileProcessEvent extends ApplicationEvent {
    private File fileName = null;
    private OutputStream outputStream = null;
    private Map<String, Object> narrativeRow = null;

    public FileProcessEvent(Object source)
    {
        super(source);
    }

    public File getFileName() {
        return fileName;
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public Map<String, Object> getNarrativeRow() {
        return narrativeRow;
    }

    public void setNarrativeRow(Map<String, Object> narrativeRow) {
        this.narrativeRow = narrativeRow;
    }


}
