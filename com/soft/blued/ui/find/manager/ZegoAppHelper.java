package com.soft.blued.ui.find.manager;

import android.os.Handler;
import android.os.HandlerThread;

public class ZegoAppHelper {
  private static final byte[] a = new byte[] { 
      -111, -109, -52, 102, 42, 28, 14, -63, 53, -20, 
      113, -5, 7, 25, 75, 56, 65, -44, -83, -125, 
      120, -14, 89, -112, -32, -92, 12, Byte.MAX_VALUE, -12, 40, 
      65, -9 };
  
  private static final byte[] b = new byte[] { 
      30, -61, -8, 92, -78, -14, 19, 112, 38, 78, 
      -77, 113, -56, -58, 92, -93, Byte.MAX_VALUE, -93, 59, -99, 
      -17, -17, 42, -123, -32, -56, -103, -82, -126, -64, 
      -10, -8 };
  
  private static final byte[] c = new byte[] { 
      93, -26, -125, -84, -92, -27, -83, 67, -27, -22, 
      -29, 112, 107, -32, 119, -92, 24, 121, 56, 49, 
      46, -52, 23, 25, 50, -46, -2, 34, 91, 107, 
      43, 47 };
  
  private static ZegoAppHelper d = new ZegoAppHelper();
  
  private HandlerThread e = new HandlerThread("zego_background");
  
  private Handler f;
  
  private ZegoAppHelper() {
    this.e.start();
    this.f = new Handler(this.e.getLooper());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\manager\ZegoAppHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */