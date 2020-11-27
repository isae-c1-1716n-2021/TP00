import java.util.regex.Pattern;

public class Customer {

    private String id;
    private String firstname;
    private String lastname;
    private String telephone;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    private String mail;


    public Customer(String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Customer(String id, String firstname, String lastname, String telephone, String street1, String street2, String city, String state, String zipcode, String country, String mail) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.mail = mail;
    }

    public static boolean insert (Customer customer) {
        CustomerDatabase.getInstance().insert(customer);
        return true;
    }

    public static boolean remove (String customerId) {
        return CustomerDatabase.getInstance().remove(customerId) != null;
    }

    public static Customer find (String customerId) {
        return CustomerDatabase.getInstance().find(customerId);
    }

    public boolean checkId(String id) {
        return getId() != null && getId().equals(id);
    }

    public boolean checkData(){
        return getCheckDataError() == null;
    }

    public String getCheckDataError() {
        if (!checkId()) return "Invalid id";
        if (!checkFirstName()) return "Invalid first name";
        if (!checkLastName()) return "Invalid last name";
        if (!checkMail()) return "Invalid mail";
        return null;
    }

    public boolean checkMail() {
        //source: https://www.geeksforgeeks.org/check-email-address-valid-not-java/
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (getMail() == null || getMail().length() < 12 || getMail().length() > 30)
            return false;
        return pat.matcher(getMail()).matches();
    }

    private boolean checkId() {
        return ckeckNullOrEmpty(getId());
    }

    private boolean checkFirstName() {
        return ckeckNullOrEmpty(getFirstname());
    }

    private boolean checkLastName() {
        return ckeckNullOrEmpty(getLastname());
    }

    private boolean ckeckNullOrEmpty (String string) {
        if (string == null) return false;
        if (string.equals("")) return false;
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}