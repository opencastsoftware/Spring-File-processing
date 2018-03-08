package uk.org.ppa.SpringSample;

import org.springframework.context.ApplicationEvent;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

public class FileProcessEvent extends ApplicationEvent {
    private File fileName = null;
    private OutputStream outputStream = null;
    private List<String> dataToWrite = null;

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

    public List<String> getDataToWrite() {
        return dataToWrite;
    }

    public void setDataToWrite(List<String> dataToWrite) {
        this.dataToWrite = dataToWrite;
    }


}
