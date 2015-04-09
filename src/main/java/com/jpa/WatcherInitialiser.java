package com.jpa;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class WatcherInitialiser {
	   
		@EJB
	    private DirectoryWatcher dirWatcher = new DirectoryWatcher();
	    
	    @PostConstruct
	    public void init() throws IOException {
	    	dirWatcher.atStartUp();;
	    }
}
