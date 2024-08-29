import org.apache.poi.xssf.usermodel.XSSFCell;

import java.text.NumberFormat;

public class GetExcelValue {
    public static String getValue(XSSFCell cell) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        String value = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    value = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    value = numberFormat.format(cell.getNumericCellValue()) + "";
                    break;
                case BLANK:
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;
                case ERROR:
                    value = String.valueOf(cell.getErrorCellValue());
                    break;
            }
        }
        return value;
    }
}
