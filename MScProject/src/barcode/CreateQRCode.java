package barcode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter; 
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.FileInputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

public class CreateQRCode{
    public static void createQRCode(String qrCodeData) {
        try {
     
            String filePath = "/Users/chrissieediker/Documents/QRCode/JobNumber.png";
            String charset = "ISO-8859-1"; // or "UTF-8"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix bm = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                //100x100 size
                BarcodeFormat.QR_CODE, 150, 150, hintMap);
           
            System.out.println(bm);
           
            MatrixToImageWriter.writeToFile(bm, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image generated.");
            
    	    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
    	    pras.add(new Copies(1));
    	    PrintService pss[] = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.GIF, pras);
    	    if (pss.length == 0)
    	      throw new RuntimeException("No printer services available.");
    	    PrintService ps = pss[0];
    	    System.out.println("Printing to " + ps);
    	    DocPrintJob job = ps.createPrintJob();
    	    
    	    FileInputStream fileInStr= new FileInputStream(filePath);
    	    Doc print = new SimpleDoc(fileInStr, DocFlavor.INPUT_STREAM.GIF, null);
    	    job.print(print, pras);
    	    fileInStr.close(); 
            
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
