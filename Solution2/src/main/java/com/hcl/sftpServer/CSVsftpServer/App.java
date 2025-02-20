package com.hcl.sftpServer.CSVsftpServer;

import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.hcl.sftpServer.model.csvModel;
import com.hcl.sftpServer.utility.csvObjToDatabase;
import com.hcl.sftpServer.utility.readingCSVfile;
import com.hcl.sftpServer.utility.readingCSVfileDir;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class App {

    public App() {
        super();
    }
 
    public static void main(String[] args) {
        String SFTP_HOST = "00.00.00.00";
        int SFTP_PORTNUMBER = 88;
        String SFTP_USERNAME = "username";
        String SFTP_PASSWORD = "password";
        String SFTP_WORKINGDIRECTORY = "/export/home/kodehelp/";
 
        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
 
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTP_USERNAME, SFTP_HOST, SFTP_PORTNUMBER);
            session.setPassword(SFTP_PASSWORD);
            
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            
            session.setConfig(config);
            
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTP_WORKINGDIRECTORY);
            
            //Reading multiple file from the server, downloading to the local host
            Vector<ChannelSftp.LsEntry> list = channelSftp.ls("*.cvs");
            for(ChannelSftp.LsEntry entry : list) {
                channelSftp.get(entry.getFilename(), "destination_Path" + entry.getFilename());
            }
            
            //Reading files from the local destination
            final File folder = new File("destination_path");
            List<String> localFiles=readingCSVfileDir.listFilesForFolder(folder);
            
            //csvModel object for each downloaded files and each single entry in the file.
            List<csvModel> csvObjList=readingCSVfile.readingCSVfileValues(localFiles);
            
            //write each object to the database
            int RESULT[] = csvObjToDatabase.csvObjToMysqlDB(csvObjList);
            
            if(RESULT.length>0)
            System.out.println("Total Number of Records inserted = " +RESULT.length);
            else
            	System.out.println("Record Not Inserted");
            
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
    }
 
}
