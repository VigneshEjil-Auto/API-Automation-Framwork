package DataProvider;

import io.restassured.parsing.Parser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetData {

    @DataProvider(name = "GoogleSearchDetails")
    public Object[][] getData()
    {
        return new Object[][] {{"AIzaSyB-PB3uTFSU9doRIPHo3sYjzT_o0h3jNRk",
                               "017576662512468239146:omuauf_lfve","lectures"},
                               {"AIzaSyB-PB3uTFSU9doRIPHo3sYjzT_o0h3jNRk",
                                       "017576662512468239146:omuauf_lfve","book"},
                                {"AIzaSyB-PB3uTFSU9doRIPHo3sYjzT_o0h3jNRk",
                                        "017576662512468239146:omuauf_lfve","hotel"}};

    }
}
