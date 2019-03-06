package Model;

/**
 * Class Client which represents the attributes needed to operate in the Movie rental store
 */
public class Client extends BaseObject<Integer>{
    private String client_name;
    private String adress;

    /**
     * Constructor for the Client class
     * @param clientid the unique id of the client
     * @param name the name of the client
     * @param adress the residential address of the client
     */
    public Client(int clientid,String name,String adress){
        super(clientid);
        this.client_name=name;
        this.adress=adress;
    }

    /**
     * Getter for the client's name
     * @return the name of the client
     */
    public String getName() {
        return client_name;
    }

    /**
     * Getter for the client's address
     * @return the client's home address
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Setter for the client's name
     * @param client_name the client's new name
     */
    public void setName(String client_name) {
        this.client_name = client_name;
    }

    /**
     * Setter for the client's address
     * @param adress the client's new address
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * toString function of the Client class
     * @return a string with the client's data
     */
    public String toString(){
        return "Client ID: "+this.getId()+"; Client Name: "+this.client_name+"; Adress: "+this.adress;
    }
}
