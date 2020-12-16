package edu.epam.quadrangle.data.reader;

import edu.epam.quadrangle.exception.InputDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataReader {
    private static final String INPUT_ERROR_MESSAGE = "Something wrong with file input.";
    private static final Logger LOGGER = LogManager.getLogger(FileDataReader.class);

    public List<String> readData(String fileName) throws InputDataException {
        LOGGER.info("Reading quadrangle data from the file");
        BufferedReader fileReader = null;
        List<String> booksLines = new ArrayList<>();
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            booksLines = fileReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("Exception: " + e.toString());
            throw new InputDataException(INPUT_ERROR_MESSAGE, e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        LOGGER.info("End of reading data");
        return booksLines;
    }
}
