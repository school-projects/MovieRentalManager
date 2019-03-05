package Model;

/**
 * Generic class for id identification of various objects
 * @param <T> the type of the ID
 */
public class BaseObject<T> {

    private T id;

    /**
     * Constructor for BaseObject class
     *
     * @param id :the given id of any object
     */
    public BaseObject(T id){
        this.id=id;
    }

    /**
     * Method with which to get the id of the object
     *
     * @return the id of the object
     */
    public T getId() {
        return id;
    }

    /**
     * Method with which to set the id of an given object
     * @param id :the given id to be set
     */
    public void setId(T id) {
        this.id = id;
    }
}
