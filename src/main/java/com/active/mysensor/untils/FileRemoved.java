package com.active.mysensor.untils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
public class FileRemoved {
 public static void main(String[] args) {
    File file=new File("/Users/rjin/Downloads/Xenon");
    File[] tempList = file.listFiles();
    
    for (File f : tempList) {
    if (f.isDirectory() || !f.getName().contains("html")) {
  continue;
  }
        StringBuilder result = new StringBuilder();
          try{
              BufferedReader br = new BufferedReader(new FileReader(f));
              String s = null;
              while((s = br.readLine())!=null){
                  result.append(System.lineSeparator()+s);
              }
              br.close();    
              
              String x=  result.toString().replace("<link rel=\"stylesheet\" href=\"http://fonts.useso.com/css?family=Arimo:400,700,400italic\">", "");
              FileOutputStream fs = new FileOutputStream(f);
              fs.write(x.getBytes());
                      fs.close();
              
              
          }catch(Exception e){
              e.printStackTrace();
          }
        
  }
  
    
 }
}
