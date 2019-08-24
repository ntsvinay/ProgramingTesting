package controler;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class Excel {

    public static final String SAMPLE_XLSX_FILE_PATH = "D:\\NA ECA COORDINATES.xlsx";
    static String category = "", storeName = "", phoneNumebr = "", weburl = "", email = "", cityName = "", address = "", state = "", other = "", latitude = "", longitude = "";
    static int zipCode = 0;
    static int number = 0, i;
    static int excelLineNumber = 0;
    static String name;
static double lat=0,lang=0;
static String url = "jdbc:oracle:thin:@localhost:1521:xe";
static String classname = "oracle.jdbc.driver.OracleDriver";
static String user = "system";
static String dbpsw = "nuevo";
    public static void main(String[] args) throws IOException, InvalidFormatException, Exception {

        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
        for (number = 0; number <= workbook.getNumberOfSheets() - 1; number++) {
            Sheet sheet = workbook.getSheetAt(number);

            String category = workbook.getSheetName(number);
            name = category;
            System.out.println(category + "<------his is the sheet name of excel");
            Row row;
            for (i = 1; i <= sheet.getLastRowNum(); i++) {

                excelLineNumber++;
                row = sheet.getRow(i);

                cityName = row.getCell(0).getStringCellValue();
                if (cityName.equals("stop")) {
                    break;
                } else {
                    System.out.println(cityName);
                    /*address = row.getCell(1).getStringCellValue();
                    System.out.println(address);
                    state = row.getCell(2).getStringCellValue();
                    System.out.println(state);
                    zipCode = (int) row.getCell(3).getNumericCellValue();
                    System.out.println(zipCode);
                    storeName = row.getCell(4).getStringCellValue();
                    System.out.println(storeName);
                    phoneNumebr = row.getCell(5).getStringCellValue();
                    System.out.println(phoneNumebr);
                    weburl = row.getCell(6).getStringCellValue();
                    System.out.println(weburl);
                    email = row.getCell(7).getStringCellValue();
                    System.out.println(email);
                    other = row.getCell(8).getStringCellValue();
                    System.out.println(other);*/
                	lat = (double) row.getCell(2).getNumericCellValue();
                	lang = (double) row.getCell(3).getNumericCellValue();
                	

                }
                dbStore(lat,lang);
            }

        }
        ((Connection) workbook).close();
    }

   /* public static void getLatLongPositions(String address) throws Exception {
        int responseCode = 0;
        String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
        URL url = new URL(api);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.connect();
        responseCode = httpConnection.getResponseCode();
        if (responseCode == 200) {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
            org.w3c.dom.Document document = builder.parse(httpConnection.getInputStream());
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("/GeocodeResponse/status");
            String status = (String) expr.evaluate(document, XPathConstants.STRING);
            if (status.equals("OK")) {
                expr = xpath.compile("//geometry/location/lat");
                latitude = (String) expr.evaluate(document, XPathConstants.STRING);
                expr = xpath.compile("//geometry/location/lng");
                longitude = (String) expr.evaluate(document, XPathConstants.STRING);
                //return new String[] {latitude, longitude};
                System.out.println(name + "---latitude----->" + latitude + "longitude---->" + longitude);
               // dbStore();
            } else {
                expr = xpath.compile("//geometry/location/lat");
                latitude = (String) expr.evaluate(document, XPathConstants.STRING);
                expr = xpath.compile("//geometry/location/lng");
                longitude = (String) expr.evaluate(document, XPathConstants.STRING);
                //return new String[] {latitude, longitude};
                System.out.println(name + "---latitude----->" + latitude + ",longitude---->" + longitude);
                //dbStore();
            }
        }

    }*/

    public static void dbStore(double a,double b) throws ClassNotFoundException, SQLException {
    
           	System.out.println("degree"+a+"--and--"+b);        	
        	double abc=a;
        	double cde=b;
            Class.forName(classname);
            Connection c = DriverManager.getConnection(url, user, dbpsw);
            c.setAutoCommit(false);
            PreparedStatement pstm = null;
           /* String sql = "INSERT INTO  CITYDATA VALUES('" + abc + "','" + cde + "','" + latitude + "'," + "'" + longitude + "','" + address
                    + "','" + state + "','" + zipCode + "','" + storeName + "','" + weburl + "','" + phoneNumebr + "','" + email + "','" + other + "')";*/
          String sql="INSERT INTO ECA_POSTION VALUES('abc','cde')";
            pstm = (PreparedStatement) c.prepareStatement(sql);
            pstm.execute();
            c.commit();
            pstm.close();
            c.close();
        
    }

}
