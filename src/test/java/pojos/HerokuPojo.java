package pojos;

public class HerokuPojo {


    //  { "firstname": "Ali",
    //                  "lastname": "Can",
    //                  "totalprice": 500,
    //                  "depositpaid": true,
    //                  "bookingdates": {
    //                      "checkin": "2022-03-01",
    //                      "checkout": "2022-03-11"
    //                   }


    private String firstname;
    private String lastname;
    private int totalprice;
    private BookingDatesPojo bookingDate;

    public BookingDatesPojo getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(BookingDatesPojo bookingDate) {
        this.bookingDate = bookingDate;
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

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    private boolean depositpaid;


    @Override
    public String toString() {
        return "HerokuPojo01{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", bookingDate=" + bookingDate +
                ", depositpaid=" + depositpaid +
                '}';
    }

    public HerokuPojo(String firstname, String lastname, int totalprice, BookingDatesPojo bookingDate, boolean depositpaid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.bookingDate = bookingDate;
        this.depositpaid = depositpaid;
    }

    public HerokuPojo() {
    }
}
