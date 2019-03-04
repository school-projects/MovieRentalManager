package Model;

public class BaseObject<T> {

    private T id;

    public BaseObject(T id){
        this.id=id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
