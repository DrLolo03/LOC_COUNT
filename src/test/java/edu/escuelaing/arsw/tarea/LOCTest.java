package edu.escuelaing.arsw.tarea;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class LOCTest
    extends TestCase
{
    /**
     * Constructor LOCTest
     */
    public LOCTest(){}


    /**
     * It test the physicalCounter for a directory
     */
    public void testPHYRecursive(){
        File file = new File("./Resources/profundidad");
        assertTrue(LOC.phyLines(file)==12);
    }

    /**
     * It test the locCounter for a directory
     */
    public void testLOCRecursive(){
        File file = new File("./Resources/profundidad");
        assertTrue(LOC.locLines(file)==12);
    }

    /**
     * It test the physicalCounter for 1 file
     */
    public void testPhysicalCountFile(){
        File file = new File("./Resources/PruebaPHY.txt");
        assertTrue(LOC.phyLines(file)==8);
        
    }

    /**
     * It test the locCounter for 1 file
     */
    public void testLocCounterFile(){
        File file = new File("./Resources/PruebaLOC.txt");
        assertTrue(LOC.locLines(file)==2);
    }
}