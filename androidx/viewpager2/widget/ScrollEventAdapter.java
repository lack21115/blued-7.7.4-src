package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
  private ViewPager2.OnPageChangeCallback a;
  
  private final ViewPager2 b;
  
  private final RecyclerView c;
  
  private final LinearLayoutManager d;
  
  private int e;
  
  private int f;
  
  private ScrollEventValues g;
  
  private int h;
  
  private int i;
  
  private boolean j;
  
  private boolean k;
  
  private boolean l;
  
  private boolean m;
  
  ScrollEventAdapter(ViewPager2 paramViewPager2) {
    this.b = paramViewPager2;
    this.c = this.b.d;
    this.d = (LinearLayoutManager)this.c.getLayoutManager();
    this.g = new ScrollEventValues();
    i();
  }
  
  private void a(int paramInt) {
    if (this.e == 3 && this.f == 0)
      return; 
    if (this.f == paramInt)
      return; 
    this.f = paramInt;
    ViewPager2.OnPageChangeCallback onPageChangeCallback = this.a;
    if (onPageChangeCallback != null)
      onPageChangeCallback.onPageScrollStateChanged(paramInt); 
  }
  
  private void a(int paramInt1, float paramFloat, int paramInt2) {
    ViewPager2.OnPageChangeCallback onPageChangeCallback = this.a;
    if (onPageChangeCallback != null)
      onPageChangeCallback.onPageScrolled(paramInt1, paramFloat, paramInt2); 
  }
  
  private void a(boolean paramBoolean) {
    this.m = paramBoolean;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 1;
    } 
    this.e = i;
    int i = this.i;
    if (i != -1) {
      this.h = i;
      this.i = -1;
    } else if (this.h == -1) {
      this.h = l();
    } 
    a(1);
  }
  
  private void b(int paramInt) {
    ViewPager2.OnPageChangeCallback onPageChangeCallback = this.a;
    if (onPageChangeCallback != null)
      onPageChangeCallback.onPageSelected(paramInt); 
  }
  
  private void i() {
    this.e = 0;
    this.f = 0;
    this.g.a();
    this.h = -1;
    this.i = -1;
    this.j = false;
    this.k = false;
    this.m = false;
    this.l = false;
  }
  
  private void j() {
    float f;
    ScrollEventValues scrollEventValues = this.g;
    scrollEventValues.a = this.d.findFirstVisibleItemPosition();
    if (scrollEventValues.a == -1) {
      scrollEventValues.a();
      return;
    } 
    View view = this.d.findViewByPosition(scrollEventValues.a);
    if (view == null) {
      scrollEventValues.a();
      return;
    } 
    int i3 = this.d.getLeftDecorationWidth(view);
    int i2 = this.d.getRightDecorationWidth(view);
    int i1 = this.d.getTopDecorationHeight(view);
    int n = this.d.getBottomDecorationHeight(view);
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    int k = i3;
    int m = i2;
    int j = i1;
    int i = n;
    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
      k = i3 + marginLayoutParams.leftMargin;
      m = i2 + marginLayoutParams.rightMargin;
      j = i1 + marginLayoutParams.topMargin;
      i = n + marginLayoutParams.bottomMargin;
    } 
    i1 = view.getHeight();
    n = m + view.getWidth() + k;
    if (this.d.getOrientation() == 0) {
      m = 1;
    } else {
      m = 0;
    } 
    if (m != 0) {
      k = view.getLeft() - k - this.c.getPaddingLeft();
      i = k;
      j = n;
      if (this.b.b()) {
        i = -k;
        j = n;
      } 
    } else {
      k = view.getTop() - j - this.c.getPaddingTop();
      j = i1 + j + i;
      i = k;
    } 
    scrollEventValues.c = -i;
    if (scrollEventValues.c < 0) {
      if ((new AnimateLayoutChangeDetector(this.d)).a())
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started."); 
      throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[] { Integer.valueOf(scrollEventValues.c) }));
    } 
    if (j == 0) {
      f = 0.0F;
    } else {
      f = scrollEventValues.c / j;
    } 
    scrollEventValues.b = f;
  }
  
  private boolean k() {
    int i = this.e;
    boolean bool = true;
    if (i != 1) {
      if (i == 4)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  private int l() {
    return this.d.findFirstVisibleItemPosition();
  }
  
  void a() {
    this.l = true;
  }
  
  void a(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      b = 2;
    } else {
      b = 3;
    } 
    this.e = b;
    byte b = 0;
    this.m = false;
    if (this.i != paramInt)
      b = 1; 
    this.i = paramInt;
    a(2);
    if (b != 0)
      b(paramInt); 
  }
  
  void a(ViewPager2.OnPageChangeCallback paramOnPageChangeCallback) {
    this.a = paramOnPageChangeCallback;
  }
  
  void b() {
    this.e = 4;
    a(true);
  }
  
  void c() {
    if (f() && !this.m)
      return; 
    this.m = false;
    j();
    if (this.g.c == 0) {
      if (this.g.a != this.h)
        b(this.g.a); 
      a(0);
      i();
      return;
    } 
    a(2);
  }
  
  int d() {
    return this.f;
  }
  
  boolean e() {
    return (this.f == 0);
  }
  
  boolean f() {
    return (this.f == 1);
  }
  
  boolean g() {
    return this.m;
  }
  
  double h() {
    j();
    return this.g.a + this.g.b;
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt) {
    int i = this.e;
    boolean bool = true;
    if ((i != 1 || this.f != 1) && paramInt == 1) {
      a(false);
      return;
    } 
    if (k() && paramInt == 2) {
      if (this.k) {
        a(2);
        this.j = true;
      } 
      return;
    } 
    if (k() && paramInt == 0) {
      j();
      if (!this.k) {
        i = bool;
        if (this.g.a != -1) {
          a(this.g.a, 0.0F, 0);
          i = bool;
        } 
      } else if (this.g.c == 0) {
        i = bool;
        if (this.h != this.g.a) {
          b(this.g.a);
          i = bool;
        } 
      } else {
        i = 0;
      } 
      if (i != 0) {
        a(0);
        i();
      } 
    } 
    if (this.e == 2 && paramInt == 0 && this.l) {
      j();
      if (this.g.c == 0) {
        if (this.i != this.g.a) {
          if (this.g.a == -1) {
            paramInt = 0;
          } else {
            paramInt = this.g.a;
          } 
          b(paramInt);
        } 
        a(0);
        i();
      } 
    } 
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield k : Z
    //   5: aload_0
    //   6: invokespecial j : ()V
    //   9: aload_0
    //   10: getfield j : Z
    //   13: ifeq -> 127
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield j : Z
    //   21: iload_3
    //   22: ifgt -> 62
    //   25: iload_3
    //   26: ifne -> 57
    //   29: iload_2
    //   30: ifge -> 39
    //   33: iconst_1
    //   34: istore #4
    //   36: goto -> 42
    //   39: iconst_0
    //   40: istore #4
    //   42: iload #4
    //   44: aload_0
    //   45: getfield b : Landroidx/viewpager2/widget/ViewPager2;
    //   48: invokevirtual b : ()Z
    //   51: if_icmpne -> 57
    //   54: goto -> 62
    //   57: iconst_0
    //   58: istore_2
    //   59: goto -> 64
    //   62: iconst_1
    //   63: istore_2
    //   64: iload_2
    //   65: ifeq -> 91
    //   68: aload_0
    //   69: getfield g : Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;
    //   72: getfield c : I
    //   75: ifeq -> 91
    //   78: aload_0
    //   79: getfield g : Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;
    //   82: getfield a : I
    //   85: iconst_1
    //   86: iadd
    //   87: istore_2
    //   88: goto -> 99
    //   91: aload_0
    //   92: getfield g : Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;
    //   95: getfield a : I
    //   98: istore_2
    //   99: aload_0
    //   100: iload_2
    //   101: putfield i : I
    //   104: aload_0
    //   105: getfield h : I
    //   108: istore_2
    //   109: aload_0
    //   110: getfield i : I
    //   113: istore_3
    //   114: iload_2
    //   115: iload_3
    //   116: if_icmpeq -> 156
    //   119: aload_0
    //   120: iload_3
    //   121: invokespecial b : (I)V
    //   124: goto -> 156
    //   127: aload_0
    //   128: getfield e : I
    //   131: ifne -> 156
    //   134: aload_0
    //   135: getfield g : Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;
    //   138: getfield a : I
    //   141: istore_3
    //   142: iload_3
    //   143: istore_2
    //   144: iload_3
    //   145: iconst_m1
    //   146: if_icmpne -> 151
    //   149: iconst_0
    //   150: istore_2
    //   151: aload_0
    //   152: iload_2
    //   153: invokespecial b : (I)V
    //   156: aload_0
    //   157: getfield g : Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;
    //   160: getfield a : I
    //   163: iconst_m1
    //   164: if_icmpne -> 172
    //   167: iconst_0
    //   168: istore_2
    //   169: goto -> 180
    //   172: aload_0
    //   173: getfield g : Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;
    //   176: getfield a : I
    //   179: istore_2
    //   180: aload_0
    //   181: iload_2
    //   182: aload_0
    //   183: getfield g : Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;
    //   186: getfield b : F
    //   189: aload_0
    //   190: getfield g : Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;
    //   193: getfield c : I
    //   196: invokespecial a : (IFI)V
    //   199: aload_0
    //   200: getfield g : Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;
    //   203: getfield a : I
    //   206: istore_2
    //   207: aload_0
    //   208: getfield i : I
    //   211: istore_3
    //   212: iload_2
    //   213: iload_3
    //   214: if_icmpeq -> 222
    //   217: iload_3
    //   218: iconst_m1
    //   219: if_icmpne -> 249
    //   222: aload_0
    //   223: getfield g : Landroidx/viewpager2/widget/ScrollEventAdapter$ScrollEventValues;
    //   226: getfield c : I
    //   229: ifne -> 249
    //   232: aload_0
    //   233: getfield f : I
    //   236: iconst_1
    //   237: if_icmpeq -> 249
    //   240: aload_0
    //   241: iconst_0
    //   242: invokespecial a : (I)V
    //   245: aload_0
    //   246: invokespecial i : ()V
    //   249: return
  }
  
  static final class ScrollEventValues {
    int a;
    
    float b;
    
    int c;
    
    void a() {
      this.a = -1;
      this.b = 0.0F;
      this.c = 0;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager2\widget\ScrollEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */