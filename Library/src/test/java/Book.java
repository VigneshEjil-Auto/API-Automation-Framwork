import DataProvider.AddBookDetails;
import DataProvider.GetBookDetails;
import Model.Pojo.Root;
import Payload.AddBookData;
import Payload.DeteleBookData;
import Payload.UpdateBook;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class Book {

    @Test(dataProvider = "GetBookDetails",dataProviderClass = GetBookDetails.class)
    public void getBook(String author)
    {
        RestAssured.baseURI="http://216.10.245.166/Library/GetBook.php";

        Response res = given().log().all().queryParams("AuthorName",author).expect().defaultParser(Parser.JSON)
                .when().get("http://216.10.245.166/Library/GetBook.php")
                .then().extract().response();

        String str = res.asString();
        System.out.println(str);


    }
    @Test(dataProvider = "AddBookDetails", dataProviderClass = AddBookDetails.class)
    public  void addBook(String name , String isbn,String aisle, String author)
    {
        baseURI="http://216.10.245.166/Library/Addbook.php";
        String str1= given()
                .body(AddBookData.addBookData(name,isbn,aisle,author))
                .expect().defaultParser(Parser.JSON)
                .when().post("Library/Addbook.php")
                .then().extract().response().asString();
        System.out.println(str1);

        JsonPath js = new JsonPath(str1);
        String id= js.get("ID");
        ArrayList<String> list = new ArrayList<>();
        list.add(id);
        System.out.println("The confirmation ID is : " + id + " And the list size is :"+ list.size());

    }

    @Test
    public void deleteBook(String id)
    {

        baseURI="http://216.10.245.166/Library/DeleteBook.php";
               String str2 = given().body(DeteleBookData.deleteBookData(id))
                        .when().delete("Library/DeleteBook.php")
                        .then().extract().response().asString();

        System.out.println(str2);
    }

    @Test
    public void updateBook()
    {
        baseURI="http://216.10.245.166/Library/Addbook.php";
        String str3 = given().body(UpdateBook.updateBook())
                .when().put("Library/Addbook.php")
                .then().extract().response().asString();

        System.out.println(str3);

    }

}
