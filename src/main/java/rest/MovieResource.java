package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.EMF_Creator;
import facades.MovieFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import entities.Movie;
import DTOs.MovieDTO;
import java.util.ArrayList;

//Todo Remove or change relevant parts before ACTUAL use
@Path("movie")
public class MovieResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);
    private static final MovieFacade FACADE = MovieFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieCount() {
        long count = FACADE.getMovieCount();
        return "{\"count\":" + count + "}";
    }

    @Path("year/{year}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieYear(@PathParam("year") int year) {
        List<Movie> movies = FACADE.getMovieYear(year);
        List<MovieDTO> mdto = new ArrayList();

        for (Movie movie : movies) {
            MovieDTO x = new MovieDTO(movie);

            mdto.add(x);
        }

        return new Gson().toJson(mdto);
    }

    @Path("title/{title}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieTitle(@PathParam("title") String title) {
        Movie movie = FACADE.getMovieTitle(title);
        MovieDTO mdto = new MovieDTO(movie);
        return new Gson().toJson(mdto);
    }

    @Path("author/{author}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieActors(@PathParam("author") String author) {
        Movie movie = FACADE.getMovieAuthor(author);
        MovieDTO mdto = new MovieDTO(movie);
        return new Gson().toJson(mdto);
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllMovies() {
        List<Movie> movies = FACADE.getAllMovies();
        List<MovieDTO> mdto = new ArrayList();

        for (Movie movie : movies) {
            MovieDTO x = new MovieDTO(movie);

            mdto.add(x);
        }

        return new Gson().toJson(mdto);
    }

    @Path("id/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieById(@PathParam("id") int id) {
        Movie movie = FACADE.getMovieByID(id);
        MovieDTO mdto = new MovieDTO(movie);
        return new Gson().toJson(mdto);

    }
}
