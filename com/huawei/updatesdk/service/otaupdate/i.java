package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class i {
  public static int a(long paramLong1, long paramLong2) {
    return (paramLong2 <= 0L) ? 0 : Math.min((int)Math.round(paramLong1 / paramLong2 * 100.0D), 100);
  }
  
  public static String a(int paramInt) {
    NumberFormat numberFormat = NumberFormat.getPercentInstance();
    double d = paramInt / 100.0D;
    numberFormat.setMinimumFractionDigits(0);
    return numberFormat.format(d);
  }
  
  public static String a(Context paramContext, long paramLong) {
    if (paramLong == 0L)
      return paramContext.getString(g.e(paramContext, "upsdk_storage_utils"), new Object[] { "0" }); 
    DecimalFormat decimalFormat = null;
    if (paramLong > 104857L) {
      decimalFormat = new DecimalFormat("###.#");
    } else if (paramLong > 10485L) {
      decimalFormat = new DecimalFormat("###.##");
    } 
    if (decimalFormat != null) {
      double d = paramLong / 1048576.0D;
      return paramContext.getString(g.e(paramContext, "upsdk_storage_utils"), new Object[] { decimalFormat.format(d) });
    } 
    return paramContext.getString(g.e(paramContext, "upsdk_storage_utils"), new Object[] { "0.01" });
  }
  
  public static boolean a(List paramList) {
    return (paramList == null || paramList.size() <= 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */