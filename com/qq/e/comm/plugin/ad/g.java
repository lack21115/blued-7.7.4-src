package com.qq.e.comm.plugin.ad;

import android.view.MotionEvent;
import android.view.View;
import com.qq.e.comm.plugin.util.w;
import org.json.JSONException;
import yaq.gdtadv;

public class g {
  private h a = new h();
  
  private View b;
  
  private static w a(w paramw) {
    return (w)gdtadv.getobjresult(175, 1, new Object[] { paramw });
  }
  
  public static String a(String paramString) {
    return (String)gdtadv.getobjresult(176, 1, new Object[] { paramString });
  }
  
  public static String a(String paramString, int paramInt) {
    return (String)gdtadv.getobjresult(177, 1, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public static String a(String paramString1, int paramInt, String paramString2) {
    return (String)gdtadv.getobjresult(178, 1, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
  }
  
  public static String c() {
    return (String)gdtadv.getobjresult(179, 1, new Object[0]);
  }
  
  private void d() {
    gdtadv.getVresult(180, 0, new Object[] { this });
  }
  
  public h a() {
    return (h)gdtadv.getobjresult(181, 0, new Object[] { this });
  }
  
  public String a(View paramView, int paramInt, String paramString1, String paramString2) {
    return (String)gdtadv.getobjresult(182, 0, new Object[] { this, paramView, Integer.valueOf(paramInt), paramString1, paramString2 });
  }
  
  public void a(int paramInt) {
    gdtadv.getVresult(183, 0, new Object[] { this, Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong) {
    gdtadv.getVresult(184, 0, new Object[] { this, Long.valueOf(paramLong) });
  }
  
  public void a(MotionEvent paramMotionEvent, boolean paramBoolean) {
    gdtadv.getVresult(185, 0, new Object[] { this, paramMotionEvent, Boolean.valueOf(paramBoolean) });
  }
  
  public void a(View paramView) {
    gdtadv.getVresult(186, 0, new Object[] { this, paramView });
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent, boolean paramBoolean) {
    gdtadv.getVresult(187, 0, new Object[] { this, paramView, paramMotionEvent, Boolean.valueOf(paramBoolean) });
  }
  
  public String b() throws JSONException {
    return (String)gdtadv.getobjresult(188, 0, new Object[] { this });
  }
  
  public void b(long paramLong) {
    gdtadv.getVresult(189, 0, new Object[] { this, Long.valueOf(paramLong) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */