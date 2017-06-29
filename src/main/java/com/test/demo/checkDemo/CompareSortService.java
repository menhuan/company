package com.test.demo.checkDemo;

import java.io.File;
import java.util.Comparator;

public class CompareSortService implements Comparator<File> {

	public int compare(File file1, File file2) {
		
		long fileTime1=file1.lastModified();
		long  fileTime2=file2.lastModified();

		if(fileTime1>fileTime2){
			return 1;
		}
		else  if(fileTime1==fileTime2){
			return 0;
		}
		else  
			return -1;
		
	}

}
