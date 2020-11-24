package DataProvider;

import org.testng.annotations.DataProvider;

public class AddBookDetails {
    @DataProvider(name = "AddBookDetails")
    public Object[][] addBookDetails()
    {
        return new Object[][] {{"Java","Test11","1111","Book1"},
                {"Python","Test21","2221","Book2"},{"C","Test31","3331","Book3"},
                {"ruby","Test41","4441","Book4"}};

    }
}
