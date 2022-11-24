package dev.elimar.graphqlstart.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tattoo {
    private String id;
    private String url;
    private String authorId;

    public Tattoo(String id, String url, String author){
        this.id = id;
        this.url = url;
        this.authorId = author;
    }

    private static List<Tattoo> tattoos = Arrays.asList(
            new Tattoo("T1", "https://tattoo1.dev","A1"),
            new Tattoo("T2", "https://tattoo2.dev","A2"),
            new Tattoo("T3", "https://tattoo3.dev","A1"),
            new Tattoo("T4", "https://tattoo4.dev","A3")
    );

    public static Tattoo findById(String id){
        return tattoos.stream()
                .filter(tattoo -> tattoo.getId().equals(id))
                .findFirst().orElse(null);
    }

    public static List<Tattoo> findByAuthor(String id){
        return  tattoos.stream()
                .filter(tattoo -> tattoo.getAuthorId().equals(id))
                .collect(Collectors.toList());
    }

    public static List<Tattoo> findByAuthors(List<Author> authors){
        List<String> authorIds = authors.stream().map(a -> a.getId()).collect(Collectors.toList());
        return tattoos.stream()
                .filter(tattoo -> authorIds.contains(tattoo.getAuthorId()))
                .collect(Collectors.toList());
    }

    public String getId(){
        return this.id;
    }

    public String getAuthorId(){
        return this.authorId;
    }

}
