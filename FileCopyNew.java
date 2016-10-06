package org.Mars;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;

public class FileCopyNew {
	 BufferedReader reader;
	 static String sourceName;
	 static String desName;
	 static long len;
    public FileCopyNew(){
    	File source;
    	File destination;
    	boolean isOK=false;
    	try{
    		do{
    	       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    	       System.out.println("請輸入來源檔案(想要複製的檔案或資料夾)");
    	       sourceName=reader.readLine();
    	       source=new File(sourceName);
    	       len=source.length();
    	       if(!source.exists()){
    	    	  System.out.println("來源檔不在，請從新輸入檔名");
    	    	  isOK=true;
    	       }
    	       else{
    	    	   isOK=false;
    	    	   break;
    	       }
    	    }while(isOK);
    		reader=new BufferedReader(new InputStreamReader(System.in));
    		boolean check=true;
    		while(check){
    	            System.out.println("請輸入目標檔(要複製過去的資料夾)");
    	            desName=reader.readLine();
    	            String[] des=desName.split("/");
    	            for(String s:des) System.out.println(s);
    	            if(!des[0].equals("C:")&&!des[0].equals("D:")&&!des[0].equals("Q:")){
    	     	        System.out.println("你所選擇的硬碟槽不存在，請從新輸入");
    	            }
    	            else{
    	            	source=new File(sourceName);
    	                destination=new File(desName);
    	            	copy(source,destination);
    	            	check=false;
    	            	break;
    	            }
    		}//end while loop
    		//copy(source,destination);
    	}
    	catch(IOException ie){
    		ie.toString();
    	}
   
    }//close constructor
	public static void main(String[] args) {
	  new FileCopyNew();
	}//close method main()
    
	public void copy(File source,File destination){
//		source=new File(sourceName);
//		destination=new File(desName);
		if(source.isFile()){
			
		    try{
		    	//String[] sou =sourceName.split("/");
		    	
		    	File des_file=new File(destination,source.getName());
		    	System.out.println(des_file.getPath());
		    	System.out.println("開始執行複製");
		    	//調整
		    	
		    	if(!des_file.exists()){
		    		des_file.createNewFile();
		    	}
		    	//FileOutputStream不知為何會拋出例外，導致下面的複製程序完全沒有執行，明明確認過檔案是存在的
                OutputStream fout=new FileOutputStream(des_file);
                System.out.println("建立FileOutputStream");
                System.out.println("Before InputStream");
                FileInputStream fin=new FileInputStream(source);
		        System.out.println("建立FileInputStream");
		        byte[] b=new byte[(int) len];
				int c;
			    System.out.println("start");
				while((c=fin.read(b))!=-1){
					fout.write(b);
				}//end while loop
				fout.flush();
				fout.close();
				fin.close();
				System.out.println(destination+source.getAbsolutePath() +".... ok"  );
		    }
		    catch(FileNotFoundException fe){
		    	System.out.println("FileNotFound xx");
		    	fe.toString();
		    }
		    catch(IOException ie){
		    	System.out.println("IOException xxx");
		    	System.out.println(ie.toString());
		    }
		    catch(SecurityException se){
		    	System.out.println("SecurityException xxxx");
		    }
		}
		// 當 source is directory
		else{
			String[] sou=sourceName.split("/");
			destination=new File(desName+"/"+sou[sou.length-1]);
			if(!destination.exists()){
				destination.mkdirs();
			}
			for( File f:source.listFiles()){
				if(f.isDirectory()){
					//找下面一層
					if(!new File(destination,f.getName()).exists()){
						new File(destination,f.getName()).mkdirs();
						System.out.println(destination.getPath()+f.getName()+".... ok"  );  					
				    }
					for(File innerf: f.listFiles()){
						copy(innerf,new File(destination,f.getName()));
					}
				}
				else if (f.isFile()){                              //當 f is a file
					
					System.out.println(destination.getPath()+f.getName());
                    copy(f,destination);
                    System.out.println(destination.getPath()+f.getName()+"...OK");
				}
			}//end for loop
		}
	}//close method copy
}//close class
