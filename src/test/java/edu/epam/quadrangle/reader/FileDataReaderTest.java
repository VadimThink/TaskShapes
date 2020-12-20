package edu.epam.quadrangle.reader;

import edu.epam.quadrangle.exception.InputDataException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FileDataReaderTest {
    private static final String DATA_FILE_EXIST = "files/Data.txt";

    @Test
    public void testGetDataShouldGetFileWhenFileIsExist() throws InputDataException, IOException {
        FileDataReader dataAcquirer = new FileDataReader();
        List<String> expectedLines = readFileLines();
        List<String> actual = dataAcquirer.readData(DATA_FILE_EXIST);
        Assert.assertEquals(expectedLines, actual);
    }

    private List<String> readFileLines() throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader fileReader;
        fileReader = new BufferedReader(new FileReader(DATA_FILE_EXIST));
        String line = fileReader.readLine();
        while (line != null) {
            lines.add(line);
            line = fileReader.readLine();
        }
        return lines;
    }

}