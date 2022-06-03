package com.company.utils.File;

import com.company.utils.StringUtil;

import java.io.*;
import java.util.List;

public class FileUtil implements ReadableFile, WriteableFile {
    @Override
    public Object readeFile(String pathFile) {
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
    public <T> void writeFile(List<T> objectList, String pathFile) {
        if (StringUtil.isNullOrEmpty(pathFile)) {
            return;
        }
        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(new FileOutputStream(pathFile))) {
            objectOutputStream.writeObject(objectList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
