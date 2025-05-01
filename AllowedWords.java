import java.util.ArrayList;

public class AllowedWords
{
   ArrayList<String> allowedWords = new ArrayList<String>();
   
   public AllowedWords()
   {
      allowedWords.add("left");
      allowedWords.add("right");
      allowedWords.add("back");
      allowedWords.add("straight");
   }
   
   public ArrayList<String> getList()
   {
      return allowedWords;
   }
}