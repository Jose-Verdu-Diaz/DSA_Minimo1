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
    private static Logger log = Logger.getLogger(Covid19ManagerImplTest.class);
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
        Assert.assertEquals(201, this.manager.addBrote());
        Assert.assertEquals(201, this.manager.addBrote());

        Assert.assertEquals(3, this.manager.getNumBrotes());

        mapaBrotes = this.manager.getHashMapBrotes();
        Assert.assertEquals(3, this.mapaBrotes.size());

        String id = mapaBrotes.keySet().iterator().next();

        brote = this.manager.getBrote(id);
        Assert.assertEquals(mapaBrotes.get(id),brote);

        /*
        brote=new Brote("test01");
        Assert.assertEquals(200,this.manager.setBrote(id,brote));
        mapaBrotes = this.manager.getHashMapBrotes();
        Assert.assertEquals(mapaBrotes.get(id).getIdentificador(),id);
        */
    }

    @After
    public void tearDown() {
        manager.tearDown();
    }
}

