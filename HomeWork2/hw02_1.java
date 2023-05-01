package HomeWork2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
Дана строка sql-запроса "select * from students where ".
Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * 
 * 
 * hw02_1
 */

public class hw02_1 {
    public static void main(String[] args) {
        split(reader());
      }

    public static String reader() 
    {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("HomeWork2\\Test.txt")))
        {
        String line;
        while ((line = reader.readLine()) != null)
            {
        sb.append(line).append(System.lineSeparator());
            }
        } 
        catch (IOException e) 
            {
          e.printStackTrace();
            }
        String str = sb.toString();
        return str;
    
    }
    
      public static void split(String str) 
    {
        String str2 = str.replace("{", "")
            .replace("}", "")
            .replace("\"", "");
        String[] newStr = str2.split(", ");
    
        Map<String, String> dictionary = new HashMap<String, String>();
        for (String item : newStr) {
          String[] strnew = item.split(":");
          System.out.println(Arrays.toString(strnew));
          for (int i = 0; i < newStr.length; i++) {
            dictionary.put(strnew[0], strnew[1]);
    
          }
        }
        System.out.println(dictionary.entrySet());
        StringBuilder WHERE = new StringBuilder();
        Set<Map.Entry<String, String>> pair = dictionary.entrySet();
        List<Map.Entry<String, String>> list = new ArrayList<>(pair);
        for (int i = 0; i < list.size(); i++) {
          if (!list.get(i).getValue().equals("null")) {
            WHERE.append(list.get(i).getKey() +  " = " +   list.get(i).getValue() + " and "  );
            
          }
        }
        System.out.println(WHERE);
    
      }
      
}