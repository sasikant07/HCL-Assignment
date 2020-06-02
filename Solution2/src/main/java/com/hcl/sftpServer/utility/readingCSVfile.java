package com.hcl.sftpServer.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hcl.sftpServer.model.csvModel;

public class readingCSVfile {
	
	//reading each csv file,
    //creating particular object for each csv file,
    //adding each object to the List,
	//returning list
	
	public static List<csvModel> readingCSVfileValues(List<String> localFiles) throws FileNotFoundException{
		List<csvModel> csvObjList=new ArrayList<csvModel>();
		
		for(String list:localFiles){
		Scanner sc=new Scanner(new File("destination_path"+list));
		
		//Set the delimiter used in file like "," or "|"
        sc.useDelimiter("|");
        
        
        while(sc.hasNext()){
        	 csvModel csvObj=new csvModel(sc.next(), sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt());
        	 csvObjList.add(csvObj);
        }
        sc.close();
		}
		return csvObjList;
	}
}
