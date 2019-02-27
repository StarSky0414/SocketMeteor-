package adapter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.List;

/**
 * 加载反射的xml
 * 返回className
 */
public class MappingLoading {
//    public static final String FILE_PATH = "E:\\skstmeteor\\src\\main\\java\\adapter\\mapping.xml";
//    public static final String FILE_PATH = "skstmeteor\\out\\artifacts\\skst_meteor_jar";
//    public static final String FILE_PATH = null;

    private InputStream loadFile() {
        InputStream fileInputStream = this.getClass().getResourceAsStream("/adapter/mapping.xml");
//        FILE_PATH = FILE_PATH.replace("file:/", "");
//        System.out.println("==="+FILE_PATH);
//        File file = new File(FILE_PATH);
//        String canonicalPath = null;
//        try {
//            canonicalPath = file.getCanonicalPath();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        File[] files = file.listFiles();
//        for (File thisFileName : files){
//            System.out.println("thisFileName :"+thisFileName.getName());
//        }
//
//        System.out.println("String canonicalPath : +++++++ "+canonicalPath);

//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.err.println("File is not exsit!");
//        }
        return fileInputStream;
    }

    private List getRowList(String sign) {
        SAXReader saxReader = new SAXReader();
        List rowList = null;
        try {
            Document read = saxReader.read(loadFile());
            rowList = read.selectNodes("//package/" + sign.trim());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return rowList;
    }

    public String getMyClass(String sign) {
        System.out.println(sign);
        List rowList = getRowList(sign);
        Element object = (Element) rowList.get(0);

        System.out.println(object.getName());
        String aClass = object.attributeValue("class");
        System.out.println(aClass);
        return aClass;
    }

}
