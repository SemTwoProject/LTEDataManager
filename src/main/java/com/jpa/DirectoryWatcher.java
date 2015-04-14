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

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.apache.commons.io.FilenameUtils;

import com.dao.ExcelDAO;

@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@TransactionManagement(TransactionManagementType.BEAN)
public class DirectoryWatcher {

	private WatchService watcher;
	@EJB
	private ExcelDAO dao;
	@Resource
	private TimerService timerService;

	@PostConstruct
	@Lock(LockType.READ)
	public void atStartUp() {
		FileSystem fileSystem = FileSystems.getDefault();
		Path path = fileSystem.getPath("c:\\excel\\");
		try {
			watcher = fileSystem.newWatchService();
			path.register(watcher, ENTRY_CREATE, ENTRY_MODIFY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Schedule(minute = "*/1", hour = "*", persistent = false)
	public void execute() {
		String fileName;
		String extension;
		try {
			WatchKey key = watcher.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				fileName = "" + event.context();
				extension = FilenameUtils.getExtension(fileName.toString());
				if (event.kind() == OVERFLOW)
					continue;
				else if (extension.equals("xls")) {
					System.out.println("File " + fileName
							+ " importing.");
					dao.callAll(fileName.replaceAll("\\s+", ""));
				} else {
					System.out.println("File " + fileName
							+ " should be of type .xls");
				}
			}
			if (!key.reset())
				return;
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

	@Timeout
	public void onTimeout(Timer timer) {
		System.out.println("Upload Timed Out.");
	}

	@PreDestroy
	public void destroy() {
		try {
			watcher.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
