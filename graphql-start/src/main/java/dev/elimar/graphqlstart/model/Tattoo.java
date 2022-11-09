package dev.elimar.graphqlstart.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    public String getId(){
        return this.id;
    }

    public String getAuthorId(){
        return this.authorId;
    }

}
