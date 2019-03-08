package Validation;

import Exceptions.ValidatorException;
import Model.Client;

/**
 * Validator for the client class
 */
public class ClientValidator implements IValidator<Client> {

    /**
     * Validates a given client.
     * @param client the client to be validated
     * @throws ValidatorException if the id is null
     *                            if the name is empty
     *                            if the address is empty
     */
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
