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
import javax.ejb.Stateless;

import com.dao.ExcelDAO;


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
	
	@Schedule(hour = "*", minute = "*/1")
	public void execute() {
		try {
			WatchKey key = watcher.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind() == OVERFLOW)
					continue;
				else
					System.out.println(event.kind() +" "+ event.count());
					dao.callAll();
			}
			if (!key.reset())
				return;
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
}