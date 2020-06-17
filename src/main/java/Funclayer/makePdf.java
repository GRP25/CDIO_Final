package Funclayer;

import Datalayer.DAO.CommodityDAO;
import Datalayer.DAO.PrescriptionCompDAO;
import Datalayer.DAO.ProductBatchCompDAO;
import Datalayer.DAO.ProductBatchDAO;
import Datalayer.Interfaces.ICommodityDAO;
import Datalayer.Interfaces.IPrescriptionCompDAO;
import Datalayer.Interfaces.IProductBatchCompDAO;
import Datalayer.Interfaces.IProductBatchDAO;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class makePdf {
    static void writeLine() {
        try {
            FileWriter myWriter = new FileWriter("temp.tex");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String productionToReceipt(int productionId) {
        IProductBatchDAO     prodao  = new ProductBatchDAO();
        IPrescriptionCompDAO precom  = new PrescriptionCompDAO();
        IProductBatchCompDAO procom  = new ProductBatchCompDAO();
        ICommodityDAO        comdao  = new CommodityDAO();

        String               printed = LocalDateTime.now().toString();

        return printed;
    }

    public static void main(String[] args) {
        System.out.println(productionToReceipt(1));
    }
}
