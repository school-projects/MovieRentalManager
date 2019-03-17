package Repository.XMLConverter;

import Model.Movie;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.time.LocalDate;

public class XMLMovieConverter implements XMLConverter<Movie>{
    @Override
    public Movie fromXML(Element node){
        String id = node.getAttribute("id");
        Movie mv = new Movie(Integer.parseInt(id));
        mv.setName(node.getElementsByTagName("name").item(0).getTextContent());
        mv.setDate(LocalDate.parse(node.getElementsByTagName("releaseDate").item(0).getTextContent()));
        return mv;
    }
    @Override
    public String toFile(Movie m){
        String string ="<movie id=\"";
        string+=m.getId()+"\">\n";
        string+="<name>"+m.getName()+"</name>\n";
        string+="<releaseDate>"+m.getDate().toString()+"</releaseDate>\n";
        string+="</movie>\n";
        return string;
    }


}
