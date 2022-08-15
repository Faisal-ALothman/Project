package com.example.amazon;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    private ArrayList<Merchant> MerchantList = new ArrayList<>();

    public ArrayList<Merchant> getMerchant(){
        return MerchantList;
    }
    public void addMerchant(Merchant merchant){
        MerchantList.add(merchant);
    }
    public void updateMerchant(int index, Merchant merchant) {
        MerchantList.set(index, merchant);
    }
    public void deleteMerchant(int index) {
        MerchantList.remove(index);
    }}
