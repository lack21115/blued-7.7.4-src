package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class BarcodeValue {
  private final Map<Integer, Integer> a = new HashMap<Integer, Integer>();
  
  void a(int paramInt) {
    Integer integer2 = this.a.get(Integer.valueOf(paramInt));
    Integer integer1 = integer2;
    if (integer2 == null)
      integer1 = Integer.valueOf(0); 
    int i = integer1.intValue();
    this.a.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
  }
  
  int[] a() {
    ArrayList arrayList = new ArrayList();
    Iterator<Map.Entry> iterator = this.a.entrySet().iterator();
    int i = -1;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      if (((Integer)entry.getValue()).intValue() > i) {
        i = ((Integer)entry.getValue()).intValue();
        arrayList.clear();
        arrayList.add(entry.getKey());
        continue;
      } 
      if (((Integer)entry.getValue()).intValue() == i)
        arrayList.add(entry.getKey()); 
    } 
    return PDF417Common.a(arrayList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\BarcodeValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */