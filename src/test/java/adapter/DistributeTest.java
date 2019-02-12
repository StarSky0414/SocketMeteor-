package adapter;

import controller.SendTrendsController;
import db.mysql.provider.DBProviderTestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistributeTest {

    @Test
    public void testMethodAnnotation(){
        SendTrendsController sendTrendsController = new SendTrendsController();
        Distribute distribute = new Distribute();
        distribute.callMethodAnnotate(sendTrendsController,"testMethod");
        System.out.println("testMethodAnnotation is over");

    }

}