package Repository.FileConverter;

import Model.Rental;

import java.time.LocalDate;

public class RentalFileConverter implements FileConverter<Rental> {

    @Override
    public String toString(Rental obj) {
        return obj.getId() + "," + obj.getClientId() + "," + obj.getMovieId() + "," + obj.getRentalStart() + "," + obj.getRentalEnd();
    }

    @Override
    public Rental fromString(String str) {
        String[] attrList = str.split(",");
        return new Rental(Integer.parseInt(attrList[0]), Integer.parseInt(attrList[1]), Integer.parseInt(attrList[2]), LocalDate.parse(attrList[3]), LocalDate.parse(attrList[4]));
    }
}
