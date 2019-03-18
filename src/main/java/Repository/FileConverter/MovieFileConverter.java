package Repository.FileConverter;

import Model.Movie;

import java.time.LocalDate;

public class MovieFileConverter implements FileConverter<Movie> {
    @Override
    public String toString(Movie obj) {
        return obj.getId().toString() + "," + obj.getName() + "," + obj.getDate().toString();
    }

    @Override
    public Movie fromString(String str) {
        String[] attrList = str.split(",");
        return new Movie(Integer.parseInt(attrList[0]), attrList[1], LocalDate.parse(attrList[2]));
    }
}
