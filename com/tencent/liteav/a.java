package com.tencent.liteav;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.liteav.basic.module.TXCStatus;
import java.util.ArrayList;

public class a {
  public static void a(String paramString, ArrayList<String> paramArrayList) {
    StatusBucket statusBucket = TXCAudioEngine.getInstance().getStatus(1);
    TXCStatus.a(paramString, 14003, Integer.valueOf(statusBucket.getIntStatus("18446744073709551615", 10001)));
    TXCStatus.a(paramString, 8005, Integer.valueOf(statusBucket.getIntStatus("18446744073709551615", 10002)));
    TXCStatus.a(paramString, 14017, Integer.valueOf(statusBucket.getIntStatus("18446744073709551615", 10000)));
    TXCStatus.a(paramString, 14002, Integer.valueOf(statusBucket.getIntStatus("18446744073709551615", 10003)));
    TXCStatus.a(paramString, 14006, Integer.valueOf(statusBucket.getIntStatus("18446744073709551615", 10004)));
    TXCStatus.a(paramString, 14018, Integer.valueOf(statusBucket.getIntStatus("18446744073709551615", 10005)));
    TXCStatus.a(paramString, 18029, Integer.valueOf(statusBucket.getIntStatus("18446744073709551615", 10006)));
    if (paramArrayList == null)
      return; 
    for (String str : paramArrayList) {
      int i = statusBucket.getIntStatus(str, 10114);
      int j = statusBucket.getIntStatus(str, 10115);
      TXCStatus.a(str, 18031, Integer.valueOf(i));
      TXCStatus.a(str, 18032, Integer.valueOf(j));
      boolean bool = false;
      if (j > 0) {
        i /= j;
      } else {
        i = 0;
      } 
      TXCStatus.a(str, 2001, Integer.valueOf(i));
      TXCStatus.a(str, 2002, Integer.valueOf(j));
      TXCStatus.a(str, 2005, Integer.valueOf(j));
      TXCStatus.a(str, 2004, Integer.valueOf(statusBucket.getIntStatus(str, 10300)));
      TXCStatus.a(str, 2034, Integer.valueOf(statusBucket.getIntStatus(str, 10301)));
      TXCStatus.a(str, 2035, Integer.valueOf(statusBucket.getIntStatus(str, 10302)));
      TXCStatus.a(str, 2014, Integer.valueOf(statusBucket.getIntStatus(str, 10303)));
      TXCStatus.a(str, 2008, Integer.valueOf(statusBucket.getIntStatus(str, 10112)));
      TXCStatus.a(str, 2010, Integer.valueOf(statusBucket.getIntStatus(str, 10106)));
      TXCStatus.a(str, 2007, Integer.valueOf(statusBucket.getIntStatus(str, 10105)));
      TXCStatus.a(str, 2011, Integer.valueOf(statusBucket.getIntStatus(str, 10107)));
      TXCStatus.a(str, 18001, Integer.valueOf(statusBucket.getIntStatus(str, 10103)));
      TXCStatus.a(str, 18002, Integer.valueOf(statusBucket.getIntStatus(str, 10104)));
      TXCStatus.a(str, 18006, Integer.valueOf(statusBucket.getIntStatus(str, 10202)));
      TXCStatus.a(str, 18007, Integer.valueOf(statusBucket.getIntStatus(str, 10203)));
      TXCStatus.a(str, 18008, Integer.valueOf(statusBucket.getIntStatus(str, 10204)));
      TXCStatus.a(str, 18015, Integer.valueOf(statusBucket.getIntStatus(str, 10205)));
      TXCStatus.a(str, 18013, Integer.valueOf(statusBucket.getIntStatus(str, 10206)));
      j = statusBucket.getIntStatus(str, 10203);
      int k = statusBucket.getIntStatus(str, 10202);
      i = bool;
      if (k > 0)
        i = j * 100 / k; 
      TXCStatus.a(str, 18014, Integer.valueOf(i));
      TXCStatus.a(str, 18023, Integer.valueOf(statusBucket.getIntStatus(str, 10200)));
      TXCStatus.a(str, 18026, Integer.valueOf(statusBucket.getIntStatus(str, 10110)));
      TXCStatus.a(str, 18027, Integer.valueOf(statusBucket.getIntStatus(str, 10111)));
      TXCStatus.a(str, 18028, Integer.valueOf(statusBucket.getIntStatus(str, 10201)));
      TXCStatus.a(str, 18030, Integer.valueOf(statusBucket.getIntStatus(str, 10113)));
      TXCStatus.a(str, 18003, Integer.valueOf(statusBucket.getIntStatus(str, 10100)));
      TXCStatus.a(str, 2019, Integer.valueOf(statusBucket.getIntStatus(str, 10100)));
      TXCStatus.a(str, 2020, Integer.valueOf(statusBucket.getIntStatus(str, 10101)));
      TXCStatus.a(str, 18016, Integer.valueOf(statusBucket.getIntStatus(str, 10102)));
      TXCStatus.a(str, 18009, Integer.valueOf(statusBucket.getIntStatus(str, 10207)));
      TXCStatus.a(str, 18010, Integer.valueOf(statusBucket.getIntStatus(str, 10208)));
      TXCStatus.a(str, 18012, Integer.valueOf(statusBucket.getIntStatus(str, 10209)));
      TXCStatus.a(str, 2021, Integer.valueOf(statusBucket.getIntStatus(str, 10109)));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */