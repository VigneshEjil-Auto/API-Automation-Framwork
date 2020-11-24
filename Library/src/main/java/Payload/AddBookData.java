package Payload;

import DataProvider.AddBookDetails;
import org.testng.annotations.Test;

public class AddBookData {
    @Test(dataProvider = "AddBookDetails",dataProviderClass = AddBookDetails.class)
    public static String addBookData(String name , String isbn,String aisle, String author)
    {
        String payload = "{\n" +
                "    \"name\":\""+name+"\",\n" +
                "    \"isbn\":\""+isbn+"\",\n" +
                "    \"aisle\":\""+aisle+"\",\n" +
                "    \"author\":\""+author+"\"\n" +
                "} ";
        return payload;
    }

}
