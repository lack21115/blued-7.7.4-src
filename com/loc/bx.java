package com.loc;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bx {
  private cw a;
  
  private cw b;
  
  private dc c;
  
  private a d = new a();
  
  private final List<cw> e = new ArrayList<cw>(3);
  
  final a a(dc paramdc, boolean paramBoolean, byte paramByte, String paramString, List<cw> paramList) {
    cw cw1;
    if (paramBoolean) {
      this.d.a();
      return null;
    } 
    a a1 = this.d;
    a1.a();
    a1.a = paramByte;
    a1.b = paramString;
    if (paramList != null) {
      a1.f.addAll(paramList);
      for (cw cw2 : a1.f) {
        if (!cw2.i && cw2.h) {
          a1.d = cw2;
          continue;
        } 
        if (cw2.i && cw2.h)
          a1.e = cw2; 
      } 
    } 
    if (a1.d == null) {
      cw1 = a1.e;
    } else {
      cw1 = a1.d;
    } 
    a1.c = cw1;
    if (this.d.c == null)
      return null; 
    dc dc1 = this.c;
    byte b2 = 1;
    byte b1 = b2;
    if (dc1 != null) {
      float f;
      boolean bool;
      if (paramdc.g > 10.0F) {
        f = 2000.0F;
      } else if (paramdc.g > 2.0F) {
        f = 500.0F;
      } else {
        f = 100.0F;
      } 
      if (paramdc.a(this.c) > f) {
        bool = true;
      } else {
        bool = false;
      } 
      b1 = b2;
      if (!bool) {
        b1 = b2;
        if (a.a(this.d.d, this.a))
          if (!a.a(this.d.e, this.b)) {
            b1 = b2;
          } else {
            b1 = 0;
          }  
      } 
    } 
    if (b1) {
      this.a = this.d.d;
      this.b = this.d.e;
      this.c = paramdc;
      ct.a(this.d.f);
      null = this.d;
      synchronized (this.e) {
        Iterator<cw> iterator = null.f.iterator();
        while (true) {
          if (iterator.hasNext()) {
            cw cw2 = iterator.next();
            if (cw2 != null && cw2.h) {
              cw cw3 = cw2.a();
              cw3.e = SystemClock.elapsedRealtime();
              int j = this.e.size();
              if (j == 0) {
                List<cw> list = this.e;
                continue;
              } 
              long l = Long.MAX_VALUE;
              int i = 0;
              b1 = -1;
              while (true) {
                b2 = b1;
                i++;
              } 
              break;
            } 
            continue;
          } 
          this.d.g.clear();
          this.d.g.addAll(this.e);
          return this.d;
        } 
      } 
    } 
    return null;
  }
  
  public static final class a {
    public byte a;
    
    public String b;
    
    public cw c;
    
    public cw d;
    
    public cw e;
    
    public List<cw> f = new ArrayList<cw>();
    
    public List<cw> g = new ArrayList<cw>();
    
    public static boolean a(cw param1cw1, cw param1cw2) {
      if (param1cw1 == null || param1cw2 == null) {
        boolean bool1;
        boolean bool2;
        if (param1cw1 == null) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (param1cw2 == null) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        return (bool1 == bool2);
      } 
      if (param1cw1 instanceof cy && param1cw2 instanceof cy) {
        param1cw1 = param1cw1;
        param1cw2 = param1cw2;
        return (((cy)param1cw1).j == ((cy)param1cw2).j && ((cy)param1cw1).k == ((cy)param1cw2).k);
      } 
      if (param1cw1 instanceof cx && param1cw2 instanceof cx) {
        param1cw1 = param1cw1;
        param1cw2 = param1cw2;
        return (((cx)param1cw1).l == ((cx)param1cw2).l && ((cx)param1cw1).k == ((cx)param1cw2).k && ((cx)param1cw1).j == ((cx)param1cw2).j);
      } 
      if (param1cw1 instanceof cz && param1cw2 instanceof cz) {
        param1cw1 = param1cw1;
        param1cw2 = param1cw2;
        return (((cz)param1cw1).j == ((cz)param1cw2).j && ((cz)param1cw1).k == ((cz)param1cw2).k);
      } 
      if (param1cw1 instanceof da && param1cw2 instanceof da) {
        param1cw1 = param1cw1;
        param1cw2 = param1cw2;
        if (((da)param1cw1).j == ((da)param1cw2).j && ((da)param1cw1).k == ((da)param1cw2).k)
          return true; 
      } 
      return false;
    }
    
    public final void a() {
      this.a = 0;
      this.b = "";
      this.c = null;
      this.d = null;
      this.e = null;
      this.f.clear();
      this.g.clear();
    }
    
    public final String toString() {
      StringBuilder stringBuilder = new StringBuilder("CellInfo{radio=");
      stringBuilder.append(this.a);
      stringBuilder.append(", operator='");
      stringBuilder.append(this.b);
      stringBuilder.append('\'');
      stringBuilder.append(", mainCell=");
      stringBuilder.append(this.c);
      stringBuilder.append(", mainOldInterCell=");
      stringBuilder.append(this.d);
      stringBuilder.append(", mainNewInterCell=");
      stringBuilder.append(this.e);
      stringBuilder.append(", cells=");
      stringBuilder.append(this.f);
      stringBuilder.append(", historyMainCellList=");
      stringBuilder.append(this.g);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */