package com.frank.util;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.PageSize;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.PdfPageSize;
import com.spire.pdf.actions.PdfGoToAction;
import com.spire.pdf.general.PdfDestination;
import com.spire.pdf.general.PdfDestinationMode;
import com.spire.pdf.graphics.*;
import com.spire.pdf.graphics.PdfTemplate;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * pdf操作类
 *
 * @author kst
 * @date 2019-07-13 18:28:12
 * // * @see https://www.cnblogs.com/qlqwjy/p/9326468.html
 */
public class PdfUtils {

    /**
     * pdf添加图片
     *
     * @param pdfFilePath 源pdf文件路径
     * @param imgFilePath 图片文件路径
     * @throws InterruptedException
     * @author kst, 20210908
     */
    public static void pdfAddImage(String pdfFilePath, String imgFilePath) throws InterruptedException {
        // 创建一个文档对象
        Document doc = new Document();
        try {
            // 定义输出位置并把文档对象装入输出对象中
            PdfWriter.getInstance(doc, new FileOutputStream(pdfFilePath));
            // 打开文档对象
            doc.open();
            // 设置中文字体
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
            // 加入文字“HelloWorld ------ 中国北京,我的2008 .”
            String str = "HelloWorld ------ 中国北京, 我的2008 .";
            Paragraph tt = new Paragraph(str, fontChinese);
            doc.add(tt);
            // 加入图片Deepinpl.jpg
            Image image = Image.getInstance(imgFilePath);
            Thread.sleep(2000);
            image.setAlignment(Image.ALIGN_CENTER);
            doc.add(image);
            // 关闭文档对象，释放资源
            doc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * PDF插入图片
     *
     * @param originalPdfFilePath 原PDF文件
     * @param composePdfFilePath  合成的PDF文件
     * @param imgFilePath         需合成的图片
     * @param xCoordinate         图片合成的x坐标
     * @param yCoordinate         图片合成的y坐标
     * @param scalePercent        图片缩放百分率
     * @throws IOException
     * @author kst 20210908
     */
    public static void pdfAddImg(String originalPdfFilePath, String composePdfFilePath, String imgFilePath,
                                 int xCoordinate, int yCoordinate, String scalePercent) throws IOException {
        try {
            PdfStamper stamper = new PdfStamper(new PdfReader(originalPdfFilePath),
                    new FileOutputStream(composePdfFilePath));
            PdfContentByte overContent = stamper.getOverContent(1);
            Image image = Image.getInstance(imgFilePath);
            image.scalePercent(Float.valueOf(scalePercent));
            image.setAbsolutePosition(xCoordinate, yCoordinate);
            overContent.addImage(image);
            overContent.stroke();
            stamper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断pdf文件是否受损
     *
     * @param pdfFilePath pdf文件路径
     * @return 文件受损情况：true-未受损，false-受损
     * @author kst, 20210908
     */
    public static boolean checkPdfFile(String pdfFilePath) {
        try {
            PdfReader reader = new PdfReader(pdfFilePath);
            com.itextpdf.text.Document document = new com.itextpdf.text.Document(reader.getPageSize(1));
            document.open();
            int n = reader.getNumberOfPages();
            document.close();
            reader.close();
            return n != 0;
        } catch (IOException e) {
            System.out.println("本地pdf文件受损");
            return false;
        }
    }

    /**
     * 获取pdf文件大小
     *
     * @param pdfFilePath pdf文件路径
     * @return pdf文件大小
     * @author kst 2019-09-06
     */
    public static String getFileSize(String pdfFilePath) {
        return Long.toString(new File(pdfFilePath).length());
    }

    /**
     * pdf添加文字
     *
     * @param srcPdfPath    源pdf文件路径
     * @param targetPdfPath 目标pdf文件路径
     * @param textContent   文本内容
     * @param fontPath      本地字体路径
     * @throws Exception
     * @author kst 2021-02-21
     * //     * @see https://blog.csdn.net/TTBJ008/article/details/83181394
     */
    public static void pdfAddWords(String srcPdfPath, String targetPdfPath, String textContent, String fontPath)
            throws Exception {
        PdfReader pdfReader = new PdfReader(srcPdfPath);
        // reader.getNumberOfPages();
        PdfStamper stamper = new PdfStamper(pdfReader, new FileOutputStream(targetPdfPath));
        PdfContentByte overContent = stamper.getOverContent(1);
        // 加载文本
        overContent.beginText();
        // 设置文本字体，引用本地字体文件
        overContent.setFontAndSize(BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 20.1f);
        // 设置文本坐标
        overContent.setTextMatrix(20, 200);
        // 设置文本内容
        overContent.showText(textContent);
        // 结束加载文本
        overContent.endText();
        stamper.close();
        pdfReader.close();
    }

    /**
     * pdf添加表单文字
     *
     * @param srcPdfPath    源pdf文件路径
     * @param targetPdfPath 目标pdf文件路径
     * @param map           map值
     * @param fontPath      本地字体路径
     * @throws Exception
     * @author kst 2021-03-02
     * //     * @see https://blog.csdn.net/no_can_no_bb_/article/details/105688154?utm_medium=distribute.pc_relevant_bbs_down.none-task--2~all~first_rank_v2~rank_v29-16.nonecase&depth_1-utm_source=distribute.pc_relevant_bbs_down.none-task--2~all~first_rank_v2~rank_v29-16.nonecase
     * https://blog.csdn.net/suolongdse/article/details/104854482
     * https://blog.csdn.net/my_dream2718/article/details/103528957
     * https://blog.csdn.net/qq_40150691/article/details/79249029
     * https://blog.csdn.net/m0_37708405/article/details/97285215?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control
     * https://blog.csdn.net/weixin_43288999/article/details/119185020
     */
    public static void pdfAddFormWords(String srcPdfPath, String targetPdfPath, Map<String, String> map,
                                       String fontPath) throws Exception {
        PdfReader pdfReader = new PdfReader(srcPdfPath);
        PdfStamper stamper = new PdfStamper(pdfReader, new FileOutputStream(targetPdfPath));
        AcroFields form = stamper.getAcroFields();
        // 设置中文字体
        form.addSubstitutionFont(BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // 签名框
            if (entry.getKey().contains("Signature")) {
                Image image = Image.getInstance(entry.getValue());
                Rectangle signRect = form.getFieldPositions(entry.getKey()).get(0).position;
                // 根据域的大小缩放图片
                image.scaleToFit(signRect.getWidth(), signRect.getHeight());
//				image.scalePercent(Float.valueOf(entry.getValue().split("\\|")[1]));
                // 添加图片
                image.setAbsolutePosition(signRect.getLeft(), signRect.getBottom());
                // 获取操作的页面
                PdfContentByte pdfContentByte = stamper
                        .getOverContent(form.getFieldPositions(entry.getKey()).get(0).page);
                pdfContentByte.addImage(image);
                continue;
            }

            // 文本框、复选框、单选框
            form.setField(entry.getKey(), entry.getValue(), true);
        }

        // true:不可编辑,false:可编辑
        stamper.setFormFlattening(true);
        stamper.close();
        pdfReader.close();
    }

    /**
     * 合并pdf(pdfbox)
     *
     * @param pdfPathArray  需合并pdf路径数组
     * @param mergerPdfPath 合并后pdf路径
     * @throws IOException
     * @author kst, 2021-04-07
     */
    @SuppressWarnings("deprecation")
    public static void mergerPdfByPdfBox(String[] pdfPathArray, String mergerPdfPath) throws IOException {
        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        pdfMerger.setDestinationFileName(mergerPdfPath);
        for (String pdfPath : pdfPathArray) {
            pdfMerger.addSource(new File(pdfPath));
        }
        pdfMerger.mergeDocuments();
    }

    /**
     * 合并pdf(itextpdf)
     *
     * @param pdfPathArray  需合并pdf路径数组
     * @param mergerPdfPath 合并后pdf路径
     * @throws IOException
     * @throws Exception
     * @author kst, 2021-04-10
     */
    public static void mergerPdfByItextPdf(String[] pdfPathArray, String mergerPdfPath) throws Exception {
        Document document = new Document();
//		document.setMargins(0, 0, 0, 0);
        PdfCopy pdfCopy = new PdfCopy(document, new FileOutputStream(mergerPdfPath));
        document.open();
        for (String pdfPath : pdfPathArray) {
            File file = new File(pdfPath);
            PdfReader reader = new PdfReader(file.getAbsolutePath());
            pdfCopy.addDocument(reader);
            pdfCopy.freeReader(reader);
            reader.close();
        }
        pdfCopy.close();
        document.close();
    }

    /**
     * pdf添加水印
     *
     * @param srcPdfPath  源pdf路径
     * @param destPdfPath 目标pdf路径
     * @param imagePath   水印图片路径
     * @param fontPath    本地字体路径
     * @throws Exception
     * @author kst 20210908
     */
    public static void pdfAddWatermark(String srcPdfPath, String destPdfPath, String imagePath, String fontPath)
            throws Exception {
        PdfReader reader = new PdfReader(srcPdfPath);
        PdfStamper stamper = new PdfStamper(reader,
                new BufferedOutputStream(new FileOutputStream(new File(destPdfPath))));
        int pages = reader.getNumberOfPages();
        PdfContentByte pdfContentByte = null;
//		BaseFont baseFont = BaseFont.createFont("STSong-Light",
//				"UniGB-UCS2-H", BaseFont.EMBEDDED);
        BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        for (int i = 0; i < pages; i++) {
            // 在内容上方加水印
            pdfContentByte = stamper.getOverContent(i + 1);
            // 在内容下方加水印
//			pdfContentByte = stamper.getUnderContent(i);

            pdfContentByte.beginText();

            // 第一行文字
            pdfContentByte.setColorFill(BaseColor.LIGHT_GRAY);
            pdfContentByte.setFontAndSize(baseFont, 20);
            pdfContentByte.showTextAligned(Element.ALIGN_CENTER, "公司内部文件，请注意保密！", 200, 100, 30);

            // 第2行文字
            pdfContentByte.setColorFill(BaseColor.LIGHT_GRAY);
            pdfContentByte.setFontAndSize(baseFont, 15.0f);
            pdfContentByte.showTextAligned(Element.ALIGN_CENTER, "0202  温州分行营业部  张三  02021", 300f, 20f, 2f);

            // 添加图片水印
            Image image = Image.getInstance(imagePath);
            image.setAlignment(Image.LEFT | Image.TEXTWRAP);
            image.setBorderWidth(10);
            image.setBorderColor(BaseColor.WHITE);
            // 大小
            image.scaleToFit(200, 200);
            // 旋转
            image.setRotationDegrees(-30);
            image.setAbsolutePosition(200, 180);
            pdfContentByte.addImage(image);

            pdfContentByte.endText();
        }
        stamper.close();
        reader.close();
    }

    /**
     * @Param source 源文件
     * @Param target 转换后文件
     * @Description 将PDF转为A4格式
     * @Date: 2023.02.23
     **/
    private static void convert(String source, String target) {
        try {
            PdfReader pdfReader = new PdfReader(source);
            Document doc = new Document();
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(target));
            doc.open();
            PdfContentByte cb = writer.getDirectContent();
            for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                PdfImportedPage page = writer.getImportedPage(pdfReader, i);
                float width = page.getWidth();
                float height = page.getHeight();
                if (height > width) {
                    //横向
                    doc.setPageSize(PageSize.A4);
                    doc.newPage();
                    //计算比例
                    float widthScale = getWidthScale(width);
                    float heightScale = getHeightScale(height);
                    //addTemplate方法中有6个float类型的参数，是通过二维图像仿射变换得到的
                    //cb.addTemplate(page, new AffineTransform(widthScale, 0, 0, heightScale,0,0));
                    //二维图像仿射变换:https://www.cnblogs.com/v2m_/archive/2013/05/09/3070187.html
                    cb.addTemplate(page, widthScale, 0, 0, heightScale, 0, 0);
                } else {
                    //纵向
                    doc.setPageSize(new com.itextpdf.text.Rectangle(PageSize.A4.getHeight(), PageSize.A4.getWidth()));
                    doc.newPage();
                    float widthScale = getWidthScale(height);
                    float heightScale = getHeightScale(width);
                    cb.addTemplate(page, widthScale, 0, 0, heightScale, 0, 0);
                }
            }
            doc.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static float getWidthScale(float width) {
        float scale = PageSize.A4.getWidth() / width;
        return scale;
    }

    private static float getHeightScale(float height) {
        float scale = PageSize.A4.getHeight() / height;
        return scale;
    }

    public static File pdfToA4(String source, String target) {
        Document document = new Document(PageSize.A4);
        File FileA4 = new File(target);
        try {
            PdfReader pdfReader = new PdfReader(new File(source).getPath());
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(target));
            document.open();
            PdfContentByte cb = pdfWriter.getDirectContent();
            // 循环PDF的每一页 pdfWriter.getImportedPage(pdfReader, index) idnex从1开始
            for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                // 新增一页，不然多页的PDF会重合到一页
                document.newPage();
                PdfImportedPage page = pdfWriter.getImportedPage(pdfReader, i);
                // 计算缩小比例 以最大缩小比例为主
                // pdfReader.getPageSize(index) index是从1开始不是0
                float w = PageSize.A4.getWidth() / pdfReader.getPageSize(1).getWidth();
                float h = PageSize.A4.getHeight() / pdfReader.getPageSize(1).getHeight();
                float Scale = w > h ? h : w;
                cb.addTemplate(page, Scale, 0, 0, Scale, 0, 0);
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 删除原来的文件
        return FileA4;
    }

    /**
     * 自动修改pdf大小为A4大小
     *
     * @param srcPdfPath 需要修改的pdf的路径
     * @param newPdfPath 生成的新的pdf的路径
     */
    public static void PdfTest(String srcPdfPath, String newPdfPath) {
        try {
            Document document = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(newPdfPath));
            PdfImportedPage page1 = pdfWriter.getImportedPage(new PdfReader(srcPdfPath), 1);
            if (Image.getInstance(page1).getScaledWidth() > Image.getInstance(page1).getScaledHeight()) {
                document.setPageSize(PageSize.A4.rotate());
            } else {
                document.setPageSize(PageSize.A4);
            }
            document.open();
            PdfReader pdfReader = new PdfReader(srcPdfPath);
            int n = pdfReader.getNumberOfPages();
            PdfImportedPage page;
            PdfImportedPage page2;
            for (int i = 1; i <= n; i++) {
                int m = 0;
                page = pdfWriter.getImportedPage(pdfReader, i);
                Image image = Image.getInstance(page);
                if (i != n) {
                    page2 = pdfWriter.getImportedPage(pdfReader, i + 1);
                } else {
                    page2 = pdfWriter.getImportedPage(pdfReader, i);
                }
                Image image2 = Image.getInstance(page2);
                float scaledWidth = image2.getScaledWidth();
                float scaledHeight = image2.getScaledHeight();
                System.out.println(i + "--原先图片大小是宽：" + scaledWidth + ",高是:" + scaledHeight);
                if (scaledWidth > scaledHeight) {
                    while (scaledWidth > 842 || scaledHeight > 595) {
                        image.scalePercent(100 - m);
                        m++;
                        scaledHeight = image.getScaledHeight();
                        scaledWidth = image.getScaledWidth();
                    }
                    document.setPageSize(PageSize.A4.rotate());
                    image.setAlignment(Image.ALIGN_CENTER);
                    document.add(image);
                    document.newPage();
                } else {
                    while (scaledHeight > 842 || scaledWidth > 595) {
                        image.scalePercent(100 - m);
                        m++;
                        scaledHeight = image.getScaledHeight();
                        scaledWidth = image.getScaledWidth();
                    }
                    // image.setAbsolutePosition(0,0);
                    document.setPageSize(PageSize.A4);
                    image.setAlignment(Image.ALIGN_CENTER);
                    document.add(image);
                    document.newPage();
                }
            }
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void convertPdf(String srcPdfPath, String newPdfPath) {
        //加载原 PDF 文件
        PdfDocument originPdf = new PdfDocument();
        originPdf.loadFromFile(srcPdfPath);

        //初始化一个新的 PdfDocument 实例
        PdfDocument newPdf = new PdfDocument();

        //初始化 PdfUnitConvertor 实例
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        //将自定义大小以英寸为单位转换为points
        float width = unitCvtr.convertUnits(6.5f, PdfGraphicsUnit.Inch, PdfGraphicsUnit.Point);
        float height = unitCvtr.convertUnits(8.5f, PdfGraphicsUnit.Inch, PdfGraphicsUnit.Point);

        //从自定义大小创建一个 Dimension2D 实例，然后它将用作新 PDF 的页面大小
        Dimension2D size = new Dimension();
        size.setSize(width, height);

        //循环遍历原PDF 中的页面
        for (int i = 0; i < originPdf.getPages().getCount(); i++) {
            //将自定义大小的页面添加到新的 PDF 文件
            PdfPageBase newPage = newPdf.getPages().add(size, new PdfMargins((0)));
            //创建一个 PdfTextLayout 实例
            PdfTextLayout layout = new PdfTextLayout();
            //将文本布局设置为一页（如果未设置内容将不会缩放以适应页面大小）
            layout.setLayout(PdfLayoutType.One_Page);
            //根据原 PDF 中的页面创建模板
            PdfTemplate template = originPdf.getPages().get(i).createTemplate();
            //在新 PDF 的页面上绘制模板
            template.draw(newPage, new Point2D.Float(0, 0), layout);
        }

        //保存结果文档
        newPdf.saveToFile(newPdfPath);
    }

    /**
     * java修改pdf文档页面的宽高
     * 参数 inPath 修改后的新的绝对路径
     * 参数 outPath pdf的路径
     */
    public static String amendpage(String outPath, String inPath) {
        //创建PdfDocument对象
        PdfDocument originalDoc = new PdfDocument();
        //加载PDF文件
        originalDoc.loadFromFile(outPath);

        //创建一个新的PdfDocument实例
        PdfDocument newDoc = new PdfDocument();

        //遍历所有PDF 页面
        Dimension2D dimension2D = new Dimension();
        for (int i = 0; i < originalDoc.getPages().getCount(); i++) {
            PdfPageBase page = originalDoc.getPages().get(i);

            PdfMargins margins = new PdfMargins(0, 0, 0, 0);
            //设置新文档的页面大小为A4
            PdfPageBase newPage = newDoc.getPages().add(PdfPageSize.A4, margins);
            //调整画布，设置内容也根据页面的大小进行缩放
//            double wScale = (PdfPageSize.A4.getWidth()) / PdfPageSize.A4.getWidth();
//            double hScale = (PdfPageSize.A4.getHeight()) / PdfPageSize.A4.getHeight();
            double wScale = PdfPageSize.A4.getHeight() / page.getSize().getWidth();
            double hScale = PdfPageSize.A4.getWidth() / page.getSize().getHeight();
            newPage.getCanvas().translateTransform(wScale, hScale);
            //复制原文档的内容到新文档
            newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float());
            //保存PDF
            newDoc.saveToFile(inPath);
        }
        newDoc.close();
        return outPath;
    }

    public static void main(String[] args) throws Exception {
        // 1.pdf添加文字
//		pdfAddWords("C:/kang/image/pdfbox/blank.pdf", "C:/kang/image/pdfbox/blank1.pdf", "温州银行无纸化系统",
//				"C:/Windows/Fonts/SIMHEI.TTF");

        // pdf添加表单文字
        // 2.1 pdf添加表单文字
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("X1", "古龙");
//		map.put("X2", "true");
//		map.put("X3", "true");
//		map.put("X4", "true");
//		map.put("X5", "mao");
//		map.put("X6", "demin");
//		map.put("X7", "19970908");
//		map.put("X8", "浙江省温州市龙湾区温州银行");
//		map.put("X9", "zhengjiangwenzhoushilongwanqu");
//		map.put("X10", "中国");
//		map.put("X11", "China");
//		map.put("X12", "123456789");
//		map.put("X13", "true");
//		map.put("X14", "true");
//		map.put("X15", "true");
//		map.put("X16", "true"); // 单选框
//		map.put("Signature", "C:/kang/image/svg/demo.png");
//		map.put("Signature1", "C:/kang/image/svg/demo.png");
//		map.put("X17", "2021.03.29");
//		map.put("X18", "true");
//		map.put("X19", "true");
//		map.put("X20", "true");
//		map.put("X21", "true");
//		pdfAddFormWords("C:/kang/image/pdfbox/mdm.pdf", "C:/kang/image/pdfbox/mdm_fb.pdf", map,
//				"C:/Windows/Fonts/simhei.ttf");

        // 2.2 pdf添加表单文字
        Map<String, String> map = new HashMap<String, String>();
        map.put("X1", "20230804GS00001");
        map.put("X2", "国家税务总局浙江省税务局第三税务分局");
        map.put("X3", "13300910000");
        map.put("X4", "来来来");
        map.put("X5", "77878798798");
        map.put("X6", "古龙");
        map.put("X7", "6217261571013778111");
        map.put("X8", "15088379926");
        map.put("X9", "浙江民泰商业银行股份有限公司杭州钱江新城支行");
        map.put("X10", "浙江民泰商业银行总行");
        map.put("X11", "313345400010");
        map.put("X12", "313331005163");
        pdfAddFormWords("C:/kang/image/pdfbox/taxpayment.pdf", "C:/kang/image/pdfbox/taxpayment_fb.pdf", map,
                "C:/Windows/Fonts/simhei.ttf");

        // 3.合并pdf(pdfbox)
//		mergerPdfByPdfBox(new String[] { "C:/kang/image/pdfbox/sample1.pdf", "C:/kang/image/pdfbox/sample2.pdf" },
//				"C:/kang/image/pdfbox/merged.pdf");

        // 4.合并pdf(itextpdf)
//		mergerPdfByItextPdf(new String[] { "C:/kang/image/pdfbox/sample1.pdf", "C:/kang/image/pdfbox/sample2.pdf" },
//				"C:/kang/image/pdfbox/merged.pdf");

        // 5.pdf添加水印
//		String srcPdfPath = "C:/kang/image/pdf.pdf";
//		String destPdfPath = "C:/kang/image/pdf_fb.pdf";
//		String imagePath = "C:/kang/image/1.jpg";
//		String fontPath = "C:/Windows/Fonts/SIMHEI.TTF";
//		pdfAddWatermark(srcPdfPath, destPdfPath, imagePath, fontPath);

//		String pdfFilePath = "C:/kang/image/pdf/pdf.pdf";
//		String pdfFilePath = "C:/kang/image/kst.pdf";
//		System.out.println(checkPdfFile(pdfFilePath));

//		String pdfFilePath = "";
//		String imgFilePath = "";
//		pdfAddImage(pdfFilePath, imgFilePath);

//        String source = "C:/kang/image/hd/3.pdf";
//        String target = "C:/kang/image/hd/3_hd.pdf";
//        convert(source, target);
//        pdfToA4(source, target);
//        PdfTest(source,target);
//        convertPdf(source, target);
//        amendpage(source, target);
//        System.out.println("111");
    }
}