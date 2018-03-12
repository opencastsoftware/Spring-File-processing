package uk.org.ppa.FlatFileProcessing;

import java.util.ArrayList;
import java.util.Properties;

public interface IFileProcessor {

	String getHeader();

	String getFooter();

	Properties getProperties(String propertiesLocation);

	ArrayList<String> getProcessedData(ArrayList<String> unprocessedData);
}
