package com.jpa;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateless;

import com.dao.ExcelDAO;

@Startup
@Stateless
public class DirectoryWatcher {
	private WatchService watcher;
	@EJB
	private ExcelDAO dao;
	
	public DirectoryWatcher() throws IOException {
		FileSystem fileSystem = FileSystems.getDefault();
		Path path = fileSystem.getPath("c:\\excel\\");
		watcher = fileSystem.newWatchService();
		path.register(watcher, ENTRY_CREATE, ENTRY_MODIFY);
	}
	
	@Schedule(minute = "*/1", hour = "*", persistent=false)
	public void execute() {
		String fileName;
		try {
			WatchKey key = watcher.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind() == OVERFLOW)
					continue;
				else
					fileName = ""+event.context();
				System.out.println(fileName);
					dao.callAll(fileName.replaceAll("\\s+",""));
			}
			if (!key.reset())
				return;
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
}