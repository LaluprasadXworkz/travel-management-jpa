package com.xworkz.temple.boot;

import java.io.FileOutputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.xworkz.temple.entity.TempleEntity;
import com.xworkz.util.EmfUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TempleReadFromMysqlToExcel {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = EmfUtil.getManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<TempleEntity> query = entityManager.createQuery("SELECT t FROM TempleEntity t", TempleEntity.class);
            List<TempleEntity> resultList = query.getResultList();

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("TempleData");

            int rowNum = 1;
            for (TempleEntity temple : resultList) {
                Row row = sheet.createRow(rowNum++);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(temple.getId());

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(temple.getTempleName());

                Cell cell3 = row.createCell(2);
                cell3.setCellValue(temple.getLocation());

                Cell cell4 = row.createCell(3);
                cell4.setCellValue(temple.getEntryFee());

                Cell cell5 = row.createCell(4);
                cell5.setCellValue(temple.isVipEntry());

                Cell cell6 = row.createCell(5);
                cell6.setCellValue(temple.getInaugurationDate());

                Cell cell7 = row.createCell(6);
                cell7.setCellValue(temple.getMainGodName());

                Cell cell8 = row.createCell(7);
                cell8.setCellValue(temple.getDimension());
            }

            try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\lalup\\OneDrive\\Desktop\\templedataread.xlsx")) {
                workbook.write(outputStream);
            }

            System.out.println("Data exported successfully to Excel.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
