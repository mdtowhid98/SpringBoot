package com.towhid.practicePharmacy2.service;

import com.towhid.practicePharmacy2.entity.Medicine;
import com.towhid.practicePharmacy2.entity.SalesMedicine;
import com.towhid.practicePharmacy2.repository.MedicineRepository;
import com.towhid.practicePharmacy2.repository.SalesMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesMedicineService {

    @Autowired
    private SalesMedicineRepository salesMedicineRepository;
//    @Autowired
//    private MedicineRepository medicineRepository;


    public SalesMedicine saveSalesMedicine(SalesMedicine salesMedicine) {
        return salesMedicineRepository.save(salesMedicine);
    }
    public List<SalesMedicine> getAllMedicine(){
        return salesMedicineRepository.findAll();
    }

    public void deleteBySalesMedicineId(long id){
        salesMedicineRepository.deleteById(id);
    }
    public SalesMedicine findById(long id){
        return salesMedicineRepository.findById(id).get();
    }
    public void updateSalesMedicin(SalesMedicine s, long id){
        salesMedicineRepository.save(s);
    }

//    public SalesMedicine updateSalesMedicine(long id, SalesMedicine salesMedicine) {
//        Optional<SalesMedicine> existingSales = salesMedicineRepository.findById(id);
//        if (existingSales.isPresent()) {
//            SalesMedicine updatedSales = existingSales.get();
//            updatedSales.setCustomername(salesMedicine.getCustomername());
//            updatedSales.setSalesdate(salesMedicine.getSalesdate());
//            updatedSales.setTotalprice(salesMedicine.getTotalprice());
//            updatedSales.setMedicines(salesMedicine.getMedicines());
//            return salesMedicineRepository.save(updatedSales);
//        } else {
//            throw new RuntimeException("SalesMedicine not found with id: " + id);
//        }
//    }


}
