package Repository.XMLConverter;

import Model.Client;
import org.w3c.dom.Element;

public class XMLClientConverter implements XMLConverter<Client>{
    @Override
    public Client fromXML(Element node){
        String id = node.getAttribute("id");
        Client cli = new Client(Integer.parseInt(id));
        cli.setName(node.getElementsByTagName("name").item(0).getTextContent());
        cli.setAddress(node.getElementsByTagName("address").item(0).getTextContent());
        return cli;
    }
    @Override
    public String toFile(Client c){
        String string ="<client id=\"";
        string+=c.getId()+"\">\n";
        string+="<name>"+c.getName()+"</name>\n";
        string+="<address>"+c.getAdress()+"</address>\n";
        string+="</client>\n";
        return string;
    }
}
