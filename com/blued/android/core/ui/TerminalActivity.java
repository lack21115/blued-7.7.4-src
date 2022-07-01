package com.blued.android.core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.blued_core.R;
import skin.support.SkinCompatManager;

public class TerminalActivity extends BaseFragmentActivity {
  protected FrameLayout c;
  
  private IWindowFocusChangedListener d;
  
  private IRestartListener e;
  
  private boolean f = false;
  
  public static Bundle a(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    bundle.putBoolean("arg_without_fitui", true);
    return bundle;
  }
  
  public static void a(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle, int paramInt) {
    c(paramContext, paramClass, paramBundle).a(paramInt);
  }
  
  public static void a(Fragment paramFragment, Class<? extends Fragment> paramClass, Bundle paramBundle, int paramInt) {
    c((Context)paramFragment.getActivity(), paramClass, paramBundle).a(paramInt, paramFragment);
  }
  
  public static Bundle b(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    bundle.putBoolean("arg_statusbar_darkicon", false);
    return bundle;
  }
  
  public static WrapIntent c(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    return new WrapIntent(paramContext, paramClass, paramBundle, TerminalActivity.class);
  }
  
  public static void d(Context paramContext, Class<? extends Fragment> paramClass, Bundle paramBundle) {
    c(paramContext, paramClass, paramBundle).b();
  }
  
  public String X_() {
    return super.X_();
  }
  
  public void a(IRestartListener paramIRestartListener) {
    this.e = paramIRestartListener;
  }
  
  protected void c(Bundle paramBundle) {
    if (paramBundle != null)
      this.f = paramBundle.getBoolean("arg_bool_backtomain", this.f); 
  }
  
  public boolean f() {
    return super.f();
  }
  
  public void finish() {
    super.finish();
    if (this.f) {
      this.f = false;
      if (isTaskRoot() && AppInfo.b() != null)
        AppInfo.b().b((Context)this); 
    } 
  }
  
  protected void h() {
    Intent intent = getIntent();
    String str = intent.getStringExtra("arg_fragment_class_name");
    if (TextUtils.isEmpty(str)) {
      Log.e("TerminalActivity", "invalid fragment class name");
      finish();
      return;
    } 
    try {
      Fragment fragment = (Fragment)getClassLoader().loadClass(str).newInstance();
      Bundle bundle = intent.getBundleExtra("arg_fragment_args");
      if (bundle != null) {
        fragment.setArguments(bundle);
        c(bundle);
      } 
      FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
      fragmentTransaction.replace(R.id.root_view, fragment, "init_fragment");
      fragmentTransaction.commitAllowingStateLoss();
      return;
    } catch (ClassNotFoundException classNotFoundException) {
      classNotFoundException.printStackTrace();
      finish();
      return;
    } catch (InstantiationException instantiationException) {
      instantiationException.printStackTrace();
      finish();
      return;
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
      finish();
      return;
    } 
  }
  
  public void onBackPressed() {
    if (this.f) {
      this.f = false;
      if (isTaskRoot() && AppInfo.b() != null)
        AppInfo.b().b((Context)this); 
    } 
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle) {
    boolean bool3 = AppInfo.i();
    int i = AppInfo.k();
    int j = AppInfo.l();
    int k = AppInfo.j();
    Bundle bundle = getIntent().getBundleExtra("arg_fragment_args");
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (bundle != null) {
      bool1 = bundle.getBoolean("arg_without_fitui", false);
      bool2 = bundle.getBoolean("arg_statusbar_darkicon", bool3);
      i = bundle.getInt("arg_statusbar_start_color", AppInfo.k());
      j = bundle.getInt("arg_statusbar_end_color", AppInfo.l());
      k = bundle.getInt("arg_window_color", AppInfo.j());
      AppInfo.v = bundle.containsKey("arg_statusbar_darkicon");
    } 
    bool2 = StatusBarHelper.a((Activity)this, bool2, AppInfo.v);
    super.onCreate(paramBundle);
    this.c = new FrameLayout((Context)this);
    this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (bool2) {
      this.c.setFitsSystemWindows(bool1 ^ true);
      if (i != 17170445 && k != 17170445) {
        Drawable drawable = StatusBarHelper.a((Context)this, i, j, k, bool1);
        getWindow().setBackgroundDrawable(drawable);
      } 
      if (!bool1 && SkinCompatManager.a() != null)
        findViewById(16908290).setBackgroundColor(BluedSkinUtils.a((Context)this, i)); 
    } 
    this.c.setId(R.id.root_view);
    setContentView((View)this.c);
    c(paramBundle);
    if (paramBundle == null)
      h(); 
  }
  
  protected void onRestart() {
    super.onRestart();
    IRestartListener iRestartListener = this.e;
    if (iRestartListener != null)
      iRestartListener.a(); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("arg_bool_backtomain", this.f);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    IWindowFocusChangedListener iWindowFocusChangedListener = this.d;
    if (iWindowFocusChangedListener != null)
      iWindowFocusChangedListener.a(); 
  }
  
  public static interface IRestartListener {
    void a();
  }
  
  public static interface IWindowFocusChangedListener {
    void a();
  }
  
  public static class WrapIntent {
    private Context a;
    
    private Intent b = null;
    
    public WrapIntent(Context param1Context, Class<? extends Fragment> param1Class, Bundle param1Bundle, Class<?> param1Class1) {
      this(param1Context, param1Class.getName(), param1Bundle, param1Class1);
    }
    
    public WrapIntent(Context param1Context, String param1String, Bundle param1Bundle, Class<?> param1Class) {
      Context context = param1Context;
      if (param1Context == null)
        context = AppInfo.d(); 
      this.a = context;
      this.b = new Intent(context, param1Class);
      this.b.putExtra("arg_fragment_class_name", param1String);
      this.b.putExtra("arg_fragment_args", param1Bundle);
    }
    
    public Intent a() {
      return this.b;
    }
    
    public void a(int param1Int) {
      Context context = this.a;
      if (context instanceof Activity) {
        ((Activity)context).startActivityForResult(this.b, param1Int);
        return;
      } 
      if (!AppInfo.m())
        return; 
      throw new RuntimeException("invoke showForResult(int) must be Activity!");
    }
    
    public void a(int param1Int, Fragment param1Fragment) {
      if (param1Fragment != null && param1Fragment.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED))
        param1Fragment.startActivityForResult(this.b, param1Int); 
    }
    
    public void b() {
      if (!(this.a instanceof Activity))
        this.b.setFlags(268435456); 
      this.a.startActivity(this.b);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\TerminalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */