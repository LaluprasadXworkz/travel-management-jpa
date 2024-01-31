package com.xworkz.temple.boot;

import com.xworkz.temple.entity.TempleEntity;
import com.xworkz.temple.repository.TempleRepository;
import com.xworkz.temple.repository.impl.TempleRepositoryImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class TempleReadFromExcel {
    public static void main(String[] args) {
        List<TempleEntity> list = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\lalup\\OneDrive\\Desktop\\temple_data.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            TempleRepository templeRepository=new TempleRepositoryImpl();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (row.getRowNum() == 0) {
                    continue;
                }


                Iterator<Cell> cellIterator = row.cellIterator();
                TempleEntity temple = new TempleEntity();

                while (cellIterator.hasNext()) {
//                    TempleEntity temple = new TempleEntity();
                    Cell cell = cellIterator.next();
                    int cellIndex = cell.getColumnIndex();

                    switch (cellIndex) {
                        case 1:
                            temple.setTempleName(cell.getStringCellValue());
                            break;
                        case 2:
                            temple.setLocation(cell.getStringCellValue());
                            break;
                        case 3:
                            temple.setEntryFee((int) cell.getNumericCellValue());
                            break;
                        case 4:
                                String booleanString = cell.getStringCellValue();
                                boolean booleanValue = Boolean.parseBoolean(booleanString);
                                temple.setVipEntry(booleanValue);
                            break;
                        case 5:
                            temple.setInaugurationDate(cell.getStringCellValue());
                            break;
                        case 6:
                            temple.setMainGodName(cell.getStringCellValue());
                            break;
                        case 7:
                            temple.setDimension(cell.getStringCellValue());
                            break;
                    }
                }
                list.add(temple);
            }
            templeRepository.saveAll(list);
            System.out.println("Data inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (TempleEntity temple : list) {
            System.out.println(temple);
        }
    }
}


