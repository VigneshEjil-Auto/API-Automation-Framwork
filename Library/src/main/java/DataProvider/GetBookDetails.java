package DataProvider;

import org.testng.annotations.DataProvider;

public class GetBookDetails {
    @DataProvider(name = "GetBookDetails")
    public Object[][] getBookDetails()
    {
        return new Object[][] {{"Brian"},{"John"}};
    }
}
