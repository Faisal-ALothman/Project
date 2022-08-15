package com.example.amazon;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    private ArrayList<MerchantStock> MerchantStockList = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStock(){
        return MerchantStockList;
    }
    public void addMerchantStock(MerchantStock merchantStock){
        MerchantStockList.add(merchantStock);
    }
    public void updateMerchantStock(int index, MerchantStock merchantStock) {
        MerchantStockList.set(index, merchantStock);
    }
    public void deleteMerchantStock(int index) {
        MerchantStockList.remove(index);
    }}

