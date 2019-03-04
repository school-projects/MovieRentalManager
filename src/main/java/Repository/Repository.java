package Repository;

import java.util.ArrayList;

public class Repository<T> implements IRepository<T> {
    private ArrayList<T> elements;
    public Repository(){this.elements=new ArrayList<T>();}
    public void add(T elem){
        elements.add(elem);
    }
    public void delete(T elem){
        elements.remove(elem);
    }
    public ArrayList<T> getAll(){
        return this.elements;
    }
    public String toString(){
        String str = "";
        for(T elem:elements)
            str += elem.toString()+"\n";
        return str;
    }

}
