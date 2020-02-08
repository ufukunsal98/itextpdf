package com.ufuk.itextpdf.Service.Impl;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import com.ufuk.itextpdf.Service.PdfService;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class PdfServiceImpl implements PdfService {
    @Override
    public void getpdf() throws Exception {
        String dest = "./target/sandbox/tables/simple_table.pdf";
        File file = new File(dest);
        file.getParentFile().mkdirs();
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);
        pdfDoc.setDefaultPageSize(PageSize.A4.rotate());
        float[] columnWidths = {1, 3, 5,5,5,5};
        Table table = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth();
        PdfFont font = PdfFontFactory.createFont(
                StandardFonts.TIMES_ROMAN, "Cp1254", true);
        doc.setFont(font);
        table.addCell(new Cell());
        table.addCell(new Cell());
        table.addCell("1.Sınıf");
        table.addCell("2.Sınıf");
        table.addCell("3.Sınıf");
        table.addCell("4.Sınıf");
        table.addCell("Gün");
        table.addCell("Saat");
        table.addCell("Dersin Adı");
        table.addCell("Dersin Adı");
        table.addCell("Dersin Adı");
        table.addCell("Dersin Adı");
        for (int i = 0; i < 6; i++) {
            table.addCell("hi");
        }

        doc.add(table);

        doc.close();
    }
}
