package com.dmm.test;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/18 11:48
 * @motto The more learn, the more found his ignorance.
 */

public class TableAndTitle {

    public static void main(String[] args) {
        test("20200318.pdf");
    }


    private static void test(String fileName)   {

        //fileOutputStream.
        Document document = new Document();
        try {

            OSS oss=new OSSClient("oss-cn-hangzhou.aliyuncs.com","","");

            //byteArrayOutputStream; E:\everyday\springboot_study
            //写出字节流
            ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
//            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//            //读取字节流
//            oss.putObject("aycunchu-test","20200318.pdf",byteArrayInputStream);

            //byteArrayOutputStream.writeTo(new FileOutputStream("file.pdf"));
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();


            PdfPTable table = new PdfPTable(1);
            table.setKeepTogether(true);
            table.setSplitLate(false);

            PdfPTable table1 = new PdfPTable(1);
            PdfPCell cell0 = new PdfPCell();
            Paragraph p = new Paragraph("table title sample");
            p.setAlignment(1);
            p.setSpacingBefore(15f);
            cell0.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            cell0.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//然并卵
            cell0.setPaddingTop(-2f);//把字垂直居中
            cell0.setPaddingBottom(8f);//把字垂直居中
            cell0.addElement(p);
            cell0.setBorder(0);
            table1.addCell(cell0);

            PdfPTable pTable = new PdfPTable(table1);
            document.add(pTable);

            PdfPTable table2 = new PdfPTable(2);
            float border = 1.5f;
            for (int a = 0; a < 20; a++) {
                PdfPCell cell = new PdfPCell();
                Paragraph pp;
                if (a == 0 || a == 1) {
                    pp = str2ParaByTwoFont("tableTitle" + (a + 1), 9f, BaseColor.BLACK, Font.BOLD); //小五 加粗
                    cell.setBorderWidthBottom(border);
                    cell.setBorderWidthTop(border);
                } else {
                    if (a == 18 || a == 19) {
                        cell.setBorderWidthTop(0);
                        cell.setBorderWidthBottom(border);
                    } else {
                        cell.setBorderWidthBottom(0);
                        cell.setBorderWidthTop(0);
                    }
                    pp = str2ParaByTwoFont("tableContent" + (a - 1), 9f, BaseColor.BLACK); //小五
                }
                //设置间隔的背景色
                if ((a + 1) % 2 == 0) {
                    if (((a + 1) / 2) % 2 == 1) {
                        cell.setBackgroundColor(new BaseColor(128, 128, 255));
                    } else {
                        cell.setBackgroundColor(new BaseColor(128, 255, 255));
                    }
                } else {
                    if (((a + 1) / 2) % 2 == 1) {
                        cell.setBackgroundColor(new BaseColor(128, 255, 255));
                    } else {
                        cell.setBackgroundColor(new BaseColor(128, 128, 255));
                    }
                }
                pp.setAlignment(1);
                cell.setBorderWidthLeft(0);
                cell.setBorderWidthRight(0);
                cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//然并卵
                cell.setPaddingTop(-2f);//把字垂直居中
                cell.setPaddingBottom(8f);//把字垂直居中
                cell.addElement(pp);
                table2.addCell(cell);
            }

            PdfPCell c1 = new PdfPCell();
            c1.setBorder(0);
            c1.addElement(table1);

            PdfPCell c2 = new PdfPCell();
            c2.setBorder(0);
            c2.addElement(table2);

            table.addCell(c1);
            table.addCell(c2);

            document.add(table);
            //必须等到文件关闭，即下面的文件流关闭
            document.close();

            byte[] bytes=byteArrayOutputStream.toByteArray();
            System.out.println(byteArrayOutputStream.toByteArray().length+"+++++++++++++++");

            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            //读取字节流
            oss.putObject("","20200318.pdf",byteArrayInputStream);


            System.out.println(byteArrayInputStream.read(bytes)+"-----99999999");
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            oss.shutdown();
        } catch (DocumentException d ) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 两种字体显示文字
     *
     * @param cont
     * @param size
     * @param color
     * @return
     */
    private static Paragraph str2ParaByTwoFont(String cont, float size, BaseColor color) {
        Paragraph res = new Paragraph();
        FontSelector selector = new FontSelector();
        //非汉字字体颜色
        Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, size);
        f1.setColor(color);
        //汉字字体颜色
        Font f2 = FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED, size);
        f2.setColor(color);

        selector.addFont(f1);
        selector.addFont(f2);
        Phrase ph = selector.process(cont);
        res.add(ph);
        return res;
    }

    /**
     * 两种字体显示文字
     *
     * @param cont
     * @param size
     * @param color
     * @param bold
     * @return
     */
    private static Paragraph str2ParaByTwoFont(String cont, float size, BaseColor color, int bold) {

        Paragraph res = new Paragraph();
        FontSelector selector = new FontSelector();
        //非汉字字体颜色
        Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, size);
        f1.setColor(color);
        f1.setStyle(bold);
        //汉字字体颜色
        Font f2 = FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED, size);
        f2.setColor(color);
        f2.setStyle(bold);

        selector.addFont(f1);
        selector.addFont(f2);
        Phrase ph = selector.process(cont);
        res.add(ph);
        return res;
    }
}

