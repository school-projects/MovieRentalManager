package Repository.FileConverter;

import Model.Client;

public class ClientFileConverter implements FileConverter<Client> {
    @Override
    public String toString(Client obj) {
        return obj.getId().toString() + "," + obj.getName() + "," + obj.getAdress();
    }

    @Override
    public Client fromString(String str) {
        String[] attrlist = str.split(",");
        return new Client(Integer.parseInt(attrlist[0]), attrlist[1], attrlist[2]);
    }
}
