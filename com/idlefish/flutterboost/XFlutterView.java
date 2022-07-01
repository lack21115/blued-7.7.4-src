package com.idlefish.flutterboost;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.LocaleList;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterSurfaceView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import io.flutter.view.AccessibilityBridge;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class XFlutterView extends FrameLayout {
  private FlutterView.RenderMode a;
  
  private FlutterView.TransparencyMode b;
  
  private RenderSurface c;
  
  private final Set<FlutterUiDisplayListener> d = new HashSet<FlutterUiDisplayListener>();
  
  private FlutterEngine e;
  
  private final Set<FlutterView.FlutterEngineAttachmentListener> f = new HashSet<FlutterView.FlutterEngineAttachmentListener>();
  
  private XTextInputPlugin g;
  
  private XAndroidKeyProcessor h;
  
  private AndroidTouchProcessor i;
  
  private AccessibilityBridge j;
  
  private boolean k = false;
  
  private boolean l;
  
  private final FlutterRenderer.ViewportMetrics m = new FlutterRenderer.ViewportMetrics();
  
  private final AccessibilityBridge.OnAccessibilityChangeListener n = new AccessibilityBridge.OnAccessibilityChangeListener(this) {
      public void onAccessibilityChanged(boolean param1Boolean1, boolean param1Boolean2) {
        XFlutterView.a(this.a, param1Boolean1, param1Boolean2);
      }
    };
  
  private final FlutterUiDisplayListener o = new FlutterUiDisplayListener(this) {
      public void onFlutterUiDisplayed() {
        XFlutterView.a(this.a, true);
        Iterator<FlutterUiDisplayListener> iterator = XFlutterView.a(this.a).iterator();
        while (iterator.hasNext())
          ((FlutterUiDisplayListener)iterator.next()).onFlutterUiDisplayed(); 
      }
      
      public void onFlutterUiNoLongerDisplayed() {
        XFlutterView.a(this.a, false);
        Iterator<FlutterUiDisplayListener> iterator = XFlutterView.a(this.a).iterator();
        while (iterator.hasNext())
          ((FlutterUiDisplayListener)iterator.next()).onFlutterUiNoLongerDisplayed(); 
      }
    };
  
  public XFlutterView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, (FlutterView.RenderMode)null, (FlutterView.TransparencyMode)null);
  }
  
  private XFlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterView.RenderMode paramRenderMode, FlutterView.TransparencyMode paramTransparencyMode) {
    super(paramContext, paramAttributeSet);
    FlutterView.RenderMode renderMode = paramRenderMode;
    if (paramRenderMode == null)
      renderMode = FlutterView.RenderMode.surface; 
    this.a = renderMode;
    if (paramTransparencyMode == null)
      paramTransparencyMode = FlutterView.TransparencyMode.opaque; 
    this.b = paramTransparencyMode;
    d();
  }
  
  public XFlutterView(Context paramContext, FlutterView.RenderMode paramRenderMode, FlutterView.TransparencyMode paramTransparencyMode) {
    this(paramContext, (AttributeSet)null, paramRenderMode, paramTransparencyMode);
  }
  
  private void a(Configuration paramConfiguration) {
    LocaleList localeList;
    ArrayList<Locale> arrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 24) {
      localeList = paramConfiguration.getLocales();
      int j = localeList.size();
      for (int i = 0; i < j; i++)
        arrayList.add(localeList.get(i)); 
    } else {
      arrayList.add(((Configuration)localeList).locale);
    } 
    FlutterEngine flutterEngine = this.e;
    if (flutterEngine != null && flutterEngine.getLocalizationChannel() != null)
      this.e.getLocalizationChannel().sendLocales(arrayList); 
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool = this.e.getRenderer().isSoftwareRenderingEnabled();
    boolean bool1 = false;
    if (!bool) {
      bool = bool1;
      if (!paramBoolean1) {
        bool = bool1;
        if (!paramBoolean2)
          bool = true; 
      } 
      setWillNotDraw(bool);
      return;
    } 
    setWillNotDraw(false);
  }
  
  private void d() {
    Log.v("FlutterView", "Initializing FlutterView");
    int i = null.a[this.a.ordinal()];
    if (i != 1) {
      if (i == 2) {
        Log.v("FlutterView", "Internally using a FlutterTextureView.");
        XFlutterTextureView xFlutterTextureView = new XFlutterTextureView(getContext());
        this.c = xFlutterTextureView;
        addView((View)xFlutterTextureView);
      } 
    } else {
      boolean bool;
      Log.v("FlutterView", "Internally using a FlutterSurfaceView.");
      Context context = getContext();
      if (this.b == FlutterView.TransparencyMode.transparent) {
        bool = true;
      } else {
        bool = false;
      } 
      FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, bool);
      this.c = (RenderSurface)flutterSurfaceView;
      addView((View)flutterSurfaceView);
    } 
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void e() {
    FlutterEngine flutterEngine = this.e;
    if (flutterEngine != null && flutterEngine.getSettingsChannel() != null)
      this.e.getSettingsChannel().startMessage().setTextScaleFactor((getResources().getConfiguration()).fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).send(); 
  }
  
  private void f() {
    if (!c()) {
      Log.w("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
      return;
    } 
    if (this.m.width == 0 && this.m.height == 0)
      return; 
    this.m.devicePixelRatio = (getResources().getDisplayMetrics()).density;
    this.e.getRenderer().setViewportMetrics(this.m);
  }
  
  public void a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Detaching from a FlutterEngine: ");
    stringBuilder.append(this.e);
    Log.d("FlutterView", stringBuilder.toString());
    if (!c()) {
      Log.d("FlutterView", "Not attached to an engine. Doing nothing.");
      return;
    } 
    Iterator<FlutterView.FlutterEngineAttachmentListener> iterator = this.f.iterator();
    while (iterator.hasNext())
      ((FlutterView.FlutterEngineAttachmentListener)iterator.next()).onFlutterEngineDetachedFromFlutterView(); 
    this.e.getPlatformViewsController().detachAccessibiltyBridge();
    this.e.getPlatformViewsController().detachFromView();
    this.j.release();
    this.j = null;
    FlutterRenderer flutterRenderer = this.e.getRenderer();
    this.l = false;
    flutterRenderer.removeIsDisplayingFlutterUiListener(this.o);
    flutterRenderer.stopRenderingToSurface();
    flutterRenderer.setSemanticsEnabled(false);
    this.c.detachFromRenderer();
    this.e = null;
  }
  
  public void a(FlutterView.FlutterEngineAttachmentListener paramFlutterEngineAttachmentListener) {
    this.f.remove(paramFlutterEngineAttachmentListener);
  }
  
  public void a(FlutterEngine paramFlutterEngine) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Attaching to a FlutterEngine: ");
    stringBuilder.append(paramFlutterEngine);
    Log.d("FlutterView", stringBuilder.toString());
    if (c()) {
      if (paramFlutterEngine == this.e) {
        Log.d("FlutterView", "Already attached to this engine. Doing nothing.");
        return;
      } 
      Log.d("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
      a();
    } 
    this.e = paramFlutterEngine;
    FlutterRenderer flutterRenderer = this.e.getRenderer();
    this.l = flutterRenderer.isDisplayingFlutterUi();
    this.c.attachToRenderer(flutterRenderer);
    flutterRenderer.addIsDisplayingFlutterUiListener(this.o);
    this.e.getPlatformViewsController().attachToView((View)this);
    this.g = XTextInputPlugin.a(this.e.getDartExecutor(), this.e.getPlatformViewsController());
    this.g.b((View)this);
    this.g.a().restartInput((View)this);
    this.h = new XAndroidKeyProcessor(this.e.getKeyEventChannel(), this.g);
    this.i = new AndroidTouchProcessor(this.e.getRenderer());
    this.j = new AccessibilityBridge((View)this, paramFlutterEngine.getAccessibilityChannel(), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), (PlatformViewsAccessibilityDelegate)this.e.getPlatformViewsController());
    this.j.setOnAccessibilityChangeListener(this.n);
    a(this.j.isAccessibilityEnabled(), this.j.isTouchExplorationEnabled());
    this.e.getPlatformViewsController().attachAccessibilityBridge(this.j);
    this.g.a().restartInput((View)this);
    e();
    a(getResources().getConfiguration());
    f();
    Iterator<FlutterView.FlutterEngineAttachmentListener> iterator = this.f.iterator();
    while (iterator.hasNext())
      ((FlutterView.FlutterEngineAttachmentListener)iterator.next()).onFlutterEngineAttachedToFlutterView(paramFlutterEngine); 
  }
  
  public void a(FlutterUiDisplayListener paramFlutterUiDisplayListener) {
    this.d.add(paramFlutterUiDisplayListener);
  }
  
  public void b() {
    XTextInputPlugin xTextInputPlugin = this.g;
    if (xTextInputPlugin != null)
      xTextInputPlugin.a((View)this); 
  }
  
  public void b(FlutterUiDisplayListener paramFlutterUiDisplayListener) {
    this.d.remove(paramFlutterUiDisplayListener);
  }
  
  public boolean c() {
    return (this.e != null);
  }
  
  public boolean checkInputConnectionProxy(View paramView) {
    FlutterEngine flutterEngine = this.e;
    return (flutterEngine != null && paramView != null) ? flutterEngine.getPlatformViewsController().checkInputConnectionProxy(paramView) : super.checkInputConnectionProxy(paramView);
  }
  
  protected boolean fitSystemWindows(Rect paramRect) {
    StringBuilder stringBuilder;
    if (Build.VERSION.SDK_INT <= 19) {
      this.m.paddingTop = paramRect.top;
      this.m.paddingRight = paramRect.right;
      FlutterRenderer.ViewportMetrics viewportMetrics = this.m;
      viewportMetrics.paddingBottom = 0;
      viewportMetrics.paddingLeft = paramRect.left;
      viewportMetrics = this.m;
      viewportMetrics.viewInsetTop = 0;
      viewportMetrics.viewInsetRight = 0;
      viewportMetrics.viewInsetBottom = paramRect.bottom;
      this.m.viewInsetLeft = 0;
      stringBuilder = new StringBuilder();
      stringBuilder.append("Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: ");
      stringBuilder.append(this.m.paddingTop);
      stringBuilder.append(", Left: ");
      stringBuilder.append(this.m.paddingLeft);
      stringBuilder.append(", Right: ");
      stringBuilder.append(this.m.paddingRight);
      stringBuilder.append("\nKeyboard insets: Bottom: ");
      stringBuilder.append(this.m.viewInsetBottom);
      stringBuilder.append(", Left: ");
      stringBuilder.append(this.m.viewInsetLeft);
      stringBuilder.append(", Right: ");
      stringBuilder.append(this.m.viewInsetRight);
      Log.v("FlutterView", stringBuilder.toString());
      f();
      return true;
    } 
    return super.fitSystemWindows((Rect)stringBuilder);
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider() {
    AccessibilityBridge accessibilityBridge = this.j;
    return (AccessibilityNodeProvider)((accessibilityBridge != null && accessibilityBridge.isAccessibilityEnabled()) ? this.j : null);
  }
  
  public FlutterEngine getAttachedFlutterEngine() {
    return this.e;
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets) {
    WindowInsets windowInsets = super.onApplyWindowInsets(paramWindowInsets);
    this.m.paddingTop = paramWindowInsets.getSystemWindowInsetTop();
    this.m.paddingRight = paramWindowInsets.getSystemWindowInsetRight();
    FlutterRenderer.ViewportMetrics viewportMetrics = this.m;
    viewportMetrics.paddingBottom = 0;
    viewportMetrics.paddingLeft = paramWindowInsets.getSystemWindowInsetLeft();
    viewportMetrics = this.m;
    viewportMetrics.viewInsetTop = 0;
    viewportMetrics.viewInsetRight = 0;
    viewportMetrics.viewInsetBottom = paramWindowInsets.getSystemWindowInsetBottom();
    this.m.viewInsetLeft = 0;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: ");
    stringBuilder.append(this.m.paddingTop);
    stringBuilder.append(", Left: ");
    stringBuilder.append(this.m.paddingLeft);
    stringBuilder.append(", Right: ");
    stringBuilder.append(this.m.paddingRight);
    stringBuilder.append("\nKeyboard insets: Bottom: ");
    stringBuilder.append(this.m.viewInsetBottom);
    stringBuilder.append(", Left: ");
    stringBuilder.append(this.m.viewInsetLeft);
    stringBuilder.append(", Right: ");
    stringBuilder.append(this.m.viewInsetRight);
    stringBuilder.append("System Gesture Insets - Left: ");
    stringBuilder.append(this.m.systemGestureInsetLeft);
    stringBuilder.append(", Top: ");
    stringBuilder.append(this.m.systemGestureInsetTop);
    stringBuilder.append(", Right: ");
    stringBuilder.append(this.m.systemGestureInsetRight);
    stringBuilder.append(", Bottom: ");
    stringBuilder.append(this.m.viewInsetBottom);
    Log.v("FlutterView", stringBuilder.toString());
    f();
    return windowInsets;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    Log.v("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
    try {
      return;
    } finally {
      paramConfiguration = null;
      Log.e("FlutterView", "onConfigurationChanged error ");
    } 
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    return !c() ? super.onCreateInputConnection(paramEditorInfo) : this.g.a((View)this, paramEditorInfo);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    boolean bool;
    if (c() && this.i.onGenericMotionEvent(paramMotionEvent)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool ? true : super.onGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent) {
    return !c() ? super.onHoverEvent(paramMotionEvent) : this.j.onAccessibilityHoverEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (!c())
      return super.onKeyDown(paramInt, paramKeyEvent); 
    this.h.b(paramKeyEvent);
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (!c())
      return super.onKeyUp(paramInt, paramKeyEvent); 
    this.h.a(paramKeyEvent);
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Size changed. Sending Flutter new viewport metrics. FlutterView was ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" x ");
    stringBuilder.append(paramInt4);
    stringBuilder.append(", it is now ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" x ");
    stringBuilder.append(paramInt2);
    Log.v("FlutterView", stringBuilder.toString());
    FlutterRenderer.ViewportMetrics viewportMetrics = this.m;
    viewportMetrics.width = paramInt1;
    viewportMetrics.height = paramInt2;
    f();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (!c())
      return super.onTouchEvent(paramMotionEvent); 
    if (Build.VERSION.SDK_INT >= 21)
      requestUnbufferedDispatch(paramMotionEvent); 
    return this.i.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\XFlutterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */