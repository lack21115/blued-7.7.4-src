package com.soft.blued.ui.msg.VideoChat;

import android.content.Context;
import android.util.Log;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.external_sense_library.utils.Accelerometer;
import com.blued.android.module.external_sense_library.utils.FileUtils;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.sensetime.stmobile.STBeautifyNative;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.stmobile.STMobileStreamFilterNative;
import com.sensetime.stmobile.model.STHumanAction;

public class ZegoBeautyWrapper {
  private static ZegoBeautyWrapper d;
  
  int a;
  
  boolean b;
  
  private String c;
  
  private Context e;
  
  private Object f;
  
  private STMobileHumanActionNative g;
  
  private STBeautifyNative h;
  
  private STMobileStreamFilterNative i;
  
  private int j;
  
  private boolean k;
  
  private STHumanAction l;
  
  private int[] m;
  
  private boolean n;
  
  public static ZegoBeautyWrapper a() {
    return d;
  }
  
  private int c() {
    int k = Accelerometer.c();
    int j = k - 1;
    int i = j;
    if (j < 0)
      i = k ^ 0x3; 
    return i;
  }
  
  private int d() {
    int i = this.a;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    int j = Accelerometer.c();
    if (!bool && j == 0)
      return 2; 
    i = j;
    if (!bool) {
      i = j;
      if (j == 2)
        i = 0; 
    } 
    return i;
  }
  
  public int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    if (this.n) {
      STHumanAction sTHumanAction = null;
      if (this.k) {
        long l = System.currentTimeMillis();
        STHumanAction sTHumanAction1 = this.g.humanActionDetect(paramArrayOfbyte, 3, 0L, d(), paramInt3, paramInt2);
        LogUtils.c(this.c, "human action cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        sTHumanAction = STHumanAction.humanActionRotateAndMirror(sTHumanAction1, paramInt2, paramInt3, this.a, c());
      } 
      int i = c();
      if (this.m == null) {
        this.m = new int[1];
        GlUtil.a(paramInt2, paramInt3, this.m, 3553);
      } 
      if (this.n) {
        long l1 = System.currentTimeMillis();
        paramInt2 = this.h.processTexture(paramInt1, paramInt2, paramInt3, i, sTHumanAction, this.m[0], this.l);
        long l2 = System.currentTimeMillis();
        LogUtils.c(this.c, "beautify cost time: %d", new Object[] { Long.valueOf(l2 - l1) });
        if (paramInt2 == 0) {
          paramInt1 = this.m[0];
          STHumanAction sTHumanAction1 = this.l;
          LogUtils.c(this.c, "replace enlarge eye and shrink face action", new Object[0]);
          return paramInt1;
        } 
      } 
    } 
    return paramInt1;
  }
  
  public void b() {
    this.g.reset();
    this.h.destroyBeautify();
    this.i.destroyInstance();
    d = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\VideoChat\ZegoBeautyWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */