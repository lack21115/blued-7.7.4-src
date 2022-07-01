package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.ArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImpl extends AppCompatDelegate implements LayoutInflater.Factory2, MenuBuilder.Callback {
  private static final Map<Class<?>, Integer> t = (Map<Class<?>, Integer>)new ArrayMap();
  
  private static final boolean u;
  
  private static final int[] v = new int[] { 16842836 };
  
  private static boolean w;
  
  private ActionMenuPresenterCallback A;
  
  private PanelMenuPresenterCallback B;
  
  private boolean C = true;
  
  private boolean D;
  
  private ViewGroup E;
  
  private TextView F;
  
  private View G;
  
  private boolean H;
  
  private boolean I;
  
  private boolean J;
  
  private PanelFeatureState[] K;
  
  private PanelFeatureState L;
  
  private boolean M;
  
  private boolean N;
  
  private boolean O;
  
  private boolean P;
  
  private int Q = -100;
  
  private int R;
  
  private boolean S;
  
  private boolean T;
  
  private AutoNightModeManager U;
  
  private AutoNightModeManager V;
  
  private final Runnable W = new Runnable(this) {
      public void run() {
        if ((this.a.s & 0x1) != 0)
          this.a.d(0); 
        if ((this.a.s & 0x1000) != 0)
          this.a.d(108); 
        AppCompatDelegateImpl appCompatDelegateImpl = this.a;
        appCompatDelegateImpl.r = false;
        appCompatDelegateImpl.s = 0;
      }
    };
  
  private boolean X;
  
  private Rect Y;
  
  private Rect Z;
  
  final Object a;
  
  private AppCompatViewInflater aa;
  
  final Context b;
  
  Window c;
  
  final AppCompatCallback d;
  
  ActionBar e;
  
  MenuInflater f;
  
  ActionMode g;
  
  ActionBarContextView h;
  
  PopupWindow i;
  
  Runnable j;
  
  ViewPropertyAnimatorCompat k = null;
  
  boolean l;
  
  boolean m;
  
  boolean n;
  
  boolean o;
  
  boolean p;
  
  boolean q;
  
  boolean r;
  
  int s;
  
  private AppCompatWindowCallback x;
  
  private CharSequence y;
  
  private DecorContentParent z;
  
  static {
    if (u && !w) {
      Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()) {
            private boolean a(Throwable param1Throwable) {
              boolean bool1 = param1Throwable instanceof Resources.NotFoundException;
              boolean bool = false;
              null = bool;
              if (bool1) {
                String str = param1Throwable.getMessage();
                null = bool;
                if (str != null) {
                  if (!str.contains("drawable")) {
                    null = bool;
                    return str.contains("Drawable") ? true : null;
                  } 
                } else {
                  return null;
                } 
              } else {
                return null;
              } 
              return true;
            }
            
            public void uncaughtException(Thread param1Thread, Throwable param1Throwable) {
              if (a(param1Throwable)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(param1Throwable.getMessage());
                stringBuilder.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.toString());
                notFoundException.initCause(param1Throwable.getCause());
                notFoundException.setStackTrace(param1Throwable.getStackTrace());
                this.a.uncaughtException(param1Thread, (Throwable)notFoundException);
                return;
              } 
              this.a.uncaughtException(param1Thread, param1Throwable);
            }
          });
      w = true;
    } 
  }
  
  AppCompatDelegateImpl(Activity paramActivity, AppCompatCallback paramAppCompatCallback) {
    this((Context)paramActivity, (Window)null, paramAppCompatCallback, paramActivity);
  }
  
  AppCompatDelegateImpl(Dialog paramDialog, AppCompatCallback paramAppCompatCallback) {
    this(paramDialog.getContext(), paramDialog.getWindow(), paramAppCompatCallback, paramDialog);
  }
  
  AppCompatDelegateImpl(Context paramContext, Activity paramActivity, AppCompatCallback paramAppCompatCallback) {
    this(paramContext, (Window)null, paramAppCompatCallback, paramActivity);
  }
  
  AppCompatDelegateImpl(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback) {
    this(paramContext, paramWindow, paramAppCompatCallback, paramContext);
  }
  
  private AppCompatDelegateImpl(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback, Object paramObject) {
    this.b = paramContext;
    this.d = paramAppCompatCallback;
    this.a = paramObject;
    if (this.Q == -100 && this.a instanceof Dialog) {
      AppCompatActivity appCompatActivity = p();
      if (appCompatActivity != null)
        this.Q = appCompatActivity.getDelegate().getLocalNightMode(); 
    } 
    if (this.Q == -100) {
      Integer integer = t.get(this.a.getClass());
      if (integer != null) {
        this.Q = integer.intValue();
        t.remove(this.a.getClass());
      } 
    } 
    if (paramWindow != null)
      a(paramWindow); 
    AppCompatDrawableManager.preload();
  }
  
  private void a(Window paramWindow) {
    if (this.c == null) {
      Window.Callback callback = paramWindow.getCallback();
      if (!(callback instanceof AppCompatWindowCallback)) {
        this.x = new AppCompatWindowCallback(this, callback);
        paramWindow.setCallback((Window.Callback)this.x);
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.b, null, v);
        Drawable drawable = tintTypedArray.getDrawableIfKnown(0);
        if (drawable != null)
          paramWindow.setBackgroundDrawable(drawable); 
        tintTypedArray.recycle();
        this.c = paramWindow;
        return;
      } 
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    } 
    throw new IllegalStateException("AppCompat has already installed itself into the Window");
  }
  
  private void a(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent) {
    // Byte code:
    //   0: aload_1
    //   1: getfield o : Z
    //   4: ifne -> 402
    //   7: aload_0
    //   8: getfield q : Z
    //   11: ifeq -> 15
    //   14: return
    //   15: aload_1
    //   16: getfield a : I
    //   19: ifne -> 54
    //   22: aload_0
    //   23: getfield b : Landroid/content/Context;
    //   26: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   29: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   32: getfield screenLayout : I
    //   35: bipush #15
    //   37: iand
    //   38: iconst_4
    //   39: if_icmpne -> 47
    //   42: iconst_1
    //   43: istore_3
    //   44: goto -> 49
    //   47: iconst_0
    //   48: istore_3
    //   49: iload_3
    //   50: ifeq -> 54
    //   53: return
    //   54: aload_0
    //   55: invokevirtual b : ()Landroid/view/Window$Callback;
    //   58: astore #4
    //   60: aload #4
    //   62: ifnull -> 90
    //   65: aload #4
    //   67: aload_1
    //   68: getfield a : I
    //   71: aload_1
    //   72: getfield j : Landroidx/appcompat/view/menu/MenuBuilder;
    //   75: invokeinterface onMenuOpened : (ILandroid/view/Menu;)Z
    //   80: ifne -> 90
    //   83: aload_0
    //   84: aload_1
    //   85: iconst_1
    //   86: invokevirtual a : (Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;Z)V
    //   89: return
    //   90: aload_0
    //   91: getfield b : Landroid/content/Context;
    //   94: ldc_w 'window'
    //   97: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   100: checkcast android/view/WindowManager
    //   103: astore #5
    //   105: aload #5
    //   107: ifnonnull -> 111
    //   110: return
    //   111: aload_0
    //   112: aload_1
    //   113: aload_2
    //   114: invokespecial b : (Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;Landroid/view/KeyEvent;)Z
    //   117: ifne -> 121
    //   120: return
    //   121: aload_1
    //   122: getfield g : Landroid/view/ViewGroup;
    //   125: ifnull -> 170
    //   128: aload_1
    //   129: getfield p : Z
    //   132: ifeq -> 138
    //   135: goto -> 170
    //   138: aload_1
    //   139: getfield i : Landroid/view/View;
    //   142: ifnull -> 334
    //   145: aload_1
    //   146: getfield i : Landroid/view/View;
    //   149: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   152: astore_2
    //   153: aload_2
    //   154: ifnull -> 334
    //   157: aload_2
    //   158: getfield width : I
    //   161: iconst_m1
    //   162: if_icmpne -> 334
    //   165: iconst_m1
    //   166: istore_3
    //   167: goto -> 337
    //   170: aload_1
    //   171: getfield g : Landroid/view/ViewGroup;
    //   174: ifnonnull -> 193
    //   177: aload_0
    //   178: aload_1
    //   179: invokespecial a : (Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;)Z
    //   182: ifeq -> 192
    //   185: aload_1
    //   186: getfield g : Landroid/view/ViewGroup;
    //   189: ifnonnull -> 217
    //   192: return
    //   193: aload_1
    //   194: getfield p : Z
    //   197: ifeq -> 217
    //   200: aload_1
    //   201: getfield g : Landroid/view/ViewGroup;
    //   204: invokevirtual getChildCount : ()I
    //   207: ifle -> 217
    //   210: aload_1
    //   211: getfield g : Landroid/view/ViewGroup;
    //   214: invokevirtual removeAllViews : ()V
    //   217: aload_0
    //   218: aload_1
    //   219: invokespecial c : (Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;)Z
    //   222: ifeq -> 402
    //   225: aload_1
    //   226: invokevirtual hasPanelItems : ()Z
    //   229: ifne -> 233
    //   232: return
    //   233: aload_1
    //   234: getfield h : Landroid/view/View;
    //   237: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   240: astore #4
    //   242: aload #4
    //   244: astore_2
    //   245: aload #4
    //   247: ifnonnull -> 262
    //   250: new android/view/ViewGroup$LayoutParams
    //   253: dup
    //   254: bipush #-2
    //   256: bipush #-2
    //   258: invokespecial <init> : (II)V
    //   261: astore_2
    //   262: aload_1
    //   263: getfield b : I
    //   266: istore_3
    //   267: aload_1
    //   268: getfield g : Landroid/view/ViewGroup;
    //   271: iload_3
    //   272: invokevirtual setBackgroundResource : (I)V
    //   275: aload_1
    //   276: getfield h : Landroid/view/View;
    //   279: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   282: astore #4
    //   284: aload #4
    //   286: instanceof android/view/ViewGroup
    //   289: ifeq -> 304
    //   292: aload #4
    //   294: checkcast android/view/ViewGroup
    //   297: aload_1
    //   298: getfield h : Landroid/view/View;
    //   301: invokevirtual removeView : (Landroid/view/View;)V
    //   304: aload_1
    //   305: getfield g : Landroid/view/ViewGroup;
    //   308: aload_1
    //   309: getfield h : Landroid/view/View;
    //   312: aload_2
    //   313: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   316: aload_1
    //   317: getfield h : Landroid/view/View;
    //   320: invokevirtual hasFocus : ()Z
    //   323: ifne -> 334
    //   326: aload_1
    //   327: getfield h : Landroid/view/View;
    //   330: invokevirtual requestFocus : ()Z
    //   333: pop
    //   334: bipush #-2
    //   336: istore_3
    //   337: aload_1
    //   338: iconst_0
    //   339: putfield n : Z
    //   342: new android/view/WindowManager$LayoutParams
    //   345: dup
    //   346: iload_3
    //   347: bipush #-2
    //   349: aload_1
    //   350: getfield d : I
    //   353: aload_1
    //   354: getfield e : I
    //   357: sipush #1002
    //   360: ldc_w 8519680
    //   363: bipush #-3
    //   365: invokespecial <init> : (IIIIIII)V
    //   368: astore_2
    //   369: aload_2
    //   370: aload_1
    //   371: getfield c : I
    //   374: putfield gravity : I
    //   377: aload_2
    //   378: aload_1
    //   379: getfield f : I
    //   382: putfield windowAnimations : I
    //   385: aload #5
    //   387: aload_1
    //   388: getfield g : Landroid/view/ViewGroup;
    //   391: aload_2
    //   392: invokeinterface addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   397: aload_1
    //   398: iconst_1
    //   399: putfield o : Z
    //   402: return
  }
  
  private void a(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    DecorContentParent decorContentParent = this.z;
    if (decorContentParent != null && decorContentParent.canShowOverflowMenu() && (!ViewConfiguration.get(this.b).hasPermanentMenuKey() || this.z.isOverflowMenuShowPending())) {
      Window.Callback callback = b();
      if (!this.z.isOverflowMenuShowing() || !paramBoolean) {
        if (callback != null && !this.q) {
          if (this.r && (this.s & 0x1) != 0) {
            this.c.getDecorView().removeCallbacks(this.W);
            this.W.run();
          } 
          PanelFeatureState panelFeatureState1 = a(0, true);
          if (panelFeatureState1.j != null && !panelFeatureState1.q && callback.onPreparePanel(0, panelFeatureState1.i, (Menu)panelFeatureState1.j)) {
            callback.onMenuOpened(108, (Menu)panelFeatureState1.j);
            this.z.showOverflowMenu();
          } 
        } 
        return;
      } 
      this.z.hideOverflowMenu();
      if (!this.q) {
        callback.onPanelClosed(108, (Menu)(a(0, true)).j);
        return;
      } 
      return;
    } 
    PanelFeatureState panelFeatureState = a(0, true);
    panelFeatureState.p = true;
    a(panelFeatureState, false);
    a(panelFeatureState, (KeyEvent)null);
  }
  
  private boolean a(ViewParent paramViewParent) {
    if (paramViewParent == null)
      return false; 
    View view = this.c.getDecorView();
    while (true) {
      if (paramViewParent == null)
        return true; 
      if (paramViewParent != view && paramViewParent instanceof View) {
        if (ViewCompat.isAttachedToWindow((View)paramViewParent))
          return false; 
        paramViewParent = paramViewParent.getParent();
        continue;
      } 
      break;
    } 
    return false;
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState) {
    paramPanelFeatureState.a(c());
    paramPanelFeatureState.g = (ViewGroup)new ListMenuDecorView(this, paramPanelFeatureState.l);
    paramPanelFeatureState.c = 81;
    return true;
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2) {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual isSystem : ()Z
    //   4: istore #5
    //   6: iconst_0
    //   7: istore #6
    //   9: iload #5
    //   11: ifeq -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_1
    //   17: getfield m : Z
    //   20: ifne -> 36
    //   23: iload #6
    //   25: istore #5
    //   27: aload_0
    //   28: aload_1
    //   29: aload_3
    //   30: invokespecial b : (Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;Landroid/view/KeyEvent;)Z
    //   33: ifeq -> 60
    //   36: iload #6
    //   38: istore #5
    //   40: aload_1
    //   41: getfield j : Landroidx/appcompat/view/menu/MenuBuilder;
    //   44: ifnull -> 60
    //   47: aload_1
    //   48: getfield j : Landroidx/appcompat/view/menu/MenuBuilder;
    //   51: iload_2
    //   52: aload_3
    //   53: iload #4
    //   55: invokevirtual performShortcut : (ILandroid/view/KeyEvent;I)Z
    //   58: istore #5
    //   60: iload #5
    //   62: ifeq -> 85
    //   65: iload #4
    //   67: iconst_1
    //   68: iand
    //   69: ifne -> 85
    //   72: aload_0
    //   73: getfield z : Landroidx/appcompat/widget/DecorContentParent;
    //   76: ifnonnull -> 85
    //   79: aload_0
    //   80: aload_1
    //   81: iconst_1
    //   82: invokevirtual a : (Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;Z)V
    //   85: iload #5
    //   87: ireturn
  }
  
  private boolean a(boolean paramBoolean) {
    if (this.q)
      return false; 
    int i = r();
    paramBoolean = b(f(i), paramBoolean);
    if (i == 0) {
      i().b();
    } else {
      AutoNightModeManager autoNightModeManager1 = this.U;
      if (autoNightModeManager1 != null)
        autoNightModeManager1.c(); 
    } 
    if (i == 3) {
      s().b();
      return paramBoolean;
    } 
    AutoNightModeManager autoNightModeManager = this.V;
    if (autoNightModeManager != null)
      autoNightModeManager.c(); 
    return paramBoolean;
  }
  
  private boolean b(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/content/Context;
    //   4: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   7: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   10: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   13: getfield uiMode : I
    //   16: bipush #48
    //   18: iand
    //   19: istore #4
    //   21: iconst_1
    //   22: istore #7
    //   24: iload_1
    //   25: iconst_1
    //   26: if_icmpeq -> 46
    //   29: iload_1
    //   30: iconst_2
    //   31: if_icmpeq -> 40
    //   34: iload #4
    //   36: istore_3
    //   37: goto -> 49
    //   40: bipush #32
    //   42: istore_3
    //   43: goto -> 49
    //   46: bipush #16
    //   48: istore_3
    //   49: aload_0
    //   50: invokespecial t : ()Z
    //   53: istore #8
    //   55: iconst_0
    //   56: istore #6
    //   58: iload #6
    //   60: istore #5
    //   62: iload_3
    //   63: iload #4
    //   65: if_icmpeq -> 174
    //   68: iload #6
    //   70: istore #5
    //   72: iload #8
    //   74: ifne -> 174
    //   77: iload #6
    //   79: istore #5
    //   81: getstatic android/os/Build$VERSION.SDK_INT : I
    //   84: bipush #17
    //   86: if_icmplt -> 174
    //   89: iload #6
    //   91: istore #5
    //   93: aload_0
    //   94: getfield N : Z
    //   97: ifne -> 174
    //   100: iload #6
    //   102: istore #5
    //   104: aload_0
    //   105: getfield a : Ljava/lang/Object;
    //   108: instanceof android/view/ContextThemeWrapper
    //   111: ifeq -> 174
    //   114: new android/content/res/Configuration
    //   117: dup
    //   118: invokespecial <init> : ()V
    //   121: astore #9
    //   123: aload #9
    //   125: aload #9
    //   127: getfield uiMode : I
    //   130: bipush #-49
    //   132: iand
    //   133: iload_3
    //   134: ior
    //   135: putfield uiMode : I
    //   138: aload_0
    //   139: getfield a : Ljava/lang/Object;
    //   142: checkcast android/view/ContextThemeWrapper
    //   145: aload #9
    //   147: invokevirtual applyOverrideConfiguration : (Landroid/content/res/Configuration;)V
    //   150: iconst_1
    //   151: istore #5
    //   153: goto -> 174
    //   156: astore #9
    //   158: ldc_w 'AppCompatDelegate'
    //   161: ldc_w 'updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()'
    //   164: aload #9
    //   166: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   169: pop
    //   170: iload #6
    //   172: istore #5
    //   174: aload_0
    //   175: getfield b : Landroid/content/Context;
    //   178: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   181: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   184: getfield uiMode : I
    //   187: bipush #48
    //   189: iand
    //   190: istore #4
    //   192: iload #5
    //   194: istore #6
    //   196: iload #5
    //   198: ifne -> 287
    //   201: iload #5
    //   203: istore #6
    //   205: iload #4
    //   207: iload_3
    //   208: if_icmpeq -> 287
    //   211: iload #5
    //   213: istore #6
    //   215: iload_2
    //   216: ifeq -> 287
    //   219: iload #5
    //   221: istore #6
    //   223: iload #8
    //   225: ifne -> 287
    //   228: iload #5
    //   230: istore #6
    //   232: aload_0
    //   233: getfield N : Z
    //   236: ifeq -> 287
    //   239: getstatic android/os/Build$VERSION.SDK_INT : I
    //   242: bipush #17
    //   244: if_icmpge -> 258
    //   247: iload #5
    //   249: istore #6
    //   251: aload_0
    //   252: getfield O : Z
    //   255: ifeq -> 287
    //   258: aload_0
    //   259: getfield a : Ljava/lang/Object;
    //   262: astore #9
    //   264: iload #5
    //   266: istore #6
    //   268: aload #9
    //   270: instanceof android/app/Activity
    //   273: ifeq -> 287
    //   276: aload #9
    //   278: checkcast android/app/Activity
    //   281: invokestatic recreate : (Landroid/app/Activity;)V
    //   284: iconst_1
    //   285: istore #6
    //   287: iload #6
    //   289: ifne -> 312
    //   292: iload #4
    //   294: iload_3
    //   295: if_icmpeq -> 312
    //   298: aload_0
    //   299: iload_3
    //   300: iload #8
    //   302: invokespecial c : (IZ)V
    //   305: iload #7
    //   307: istore #6
    //   309: goto -> 312
    //   312: iload #6
    //   314: ifeq -> 340
    //   317: aload_0
    //   318: getfield a : Ljava/lang/Object;
    //   321: astore #9
    //   323: aload #9
    //   325: instanceof androidx/appcompat/app/AppCompatActivity
    //   328: ifeq -> 340
    //   331: aload #9
    //   333: checkcast androidx/appcompat/app/AppCompatActivity
    //   336: iload_1
    //   337: invokevirtual a : (I)V
    //   340: iload #6
    //   342: ireturn
    // Exception table:
    //   from	to	target	type
    //   138	150	156	java/lang/IllegalStateException
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/content/Context;
    //   4: astore #4
    //   6: aload_1
    //   7: getfield a : I
    //   10: ifeq -> 25
    //   13: aload #4
    //   15: astore_2
    //   16: aload_1
    //   17: getfield a : I
    //   20: bipush #108
    //   22: if_icmpne -> 191
    //   25: aload #4
    //   27: astore_2
    //   28: aload_0
    //   29: getfield z : Landroidx/appcompat/widget/DecorContentParent;
    //   32: ifnull -> 191
    //   35: new android/util/TypedValue
    //   38: dup
    //   39: invokespecial <init> : ()V
    //   42: astore #5
    //   44: aload #4
    //   46: invokevirtual getTheme : ()Landroid/content/res/Resources$Theme;
    //   49: astore #6
    //   51: aload #6
    //   53: getstatic androidx/appcompat/R$attr.actionBarTheme : I
    //   56: aload #5
    //   58: iconst_1
    //   59: invokevirtual resolveAttribute : (ILandroid/util/TypedValue;Z)Z
    //   62: pop
    //   63: aconst_null
    //   64: astore_2
    //   65: aload #5
    //   67: getfield resourceId : I
    //   70: ifeq -> 112
    //   73: aload #4
    //   75: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   78: invokevirtual newTheme : ()Landroid/content/res/Resources$Theme;
    //   81: astore_2
    //   82: aload_2
    //   83: aload #6
    //   85: invokevirtual setTo : (Landroid/content/res/Resources$Theme;)V
    //   88: aload_2
    //   89: aload #5
    //   91: getfield resourceId : I
    //   94: iconst_1
    //   95: invokevirtual applyStyle : (IZ)V
    //   98: aload_2
    //   99: getstatic androidx/appcompat/R$attr.actionBarWidgetTheme : I
    //   102: aload #5
    //   104: iconst_1
    //   105: invokevirtual resolveAttribute : (ILandroid/util/TypedValue;Z)Z
    //   108: pop
    //   109: goto -> 124
    //   112: aload #6
    //   114: getstatic androidx/appcompat/R$attr.actionBarWidgetTheme : I
    //   117: aload #5
    //   119: iconst_1
    //   120: invokevirtual resolveAttribute : (ILandroid/util/TypedValue;Z)Z
    //   123: pop
    //   124: aload_2
    //   125: astore_3
    //   126: aload #5
    //   128: getfield resourceId : I
    //   131: ifeq -> 165
    //   134: aload_2
    //   135: astore_3
    //   136: aload_2
    //   137: ifnonnull -> 155
    //   140: aload #4
    //   142: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   145: invokevirtual newTheme : ()Landroid/content/res/Resources$Theme;
    //   148: astore_3
    //   149: aload_3
    //   150: aload #6
    //   152: invokevirtual setTo : (Landroid/content/res/Resources$Theme;)V
    //   155: aload_3
    //   156: aload #5
    //   158: getfield resourceId : I
    //   161: iconst_1
    //   162: invokevirtual applyStyle : (IZ)V
    //   165: aload #4
    //   167: astore_2
    //   168: aload_3
    //   169: ifnull -> 191
    //   172: new androidx/appcompat/view/ContextThemeWrapper
    //   175: dup
    //   176: aload #4
    //   178: iconst_0
    //   179: invokespecial <init> : (Landroid/content/Context;I)V
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual getTheme : ()Landroid/content/res/Resources$Theme;
    //   187: aload_3
    //   188: invokevirtual setTo : (Landroid/content/res/Resources$Theme;)V
    //   191: new androidx/appcompat/view/menu/MenuBuilder
    //   194: dup
    //   195: aload_2
    //   196: invokespecial <init> : (Landroid/content/Context;)V
    //   199: astore_2
    //   200: aload_2
    //   201: aload_0
    //   202: invokevirtual setCallback : (Landroidx/appcompat/view/menu/MenuBuilder$Callback;)V
    //   205: aload_1
    //   206: aload_2
    //   207: invokevirtual a : (Landroidx/appcompat/view/menu/MenuBuilder;)V
    //   210: iconst_1
    //   211: ireturn
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent) {
    DecorContentParent decorContentParent;
    int i;
    if (this.q)
      return false; 
    if (paramPanelFeatureState.m)
      return true; 
    PanelFeatureState panelFeatureState = this.L;
    if (panelFeatureState != null && panelFeatureState != paramPanelFeatureState)
      a(panelFeatureState, false); 
    Window.Callback callback = b();
    if (callback != null)
      paramPanelFeatureState.i = callback.onCreatePanelView(paramPanelFeatureState.a); 
    if (paramPanelFeatureState.a == 0 || paramPanelFeatureState.a == 108) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      DecorContentParent decorContentParent1 = this.z;
      if (decorContentParent1 != null)
        decorContentParent1.setMenuPrepared(); 
    } 
    if (paramPanelFeatureState.i == null && (!i || !(a() instanceof ToolbarActionBar))) {
      DecorContentParent decorContentParent1;
      boolean bool;
      if (paramPanelFeatureState.j == null || paramPanelFeatureState.q) {
        if (paramPanelFeatureState.j == null && (!b(paramPanelFeatureState) || paramPanelFeatureState.j == null))
          return false; 
        if (i && this.z != null) {
          if (this.A == null)
            this.A = new ActionMenuPresenterCallback(this); 
          this.z.setMenu((Menu)paramPanelFeatureState.j, this.A);
        } 
        paramPanelFeatureState.j.stopDispatchingItemsChanged();
        if (!callback.onCreatePanelMenu(paramPanelFeatureState.a, (Menu)paramPanelFeatureState.j)) {
          paramPanelFeatureState.a((MenuBuilder)null);
          if (i) {
            decorContentParent = this.z;
            if (decorContentParent != null)
              decorContentParent.setMenu(null, this.A); 
          } 
          return false;
        } 
        ((PanelFeatureState)decorContentParent).q = false;
      } 
      ((PanelFeatureState)decorContentParent).j.stopDispatchingItemsChanged();
      if (((PanelFeatureState)decorContentParent).r != null) {
        ((PanelFeatureState)decorContentParent).j.restoreActionViewStates(((PanelFeatureState)decorContentParent).r);
        ((PanelFeatureState)decorContentParent).r = null;
      } 
      if (!callback.onPreparePanel(0, ((PanelFeatureState)decorContentParent).i, (Menu)((PanelFeatureState)decorContentParent).j)) {
        if (i) {
          decorContentParent1 = this.z;
          if (decorContentParent1 != null)
            decorContentParent1.setMenu(null, this.A); 
        } 
        ((PanelFeatureState)decorContentParent).j.startDispatchingItemsChanged();
        return false;
      } 
      if (decorContentParent1 != null) {
        i = decorContentParent1.getDeviceId();
      } else {
        i = -1;
      } 
      if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
        bool = true;
      } else {
        bool = false;
      } 
      ((PanelFeatureState)decorContentParent).qwertyMode = bool;
      ((PanelFeatureState)decorContentParent).j.setQwertyMode(((PanelFeatureState)decorContentParent).qwertyMode);
      ((PanelFeatureState)decorContentParent).j.startDispatchingItemsChanged();
    } 
    ((PanelFeatureState)decorContentParent).m = true;
    ((PanelFeatureState)decorContentParent).n = false;
    this.L = (PanelFeatureState)decorContentParent;
    return true;
  }
  
  private void c(int paramInt, boolean paramBoolean) {
    Resources resources = this.b.getResources();
    Configuration configuration = new Configuration(resources.getConfiguration());
    configuration.uiMode = paramInt | (resources.getConfiguration()).uiMode & 0xFFFFFFCF;
    resources.updateConfiguration(configuration, null);
    if (Build.VERSION.SDK_INT < 26)
      ResourcesFlusher.a(resources); 
    paramInt = this.R;
    if (paramInt != 0) {
      this.b.setTheme(paramInt);
      if (Build.VERSION.SDK_INT >= 23)
        this.b.getTheme().applyStyle(this.R, true); 
    } 
    if (paramBoolean) {
      Object object = this.a;
      if (object instanceof Activity) {
        object = object;
        if (object instanceof LifecycleOwner) {
          if (((LifecycleOwner)object).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            object.onConfigurationChanged(configuration);
            return;
          } 
        } else if (this.P) {
          object.onConfigurationChanged(configuration);
        } 
      } 
    } 
  }
  
  private boolean c(PanelFeatureState paramPanelFeatureState) {
    if (paramPanelFeatureState.i != null) {
      paramPanelFeatureState.h = paramPanelFeatureState.i;
      return true;
    } 
    if (paramPanelFeatureState.j == null)
      return false; 
    if (this.B == null)
      this.B = new PanelMenuPresenterCallback(this); 
    paramPanelFeatureState.h = (View)paramPanelFeatureState.a(this.B);
    return (paramPanelFeatureState.h != null);
  }
  
  private boolean d(int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getRepeatCount() == 0) {
      PanelFeatureState panelFeatureState = a(paramInt, true);
      if (!panelFeatureState.o)
        return b(panelFeatureState, paramKeyEvent); 
    } 
    return false;
  }
  
  private boolean e(int paramInt, KeyEvent paramKeyEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Landroidx/appcompat/view/ActionMode;
    //   4: ifnull -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: iload_1
    //   11: iconst_1
    //   12: invokevirtual a : (IZ)Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;
    //   15: astore #4
    //   17: iload_1
    //   18: ifne -> 110
    //   21: aload_0
    //   22: getfield z : Landroidx/appcompat/widget/DecorContentParent;
    //   25: astore #5
    //   27: aload #5
    //   29: ifnull -> 110
    //   32: aload #5
    //   34: invokeinterface canShowOverflowMenu : ()Z
    //   39: ifeq -> 110
    //   42: aload_0
    //   43: getfield b : Landroid/content/Context;
    //   46: invokestatic get : (Landroid/content/Context;)Landroid/view/ViewConfiguration;
    //   49: invokevirtual hasPermanentMenuKey : ()Z
    //   52: ifne -> 110
    //   55: aload_0
    //   56: getfield z : Landroidx/appcompat/widget/DecorContentParent;
    //   59: invokeinterface isOverflowMenuShowing : ()Z
    //   64: ifne -> 97
    //   67: aload_0
    //   68: getfield q : Z
    //   71: ifne -> 180
    //   74: aload_0
    //   75: aload #4
    //   77: aload_2
    //   78: invokespecial b : (Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;Landroid/view/KeyEvent;)Z
    //   81: ifeq -> 180
    //   84: aload_0
    //   85: getfield z : Landroidx/appcompat/widget/DecorContentParent;
    //   88: invokeinterface showOverflowMenu : ()Z
    //   93: istore_3
    //   94: goto -> 198
    //   97: aload_0
    //   98: getfield z : Landroidx/appcompat/widget/DecorContentParent;
    //   101: invokeinterface hideOverflowMenu : ()Z
    //   106: istore_3
    //   107: goto -> 198
    //   110: aload #4
    //   112: getfield o : Z
    //   115: ifne -> 185
    //   118: aload #4
    //   120: getfield n : Z
    //   123: ifeq -> 129
    //   126: goto -> 185
    //   129: aload #4
    //   131: getfield m : Z
    //   134: ifeq -> 180
    //   137: aload #4
    //   139: getfield q : Z
    //   142: ifeq -> 162
    //   145: aload #4
    //   147: iconst_0
    //   148: putfield m : Z
    //   151: aload_0
    //   152: aload #4
    //   154: aload_2
    //   155: invokespecial b : (Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;Landroid/view/KeyEvent;)Z
    //   158: istore_3
    //   159: goto -> 164
    //   162: iconst_1
    //   163: istore_3
    //   164: iload_3
    //   165: ifeq -> 180
    //   168: aload_0
    //   169: aload #4
    //   171: aload_2
    //   172: invokespecial a : (Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;Landroid/view/KeyEvent;)V
    //   175: iconst_1
    //   176: istore_3
    //   177: goto -> 198
    //   180: iconst_0
    //   181: istore_3
    //   182: goto -> 198
    //   185: aload #4
    //   187: getfield o : Z
    //   190: istore_3
    //   191: aload_0
    //   192: aload #4
    //   194: iconst_1
    //   195: invokevirtual a : (Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;Z)V
    //   198: iload_3
    //   199: ifeq -> 237
    //   202: aload_0
    //   203: getfield b : Landroid/content/Context;
    //   206: ldc_w 'audio'
    //   209: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   212: checkcast android/media/AudioManager
    //   215: astore_2
    //   216: aload_2
    //   217: ifnull -> 227
    //   220: aload_2
    //   221: iconst_0
    //   222: invokevirtual playSoundEffect : (I)V
    //   225: iload_3
    //   226: ireturn
    //   227: ldc_w 'AppCompatDelegate'
    //   230: ldc_w 'Couldn't get audio manager'
    //   233: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   236: pop
    //   237: iload_3
    //   238: ireturn
  }
  
  private void g(int paramInt) {
    this.s = 1 << paramInt | this.s;
    if (!this.r) {
      ViewCompat.postOnAnimation(this.c.getDecorView(), this.W);
      this.r = true;
    } 
  }
  
  private int h(int paramInt) {
    if (paramInt == 8) {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      return 108;
    } 
    int i = paramInt;
    if (paramInt == 9) {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
      i = 109;
    } 
    return i;
  }
  
  private void j() {
    m();
    if (this.l) {
      if (this.e != null)
        return; 
      Object object = this.a;
      if (object instanceof Activity) {
        this.e = new WindowDecorActionBar((Activity)object, this.m);
      } else if (object instanceof Dialog) {
        this.e = new WindowDecorActionBar((Dialog)object);
      } 
      object = this.e;
      if (object != null)
        object.setDefaultDisplayHomeAsUpEnabled(this.X); 
    } 
  }
  
  private void k() {
    AutoNightModeManager autoNightModeManager = this.U;
    if (autoNightModeManager != null)
      autoNightModeManager.c(); 
    autoNightModeManager = this.V;
    if (autoNightModeManager != null)
      autoNightModeManager.c(); 
  }
  
  private void l() {
    if (this.c == null) {
      Object object = this.a;
      if (object instanceof Activity)
        a(((Activity)object).getWindow()); 
    } 
    if (this.c != null)
      return; 
    throw new IllegalStateException("We have not been given a Window");
  }
  
  private void m() {
    if (!this.D) {
      this.E = n();
      CharSequence charSequence = d();
      if (!TextUtils.isEmpty(charSequence)) {
        DecorContentParent decorContentParent = this.z;
        if (decorContentParent != null) {
          decorContentParent.setWindowTitle(charSequence);
        } else if (a() != null) {
          a().setWindowTitle(charSequence);
        } else {
          TextView textView = this.F;
          if (textView != null)
            textView.setText(charSequence); 
        } 
      } 
      o();
      a(this.E);
      this.D = true;
      PanelFeatureState panelFeatureState = a(0, false);
      if (!this.q && (panelFeatureState == null || panelFeatureState.j == null))
        g(108); 
    } 
  }
  
  private ViewGroup n() {
    StringBuilder stringBuilder;
    TypedArray typedArray = this.b.obtainStyledAttributes(R.styleable.AppCompatTheme);
    if (typedArray.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
      ViewGroup viewGroup;
      if (typedArray.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
        requestWindowFeature(1);
      } else if (typedArray.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
        requestWindowFeature(108);
      } 
      if (typedArray.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false))
        requestWindowFeature(109); 
      if (typedArray.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false))
        requestWindowFeature(10); 
      this.o = typedArray.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
      typedArray.recycle();
      l();
      this.c.getDecorView();
      LayoutInflater layoutInflater = LayoutInflater.from(this.b);
      if (!this.p) {
        if (this.o) {
          viewGroup = (ViewGroup)layoutInflater.inflate(R.layout.abc_dialog_title_material, null);
          this.m = false;
          this.l = false;
        } else if (this.l) {
          Context context;
          TypedValue typedValue = new TypedValue();
          this.b.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
          if (typedValue.resourceId != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.b, typedValue.resourceId);
          } else {
            context = this.b;
          } 
          ViewGroup viewGroup1 = (ViewGroup)LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, null);
          this.z = (DecorContentParent)viewGroup1.findViewById(R.id.decor_content_parent);
          this.z.setWindowCallback(b());
          if (this.m)
            this.z.initFeature(109); 
          if (this.H)
            this.z.initFeature(2); 
          viewGroup = viewGroup1;
          if (this.I) {
            this.z.initFeature(5);
            viewGroup = viewGroup1;
          } 
        } else {
          layoutInflater = null;
        } 
      } else {
        if (this.n) {
          viewGroup = (ViewGroup)layoutInflater.inflate(R.layout.abc_screen_simple_overlay_action_mode, null);
        } else {
          viewGroup = (ViewGroup)viewGroup.inflate(R.layout.abc_screen_simple, null);
        } 
        if (Build.VERSION.SDK_INT >= 21) {
          ViewCompat.setOnApplyWindowInsetsListener((View)viewGroup, new OnApplyWindowInsetsListener(this) {
                public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
                  int i = param1WindowInsetsCompat.getSystemWindowInsetTop();
                  int j = this.a.e(i);
                  WindowInsetsCompat windowInsetsCompat = param1WindowInsetsCompat;
                  if (i != j)
                    windowInsetsCompat = param1WindowInsetsCompat.replaceSystemWindowInsets(param1WindowInsetsCompat.getSystemWindowInsetLeft(), j, param1WindowInsetsCompat.getSystemWindowInsetRight(), param1WindowInsetsCompat.getSystemWindowInsetBottom()); 
                  return ViewCompat.onApplyWindowInsets(param1View, windowInsetsCompat);
                }
              });
        } else {
          ((FitWindowsViewGroup)viewGroup).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener(this) {
                public void onFitSystemWindows(Rect param1Rect) {
                  param1Rect.top = this.a.e(param1Rect.top);
                }
              });
        } 
      } 
      if (viewGroup != null) {
        if (this.z == null)
          this.F = (TextView)viewGroup.findViewById(R.id.title); 
        ViewUtils.makeOptionalFitsSystemWindows((View)viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout)viewGroup.findViewById(R.id.action_bar_activity_content);
        ViewGroup viewGroup1 = (ViewGroup)this.c.findViewById(16908290);
        if (viewGroup1 != null) {
          while (viewGroup1.getChildCount() > 0) {
            View view = viewGroup1.getChildAt(0);
            viewGroup1.removeViewAt(0);
            contentFrameLayout.addView(view);
          } 
          viewGroup1.setId(-1);
          contentFrameLayout.setId(16908290);
          if (viewGroup1 instanceof FrameLayout)
            ((FrameLayout)viewGroup1).setForeground(null); 
        } 
        this.c.setContentView((View)viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener(this) {
              public void onAttachedFromWindow() {}
              
              public void onDetachedFromWindow() {
                this.a.h();
              }
            });
        return viewGroup;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("AppCompat does not support the current theme features: { windowActionBar: ");
      stringBuilder.append(this.l);
      stringBuilder.append(", windowActionBarOverlay: ");
      stringBuilder.append(this.m);
      stringBuilder.append(", android:windowIsFloating: ");
      stringBuilder.append(this.o);
      stringBuilder.append(", windowActionModeOverlay: ");
      stringBuilder.append(this.n);
      stringBuilder.append(", windowNoTitle: ");
      stringBuilder.append(this.p);
      stringBuilder.append(" }");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    stringBuilder.recycle();
    throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
  }
  
  private void o() {
    ContentFrameLayout contentFrameLayout = (ContentFrameLayout)this.E.findViewById(16908290);
    View view = this.c.getDecorView();
    contentFrameLayout.setDecorPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    TypedArray typedArray = this.b.obtainStyledAttributes(R.styleable.AppCompatTheme);
    typedArray.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
    typedArray.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
    if (typedArray.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor))
      typedArray.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor()); 
    if (typedArray.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor))
      typedArray.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor()); 
    if (typedArray.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor))
      typedArray.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor()); 
    if (typedArray.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor))
      typedArray.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor()); 
    typedArray.recycle();
    contentFrameLayout.requestLayout();
  }
  
  private AppCompatActivity p() {
    Context context = this.b;
    while (context != null) {
      if (context instanceof AppCompatActivity)
        return (AppCompatActivity)context; 
      if (context instanceof ContextWrapper)
        context = ((ContextWrapper)context).getBaseContext(); 
    } 
    return null;
  }
  
  private void q() {
    if (!this.D)
      return; 
    throw new AndroidRuntimeException("Window feature must be requested before adding content");
  }
  
  private int r() {
    int i = this.Q;
    return (i != -100) ? i : getDefaultNightMode();
  }
  
  private AutoNightModeManager s() {
    if (this.V == null)
      this.V = new AutoBatteryNightModeManager(this, this.b); 
    return this.V;
  }
  
  private boolean t() {
    if (!this.T && this.a instanceof Activity) {
      PackageManager packageManager = this.b.getPackageManager();
      if (packageManager == null)
        return false; 
      try {
        boolean bool;
        ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.b, this.a.getClass()), 0);
        if (activityInfo != null && (activityInfo.configChanges & 0x200) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.S = bool;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", (Throwable)nameNotFoundException);
        this.S = false;
      } 
    } 
    this.T = true;
    return this.S;
  }
  
  final ActionBar a() {
    return this.e;
  }
  
  protected PanelFeatureState a(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield K : [Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;
    //   4: astore #4
    //   6: aload #4
    //   8: ifnull -> 21
    //   11: aload #4
    //   13: astore_3
    //   14: aload #4
    //   16: arraylength
    //   17: iload_1
    //   18: if_icmpgt -> 49
    //   21: iload_1
    //   22: iconst_1
    //   23: iadd
    //   24: anewarray androidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState
    //   27: astore_3
    //   28: aload #4
    //   30: ifnull -> 44
    //   33: aload #4
    //   35: iconst_0
    //   36: aload_3
    //   37: iconst_0
    //   38: aload #4
    //   40: arraylength
    //   41: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   44: aload_0
    //   45: aload_3
    //   46: putfield K : [Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;
    //   49: aload_3
    //   50: iload_1
    //   51: aaload
    //   52: astore #5
    //   54: aload #5
    //   56: astore #4
    //   58: aload #5
    //   60: ifnonnull -> 78
    //   63: new androidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState
    //   66: dup
    //   67: iload_1
    //   68: invokespecial <init> : (I)V
    //   71: astore #4
    //   73: aload_3
    //   74: iload_1
    //   75: aload #4
    //   77: aastore
    //   78: aload #4
    //   80: areturn
  }
  
  PanelFeatureState a(Menu paramMenu) {
    byte b;
    PanelFeatureState[] arrayOfPanelFeatureState = this.K;
    int i = 0;
    if (arrayOfPanelFeatureState != null) {
      b = arrayOfPanelFeatureState.length;
    } else {
      b = 0;
    } 
    while (i < b) {
      PanelFeatureState panelFeatureState = arrayOfPanelFeatureState[i];
      if (panelFeatureState != null && panelFeatureState.j == paramMenu)
        return panelFeatureState; 
      i++;
    } 
    return null;
  }
  
  ActionMode a(ActionMode.Callback paramCallback) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual f : ()V
    //   4: aload_0
    //   5: getfield g : Landroidx/appcompat/view/ActionMode;
    //   8: astore #4
    //   10: aload #4
    //   12: ifnull -> 20
    //   15: aload #4
    //   17: invokevirtual finish : ()V
    //   20: aload_1
    //   21: astore #4
    //   23: aload_1
    //   24: instanceof androidx/appcompat/app/AppCompatDelegateImpl$ActionModeCallbackWrapperV9
    //   27: ifne -> 41
    //   30: new androidx/appcompat/app/AppCompatDelegateImpl$ActionModeCallbackWrapperV9
    //   33: dup
    //   34: aload_0
    //   35: aload_1
    //   36: invokespecial <init> : (Landroidx/appcompat/app/AppCompatDelegateImpl;Landroidx/appcompat/view/ActionMode$Callback;)V
    //   39: astore #4
    //   41: aload_0
    //   42: getfield d : Landroidx/appcompat/app/AppCompatCallback;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -> 69
    //   50: aload_0
    //   51: getfield q : Z
    //   54: ifne -> 69
    //   57: aload_1
    //   58: aload #4
    //   60: invokeinterface onWindowStartingSupportActionMode : (Landroidx/appcompat/view/ActionMode$Callback;)Landroidx/appcompat/view/ActionMode;
    //   65: astore_1
    //   66: goto -> 71
    //   69: aconst_null
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull -> 83
    //   75: aload_0
    //   76: aload_1
    //   77: putfield g : Landroidx/appcompat/view/ActionMode;
    //   80: goto -> 573
    //   83: aload_0
    //   84: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   87: astore_1
    //   88: iconst_1
    //   89: istore_3
    //   90: aload_1
    //   91: ifnonnull -> 353
    //   94: aload_0
    //   95: getfield o : Z
    //   98: ifeq -> 313
    //   101: new android/util/TypedValue
    //   104: dup
    //   105: invokespecial <init> : ()V
    //   108: astore #5
    //   110: aload_0
    //   111: getfield b : Landroid/content/Context;
    //   114: invokevirtual getTheme : ()Landroid/content/res/Resources$Theme;
    //   117: astore_1
    //   118: aload_1
    //   119: getstatic androidx/appcompat/R$attr.actionBarTheme : I
    //   122: aload #5
    //   124: iconst_1
    //   125: invokevirtual resolveAttribute : (ILandroid/util/TypedValue;Z)Z
    //   128: pop
    //   129: aload #5
    //   131: getfield resourceId : I
    //   134: ifeq -> 191
    //   137: aload_0
    //   138: getfield b : Landroid/content/Context;
    //   141: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   144: invokevirtual newTheme : ()Landroid/content/res/Resources$Theme;
    //   147: astore #6
    //   149: aload #6
    //   151: aload_1
    //   152: invokevirtual setTo : (Landroid/content/res/Resources$Theme;)V
    //   155: aload #6
    //   157: aload #5
    //   159: getfield resourceId : I
    //   162: iconst_1
    //   163: invokevirtual applyStyle : (IZ)V
    //   166: new androidx/appcompat/view/ContextThemeWrapper
    //   169: dup
    //   170: aload_0
    //   171: getfield b : Landroid/content/Context;
    //   174: iconst_0
    //   175: invokespecial <init> : (Landroid/content/Context;I)V
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual getTheme : ()Landroid/content/res/Resources$Theme;
    //   183: aload #6
    //   185: invokevirtual setTo : (Landroid/content/res/Resources$Theme;)V
    //   188: goto -> 196
    //   191: aload_0
    //   192: getfield b : Landroid/content/Context;
    //   195: astore_1
    //   196: aload_0
    //   197: new androidx/appcompat/widget/ActionBarContextView
    //   200: dup
    //   201: aload_1
    //   202: invokespecial <init> : (Landroid/content/Context;)V
    //   205: putfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   208: aload_0
    //   209: new android/widget/PopupWindow
    //   212: dup
    //   213: aload_1
    //   214: aconst_null
    //   215: getstatic androidx/appcompat/R$attr.actionModePopupWindowStyle : I
    //   218: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   221: putfield i : Landroid/widget/PopupWindow;
    //   224: aload_0
    //   225: getfield i : Landroid/widget/PopupWindow;
    //   228: iconst_2
    //   229: invokestatic setWindowLayoutType : (Landroid/widget/PopupWindow;I)V
    //   232: aload_0
    //   233: getfield i : Landroid/widget/PopupWindow;
    //   236: aload_0
    //   237: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   240: invokevirtual setContentView : (Landroid/view/View;)V
    //   243: aload_0
    //   244: getfield i : Landroid/widget/PopupWindow;
    //   247: iconst_m1
    //   248: invokevirtual setWidth : (I)V
    //   251: aload_1
    //   252: invokevirtual getTheme : ()Landroid/content/res/Resources$Theme;
    //   255: getstatic androidx/appcompat/R$attr.actionBarSize : I
    //   258: aload #5
    //   260: iconst_1
    //   261: invokevirtual resolveAttribute : (ILandroid/util/TypedValue;Z)Z
    //   264: pop
    //   265: aload #5
    //   267: getfield data : I
    //   270: aload_1
    //   271: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   274: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   277: invokestatic complexToDimensionPixelSize : (ILandroid/util/DisplayMetrics;)I
    //   280: istore_2
    //   281: aload_0
    //   282: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   285: iload_2
    //   286: invokevirtual setContentHeight : (I)V
    //   289: aload_0
    //   290: getfield i : Landroid/widget/PopupWindow;
    //   293: bipush #-2
    //   295: invokevirtual setHeight : (I)V
    //   298: aload_0
    //   299: new androidx/appcompat/app/AppCompatDelegateImpl$6
    //   302: dup
    //   303: aload_0
    //   304: invokespecial <init> : (Landroidx/appcompat/app/AppCompatDelegateImpl;)V
    //   307: putfield j : Ljava/lang/Runnable;
    //   310: goto -> 353
    //   313: aload_0
    //   314: getfield E : Landroid/view/ViewGroup;
    //   317: getstatic androidx/appcompat/R$id.action_mode_bar_stub : I
    //   320: invokevirtual findViewById : (I)Landroid/view/View;
    //   323: checkcast androidx/appcompat/widget/ViewStubCompat
    //   326: astore_1
    //   327: aload_1
    //   328: ifnull -> 353
    //   331: aload_1
    //   332: aload_0
    //   333: invokevirtual c : ()Landroid/content/Context;
    //   336: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   339: invokevirtual setLayoutInflater : (Landroid/view/LayoutInflater;)V
    //   342: aload_0
    //   343: aload_1
    //   344: invokevirtual inflate : ()Landroid/view/View;
    //   347: checkcast androidx/appcompat/widget/ActionBarContextView
    //   350: putfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   353: aload_0
    //   354: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   357: ifnull -> 573
    //   360: aload_0
    //   361: invokevirtual f : ()V
    //   364: aload_0
    //   365: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   368: invokevirtual killMode : ()V
    //   371: aload_0
    //   372: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   375: invokevirtual getContext : ()Landroid/content/Context;
    //   378: astore_1
    //   379: aload_0
    //   380: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   383: astore #5
    //   385: aload_0
    //   386: getfield i : Landroid/widget/PopupWindow;
    //   389: ifnonnull -> 395
    //   392: goto -> 397
    //   395: iconst_0
    //   396: istore_3
    //   397: new androidx/appcompat/view/StandaloneActionMode
    //   400: dup
    //   401: aload_1
    //   402: aload #5
    //   404: aload #4
    //   406: iload_3
    //   407: invokespecial <init> : (Landroid/content/Context;Landroidx/appcompat/widget/ActionBarContextView;Landroidx/appcompat/view/ActionMode$Callback;Z)V
    //   410: astore_1
    //   411: aload #4
    //   413: aload_1
    //   414: aload_1
    //   415: invokevirtual getMenu : ()Landroid/view/Menu;
    //   418: invokeinterface onCreateActionMode : (Landroidx/appcompat/view/ActionMode;Landroid/view/Menu;)Z
    //   423: ifeq -> 568
    //   426: aload_1
    //   427: invokevirtual invalidate : ()V
    //   430: aload_0
    //   431: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   434: aload_1
    //   435: invokevirtual initForMode : (Landroidx/appcompat/view/ActionMode;)V
    //   438: aload_0
    //   439: aload_1
    //   440: putfield g : Landroidx/appcompat/view/ActionMode;
    //   443: aload_0
    //   444: invokevirtual e : ()Z
    //   447: ifeq -> 492
    //   450: aload_0
    //   451: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   454: fconst_0
    //   455: invokevirtual setAlpha : (F)V
    //   458: aload_0
    //   459: aload_0
    //   460: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   463: invokestatic animate : (Landroid/view/View;)Landroidx/core/view/ViewPropertyAnimatorCompat;
    //   466: fconst_1
    //   467: invokevirtual alpha : (F)Landroidx/core/view/ViewPropertyAnimatorCompat;
    //   470: putfield k : Landroidx/core/view/ViewPropertyAnimatorCompat;
    //   473: aload_0
    //   474: getfield k : Landroidx/core/view/ViewPropertyAnimatorCompat;
    //   477: new androidx/appcompat/app/AppCompatDelegateImpl$7
    //   480: dup
    //   481: aload_0
    //   482: invokespecial <init> : (Landroidx/appcompat/app/AppCompatDelegateImpl;)V
    //   485: invokevirtual setListener : (Landroidx/core/view/ViewPropertyAnimatorListener;)Landroidx/core/view/ViewPropertyAnimatorCompat;
    //   488: pop
    //   489: goto -> 543
    //   492: aload_0
    //   493: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   496: fconst_1
    //   497: invokevirtual setAlpha : (F)V
    //   500: aload_0
    //   501: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   504: iconst_0
    //   505: invokevirtual setVisibility : (I)V
    //   508: aload_0
    //   509: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   512: bipush #32
    //   514: invokevirtual sendAccessibilityEvent : (I)V
    //   517: aload_0
    //   518: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   521: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   524: instanceof android/view/View
    //   527: ifeq -> 543
    //   530: aload_0
    //   531: getfield h : Landroidx/appcompat/widget/ActionBarContextView;
    //   534: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   537: checkcast android/view/View
    //   540: invokestatic requestApplyInsets : (Landroid/view/View;)V
    //   543: aload_0
    //   544: getfield i : Landroid/widget/PopupWindow;
    //   547: ifnull -> 573
    //   550: aload_0
    //   551: getfield c : Landroid/view/Window;
    //   554: invokevirtual getDecorView : ()Landroid/view/View;
    //   557: aload_0
    //   558: getfield j : Ljava/lang/Runnable;
    //   561: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   564: pop
    //   565: goto -> 573
    //   568: aload_0
    //   569: aconst_null
    //   570: putfield g : Landroidx/appcompat/view/ActionMode;
    //   573: aload_0
    //   574: getfield g : Landroidx/appcompat/view/ActionMode;
    //   577: astore_1
    //   578: aload_1
    //   579: ifnull -> 601
    //   582: aload_0
    //   583: getfield d : Landroidx/appcompat/app/AppCompatCallback;
    //   586: astore #4
    //   588: aload #4
    //   590: ifnull -> 601
    //   593: aload #4
    //   595: aload_1
    //   596: invokeinterface onSupportActionModeStarted : (Landroidx/appcompat/view/ActionMode;)V
    //   601: aload_0
    //   602: getfield g : Landroidx/appcompat/view/ActionMode;
    //   605: areturn
    //   606: astore_1
    //   607: goto -> 69
    // Exception table:
    //   from	to	target	type
    //   57	66	606	java/lang/AbstractMethodError
  }
  
  void a(int paramInt) {
    if (paramInt == 108) {
      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null) {
        actionBar.dispatchMenuVisibilityChanged(false);
        return;
      } 
    } else if (paramInt == 0) {
      PanelFeatureState panelFeatureState = a(paramInt, true);
      if (panelFeatureState.o)
        a(panelFeatureState, false); 
    } 
  }
  
  void a(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu) {
    MenuBuilder menuBuilder;
    PanelFeatureState panelFeatureState = paramPanelFeatureState;
    Menu menu = paramMenu;
    if (paramMenu == null) {
      PanelFeatureState panelFeatureState1 = paramPanelFeatureState;
      if (paramPanelFeatureState == null) {
        panelFeatureState1 = paramPanelFeatureState;
        if (paramInt >= 0) {
          PanelFeatureState[] arrayOfPanelFeatureState = this.K;
          panelFeatureState1 = paramPanelFeatureState;
          if (paramInt < arrayOfPanelFeatureState.length)
            panelFeatureState1 = arrayOfPanelFeatureState[paramInt]; 
        } 
      } 
      panelFeatureState = panelFeatureState1;
      menu = paramMenu;
      if (panelFeatureState1 != null) {
        menuBuilder = panelFeatureState1.j;
        panelFeatureState = panelFeatureState1;
      } 
    } 
    if (panelFeatureState != null && !panelFeatureState.o)
      return; 
    if (!this.q)
      this.x.getWrapped().onPanelClosed(paramInt, (Menu)menuBuilder); 
  }
  
  void a(ViewGroup paramViewGroup) {}
  
  void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean) {
    if (paramBoolean && paramPanelFeatureState.a == 0) {
      DecorContentParent decorContentParent = this.z;
      if (decorContentParent != null && decorContentParent.isOverflowMenuShowing()) {
        a(paramPanelFeatureState.j);
        return;
      } 
    } 
    WindowManager windowManager = (WindowManager)this.b.getSystemService("window");
    if (windowManager != null && paramPanelFeatureState.o && paramPanelFeatureState.g != null) {
      windowManager.removeView((View)paramPanelFeatureState.g);
      if (paramBoolean)
        a(paramPanelFeatureState.a, paramPanelFeatureState, (Menu)null); 
    } 
    paramPanelFeatureState.m = false;
    paramPanelFeatureState.n = false;
    paramPanelFeatureState.o = false;
    paramPanelFeatureState.h = null;
    paramPanelFeatureState.p = true;
    if (this.L == paramPanelFeatureState)
      this.L = null; 
  }
  
  void a(MenuBuilder paramMenuBuilder) {
    if (this.J)
      return; 
    this.J = true;
    this.z.dismissPopups();
    Window.Callback callback = b();
    if (callback != null && !this.q)
      callback.onPanelClosed(108, (Menu)paramMenuBuilder); 
    this.J = false;
  }
  
  boolean a(int paramInt, KeyEvent paramKeyEvent) {
    PanelFeatureState panelFeatureState1;
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null && actionBar.onKeyShortcut(paramInt, paramKeyEvent))
      return true; 
    PanelFeatureState panelFeatureState2 = this.L;
    if (panelFeatureState2 != null && a(panelFeatureState2, paramKeyEvent.getKeyCode(), paramKeyEvent, 1)) {
      panelFeatureState1 = this.L;
      if (panelFeatureState1 != null)
        panelFeatureState1.n = true; 
      return true;
    } 
    if (this.L == null) {
      panelFeatureState2 = a(0, true);
      b(panelFeatureState2, (KeyEvent)panelFeatureState1);
      boolean bool = a(panelFeatureState2, panelFeatureState1.getKeyCode(), (KeyEvent)panelFeatureState1, 1);
      panelFeatureState2.m = false;
      if (bool)
        return true; 
    } 
    return false;
  }
  
  boolean a(KeyEvent paramKeyEvent) {
    Object object = this.a;
    boolean bool1 = object instanceof KeyEventDispatcher.Component;
    boolean bool = true;
    if (bool1 || object instanceof AppCompatDialog) {
      object = this.c.getDecorView();
      if (object != null && KeyEventDispatcher.dispatchBeforeHierarchy((View)object, paramKeyEvent))
        return true; 
    } 
    if (paramKeyEvent.getKeyCode() == 82 && this.x.getWrapped().dispatchKeyEvent(paramKeyEvent))
      return true; 
    int i = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() != 0)
      bool = false; 
    return bool ? c(i, paramKeyEvent) : b(i, paramKeyEvent);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    m();
    ((ViewGroup)this.E.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.x.getWrapped().onContentChanged();
  }
  
  public boolean applyDayNight() {
    return a(true);
  }
  
  public void attachBaseContext(Context paramContext) {
    a(false);
    this.N = true;
  }
  
  final Window.Callback b() {
    return this.c.getCallback();
  }
  
  void b(int paramInt) {
    if (paramInt == 108) {
      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null)
        actionBar.dispatchMenuVisibilityChanged(true); 
    } 
  }
  
  boolean b(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt != 4) {
      if (paramInt != 82)
        return false; 
      e(0, paramKeyEvent);
      return true;
    } 
    boolean bool = this.M;
    this.M = false;
    PanelFeatureState panelFeatureState = a(0, false);
    if (panelFeatureState != null && panelFeatureState.o) {
      if (!bool)
        a(panelFeatureState, true); 
      return true;
    } 
    return g();
  }
  
  final Context c() {
    Context context;
    ActionBar actionBar1 = getSupportActionBar();
    if (actionBar1 != null) {
      Context context1 = actionBar1.getThemedContext();
    } else {
      actionBar1 = null;
    } 
    ActionBar actionBar2 = actionBar1;
    if (actionBar1 == null)
      context = this.b; 
    return context;
  }
  
  void c(int paramInt) {
    a(a(paramInt, true), true);
  }
  
  boolean c(int paramInt, KeyEvent paramKeyEvent) {
    boolean bool = true;
    if (paramInt != 4) {
      if (paramInt != 82)
        return false; 
      d(0, paramKeyEvent);
      return true;
    } 
    if ((paramKeyEvent.getFlags() & 0x80) == 0)
      bool = false; 
    this.M = bool;
    return false;
  }
  
  public View createView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    AppCompatViewInflater appCompatViewInflater = this.aa;
    boolean bool = false;
    if (appCompatViewInflater == null) {
      String str = this.b.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
      if (str == null || AppCompatViewInflater.class.getName().equals(str)) {
        this.aa = new AppCompatViewInflater();
      } else {
        try {
          this.aa = Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } finally {
          Exception exception = null;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Failed to instantiate custom view inflater ");
          stringBuilder.append(str);
          stringBuilder.append(". Falling back to default.");
          Log.i("AppCompatDelegate", stringBuilder.toString(), exception);
        } 
      } 
    } 
    if (u) {
      if (paramAttributeSet instanceof XmlPullParser) {
        if (((XmlPullParser)paramAttributeSet).getDepth() > 1)
          bool = true; 
      } else {
        bool = a((ViewParent)paramView);
      } 
    } else {
      bool = false;
    } 
    return this.aa.a(paramView, paramString, paramContext, paramAttributeSet, bool, u, true, VectorEnabledTintResources.shouldBeUsed());
  }
  
  final CharSequence d() {
    Object object = this.a;
    return (object instanceof Activity) ? ((Activity)object).getTitle() : this.y;
  }
  
  void d(int paramInt) {
    PanelFeatureState panelFeatureState = a(paramInt, true);
    if (panelFeatureState.j != null) {
      Bundle bundle = new Bundle();
      panelFeatureState.j.saveActionViewStates(bundle);
      if (bundle.size() > 0)
        panelFeatureState.r = bundle; 
      panelFeatureState.j.stopDispatchingItemsChanged();
      panelFeatureState.j.clear();
    } 
    panelFeatureState.q = true;
    panelFeatureState.p = true;
    if ((paramInt == 108 || paramInt == 0) && this.z != null) {
      panelFeatureState = a(0, false);
      if (panelFeatureState != null) {
        panelFeatureState.m = false;
        b(panelFeatureState, (KeyEvent)null);
      } 
    } 
  }
  
  int e(int paramInt) {
    boolean bool1;
    ActionBarContextView actionBarContextView = this.h;
    boolean bool2 = false;
    if (actionBarContextView != null && actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
      boolean bool3;
      int i;
      boolean bool5;
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.h.getLayoutParams();
      boolean bool = this.h.isShown();
      boolean bool4 = true;
      if (bool) {
        boolean bool6;
        if (this.Y == null) {
          this.Y = new Rect();
          this.Z = new Rect();
        } 
        Rect rect1 = this.Y;
        Rect rect2 = this.Z;
        rect1.set(0, paramInt, 0, 0);
        ViewUtils.computeFitSystemWindows((View)this.E, rect1, rect2);
        if (rect2.top == 0) {
          bool3 = paramInt;
        } else {
          bool3 = false;
        } 
        if (marginLayoutParams.topMargin != bool3) {
          marginLayoutParams.topMargin = paramInt;
          View view1 = this.G;
          if (view1 == null) {
            this.G = new View(this.b);
            this.G.setBackgroundColor(this.b.getResources().getColor(R.color.abc_input_method_navigation_guard));
            this.E.addView(this.G, -1, new ViewGroup.LayoutParams(-1, paramInt));
          } else {
            ViewGroup.LayoutParams layoutParams = view1.getLayoutParams();
            if (layoutParams.height != paramInt) {
              layoutParams.height = paramInt;
              this.G.setLayoutParams(layoutParams);
            } 
          } 
          bool6 = true;
        } else {
          bool6 = false;
        } 
        if (this.G == null)
          bool4 = false; 
        bool5 = bool6;
        bool3 = bool4;
        i = paramInt;
        if (!this.n) {
          bool5 = bool6;
          bool3 = bool4;
          i = paramInt;
          if (bool4) {
            i = 0;
            bool5 = bool6;
            bool3 = bool4;
          } 
        } 
      } else {
        boolean bool6;
        if (marginLayoutParams.topMargin != 0) {
          marginLayoutParams.topMargin = 0;
          bool6 = true;
        } else {
          bool6 = false;
        } 
        bool3 = false;
        i = paramInt;
        bool5 = bool6;
      } 
      bool1 = bool3;
      paramInt = i;
      if (bool5) {
        this.h.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
        bool1 = bool3;
        paramInt = i;
      } 
    } else {
      bool1 = false;
    } 
    View view = this.G;
    if (view != null) {
      byte b;
      if (bool1) {
        b = bool2;
      } else {
        b = 8;
      } 
      view.setVisibility(b);
    } 
    return paramInt;
  }
  
  final boolean e() {
    if (this.D) {
      ViewGroup viewGroup = this.E;
      if (viewGroup != null && ViewCompat.isLaidOut((View)viewGroup))
        return true; 
    } 
    return false;
  }
  
  int f(int paramInt) {
    if (paramInt != -100) {
      int i = paramInt;
      if (paramInt != -1)
        if (paramInt != 0) {
          i = paramInt;
          if (paramInt != 1) {
            i = paramInt;
            if (paramInt != 2) {
              if (paramInt == 3)
                return s().getApplyableNightMode(); 
              throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            } 
          } 
        } else {
          if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager)this.b.getSystemService(UiModeManager.class)).getNightMode() == 0)
            return -1; 
          i = i().getApplyableNightMode();
        }  
      return i;
    } 
    return -1;
  }
  
  void f() {
    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.k;
    if (viewPropertyAnimatorCompat != null)
      viewPropertyAnimatorCompat.cancel(); 
  }
  
  public <T extends View> T findViewById(int paramInt) {
    m();
    return (T)this.c.findViewById(paramInt);
  }
  
  boolean g() {
    ActionMode actionMode = this.g;
    if (actionMode != null) {
      actionMode.finish();
      return true;
    } 
    ActionBar actionBar = getSupportActionBar();
    return (actionBar != null && actionBar.collapseActionView());
  }
  
  public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
    return new ActionBarDrawableToggleImpl(this);
  }
  
  public int getLocalNightMode() {
    return this.Q;
  }
  
  public MenuInflater getMenuInflater() {
    if (this.f == null) {
      Context context;
      j();
      ActionBar actionBar = this.e;
      if (actionBar != null) {
        context = actionBar.getThemedContext();
      } else {
        context = this.b;
      } 
      this.f = (MenuInflater)new SupportMenuInflater(context);
    } 
    return this.f;
  }
  
  public ActionBar getSupportActionBar() {
    j();
    return this.e;
  }
  
  void h() {
    DecorContentParent decorContentParent = this.z;
    if (decorContentParent != null)
      decorContentParent.dismissPopups(); 
    if (this.i != null) {
      this.c.getDecorView().removeCallbacks(this.j);
      if (this.i.isShowing())
        try {
          this.i.dismiss();
        } catch (IllegalArgumentException illegalArgumentException) {} 
      this.i = null;
    } 
    f();
    PanelFeatureState panelFeatureState = a(0, false);
    if (panelFeatureState != null && panelFeatureState.j != null)
      panelFeatureState.j.close(); 
  }
  
  public boolean hasWindowFeature(int paramInt) {
    boolean bool;
    int i = h(paramInt);
    boolean bool1 = true;
    if (i != 1) {
      if (i != 2) {
        if (i != 5) {
          if (i != 10) {
            if (i != 108) {
              if (i != 109) {
                bool = false;
              } else {
                bool = this.m;
              } 
            } else {
              bool = this.l;
            } 
          } else {
            bool = this.n;
          } 
        } else {
          bool = this.I;
        } 
      } else {
        bool = this.H;
      } 
    } else {
      bool = this.p;
    } 
    if (!bool) {
      if (this.c.hasFeature(paramInt))
        return true; 
      bool1 = false;
    } 
    return bool1;
  }
  
  final AutoNightModeManager i() {
    if (this.U == null)
      this.U = new AutoTimeNightModeManager(this, TwilightManager.a(this.b)); 
    return this.U;
  }
  
  public void installViewFactory() {
    LayoutInflater layoutInflater = LayoutInflater.from(this.b);
    if (layoutInflater.getFactory() == null) {
      LayoutInflaterCompat.setFactory2(layoutInflater, this);
      return;
    } 
    if (!(layoutInflater.getFactory2() instanceof AppCompatDelegateImpl))
      Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's"); 
  }
  
  public void invalidateOptionsMenu() {
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null && actionBar.invalidateOptionsMenu())
      return; 
    g(0);
  }
  
  public boolean isHandleNativeActionModesEnabled() {
    return this.C;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    if (this.l && this.D) {
      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null)
        actionBar.onConfigurationChanged(paramConfiguration); 
    } 
    AppCompatDrawableManager.get().onConfigurationChanged(this.b);
    a(false);
  }
  
  public void onCreate(Bundle paramBundle) {
    this.N = true;
    a(false);
    l();
    Object object = this.a;
    if (object instanceof Activity) {
      Object object1;
      paramBundle = null;
      try {
        object = NavUtils.getParentActivityName((Activity)object);
        object1 = object;
      } catch (IllegalArgumentException illegalArgumentException) {}
      if (object1 != null) {
        object1 = a();
        if (object1 == null) {
          this.X = true;
        } else {
          object1.setDefaultDisplayHomeAsUpEnabled(true);
        } 
      } 
    } 
    this.O = true;
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    return createView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    return onCreateView((View)null, paramString, paramContext, paramAttributeSet);
  }
  
  public void onDestroy() {
    b(this);
    if (this.r)
      this.c.getDecorView().removeCallbacks(this.W); 
    this.P = false;
    this.q = true;
    ActionBar actionBar = this.e;
    if (actionBar != null)
      actionBar.a(); 
    k();
  }
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    Window.Callback callback = b();
    if (callback != null && !this.q) {
      PanelFeatureState panelFeatureState = a((Menu)paramMenuBuilder.getRootMenu());
      if (panelFeatureState != null)
        return callback.onMenuItemSelected(panelFeatureState.a, paramMenuItem); 
    } 
    return false;
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder) {
    a(paramMenuBuilder, true);
  }
  
  public void onPostCreate(Bundle paramBundle) {
    m();
  }
  
  public void onPostResume() {
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null)
      actionBar.setShowHideAnimationEnabled(true); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    if (this.Q != -100)
      t.put(this.a.getClass(), Integer.valueOf(this.Q)); 
  }
  
  public void onStart() {
    this.P = true;
    applyDayNight();
    a(this);
  }
  
  public void onStop() {
    this.P = false;
    b(this);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null)
      actionBar.setShowHideAnimationEnabled(false); 
    if (this.a instanceof Dialog)
      k(); 
  }
  
  public boolean requestWindowFeature(int paramInt) {
    paramInt = h(paramInt);
    if (this.p && paramInt == 108)
      return false; 
    if (this.l && paramInt == 1)
      this.l = false; 
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 5) {
          if (paramInt != 10) {
            if (paramInt != 108) {
              if (paramInt != 109)
                return this.c.requestFeature(paramInt); 
              q();
              this.m = true;
              return true;
            } 
            q();
            this.l = true;
            return true;
          } 
          q();
          this.n = true;
          return true;
        } 
        q();
        this.I = true;
        return true;
      } 
      q();
      this.H = true;
      return true;
    } 
    q();
    this.p = true;
    return true;
  }
  
  public void setContentView(int paramInt) {
    m();
    ViewGroup viewGroup = (ViewGroup)this.E.findViewById(16908290);
    viewGroup.removeAllViews();
    LayoutInflater.from(this.b).inflate(paramInt, viewGroup);
    this.x.getWrapped().onContentChanged();
  }
  
  public void setContentView(View paramView) {
    m();
    ViewGroup viewGroup = (ViewGroup)this.E.findViewById(16908290);
    viewGroup.removeAllViews();
    viewGroup.addView(paramView);
    this.x.getWrapped().onContentChanged();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    m();
    ViewGroup viewGroup = (ViewGroup)this.E.findViewById(16908290);
    viewGroup.removeAllViews();
    viewGroup.addView(paramView, paramLayoutParams);
    this.x.getWrapped().onContentChanged();
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean) {
    this.C = paramBoolean;
  }
  
  public void setLocalNightMode(int paramInt) {
    if (this.Q != paramInt) {
      this.Q = paramInt;
      applyDayNight();
    } 
  }
  
  public void setSupportActionBar(Toolbar paramToolbar) {
    if (!(this.a instanceof Activity))
      return; 
    ActionBar actionBar = getSupportActionBar();
    if (!(actionBar instanceof WindowDecorActionBar)) {
      this.f = null;
      if (actionBar != null)
        actionBar.a(); 
      if (paramToolbar != null) {
        ToolbarActionBar toolbarActionBar = new ToolbarActionBar(paramToolbar, d(), (Window.Callback)this.x);
        this.e = toolbarActionBar;
        this.c.setCallback(toolbarActionBar.getWrappedWindowCallback());
      } else {
        this.e = null;
        this.c.setCallback((Window.Callback)this.x);
      } 
      invalidateOptionsMenu();
      return;
    } 
    throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
  }
  
  public void setTheme(int paramInt) {
    this.R = paramInt;
  }
  
  public final void setTitle(CharSequence paramCharSequence) {
    this.y = paramCharSequence;
    DecorContentParent decorContentParent = this.z;
    if (decorContentParent != null) {
      decorContentParent.setWindowTitle(paramCharSequence);
      return;
    } 
    if (a() != null) {
      a().setWindowTitle(paramCharSequence);
      return;
    } 
    TextView textView = this.F;
    if (textView != null)
      textView.setText(paramCharSequence); 
  }
  
  public ActionMode startSupportActionMode(ActionMode.Callback paramCallback) {
    if (paramCallback != null) {
      ActionMode actionMode = this.g;
      if (actionMode != null)
        actionMode.finish(); 
      paramCallback = new ActionModeCallbackWrapperV9(this, paramCallback);
      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null) {
        this.g = actionBar.startActionMode(paramCallback);
        ActionMode actionMode1 = this.g;
        if (actionMode1 != null) {
          AppCompatCallback appCompatCallback = this.d;
          if (appCompatCallback != null)
            appCompatCallback.onSupportActionModeStarted(actionMode1); 
        } 
      } 
      if (this.g == null)
        this.g = a(paramCallback); 
      return this.g;
    } 
    throw new IllegalArgumentException("ActionMode callback can not be null.");
  }
  
  static {
    boolean bool;
  }
  
  static {
    if (Build.VERSION.SDK_INT < 21) {
      bool = true;
    } else {
      bool = false;
    } 
    u = bool;
  }
  
  class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
    ActionBarDrawableToggleImpl(AppCompatDelegateImpl this$0) {}
    
    public Context getActionBarThemedContext() {
      return this.a.c();
    }
    
    public Drawable getThemeUpIndicator() {
      TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[] { R.attr.homeAsUpIndicator });
      Drawable drawable = tintTypedArray.getDrawable(0);
      tintTypedArray.recycle();
      return drawable;
    }
    
    public boolean isNavigationVisible() {
      ActionBar actionBar = this.a.getSupportActionBar();
      return (actionBar != null && (actionBar.getDisplayOptions() & 0x4) != 0);
    }
    
    public void setActionBarDescription(int param1Int) {
      ActionBar actionBar = this.a.getSupportActionBar();
      if (actionBar != null)
        actionBar.setHomeActionContentDescription(param1Int); 
    }
    
    public void setActionBarUpIndicator(Drawable param1Drawable, int param1Int) {
      ActionBar actionBar = this.a.getSupportActionBar();
      if (actionBar != null) {
        actionBar.setHomeAsUpIndicator(param1Drawable);
        actionBar.setHomeActionContentDescription(param1Int);
      } 
    }
  }
  
  final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
    ActionMenuPresenterCallback(AppCompatDelegateImpl this$0) {}
    
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {
      this.a.a(param1MenuBuilder);
    }
    
    public boolean onOpenSubMenu(MenuBuilder param1MenuBuilder) {
      Window.Callback callback = this.a.b();
      if (callback != null)
        callback.onMenuOpened(108, (Menu)param1MenuBuilder); 
      return true;
    }
  }
  
  class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
    private ActionMode.Callback b;
    
    public ActionModeCallbackWrapperV9(AppCompatDelegateImpl this$0, ActionMode.Callback param1Callback) {
      this.b = param1Callback;
    }
    
    public boolean onActionItemClicked(ActionMode param1ActionMode, MenuItem param1MenuItem) {
      return this.b.onActionItemClicked(param1ActionMode, param1MenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode param1ActionMode, Menu param1Menu) {
      return this.b.onCreateActionMode(param1ActionMode, param1Menu);
    }
    
    public void onDestroyActionMode(ActionMode param1ActionMode) {
      this.b.onDestroyActionMode(param1ActionMode);
      if (this.a.i != null)
        this.a.c.getDecorView().removeCallbacks(this.a.j); 
      if (this.a.h != null) {
        this.a.f();
        AppCompatDelegateImpl appCompatDelegateImpl = this.a;
        appCompatDelegateImpl.k = ViewCompat.animate((View)appCompatDelegateImpl.h).alpha(0.0F);
        this.a.k.setListener((ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerAdapter(this) {
              public void onAnimationEnd(View param2View) {
                this.a.a.h.setVisibility(8);
                if (this.a.a.i != null) {
                  this.a.a.i.dismiss();
                } else if (this.a.a.h.getParent() instanceof View) {
                  ViewCompat.requestApplyInsets((View)this.a.a.h.getParent());
                } 
                this.a.a.h.removeAllViews();
                this.a.a.k.setListener(null);
                this.a.a.k = null;
              }
            });
      } 
      if (this.a.d != null)
        this.a.d.onSupportActionModeFinished(this.a.g); 
      this.a.g = null;
    }
    
    public boolean onPrepareActionMode(ActionMode param1ActionMode, Menu param1Menu) {
      return this.b.onPrepareActionMode(param1ActionMode, param1Menu);
    }
  }
  
  class null extends ViewPropertyAnimatorListenerAdapter {
    null(AppCompatDelegateImpl this$0) {}
    
    public void onAnimationEnd(View param1View) {
      this.a.a.h.setVisibility(8);
      if (this.a.a.i != null) {
        this.a.a.i.dismiss();
      } else if (this.a.a.h.getParent() instanceof View) {
        ViewCompat.requestApplyInsets((View)this.a.a.h.getParent());
      } 
      this.a.a.h.removeAllViews();
      this.a.a.k.setListener(null);
      this.a.a.k = null;
    }
  }
  
  class AppCompatWindowCallback extends WindowCallbackWrapper {
    AppCompatWindowCallback(AppCompatDelegateImpl this$0, Window.Callback param1Callback) {
      super(param1Callback);
    }
    
    final ActionMode a(ActionMode.Callback param1Callback) {
      SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(this.a.b, param1Callback);
      ActionMode actionMode = this.a.startSupportActionMode((ActionMode.Callback)callbackWrapper);
      return (actionMode != null) ? callbackWrapper.getActionModeWrapper(actionMode) : null;
    }
    
    public boolean dispatchKeyEvent(KeyEvent param1KeyEvent) {
      return (this.a.a(param1KeyEvent) || super.dispatchKeyEvent(param1KeyEvent));
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent param1KeyEvent) {
      return (super.dispatchKeyShortcutEvent(param1KeyEvent) || this.a.a(param1KeyEvent.getKeyCode(), param1KeyEvent));
    }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int param1Int, Menu param1Menu) {
      return (param1Int == 0 && !(param1Menu instanceof MenuBuilder)) ? false : super.onCreatePanelMenu(param1Int, param1Menu);
    }
    
    public boolean onMenuOpened(int param1Int, Menu param1Menu) {
      super.onMenuOpened(param1Int, param1Menu);
      this.a.b(param1Int);
      return true;
    }
    
    public void onPanelClosed(int param1Int, Menu param1Menu) {
      super.onPanelClosed(param1Int, param1Menu);
      this.a.a(param1Int);
    }
    
    public boolean onPreparePanel(int param1Int, View param1View, Menu param1Menu) {
      MenuBuilder menuBuilder;
      if (param1Menu instanceof MenuBuilder) {
        menuBuilder = (MenuBuilder)param1Menu;
      } else {
        menuBuilder = null;
      } 
      if (param1Int == 0 && menuBuilder == null)
        return false; 
      if (menuBuilder != null)
        menuBuilder.setOverrideVisibleItems(true); 
      boolean bool = super.onPreparePanel(param1Int, param1View, param1Menu);
      if (menuBuilder != null)
        menuBuilder.setOverrideVisibleItems(false); 
      return bool;
    }
    
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> param1List, Menu param1Menu, int param1Int) {
      AppCompatDelegateImpl.PanelFeatureState panelFeatureState = this.a.a(0, true);
      if (panelFeatureState != null && panelFeatureState.j != null) {
        super.onProvideKeyboardShortcuts(param1List, (Menu)panelFeatureState.j, param1Int);
        return;
      } 
      super.onProvideKeyboardShortcuts(param1List, param1Menu, param1Int);
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback param1Callback) {
      return (Build.VERSION.SDK_INT >= 23) ? null : (this.a.isHandleNativeActionModesEnabled() ? a(param1Callback) : super.onWindowStartingActionMode(param1Callback));
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback param1Callback, int param1Int) {
      return (!this.a.isHandleNativeActionModesEnabled() || param1Int != 0) ? super.onWindowStartingActionMode(param1Callback, param1Int) : a(param1Callback);
    }
  }
  
  class AutoBatteryNightModeManager extends AutoNightModeManager {
    private final PowerManager c;
    
    AutoBatteryNightModeManager(AppCompatDelegateImpl this$0, Context param1Context) {
      super(this$0);
      this.c = (PowerManager)param1Context.getSystemService("power");
    }
    
    IntentFilter a() {
      if (Build.VERSION.SDK_INT >= 21) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        return intentFilter;
      } 
      return null;
    }
    
    public int getApplyableNightMode() {
      int i = Build.VERSION.SDK_INT;
      byte b2 = 1;
      byte b1 = b2;
      if (i >= 21) {
        b1 = b2;
        if (this.c.isPowerSaveMode())
          b1 = 2; 
      } 
      return b1;
    }
    
    public void onChange() {
      this.a.applyDayNight();
    }
  }
  
  abstract class AutoNightModeManager {
    private BroadcastReceiver a;
    
    AutoNightModeManager(AppCompatDelegateImpl this$0) {}
    
    abstract IntentFilter a();
    
    void b() {
      c();
      IntentFilter intentFilter = a();
      if (intentFilter != null) {
        if (intentFilter.countActions() == 0)
          return; 
        if (this.a == null)
          this.a = new BroadcastReceiver(this) {
              public void onReceive(Context param2Context, Intent param2Intent) {
                this.a.onChange();
              }
            }; 
        this.b.b.registerReceiver(this.a, intentFilter);
      } 
    }
    
    void c() {
      if (this.a != null) {
        try {
          this.b.b.unregisterReceiver(this.a);
        } catch (IllegalArgumentException illegalArgumentException) {}
        this.a = null;
      } 
    }
    
    abstract int getApplyableNightMode();
    
    abstract void onChange();
  }
  
  class null extends BroadcastReceiver {
    null(AppCompatDelegateImpl this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      this.a.onChange();
    }
  }
  
  class AutoTimeNightModeManager extends AutoNightModeManager {
    private final TwilightManager c;
    
    AutoTimeNightModeManager(AppCompatDelegateImpl this$0, TwilightManager param1TwilightManager) {
      super(this$0);
      this.c = param1TwilightManager;
    }
    
    IntentFilter a() {
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("android.intent.action.TIME_SET");
      intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
      intentFilter.addAction("android.intent.action.TIME_TICK");
      return intentFilter;
    }
    
    public int getApplyableNightMode() {
      return this.c.a() ? 2 : 1;
    }
    
    public void onChange() {
      this.a.applyDayNight();
    }
  }
  
  class ListMenuDecorView extends ContentFrameLayout {
    public ListMenuDecorView(AppCompatDelegateImpl this$0, Context param1Context) {
      super(param1Context);
    }
    
    private boolean a(int param1Int1, int param1Int2) {
      return (param1Int1 < -5 || param1Int2 < -5 || param1Int1 > getWidth() + 5 || param1Int2 > getHeight() + 5);
    }
    
    public boolean dispatchKeyEvent(KeyEvent param1KeyEvent) {
      return (this.a.a(param1KeyEvent) || super.dispatchKeyEvent(param1KeyEvent));
    }
    
    public boolean onInterceptTouchEvent(MotionEvent param1MotionEvent) {
      if (param1MotionEvent.getAction() == 0 && a((int)param1MotionEvent.getX(), (int)param1MotionEvent.getY())) {
        this.a.c(0);
        return true;
      } 
      return super.onInterceptTouchEvent(param1MotionEvent);
    }
    
    public void setBackgroundResource(int param1Int) {
      setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), param1Int));
    }
  }
  
  public static final class PanelFeatureState {
    int a;
    
    int b;
    
    int c;
    
    int d;
    
    int e;
    
    int f;
    
    ViewGroup g;
    
    View h;
    
    View i;
    
    MenuBuilder j;
    
    ListMenuPresenter k;
    
    Context l;
    
    boolean m;
    
    boolean n;
    
    boolean o;
    
    boolean p;
    
    boolean q;
    
    public boolean qwertyMode;
    
    Bundle r;
    
    PanelFeatureState(int param1Int) {
      this.a = param1Int;
      this.p = false;
    }
    
    MenuView a(MenuPresenter.Callback param1Callback) {
      if (this.j == null)
        return null; 
      if (this.k == null) {
        this.k = new ListMenuPresenter(this.l, R.layout.abc_list_menu_item_layout);
        this.k.setCallback(param1Callback);
        this.j.addMenuPresenter((MenuPresenter)this.k);
      } 
      return this.k.getMenuView(this.g);
    }
    
    void a(Context param1Context) {
      TypedValue typedValue = new TypedValue();
      Resources.Theme theme = param1Context.getResources().newTheme();
      theme.setTo(param1Context.getTheme());
      theme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
      if (typedValue.resourceId != 0)
        theme.applyStyle(typedValue.resourceId, true); 
      theme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
      if (typedValue.resourceId != 0) {
        theme.applyStyle(typedValue.resourceId, true);
      } else {
        theme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
      } 
      ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(param1Context, 0);
      contextThemeWrapper.getTheme().setTo(theme);
      this.l = (Context)contextThemeWrapper;
      TypedArray typedArray = contextThemeWrapper.obtainStyledAttributes(R.styleable.AppCompatTheme);
      this.b = typedArray.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
      this.f = typedArray.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
      typedArray.recycle();
    }
    
    void a(MenuBuilder param1MenuBuilder) {
      MenuBuilder menuBuilder = this.j;
      if (param1MenuBuilder == menuBuilder)
        return; 
      if (menuBuilder != null)
        menuBuilder.removeMenuPresenter((MenuPresenter)this.k); 
      this.j = param1MenuBuilder;
      if (param1MenuBuilder != null) {
        ListMenuPresenter listMenuPresenter = this.k;
        if (listMenuPresenter != null)
          param1MenuBuilder.addMenuPresenter((MenuPresenter)listMenuPresenter); 
      } 
    }
    
    public void clearMenuPresenters() {
      MenuBuilder menuBuilder = this.j;
      if (menuBuilder != null)
        menuBuilder.removeMenuPresenter((MenuPresenter)this.k); 
      this.k = null;
    }
    
    public boolean hasPanelItems() {
      View view = this.h;
      boolean bool = false;
      if (view == null)
        return false; 
      if (this.i != null)
        return true; 
      if (this.k.getAdapter().getCount() > 0)
        bool = true; 
      return bool;
    }
    
    static class SavedState implements Parcelable {
      public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
          public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel param3Parcel) {
            return AppCompatDelegateImpl.PanelFeatureState.SavedState.a(param3Parcel, null);
          }
          
          public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel param3Parcel, ClassLoader param3ClassLoader) {
            return AppCompatDelegateImpl.PanelFeatureState.SavedState.a(param3Parcel, param3ClassLoader);
          }
          
          public AppCompatDelegateImpl.PanelFeatureState.SavedState[] newArray(int param3Int) {
            return new AppCompatDelegateImpl.PanelFeatureState.SavedState[param3Int];
          }
        };
      
      int a;
      
      boolean b;
      
      Bundle c;
      
      static SavedState a(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        SavedState savedState = new SavedState();
        savedState.a = param2Parcel.readInt();
        int i = param2Parcel.readInt();
        boolean bool = true;
        if (i != 1)
          bool = false; 
        savedState.b = bool;
        if (savedState.b)
          savedState.c = param2Parcel.readBundle(param2ClassLoader); 
        return savedState;
      }
      
      public int describeContents() {
        return 0;
      }
      
      public void writeToParcel(Parcel param2Parcel, int param2Int) {
        throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
    }
    
    static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
      public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel param2Parcel) {
        return AppCompatDelegateImpl.PanelFeatureState.SavedState.a(param2Parcel, null);
      }
      
      public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        return AppCompatDelegateImpl.PanelFeatureState.SavedState.a(param2Parcel, param2ClassLoader);
      }
      
      public AppCompatDelegateImpl.PanelFeatureState.SavedState[] newArray(int param2Int) {
        return new AppCompatDelegateImpl.PanelFeatureState.SavedState[param2Int];
      }
    }
  }
  
  static class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel param3Parcel) {
          return AppCompatDelegateImpl.PanelFeatureState.SavedState.a(param3Parcel, null);
        }
        
        public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel param3Parcel, ClassLoader param3ClassLoader) {
          return AppCompatDelegateImpl.PanelFeatureState.SavedState.a(param3Parcel, param3ClassLoader);
        }
        
        public AppCompatDelegateImpl.PanelFeatureState.SavedState[] newArray(int param3Int) {
          return new AppCompatDelegateImpl.PanelFeatureState.SavedState[param3Int];
        }
      };
    
    int a;
    
    boolean b;
    
    Bundle c;
    
    static SavedState a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      SavedState savedState = new SavedState();
      savedState.a = param1Parcel.readInt();
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      savedState.b = bool;
      if (savedState.b)
        savedState.c = param1Parcel.readBundle(param1ClassLoader); 
      return savedState;
    }
    
    public int describeContents() {
      return 0;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<PanelFeatureState.SavedState> {
    public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel param1Parcel) {
      return AppCompatDelegateImpl.PanelFeatureState.SavedState.a(param1Parcel, null);
    }
    
    public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return AppCompatDelegateImpl.PanelFeatureState.SavedState.a(param1Parcel, param1ClassLoader);
    }
    
    public AppCompatDelegateImpl.PanelFeatureState.SavedState[] newArray(int param1Int) {
      return new AppCompatDelegateImpl.PanelFeatureState.SavedState[param1Int];
    }
  }
  
  final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
    PanelMenuPresenterCallback(AppCompatDelegateImpl this$0) {}
    
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {
      boolean bool;
      MenuBuilder menuBuilder = param1MenuBuilder.getRootMenu();
      if (menuBuilder != param1MenuBuilder) {
        bool = true;
      } else {
        bool = false;
      } 
      AppCompatDelegateImpl appCompatDelegateImpl = this.a;
      if (bool)
        param1MenuBuilder = menuBuilder; 
      AppCompatDelegateImpl.PanelFeatureState panelFeatureState = appCompatDelegateImpl.a((Menu)param1MenuBuilder);
      if (panelFeatureState != null) {
        if (bool) {
          this.a.a(panelFeatureState.a, panelFeatureState, (Menu)menuBuilder);
          this.a.a(panelFeatureState, true);
          return;
        } 
        this.a.a(panelFeatureState, param1Boolean);
      } 
    }
    
    public boolean onOpenSubMenu(MenuBuilder param1MenuBuilder) {
      if (param1MenuBuilder == null && this.a.l) {
        Window.Callback callback = this.a.b();
        if (callback != null && !this.a.q)
          callback.onMenuOpened(108, (Menu)param1MenuBuilder); 
      } 
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\app\AppCompatDelegateImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */