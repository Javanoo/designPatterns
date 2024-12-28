package org.craft.designpatterns.structural;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        testFacade();
    }

    //initially this used xpay, but now it has been changed to use payd,
    //the adaptor is shown into play when this method is called in main.
    static void transact (PayD details){
        System.out.println(details.getCardOwnerName() +
                " has paid " + details.getTotalAmount() +
                " on " + new Date());
;    }

    static void testAdaptor(){
        Xpay client = new XpayImpl();
        client.setCustomerName("Matthews");
        client.setCardCVVNo((short) 29);
        client.setAmount(2_000.0);

        transact(new Adaptor(client));
    }

    static  void testFacade(){
        //instead of creating an object and independently calling the start and
        //stop methods of the object in the predefined sequense, you can just use the facade.
        Facade scheduleServerFacade = new Facade(new ScheduleServer());
        scheduleServerFacade.startServer();
        scheduleServerFacade.stopServer();
    }
}
