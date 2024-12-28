package org.craft.designpatterns.structural;

import java.util.Date;
import java.util.logging.Logger;

/**
 *  the facade design pattern often tends to hide complex interface of a subsystem by providing an easier
 *  alternative. it does not encapsulate the subsystem since the classes of the subsystem can be directly contacted
 *  by those who are interested to, however it only offers an easier way of interacting with the subsystem.
 */
public class Facade {
    public ScheduleServer server;

    public Facade(ScheduleServer server){
        this.server = server;
    }

    void startServer(){
        server.startServer();
        server.initialiseServer();
        server.readSystemConfigFiles();
        server.registerListerners();
    }

    void stopServer(){
        server.unregisterListeners();
        server.destroyInitParam();
        server.stopProcesses();
        server.stopServer();
    }
}

class ScheduleServer{
    private final Logger logger = Logger.
            getLogger(this.getClass().getName());

    //processes for starting and stop the server
    void startServer(){
        logger.info("starting server .... [ " +
                new Date() + " ]" );
    }
    void initialiseServer(){
        logger.info("initialising server ..... [ " +
                this.getClass().descriptorString() + " ]");
    }
    void readSystemConfigFiles(){
        logger.info("read system wide configurations .... [ From " +
                this.getClass().getSimpleName() + " ]");
    }
    void registerListerners(){
        logger.info("listeners registered .... [ " +
                this.getClass().getTypeName() + " ]");
    }
    void stopServer(){
        logger.info("stopping server .... [ " +
                new Date() + " ]" );
    }
    void unregisterListeners(){
        logger.info("listeners unregistered .... [ " +
                this.getClass().getTypeName() + " ]");
    }
    void stopProcesses(){
        logger.info("stopping processes in memory .... [ " +
                this.getClass().getCanonicalName() + " ]");
    }
    void destroyInitParam(){
        logger.info("uninitialising server ..... [ " +
                this.getClass().descriptorString() + " ]");
    }
}