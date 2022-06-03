package com.company.utils.file;

import com.company.utils.DataUtil;
import com.company.utils.StringUtil;

import java.io.*;

public class FileUtil implements DataReable, DataWriteable {
    @Override
    public Object readDataFromFile(String pathFile) {
        if (StringUtil.isNullOrEmpty(pathFile)) {
            return null;
        }
        try (ObjectInputStream objectInputStream
                     = new ObjectInputStream(new FileInputStream(pathFile))) {
            return objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeDataToFile(Object[] objects, String pathFile) {
        if (StringUtil.isNullOrEmpty(pathFile) && DataUtil.isNullOrEmptyArray(objects)) {
            return;
        }
        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(new FileOutputStream(pathFile))) {
            objectOutputStream.writeObject(objects);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
