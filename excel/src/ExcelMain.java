import java.io.IOException;

public class ExcelMain {
    public static void main(String[] args) {
        String path="C:\\Users\\pc25\\Desktop";
        String filename="test.xlsx";
        MakeExcel make=new MakeExcel();
        try{
            make.excel(path, filename);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("열려있는 파일이 있습니다.");
        }
    }
}