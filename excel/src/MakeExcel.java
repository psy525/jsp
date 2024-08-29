
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class MakeExcel {
public void excel(String path, String fileName) throws IOException {
    Workbook workbook = new XSSFWorkbook();

    Sheet sheet= workbook.createSheet("취향 메모");

    Row row0 = sheet.createRow(0);
    Row row1 = sheet.createRow(1);
    Row row2 = sheet.createRow(2);
    Row row3 = sheet.createRow(3);

    sheet.setColumnWidth(0,(short)+4096 );
    sheet.setColumnWidth(1,(short)+4096 );
    sheet.setColumnWidth(2,(short)+4096 );


    row0.createCell(0).setCellValue("이름");
    row0.createCell(1).setCellValue("만화");
    row0.createCell(2).setCellValue("게임");

    row1.createCell(0).setCellValue("박선영");
    row1.createCell(1).setCellValue("스폰지밥");
    row1.createCell(2).setCellValue("발로란트");

    row2.createCell(0).setCellValue("다진다진");
    row2.createCell(1).setCellValue("하이큐");
    row2.createCell(2).setCellValue("알투비트");


    row3.createCell(0).setCellValue("영선영선");
    row3.createCell(1).setCellValue("하이큐");
    row3.createCell(2).setCellValue("테트리스");


    FileOutputStream fos=new FileOutputStream(path+"\\"+fileName);
    workbook.write(fos);
    fos.close();
    workbook.close();
}
}