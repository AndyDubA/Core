import java.io.*;
import java.util.*;

public class Save {

    public static void main(String[] args)throws IOException {

        String file = "NewSave.csv";
        String[] header = {"Value1", "Value2", "Value3"};
        int[][] data = {{100, 200, 123}, {300, 400, 500}};

        AppData.setHeader(header);
        AppData.setData(data);
        AppData.save(file);
        read(file);

        ArrayList<String> list = getDataFromFile(file);
        AppData.setHeader(getHeaderArr(list));
        AppData.setData(getDataArr(list, getHeaderArr(list).length));
    }

    public static ArrayList<String> getDataFromFile(String file) throws IOException{
        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String str;
        while ((str = reader.readLine()) != null) {
            list.add(str);
        }
        return list;
    }

    public static String[] getDataStr(ArrayList<String> list){
        String[] data = new String[list.size() - 1];
        for (int i = 0; i < list.size() - 1; i++) {
            data[i] = list.get(i + 1);
        }
        return data;
    }

    public static String[] getHeaderArr(ArrayList<String> list){
        String header = list.get(0);
        String[] headerArr = header.split(";");
        return headerArr;
    }

    public static int[][] getDataArr(ArrayList<String> list, int size){
        String[] data = getDataStr(list);
        String[] dataStr;
        int[][] dataInt = new int[data.length][size];
        for (int i = 0; i < data.length; i++) {
            dataStr = data[i].split(";");
            for (int j = 0; j < dataStr.length; j++) {
                dataInt[i][j] = Integer.parseInt(dataStr[j]);
            }
        }
        return dataInt;
    }

    public static void read(String file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}