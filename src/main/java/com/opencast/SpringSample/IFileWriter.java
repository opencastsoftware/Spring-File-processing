package com.opencast.SpringSample;

import java.util.ArrayList;

public interface IFileWriter {

	void write();

	void setMessageData(ArrayList<String> messageData);
}
