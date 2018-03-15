package uk.org.ppa.FlatFileProcessing;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class SimpleSQLInsertor {

    private String mdrrPropertiesLocation;
    public   String mdrrDriverClassName;
    public  String mdrrUrl;
    public String mdrrUsername;
    public String mdrrPassword;

    public void runSQL(ArrayList<String> sqlInserts) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(mdrrPropertiesLocation));
        if(properties != null)
        {
            mdrrDriverClassName = properties.getProperty("mdrrDriverClassName");
            mdrrUrl = properties.getProperty("mdrrUrl");
            mdrrUsername = properties.getProperty("mdrrUsername");
            mdrrPassword = properties.getProperty("mdrrPassword");

        }
        else
        {
            System.out.println("properties not found");
        }
        try {
            for (String SQL:sqlInserts) {
                runSql(SQL);
            }

        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < sqlInserts.size(); i++) {

            String str = sqlInserts.get(i);
            System.out.println(str);
        }
    }

    public void runSql(String SQL) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement statement = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(mdrrUrl, mdrrUsername, mdrrPassword);
        statement = conn.createStatement();
        statement.execute(SQL);
        statement.close();
        conn.close();
    }

    public void setMdrrPropertiesLocation(String mdrrPropertiesLocation) {
        this.mdrrPropertiesLocation = mdrrPropertiesLocation;
    }
}