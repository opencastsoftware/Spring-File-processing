package uk.org.ppa.FlatFileProcessing;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class SimpleSQLInsertor {

    private String mdrrPropertiesLocation;

    public void runSQL(ArrayList<String> sqlInserts) throws IOException {
        Properties properties = new Properties();
//        InputStream inputStream = getClass().getResourceAsStream(mdrrPropertiesLocation);
        InputStream inputStream = getClass().getResourceAsStream("C:\\PxApplications\\properties\\mdrrApplicationsCommon.properties");
        properties.load(inputStream);
        inputStream.close();

        for (int i = 0; i < sqlInserts.size(); i++) {
            System.out.println(properties.size());
            String str = sqlInserts.get(i);
            System.out.println(str);
        }
    }

    public void setMdrrPropertiesLocation(String mdrrPropertiesLocation) {
        this.mdrrPropertiesLocation = mdrrPropertiesLocation;
    }
}
