/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author lenov
 */
import dao.KrsDAO;
import java.util.List;
import model.KRS;

public class KRSController {
    private final KrsDAO krsDao;

    public KRSController() {
        this.krsDao = new KrsDAO();
    }

    public int addKRS(KRS krs) {
        int result = krsDao.insertKRS(krs);
        return result;
    }

    public List<KRS> getKRSList() {
        List<KRS> dataList = krsDao.getKRSList();
        return dataList;
    }

    public int deleteKRS(int krsID) {
        int result = krsDao.deleteKRS(krsID);
        return result;
    }
}