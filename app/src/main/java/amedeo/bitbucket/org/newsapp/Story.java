package amedeo.bitbucket.org.newsapp;

/**
 * Created by stefano on 24/06/2017.
 */

public class Story {

    //fields
    private String title;
    private String section;
    private String url;

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

    public String getSection() {
        return section;
    }

    public String getUrl() {
        return url;
    }

}
