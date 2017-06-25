package amedeo.bitbucket.org.newsapp;

/**
 * Created by stefano on 24/06/2017.
 */

public class Story {

    //fields
    private String title;
    private String section;
    private String url;
    private String author;

    //constructors
    public Story(String title, String section, String url){
        this.title = title;
        this.section = section;
        this.url = url;
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
