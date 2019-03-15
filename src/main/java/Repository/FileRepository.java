package Repository;

import Model.BaseObject;
import Repository.FileConverter.FileConverter;
import Validation.IValidator;

import java.io.*;
import java.util.Map;
import java.util.Optional;
import java.util.stream.StreamSupport;

public class FileRepository<TYPE,T extends BaseObject<TYPE>> extends Repository<TYPE,T>{
    private FileConverter<T> fileConverter;
    private String fileName;
    public FileRepository(IValidator<T> validator, FileConverter<T> fc) throws IOException {
        super(validator);
        this.fileConverter=fc;
        this.fileName="C:\\Users\\teodo\\Desktop\\Lab2-4\\src\\main\\java\\Repository\\movies.txt";
        readFromFile();
    }
    public void readFromFile() throws IOException {
        BufferedReader br =new BufferedReader(new FileReader(fileName));
        String line = br.readLine();
        while(line!=null){
            T obj = fileConverter.fromString(line);
            this.add(obj);
            line=br.readLine();
        }
        br.close();
    }
    public void writeToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));
        this.elements.values().stream().forEach(p-> {
            try {
                writer.write(fileConverter.toString((T) p));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    @Override
    public Optional<T> add(T elem){
        Optional<T> a=super.add(elem);
        try {
            this.writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }
    @Override
    public Optional<T> delete(TYPE id){
        Optional<T> a=super.delete(id);
        try {
            this.writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }
    @Override
    public Optional<T> update(T elem) {
        Optional<T> a=super.update(elem);
        try {
            this.writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }


}
