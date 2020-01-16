package be.helha.aemt.entities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator implements Serializable{

		
//		public static void createPDF(Offre offre,String nomPDF) {
	public static void createPDF() {
	      Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("hello.pdf"));
	         document.open();
	         document.add(new Paragraph("coucou"));
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	   
}
