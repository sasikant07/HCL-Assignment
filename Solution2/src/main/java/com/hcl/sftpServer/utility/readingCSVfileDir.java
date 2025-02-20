package com.hcl.sftpServer.utility;

import java.io.File;
import java.util.*;

public class readingCSVfileDir {

	
	public static List<String> listFilesForFolder(final File folder) {
		List<String> filenames = new LinkedList<String>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            if(fileEntry.getName().contains(".csv"))
	                filenames.add(fileEntry.getName());
	        }
	    }
	  System.out.println("Total No of Files = "+filenames.size());
	  
	  return filenames;
	}
	
}
