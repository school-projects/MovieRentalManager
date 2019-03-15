package Repository.FileConverter;

public interface FileConverter<T> {
    String toString(T obj);
    T fromString(String str);
}
