package com.company.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader3 {
	

	public static String filename = "C:\\Users\\Afsar\\Downloads\\Selenium\\TestData.xlsx";
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;

	public ExcelReader3(String path) {

		this.path=path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	// returns the row count in a sheet
	public int getRowCount(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else{
			sheet = workbook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;
		}

	}

	// returns the data from a cell
	public String getCellData(String sheetName,String colName,int rowNum){
		try{
			if(rowNum <=0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num=-1;
			if(index==-1)
				return "";

			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;
			}
			if(col_Num==-1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(col_Num);

			if(cell==null)
				return "";
			//System.out.println(cell.getCellType());
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){

				String cellText  = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal =Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText =
							(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cal.get(Calendar.MONTH)+1 + "/" + 
							cellText;

					//System.out.println(cellText);

				}

				return cellText;
			}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
				return ""; 
			else 
				return String.valueOf(cell.getBooleanCellValue());

		}
		catch(Exception e){

			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}

	// returns the data from a cell
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			if(rowNum <=0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if(index==-1)
				return "";


			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(colNum);
			if(cell==null)
				return "";

			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){

				String cellText  = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal =Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText =
							(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH)+1 + "/" +
							cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cellText;

					// System.out.println(cellText);

				}

				return cellText;
			}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
				return "";
			else 
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){

			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}
	
	
	public  Hashtable<String, String>  getData(String SheetName,String testName){
		
		int startRowNum=0;
		
		//find the row number for test start
		
		for(int rNum=1;rNum<getRowCount(SheetName);rNum++){
			
			if(getCellData(SheetName,0,rNum).contentEquals(testName)){
				startRowNum=rNum;
				break;
				
			}
		}
		
		System.out.println("Test  "+testName+"  starts from row num : "+startRowNum);
		int colStartRowNum=startRowNum+1;
		
		int totalcol=0;
		while(!getCellData(SheetName,totalcol,colStartRowNum).equals("")){
			
			totalcol++;
		}
		
		System.out.println("Total cols in the test "+testName +" are "+totalcol);
		
		// Rows
		
		int dataStartRowNum=startRowNum+2;
		int totalRows=0;
		while(!getCellData(SheetName, 0, dataStartRowNum+totalRows).equals("")){
			
			totalRows++;
		}
		
		System.out.println("Total Rows  in the test "+testName +" are "+totalRows);
		
		System.out.println("###############################################################################");
		
		// extract data
		
		Hashtable<String,String>table=null;
		
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+totalRows);rNum++){
			
			table=new Hashtable<String, String>();
			
			for(int cNum=0;cNum<totalcol;cNum++){
				table.put(getCellData(SheetName, cNum, colStartRowNum), getCellData(SheetName, cNum, rNum));//need to check
				
				//System.out.println("values are "+getCellData(SheetName, cNum, rNum));
				
			}
			
		}
		return table;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		ExcelReader3 reader=new ExcelReader3("C:\\Users\\Afsar\\Downloads\\Selenium\\TestData.xlsx");
		
		System.out.println("Data form excel is  :  "+reader.getCellData("Sheet1", 2, 2));
		
		//reader.getData("Sheet1", "TestCase2");
		Hashtable<String, String> data=reader.getData("Sheet1", "TestCase2");
		System.out.println(" data returned as "+data.get("para2"));
		
	}
	
	  

}
