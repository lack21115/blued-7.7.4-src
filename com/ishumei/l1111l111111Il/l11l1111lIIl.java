package com.ishumei.l1111l111111Il;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.ishumei.dfp.SMSDK;
import com.ishumei.l111l11111Il.l111l11111lIl;
import com.ishumei.l111l11111lIl.l111l11111lIl;
import com.ishumei.l111l1111l1Il.l111l11111I1l;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import com.ishumei.smantifraud.SmAntiFraud;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l11l1111lIIl {
  Runnable l1111l111111Il = new Runnable(this) {
      public final void run() {
        try {
          l11l1111lIIl.l1111l111111Il(this.l1111l111111Il);
          return;
        } catch (Exception exception) {
          return;
        } finally {
          com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this, 6, (l11l1111lIIl.l111l11111lIl(this.l1111l111111Il).l111l11111I1l() * 1000), false);
        } 
      }
    };
  
  private int l111l11111I1l = 0;
  
  private int l111l11111Il = 0;
  
  private ArrayList<l11l1111I11l> l111l11111lIl = new ArrayList<l11l1111I11l>();
  
  private l111l11111lIl l111l1111l1Il;
  
  private Runnable l111l1111lI1l = new Runnable(this) {
      public final void run() {
        try {
          l11l1111lIIl.l1111l111111Il(this.l1111l111111Il);
          return;
        } catch (Exception exception) {
          return;
        } 
      }
    };
  
  private boolean l111l1111llIl = false;
  
  private l11l1111lIIl() {}
  
  public static l11l1111lIIl l1111l111111Il() {
    return l1111l111111Il.l1111l111111Il();
  }
  
  private void l111l11111lIl() {
    if (this.l111l11111lIl.size() <= 0)
      return; 
    this.l111l11111Il++;
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("smid", SmAntiFraud.getDeviceId());
    jSONObject.put("appId", SmAntiFraud.l1111l111111Il.l11l11IlIIll());
    jSONObject.put("appname", l111l11111lIl.l111l11111I1l());
    jSONObject.put("sessionId", l111l1111llIl.l1111l111111Il.l111l1111l1Il);
    ArrayList<l11l1111I11l> arrayList = this.l111l11111lIl;
    this.l111l11111lIl = new ArrayList<l11l1111I11l>();
    JSONArray jSONArray = new JSONArray();
    Iterator<l11l1111I11l> iterator = arrayList.iterator();
    while (iterator.hasNext())
      jSONArray.put(l111l1111lIl.l1111l111111Il(iterator.next())); 
    jSONObject.put("wevent", jSONArray);
    String str = SMSDK.v3(l111l1111llIl.l1111l111111Il.l111l11111Il, jSONObject.toString(), SmAntiFraud.l1111l111111Il.l111l1111llIl(), SmAntiFraud.l1111l111111Il.l11l1111I1ll(), SmAntiFraud.l1111l111111Il.l11l11IlIIll());
    if (TextUtils.isEmpty(str))
      return; 
    com.ishumei.l111l1111l1Il.l1111l111111Il l1111l111111Il = com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(SmAntiFraud.l1111l111111Il.l11l1111Il1l(), SmAntiFraud.l1111l111111Il.l111l1111l1Il(), SmAntiFraud.l1111l111111Il.l111l11111Il());
    (new l111l11111I1l()).l1111l111111Il(l1111l111111Il).l1111l111111Il(str.getBytes(), null, SmAntiFraud.l1111l111111Il.l11l1111Il1l());
  }
  
  public final void l1111l111111Il(String paramString1, String paramString2, MotionEvent paramMotionEvent) {
    float f1;
    float f2;
    float f3;
    float f4;
    int i;
    long l1;
    if (paramMotionEvent == null) {
      i = -1;
    } else {
      i = paramMotionEvent.getAction();
    } 
    if (paramMotionEvent == null) {
      f1 = -1.0F;
    } else {
      f1 = paramMotionEvent.getPressure();
    } 
    if (paramMotionEvent == null) {
      f2 = -1.0F;
    } else {
      f2 = paramMotionEvent.getSize();
    } 
    long l2 = -1L;
    if (paramMotionEvent == null) {
      l1 = -1L;
    } else {
      l1 = paramMotionEvent.getDownTime();
    } 
    if (paramMotionEvent != null)
      l2 = paramMotionEvent.getEventTime(); 
    if (paramMotionEvent == null) {
      f3 = -1.0F;
    } else {
      f3 = paramMotionEvent.getXPrecision();
    } 
    if (paramMotionEvent == null) {
      f4 = -1.0F;
    } else {
      f4 = paramMotionEvent.getYPrecision();
    } 
    com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(new Runnable(this, i, paramString1, paramString2, f1, f2, l1, l2, f3, f4) {
          public final void run() {
            String str;
            if (l11l1111lIIl.l111l11111lIl(this.l11l1111I11l) == null)
              l11l1111lIIl.l1111l111111Il(this.l11l1111I11l, com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl()); 
            if (!l11l1111lIIl.l111l11111I1l(this.l11l1111I11l)) {
              com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this.l11l1111I11l.l1111l111111Il, 6, (l11l1111lIIl.l111l11111lIl(this.l11l1111I11l).l111l11111I1l() * 1000), false);
              l11l1111lIIl.l1111l111111Il(this.l11l1111I11l, true);
            } 
            if (l11l1111lIIl.l111l11111Il(this.l11l1111I11l) >= l11l1111lIIl.l111l11111lIl(this.l11l1111I11l).l111l11111lIl())
              return; 
            int i = this.l1111l111111Il;
            if (i != 0) {
              if (i != 1) {
                if (i != 2) {
                  str = "";
                } else {
                  str = "Move";
                } 
              } else {
                str = "Up";
              } 
            } else {
              str = "Down";
            } 
            l11l1111I11l l11l1111I11l = new l11l1111I11l();
            l11l1111I11l.l1111l111111Il(l11l1111lIIl.l111l1111l1Il(this.l11l1111I11l));
            l11l1111I11l.l1111l111111Il(this.l111l11111lIl);
            l11l1111I11l.l111l11111lIl(str);
            l11l1111I11l.l111l11111I1l(this.l111l11111I1l);
            l11l1111I11l.l111l11111Il(this.l111l11111Il);
            l11l1111I11l.l111l11111I1l(this.l111l1111l1Il);
            l11l1111I11l.l111l11111I1l(System.currentTimeMillis());
            l11l1111I11l.l1111l111111Il(this.l111l1111llIl);
            l11l1111I11l.l111l11111lIl(this.l111l1111lI1l);
            l11l1111I11l.l1111l111111Il(this.l111l1111lIl);
            l11l1111I11l.l111l11111lIl(this.l11l1111lIIl);
            l11l1111lIIl.l111l1111llIl(this.l11l1111I11l).add(l11l1111I11l);
            if (l11l1111lIIl.l111l1111llIl(this.l11l1111I11l).size() >= l11l1111lIIl.l111l11111lIl(this.l11l1111I11l).l1111l111111Il())
              com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(l11l1111lIIl.l111l1111lI1l(this.l11l1111I11l), 6); 
          }
        }6, 0L, false);
  }
  
  static final class l1111l111111Il {
    private static final l11l1111lIIl l1111l111111Il = new l11l1111lIIl((byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l1111l111111Il\l11l1111lIIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */