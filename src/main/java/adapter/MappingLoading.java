package adapter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * 加载反射的xml
 * 返回className
 */
public class MappingLoading {
    public static final String FILE_PATH = "src\\main\\java\\adapter\\mapping.xml";

    private InputStream loadFile() {
        File file = new File(FILE_PATH);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File is not exsit!");
        }
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
