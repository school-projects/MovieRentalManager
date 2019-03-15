package Repository.FileConverter;

import Model.BaseObject;

public interface FileConverter<T> {
    String toString(T obj);
    T fromString(String str);
}
