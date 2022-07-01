package com.huawei.hianalytics.ab.bc.ef;

import android.util.Log;
import com.huawei.hianalytics.ab.gh.ab;

public class bc {
  private boolean ab = false;
  
  private int bc = 4;
  
  private static String ab() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HiAnalyticsSDK_2.2.0.308");
    stringBuilder.append(ab.ab());
    return stringBuilder.toString();
  }
  
  public void ab(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('\n');
    stringBuilder.append("=======================================\n ");
    stringBuilder.append(ab());
    stringBuilder.append("");
    stringBuilder.append("\n=======================================");
    Log.i("HiAnalyticsSDK", stringBuilder.toString());
    this.bc = paramInt;
    this.ab = true;
  }
  
  public void ab(int paramInt, String paramString1, String paramString2) {
    if (paramInt != 3) {
      if (paramInt != 5) {
        if (paramInt != 6) {
          Log.i(paramString1, paramString2);
          return;
        } 
        Log.e(paramString1, paramString2);
        return;
      } 
      Log.w(paramString1, paramString2);
      return;
    } 
    Log.d(paramString1, paramString2);
  }
  
  public void bc(int paramInt, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("=> ");
    stringBuilder.append(paramString2);
    ab(paramInt, "HiAnalyticsSDK", stringBuilder.toString());
  }
  
  public boolean bc(int paramInt) {
    return (this.ab && paramInt >= this.bc);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\ef\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */