package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

class AdapterHelper implements OpReorderer.Callback {
  final ArrayList<UpdateOp> a = new ArrayList<UpdateOp>();
  
  final ArrayList<UpdateOp> b = new ArrayList<UpdateOp>();
  
  final Callback c;
  
  Runnable d;
  
  final boolean e;
  
  final OpReorderer f;
  
  private Pools.Pool<UpdateOp> g = (Pools.Pool<UpdateOp>)new Pools.SimplePool(30);
  
  private int h = 0;
  
  AdapterHelper(Callback paramCallback) {
    this(paramCallback, false);
  }
  
  AdapterHelper(Callback paramCallback, boolean paramBoolean) {
    this.c = paramCallback;
    this.e = paramBoolean;
    this.f = new OpReorderer(this);
  }
  
  private void a(UpdateOp paramUpdateOp) {
    f(paramUpdateOp);
  }
  
  private void b(UpdateOp paramUpdateOp) {
    int m = paramUpdateOp.b;
    int j = paramUpdateOp.b + paramUpdateOp.d;
    int i = paramUpdateOp.b;
    int k = 0;
    byte b = -1;
    while (i < j) {
      int n;
      if (this.c.findViewHolder(i) != null || c(i)) {
        if (b == 0) {
          d(obtainUpdateOp(2, m, k, null));
          n = 1;
        } else {
          n = 0;
        } 
        b = 1;
      } else {
        if (b == 1) {
          f(obtainUpdateOp(2, m, k, null));
          b = 1;
        } else {
          b = 0;
        } 
        boolean bool = false;
        n = b;
        b = bool;
      } 
      if (n != 0) {
        i -= k;
        j -= k;
        n = 1;
      } else {
        n = k + 1;
      } 
      i++;
      k = n;
    } 
    UpdateOp updateOp = paramUpdateOp;
    if (k != paramUpdateOp.d) {
      recycleUpdateOp(paramUpdateOp);
      updateOp = obtainUpdateOp(2, m, k, null);
    } 
    if (b == 0) {
      d(updateOp);
      return;
    } 
    f(updateOp);
  }
  
  private void c(UpdateOp paramUpdateOp) {
    int k = paramUpdateOp.b;
    int n = paramUpdateOp.b;
    int i1 = paramUpdateOp.d;
    int i = paramUpdateOp.b;
    int j = 0;
    int m;
    for (m = -1; i < n + i1; m = i2) {
      int i2;
      int i3;
      if (this.c.findViewHolder(i) != null || c(i)) {
        i3 = j;
        int i4 = k;
        if (m == 0) {
          d(obtainUpdateOp(4, k, j, paramUpdateOp.c));
          i4 = i;
          i3 = 0;
        } 
        i2 = 1;
        k = i4;
      } else {
        i3 = j;
        i2 = k;
        if (m == 1) {
          f(obtainUpdateOp(4, k, j, paramUpdateOp.c));
          i2 = i;
          i3 = 0;
        } 
        j = 0;
        k = i2;
        i2 = j;
      } 
      j = i3 + 1;
      i++;
    } 
    Object object = paramUpdateOp;
    if (j != paramUpdateOp.d) {
      object = paramUpdateOp.c;
      recycleUpdateOp(paramUpdateOp);
      object = obtainUpdateOp(4, k, j, object);
    } 
    if (m == 0) {
      d((UpdateOp)object);
      return;
    } 
    f((UpdateOp)object);
  }
  
  private boolean c(int paramInt) {
    int j = this.b.size();
    for (int i = 0; i < j; i++) {
      UpdateOp updateOp = this.b.get(i);
      if (updateOp.a == 8) {
        if (a(updateOp.d, i + 1) == paramInt)
          return true; 
      } else if (updateOp.a == 1) {
        int m = updateOp.b;
        int n = updateOp.d;
        for (int k = updateOp.b; k < m + n; k++) {
          if (a(k, i + 1) == paramInt)
            return true; 
        } 
      } 
    } 
    return false;
  }
  
  private int d(int paramInt1, int paramInt2) {
    int i = this.b.size() - 1;
    int j;
    for (j = paramInt1; i >= 0; j = paramInt1) {
      UpdateOp updateOp = this.b.get(i);
      if (updateOp.a == 8) {
        int k;
        if (updateOp.b < updateOp.d) {
          paramInt1 = updateOp.b;
          k = updateOp.d;
        } else {
          paramInt1 = updateOp.d;
          k = updateOp.b;
        } 
        if (j >= paramInt1 && j <= k) {
          if (paramInt1 == updateOp.b) {
            if (paramInt2 == 1) {
              updateOp.d++;
            } else if (paramInt2 == 2) {
              updateOp.d--;
            } 
            paramInt1 = j + 1;
          } else {
            if (paramInt2 == 1) {
              updateOp.b++;
            } else if (paramInt2 == 2) {
              updateOp.b--;
            } 
            paramInt1 = j - 1;
          } 
        } else {
          paramInt1 = j;
          if (j < updateOp.b)
            if (paramInt2 == 1) {
              updateOp.b++;
              updateOp.d++;
              paramInt1 = j;
            } else {
              paramInt1 = j;
              if (paramInt2 == 2) {
                updateOp.b--;
                updateOp.d--;
                paramInt1 = j;
              } 
            }  
        } 
      } else if (updateOp.b <= j) {
        if (updateOp.a == 1) {
          paramInt1 = j - updateOp.d;
        } else {
          paramInt1 = j;
          if (updateOp.a == 2)
            paramInt1 = j + updateOp.d; 
        } 
      } else if (paramInt2 == 1) {
        updateOp.b++;
        paramInt1 = j;
      } else {
        paramInt1 = j;
        if (paramInt2 == 2) {
          updateOp.b--;
          paramInt1 = j;
        } 
      } 
      i--;
    } 
    for (paramInt1 = this.b.size() - 1; paramInt1 >= 0; paramInt1--) {
      UpdateOp updateOp = this.b.get(paramInt1);
      if (updateOp.a == 8) {
        if (updateOp.d == updateOp.b || updateOp.d < 0) {
          this.b.remove(paramInt1);
          recycleUpdateOp(updateOp);
        } 
      } else if (updateOp.d <= 0) {
        this.b.remove(paramInt1);
        recycleUpdateOp(updateOp);
      } 
    } 
    return j;
  }
  
  private void d(UpdateOp paramUpdateOp) {
    if (paramUpdateOp.a != 1 && paramUpdateOp.a != 8) {
      byte b;
      int m = d(paramUpdateOp.b, paramUpdateOp.a);
      int i = paramUpdateOp.b;
      int j = paramUpdateOp.a;
      if (j != 2) {
        if (j == 4) {
          b = 1;
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("op should be remove or update.");
          stringBuilder.append(paramUpdateOp);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } else {
        b = 0;
      } 
      int k = 1;
      int n;
      for (n = 1; k < paramUpdateOp.d; n = j) {
        int i1 = d(paramUpdateOp.b + b * k, paramUpdateOp.a);
        j = paramUpdateOp.a;
        if ((j != 2) ? (j == 4 && i1 == m + 1) : (i1 == m)) {
          j = 1;
        } else {
          j = 0;
        } 
        if (j != 0) {
          j = n + 1;
        } else {
          UpdateOp updateOp = obtainUpdateOp(paramUpdateOp.a, m, n, paramUpdateOp.c);
          a(updateOp, i);
          recycleUpdateOp(updateOp);
          j = i;
          if (paramUpdateOp.a == 4)
            j = i + n; 
          m = i1;
          n = 1;
          i = j;
          j = n;
        } 
        k++;
      } 
      Object object = paramUpdateOp.c;
      recycleUpdateOp(paramUpdateOp);
      if (n > 0) {
        paramUpdateOp = obtainUpdateOp(paramUpdateOp.a, m, n, object);
        a(paramUpdateOp, i);
        recycleUpdateOp(paramUpdateOp);
      } 
      return;
    } 
    throw new IllegalArgumentException("should not dispatch add or move for pre layout");
  }
  
  private void e(UpdateOp paramUpdateOp) {
    f(paramUpdateOp);
  }
  
  private void f(UpdateOp paramUpdateOp) {
    this.b.add(paramUpdateOp);
    int i = paramUpdateOp.a;
    if (i != 1) {
      if (i != 2) {
        if (i != 4) {
          if (i == 8) {
            this.c.offsetPositionsForMove(paramUpdateOp.b, paramUpdateOp.d);
            return;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown update op type for ");
          stringBuilder.append(paramUpdateOp);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        this.c.markViewHoldersUpdated(paramUpdateOp.b, paramUpdateOp.d, paramUpdateOp.c);
        return;
      } 
      this.c.offsetPositionsForRemovingLaidOutOrNewView(paramUpdateOp.b, paramUpdateOp.d);
      return;
    } 
    this.c.offsetPositionsForAdd(paramUpdateOp.b, paramUpdateOp.d);
  }
  
  int a(int paramInt1, int paramInt2) {
    int j = this.b.size();
    int i = paramInt2;
    for (paramInt2 = paramInt1; i < j; paramInt2 = paramInt1) {
      UpdateOp updateOp = this.b.get(i);
      if (updateOp.a == 8) {
        if (updateOp.b == paramInt2) {
          paramInt1 = updateOp.d;
        } else {
          int k = paramInt2;
          if (updateOp.b < paramInt2)
            k = paramInt2 - 1; 
          paramInt1 = k;
          if (updateOp.d <= k)
            paramInt1 = k + 1; 
        } 
      } else {
        paramInt1 = paramInt2;
        if (updateOp.b <= paramInt2)
          if (updateOp.a == 2) {
            if (paramInt2 < updateOp.b + updateOp.d)
              return -1; 
            paramInt1 = paramInt2 - updateOp.d;
          } else {
            paramInt1 = paramInt2;
            if (updateOp.a == 1)
              paramInt1 = paramInt2 + updateOp.d; 
          }  
      } 
      i++;
    } 
    return paramInt2;
  }
  
  void a() {
    a(this.a);
    a(this.b);
    this.h = 0;
  }
  
  void a(UpdateOp paramUpdateOp, int paramInt) {
    this.c.onDispatchFirstPass(paramUpdateOp);
    int i = paramUpdateOp.a;
    if (i != 2) {
      if (i == 4) {
        this.c.markViewHoldersUpdated(paramInt, paramUpdateOp.d, paramUpdateOp.c);
        return;
      } 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    } 
    this.c.offsetPositionsForRemovingInvisible(paramInt, paramUpdateOp.d);
  }
  
  void a(List<UpdateOp> paramList) {
    int j = paramList.size();
    for (int i = 0; i < j; i++)
      recycleUpdateOp(paramList.get(i)); 
    paramList.clear();
  }
  
  boolean a(int paramInt) {
    return ((paramInt & this.h) != 0);
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool = false;
    if (paramInt1 == paramInt2)
      return false; 
    if (paramInt3 == 1) {
      this.a.add(obtainUpdateOp(8, paramInt1, paramInt2, null));
      this.h |= 0x8;
      if (this.a.size() == 1)
        bool = true; 
      return bool;
    } 
    throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
  }
  
  boolean a(int paramInt1, int paramInt2, Object paramObject) {
    boolean bool = false;
    if (paramInt2 < 1)
      return false; 
    this.a.add(obtainUpdateOp(4, paramInt1, paramInt2, paramObject));
    this.h |= 0x4;
    if (this.a.size() == 1)
      bool = true; 
    return bool;
  }
  
  public int applyPendingUpdatesToPosition(int paramInt) {
    int k = this.a.size();
    int j = 0;
    int i;
    for (i = paramInt; j < k; i = paramInt) {
      UpdateOp updateOp = this.a.get(j);
      paramInt = updateOp.a;
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 8) {
            paramInt = i;
          } else if (updateOp.b == i) {
            paramInt = updateOp.d;
          } else {
            int m = i;
            if (updateOp.b < i)
              m = i - 1; 
            paramInt = m;
            if (updateOp.d <= m)
              paramInt = m + 1; 
          } 
        } else {
          paramInt = i;
          if (updateOp.b <= i) {
            if (updateOp.b + updateOp.d > i)
              return -1; 
            paramInt = i - updateOp.d;
          } 
        } 
      } else {
        paramInt = i;
        if (updateOp.b <= i)
          paramInt = i + updateOp.d; 
      } 
      j++;
    } 
    return i;
  }
  
  int b(int paramInt) {
    return a(paramInt, 0);
  }
  
  void b() {
    this.f.a(this.a);
    int j = this.a.size();
    for (int i = 0; i < j; i++) {
      UpdateOp updateOp = this.a.get(i);
      int k = updateOp.a;
      if (k != 1) {
        if (k != 2) {
          if (k != 4) {
            if (k == 8)
              a(updateOp); 
          } else {
            c(updateOp);
          } 
        } else {
          b(updateOp);
        } 
      } else {
        e(updateOp);
      } 
      Runnable runnable = this.d;
      if (runnable != null)
        runnable.run(); 
    } 
    this.a.clear();
  }
  
  boolean b(int paramInt1, int paramInt2) {
    boolean bool = false;
    if (paramInt2 < 1)
      return false; 
    this.a.add(obtainUpdateOp(1, paramInt1, paramInt2, null));
    this.h |= 0x1;
    if (this.a.size() == 1)
      bool = true; 
    return bool;
  }
  
  void c() {
    int j = this.b.size();
    for (int i = 0; i < j; i++)
      this.c.onDispatchSecondPass(this.b.get(i)); 
    a(this.b);
    this.h = 0;
  }
  
  boolean c(int paramInt1, int paramInt2) {
    boolean bool = false;
    if (paramInt2 < 1)
      return false; 
    this.a.add(obtainUpdateOp(2, paramInt1, paramInt2, null));
    this.h |= 0x2;
    if (this.a.size() == 1)
      bool = true; 
    return bool;
  }
  
  boolean d() {
    return (this.a.size() > 0);
  }
  
  void e() {
    c();
    int j = this.a.size();
    for (int i = 0; i < j; i++) {
      UpdateOp updateOp = this.a.get(i);
      int k = updateOp.a;
      if (k != 1) {
        if (k != 2) {
          if (k != 4) {
            if (k == 8) {
              this.c.onDispatchSecondPass(updateOp);
              this.c.offsetPositionsForMove(updateOp.b, updateOp.d);
            } 
          } else {
            this.c.onDispatchSecondPass(updateOp);
            this.c.markViewHoldersUpdated(updateOp.b, updateOp.d, updateOp.c);
          } 
        } else {
          this.c.onDispatchSecondPass(updateOp);
          this.c.offsetPositionsForRemovingInvisible(updateOp.b, updateOp.d);
        } 
      } else {
        this.c.onDispatchSecondPass(updateOp);
        this.c.offsetPositionsForAdd(updateOp.b, updateOp.d);
      } 
      Runnable runnable = this.d;
      if (runnable != null)
        runnable.run(); 
    } 
    a(this.a);
    this.h = 0;
  }
  
  boolean f() {
    return (!this.b.isEmpty() && !this.a.isEmpty());
  }
  
  public UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject) {
    UpdateOp updateOp = (UpdateOp)this.g.acquire();
    if (updateOp == null)
      return new UpdateOp(paramInt1, paramInt2, paramInt3, paramObject); 
    updateOp.a = paramInt1;
    updateOp.b = paramInt2;
    updateOp.d = paramInt3;
    updateOp.c = paramObject;
    return updateOp;
  }
  
  public void recycleUpdateOp(UpdateOp paramUpdateOp) {
    if (!this.e) {
      paramUpdateOp.c = null;
      this.g.release(paramUpdateOp);
    } 
  }
  
  static interface Callback {
    RecyclerView.ViewHolder findViewHolder(int param1Int);
    
    void markViewHoldersUpdated(int param1Int1, int param1Int2, Object param1Object);
    
    void offsetPositionsForAdd(int param1Int1, int param1Int2);
    
    void offsetPositionsForMove(int param1Int1, int param1Int2);
    
    void offsetPositionsForRemovingInvisible(int param1Int1, int param1Int2);
    
    void offsetPositionsForRemovingLaidOutOrNewView(int param1Int1, int param1Int2);
    
    void onDispatchFirstPass(AdapterHelper.UpdateOp param1UpdateOp);
    
    void onDispatchSecondPass(AdapterHelper.UpdateOp param1UpdateOp);
  }
  
  static class UpdateOp {
    int a;
    
    int b;
    
    Object c;
    
    int d;
    
    UpdateOp(int param1Int1, int param1Int2, int param1Int3, Object param1Object) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.d = param1Int3;
      this.c = param1Object;
    }
    
    String a() {
      int i = this.a;
      return (i != 1) ? ((i != 2) ? ((i != 4) ? ((i != 8) ? "??" : "mv") : "up") : "rm") : "add";
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        param1Object = param1Object;
        int i = this.a;
        if (i != ((UpdateOp)param1Object).a)
          return false; 
        if (i == 8 && Math.abs(this.d - this.b) == 1 && this.d == ((UpdateOp)param1Object).b && this.b == ((UpdateOp)param1Object).d)
          return true; 
        if (this.d != ((UpdateOp)param1Object).d)
          return false; 
        if (this.b != ((UpdateOp)param1Object).b)
          return false; 
        Object object = this.c;
        if (object != null) {
          if (!object.equals(((UpdateOp)param1Object).c))
            return false; 
        } else if (((UpdateOp)param1Object).c != null) {
          return false;
        } 
        return true;
      } 
      return false;
    }
    
    public int hashCode() {
      return (this.a * 31 + this.b) * 31 + this.d;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append("[");
      stringBuilder.append(a());
      stringBuilder.append(",s:");
      stringBuilder.append(this.b);
      stringBuilder.append("c:");
      stringBuilder.append(this.d);
      stringBuilder.append(",p:");
      stringBuilder.append(this.c);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\AdapterHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */