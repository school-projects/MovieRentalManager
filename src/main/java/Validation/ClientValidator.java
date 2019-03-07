package Validation;

import Exceptions.ValidatorException;
import Model.Client;

public class ClientValidator implements IValidator<Client> {

    @Override
    public void validate(Client client) throws ValidatorException {
        Integer clientId = client.getId();
        String clientName = client.getName();
        String clientAddress = client.getAdress();

        String exceptionStr = "";
        if (clientId == null)
            exceptionStr += "Invalid id! ";
        if (clientName.length() == 0 || clientName.trim().length() == 0)
            exceptionStr += "Invalid client name! ";
        if (clientAddress.length() == 0 || clientAddress.trim().length() == 0)
            exceptionStr += "Invalid client address! ";

        if (!exceptionStr.equals(""))
            throw new ValidatorException(exceptionStr);
    }
}
