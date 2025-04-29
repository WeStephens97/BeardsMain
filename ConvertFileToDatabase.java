import java.io.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//Converts data in MapText.txt into a table in map.db

public class ConvertFileToDatabase
{
   public static void main(String[] args)
   {
      try(Connection connection = DriverManager.getConnection("jdbc:sqlite:Map.db");
         FileReader fr = new FileReader("MapText.txt");
         BufferedReader br = new BufferedReader(fr))
      {
         Statement statement = connection.createStatement();
         statement.setQueryTimeout(30);
         statement.executeUpdate("drop table if exists MapTable");
         statement.executeUpdate("create table MapTable(level integer, location integer, scenario text)");
         
         String line = br.readLine();
         
         
         while(line != null)
         {
            String[] parts = line.split(",");
            int level = Integer.parseInt(parts[0]);
            int location = Integer.parseInt(parts[1]);
            statement.executeUpdate(String.format("insert into MapTable values(%d, %d, '%s')", level, location, parts[2]));
            line = br.readLine();
         }
      
      }
      catch(SQLException e)
      {
         System.out.printf("SQL ERROR: %s%n", e.getMessage());
      }
      catch(FileNotFoundException e)
      {
         System.out.printf("FILE NOT FOUND ERROR: %s%n", e.getMessage());
      }
      catch(IOException e)
      {
         System.out.printf("INPUT OUTPUT ERROR: %s%n", e.getMessage());
      }
      catch(NumberFormatException e)
      {
         System.out.printf("NUMBER FORMAT ERROR: %s%n", e.getMessage());
   
      }
   }
}