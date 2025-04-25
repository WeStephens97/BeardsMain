import java.io.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Map
{
   protected int level;
   protected int location;
   protected int lost = 0;
   
   public Map()
   {
      this.level = 100;
      this.location = 0;
   }
   
   public int getLevel()
   {
      return level;
   }
   public int getLocation()
   {
      return location;
   }
   
   public void setLevel(int level)
   {
      this.level = level;
      location = 0;
   }
   public void setLocation(int location)
   {
      lost++;
      this.location = location;
   }
   public int convertWords(String word)
   {
   //Converts words entered into an int associated with a text location
   //in the database
      while(level == 100)
      {
         if(word.equals("left"))
         {
            return 1;
         }
         if(word.equals("right"))
         {
            return 2;
         }
         if(word.equals("back"))
         {
            return 0;
         }
         if(word.equals("straight"))
         {
            level = 200;
            return 0;
         }
      }
      while(level == 200)
      {
         if(word.equals("left"))
         {
            return 1;
         }
         if(word.equals("back"))
         {
            return 0;
         }
         if(word.equals("right"))
         {
            level = 300;
            return 0;
         }
      }
      while(level == 300)
      {
         if(word.equals("left"))
         {
            return 1;
         }
         if(word.equals("right"))
         {
            level = 400;
            return 0;
         }
         if(word.equals("back"))
         {
            return 0;
         }
      }
      while(level == 400)
      {
         if(word.equals("straight"))
         {
            level = 1;
            System.out.println("straight");
            return 0;
         }
         if(word.equals("back"))
         {
            level = 300;
            return 1;
         }
         
      }
      
      return 0;

   }

   

   public String queryDatabase(int lev, String loc) throws SQLException
   {  int num = convertWords(loc);
      try(Connection connection = DriverManager.getConnection("jdbc:sqlite:map.db"))
      {
         Statement statement = connection.createStatement();
         statement.setQueryTimeout(30);
         String myQuery = String.format("select scenario from MapTable where level is %d and location is %d", level, num);
         ResultSet rs = statement.executeQuery(myQuery);
         String place = rs.getString(1);
         return place;   
      }
       
   }

   
}
