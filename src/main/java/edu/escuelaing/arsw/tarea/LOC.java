package edu.escuelaing.arsw.tarea;

import java.io.*;

/**
 * This program count lines of a file 
 * 
 * HOW TO USE FROM CONSOLE WINDOS:
 * OPTION 1 physical lines
 *  $ java LOC PHY [sourcefile]
 * OPTION 2 code lines
 *  $ java LOC LOC [sourcefile]
 * 
 */

public class LOC{
    private static String options[]= {"PHY","LOC"}; 
    /**
     * main function
     * @param args
     */
    public static void main(String[] args) {
        String choice= args[0];
        File file= new File(args[1]);
        if(choice.equals(options[0])){
            System.out.println("The lines counted was: " + phyLines(file));     
        }else if(choice.equals(options[1])){
            System.out.println("The lines counted was: " + locLines(file));
        }
        else{
            System.out.println("not valid option or file not found");
        }
     }

     /**
      * 
      * @param f the file or directory from where the lines are to be read
      * @return the number of the physical lines counted 
      */
     public static long phyLines(File f){
        long lines =0 ;   
        if (f.isDirectory()){
            for(File Entry: f.listFiles()){
                lines+= phyLines(Entry);
            }   
        }
        try{
            BufferedReader br= new BufferedReader(new FileReader (f));
            String line;
            while ((line =br.readLine()) != null){
                lines+=1;
            }
            br.close();
        }catch(IOException e){
            System.out.println("File not Found");
        }
        return lines;

    }
    /**
     * 
     * @param f the file or directory from where the lines are to be read
     * @return the number of the lines of code counted 
     */
     static long locLines(File f) {
        long lines =0 ;   
        if (f.isDirectory()){
            for(File Entry: f.listFiles()){
                lines+= phyLines(Entry);
            }   
        }
        try{
            BufferedReader br= new BufferedReader(new FileReader (f));
            String reader;
            while ((reader=br.readLine()) != null && reader.charAt(0)!='/' && reader.charAt(0)!='*'){
                lines+=1;
            }
            br.close();
        }catch(IOException e){
            System.out.println("File not Found");
        }
        return lines;
    }

    

}