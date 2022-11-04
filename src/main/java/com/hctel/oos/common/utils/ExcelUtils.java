package com.hctel.oos.common.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 最后一行行标，比行数小1，行数使用getPhysicalNumberOfRows()获取
 * sheet.getLastRowNum();
 * 获取列数，比最后一列列标大1，等价于getPhysicalNumberOfCells()，空的cell不计算
 * sheet.getRow(k).getLastCellNum();
 *
 * 链接：https://www.jianshu.com/p/252c2a295a50
 * 来源：简书
 */
public class ExcelUtils {
    private static FormulaEvaluator evaluator;
    public void readXls(String path) {
        try{
            // 读取的时候可以使用流，也可以直接使用文件名
            FileInputStream is =  new FileInputStream(path);
            Workbook xwb = new XSSFWorkbook(is);
            // 循环工作表sheet
            for(int numSheet = 0; numSheet < xwb.getNumberOfSheets(); numSheet++) {
                Sheet sheet = xwb.getSheetAt(numSheet);
                if(sheet == null) {
                    continue;
                }
                // 循环row，如果第一行是字段，则 numRow = 1
                for(int numRow = 0; numRow <= sheet.getLastRowNum(); numRow++) {
                    Row row = sheet.getRow(numRow);
                    if(row == null) {
                        continue;
                    }
                    // 循环cell
                    for(int numCell = 0; numCell < row.getLastCellNum(); numCell++) {
                        Cell cell = row.getCell(numCell);
                        if(cell == null) {
                            continue;
                        }
                        // 打印数据
                        System.out.println("xlsx表格中读取的数据" + getValue(cell));
                    }
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static String getValue(Cell cell) {
        String val = null;
        switch(cell.getCellType()) {
            case FORMULA:  //公式类型
                // 先计算表达式
                val = String.valueOf(evaluator.evaluate(cell).getNumberValue());
                break;
            case BOOLEAN:  //布尔类型
                val = String.valueOf(cell.getBooleanCellValue());
                break;
            case STRING:   // 字符串类型
                val = cell.getStringCellValue().trim();
                break;
            case NUMERIC:  // 数值类型
                // 日期格式
                if(DateUtil.isCellDateFormatted(cell)) {
                    val =   Date2Str(cell.getDateCellValue(), "yyyy-MM-dd HH:mm:ss");
                }else {
                    // 四舍五入
                    val = new DecimalFormat("#.####").format(cell.getNumericCellValue());
                }
                break;
            default: //其它类型
                break;
        }
        return val;
    }

    public static String Date2Str(Date date, String format){
        // Date -> LocalDateTime -> String
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(),zone);
        return df.format(localDateTime);
    }
}
