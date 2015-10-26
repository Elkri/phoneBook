package phoneBook;




public class noteRecord {

    private String first_name;
    private String last_name;
    private String company;
    private String phone;
    private String mail;
    private String date_of_birth;

    public String getFirst_name() {return first_name;}
    public void setFirst_name(String first_name) {this.first_name = first_name;}
    public String getLast_name() {return last_name;}
    public void setLast_name(String last_name) {this.last_name = last_name;}
    public String getCompany() {return company;}
    public void setCompany(String company) {this.company = company;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public String getMail() {return mail;}
    public void setMail(String mail) {this.mail = mail;}
    public String getDate_of_birth() {return date_of_birth;}
    public void setDate_of_birth(String date_of_birth) {this.date_of_birth = date_of_birth;}


    public void menu () {

        System.out.println("1. Add Record");
        System.out.println("2. Search Record");
        System.out.println("3. Delete Record");
        System.out.println("4. Edit Record");
        System.out.println("5. Display All Records");
        System.out.println("6. Exit");



    }





}
