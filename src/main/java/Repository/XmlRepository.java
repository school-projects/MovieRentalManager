package Repository;

import Exceptions.FileException;
import Exceptions.UserInputException;
import Model.BaseObject;
import Repository.XMLConverter.XMLConverter;
import Validation.IValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class XmlRepository<TYPE,T extends BaseObject<TYPE>> extends Repository<TYPE,T>{
    private String filePath;
    private XMLConverter<T> converter;

    public XmlRepository(IValidator<T> validator, XMLConverter<T> converter, String filePath) throws IOException, SAXException, ParserConfigurationException {
        super(validator);
        this.filePath=filePath;
        this.converter=converter;
        this.LoadObjects();
    }

    public void LoadObjects() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(this.filePath);
        Element root = doc.getDocumentElement();

        NodeList nl = root.getChildNodes();
        int len = nl.getLength();
        for(int i=0;i<len;i++){
            Node node = nl.item(i);
            if(node instanceof Element){
                T obj = this.converter.fromXML((Element)node);
                this.add(obj);
            }
        }

    }

    public void SaveObjects() throws ParserConfigurationException, IOException, SAXException{
        DocumentBuilderFactory docFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(this.filePath);
        Element root = doc.getDocumentElement();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,false));
            ){
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?><objects>\n");
            this.elements.values().stream().forEach(p-> {
                try {
                    writer.write(converter.toFile(p));
                } catch (IOException e) {
                    throw new FileException(e.getMessage());
                }
            });
            writer.write("</objects>");
        }catch(IOException e){
            throw new FileException(e.getMessage());
        }


    }
    @Override
    public Optional<T> add(T elem){
        Optional<T> a=super.add(elem);
        try {
            try {
                this.SaveObjects();
            } catch (ParserConfigurationException | SAXException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
        return a;
    }
    @Override
    public Optional<T> delete(TYPE id){
        Optional<T> a=super.delete(id);
        try {
            try {
                this.SaveObjects();
            } catch (ParserConfigurationException | SAXException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
        return a;
    }
    @Override
    public Optional<T> update(T elem) {
        Optional<T> a=super.update(elem);
        try {
            try {
                this.SaveObjects();
            } catch (ParserConfigurationException | SAXException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
        return a;
    }



}
