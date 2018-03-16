package uk.org.ppa.FlatFileProcessing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public abstract class FileProcessor {

	private String header;

	private String footer;

	private String pre;

	private String post;

	private ArrayList<String> headers;

	public void setHeaders(ArrayList<String> headers) {
		this.headers = headers;
	}

	public ArrayList<String> getLengths() {
		return lengths;
	}

	public void setLengths(ArrayList<String> lengths) {
		this.lengths = lengths;
	}

	private ArrayList<String> lengths;

	public void setHeader(String header) {
		this.header = header;
	}

	public String getHeader() {
		return header;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getFooter() {
		return footer;
	}

	public void setPre(String pre) {
		this.pre = pre;
	}

	public String getPre() {
		return pre;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPost() {
		return post;
	}

	public List<String> getHeaders() {
		return headers;
	}

	Map<String, String> getRecordMap(String record) {

		Map<String, String> recordMap = new HashMap<>();
		if (headers.size() != lengths.size()) {
			return null;
		}
		int stringIndex = 0;
		for (int i = 0; i < headers.size(); i++) {
			String value = record.substring(stringIndex, stringIndex + Integer.parseInt(lengths.get(i)));
			recordMap.put(headers.get(i), value);
			stringIndex += Integer.parseInt(lengths.get(i));
		}
		return recordMap;
	}



	abstract ArrayList<String> getProcessedData(ArrayList<String> unprocessedData);
}
