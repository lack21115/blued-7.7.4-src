package com.loc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class bz {
  private List<dd> a = new ArrayList<dd>();
  
  private dc b;
  
  private ArrayList<dd> c = new ArrayList<dd>();
  
  private void a(List<dd> paramList1, List<dd> paramList2) {
    paramList1.clear();
    if (paramList2 != null) {
      ArrayList<?> arrayList = new ArrayList();
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      byte b = 0;
      int i;
      for (i = 0; i < paramList2.size(); i++) {
        dd dd = paramList2.get(i);
        hashMap.put(Integer.valueOf(dd.c), dd);
      } 
      arrayList.addAll(hashMap.values());
      Collections.sort(arrayList, new Comparator<dd>(this) {
          
          });
      int k = arrayList.size();
      int j = b;
      i = k;
      if (k > 40) {
        i = 40;
        j = b;
      } 
      while (j < i) {
        paramList1.add((dd)arrayList.get(j));
        j++;
      } 
    } 
  }
  
  final List<dd> a(dc paramdc, List<dd> paramList, boolean paramBoolean, long paramLong1, long paramLong2) {
    int i;
    int j = 0;
    boolean bool = false;
    if (!paramBoolean) {
      i = j;
    } else {
      boolean bool1;
      i = 3500;
      float f2 = paramdc.g;
      float f1 = 10.0F;
      if (f2 >= 10.0F)
        i = 2000; 
      if (paramLong1 > 0L && paramLong2 - paramLong1 < i) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      i = j;
      if (bool1) {
        i = j;
        if (paramList != null) {
          i = j;
          if (paramList.size() > 0)
            if (this.b != null) {
              if (paramdc.g > 10.0F) {
                f1 = 200.0F;
              } else if (paramdc.g > 2.0F) {
                f1 = 50.0F;
              } 
              if (paramdc.a(this.b) > f1) {
                i = 1;
              } else {
                i = 0;
              } 
              if (i == 0) {
                List<dd> list = this.a;
                bool1 = bool;
                if (paramList != null)
                  if (list == null) {
                    bool1 = bool;
                  } else {
                    List<dd> list1;
                    j = paramList.size();
                    int k = list.size();
                    if (j > k) {
                      list1 = list;
                      list = paramList;
                    } else {
                      list1 = paramList;
                    } 
                    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(list.size());
                    Iterator<dd> iterator2 = list.iterator();
                    while (iterator2.hasNext())
                      hashMap.put(Long.valueOf(((dd)iterator2.next()).a), Integer.valueOf(1)); 
                    Iterator<dd> iterator1 = list1.iterator();
                    i = 0;
                    while (iterator1.hasNext()) {
                      if ((Integer)hashMap.get(Long.valueOf(((dd)iterator1.next()).a)) != null)
                        i++; 
                    } 
                    bool1 = bool;
                    if (i * 2.0D >= (j + k) * 0.5D)
                      bool1 = true; 
                  }  
                i = bool1 ^ true;
              } 
            } else {
              i = 1;
            }  
        } 
      } 
    } 
    if (i != 0) {
      a(this.c, paramList);
      this.a.clear();
      this.a.addAll(paramList);
      this.b = paramdc;
      return this.c;
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */