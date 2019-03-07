package Model;

/**
 * Class Client which represents the attributes needed to operate in the Movie rental store
 */
public class Client extends BaseObject<Integer> {
    private String clientName;
    private String clientAddress;

    /**
     * Constructor for the Client class
     *
     * @param clientId the unique id of the client
     * @param name     the name of the client
     * @param address  the residential address of the client
     */
    public Client(int clientId, String name, String address) {
        super(clientId);
        this.clientName = name;
        this.clientAddress = address;
    }

    /**
     * Getter for the client's name
     *
     * @return the name of the client
     */
    public String getName() {
        return clientName;
    }

    /**
     * Getter for the client's address
     *
     * @return the client's home address
     */
    public String getAdress() {
        return clientAddress;
    }

    /**
     * Setter for the client's name
     *
     * @param clientName the client's new name
     */
    public void setName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Setter for the client's address
     *
     * @param clientAddress the client's new address
     */
    public void setAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * toString function of the Client class
     *
     * @return a string with the client's data
     */
    public String toString() {
        return "Client ID: " + this.getId() + "; Client Name: " + this.clientName + "; Adress: " + this.clientAddress;
    }
}
