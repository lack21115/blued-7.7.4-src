package com.soft.blued.ui.live.utils;

import com.soft.blued.ui.live.model.BluedLiveListData;
import java.util.ArrayList;
import java.util.List;

public class LiveListDataUtils {
  private static List<BluedLiveListData> a;
  
  private static List<BluedLiveListData> b;
  
  private static List<BluedLiveListData> c;
  
  private static List<List<BluedLiveListData>> d;
  
  private static List<List<BluedLiveListData>> e;
  
  private static List<List<BluedLiveListData>> f;
  
  public static int a(long paramLong, List<BluedLiveListData> paramList) {
    if (paramList == null)
      return 0; 
    for (int i = 0; i < paramList.size(); i++) {
      BluedLiveListData bluedLiveListData = paramList.get(i);
      if (bluedLiveListData != null && String.valueOf(paramLong).equals(bluedLiveListData.lid))
        return i; 
    } 
    return 0;
  }
  
  public static int a(BluedLiveListData paramBluedLiveListData) {
    return (paramBluedLiveListData.liveType == 1) ? 1 : ((paramBluedLiveListData.liveType == 2) ? 2 : ((paramBluedLiveListData.liveType == 7) ? 7 : ((paramBluedLiveListData.liveType == 10) ? 10 : 0)));
  }
  
  public static List<BluedLiveListData> a(List<BluedLiveListData> paramList) {
    ArrayList<BluedLiveListData> arrayList = new ArrayList();
    for (int i = 0; i < paramList.size(); i++) {
      BluedLiveListData bluedLiveListData = paramList.get(i);
      if (bluedLiveListData.liveType == 7) {
        if (bluedLiveListData != null && bluedLiveListData.hotpk_list != null)
          for (int j = 0; j < bluedLiveListData.hotpk_list.size(); j++)
            arrayList.add(bluedLiveListData.hotpk_list.get(j));  
      } else {
        arrayList.add(bluedLiveListData);
      } 
    } 
    return arrayList;
  }
  
  public static List<BluedLiveListData> a(List<BluedLiveListData> paramList, boolean paramBoolean) {
    ArrayList<BluedLiveListData> arrayList = new ArrayList();
    a = new ArrayList<BluedLiveListData>();
    b = new ArrayList<BluedLiveListData>();
    e = new ArrayList<List<BluedLiveListData>>();
    f = new ArrayList<List<BluedLiveListData>>();
    d = new ArrayList<List<BluedLiveListData>>();
    c = new ArrayList<BluedLiveListData>();
    byte b = 0;
    BluedLiveListData bluedLiveListData = null;
    if (paramList != null) {
      bluedLiveListData = null;
      int i = 0;
      try {
        while (i < paramList.size()) {
          int j = a(paramList.get(i));
          if (j != 0) {
            if (j != 1) {
              if (j != 2) {
                if (j != 7) {
                  if (j == 10)
                    e(paramList.get(i)); 
                } else {
                  BluedLiveListData bluedLiveListData1 = paramList.get(i);
                  bluedLiveListData = bluedLiveListData1;
                } 
              } else {
                b(paramList.get(i));
              } 
            } else {
              c(paramList.get(i));
            } 
          } else {
            d(paramList.get(i));
          } 
          i++;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    if (d.size() > 0) {
      List<List<BluedLiveListData>> list = d;
      if (a(list.get(list.size() - 1), 2)) {
        list = d;
        list.remove(list.size() - 1);
      } 
      if (d.size() > 0) {
        BluedLiveListData bluedLiveListData1 = new BluedLiveListData();
        bluedLiveListData1.liveType = 4;
        arrayList.add(bluedLiveListData1);
        int j = 0;
        int i = 0;
        while (j < d.size()) {
          List<BluedLiveListData> list1 = d.get(j);
          int k;
          for (k = 0; k < list1.size(); k++) {
            BluedLiveListData bluedLiveListData2 = list1.get(k);
            bluedLiveListData2.position = k;
            bluedLiveListData2.positionReal = i;
            arrayList.add(bluedLiveListData2);
            i++;
          } 
          j++;
        } 
      } 
    } 
    if (e.size() > 0)
      for (int i = 0; i < e.size(); i++) {
        paramList = e.get(i);
        for (int j = 0; j < paramList.size(); j++)
          arrayList.add(paramList.get(j)); 
      }  
    if (bluedLiveListData != null)
      arrayList.add(bluedLiveListData); 
    if (f.size() > 0) {
      List<List<BluedLiveListData>> list = f;
      if (a(list.get(list.size() - 1), 0)) {
        list = f;
        list.remove(list.size() - 1);
      } 
      if (f.size() > 0) {
        if (paramBoolean) {
          BluedLiveListData bluedLiveListData1 = new BluedLiveListData();
          bluedLiveListData1.liveType = 5;
          if (e.size() > 0) {
            bluedLiveListData1.hasOfficialList = true;
          } else {
            bluedLiveListData1.hasOfficialList = false;
          } 
          if (d.size() > 0) {
            bluedLiveListData1.hasRedList = true;
          } else {
            bluedLiveListData1.hasRedList = false;
          } 
          if (bluedLiveListData != null) {
            bluedLiveListData1.hasPKList = true;
          } else {
            bluedLiveListData1.hasPKList = false;
          } 
          arrayList.add(bluedLiveListData1);
        } 
        int j = 0;
        int i = 0;
        while (j < f.size()) {
          list = (List<List<BluedLiveListData>>)f.get(j);
          int k;
          for (k = 0; k < list.size(); k++) {
            bluedLiveListData = (BluedLiveListData)list.get(k);
            bluedLiveListData.position = k;
            bluedLiveListData.positionReal = i;
            arrayList.add(bluedLiveListData);
            i++;
          } 
          j++;
        } 
      } 
    } 
    if (c.size() > 1) {
      int i = b;
      if (b(c)) {
        paramList = c;
        paramList.remove(paramList.size() - 1);
        i = b;
      } 
      while (i < c.size()) {
        ((BluedLiveListData)c.get(i)).position = i % 2;
        i++;
      } 
      if (f.size() == 0) {
        BluedLiveListData bluedLiveListData2 = new BluedLiveListData();
        bluedLiveListData2.liveType = 9;
        arrayList.add(bluedLiveListData2);
      } 
      BluedLiveListData bluedLiveListData1 = new BluedLiveListData();
      bluedLiveListData1.liveType = 8;
      arrayList.add(bluedLiveListData1);
      arrayList.addAll(c);
    } 
    return arrayList;
  }
  
  public static boolean a(List<BluedLiveListData> paramList, int paramInt) {
    byte b = 2;
    if (paramInt != 0)
      if (paramInt != 2) {
        b = 0;
      } else {
        b = 3;
      }  
    return (paramList == null || paramList.size() < b);
  }
  
  private static void b(BluedLiveListData paramBluedLiveListData) {
    if (a.size() == 3 || a.size() == 0) {
      a = new ArrayList<BluedLiveListData>();
      a.add(paramBluedLiveListData);
      d.add(a);
      return;
    } 
    a.add(paramBluedLiveListData);
  }
  
  public static boolean b(List<BluedLiveListData> paramList) {
    return (paramList != null && paramList.size() % 2 == 1);
  }
  
  private static void c(BluedLiveListData paramBluedLiveListData) {
    ArrayList<BluedLiveListData> arrayList = new ArrayList();
    arrayList.add(paramBluedLiveListData);
    e.add(arrayList);
  }
  
  private static void d(BluedLiveListData paramBluedLiveListData) {
    if (b.size() == 2 || b.size() == 0) {
      b = new ArrayList<BluedLiveListData>();
      b.add(paramBluedLiveListData);
      f.add(b);
      return;
    } 
    b.add(paramBluedLiveListData);
  }
  
  private static void e(BluedLiveListData paramBluedLiveListData) {
    c.add(paramBluedLiveListData);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\liv\\utils\LiveListDataUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */