package dev.elimar.graphqlstart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

public class Author {
    private String id;
    private String name;
    private String instagramUser;

    public Author(String id, String name, String instagramUser){
        this.id = id;
        this.name = name;
        this.instagramUser = instagramUser;
    }

    private static List<Author> authors = Arrays.asList(
            new Author("A1", "Author Stt1","author_sst1"),
            new Author("A2", "Author Stt2","author_sst2"),
            new Author("A3", "Author Stt3","author_sst3"),
            new Author("A4", "Author Stt4","author_sst4")
    );

    public static Author findById(String id){
        return  authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId(){
        return this.id;
    }
}
