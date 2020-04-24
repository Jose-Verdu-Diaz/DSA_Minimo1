package edu.upc.dsa;

import edu.upc.dsa.models.Caso;
import edu.upc.dsa.models.Brote;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class Covid19ManagerImplTest {
    private static Logger logger = Logger.getLogger(Covid19ManagerImplTest.class);
    public Covid19Manager manager = null;

    Brote brote;
    Caso caso;
    HashMap<String,Brote> mapaBrotes;

    @Before
    public void setUp() {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        manager = Covid19ManagerImpl.getInstance();
    }

    @Test
    public void addBrote(){
        Assert.assertEquals(201, this.manager.addBrote());
        Assert.assertEquals(1, this.manager.getNumBrotes());

        mapaBrotes = this.manager.getHashMapBrotes();
        Assert.assertEquals(1, this.mapaBrotes.size());
    }

    @After
    public void tearDown() {
        manager.tearDown();
    }
}

