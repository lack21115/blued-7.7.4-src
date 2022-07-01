package com.baidu.mobads;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.f.b;
import com.baidu.mobads.f.g;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.utils.f;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.vo.XAdInstanceInfo;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppActivityImp {
  public static final String EXTRA_AD_INSTANCE_INFO = "EXTRA_DATA_STRING_AD";
  
  public static final String EXTRA_COMMAND_EXTRA_INFO = "EXTRA_DATA_STRING_COM";
  
  public static final String EXTRA_DATA = "EXTRA_DATA";
  
  public static final String EXTRA_LANDINGPAGE_EXTRA_INFO = "EXTRA_DATA_STRING";
  
  public static final String EXTRA_LP_FLAG = "EXTRA_LP_FLAG";
  
  public static final String EXTRA_LP_THEME = "theme";
  
  private static boolean b = false;
  
  private static Class<?> d;
  
  private static AppActivity.ActionBarColorTheme f = AppActivity.ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
  
  private Activity a;
  
  private Object c;
  
  private Method[] e = null;
  
  public AppActivityImp() {}
  
  public AppActivityImp(Activity paramActivity) {
    this.a = paramActivity;
  }
  
  private Method a(String paramString) {
    Method[] arrayOfMethod = this.e;
    if (arrayOfMethod == null)
      return null; 
    int j = arrayOfMethod.length;
    for (int i = 0; i < j; i++) {
      Method method = arrayOfMethod[i];
      if (method.getName().equals(paramString)) {
        method.setAccessible(true);
        return method;
      } 
    } 
    return null;
  }
  
  private static void a(Class<?> paramClass, Object paramObject, String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      for (Field field : paramClass.getDeclaredFields()) {
        paramString = null;
        String str = paramString;
        try {
          field.setAccessible(true);
          str = paramString;
          paramString = field.getName();
          str = paramString;
          Class<?> clazz = field.getType();
          str = paramString;
          if (!jSONObject.isNull(paramString)) {
            str = paramString;
            if (a(clazz)) {
              str = paramString;
              field.set(paramObject, jSONObject.get(paramString));
            } 
          } 
        } catch (Exception exception) {
          q q = q.a();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("");
          stringBuilder.append(str);
          q.d(stringBuilder.toString());
          q.a().d(exception);
        } 
      } 
    } catch (Exception exception) {
      q.a().d(exception);
    } 
  }
  
  private void a(String paramString, Object... paramVarArgs) {
    try {
      boolean bool;
      q q = q.a();
      if (paramVarArgs != null) {
        bool = paramVarArgs.length;
      } else {
        bool = false;
      } 
      q.d(new Object[] { paramString, Integer.valueOf(bool), paramVarArgs });
      Method method = a(paramString);
      if (method != null) {
        if (paramVarArgs == null || paramVarArgs.length == 0) {
          method.invoke(this.c, new Object[0]);
          return;
        } 
        method.invoke(this.c, paramVarArgs);
        return;
      } 
    } catch (Exception exception) {
      q.a().d(exception);
    } 
  }
  
  private static boolean a(Class<?> paramClass) {
    return (paramClass == null) ? false : ((paramClass.equals(String.class) || paramClass.equals(Integer.class) || paramClass.equals(int.class) || paramClass.equals(Boolean.class) || paramClass.equals(boolean.class) || paramClass.equals(Double.class) || paramClass.equals(double.class) || paramClass.equals(Long.class) || paramClass.equals(long.class) || paramClass.equals(JSONArray.class) || paramClass.equals(JSONObject.class)));
  }
  
  private boolean b(String paramString, Object... paramVarArgs) {
    try {
      boolean bool;
      q q = q.a();
      if (paramVarArgs != null) {
        bool = paramVarArgs.length;
      } else {
        bool = false;
      } 
      q.d(new Object[] { paramString, Integer.valueOf(bool), paramVarArgs });
      Method method = a(paramString);
      if (method != null)
        return (paramVarArgs == null || paramVarArgs.length == 0) ? ((Boolean)method.invoke(this.c, new Object[0])).booleanValue() : ((Boolean)method.invoke(this.c, paramVarArgs)).booleanValue(); 
    } catch (Exception exception) {
      q.a().d(exception);
    } 
    return false;
  }
  
  private Object c(String paramString, Object... paramVarArgs) {
    try {
      boolean bool;
      q q = q.a();
      if (paramVarArgs != null) {
        bool = paramVarArgs.length;
      } else {
        bool = false;
      } 
      q.d(new Object[] { paramString, Integer.valueOf(bool), paramVarArgs });
      Method method = a(paramString);
      if (method != null)
        return (paramVarArgs == null || paramVarArgs.length == 0) ? method.invoke(this.c, new Object[0]) : method.invoke(this.c, paramVarArgs); 
    } catch (Exception exception) {
      q.a().d(exception);
    } 
    return null;
  }
  
  public static void canLpShowWhenLocked(boolean paramBoolean) {
    b = paramBoolean;
  }
  
  public static String classToString(Class<?> paramClass, Object paramObject) {
    JSONObject jSONObject = new JSONObject();
    try {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      for (int i = 0;; i++) {
        if (i < j) {
          String str;
          Field field = arrayOfField[i];
          Class<?> clazz = null;
          paramClass = clazz;
          try {
            field.setAccessible(true);
            paramClass = clazz;
            String str1 = field.getName();
            str = str1;
            if (a(field.getType())) {
              str = str1;
              jSONObject.put(str1, field.get(paramObject));
            } 
          } catch (Exception exception) {
            q q = q.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(str);
            q.d(stringBuilder.toString());
            q.a().d(exception);
          } 
        } else {
          return jSONObject.toString();
        } 
      } 
    } catch (Exception exception) {
      q.a().d(exception);
      return "";
    } 
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return b("dispatchKeyEvent", new Object[] { paramKeyEvent });
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    return b("dispatchTouchEvent", new Object[] { paramMotionEvent });
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent) {
    return b("dispatchTrackballEvent", new Object[] { paramMotionEvent });
  }
  
  public void invokeRemoteStatic(String paramString, Object... paramVarArgs) {
    try {
      boolean bool;
      q q = q.a();
      if (paramVarArgs != null) {
        bool = paramVarArgs.length;
      } else {
        bool = false;
      } 
      q.d(new Object[] { paramString, Integer.valueOf(bool), paramVarArgs });
      Method method = a(paramString);
      if (method != null) {
        if (paramVarArgs == null || paramVarArgs.length == 0) {
          method.invoke((Object)null, new Object[0]);
          return;
        } 
        method.invoke((Object)null, paramVarArgs);
        return;
      } 
    } catch (Exception exception) {
      q.a().d(exception);
    } 
  }
  
  public Class<?> loadLocalApk(String paramString) {
    q q = q.a();
    ClassLoader classLoader = getClass().getClassLoader();
    Exception exception2 = null;
    try {
      Class<?> clazz = Class.forName(paramString, true, (ClassLoader)new DexClassLoader(g.a((Context)this.a), this.a.getFilesDir().getAbsolutePath(), null, classLoader));
    } catch (Exception exception1) {
      q.d(exception1);
      exception1 = exception2;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("jar.path=, clz=");
    stringBuilder.append(exception1);
    q.d(stringBuilder.toString());
    return (Class<?>)exception1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    a("onActivityResult", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
  
  protected void onApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean) {
    a("onApplyThemeResource", new Object[] { paramTheme, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
  }
  
  protected void onChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence) {
    a("onChildTitleChanged", new Object[] { paramActivity, paramCharSequence });
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    a("onConfigurationChanged", new Object[] { paramConfiguration });
  }
  
  public void onContentChanged() {
    a("onContentChanged", new Object[0]);
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem) {
    return b("onContextItemSelected", new Object[] { paramMenuItem });
  }
  
  public void onContextMenuClosed(Menu paramMenu) {
    a("onContextMenuClosed", new Object[] { paramMenu });
  }
  
  protected void onCreate(Bundle paramBundle) {
    try {
      Intent intent = this.a.getIntent();
      if (intent != null) {
        intent.setExtrasClassLoader(getClass().getClassLoader());
        String str = this.a.getIntent().getStringExtra("theme");
        a(AppActivity.ActionBarColorTheme.class, f, str);
        b = intent.getBooleanExtra("showWhenLocked", true);
      } 
      intent.putExtra("multiProcess", (new f()).webviewMultiProcess(this.a));
      if (AppActivity.isAnti() && intent.getParcelableExtra("EXTRA_DATA") == null) {
        XAdLandingPageExtraInfo xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo(null, (IXAdInstanceInfo)new XAdInstanceInfo(new JSONObject()));
        a(XAdLandingPageExtraInfo.class, xAdLandingPageExtraInfo, this.a.getIntent().getStringExtra("EXTRA_DATA_STRING"));
        a(XAdCommandExtraInfo.class, xAdLandingPageExtraInfo, this.a.getIntent().getStringExtra("EXTRA_DATA_STRING_COM"));
        String str = this.a.getIntent().getStringExtra("EXTRA_DATA_STRING_AD");
        a(XAdInstanceInfo.class, xAdLandingPageExtraInfo.getAdInstanceInfo(), str);
        intent.putExtra("EXTRA_DATA", (Parcelable)xAdLandingPageExtraInfo);
      } 
      DexClassLoader dexClassLoader = b.d();
      if (dexClassLoader == null) {
        d = loadLocalApk("com.baidu.mobads.container.landingpage.App2Activity");
      } else {
        d = Class.forName("com.baidu.mobads.container.landingpage.App2Activity", true, (ClassLoader)dexClassLoader);
      } 
      this.e = d.getDeclaredMethods();
      this.c = d.getConstructor(new Class[] { Activity.class }).newInstance(new Object[] { this.a });
      invokeRemoteStatic("canLpShowWhenLocked", new Object[] { Boolean.valueOf(b) });
      invokeRemoteStatic("setActionBarColor", new Object[] { Integer.valueOf(f.closeColor), Integer.valueOf(f.titleColor), Integer.valueOf(f.progressColor), Integer.valueOf(f.backgroundColor) });
      q.a().d(new Object[] { "com.baidu.mobads.container.landingpage.App2Activity", d, this.c });
    } catch (Exception exception) {
      q.a().d(exception);
    } 
    a("onCreate", new Object[] { paramBundle });
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
    a("onCreateContextMenu", new Object[] { paramContextMenu, paramView, paramContextMenuInfo });
  }
  
  public CharSequence onCreateDescription() {
    return (CharSequence)c("onCreateDescription", new Object[0]);
  }
  
  protected Dialog onCreateDialog(int paramInt) {
    Dialog dialog = (Dialog)c("onCreateDialog", new Object[] { Integer.valueOf(paramInt) });
    if (dialog != null);
    return dialog;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    return b("onCreateOptionsMenu", new Object[] { paramMenu });
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu) {
    return b("onCreatePanelMenu", new Object[] { Integer.valueOf(paramInt), paramMenu });
  }
  
  public View onCreatePanelView(int paramInt) {
    try {
      return (View)c("onCreatePanelView", new Object[] { Integer.valueOf(paramInt) });
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public boolean onCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas) {
    return b("onCreateThumbnail", new Object[] { paramBitmap, paramCanvas });
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    try {
      return (View)c("onCreateView", new Object[] { paramString, paramContext, paramAttributeSet });
    } catch (Exception exception) {
      return null;
    } 
  }
  
  protected void onDestroy() {
    if (this.a != null) {
      Intent intent = new Intent();
      intent.setAction("lp_close");
      this.a.sendBroadcast(intent);
    } 
    a("onDestroy", new Object[0]);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return b("onKeyDown", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent) {
    return b("onKeyMultiple", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramKeyEvent });
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    return b("onKeyUp", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
  }
  
  public void onLowMemory() {
    a("onLowMemory", new Object[0]);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
    return b("onMenuItemSelected", new Object[] { Integer.valueOf(paramInt), paramMenuItem });
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu) {
    return b("onMenuOpened", new Object[] { Integer.valueOf(paramInt), paramMenu });
  }
  
  protected void onNewIntent(Intent paramIntent) {
    a("onNewIntent", new Object[] { paramIntent });
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    return b("onOptionsItemSelected", new Object[] { paramMenuItem });
  }
  
  public void onOptionsMenuClosed(Menu paramMenu) {
    a("onOptionsMenuClosed", new Object[] { paramMenu });
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu) {
    a("onPanelClosed", new Object[] { Integer.valueOf(paramInt), paramMenu });
  }
  
  protected void onPause() {
    a("onPause", new Object[0]);
  }
  
  protected void onPostCreate(Bundle paramBundle) {
    a("onPostCreate", new Object[] { paramBundle });
  }
  
  protected void onPostResume() {
    a("onPostResume", new Object[0]);
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog) {
    a("onPrepareDialog", new Object[] { Integer.valueOf(paramInt), paramDialog });
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu) {
    return b("onPrepareOptionsMenu", new Object[] { paramMenu });
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu) {
    return b("onPreparePanel", new Object[] { Integer.valueOf(paramInt), paramView, paramMenu });
  }
  
  protected void onRestart() {
    a("onRestart", new Object[0]);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle) {
    a("onRestoreInstanceState", new Object[] { paramBundle });
  }
  
  protected void onResume() {
    a("onResume", new Object[0]);
  }
  
  public Object onRetainNonConfigurationInstance() {
    return c("onRetainNonConfigurationInstance", new Object[0]);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    a("onSaveInstanceState", new Object[] { paramBundle });
  }
  
  public boolean onSearchRequested() {
    return b("onSearchRequested", new Object[0]);
  }
  
  protected void onStart() {
    a("onStart", new Object[0]);
  }
  
  protected void onStop() {
    a("onStop", new Object[0]);
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt) {
    a("onTitleChanged", new Object[] { paramCharSequence, Integer.valueOf(paramInt) });
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return b("onTouchEvent", new Object[] { paramMotionEvent });
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent) {
    return b("onTrackballEvent", new Object[] { paramMotionEvent });
  }
  
  public void onUserInteraction() {
    a("onUserInteraction", new Object[0]);
  }
  
  protected void onUserLeaveHint() {
    a("onUserLeaveHint", new Object[0]);
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams) {
    a("onWindowAttributesChanged", new Object[] { paramLayoutParams });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    a("onWindowFocusChanged", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setActivity(Activity paramActivity) {
    this.a = paramActivity;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\AppActivityImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */