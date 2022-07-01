package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class ViewBoundsCheck {
  final Callback a;
  
  BoundFlags b;
  
  ViewBoundsCheck(Callback paramCallback) {
    this.a = paramCallback;
    this.b = new BoundFlags();
  }
  
  View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b;
    int i = this.a.getParentStart();
    int j = this.a.getParentEnd();
    if (paramInt2 > paramInt1) {
      b = 1;
    } else {
      b = -1;
    } 
    View view;
    for (view = null; paramInt1 != paramInt2; view = view1) {
      View view2 = this.a.getChildAt(paramInt1);
      int k = this.a.getChildStart(view2);
      int m = this.a.getChildEnd(view2);
      this.b.a(i, j, k, m);
      if (paramInt3 != 0) {
        this.b.a();
        this.b.a(paramInt3);
        if (this.b.b())
          return view2; 
      } 
      View view1 = view;
      if (paramInt4 != 0) {
        this.b.a();
        this.b.a(paramInt4);
        view1 = view;
        if (this.b.b())
          view1 = view2; 
      } 
      paramInt1 += b;
    } 
    return view;
  }
  
  boolean a(View paramView, int paramInt) {
    this.b.a(this.a.getParentStart(), this.a.getParentEnd(), this.a.getChildStart(paramView), this.a.getChildEnd(paramView));
    if (paramInt != 0) {
      this.b.a();
      this.b.a(paramInt);
      return this.b.b();
    } 
    return false;
  }
  
  static class BoundFlags {
    int a = 0;
    
    int b;
    
    int c;
    
    int d;
    
    int e;
    
    int a(int param1Int1, int param1Int2) {
      return (param1Int1 > param1Int2) ? 1 : ((param1Int1 == param1Int2) ? 2 : 4);
    }
    
    void a() {
      this.a = 0;
    }
    
    void a(int param1Int) {
      this.a = param1Int | this.a;
    }
    
    void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.b = param1Int1;
      this.c = param1Int2;
      this.d = param1Int3;
      this.e = param1Int4;
    }
    
    boolean b() {
      int i = this.a;
      if ((i & 0x7) != 0 && (i & a(this.d, this.b) << 0) == 0)
        return false; 
      i = this.a;
      if ((i & 0x70) != 0 && (i & a(this.d, this.c) << 4) == 0)
        return false; 
      i = this.a;
      if ((i & 0x700) != 0 && (i & a(this.e, this.b) << 8) == 0)
        return false; 
      i = this.a;
      return !((i & 0x7000) != 0 && (i & a(this.e, this.c) << 12) == 0);
    }
  }
  
  static interface Callback {
    View getChildAt(int param1Int);
    
    int getChildEnd(View param1View);
    
    int getChildStart(View param1View);
    
    int getParentEnd();
    
    int getParentStart();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ViewBounds {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\ViewBoundsCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */