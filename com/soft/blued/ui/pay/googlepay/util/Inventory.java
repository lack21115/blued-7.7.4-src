package com.soft.blued.ui.pay.googlepay.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
  Map<String, SkuDetails> a = new HashMap<String, SkuDetails>();
  
  Map<String, Purchase> b = new HashMap<String, Purchase>();
  
  List<String> a(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    for (Purchase purchase : this.b.values()) {
      if (purchase.a().equals(paramString))
        arrayList.add(purchase.b()); 
    } 
    return arrayList;
  }
  
  void a(Purchase paramPurchase) {
    this.b.put(paramPurchase.b(), paramPurchase);
  }
  
  void a(SkuDetails paramSkuDetails) {
    this.a.put(paramSkuDetails.a(), paramSkuDetails);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\googlepa\\util\Inventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */