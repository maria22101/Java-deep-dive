package hw_exceptions_from_habr_articles.blog_225585_exceptions_part_2;

import java.io.IOException;

public class Child extends Parent {
    @Override
    void f() throws IOException { // acceptable as the child class does not widening the throwing exceptions range
    }
}
