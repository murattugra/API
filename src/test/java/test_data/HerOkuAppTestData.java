package test_data;

import java.util.HashMap;

public class HerOkuAppTestData {



    //               "firstname": "Ali",
    //              "lastname": "Can",
    //              "totalprice": 700,
    //              "depositpaid": true,
    //              "bookingdates": {
    //                                "checkin": "2022-02-01",
    //                                    "checkout": "2022-02-11"



    public HashMap<String,Object> setUpTestData(){

        HashMap<String, Object> bookingDates=new HashMap<>();
        bookingDates.put("checkin","2022-03-01");
        bookingDates.put("checkout","2022-03-11");


        HashMap<String, Object> expectedData1=new HashMap<>();
        expectedData1.put("firstname","Ali");
        expectedData1.put("lastname","Can");
        expectedData1.put("totalprice",500);
        expectedData1.put("depositpaid",true);
        expectedData1.put("bookingdates",bookingDates);


        return expectedData1;
    }


}
