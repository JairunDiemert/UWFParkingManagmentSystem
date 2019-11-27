package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

public class BarCode_Creator {
	
	public static int hashBarcodeNumber(int uniqueID)
	{
		int hash = 0;
		hash = (uniqueID + 900000000) ;
		return hash;
	}
	
	public static void crateBarcode(int uniqueID) throws Exception{
		
		String hashedBarcode = String.valueOf(hashBarcodeNumber(uniqueID));

		// Create the barcode
		        Code39Bean bean = new Code39Bean();
		 
		        final int dpi = 150;
		 
		        //Configure the barcode generator
		        bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar, width exactly one pixel
		        bean.setWideFactor(3);
		        bean.doQuietZone(false);
		 
		        //Open output file
		        File outputFile = new File("BarCodeStuff"+"/"+"images"+"/"+"out.png");
		        OutputStream out = new FileOutputStream(outputFile);
		        
		
		 
		            //Set up the canvas provider for monochrome PNG output
		            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
		                out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		 
		            //Generate the barcode
		            bean.generateBarcode(canvas, hashedBarcode);
		 
		            //Signal end of generation
		            canvas.finish();

		            out.close();

	}
	
}