package Payload;

public class DeteleBookData {

    public static String deleteBookData(String id)
    {
        return  "{\n" +
            "    \"ID\":\""+id+"\"\n" +
            "}";
    }
}
