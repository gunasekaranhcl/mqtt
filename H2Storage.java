package com.mqtt;

//STEP 1. Import required packages
import java.sql.*;

public class H2Storage {
  // JDBC driver name and database URL
  static final String JDBC_DRIVER = "org.h2.Driver";
  static final String DB_URL = "jdbc:h2:~/hearts";

  //  Database credentials
  static final String USER = "sa";
  static final String PASS = "sa";

  public void addRecords() {
      Connection conn = null;
      Statement stmt = null;

      try {
          //STEP 2: Register JDBC driver
          Class.forName(JDBC_DRIVER);

          //STEP 3: Open a connection
          System.out.println("Connecting to a selected database...");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          System.out.println("Connected database successfully...");

          //STEP 4: Execute a query
          System.out.println("Inserting records into the table...");
          stmt = conn.createStatement();

          String sql = "INSERT INTO HEARTBEAT(pulse,duration,bpm) " + "VALUES (1, 1,1)";

          stmt.executeUpdate(sql);

          System.out.println("Inserted records into the table...");

      } catch (SQLException se) {
          //Handle errors for JDBC
          se.printStackTrace();
      } catch (Exception e) {
          //Handle errors for Class.forName
          e.printStackTrace();
      } finally {
          //finally block used to close resources
          try {
              if (stmt!=null)
                  conn.close();
          } catch (SQLException se) {
          } // do nothing
          try {
              if (conn!=null)
                  conn.close();
          } catch (SQLException se) {
              se.printStackTrace();
          } //end finally try
      } //end try

      System.out.println("Goodbye!");

  } //end main
  
  public void createTable(){
	  Connection conn = null;
      Statement stmt = null;

      try {
          //STEP 2: Register JDBC driver
          Class.forName("org.h2.Driver");

          //STEP 3: Open a connection
          System.out.println("Connecting to a selected database...");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          System.out.println("Connected database successfully...");

          //STEP 4: Execute a query
          System.out.println("Creating table in given database...");
          stmt = conn.createStatement();

          String sql = "CREATE TABLE IF NOT EXISTS HEARTBEAT " +
                  "(id INTEGER auto_increment, " +
                  " pulse BOOLEAN, " +                 
                  " duration INTEGER, " +
                  " time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                  " bpm INTEGER)";

          stmt.executeUpdate(sql);
          System.out.println("Created table in given database...");
      } catch (SQLException se) {
          //Handle errors for JDBC
          se.printStackTrace();
      } catch (Exception e) {
          //Handle errors for Class.forName
          e.printStackTrace();
      } finally {
          //finally block used to close resources
          try {
              if (stmt!=null)
                  conn.close();
          } catch (SQLException se) {
          } // do nothing
          try {
              if (conn!= null)
                  conn.close();
          } catch (SQLException se) {
              se.printStackTrace();
          } // end finally try
      } // end try
      System.out.println("Goodbye!");
  }
  public void deleteTable(){
	  Connection conn = null;
      Statement stmt = null;

      try {
          //STEP 2: Register JDBC driver
          Class.forName("org.h2.Driver");

          //STEP 3: Open a connection
          System.out.println("Connecting to a selected database...");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          System.out.println("Connected database successfully...");

          //STEP 4: Execute a query
          System.out.println("Creating table in given database...");
          stmt = conn.createStatement();

          String sql = "DROP TABLE HEARTBEAT;";

          stmt.executeUpdate(sql);
          System.out.println("Created table in given database...");
      } catch (SQLException se) {
          //Handle errors for JDBC
          se.printStackTrace();
      } catch (Exception e) {
          //Handle errors for Class.forName
          e.printStackTrace();
      } finally {
          //finally block used to close resources
          try {
              if (stmt!=null)
                  conn.close();
          } catch (SQLException se) {
          } // do nothing
          try {
              if (conn!= null)
                  conn.close();
          } catch (SQLException se) {
              se.printStackTrace();
          } // end finally try
      }
  }
  public void selectTable(){
	  Connection conn = null;
      Statement stmt = null;

      try {
          //STEP 2: Register JDBC driver
          Class.forName("org.h2.Driver");

          //STEP 3: Open a connection
          System.out.println("Connecting to a selected database...");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          System.out.println("Connected database successfully...");

          //STEP 4: Execute a query
          System.out.println("Selecting table in given database...");
          stmt = conn.createStatement();          

          ResultSet rs = stmt.executeQuery("SELECT * FROM HEARTBEAT;");
          while (rs.next()) {
              int id = rs.getInt(1);             
              System.out.println(id);
              boolean pulse = rs.getBoolean(2);             
              System.out.println(pulse);
              
              int duration = rs.getInt(3);             
              System.out.println(duration);
              
              Timestamp time = rs.getTimestamp(4);             
              System.out.println(time);
          }
          
          System.out.println("Created table in given database...");
      } catch (SQLException se) {
          //Handle errors for JDBC
          se.printStackTrace();
      } catch (Exception e) {
          //Handle errors for Class.forName
          e.printStackTrace();
      } finally {
          //finally block used to close resources
          try {
              if (stmt!=null)
                  conn.close();
          } catch (SQLException se) {
          } // do nothing
          try {
              if (conn!= null)
                  conn.close();
          } catch (SQLException se) {
              se.printStackTrace();
          } // end finally try
      }
  }
} //end JDBCExample

