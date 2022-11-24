package dev.elimar.graphqlstart.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        return  authors.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public static List<Author> getByAttributes(Author author){
        List<Author> authorsById = authors.stream()
                .filter(ar -> ar.getId().equals(author.getId()))
                .collect(Collectors.toList());
        List<Author> authorsByName = authors.stream()
                .filter(ar -> ar.getName().equals(author.getName()))
                .collect(Collectors.toList());
        List<Author> result = new ArrayList<>(authorsById);
        result.remove(authorsByName);
        result.addAll(authorsByName);
        return result;
    }
    @Override
    public String toString() {
        return String.format("ID {%s}:name {%s}, user {%s}",this.id,this.name,this.instagramUser);
    }
}
