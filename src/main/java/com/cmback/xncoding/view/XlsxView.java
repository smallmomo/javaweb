package com.cmback.xncoding.view;

import com.cmback.xncoding.commons.DateUtil;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class XlsxView extends AbstractXlsxView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    public void buildExcelDocument(Map<String, Object> model,
                                   Workbook workbook,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {


        @SuppressWarnings("unchecked")
        List<String> orders = (List<String>) model.get("orders");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("订单");

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        // Font font = workbook.createFont();
        // font.setColor(IndexedColors.RED.getIndex());
        // style.setFont(font);

        // create header row
        Row header = sheet.createRow(0);
        Cell c0 = header.createCell(0);
        c0.setCellStyle(style);
        c0.setCellValue("渠道ID");

        Cell c1 = header.createCell(1);
        c1.setCellStyle(style);
        c1.setCellValue("订单ID");

        Cell c2 = header.createCell(2);
        c2.setCellStyle(style);
        c2.setCellValue("手机号");

        Cell c3 = header.createCell(3);
        c3.setCellStyle(style);
        c3.setCellValue("金额（分）");

        Cell c4 = header.createCell(4);
        c4.setCellStyle(style);
        c4.setCellValue("日期");

        // Create data cells
//        CellStyle styleData = workbook.createCellStyle();
//        styleData.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        styleData.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        styleData.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        styleData.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        int rowCount = 1;
        if (orders != null && orders.size() > 0) {
            for (String order : orders) {
                Row courseRow = sheet.createRow(rowCount++);
                courseRow.createCell(0).setCellValue(order);
                courseRow.createCell(1).setCellValue(order);
                courseRow.createCell(2).setCellValue(order);
                courseRow.createCell(3).setCellValue(order);
                courseRow.createCell(4).setCellValue(
                        DateUtil.getDateString(new Date(), DateUtil.DATE_TIME_FMT));
            }
        }

//        Row r = sheet.getRow(0);
//        for (int colNum = 0; colNum < r.getLastCellNum(); colNum++)
//            sheet.autoSizeColumn(colNum);
        sheet.setColumnWidth(0, 10 * 256);
        sheet.setColumnWidth(1, 20 * 256);
        sheet.setColumnWidth(2, 20 * 256);
        sheet.setColumnWidth(3, 12 * 256);
        sheet.setColumnWidth(4, 22 * 256);

        String filename = "测试.xlsx";//设置下载时客户端Excel的名称
        filename = URLEncoder.encode(filename,"UTF-8");
        // change the file name
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String agent = request.getHeader("USER-AGENT");
//        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
        if ((agent != null) && (agent.contains("Mozilla")))
            response.setHeader("Content-Disposition","attachment; filename*=UTF-8''"+filename);
        else
            response.setHeader("Content-Disposition","attachment; filename="+filename);
        OutputStream ouputStream = response.getOutputStream();
        workbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }
}
