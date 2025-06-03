package org.WeatherReports;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import java.io.IOException;

public class createPDFTest {
    private void CreatePDFTest() {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
                document.addPage(page);
                PDPageContentStream contentStream = new PDPageContentStream(document, page);
                contentStream.beginText();
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 14);
                //contentStream.showText("Prognoza pogody data:" + currentWeather.dt.toString() +" miejscowość  " + currentWeather.name);
                contentStream.endText();
                contentStream.close();
                //document.save(currentWeather.name + ".pdf");
                document.close();
                System.out.println("createPDF");
        } catch (IOException e) {
            System.out.println("Błąd tworzenia pliku pdf");
        }
    }
}
