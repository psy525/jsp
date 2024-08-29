import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    public static void readExcel(String path, String fileName) throws IOException {
        FileInputStream file = new FileInputStream(path + fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        int sheetCount = workbook.getNumberOfSheets();
        System.out.println(sheetCount);
        for (int i = 0; i < sheetCount; i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            System.out.println(fileName + "의" + (i+1) + "번째 시트에서 읽어온 내용");

            int rows=sheet.getPhysicalNumberOfRows();

            for(int r=0; r<rows; r++){
                XSSFRow row = sheet.getRow(r);

                int cols=row.getPhysicalNumberOfCells();
                System.out.print("|  " + (r+1) + "  |");

                for(int c=0; c<cols; c++){
                    XSSFCell cell = row.getCell(c);
                    String value=GetExcelValue.getValue(cell);
                    System.out.print("             " + value + "            |");
                }
                System.out.println();
            }
        }
        workbook.close();
        file.close();
    }
}
