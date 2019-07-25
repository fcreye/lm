package org;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Test
{
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		
		HSSFRow row = sheet.createRow(0) ;
		row.setHeight((short) 500) ;
		sheet.setColumnWidth(0, 4000) ;
		
		HSSFCellStyle cellStyle = workbook.createCellStyle() ;
		cellStyle.setWrapText(true);
		cellStyle.setAlignment((short)2) ;
		cellStyle.setVerticalAlignment((short)1) ;
 
		
		HSSFCell cell = row.createCell(0) ;
		cell.setCellValue("姓名            密码") ;
		cell.setCellStyle(cellStyle) ;
 
		//画线(由左上到右下的斜线)
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		HSSFClientAnchor a = new HSSFClientAnchor(0, 0, 1023, 255, (short)0, 0, (short)0, 0);
		HSSFSimpleShape shape1 = patriarch.createSimpleShape(a);
		shape1.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE); 
		shape1.setLineStyle(HSSFSimpleShape.LINESTYLE_SOLID) ;
		
		OutputStream outputStream = new  FileOutputStream("C:\\test.xls") ;
		try
		{
			workbook.write(outputStream);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("generate  excel success ! ");
		
	}
	
}
