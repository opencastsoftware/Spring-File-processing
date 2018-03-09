package uk.org.ppa.FlatFileProcessing;

import java.util.ArrayList;

public interface IFileProcessor {

	String getInitialText();

	ArrayList<String> getProcessedData(ArrayList<String> unprocessedData);
}
