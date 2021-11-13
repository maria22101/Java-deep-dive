package web.jackson;

public class Course {

    private String author;
    private String title;
    private String requirements;

    public Course(String author, String title, String requirements) {
        this.author = author;
        this.title = title;
        this.requirements = requirements;
    }

    public Course() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    @Override
    public String toString() {
        return "Course{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", requirements='" + requirements + '\'' +
                '}';
    }
}
