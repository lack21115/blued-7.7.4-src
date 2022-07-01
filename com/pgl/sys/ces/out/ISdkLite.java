package com.pgl.sys.ces.out;

import android.content.Context;
import java.util.HashMap;

public interface ISdkLite {
  public static final int REGION_INTERNEL = 0;
  
  public static final int REGION_SINGAPOER = 2;
  
  public static final int REGION_UNSET = 255;
  
  public static final int REGION_USA_EAST = 3;
  
  void SetRegionType(int paramInt);
  
  String debugEntry(Context paramContext, int paramInt);
  
  String onEvent();
  
  String pullSg();
  
  String pullVer(String paramString);
  
  void reportNow(String paramString);
  
  void setCustomInfo(HashMap<String, Object> paramHashMap);
  
  void setEfficientDebug(boolean paramBoolean);
  
  void setParams(String paramString1, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\out\ISdkLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */