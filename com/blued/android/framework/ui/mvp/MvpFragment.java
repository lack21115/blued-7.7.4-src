package com.blued.android.framework.ui.mvp;

import android.app.Dialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.R;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;

public abstract class MvpFragment<T extends MvpPresenter> extends BaseFragment implements MvpView {
  private final String d;
  
  private boolean e;
  
  private boolean f;
  
  private boolean g;
  
  private boolean h;
  
  private volatile boolean i;
  
  private boolean j;
  
  protected T k;
  
  protected View l;
  
  protected Dialog m;
  
  private Unbinder n;
  
  private MvpDispatcher o;
  
  private HashSet<ViewTask> p;
  
  public MvpFragment() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_MVP_");
    stringBuilder.append(getClass().getSimpleName());
    this.d = stringBuilder.toString();
    this.e = false;
    this.f = false;
    this.g = false;
    this.h = false;
    this.i = false;
    this.j = false;
    this.o = null;
    this.p = new HashSet<ViewTask>();
  }
  
  private void E() {
    synchronized (this.p) {
      if (this.p != null) {
        for (ViewTask viewTask : this.p) {
          if (viewTask != null)
            AppInfo.n().removeCallbacks(viewTask); 
        } 
        this.p.clear();
      } 
      return;
    } 
  }
  
  private MvpPresenter a(String paramString, MemoryDataCache paramMemoryDataCache) {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : Ljava/lang/String;
    //   4: astore_3
    //   5: new java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore #4
    //   14: aload #4
    //   16: ldc 'onCreatePresenter, presenterId:'
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload #4
    //   24: aload_1
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_3
    //   30: aload #4
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: invokestatic a : ()Lcom/blued/android/framework/ui/mvp/MvpPresenterManager;
    //   42: aload_1
    //   43: invokevirtual a : (Ljava/lang/String;)Lcom/blued/android/framework/ui/mvp/MvpPresenter;
    //   46: astore #4
    //   48: aload_0
    //   49: getfield d : Ljava/lang/String;
    //   52: astore #5
    //   54: aload #4
    //   56: ifnonnull -> 65
    //   59: ldc 'presenter not exist, create it'
    //   61: astore_3
    //   62: goto -> 68
    //   65: ldc 'presenter exist, use it'
    //   67: astore_3
    //   68: aload #5
    //   70: aload_3
    //   71: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: aload #4
    //   77: astore #5
    //   79: aload #4
    //   81: ifnonnull -> 160
    //   84: aload_0
    //   85: invokespecial k : ()Ljava/lang/Class;
    //   88: astore #5
    //   90: aload #4
    //   92: astore_3
    //   93: aload #5
    //   95: ifnull -> 136
    //   98: aload #5
    //   100: invokevirtual newInstance : ()Ljava/lang/Object;
    //   103: checkcast com/blued/android/framework/ui/mvp/MvpPresenter
    //   106: astore_3
    //   107: aload_2
    //   108: ifnull -> 116
    //   111: aload_3
    //   112: aload_2
    //   113: invokevirtual a : (Lcom/blued/android/framework/ui/mvp/MemoryDataCache;)V
    //   116: aload_3
    //   117: aload_1
    //   118: invokevirtual c_ : (Ljava/lang/String;)V
    //   121: goto -> 136
    //   124: astore_1
    //   125: goto -> 132
    //   128: astore_1
    //   129: aload #4
    //   131: astore_3
    //   132: aload_1
    //   133: invokevirtual printStackTrace : ()V
    //   136: aload_3
    //   137: astore #5
    //   139: aload_3
    //   140: ifnull -> 160
    //   143: invokestatic a : ()Lcom/blued/android/framework/ui/mvp/MvpPresenterManager;
    //   146: aload_3
    //   147: aload_0
    //   148: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   151: invokevirtual getLifecycle : ()Landroidx/lifecycle/Lifecycle;
    //   154: invokevirtual a : (Lcom/blued/android/framework/ui/mvp/MvpPresenter;Landroidx/lifecycle/Lifecycle;)V
    //   157: aload_3
    //   158: astore #5
    //   160: aload #5
    //   162: areturn
    // Exception table:
    //   from	to	target	type
    //   98	107	128	java/lang/Exception
    //   111	116	124	java/lang/Exception
    //   116	121	124	java/lang/Exception
  }
  
  private void c(Runnable paramRunnable, long paramLong) {
    null = new ViewTask(this, paramRunnable);
    if (0L == paramLong) {
      AppInfo.n().post(null);
    } else {
      AppInfo.n().postDelayed(null, paramLong);
    } 
    synchronized (this.p) {
      this.p.add(null);
      return;
    } 
  }
  
  private Class<T> k() {
    try {
      return (getClass().getGenericSuperclass() instanceof ParameterizedType) ? (Class)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0] : null;
    } catch (Exception exception) {
      exception.printStackTrace();
      throw new RuntimeException(exception);
    } 
  }
  
  private boolean l() {
    Fragment fragment = getParentFragment();
    if (fragment instanceof MvpFragment) {
      MvpFragment mvpFragment = (MvpFragment)fragment;
      if (mvpFragment.A() && !mvpFragment.e)
        return false; 
    } 
    return true;
  }
  
  private void m() {
    List list = getChildFragmentManager().getFragments();
    if (list.isEmpty())
      return; 
    for (Fragment fragment : list) {
      if (fragment instanceof MvpFragment) {
        MvpFragment mvpFragment = (MvpFragment)fragment;
        if (mvpFragment.A() && mvpFragment.e)
          mvpFragment.D(); 
      } 
    } 
  }
  
  private void n() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getClass().getName());
      stringBuilder.append("_MVP");
      this.o = Class.forName(stringBuilder.toString()).getConstructor(new Class[0]).newInstance(new Object[0]);
      Log.d(this.d, "Loaded _MVP class and constructor.");
      return;
    } catch (Exception exception) {
      this.o = null;
      return;
    } 
  }
  
  protected boolean A() {
    return false;
  }
  
  protected Dialog B() {
    Dialog dialog = new Dialog(getContext(), R.style.TranslucentBackground);
    dialog.setContentView(R.layout.common_loading_dialog);
    StatusBarHelper.a(dialog.getWindow());
    dialog.setCancelable(true);
    dialog.setCanceledOnTouchOutside(true);
    return dialog;
  }
  
  public final void C() {
    FragmentActivity fragmentActivity = getActivity();
    if (fragmentActivity != null)
      fragmentActivity.finish(); 
  }
  
  protected void D() {
    if (!this.f)
      return; 
    if (A()) {
      if (l()) {
        b_(this.e ^ true);
        m();
        return;
      } 
    } else {
      b_(false);
    } 
  }
  
  protected String a(String paramString) {
    Class<T> clazz = k();
    if (clazz != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(clazz.getSimpleName());
      stringBuilder1.append("_");
      stringBuilder1.append(paramString);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(aG_());
    stringBuilder.append("_");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public void a(Bundle paramBundle) {
    this.n = ButterKnife.a(this, this.l);
  }
  
  public void a(String paramString, List paramList) {
    MvpDispatcher mvpDispatcher = this.o;
    if (mvpDispatcher != null)
      mvpDispatcher.a(this, paramString, paramList); 
  }
  
  public void a(String paramString, boolean paramBoolean) {
    if ("_load_type_default_".equals(paramString))
      w(); 
  }
  
  public void aL_() {
    this.f = false;
    this.g = false;
    this.h = false;
    E();
    this.l = null;
    this.i = false;
    Dialog dialog = this.m;
    if (dialog != null && dialog.isShowing())
      this.m.dismiss(); 
    Unbinder unbinder = this.n;
    if (unbinder != null) {
      unbinder.unbind();
      this.n = null;
    } 
  }
  
  public void b(Runnable paramRunnable) {
    if (paramRunnable != null)
      c(paramRunnable, 0L); 
  }
  
  public void b(Runnable paramRunnable, long paramLong) {
    if (paramRunnable != null)
      c(paramRunnable, paramLong); 
  }
  
  public void b(String paramString) {
    if ("_load_type_default_".equals(paramString))
      v(); 
  }
  
  public void b_(boolean paramBoolean) {
    Log.v(this.d, " onLoadData()");
    if (this.k == null)
      return; 
    if (!t())
      return; 
    if (!this.g) {
      this.g = true;
      List<Pair<String, List>> list = this.k.a();
      if (list != null)
        for (Pair<String, List> pair : list) {
          String str = this.d;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("showDataToUI(), type:");
          stringBuilder.append((String)pair.first);
          Log.v(str, stringBuilder.toString());
          a((String)pair.first, (List)pair.second);
        }  
    } 
    if (!this.h && !paramBoolean) {
      this.h = true;
      this.k.d();
    } 
  }
  
  public void o() {}
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    Log.v(this.d, " onActivityCreated()");
    this.f = true;
    D();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    Log.v(this.d, " onCreate()");
    o();
    n();
    this.k = r();
    T t = this.k;
    if (t != null)
      t.a(getActivity(), getArguments(), paramBundle); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    Log.v(this.d, " onCreateView()");
    View view = this.l;
    if (view != null) {
      if (view.getParent() != null)
        ((ViewGroup)this.l.getParent()).removeView(this.l); 
      return this.l;
    } 
    this.l = paramLayoutInflater.inflate(p(), paramViewGroup, false);
    T t = this.k;
    if (t != null)
      t.a(getActivity(), this); 
    return this.l;
  }
  
  public void onDestroy() {
    super.onDestroy();
    Log.v(this.d, " onDestroy()");
    this.j = false;
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    Log.v(this.d, " onDestroyView()");
    if (!z()) {
      T t = this.k;
      if (t != null)
        t.a(this); 
      aL_();
    } 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    T t = this.k;
    if (t != null)
      t.a(paramBundle); 
  }
  
  public void onStart() {
    super.onStart();
    D();
  }
  
  public void onStop() {
    super.onStop();
    this.h = false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    Log.v(this.d, " onViewCreated()");
    if (!this.i) {
      a(paramBundle);
      this.i = true;
    } 
    if (!this.j) {
      this.j = true;
      T t = this.k;
      if (t != null)
        t.a((LifecycleOwner)getActivity()); 
    } 
  }
  
  protected abstract int p();
  
  public String q() {
    return a(String.valueOf(SystemClock.uptimeMillis()));
  }
  
  protected T r() {
    String str1;
    String str2 = q();
    MvpPresenter mvpPresenter2 = a(str2, (MemoryDataCache)null);
    String str3 = this.d;
    if (mvpPresenter2 == null) {
      str1 = "presenter not exist, create it";
    } else {
      str1 = "presenter exist, use it";
    } 
    Log.v(str3, str1);
    MvpPresenter mvpPresenter1 = mvpPresenter2;
    if (mvpPresenter2 != null) {
      mvpPresenter1 = mvpPresenter2;
      if (mvpPresenter2.h() != null) {
        boolean bool;
        if (getActivity() == mvpPresenter2.h()) {
          bool = true;
        } else {
          bool = false;
        } 
        mvpPresenter1 = mvpPresenter2;
        if (!bool) {
          MemoryDataCache memoryDataCache = mvpPresenter2.f;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str2);
          stringBuilder.append("@");
          stringBuilder.append(getActivity().hashCode());
          mvpPresenter1 = a(stringBuilder.toString(), memoryDataCache);
        } 
      } 
    } 
    return (T)mvpPresenter1;
  }
  
  public T s() {
    return this.k;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    String str = this.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" setUserVisibleHint() ");
    stringBuilder.append(paramBoolean);
    Log.v(str, stringBuilder.toString());
    this.e = paramBoolean;
    D();
  }
  
  public boolean t() {
    return (this.i && getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED));
  }
  
  public void u() {
    this.k.e();
  }
  
  public void v() {
    if (w_().isActive()) {
      if (this.m == null)
        this.m = B(); 
      Dialog dialog = this.m;
      if (dialog != null)
        dialog.show(); 
    } 
  }
  
  public void w() {
    if (w_().isActive()) {
      Dialog dialog = this.m;
      if (dialog != null)
        dialog.dismiss(); 
    } 
  }
  
  public void x() {}
  
  public void y() {}
  
  protected boolean z() {
    return false;
  }
  
  class ViewTask implements Runnable {
    private final Runnable b;
    
    public ViewTask(MvpFragment this$0, Runnable param1Runnable) {
      this.b = param1Runnable;
    }
    
    public void run() {
      synchronized (MvpFragment.a(this.a)) {
        MvpFragment.a(this.a).remove(this);
        if (MvpFragment.b(this.a))
          this.b.run(); 
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\mvp\MvpFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */