public class DownloadExcel {
    public static void main(String[] args) {
        String path="C:\\Users\\pc25\\Desktop\\";
        String fileName="test.xlsx";
        try{
            ReadExcel.readExcel(path,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
