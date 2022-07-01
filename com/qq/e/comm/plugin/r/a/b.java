package com.qq.e.comm.plugin.r.a;

import com.qq.e.comm.plugin.r.b.c;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class b {
  private static int a(c paramc) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BiddingUtils ");
    stringBuilder.append(paramc.a());
    stringBuilder.append(" Priority config, isEnableRtPriority: ");
    stringBuilder.append(paramc.j());
    stringBuilder.append("  getRtPriority: ");
    stringBuilder.append(paramc.l());
    stringBuilder.append("  isContractAd: ");
    stringBuilder.append(paramc.m());
    stringBuilder.append("  getContractPriority(): ");
    stringBuilder.append(paramc.n());
    stringBuilder.append("  getPriority: ");
    stringBuilder.append(paramc.d());
    GDTLogger.d(stringBuilder.toString());
    int j = paramc.d();
    int i = j;
    if (paramc.j()) {
      if (paramc.l() > 0)
        return paramc.l(); 
      i = j;
      if (paramc.n() > 0) {
        i = j;
        if (paramc.m())
          i = paramc.n(); 
      } 
    } 
    return i;
  }
  
  public static List<c> a(List<c> paramList) {
    return a(paramList, false);
  }
  
  private static List<c> a(List<c> paramList, boolean paramBoolean) {
    ArrayList<? super c> arrayList = new ArrayList();
    if (paramList != null) {
      c[] arrayOfC = paramList.<c>toArray(new c[paramList.size()]);
      int j = arrayOfC.length;
      for (int i = 0; i < j - 1; i = m) {
        int m = i + 1;
        int n = i;
        int k = m;
        while (k < j) {
          int i1 = n;
          if (a(arrayOfC[k], arrayOfC[n], paramBoolean))
            i1 = k; 
          k++;
          n = i1;
        } 
        if (i != n) {
          c c = arrayOfC[i];
          arrayOfC[i] = arrayOfC[n];
          arrayOfC[n] = c;
        } 
      } 
      Collections.addAll(arrayList, arrayOfC);
    } 
    return (List)arrayList;
  }
  
  private static boolean a(c paramc1, c paramc2, boolean paramBoolean) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramc1 != null) {
      bool1 = bool2;
      if (paramc2 != null) {
        int i;
        int j;
        long l1;
        long l2;
        if (paramBoolean) {
          j = a(paramc1);
          i = a(paramc2);
          l1 = b(paramc1);
          l2 = b(paramc2);
        } else {
          j = paramc1.d();
          i = paramc2.d();
          l1 = paramc1.c();
          l2 = paramc2.c();
        } 
        if (j >= i) {
          bool1 = bool2;
          if (j == i) {
            if (l1 <= l2)
              return false; 
          } else {
            return bool1;
          } 
        } 
        bool1 = true;
      } 
    } 
    return bool1;
  }
  
  private static long b(c paramc) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BiddingUtils ");
    stringBuilder.append(paramc.a());
    stringBuilder.append("  ECPM config, isEnableRtBid: ");
    stringBuilder.append(paramc.k());
    stringBuilder.append("  getECPM: ");
    stringBuilder.append(paramc.i());
    stringBuilder.append("  getECPM() * 1000: ");
    stringBuilder.append(paramc.i() * 1000L);
    stringBuilder.append("  getBid: ");
    stringBuilder.append(paramc.c());
    GDTLogger.d(stringBuilder.toString());
    return (paramc.k() && paramc.i() > 0) ? (paramc.i() * 1000L) : paramc.c();
  }
  
  public static List<c> b(List<c> paramList) {
    paramList = a(paramList, true);
    Iterator<c> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (!((c)iterator.next()).r())
        iterator.remove(); 
    } 
    return paramList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\r\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */