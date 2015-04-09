package com.jpa;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class DirectoryWatcher {

	private ExcelReadImpl excel;
	
	private WatchService watcher;
	private Path dir;
	@PostConstruct
	public void artStartUp(){
		try{
			dir = Paths.get("c:\\excel\\");
			watcher = FileSystems.getDefault().newWatchService();
			dir.register(watcher, ENTRY_CREATE,ENTRY_MODIFY);
		}catch(IOException io){
			io.getMessage();
		}
	while (true) {
	    WatchKey key;
	    try {
	        // wait for a key to be available
	        key = watcher.take();
	    } catch (InterruptedException ex) {
	        return;
	    }
	 
	    for (WatchEvent<?> event : key.pollEvents()) {
	        // get event type
	        WatchEvent.Kind<?> kind = event.kind();
	 
	        // get file name
	        @SuppressWarnings("unchecked")
	        WatchEvent<Path> ev = (WatchEvent<Path>) event;
	        Path fileName = ev.context();
	        
	        if (kind == OVERFLOW) {
	            continue;
	        } else if (kind == ENTRY_CREATE) {
	        	excel.callAll();
	        } else if (kind == ENTRY_MODIFY) {
	        	excel.callAll();
	        }
	    }
	    // IMPORTANT: The key must be reset after processed
	    boolean valid = key.reset();
	    if (!valid) {
	        break;
	    }
	}
	}
}
