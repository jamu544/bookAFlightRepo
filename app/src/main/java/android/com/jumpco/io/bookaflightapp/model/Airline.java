package android.com.jumpco.io.bookaflightapp.model;

public class Airline {
    private int id;
    private String nameOfAirline;
    private long basePriceForPerson;
    private boolean isBooked;

    public Airline(int id,String nameOfAirline,long basePriceForPerson) {
        this.id = id;
        this.nameOfAirline = nameOfAirline;
        this.basePriceForPerson = basePriceForPerson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfAirline() {
        return nameOfAirline;
    }

    public void setNameOfAirline(String nameOfAirline) {
        this.nameOfAirline = nameOfAirline;
    }

    public long getBasePriceForPerson() {
        return basePriceForPerson;
    }

    public void setBasePriceForPerson(long basePriceForPerson) {
        this.basePriceForPerson = basePriceForPerson;
    }
}
