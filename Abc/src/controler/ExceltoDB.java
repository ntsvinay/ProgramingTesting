package controler;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Servlet implementation class Mapdb
 */
@WebServlet("/Mapdb")
public class ExceltoDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String fileName = "", name = "", shipName = "", dbName = "", filenamewithpath = "";
	String cont_prsn = "", comp_Name = "", address = "", email = "",  country = "", city = "",
			nearst_Airport = "", otherDetail = "";
	int cont_Number=0;
	String categoryforDB = "";
	String f_title = "", s_title = "";
	String tablenameforexcel = "";
	ResultSet rs = null;
	int number, i, srno, imo, mmsi;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String classname = "oracle.jdbc.driver.OracleDriver";
	String user = "system";
	String dbpsw = "nuevo";
	PreparedStatement pstm = null;
	Connection c = null;
	Workbook workbook = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExceltoDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @throws IOException      s
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		tablenameforexcel = (String) session.getAttribute("tablename");
		System.out.println(tablenameforexcel);
		fileName = request.getParameter("filename");
		filenamewithpath = "D:\\Project\\Map\\Excel\\" + fileName;
		System.out.println("filename" + fileName);
		if (!fileName.equals("")) {

			try {
				workbook = WorkbookFactory.create(new File(filenamewithpath));
			} catch (InvalidFormatException | IOException e) {
				// e.printStackTrace();
				System.out.println("from workbook catch");
			}
			for (number = 0; number <= workbook.getNumberOfSheets() - 1; number++) {
				Sheet sheet = workbook.getSheetAt(number);

				// category = workbook.getSheetName(number);
				// name = category;
				// System.out.println(category + "<------his is the sheet name of excel");
				Row row;
				row = sheet.getRow(0);
				shipName = row.getCell(1).getStringCellValue();
				System.out.println("here is the title----" + shipName);
				if (number == 0) {

					if (shipName.equals("ShipName")) {

						crctExlFile();

					}

					else {

						System.out.println("not ship name");
						request.setAttribute("myname", tablenameforexcel);
						System.out.println(tablenameforexcel);
						request.getRequestDispatcher("againexcelupload.jsp").forward(request, response);
						break;
					}
				} else {
					tabDetailStore();

				}
			}
			// ((PrintWriter) workbook).close();
			try {
				response.sendRedirect("shipLogin.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				doGet(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		// ---------------------------
		else {

			System.out.println("name of file from if file is empty---" + tablenameforexcel);
			request.setAttribute("myname", tablenameforexcel);
			System.out.println(tablenameforexcel);
			request.getRequestDispatcher("againexcelupload.jsp").forward(request, response);

		}
	}

	public void crctExlFile() {
		for (number = 0; number<=0 ; number++) {
			Sheet sheet = workbook.getSheetAt(number);

			categoryforDB = workbook.getSheetName(number);
			name = categoryforDB;
			System.out.println(categoryforDB + "<------his is the sheet name of excel");
			Row row;
			for (i = 1; i <= sheet.getLastRowNum(); i++) {

				row = sheet.getRow(i);

				try {
					shipName = row.getCell(1).getStringCellValue();
					System.out.println(shipName);
					imo = (int) row.getCell(2).getNumericCellValue();
					System.out.println(imo);
					mmsi = (int) row.getCell(3).getNumericCellValue();
					System.out.println(mmsi);
					srno = (int) row.getCell(0).getNumericCellValue();
					System.out.println(srno);
				} catch (IllegalStateException ie) {

					System.out.println("illegalstation--->" + ie);
				}

				System.out.println(categoryforDB + shipName + imo + mmsi);
				insertExceldetail();
				insertCurrentIndivisual();
			}

		}

	}

	public void tabDetailStore() {
		for (number = 1; number <= workbook.getNumberOfSheets() - 1; number++) {
			Sheet sheet = workbook.getSheetAt(number);

			categoryforDB = workbook.getSheetName(number);
			name = categoryforDB;
			System.out.println(categoryforDB + "<------his is the sheet name of excel");
			Row row;
			for (i = 1; i <= sheet.getLastRowNum(); i++) {

				row = sheet.getRow(i);
				
				cont_prsn = row.getCell(0).getStringCellValue();
				if(cont_prsn.equals("stop"))
				{
					break;
				}
				else
				try {
					cont_prsn = row.getCell(0).getStringCellValue();
					System.out.println(cont_prsn);
					comp_Name = row.getCell(1).getStringCellValue();
					System.out.println(comp_Name);
					address =  row.getCell(2).getStringCellValue();
					System.out.println(address);
					email =row.getCell(3).getStringCellValue();
					System.out.println(email);				
					cont_Number = (int) row.getCell(4).getNumericCellValue();
					//cont_Number =row.getCell(4).getStringCellValue();
					System.out.println(cont_Number);
					country = row.getCell(5).getStringCellValue();
					System.out.println(country);
					city = row.getCell(6).getStringCellValue();
					System.out.println(city);
					nearst_Airport=row.getCell(7).getStringCellValue();
					System.out.println(nearst_Airport);
					otherDetail=row.getCell(8).getStringCellValue();
					System.out.println(otherDetail);
				} catch (IllegalStateException ie) {

					System.out.println("illegalstation--->" + ie);
				}

				System.out.println(categoryforDB + shipName + imo + mmsi);
				insertTabdetail();
							}

		}

	}

	public void insertExceldetail() {
		try {

			Class.forName(classname);
			c = DriverManager.getConnection(url, user, dbpsw);
			c.setAutoCommit(false);
			String sql = "INSERT  INTO  Exceltable_" + tablenameforexcel + " VALUES('" + srno + "','" + categoryforDB
					+ "','" + shipName + "','" + imo + "'," + "'" + mmsi + "')";
			System.out.println(sql);
			pstm = (PreparedStatement) c.prepareStatement(sql);
			pstm.execute();
			c.commit();
			pstm.close();
			c.close();
		} catch (Exception e) {

			e.printStackTrace();

		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("catch block");
			e.printStackTrace();
		}

	}

	public void insertTabdetail() {
		try {

			Class.forName(classname);
			c = DriverManager.getConnection(url, user, dbpsw);
			c.setAutoCommit(false);
			String sql = "INSERT  INTO fullTabdetail_" + tablenameforexcel + " VALUES('" + categoryforDB + "','" + cont_prsn + "','" + comp_Name + "','" + address
					+ "'," + "'" + email + "','" + cont_Number + "','" + country + "','" + city + "'," + "'"
					+ nearst_Airport + "','" + otherDetail + "')";
			System.out.println(sql);
			pstm = (PreparedStatement) c.prepareStatement(sql);
			pstm.execute();
			c.commit();
			pstm.close();
			c.close();
		} catch (Exception e) {

			e.printStackTrace();

		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("catch block");
			e.printStackTrace();
		}

	}

	public void insertCurrentIndivisual() {
		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(url, user, dbpsw);
			c.setAutoCommit(false);
			PreparedStatement pstm = null;

			String sql = "INSERT  INTO fulldetail_" + tablenameforexcel + " VALUES('" + "" + "','" + "" + "','" + imo
					+ "'," + "'" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + ""
					+ "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','"
					+ "" + "')";
			System.out.println(sql);
			pstm = (PreparedStatement) c.prepareStatement(sql);
			pstm.execute();
			c.commit();
			pstm.close();
			c.close();
		} catch (Exception e) {
			System.out.println(e);

		}

	}

	/*
	 * public void deleteRecord() { String queryDelete =
	 * "DELETE FROM Exceltable"+tablenameforexcel + " WHERE NAME = 'NewUser'";
	 * System.out.println(queryDelete); try { Class.forName(classname); c =
	 * DriverManager.getConnection(url, user, dbpsw); Statement stmntdelete =
	 * c.createStatement(); rs = stmntdelete.executeQuery(queryDelete); } catch
	 * (ClassNotFoundException | SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } }
	 */
}
