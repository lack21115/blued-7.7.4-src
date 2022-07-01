package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
  final Callback a;
  
  final Bucket b;
  
  final List<View> c;
  
  ChildHelper(Callback paramCallback) {
    this.a = paramCallback;
    this.b = new Bucket();
    this.c = new ArrayList<View>();
  }
  
  private int f(int paramInt) {
    if (paramInt < 0)
      return -1; 
    int j = this.a.getChildCount();
    for (int i = paramInt; i < j; i += k) {
      int k = paramInt - i - this.b.e(i);
      if (k == 0) {
        while (this.b.c(i))
          i++; 
        return i;
      } 
    } 
    return -1;
  }
  
  private void g(View paramView) {
    this.c.add(paramView);
    this.a.onEnteredHiddenState(paramView);
  }
  
  private boolean h(View paramView) {
    if (this.c.remove(paramView)) {
      this.a.onLeftHiddenState(paramView);
      return true;
    } 
    return false;
  }
  
  void a() {
    this.b.a();
    for (int i = this.c.size() - 1; i >= 0; i--) {
      this.a.onLeftHiddenState(this.c.get(i));
      this.c.remove(i);
    } 
    this.a.removeAllViews();
  }
  
  void a(int paramInt) {
    paramInt = f(paramInt);
    View view = this.a.getChildAt(paramInt);
    if (view == null)
      return; 
    if (this.b.d(paramInt))
      h(view); 
    this.a.removeViewAt(paramInt);
  }
  
  void a(View paramView) {
    int i = this.a.indexOfChild(paramView);
    if (i < 0)
      return; 
    if (this.b.d(i))
      h(paramView); 
    this.a.removeViewAt(i);
  }
  
  void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean) {
    if (paramInt < 0) {
      paramInt = this.a.getChildCount();
    } else {
      paramInt = f(paramInt);
    } 
    this.b.a(paramInt, paramBoolean);
    if (paramBoolean)
      g(paramView); 
    this.a.attachViewToParent(paramView, paramInt, paramLayoutParams);
  }
  
  void a(View paramView, int paramInt, boolean paramBoolean) {
    if (paramInt < 0) {
      paramInt = this.a.getChildCount();
    } else {
      paramInt = f(paramInt);
    } 
    this.b.a(paramInt, paramBoolean);
    if (paramBoolean)
      g(paramView); 
    this.a.addView(paramView, paramInt);
  }
  
  void a(View paramView, boolean paramBoolean) {
    a(paramView, -1, paramBoolean);
  }
  
  int b() {
    return this.a.getChildCount() - this.c.size();
  }
  
  int b(View paramView) {
    int i = this.a.indexOfChild(paramView);
    return (i == -1) ? -1 : (this.b.c(i) ? -1 : (i - this.b.e(i)));
  }
  
  View b(int paramInt) {
    paramInt = f(paramInt);
    return this.a.getChildAt(paramInt);
  }
  
  int c() {
    return this.a.getChildCount();
  }
  
  View c(int paramInt) {
    int j = this.c.size();
    for (int i = 0; i < j; i++) {
      View view = this.c.get(i);
      RecyclerView.ViewHolder viewHolder = this.a.getChildViewHolder(view);
      if (viewHolder.getLayoutPosition() == paramInt && !viewHolder.j() && !viewHolder.m())
        return view; 
    } 
    return null;
  }
  
  boolean c(View paramView) {
    return this.c.contains(paramView);
  }
  
  View d(int paramInt) {
    return this.a.getChildAt(paramInt);
  }
  
  void d(View paramView) {
    int i = this.a.indexOfChild(paramView);
    if (i >= 0) {
      this.b.a(i);
      g(paramView);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("view is not a child, cannot hide ");
    stringBuilder.append(paramView);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  void e(int paramInt) {
    paramInt = f(paramInt);
    this.b.d(paramInt);
    this.a.detachViewFromParent(paramInt);
  }
  
  void e(View paramView) {
    int i = this.a.indexOfChild(paramView);
    if (i >= 0) {
      if (this.b.c(i)) {
        this.b.b(i);
        h(paramView);
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("trying to unhide a view that was not hidden");
      stringBuilder1.append(paramView);
      throw new RuntimeException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("view is not a child, cannot hide ");
    stringBuilder.append(paramView);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  boolean f(View paramView) {
    int i = this.a.indexOfChild(paramView);
    if (i == -1) {
      h(paramView);
      return true;
    } 
    if (this.b.c(i)) {
      this.b.d(i);
      h(paramView);
      this.a.removeViewAt(i);
      return true;
    } 
    return false;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.toString());
    stringBuilder.append(", hidden list:");
    stringBuilder.append(this.c.size());
    return stringBuilder.toString();
  }
  
  static class Bucket {
    long a = 0L;
    
    Bucket b;
    
    private void b() {
      if (this.b == null)
        this.b = new Bucket(); 
    }
    
    void a() {
      this.a = 0L;
      Bucket bucket = this.b;
      if (bucket != null)
        bucket.a(); 
    }
    
    void a(int param1Int) {
      if (param1Int >= 64) {
        b();
        this.b.a(param1Int - 64);
        return;
      } 
      this.a |= 1L << param1Int;
    }
    
    void a(int param1Int, boolean param1Boolean) {
      boolean bool;
      if (param1Int >= 64) {
        b();
        this.b.a(param1Int - 64, param1Boolean);
        return;
      } 
      if ((this.a & Long.MIN_VALUE) != 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      long l1 = (1L << param1Int) - 1L;
      long l2 = this.a;
      this.a = (l2 & l1) << 1L | l2 & l1;
      if (param1Boolean) {
        a(param1Int);
      } else {
        b(param1Int);
      } 
      if (bool || this.b != null) {
        b();
        this.b.a(0, bool);
      } 
    }
    
    void b(int param1Int) {
      if (param1Int >= 64) {
        Bucket bucket = this.b;
        if (bucket != null) {
          bucket.b(param1Int - 64);
          return;
        } 
      } else {
        this.a &= 1L << param1Int;
      } 
    }
    
    boolean c(int param1Int) {
      if (param1Int >= 64) {
        b();
        return this.b.c(param1Int - 64);
      } 
      return ((this.a & 1L << param1Int) != 0L);
    }
    
    boolean d(int param1Int) {
      boolean bool;
      if (param1Int >= 64) {
        b();
        return this.b.d(param1Int - 64);
      } 
      long l1 = 1L << param1Int;
      if ((this.a & l1) != 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      this.a &= l1;
      l1--;
      long l2 = this.a;
      this.a = Long.rotateRight(l2 & l1, 1) | l2 & l1;
      Bucket bucket = this.b;
      if (bucket != null) {
        if (bucket.c(0))
          a(63); 
        this.b.d(0);
      } 
      return bool;
    }
    
    int e(int param1Int) {
      Bucket bucket = this.b;
      return (bucket == null) ? ((param1Int >= 64) ? Long.bitCount(this.a) : Long.bitCount(this.a & (1L << param1Int) - 1L)) : ((param1Int < 64) ? Long.bitCount(this.a & (1L << param1Int) - 1L) : (bucket.e(param1Int - 64) + Long.bitCount(this.a)));
    }
    
    public String toString() {
      if (this.b == null)
        return Long.toBinaryString(this.a); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b.toString());
      stringBuilder.append("xx");
      stringBuilder.append(Long.toBinaryString(this.a));
      return stringBuilder.toString();
    }
  }
  
  static interface Callback {
    void addView(View param1View, int param1Int);
    
    void attachViewToParent(View param1View, int param1Int, ViewGroup.LayoutParams param1LayoutParams);
    
    void detachViewFromParent(int param1Int);
    
    View getChildAt(int param1Int);
    
    int getChildCount();
    
    RecyclerView.ViewHolder getChildViewHolder(View param1View);
    
    int indexOfChild(View param1View);
    
    void onEnteredHiddenState(View param1View);
    
    void onLeftHiddenState(View param1View);
    
    void removeAllViews();
    
    void removeViewAt(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\ChildHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */