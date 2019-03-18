package Repository.XMLConverter;

import Model.Rental;
import org.w3c.dom.Element;

import java.time.LocalDate;

public class XMLRentalConverter implements XMLConverter<Rental> {
    @Override
    public String toFile(Rental rental) {
        String ret = "<rental id=\"";
        ret += rental.getId() + "\">\n";
        ret += "<clientId>" + rental.getClientId() + "</clientId>\n";
        ret += "<movieId>" + rental.getMovieId() + "</movieId>\n";
        ret += "<rentalStart>" + rental.getRentalStart() + "</rentalStart>\n";
        ret += "<rentalEnd>" + rental.getRentalEnd() + "</rentalEnd>\n";
        ret += "</rental>\n";
        return ret;
    }

    @Override
    public Rental fromXML(Element elem) {
        int id = Integer.parseInt(elem.getAttribute("id"));
        int clientId = Integer.parseInt(elem.getElementsByTagName("clientId").item(0).getTextContent());
        int movieId = Integer.parseInt(elem.getElementsByTagName("movieId").item(0).getTextContent());
        LocalDate rentalStart = LocalDate.parse(elem.getElementsByTagName("rentalStart").item(0).getTextContent());
        LocalDate rentalEnd = LocalDate.parse(elem.getElementsByTagName("rentalEnd").item(0).getTextContent());
        return new Rental(id, clientId, movieId, rentalStart, rentalEnd);
    }
}
