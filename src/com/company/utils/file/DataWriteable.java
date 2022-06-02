package com.company.utils.file;

import java.io.FileNotFoundException;

public interface DataWriteable {
    void  writeDataToFile(Object[] objects, String pathFile) throws FileNotFoundException;
}
