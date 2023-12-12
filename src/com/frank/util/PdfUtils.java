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
 * pdf������
 *
 * @author kst
 * @date 2019-07-13 18:28:12
 * // * @see https://www.cnblogs.com/qlqwjy/p/9326468.html
 */
public class PdfUtils {

    /**
     * pdf���ͼƬ
     *
     * @param pdfFilePath Դpdf�ļ�·��
     * @param imgFilePath ͼƬ�ļ�·��
     * @throws InterruptedException
     * @author kst, 20210908
     */
    public static void pdfAddImage(String pdfFilePath, String imgFilePath) throws InterruptedException {
        // ����һ���ĵ�����
        Document doc = new Document();
        try {
            // �������λ�ò����ĵ�����װ�����������
            PdfWriter.getInstance(doc, new FileOutputStream(pdfFilePath));
            // ���ĵ�����
            doc.open();
            // ������������
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
            // �������֡�HelloWorld ------ �й�����,�ҵ�2008 .��
            String str = "HelloWorld ------ �й�����, �ҵ�2008 .";
            Paragraph tt = new Paragraph(str, fontChinese);
            doc.add(tt);
            // ����ͼƬDeepinpl.jpg
            Image image = Image.getInstance(imgFilePath);
            Thread.sleep(2000);
            image.setAlignment(Image.ALIGN_CENTER);
            doc.add(image);
            // �ر��ĵ������ͷ���Դ
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
     * PDF����ͼƬ
     *
     * @param originalPdfFilePath ԭPDF�ļ�
     * @param composePdfFilePath  �ϳɵ�PDF�ļ�
     * @param imgFilePath         ��ϳɵ�ͼƬ
     * @param xCoordinate         ͼƬ�ϳɵ�x����
     * @param yCoordinate         ͼƬ�ϳɵ�y����
     * @param scalePercent        ͼƬ���Űٷ���
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
     * �ж�pdf�ļ��Ƿ�����
     *
     * @param pdfFilePath pdf�ļ�·��
     * @return �ļ����������true-δ����false-����
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
            System.out.println("����pdf�ļ�����");
            return false;
        }
    }

    /**
     * ��ȡpdf�ļ���С
     *
     * @param pdfFilePath pdf�ļ�·��
     * @return pdf�ļ���С
     * @author kst 2019-09-06
     */
    public static String getFileSize(String pdfFilePath) {
        return Long.toString(new File(pdfFilePath).length());
    }

    /**
     * pdf�������
     *
     * @param srcPdfPath    Դpdf�ļ�·��
     * @param targetPdfPath Ŀ��pdf�ļ�·��
     * @param textContent   �ı�����
     * @param fontPath      ��������·��
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
        // �����ı�
        overContent.beginText();
        // �����ı����壬���ñ��������ļ�
        overContent.setFontAndSize(BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 20.1f);
        // �����ı�����
        overContent.setTextMatrix(20, 200);
        // �����ı�����
        overContent.showText(textContent);
        // ���������ı�
        overContent.endText();
        stamper.close();
        pdfReader.close();
    }

    /**
     * pdf��ӱ�����
     *
     * @param srcPdfPath    Դpdf�ļ�·��
     * @param targetPdfPath Ŀ��pdf�ļ�·��
     * @param map           mapֵ
     * @param fontPath      ��������·��
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
        // ������������
        form.addSubstitutionFont(BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // ǩ����
            if (entry.getKey().contains("Signature")) {
                Image image = Image.getInstance(entry.getValue());
                Rectangle signRect = form.getFieldPositions(entry.getKey()).get(0).position;
                // ������Ĵ�С����ͼƬ
                image.scaleToFit(signRect.getWidth(), signRect.getHeight());
//				image.scalePercent(Float.valueOf(entry.getValue().split("\\|")[1]));
                // ���ͼƬ
                image.setAbsolutePosition(signRect.getLeft(), signRect.getBottom());
                // ��ȡ������ҳ��
                PdfContentByte pdfContentByte = stamper
                        .getOverContent(form.getFieldPositions(entry.getKey()).get(0).page);
                pdfContentByte.addImage(image);
                continue;
            }

            // �ı��򡢸�ѡ�򡢵�ѡ��
            form.setField(entry.getKey(), entry.getValue(), true);
        }

        // true:���ɱ༭,false:�ɱ༭
        stamper.setFormFlattening(true);
        stamper.close();
        pdfReader.close();
    }

    /**
     * �ϲ�pdf(pdfbox)
     *
     * @param pdfPathArray  ��ϲ�pdf·������
     * @param mergerPdfPath �ϲ���pdf·��
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
     * �ϲ�pdf(itextpdf)
     *
     * @param pdfPathArray  ��ϲ�pdf·������
     * @param mergerPdfPath �ϲ���pdf·��
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
     * pdf���ˮӡ
     *
     * @param srcPdfPath  Դpdf·��
     * @param destPdfPath Ŀ��pdf·��
     * @param imagePath   ˮӡͼƬ·��
     * @param fontPath    ��������·��
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
            // �������Ϸ���ˮӡ
            pdfContentByte = stamper.getOverContent(i + 1);
            // �������·���ˮӡ
//			pdfContentByte = stamper.getUnderContent(i);

            pdfContentByte.beginText();

            // ��һ������
            pdfContentByte.setColorFill(BaseColor.LIGHT_GRAY);
            pdfContentByte.setFontAndSize(baseFont, 20);
            pdfContentByte.showTextAligned(Element.ALIGN_CENTER, "��˾�ڲ��ļ�����ע�Ᵽ�ܣ�", 200, 100, 30);

            // ��2������
            pdfContentByte.setColorFill(BaseColor.LIGHT_GRAY);
            pdfContentByte.setFontAndSize(baseFont, 15.0f);
            pdfContentByte.showTextAligned(Element.ALIGN_CENTER, "0202  ���ݷ���Ӫҵ��  ����  02021", 300f, 20f, 2f);

            // ���ͼƬˮӡ
            Image image = Image.getInstance(imagePath);
            image.setAlignment(Image.LEFT | Image.TEXTWRAP);
            image.setBorderWidth(10);
            image.setBorderColor(BaseColor.WHITE);
            // ��С
            image.scaleToFit(200, 200);
            // ��ת
            image.setRotationDegrees(-30);
            image.setAbsolutePosition(200, 180);
            pdfContentByte.addImage(image);

            pdfContentByte.endText();
        }
        stamper.close();
        reader.close();
    }

    /**
     * @Param source Դ�ļ�
     * @Param target ת�����ļ�
     * @Description ��PDFתΪA4��ʽ
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
                    //����
                    doc.setPageSize(PageSize.A4);
                    doc.newPage();
                    //�������
                    float widthScale = getWidthScale(width);
                    float heightScale = getHeightScale(height);
                    //addTemplate��������6��float���͵Ĳ�������ͨ����άͼ�����任�õ���
                    //cb.addTemplate(page, new AffineTransform(widthScale, 0, 0, heightScale,0,0));
                    //��άͼ�����任:https://www.cnblogs.com/v2m_/archive/2013/05/09/3070187.html
                    cb.addTemplate(page, widthScale, 0, 0, heightScale, 0, 0);
                } else {
                    //����
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
            // ѭ��PDF��ÿһҳ pdfWriter.getImportedPage(pdfReader, index) idnex��1��ʼ
            for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                // ����һҳ����Ȼ��ҳ��PDF���غϵ�һҳ
                document.newPage();
                PdfImportedPage page = pdfWriter.getImportedPage(pdfReader, i);
                // ������С���� �������С����Ϊ��
                // pdfReader.getPageSize(index) index�Ǵ�1��ʼ����0
                float w = PageSize.A4.getWidth() / pdfReader.getPageSize(1).getWidth();
                float h = PageSize.A4.getHeight() / pdfReader.getPageSize(1).getHeight();
                float Scale = w > h ? h : w;
                cb.addTemplate(page, Scale, 0, 0, Scale, 0, 0);
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ɾ��ԭ�����ļ�
        return FileA4;
    }

    /**
     * �Զ��޸�pdf��СΪA4��С
     *
     * @param srcPdfPath ��Ҫ�޸ĵ�pdf��·��
     * @param newPdfPath ���ɵ��µ�pdf��·��
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
                System.out.println(i + "--ԭ��ͼƬ��С�ǿ�" + scaledWidth + ",����:" + scaledHeight);
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
        //����ԭ PDF �ļ�
        PdfDocument originPdf = new PdfDocument();
        originPdf.loadFromFile(srcPdfPath);

        //��ʼ��һ���µ� PdfDocument ʵ��
        PdfDocument newPdf = new PdfDocument();

        //��ʼ�� PdfUnitConvertor ʵ��
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        //���Զ����С��Ӣ��Ϊ��λת��Ϊpoints
        float width = unitCvtr.convertUnits(6.5f, PdfGraphicsUnit.Inch, PdfGraphicsUnit.Point);
        float height = unitCvtr.convertUnits(8.5f, PdfGraphicsUnit.Inch, PdfGraphicsUnit.Point);

        //���Զ����С����һ�� Dimension2D ʵ����Ȼ������������ PDF ��ҳ���С
        Dimension2D size = new Dimension();
        size.setSize(width, height);

        //ѭ������ԭPDF �е�ҳ��
        for (int i = 0; i < originPdf.getPages().getCount(); i++) {
            //���Զ����С��ҳ����ӵ��µ� PDF �ļ�
            PdfPageBase newPage = newPdf.getPages().add(size, new PdfMargins((0)));
            //����һ�� PdfTextLayout ʵ��
            PdfTextLayout layout = new PdfTextLayout();
            //���ı���������Ϊһҳ�����δ�������ݽ�������������Ӧҳ���С��
            layout.setLayout(PdfLayoutType.One_Page);
            //����ԭ PDF �е�ҳ�洴��ģ��
            PdfTemplate template = originPdf.getPages().get(i).createTemplate();
            //���� PDF ��ҳ���ϻ���ģ��
            template.draw(newPage, new Point2D.Float(0, 0), layout);
        }

        //�������ĵ�
        newPdf.saveToFile(newPdfPath);
    }

    /**
     * java�޸�pdf�ĵ�ҳ��Ŀ��
     * ���� inPath �޸ĺ���µľ���·��
     * ���� outPath pdf��·��
     */
    public static String amendpage(String outPath, String inPath) {
        //����PdfDocument����
        PdfDocument originalDoc = new PdfDocument();
        //����PDF�ļ�
        originalDoc.loadFromFile(outPath);

        //����һ���µ�PdfDocumentʵ��
        PdfDocument newDoc = new PdfDocument();

        //��������PDF ҳ��
        Dimension2D dimension2D = new Dimension();
        for (int i = 0; i < originalDoc.getPages().getCount(); i++) {
            PdfPageBase page = originalDoc.getPages().get(i);

            PdfMargins margins = new PdfMargins(0, 0, 0, 0);
            //�������ĵ���ҳ���СΪA4
            PdfPageBase newPage = newDoc.getPages().add(PdfPageSize.A4, margins);
            //������������������Ҳ����ҳ��Ĵ�С��������
//            double wScale = (PdfPageSize.A4.getWidth()) / PdfPageSize.A4.getWidth();
//            double hScale = (PdfPageSize.A4.getHeight()) / PdfPageSize.A4.getHeight();
            double wScale = PdfPageSize.A4.getHeight() / page.getSize().getWidth();
            double hScale = PdfPageSize.A4.getWidth() / page.getSize().getHeight();
            newPage.getCanvas().translateTransform(wScale, hScale);
            //����ԭ�ĵ������ݵ����ĵ�
            newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float());
            //����PDF
            newDoc.saveToFile(inPath);
        }
        newDoc.close();
        return outPath;
    }

    public static void main(String[] args) throws Exception {
        // 1.pdf�������
//		pdfAddWords("C:/kang/image/pdfbox/blank.pdf", "C:/kang/image/pdfbox/blank1.pdf", "����������ֽ��ϵͳ",
//				"C:/Windows/Fonts/SIMHEI.TTF");

        // pdf��ӱ�����
        // 2.1 pdf��ӱ�����
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("X1", "����");
//		map.put("X2", "true");
//		map.put("X3", "true");
//		map.put("X4", "true");
//		map.put("X5", "mao");
//		map.put("X6", "demin");
//		map.put("X7", "19970908");
//		map.put("X8", "�㽭ʡ��������������������");
//		map.put("X9", "zhengjiangwenzhoushilongwanqu");
//		map.put("X10", "�й�");
//		map.put("X11", "China");
//		map.put("X12", "123456789");
//		map.put("X13", "true");
//		map.put("X14", "true");
//		map.put("X15", "true");
//		map.put("X16", "true"); // ��ѡ��
//		map.put("Signature", "C:/kang/image/svg/demo.png");
//		map.put("Signature1", "C:/kang/image/svg/demo.png");
//		map.put("X17", "2021.03.29");
//		map.put("X18", "true");
//		map.put("X19", "true");
//		map.put("X20", "true");
//		map.put("X21", "true");
//		pdfAddFormWords("C:/kang/image/pdfbox/mdm.pdf", "C:/kang/image/pdfbox/mdm_fb.pdf", map,
//				"C:/Windows/Fonts/simhei.ttf");

        // 2.2 pdf��ӱ�����
        Map<String, String> map = new HashMap<String, String>();
        map.put("X1", "20230804GS00001");
        map.put("X2", "����˰���ܾ��㽭ʡ˰��ֵ���˰��־�");
        map.put("X3", "13300910000");
        map.put("X4", "������");
        map.put("X5", "77878798798");
        map.put("X6", "����");
        map.put("X7", "6217261571013778111");
        map.put("X8", "15088379926");
        map.put("X9", "�㽭��̩��ҵ���йɷ����޹�˾����Ǯ���³�֧��");
        map.put("X10", "�㽭��̩��ҵ��������");
        map.put("X11", "313345400010");
        map.put("X12", "313331005163");
        pdfAddFormWords("C:/kang/image/pdfbox/taxpayment.pdf", "C:/kang/image/pdfbox/taxpayment_fb.pdf", map,
                "C:/Windows/Fonts/simhei.ttf");

        // 3.�ϲ�pdf(pdfbox)
//		mergerPdfByPdfBox(new String[] { "C:/kang/image/pdfbox/sample1.pdf", "C:/kang/image/pdfbox/sample2.pdf" },
//				"C:/kang/image/pdfbox/merged.pdf");

        // 4.�ϲ�pdf(itextpdf)
//		mergerPdfByItextPdf(new String[] { "C:/kang/image/pdfbox/sample1.pdf", "C:/kang/image/pdfbox/sample2.pdf" },
//				"C:/kang/image/pdfbox/merged.pdf");

        // 5.pdf���ˮӡ
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