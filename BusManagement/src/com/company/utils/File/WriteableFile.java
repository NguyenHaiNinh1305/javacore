package com.company.utils.File;

import java.util.List;

public interface WriteableFile {

    <T> void writeFile(List<T> objectList, String pathFile);
}
