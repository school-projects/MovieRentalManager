package Validation;

import Exceptions.ValidatorException;
import Model.Client;

import java.util.Optional;

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
//        Integer clientId = client.getId();
//        String clientName = client.getName();
//        String clientAddress = client.getAdress();
//
//        String exceptionStr = "";
//        if (clientId == null)
//            exceptionStr += "Invalid id! ";
//        if (clientName.length() == 0 || clientName.trim().length() == 0)
//            exceptionStr += "Invalid client name! ";
//        if (clientAddress.length() == 0 || clientAddress.trim().length() == 0)
//            exceptionStr += "Invalid client address! ";
//
//        if (!exceptionStr.equals(""))
//            throw new ValidatorException(exceptionStr);

        Optional<Client> c = Optional.of(client);
        c.filter(j-> j.getId() != null).orElseThrow(() -> new ValidatorException("Invalid client id"));
        c.filter(j->j.getName().length() != 0 && j.getName().trim().length() != 0).orElseThrow(() -> new ValidatorException("Invalid client name! "));
        c.filter(j->j.getAdress().length() != 0 && j.getAdress().trim().length() != 0).orElseThrow(() -> new ValidatorException("Invalid client adress! "));
    }
}
