package uk.org.ppa.SpringSample;

import java.util.ArrayList;

public interface IFileWriter {

	String getFilename();

	String getInitialText();

	void processData();

	void setMessageData(ArrayList<String> messageData);

	ArrayList<String> getDataToWrite();
}
