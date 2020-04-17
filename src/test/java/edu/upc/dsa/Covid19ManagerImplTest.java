package edu.upc.dsa;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Covid19ManagerImplTest {

    private HttpServer server;
    private WebTarget target;

    private static Logger logger = Logger.getLogger(Covid19ManagerImplTest.class);
    public Covid19Manager manager = null;

    @Before
    public void setUp() throws Exception {

        server = Main.startServer();
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);

        Assert.assertEquals(0, manager.getNumBrotes());
        manager.addBrote();
        Assert.assertEquals(0, manager.getNumBrotes());
    }

    @After
    public void tearDown() throws Exception {
        manager.tearDown();
        server.stop();
    }
}
