package com.chad.library.adapter.base;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.animation.AlphaInAnimation;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseQuickAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {
  public static final String j = BaseQuickAdapter.class.getSimpleName();
  
  private boolean A;
  
  private boolean B;
  
  private RecyclerView C;
  
  private boolean D;
  
  private boolean E;
  
  private UpFetchListener F;
  
  private int G = 1;
  
  private boolean H;
  
  private boolean I;
  
  private SpanSizeLookup J;
  
  private MultiTypeDelegate<T> K;
  
  private int L = 1;
  
  private boolean a = false;
  
  private boolean b = false;
  
  private boolean c = false;
  
  private LoadMoreView d = (LoadMoreView)new SimpleLoadMoreView();
  
  private RequestLoadMoreListener e;
  
  private boolean f = false;
  
  private OnItemClickListener g;
  
  private OnItemLongClickListener h;
  
  private OnItemChildClickListener i;
  
  public Context k;
  
  protected int l;
  
  protected LayoutInflater m;
  
  public List<T> n;
  
  private OnItemChildLongClickListener o;
  
  private boolean p = true;
  
  private boolean q = false;
  
  private Interpolator r = (Interpolator)new LinearInterpolator();
  
  private int s = 300;
  
  private int t = -1;
  
  private BaseAnimation u;
  
  private BaseAnimation v = (BaseAnimation)new AlphaInAnimation();
  
  private LinearLayout w;
  
  private LinearLayout x;
  
  private FrameLayout y;
  
  private boolean z = true;
  
  public BaseQuickAdapter(int paramInt) {
    this(paramInt, (List<T>)null);
  }
  
  public BaseQuickAdapter(int paramInt, List<T> paramList) {
    List<T> list = paramList;
    if (paramList == null)
      list = new ArrayList<T>(); 
    this.n = list;
    if (paramInt != 0)
      this.l = paramInt; 
  }
  
  public BaseQuickAdapter(List<T> paramList) {
    this(0, paramList);
  }
  
  private int a(int[] paramArrayOfint) {
    int i = -1;
    int j = i;
    if (paramArrayOfint != null) {
      if (paramArrayOfint.length == 0)
        return -1; 
      int m = paramArrayOfint.length;
      int k = 0;
      while (true) {
        j = i;
        if (k < m) {
          int n = paramArrayOfint[k];
          j = i;
          if (n > i)
            j = n; 
          k++;
          i = j;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  private K a(ViewGroup paramViewGroup) {
    paramViewGroup = (ViewGroup)a(a(this.d.a(), paramViewGroup));
    ((BaseViewHolder)paramViewGroup).itemView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (BaseQuickAdapter.a(this.a).e() == 3)
              this.a.r(); 
            if (BaseQuickAdapter.b(this.a) && BaseQuickAdapter.a(this.a).e() == 4)
              this.a.r(); 
          }
        });
    return (K)paramViewGroup;
  }
  
  private K a(Class paramClass, View paramView) {
    try {
      if (paramClass.isMemberClass() && !Modifier.isStatic(paramClass.getModifiers())) {
        constructor = paramClass.getDeclaredConstructor(new Class[] { getClass(), View.class });
        constructor.setAccessible(true);
        return (K)constructor.newInstance(new Object[] { this, paramView });
      } 
      Constructor<BaseViewHolder> constructor = constructor.getDeclaredConstructor(new Class[] { View.class });
      constructor.setAccessible(true);
      return (K)constructor.newInstance(new Object[] { paramView });
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InstantiationException instantiationException) {
      instantiationException.printStackTrace();
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
    } 
    return null;
  }
  
  private Class a(Class paramClass) {
    Type type = paramClass.getGenericSuperclass();
    if (type instanceof ParameterizedType)
      for (Type type1 : ((ParameterizedType)type).getActualTypeArguments()) {
        if (type1 instanceof Class) {
          type1 = type1;
          if (BaseViewHolder.class.isAssignableFrom((Class<?>)type1))
            return (Class)type1; 
        } 
      }  
    return null;
  }
  
  private void a() {
    if (e() != null)
      return; 
    throw new RuntimeException("please bind recyclerView first!");
  }
  
  private void a(int paramInt) {
    if (g()) {
      if (h())
        return; 
      if (paramInt <= this.G) {
        UpFetchListener upFetchListener = this.F;
        if (upFetchListener != null)
          upFetchListener.a(); 
      } 
    } 
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder) {
    if (this.q && (!this.p || paramViewHolder.getLayoutPosition() > this.t)) {
      BaseAnimation baseAnimation = this.u;
      if (baseAnimation == null)
        baseAnimation = this.v; 
      Animator[] arrayOfAnimator = baseAnimation.a(paramViewHolder.itemView);
      int j = arrayOfAnimator.length;
      for (int i = 0; i < j; i++)
        a(arrayOfAnimator[i], paramViewHolder.getLayoutPosition()); 
      this.t = paramViewHolder.getLayoutPosition();
    } 
  }
  
  private int b() {
    return (q() == 1) ? (this.A ? 0 : -1) : 0;
  }
  
  private void b(int paramInt) {
    int i;
    List<T> list = this.n;
    if (list == null) {
      i = 0;
    } else {
      i = list.size();
    } 
    if (i == paramInt)
      notifyDataSetChanged(); 
  }
  
  private void b(RequestLoadMoreListener paramRequestLoadMoreListener) {
    this.e = paramRequestLoadMoreListener;
    this.a = true;
    this.b = true;
    this.c = false;
  }
  
  private void b(BaseViewHolder paramBaseViewHolder) {
    if (paramBaseViewHolder == null)
      return; 
    View view = paramBaseViewHolder.itemView;
    if (view == null)
      return; 
    if (x() != null)
      view.setOnClickListener(new View.OnClickListener(this, paramBaseViewHolder) {
            public void onClick(View param1View) {
              this.b.x().onItemClick(this.b, param1View, this.a.getLayoutPosition() - this.b.o());
            }
          }); 
    if (w() != null)
      view.setOnLongClickListener(new View.OnLongClickListener(this, paramBaseViewHolder) {
            public boolean onLongClick(View param1View) {
              return this.b.w().a(this.b, param1View, this.a.getLayoutPosition() - this.b.o());
            }
          }); 
  }
  
  private int c() {
    int i = q();
    boolean bool = true;
    if (i == 1) {
      i = bool;
      if (this.A) {
        i = bool;
        if (o() != 0)
          i = 2; 
      } 
      return this.B ? i : -1;
    } 
    return o() + this.n.size();
  }
  
  private void c(RecyclerView paramRecyclerView) {
    this.C = paramRecyclerView;
  }
  
  private void g(int paramInt) {
    if (i() == 0)
      return; 
    if (paramInt < getItemCount() - this.L)
      return; 
    if (this.d.e() != 1)
      return; 
    this.d.a(2);
    if (!this.c) {
      this.c = true;
      if (e() != null) {
        e().post(new Runnable(this) {
              public void run() {
                BaseQuickAdapter.d(this.a).onLoadMoreRequested();
              }
            });
        return;
      } 
      this.e.onLoadMoreRequested();
    } 
  }
  
  public int a(View paramView, int paramInt) {
    return a(paramView, paramInt, 1);
  }
  
  public int a(View paramView, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield w : Landroid/widget/LinearLayout;
    //   4: ifnonnull -> 80
    //   7: aload_0
    //   8: new android/widget/LinearLayout
    //   11: dup
    //   12: aload_1
    //   13: invokevirtual getContext : ()Landroid/content/Context;
    //   16: invokespecial <init> : (Landroid/content/Context;)V
    //   19: putfield w : Landroid/widget/LinearLayout;
    //   22: iload_3
    //   23: iconst_1
    //   24: if_icmpne -> 55
    //   27: aload_0
    //   28: getfield w : Landroid/widget/LinearLayout;
    //   31: iconst_1
    //   32: invokevirtual setOrientation : (I)V
    //   35: aload_0
    //   36: getfield w : Landroid/widget/LinearLayout;
    //   39: new androidx/recyclerview/widget/RecyclerView$LayoutParams
    //   42: dup
    //   43: iconst_m1
    //   44: bipush #-2
    //   46: invokespecial <init> : (II)V
    //   49: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   52: goto -> 80
    //   55: aload_0
    //   56: getfield w : Landroid/widget/LinearLayout;
    //   59: iconst_0
    //   60: invokevirtual setOrientation : (I)V
    //   63: aload_0
    //   64: getfield w : Landroid/widget/LinearLayout;
    //   67: new androidx/recyclerview/widget/RecyclerView$LayoutParams
    //   70: dup
    //   71: bipush #-2
    //   73: iconst_m1
    //   74: invokespecial <init> : (II)V
    //   77: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   80: aload_0
    //   81: getfield w : Landroid/widget/LinearLayout;
    //   84: invokevirtual getChildCount : ()I
    //   87: istore #4
    //   89: iload_2
    //   90: iflt -> 101
    //   93: iload_2
    //   94: istore_3
    //   95: iload_2
    //   96: iload #4
    //   98: if_icmple -> 104
    //   101: iload #4
    //   103: istore_3
    //   104: aload_0
    //   105: getfield w : Landroid/widget/LinearLayout;
    //   108: aload_1
    //   109: iload_3
    //   110: invokevirtual addView : (Landroid/view/View;I)V
    //   113: aload_0
    //   114: getfield w : Landroid/widget/LinearLayout;
    //   117: invokevirtual getChildCount : ()I
    //   120: iconst_1
    //   121: if_icmpne -> 139
    //   124: aload_0
    //   125: invokespecial b : ()I
    //   128: istore_2
    //   129: iload_2
    //   130: iconst_m1
    //   131: if_icmpeq -> 139
    //   134: aload_0
    //   135: iload_2
    //   136: invokevirtual notifyItemInserted : (I)V
    //   139: iload_3
    //   140: ireturn
  }
  
  protected View a(int paramInt, ViewGroup paramViewGroup) {
    return this.m.inflate(paramInt, paramViewGroup, false);
  }
  
  public View a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    if (paramRecyclerView == null)
      return null; 
    BaseViewHolder baseViewHolder = (BaseViewHolder)paramRecyclerView.findViewHolderForLayoutPosition(paramInt1);
    return (baseViewHolder == null) ? null : baseViewHolder.d(paramInt2);
  }
  
  protected K a(View paramView) {
    Class<?> clazz = getClass();
    Class clazz1 = null;
    while (clazz1 == null && clazz != null) {
      clazz1 = a(clazz);
      clazz = clazz.getSuperclass();
    } 
    if (clazz1 == null) {
      BaseViewHolder baseViewHolder = new BaseViewHolder(paramView);
    } else {
      clazz = (Class<?>)a(clazz1, paramView);
    } 
    return (K)((clazz != null) ? clazz : new BaseViewHolder(paramView));
  }
  
  protected K a(ViewGroup paramViewGroup, int paramInt) {
    int i = this.l;
    MultiTypeDelegate<T> multiTypeDelegate = this.K;
    if (multiTypeDelegate != null)
      i = multiTypeDelegate.a(paramInt); 
    return c(paramViewGroup, i);
  }
  
  public void a(int paramInt, T paramT) {
    this.n.add(paramInt, paramT);
    notifyItemInserted(paramInt + o());
    b(1);
  }
  
  protected void a(Animator paramAnimator, int paramInt) {
    paramAnimator.setDuration(this.s).start();
    paramAnimator.setInterpolator((TimeInterpolator)this.r);
  }
  
  public void a(RecyclerView paramRecyclerView) {
    if (e() == null) {
      c(paramRecyclerView);
      e().setAdapter(this);
      return;
    } 
    throw new RuntimeException("Don't bind twice");
  }
  
  public void a(OnItemChildClickListener paramOnItemChildClickListener) {
    this.i = paramOnItemChildClickListener;
  }
  
  public void a(OnItemClickListener paramOnItemClickListener) {
    this.g = paramOnItemClickListener;
  }
  
  public void a(OnItemLongClickListener paramOnItemLongClickListener) {
    this.h = paramOnItemLongClickListener;
  }
  
  @Deprecated
  public void a(RequestLoadMoreListener paramRequestLoadMoreListener) {
    b(paramRequestLoadMoreListener);
  }
  
  public void a(RequestLoadMoreListener paramRequestLoadMoreListener, RecyclerView paramRecyclerView) {
    b(paramRequestLoadMoreListener);
    if (e() == null)
      c(paramRecyclerView); 
  }
  
  public void a(K paramK) {
    super.onViewAttachedToWindow((RecyclerView.ViewHolder)paramK);
    int i = paramK.getItemViewType();
    if (i == 1365 || i == 273 || i == 819 || i == 546) {
      g((RecyclerView.ViewHolder)paramK);
      return;
    } 
    a((RecyclerView.ViewHolder)paramK);
  }
  
  public void a(K paramK, int paramInt) {
    a(paramInt);
    g(paramInt);
    int i = paramK.getItemViewType();
    if (i != 0) {
      if (i != 273)
        if (i != 546) {
          if (i != 819 && i != 1365) {
            a(paramK, e(paramInt - o()));
            return;
          } 
        } else {
          this.d.a((BaseViewHolder)paramK);
          return;
        }  
    } else {
      a(paramK, e(paramInt - o()));
    } 
  }
  
  protected abstract void a(K paramK, T paramT);
  
  public void a(LoadMoreView paramLoadMoreView) {
    this.d = paramLoadMoreView;
  }
  
  public void a(T paramT) {
    this.n.add(paramT);
    notifyItemInserted(this.n.size() + o());
    b(1);
  }
  
  public void a(Collection<? extends T> paramCollection) {
    this.n.addAll(paramCollection);
    notifyItemRangeInserted(this.n.size() - paramCollection.size() + o(), paramCollection.size());
    b(paramCollection.size());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    this.A = paramBoolean1;
    this.B = paramBoolean2;
  }
  
  public int b(View paramView) {
    return a(paramView, -1);
  }
  
  public int b(View paramView, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield x : Landroid/widget/LinearLayout;
    //   4: ifnonnull -> 80
    //   7: aload_0
    //   8: new android/widget/LinearLayout
    //   11: dup
    //   12: aload_1
    //   13: invokevirtual getContext : ()Landroid/content/Context;
    //   16: invokespecial <init> : (Landroid/content/Context;)V
    //   19: putfield x : Landroid/widget/LinearLayout;
    //   22: iload_3
    //   23: iconst_1
    //   24: if_icmpne -> 55
    //   27: aload_0
    //   28: getfield x : Landroid/widget/LinearLayout;
    //   31: iconst_1
    //   32: invokevirtual setOrientation : (I)V
    //   35: aload_0
    //   36: getfield x : Landroid/widget/LinearLayout;
    //   39: new androidx/recyclerview/widget/RecyclerView$LayoutParams
    //   42: dup
    //   43: iconst_m1
    //   44: bipush #-2
    //   46: invokespecial <init> : (II)V
    //   49: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   52: goto -> 80
    //   55: aload_0
    //   56: getfield x : Landroid/widget/LinearLayout;
    //   59: iconst_0
    //   60: invokevirtual setOrientation : (I)V
    //   63: aload_0
    //   64: getfield x : Landroid/widget/LinearLayout;
    //   67: new androidx/recyclerview/widget/RecyclerView$LayoutParams
    //   70: dup
    //   71: bipush #-2
    //   73: iconst_m1
    //   74: invokespecial <init> : (II)V
    //   77: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   80: aload_0
    //   81: getfield x : Landroid/widget/LinearLayout;
    //   84: invokevirtual getChildCount : ()I
    //   87: istore #4
    //   89: iload_2
    //   90: iflt -> 101
    //   93: iload_2
    //   94: istore_3
    //   95: iload_2
    //   96: iload #4
    //   98: if_icmple -> 104
    //   101: iload #4
    //   103: istore_3
    //   104: aload_0
    //   105: getfield x : Landroid/widget/LinearLayout;
    //   108: aload_1
    //   109: iload_3
    //   110: invokevirtual addView : (Landroid/view/View;I)V
    //   113: aload_0
    //   114: getfield x : Landroid/widget/LinearLayout;
    //   117: invokevirtual getChildCount : ()I
    //   120: iconst_1
    //   121: if_icmpne -> 139
    //   124: aload_0
    //   125: invokespecial c : ()I
    //   128: istore_2
    //   129: iload_2
    //   130: iconst_m1
    //   131: if_icmpeq -> 139
    //   134: aload_0
    //   135: iload_2
    //   136: invokevirtual notifyItemInserted : (I)V
    //   139: iload_3
    //   140: ireturn
  }
  
  public K b(ViewGroup paramViewGroup, int paramInt) {
    this.k = paramViewGroup.getContext();
    this.m = LayoutInflater.from(this.k);
    if (paramInt != 273) {
      if (paramInt != 546) {
        if (paramInt != 819) {
          if (paramInt != 1365) {
            paramViewGroup = (ViewGroup)a(paramViewGroup, paramInt);
            b((BaseViewHolder)paramViewGroup);
          } else {
            paramViewGroup = (ViewGroup)a((View)this.y);
          } 
        } else {
          paramViewGroup = (ViewGroup)a((View)this.x);
        } 
      } else {
        paramViewGroup = (ViewGroup)a(paramViewGroup);
      } 
    } else {
      paramViewGroup = (ViewGroup)a((View)this.w);
    } 
    paramViewGroup.a(this);
    return (K)paramViewGroup;
  }
  
  public void b(RecyclerView paramRecyclerView) {
    c(false);
    if (paramRecyclerView == null)
      return; 
    RecyclerView.LayoutManager layoutManager = paramRecyclerView.getLayoutManager();
    if (layoutManager == null)
      return; 
    if (layoutManager instanceof LinearLayoutManager) {
      paramRecyclerView.postDelayed(new Runnable(this, (LinearLayoutManager)layoutManager) {
            public void run() {
              if (this.a.findLastCompletelyVisibleItemPosition() + 1 != this.b.getItemCount())
                this.b.c(true); 
            }
          }50L);
      return;
    } 
    if (layoutManager instanceof StaggeredGridLayoutManager)
      paramRecyclerView.postDelayed(new Runnable(this, (StaggeredGridLayoutManager)layoutManager) {
            public void run() {
              int[] arrayOfInt = new int[this.a.getSpanCount()];
              this.a.findLastCompletelyVisibleItemPositions(arrayOfInt);
              if (BaseQuickAdapter.a(this.b, arrayOfInt) + 1 != this.b.getItemCount())
                this.b.c(true); 
            }
          }50L); 
  }
  
  public void b(boolean paramBoolean) {
    if (i() == 0)
      return; 
    this.c = false;
    this.a = false;
    this.d.a(paramBoolean);
    if (paramBoolean) {
      notifyItemRemoved(j());
      return;
    } 
    this.d.a(4);
    notifyItemChanged(j());
  }
  
  protected int c(int paramInt) {
    MultiTypeDelegate<T> multiTypeDelegate = this.K;
    return (multiTypeDelegate != null) ? multiTypeDelegate.a(this.n, paramInt) : super.getItemViewType(paramInt);
  }
  
  public int c(View paramView) {
    return b(paramView, -1, 1);
  }
  
  public int c(View paramView, int paramInt1, int paramInt2) {
    LinearLayout linearLayout = this.x;
    if (linearLayout == null || linearLayout.getChildCount() <= paramInt1)
      return b(paramView, paramInt1, paramInt2); 
    this.x.removeViewAt(paramInt1);
    this.x.addView(paramView, paramInt1);
    return paramInt1;
  }
  
  public View c(int paramInt1, int paramInt2) {
    a();
    return a(e(), paramInt1, paramInt2);
  }
  
  protected K c(ViewGroup paramViewGroup, int paramInt) {
    return a(a(paramInt, paramViewGroup));
  }
  
  public void c(List<T> paramList) {
    List<T> list = paramList;
    if (paramList == null)
      list = new ArrayList<T>(); 
    this.n = list;
    if (this.e != null) {
      this.a = true;
      this.b = true;
      this.c = false;
      this.d.a(1);
    } 
    this.t = -1;
    notifyDataSetChanged();
  }
  
  public void c(boolean paramBoolean) {
    int i = i();
    this.b = paramBoolean;
    int j = i();
    if (i == 1) {
      if (j == 0) {
        notifyItemRemoved(j());
        return;
      } 
    } else if (j == 1) {
      this.d.a(1);
      notifyItemInserted(j());
    } 
  }
  
  public int d(View paramView) {
    return c(paramView, 0, 1);
  }
  
  public void d(int paramInt) {
    this.n.remove(paramInt);
    paramInt += o();
    notifyItemRemoved(paramInt);
    b(0);
    notifyItemRangeChanged(paramInt, this.n.size() - paramInt);
  }
  
  public void d(boolean paramBoolean) {
    a(paramBoolean, false);
  }
  
  public RecyclerView e() {
    return this.C;
  }
  
  public T e(int paramInt) {
    return (paramInt < this.n.size()) ? this.n.get(paramInt) : null;
  }
  
  public void e(View paramView) {
    boolean bool1;
    FrameLayout frameLayout = this.y;
    boolean bool2 = false;
    if (frameLayout == null) {
      this.y = new FrameLayout(paramView.getContext());
      RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
      ViewGroup.LayoutParams layoutParams1 = paramView.getLayoutParams();
      if (layoutParams1 != null) {
        layoutParams.width = layoutParams1.width;
        layoutParams.height = layoutParams1.height;
      } 
      this.y.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.y.removeAllViews();
    this.y.addView(paramView);
    this.z = true;
    if (bool1 && q() == 1) {
      bool1 = bool2;
      if (this.A) {
        bool1 = bool2;
        if (o() != 0)
          bool1 = true; 
      } 
      notifyItemInserted(bool1);
    } 
  }
  
  public void f() {
    a();
    b(e());
  }
  
  protected boolean f(int paramInt) {
    return (paramInt == 1365 || paramInt == 273 || paramInt == 819 || paramInt == 546);
  }
  
  protected void g(RecyclerView.ViewHolder paramViewHolder) {
    if (paramViewHolder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams)
      ((StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams()).setFullSpan(true); 
  }
  
  public boolean g() {
    return this.D;
  }
  
  public int getItemCount() {
    int i = q();
    int j = 1;
    if (i == 1) {
      i = j;
      if (this.A) {
        i = j;
        if (o() != 0)
          i = 2; 
      } 
      j = i;
      if (this.B) {
        j = i;
        if (p() != 0)
          return i + 1; 
      } 
    } else {
      i = o();
      j = this.n.size();
      int k = p();
      j = i() + i + j + k;
    } 
    return j;
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt) {
    if (q() == 1) {
      boolean bool;
      if (this.A && o() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? 1365 : 819) : (bool ? 1365 : 819)) : (bool ? 273 : 1365);
    } 
    int i = o();
    if (paramInt < i)
      return 273; 
    paramInt -= i;
    i = this.n.size();
    return (paramInt < i) ? c(paramInt) : ((paramInt - i < p()) ? 819 : 546);
  }
  
  public boolean h() {
    return this.E;
  }
  
  public int i() {
    return (this.e != null) ? (!this.b ? 0 : ((!this.a && this.d.f()) ? 0 : ((this.n.size() == 0) ? 0 : 1))) : 0;
  }
  
  public int j() {
    return o() + this.n.size() + p();
  }
  
  public void k() {
    b(false);
  }
  
  public void l() {
    if (i() == 0)
      return; 
    this.c = false;
    this.a = true;
    this.d.a(1);
    notifyItemChanged(j());
  }
  
  public void m() {
    if (i() == 0)
      return; 
    this.c = false;
    this.d.a(3);
    notifyItemChanged(j());
  }
  
  public List<T> n() {
    return this.n;
  }
  
  public int o() {
    LinearLayout linearLayout = this.w;
    return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView) {
    super.onAttachedToRecyclerView(paramRecyclerView);
    RecyclerView.LayoutManager layoutManager = paramRecyclerView.getLayoutManager();
    if (layoutManager instanceof GridLayoutManager) {
      GridLayoutManager gridLayoutManager = (GridLayoutManager)layoutManager;
      gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this, gridLayoutManager) {
            public int getSpanSize(int param1Int) {
              int i = this.d.getItemViewType(param1Int);
              boolean bool = true;
              if (i == 273 && this.d.s())
                return 1; 
              if (i == 819 && this.d.t())
                return 1; 
              if (BaseQuickAdapter.c(this.d) == null) {
                param1Int = bool;
                if (this.d.f(i))
                  param1Int = this.c.getSpanCount(); 
                return param1Int;
              } 
              return this.d.f(i) ? this.c.getSpanCount() : BaseQuickAdapter.c(this.d).a(this.c, param1Int - this.d.o());
            }
          });
    } 
  }
  
  public int p() {
    LinearLayout linearLayout = this.x;
    return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
  }
  
  public int q() {
    FrameLayout frameLayout = this.y;
    return (frameLayout != null) ? ((frameLayout.getChildCount() == 0) ? 0 : (!this.z ? 0 : ((this.n.size() != 0) ? 0 : 1))) : 0;
  }
  
  public void r() {
    if (this.d.e() == 2)
      return; 
    this.d.a(1);
    notifyItemChanged(j());
  }
  
  public boolean s() {
    return this.H;
  }
  
  public boolean t() {
    return this.I;
  }
  
  public LinearLayout u() {
    return this.w;
  }
  
  public void v() {
    if (p() == 0)
      return; 
    this.x.removeAllViews();
    int i = c();
    if (i != -1)
      notifyItemRemoved(i); 
  }
  
  public final OnItemLongClickListener w() {
    return this.h;
  }
  
  public final OnItemClickListener x() {
    return this.g;
  }
  
  public final OnItemChildClickListener y() {
    return this.i;
  }
  
  public final OnItemChildLongClickListener z() {
    return this.o;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AnimationType {}
  
  public static interface OnItemChildClickListener {
    void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int);
  }
  
  public static interface OnItemChildLongClickListener {
    boolean a(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int);
  }
  
  public static interface OnItemClickListener {
    void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int);
  }
  
  public static interface OnItemLongClickListener {
    boolean a(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int);
  }
  
  public static interface RequestLoadMoreListener {
    void onLoadMoreRequested();
  }
  
  public static interface SpanSizeLookup {
    int a(GridLayoutManager param1GridLayoutManager, int param1Int);
  }
  
  public static interface UpFetchListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\chad\library\adapter\base\BaseQuickAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */