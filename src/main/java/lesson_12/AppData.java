package lesson_12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void save(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(String.join(";", header) + "\n");

            for (int[] row : data) {
                StringBuilder line = new StringBuilder();
                for (int value : row) {
                    line.append(value).append(";");
                }
                writer.write(line.substring(0, line.length() - 1) + "\n");
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String headerLine = reader.readLine();
            header = headerLine.split(";");

            List<int[]> dataList = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] row = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Integer.parseInt(values[i]);
                }
                dataList.add(row);
            }

            data = new int[dataList.size()][];
            for (int i = 0; i < dataList.size(); i++) {
                data[i] = dataList.get(i);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.setHeader(new String[]{"Test 1", "Test 2", "Test 3", "Test 4"});
        appData.setData(new int[][]{
                {2, 2, 3},
                {4, 5, 6}
        });

        String fileName = "test.csv";
        appData.save(fileName);

        AppData loadedData = new AppData();
        loadedData.load(fileName);

        for (String header : loadedData.getHeader()) {
            System.out.print(header + " ");
        }

        System.out.println();
        for (int[] row : loadedData.getData()) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
