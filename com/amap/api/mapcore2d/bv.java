package com.amap.api.mapcore2d;

import com.amap.api.maps2d.AMapException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bv extends f<bs, bs> implements cc {
  private an c;
  
  private am d = new am();
  
  public bv(az paramaz, an paraman) {
    super(paramaz);
    this.c = paraman;
    this.a = new br();
    this.b.c.a(this);
    a();
  }
  
  private ArrayList<bs> a(ArrayList<bs> paramArrayList, an paraman, float paramFloat, boolean paramBoolean) {
    ArrayList<bs> arrayList = new ArrayList();
    if (paramArrayList != null) {
      if (paraman == null)
        return null; 
      if (!paraman.a())
        return null; 
      if (paraman.p == null)
        return null; 
      paraman.p.clear();
      if (paramFloat <= paraman.c) {
        if (paramFloat < paraman.d)
          return null; 
        int j = paramArrayList.size();
        if (j <= 0)
          return null; 
        int i = 0;
        while (true) {
          if (i < j) {
            try {
              bs bs = paramArrayList.get(i);
              if (bs != null) {
                int k = paraman.n.a(bs.c());
                bs bs1 = new bs(bs.b, bs.c, bs.d, paraman.l);
                bs1.h = k;
                bs1.g = bs.g;
                paraman.p.add(bs1);
                if (a(bs1) && !paramBoolean && !this.d.contains(bs1)) {
                  if (!paraman.f)
                    bs1.a = -1; 
                  arrayList.add(bs1);
                } 
              } 
            } finally {
              paramArrayList = null;
            } 
            continue;
          } 
          return arrayList;
        } 
      } 
    } 
    return null;
  }
  
  private void a(ArrayList<bs> paramArrayList, boolean paramBoolean) {
    if (this.a != null) {
      if (paramArrayList == null)
        return; 
      if (paramArrayList.size() != 0)
        this.a.a(paramArrayList, paramBoolean); 
    } 
  }
  
  private boolean a(bs parambs) {
    return (parambs == null || parambs.h < 0);
  }
  
  private void c(ArrayList<bs> paramArrayList) {
    if (paramArrayList != null) {
      if (this.d == null)
        return; 
      int j = paramArrayList.size();
      if (j == 0)
        return; 
      for (int i = 0; i < j; i++)
        this.d.a(paramArrayList.get(i)); 
    } 
  }
  
  private boolean j() {
    return (this.b != null) ? ((this.b.e == null) ? false : ((this.b.e.a == null) ? false : ((this.b.e.a.size() <= 0) ? false : this.c.a()))) : false;
  }
  
  protected ArrayList<bs> a(ArrayList<bs> paramArrayList) throws AMapException {
    ArrayList<bs> arrayList2;
    bw bw2 = null;
    ArrayList<bs> arrayList1 = null;
    bw bw1 = bw2;
    if (paramArrayList != null) {
      if (paramArrayList.size() == 0)
        return null; 
      bw1 = bw2;
      if (this.b != null) {
        bw1 = bw2;
        if (this.b.e != null) {
          if (this.b.e.a == null)
            return null; 
          a(paramArrayList);
          if (paramArrayList.size() == 0)
            return null; 
          if (this.c.j != null || this.c.k != null) {
            bw1 = new bw(paramArrayList, this.c.k);
            bw1.a(this.c);
            arrayList1 = bw1.a();
            bw1.a((an)null);
          } 
          c(paramArrayList);
          arrayList2 = arrayList1;
          if (this.b != null) {
            if (this.b.e == null)
              return arrayList1; 
            this.b.e.b();
            arrayList2 = arrayList1;
          } 
        } 
      } 
    } 
    return arrayList2;
  }
  
  public void a(List<bs> paramList) {
    if (paramList == null)
      return; 
    int j = paramList.size();
    if (j == 0)
      return; 
    int i = 0;
    while (i < j) {
      int k = j;
      int m = i;
      if (!this.d.b(paramList.get(i))) {
        paramList.remove(i);
        m = i - 1;
        k = j - 1;
      } 
      i = m + 1;
      j = k;
    } 
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    try {
      if (!j())
        return; 
      ArrayList<bs> arrayList1 = this.b.h.a(this.b.h.l, this.b.h.b(), this.b.c.c(), this.b.c.d());
      if (arrayList1 == null)
        return; 
      if (arrayList1.size() <= 0)
        return; 
      ArrayList<bs> arrayList2 = a(arrayList1, this.c, this.b.c.e(), paramBoolean2);
      if (arrayList2 != null) {
        a(arrayList2, true);
        arrayList2.clear();
      } 
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  protected ArrayList<bs> b(ArrayList<bs> paramArrayList) {
    if (paramArrayList == null)
      return null; 
    int k = paramArrayList.size();
    if (k == 0)
      return null; 
    int j = 0;
    Iterator<bs> iterator = null;
    int i = -1;
    while (true) {
      ArrayList<bs> arrayList;
      if (j < k) {
        ArrayList<bs> arrayList1;
        Iterator<bs> iterator1 = iterator;
        try {
          bs bs = paramArrayList.get(j);
          if (bs != null) {
            iterator1 = iterator;
            if (this.b != null) {
              iterator1 = iterator;
              if (this.b.e != null) {
                iterator1 = iterator;
                if (this.b.e.a == null)
                  return null; 
                iterator1 = iterator;
                this.b.e.a.size();
                iterator1 = iterator;
                boolean bool = this.c.f;
                if (bool) {
                  try {
                  
                  } finally {
                    Exception exception = null;
                    iterator1 = iterator;
                  } 
                  if (i >= 0) {
                    iterator1 = iterator;
                    paramArrayList.remove(j);
                    k--;
                    j--;
                    iterator1 = iterator;
                    bn<bs> bn = this.c.p;
                    if (bn != null)
                      synchronized (iterator) {
                        for (bs bs1 : bn) {
                          if (bs1 != null && bs1.equals(bs)) {
                            bs1.h = i;
                            this.b.e.b();
                            break;
                          } 
                        } 
                        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{com/amap/api/mapcore2d/bn<ObjectType{com/amap/api/mapcore2d/bs}>}, name=null} */
                      }  
                  } else {
                    ArrayList<bs> arrayList2;
                    Iterator<bs> iterator2 = iterator;
                    if (iterator == null) {
                      iterator1 = iterator;
                      arrayList2 = new ArrayList();
                    } 
                    arrayList1 = arrayList2;
                    bs bs1 = new bs(bs);
                    arrayList1 = arrayList2;
                    bs1.a = -1;
                    arrayList1 = arrayList2;
                    arrayList2.add(bs1);
                    arrayList = arrayList2;
                  } 
                } 
              } else {
                return null;
              } 
            } else {
              return null;
            } 
          } 
        } finally {
          paramArrayList = null;
        } 
        continue;
      } 
      return arrayList;
    } 
  }
  
  public void b() {
    super.b();
    this.d.clear();
    if (this.b != null && this.b.c != null)
      this.b.c.b(this); 
    this.b = null;
  }
  
  protected int f() {
    return 4;
  }
  
  protected int g() {
    return 1;
  }
  
  public void i() {
    a(false, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */