package Model.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.awt.print.Book;
import java.util.List;

public class Root {

    public List<Books> getBook() {
        return book;
    }

    public void setBook(List<Books> book) {
        this.book = book;
    }
    @JsonProperty("Books")
    private List<Books> book ;

}
