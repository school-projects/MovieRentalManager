package Main;

import Model.Movie;
import Repository.Repository;

public class Main {
    public static void main(String args[]){
        System.out.println("Hello World");

        Movie a = new Movie(1,"The Fateful Eight","2016-01-15");
        Movie b = new Movie(2,"Men in Black","1997-07-04");
        Movie c = new Movie(3,"Bohemian Rhapsody","2018-10-24");
        Repository<Integer,Movie> repo = new Repository<Integer,Movie>();
        repo.add(a);repo.add(b);repo.add(c);
        System.out.println(repo.findAll());
        repo.delete(3);
        System.out.println(repo.findAll());
    }
}
