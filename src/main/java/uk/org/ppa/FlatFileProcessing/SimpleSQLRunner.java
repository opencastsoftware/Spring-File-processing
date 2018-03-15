package uk.org.ppa.FlatFileProcessing;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class SimpleSQLRunner {

    private String mdrrPropertiesLocation;

    private String mdrrDriverClassName;
    private String mdrrUrl;
    private String mdrrUsername;
    private String mdrrPassword;

    public void runSQL(ArrayList<String> sqlInserts) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(mdrrPropertiesLocation));
        mdrrDriverClassName = properties.getProperty("mdrrDriverClassName");
        mdrrUrl = properties.getProperty("mdrrUrl");
        mdrrUsername = properties.getProperty("mdrrUsername");
        mdrrPassword = properties.getProperty("mdrrPassword");
        try {
            for (String SQL:sqlInserts) {
                runSqlString(SQL);
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void runSqlString(String SQL) throws ClassNotFoundException, SQLException {
        Class.forName(mdrrDriverClassName);
        Connection conn = DriverManager.getConnection(mdrrUrl, mdrrUsername, mdrrPassword);
        conn.setAutoCommit(false);
        Statement statement = conn.createStatement();
        statement.execute(SQL);
        statement.close();
        conn.close();
    }


    public void setMdrrPropertiesLocation(String mdrrPropertiesLocation) {
        this.mdrrPropertiesLocation = mdrrPropertiesLocation;
    }
}