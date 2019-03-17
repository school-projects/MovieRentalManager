package Repository.XMLConverter;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public interface XMLConverter<T> {
    String toFile(T elem);
    T fromXML(Element elem);
}
