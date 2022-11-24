package dev.elimar.graphqlstart.controller;

import dev.elimar.graphqlstart.model.Author;
import dev.elimar.graphqlstart.model.Tattoo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TattooController {
    @QueryMapping
    public Tattoo tattooById(@Argument String id){
        return Tattoo.findById(id);
    }

    @QueryMapping
    public List<Tattoo> tattooByAuthor(@Argument String author){
        return Tattoo.findByAuthor(author);
    }

    @SchemaMapping
    public Author author(Tattoo tattoo){
        return Author.findById(tattoo.getAuthorId());
    }
}
