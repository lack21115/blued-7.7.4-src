package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.amap.api.maps2d.MapsInitializer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

class az {
  static double a = 0.6499999761581421D;
  
  public d b;
  
  public c c;
  
  public b d;
  
  public a e;
  
  public v f;
  
  public b g;
  
  public av h = null;
  
  private an i;
  
  public az(Context paramContext, b paramb, int paramInt) {
    this.g = paramb;
    this.c = new c(paramb);
    this.h = new av(this.c);
    av av1 = this.h;
    av1.a = paramInt;
    av1.b = paramInt;
    av1.a();
    a(paramContext);
    this.e = new a(paramContext);
    this.b = new d(this);
    this.d = new b(this);
    this.f = new v(paramb);
    this.c.a(false, false);
  }
  
  private void b() {
    if (MapsInitializer.getUpdateDataActiveEnable()) {
      bg.a();
      String str = bg.a("updateDataPeriodDate");
      if (str == null || str.equals("")) {
        bg.a().b("updateDataPeriodDate", t.a());
        return;
      } 
      if (t.a(str, t.a()) > bg.a().a("period_day", q.q)) {
        c();
        return;
      } 
    } 
  }
  
  private void c() {
    bg.a();
    String str = bg.a("cache_path", (String)null);
    if (str != null)
      u.a(str); 
    bg.a().b("updateDataPeriodDate", t.a());
  }
  
  public void a() {
    this.e.a();
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    if (MapsInitializer.getUpdateDataActiveEnable() && q.b())
      c(); 
  }
  
  public void a(Context paramContext) {
    new DisplayMetrics();
    DisplayMetrics displayMetrics = paramContext.getApplicationContext().getResources().getDisplayMetrics();
    try {
      Field field = displayMetrics.getClass().getField("densityDpi");
    } catch (SecurityException securityException) {
      cm.a(securityException, "Mediator", "initialize");
      securityException = null;
    } catch (NoSuchFieldException noSuchFieldException) {
      cm.a(noSuchFieldException, "Mediator", "initialize");
    } 
    if (noSuchFieldException != null) {
      int i;
      long l = (displayMetrics.widthPixels * displayMetrics.heightPixels);
      try {
        i = noSuchFieldException.getInt(displayMetrics);
      } catch (IllegalArgumentException illegalArgumentException) {
        cm.a(illegalArgumentException, "Mediator", "initialize");
        i = 160;
      } catch (IllegalAccessException illegalAccessException) {
        cm.a(illegalAccessException, "Mediator", "initialize");
      } 
      if (i <= 120) {
        q.m = 1;
      } else if (i <= 160) {
        q.m = 3;
      } else if (i <= 240) {
        q.m = 2;
      } else {
        i = l cmp 153600L;
        if (i > 0) {
          q.m = 2;
        } else if (i < 0) {
          q.m = 1;
        } else {
          q.m = 3;
        } 
      } 
    } else {
      int i = (displayMetrics.widthPixels * displayMetrics.heightPixels) cmp 153600L;
      if (i > 0) {
        q.m = 2;
      } else if (i < 0) {
        q.m = 1;
      } else {
        q.m = 3;
      } 
    } 
    if (q.m != 2)
      q.c = 18; 
    bg.a(paramContext);
    if (MapsInitializer.getUpdateDataActiveEnable()) {
      bg.a();
      bg.b("UpdateDataActiveEnable", true);
    } 
    bg.a();
    MapsInitializer.setUpdateDataActiveEnable(bg.a("UpdateDataActiveEnable", false));
    b();
  }
  
  public void a(boolean paramBoolean) {
    this.e.b(paramBoolean);
  }
  
  public class a {
    public bn<an> a = null;
    
    public boolean b = false;
    
    public boolean c = false;
    
    String d = "zh_cn";
    
    int e = 0;
    
    int f = 0;
    
    String g;
    
    String h = "SatelliteMap3";
    
    String i = "GridTmc3";
    
    String j = "SateliteTmc3";
    
    private boolean l = false;
    
    private boolean m = true;
    
    private Context n;
    
    private boolean o = false;
    
    private a(az this$0, Context param1Context) {
      if (param1Context == null)
        return; 
      this.n = param1Context;
      DisplayMetrics displayMetrics = new DisplayMetrics();
      ((WindowManager)param1Context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
      int i = displayMetrics.widthPixels / az.this.h.a + c();
      int j = displayMetrics.heightPixels / az.this.h.a + c();
      this.e = i * j + i + j;
      this.f = this.e / 8 + 1;
      i = this.f;
      if (i == 0) {
        this.f = 1;
      } else if (i > 5) {
        this.f = 5;
      } 
      a(param1Context, "zh_cn");
    }
    
    private void a(Context param1Context, String param1String) {
      if (this.a == null)
        this.a = new bn<an>(); 
      if (q.g == null || q.g.equals("")) {
        if (param1String.equals("zh_cn")) {
          this.g = "GridMapV3";
        } else if (param1String.equals("en")) {
          this.g = "GridMapEnV3";
        } 
      } else {
        this.g = q.g;
      } 
      an an = new an(this.k.h);
      an.j = new cb(this) {
          public String a(int param2Int1, int param2Int2, int param2Int3) {
            if (q.h == null || q.h.equals("")) {
              String str = ax.a().b();
              return String.format(Locale.US, str, new Object[] { Integer.valueOf(param2Int3), Integer.valueOf(param2Int1), Integer.valueOf(param2Int2), this.a.d });
            } 
            return String.format(Locale.US, q.h, new Object[] { Integer.valueOf(param2Int3), Integer.valueOf(param2Int1), Integer.valueOf(param2Int2) });
          }
        };
      if (q.h == null || q.h.equals("")) {
        an.h = true;
      } else {
        an.h = false;
      } 
      an.b = this.g;
      an.e = true;
      an.f = true;
      an.c = q.c;
      an.d = q.d;
      an.q = new bv(this.k, an);
      an.a(true);
      a(an, param1Context);
    }
    
    private void a(Canvas param1Canvas) {
      int j = this.a.size();
      for (int i = 0; i < j; i++) {
        an an = this.a.get(i);
        if (an != null && an.a())
          an.a(param1Canvas); 
      } 
    }
    
    private void b(Canvas param1Canvas) {
      if (this.m)
        this.k.f.a(param1Canvas); 
    }
    
    private int c() {
      return 3;
    }
    
    private void c(Canvas param1Canvas) {
      this.k.g.j.a(param1Canvas);
    }
    
    private void c(String param1String) {
      if (param1String.equals("") == true)
        return; 
      int j = this.a.size();
      for (int i = 0; i < j; i++) {
        an an = this.a.get(i);
        if (an != null && !an.b.equals(param1String) && an.e == true && an.a() == true)
          an.a(false); 
      } 
    }
    
    private void d() {
      int j = this.a.size();
      for (int i = 0; i < j; i++) {
        an an = this.a.get(i);
        if (an != null)
          an.l = i; 
      } 
    }
    
    private boolean d(String param1String) {
      bn<an> bn1 = this.a;
      if (bn1 == null)
        return false; 
      int j = bn1.size();
      for (int i = 0; i < j; i++) {
        an an = this.a.get(i);
        if (an != null && an.b.equals(param1String) == true)
          return true; 
      } 
      return false;
    }
    
    public void a() {
      if (this.k.e.a == null)
        return; 
      for (an an : this.k.e.a) {
        if (an != null)
          an.b(); 
      } 
      this.k.e.a.clear();
      this.k.e.a = null;
    }
    
    public void a(Canvas param1Canvas, Matrix param1Matrix, float param1Float1, float param1Float2) {
      try {
        return;
      } finally {
        param1Canvas = null;
        cm.a((Throwable)param1Canvas, "Mediator", "draw");
      } 
    }
    
    public void a(String param1String) {
      if (param1String != null) {
        if (param1String.equals(""))
          return; 
        if (this.d.equals(param1String))
          return; 
        if (!param1String.equals("zh_cn") && !param1String.equals("en"))
          return; 
        if (q.g == null || q.g.equals("")) {
          if (param1String.equals("zh_cn")) {
            this.g = "GridMapV3";
          } else if (param1String.equals("en")) {
            this.g = "GridMapEnV3";
          } 
        } else {
          this.g = q.g;
        } 
        az.a(this.k, b(this.g));
        if (az.a(this.k) == null) {
          az az1 = this.k;
          az.a(az1, new an(az1.h));
          an an = az.a(this.k);
          az az2 = this.k;
          an.q = new bv(az2, az.a(az2));
          (az.a(this.k)).j = new cb(this) {
              public String a(int param2Int1, int param2Int2, int param2Int3) {
                if (q.h == null || q.h.equals("")) {
                  String str = ax.a().b();
                  return String.format(Locale.US, str, new Object[] { Integer.valueOf(param2Int3), Integer.valueOf(param2Int1), Integer.valueOf(param2Int2), this.a.d });
                } 
                return String.format(Locale.US, q.h, new Object[] { Integer.valueOf(param2Int3), Integer.valueOf(param2Int1), Integer.valueOf(param2Int2) });
              }
            };
          if (q.h == null || q.h.equals("")) {
            (az.a(this.k)).h = true;
          } else {
            (az.a(this.k)).h = false;
          } 
          (az.a(this.k)).b = this.g;
          (az.a(this.k)).e = true;
          az.a(this.k).a(true);
          (az.a(this.k)).f = true;
          (az.a(this.k)).c = q.c;
          (az.a(this.k)).d = q.d;
          a(az.a(this.k), this.n);
        } 
        a(this.g, true);
        this.d = param1String;
      } 
    }
    
    public void a(boolean param1Boolean) {
      this.l = param1Boolean;
    }
    
    public boolean a(int param1Int, KeyEvent param1KeyEvent) {
      return false;
    }
    
    public boolean a(MotionEvent param1MotionEvent) {
      return false;
    }
    
    boolean a(an param1an, Context param1Context) {
      boolean bool1;
      boolean bool2 = false;
      if (param1an == null)
        return false; 
      if (param1an.b.equals("") == true)
        return false; 
      if (d(param1an.b) == true)
        return false; 
      param1an.p = new bn<bs>();
      param1an.n = new ba(this.e, this.f, param1an.g, param1an.i, param1an);
      param1an.o = new u(param1Context, (az.c.a(this.k.c)).d, param1an);
      param1an.o.a(param1an.n);
      int i = this.a.size();
      if (!param1an.e || i == 0) {
        bool1 = this.a.add(param1an);
      } else {
        i--;
        while (true) {
          bool1 = bool2;
          if (i >= 0) {
            an an1 = this.a.get(i);
            if (an1 != null && an1.e == true) {
              this.a.add(i, param1an);
              bool1 = bool2;
              break;
            } 
            i--;
            continue;
          } 
          break;
        } 
      } 
      d();
      if (param1an.a() == true)
        a(param1an.b, true); 
      return bool1;
    }
    
    boolean a(String param1String, boolean param1Boolean) {
      if (param1String.equals(""))
        return false; 
      int j = this.a.size();
      for (int i = 0; i < j; i++) {
        an an = this.a.get(i);
        if (an != null && an.b.equals(param1String) == true) {
          an.a(param1Boolean);
          if (!an.e)
            return true; 
          if (param1Boolean == true) {
            if (an.c > an.d) {
              this.k.c.a(an.c);
              this.k.c.b(an.d);
            } 
            c(param1String);
            this.k.c.a(false, false);
            return true;
          } 
        } 
      } 
      return false;
    }
    
    an b(String param1String) {
      if (param1String.equals("") != true) {
        bn<an> bn1 = this.a;
        if (bn1 != null) {
          if (bn1.size() == 0)
            return null; 
          int j = this.a.size();
          for (int i = 0; i < j; i++) {
            an an = this.a.get(i);
            if (an != null && an.b.equals(param1String) == true)
              return an; 
          } 
        } 
      } 
      return null;
    }
    
    public void b() {
      if (this.k.c != null) {
        if (az.c.a(this.k.c) == null)
          return; 
        az.c.a(this.k.c).postInvalidate();
      } 
    }
    
    public void b(boolean param1Boolean) {
      this.m = param1Boolean;
    }
    
    public boolean b(int param1Int, KeyEvent param1KeyEvent) {
      return false;
    }
    
    protected boolean b(MotionEvent param1MotionEvent) {
      return false;
    }
  }
  
  class null implements cb {
    null(az this$0) {}
    
    public String a(int param1Int1, int param1Int2, int param1Int3) {
      if (q.h == null || q.h.equals("")) {
        String str = ax.a().b();
        return String.format(Locale.US, str, new Object[] { Integer.valueOf(param1Int3), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2), this.a.d });
      } 
      return String.format(Locale.US, q.h, new Object[] { Integer.valueOf(param1Int3), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2) });
    }
  }
  
  class null implements cb {
    null(az this$0) {}
    
    public String a(int param1Int1, int param1Int2, int param1Int3) {
      if (q.h == null || q.h.equals("")) {
        String str = ax.a().b();
        return String.format(Locale.US, str, new Object[] { Integer.valueOf(param1Int3), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2), this.a.d });
      } 
      return String.format(Locale.US, q.h, new Object[] { Integer.valueOf(param1Int3), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2) });
    }
  }
  
  public class b {
    public boolean a = false;
    
    int b = 0;
    
    public b(az this$0) {
      e();
    }
    
    public void a() {
      if (az.a.a(this.c.e))
        this.c.e.b(); 
      int i = ++this.b;
      if (i >= 20) {
        if (i % 20 != 0)
          return; 
        if (this.c.e.a != null) {
          if (this.c.e.a.size() == 0)
            return; 
          int j = this.c.e.a.size();
          for (i = 0; i < j; i++)
            ((an)this.c.e.a.get(i)).q.i(); 
        } 
      } 
    }
    
    public void b() {
      az.c c = this.c.c;
      int i = 0;
      c.a = false;
      if (this.c.e.a != null) {
        if (this.c.e.a.size() == 0)
          return; 
        int j = this.c.e.a.size();
        while (i < j) {
          ((an)this.c.e.a.get(i)).q.b();
          i++;
        } 
      } 
    }
    
    public void c() {
      if (this.c.e.a != null) {
        if (this.c.e.a.size() == 0)
          return; 
        try {
          int i;
          int j = this.c.e.a.size();
          return;
        } finally {
          Exception exception = null;
        } 
      } 
    }
    
    public void d() {
      if (this.c.e.a != null) {
        if (this.c.e.a.size() == 0)
          return; 
        int j = this.c.e.a.size();
        for (int i = 0; i < j; i++) {
          an an = this.c.e.a.get(i);
          if (an != null) {
            bv bv = an.q;
            if (bv != null)
              bv.c(); 
          } 
        } 
      } 
    }
    
    public void e() {
      if (this.c.e.a != null) {
        if (this.c.e.a.size() == 0)
          return; 
        int j = this.c.e.a.size();
        for (int i = 0; i < j; i++) {
          an an = this.c.e.a.get(i);
          if (an != null) {
            bv bv = an.q;
            if (bv != null)
              bv.h(); 
          } 
        } 
      } 
    }
  }
  
  public class c {
    public boolean a = true;
    
    private b c;
    
    private ArrayList<cc> d;
    
    private c(az this$0, b param1b) {
      this.c = param1b;
      this.d = new ArrayList<cc>();
    }
    
    public int a() {
      try {
        return this.b.h.i;
      } finally {
        Exception exception = null;
        cm.a(exception, "Mediator", "getMaxZoomLevel");
      } 
    }
    
    public void a(float param1Float) {
      if (param1Float != this.b.h.j) {
        this.b.h.j = param1Float;
        int i = (int)param1Float;
        double d1 = this.b.h.d / (1 << i);
        float f = param1Float - i;
        double d2 = f;
        if (d2 < az.a) {
          this.b.h.a = (int)(this.b.h.b * (d2 * 0.4D + 1.0D));
          d2 = this.b.h.a / this.b.h.b;
        } else {
          this.b.h.a = (int)(this.b.h.b / 2.0F / (2.0F - (1.0F - f) * 0.4F));
          d2 = this.b.h.a / this.b.h.b;
          d1 /= 2.0D;
        } 
        d1 /= d2;
        this.b.h.k = d1;
        this.b.g.c[1] = param1Float;
        this.b.g.f.a(param1Float);
      } 
      a(false, false);
    }
    
    public void a(int param1Int) {
      if (param1Int <= 0)
        return; 
      try {
        return;
      } finally {
        Exception exception = null;
        cm.a(exception, "Mediator", "setMaxZoomLevel");
      } 
    }
    
    public void a(int param1Int1, int param1Int2) {
      if (param1Int1 != q.n || param1Int2 != q.o) {
        q.n = param1Int1;
        q.o = param1Int2;
        a(true, false);
      } 
    }
    
    public void a(cc param1cc) {
      this.d.add(param1cc);
    }
    
    public void a(w param1w) {
      if (param1w == null)
        return; 
      if (q.s == true) {
        param1w = this.b.h.a(param1w);
        this.b.h.l = param1w;
      } 
      a(false, false);
    }
    
    public void a(boolean param1Boolean1, boolean param1Boolean2) {
      Iterator<cc> iterator = this.d.iterator();
      while (iterator.hasNext())
        ((cc)iterator.next()).a(param1Boolean1, param1Boolean2); 
      if (this.b.g != null && this.b.g.i != null) {
        this.b.g.i.a(true);
        this.b.g.postInvalidate();
      } 
    }
    
    public int b() {
      try {
        return this.b.h.h;
      } finally {
        Exception exception = null;
        cm.a(exception, "Mediator", "getMinZoomLevel");
      } 
    }
    
    public void b(int param1Int) {
      if (param1Int <= 0)
        return; 
      try {
        return;
      } finally {
        Exception exception = null;
        cm.a(exception, "Mediator", "setMinZoomLevel");
      } 
    }
    
    public void b(cc param1cc) {
      this.d.remove(param1cc);
    }
    
    public void b(w param1w) {
      w w1 = this.b.c.f();
      if (param1w != null && !param1w.equals(w1)) {
        if (q.s == true) {
          param1w = this.b.h.a(param1w);
          this.b.h.l = param1w;
        } 
        a(false, true);
      } 
    }
    
    public int c() {
      return q.n;
    }
    
    public int d() {
      return q.o;
    }
    
    public float e() {
      try {
        return this.b.h.j;
      } finally {
        Exception exception = null;
        cm.a(exception, "Mediator", "getZoomLevel");
      } 
    }
    
    public w f() {
      w w2 = this.b.h.b(this.b.h.l);
      w w1 = w2;
      if (this.b.d != null) {
        w1 = w2;
        if (this.b.d.a)
          w1 = this.b.h.m; 
      } 
      return w1;
    }
    
    public b g() {
      return this.c;
    }
  }
  
  public class d implements bh {
    private float b = 0.0F;
    
    private HashMap<Float, Float> c = new HashMap<Float, Float>();
    
    public d(az this$0) {}
    
    private int a(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {
      if (param1Int1 <= 0)
        param1Int1 = this.a.c.c(); 
      if (param1Int2 <= 0)
        param1Int2 = this.a.c.d(); 
      w w1 = a(param1Int3, param1Int2 - param1Int3);
      w w2 = a(param1Int1 - param1Int3, param1Int3);
      return param1Boolean ? Math.abs(w1.a() - w2.a()) : Math.abs(w1.b() - w2.b());
    }
    
    public float a(float param1Float) {
      float f = this.a.c.e();
      if (this.c.size() > 30 || f != this.b) {
        this.b = f;
        this.c.clear();
      } 
      if (!this.c.containsKey(Float.valueOf(param1Float))) {
        w w1 = a(0, 0);
        w w2 = a(0, 100);
        f = this.a.h.a(w1, w2);
        if (f <= 0.0F)
          return 0.0F; 
        f = param1Float / f;
        this.c.put(Float.valueOf(param1Float), Float.valueOf(f * 100.0F));
      } 
      return ((Float)this.c.get(Float.valueOf(param1Float))).floatValue();
    }
    
    public int a(int param1Int1, int param1Int2, int param1Int3) {
      return a(param1Int1, param1Int2, param1Int3, false);
    }
    
    public Point a(w param1w, Point param1Point) {
      int i;
      int j;
      if (param1w == null)
        return null; 
      PointF pointF = this.a.h.b(param1w, this.a.h.l, this.a.h.n, this.a.h.k);
      bb bb = az.c.a(this.a.c).l();
      Point point2 = (az.c.a(this.a.c).a()).h.n;
      if (bb.m) {
        boolean bool;
        try {
          bool = this.a.g.h.isZoomGesturesEnabled();
        } catch (RemoteException remoteException) {
          remoteException.printStackTrace();
          bool = true;
        } 
        if (bb.l && bool) {
          float f1 = bb.j * ((int)pointF.x - bb.f.x) + bb.f.x + bb.g.x - bb.f.x;
          float f2 = bb.j * ((int)pointF.y - bb.f.y) + bb.f.y + bb.g.y - bb.f.y;
          i = (int)f1;
          int m = (int)f2;
          int k = i;
          if (f1 >= i + 0.5D)
            k = i + 1; 
          i = m;
          j = k;
          if (f2 >= m + 0.5D) {
            i = m + 1;
            j = k;
          } 
        } else {
          j = (int)pointF.x;
          i = (int)pointF.y;
        } 
      } else {
        float f1 = this.a.h.c * ((int)pointF.x - ((Point)remoteException).x) + ((Point)remoteException).x;
        float f2 = this.a.h.c * ((int)pointF.y - ((Point)remoteException).y) + ((Point)remoteException).y;
        j = (int)f1;
        i = (int)f2;
        int k = j;
        if (f1 >= j + 0.5D)
          k = j + 1; 
        if (f2 >= i + 0.5D) {
          i++;
          j = k;
        } else {
          j = k;
        } 
      } 
      Point point1 = new Point(j, i);
      if (param1Point != null) {
        param1Point.x = point1.x;
        param1Point.y = point1.y;
      } 
      return point1;
    }
    
    public w a(int param1Int1, int param1Int2) {
      PointF pointF = new PointF(param1Int1, param1Int2);
      return this.a.h.a(pointF, this.a.h.l, this.a.h.n, this.a.h.k, this.a.h.o);
    }
    
    public int b(int param1Int1, int param1Int2, int param1Int3) {
      return a(param1Int1, param1Int2, param1Int3, true);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */