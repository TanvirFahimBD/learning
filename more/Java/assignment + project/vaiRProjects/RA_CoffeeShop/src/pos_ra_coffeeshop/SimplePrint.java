package pos_ra_coffeeshop;

//code snippet

import java.awt.*;
import java.awt.print.*;
import javax.print.attribute.standard.*;
import javax.print.*;
import javax.print.attribute.*;

public class SimplePrint implements Printable {

    private String stringToPrint;

//Creating the constructor. We are passing 
//string (that is to b printed) as parameter
    public SimplePrint(String stringToPrint) {
        this.stringToPrint = stringToPrint;
    }

    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        g.setFont(new Font("Arial", Font.PLAIN, 11));
        g.setColor(Color.black);
        g.drawString(stringToPrint, 100, 100);

        return Printable.PAGE_EXISTS;
    }

    public void PrintReport() {

// Look up all services
// Look up the default print service
        PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
        PrintService designatedService = null;
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

// Find a particular service by name;
// in this case "HP LaserJet 6MP PS"
        AttributeSet aset = new HashAttributeSet();
// aset.add(new PrinterName("\\\\GPNT43\\INET_1", null));

        String DESINATED_PRINTER = "\\\\GPNT43\\INET_1";
// Find all services that support a set of print job capabilities;
// in this case, color
        aset = new HashAttributeSet();
        aset.add(ColorSupported.SUPPORTED);

        for (int i = 0; i < printServices.length; i++) {
            System.out.println(" service found " + printServices[i].getName());
            if (printServices[i].getName().equalsIgnoreCase(DESINATED_PRINTER)) {
                System.out.println("I want this one: " + printServices[i].getName());
                designatedService = printServices[i];
                break;
            }
        }

// Get a PrintJob
        PrinterJob pj = PrinterJob.getPrinterJob();
        try {
            pj.setPrintService(designatedService);
        } catch (PrinterException e) {
        }
        Printable painter;

// Specify the painter
        painter = new SimplePrint(stringToPrint);
        pj.setPrintable(painter);

// Show the print dialog
        if (pj.printDialog()) {
            try {
                pj.print();

            } catch (PrinterException pe) {
                System.out.println("Exception while printing.\n");
                pe.printStackTrace();
            }
        }

//new PrintPreview(painter, "Print Preview - SimplePrint");
    }
}
