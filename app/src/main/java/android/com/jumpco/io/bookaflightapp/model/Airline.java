package android.com.jumpco.io.bookaflightapp.model;

public class Airline {
    public String id;
    public String nameOfAirline;
    public String basePriceForPerson;
    public boolean isBooked;
    public boolean isDeleted;

    public Airline(String id, String nameOfAirline, String basePriceForPerson, boolean isBooked, boolean isDeleted) {
        this.id = id;
        this.nameOfAirline = nameOfAirline;
        this.basePriceForPerson = basePriceForPerson;
        this.isBooked = isBooked;
        this.isDeleted = isDeleted;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getNameOfAirline() {
        return nameOfAirline;
    }

    public void setNameOfAirline(String nameOfAirline) {
        this.nameOfAirline = nameOfAirline;
    }

//    public int getBasePriceForPerson() {
//        return basePriceForPerson;
//    }
//
//    public void setBasePriceForPerson(int basePriceForPerson) {
//        this.basePriceForPerson = basePriceForPerson;
//    }
}
