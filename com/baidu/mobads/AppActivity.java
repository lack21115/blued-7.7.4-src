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
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.baidu.mobads.utils.q;
import java.io.Serializable;

public class AppActivity extends Activity {
  private static boolean a;
  
  public static String activityName;
  
  private static ActionBarColorTheme c = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
  
  private AppActivityImp b = new AppActivityImp();
  
  public static void canLpShowWhenLocked(boolean paramBoolean) {
    a = paramBoolean;
    AppActivityImp.canLpShowWhenLocked(paramBoolean);
  }
  
  public static ActionBarColorTheme getActionBarColorTheme() {
    return c;
  }
  
  public static Class<?> getActivityClass() {
    if (!TextUtils.isEmpty(activityName))
      try {
        return Class.forName(activityName);
      } catch (Exception exception) {
        q.a().e(exception);
      }  
    return AppActivity.class;
  }
  
  public static boolean getLpShowWhenLocked() {
    return a;
  }
  
  public static boolean isAnti() {
    return TextUtils.isEmpty(activityName) ^ true;
  }
  
  public static void setActionBarColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    c = new ActionBarColorTheme(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setActionBarColorTheme(ActionBarColorTheme paramActionBarColorTheme) {
    if (paramActionBarColorTheme != null)
      c = new ActionBarColorTheme(paramActionBarColorTheme); 
  }
  
  public static void setActivityName(String paramString) {
    activityName = paramString;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return this.b.dispatchKeyEvent(paramKeyEvent) ? true : super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    return this.b.dispatchTouchEvent(paramMotionEvent) ? true : super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent) {
    return this.b.dispatchTrackballEvent(paramMotionEvent) ? true : super.dispatchTrackballEvent(paramMotionEvent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    this.b.onActivityResult(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean) {
    this.b.onApplyThemeResource(paramTheme, paramInt, paramBoolean);
    super.onApplyThemeResource(paramTheme, paramInt, paramBoolean);
  }
  
  protected void onChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence) {
    this.b.onChildTitleChanged(paramActivity, paramCharSequence);
    super.onChildTitleChanged(paramActivity, paramCharSequence);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    this.b.onConfigurationChanged(paramConfiguration);
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onContentChanged() {
    this.b.onContentChanged();
    super.onContentChanged();
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem) {
    return this.b.onContextItemSelected(paramMenuItem) ? true : super.onContextItemSelected(paramMenuItem);
  }
  
  public void onContextMenuClosed(Menu paramMenu) {
    this.b.onContextMenuClosed(paramMenu);
    super.onContextMenuClosed(paramMenu);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      this.b.setActivity(this);
      this.b.onCreate(paramBundle);
      return;
    } catch (Exception exception) {
      q.a().e(exception);
      return;
    } 
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    this.b.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public CharSequence onCreateDescription() {
    CharSequence charSequence = this.b.onCreateDescription();
    return (charSequence != null) ? charSequence : super.onCreateDescription();
  }
  
  protected Dialog onCreateDialog(int paramInt) {
    Dialog dialog = this.b.onCreateDialog(paramInt);
    return (dialog != null) ? dialog : super.onCreateDialog(paramInt);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    return this.b.onCreateOptionsMenu(paramMenu) ? true : super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu) {
    return this.b.onCreatePanelMenu(paramInt, paramMenu) ? true : super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt) {
    View view = this.b.onCreatePanelView(paramInt);
    return (view != null) ? view : super.onCreatePanelView(paramInt);
  }
  
  public boolean onCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas) {
    return this.b.onCreateThumbnail(paramBitmap, paramCanvas) ? true : super.onCreateThumbnail(paramBitmap, paramCanvas);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    View view = this.b.onCreateView(paramString, paramContext, paramAttributeSet);
    return (view != null) ? view : super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  protected void onDestroy() {
    this.b.onDestroy();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return this.b.onKeyDown(paramInt, paramKeyEvent) ? true : super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent) {
    return this.b.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent) ? true : super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    return this.b.onKeyUp(paramInt, paramKeyEvent) ? true : super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onLowMemory() {
    this.b.onLowMemory();
    super.onLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
    return this.b.onMenuItemSelected(paramInt, paramMenuItem) ? true : super.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu) {
    return this.b.onMenuOpened(paramInt, paramMenu) ? true : super.onMenuOpened(paramInt, paramMenu);
  }
  
  protected void onNewIntent(Intent paramIntent) {
    this.b.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    return this.b.onOptionsItemSelected(paramMenuItem) ? true : super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onOptionsMenuClosed(Menu paramMenu) {
    this.b.onOptionsMenuClosed(paramMenu);
    super.onOptionsMenuClosed(paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu) {
    this.b.onPanelClosed(paramInt, paramMenu);
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPause() {
    this.b.onPause();
    super.onPause();
  }
  
  protected void onPostCreate(Bundle paramBundle) {
    super.onPostCreate(paramBundle);
    this.b.onPostCreate(paramBundle);
  }
  
  protected void onPostResume() {
    super.onPostResume();
    this.b.onPostResume();
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog) {
    super.onPrepareDialog(paramInt, paramDialog);
    this.b.onPrepareDialog(paramInt, paramDialog);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu) {
    return this.b.onPrepareOptionsMenu(paramMenu) ? true : super.onPrepareOptionsMenu(paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu) {
    return this.b.onPreparePanel(paramInt, paramView, paramMenu) ? true : super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  protected void onRestart() {
    super.onRestart();
    this.b.onRestart();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle) {
    super.onRestoreInstanceState(paramBundle);
    this.b.onRestoreInstanceState(paramBundle);
  }
  
  protected void onResume() {
    super.onResume();
    this.b.onResume();
  }
  
  public Object onRetainNonConfigurationInstance() {
    Object object = this.b.onRetainNonConfigurationInstance();
    return (object != null) ? object : super.onRetainNonConfigurationInstance();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    this.b.onSaveInstanceState(paramBundle);
  }
  
  public boolean onSearchRequested() {
    return this.b.onSearchRequested() ? true : super.onSearchRequested();
  }
  
  protected void onStart() {
    super.onStart();
    this.b.onStart();
  }
  
  protected void onStop() {
    this.b.onStop();
    super.onStop();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt) {
    super.onTitleChanged(paramCharSequence, paramInt);
    this.b.onTitleChanged(paramCharSequence, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return this.b.onTouchEvent(paramMotionEvent) ? true : super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent) {
    return this.b.onTrackballEvent(paramMotionEvent) ? true : super.onTrackballEvent(paramMotionEvent);
  }
  
  public void onUserInteraction() {
    super.onUserInteraction();
    this.b.onUserInteraction();
  }
  
  protected void onUserLeaveHint() {
    super.onUserLeaveHint();
    this.b.onUserLeaveHint();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams) {
    super.onWindowAttributesChanged(paramLayoutParams);
    this.b.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    this.b.onWindowFocusChanged(paramBoolean);
  }
  
  public static class ActionBarColorTheme implements Serializable {
    public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME;
    
    public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME;
    
    public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME;
    
    public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME;
    
    public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME;
    
    public static final ActionBarColorTheme ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
    
    public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, -328966);
    
    public int backgroundColor;
    
    public int closeColor;
    
    public int progressColor;
    
    public int titleColor;
    
    static {
      ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
      ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
      ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
      ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
      ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);
    }
    
    public ActionBarColorTheme(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.closeColor = param1Int1;
      this.titleColor = param1Int2;
      this.progressColor = param1Int3;
      this.backgroundColor = param1Int4;
    }
    
    public ActionBarColorTheme(ActionBarColorTheme param1ActionBarColorTheme) {
      this.closeColor = param1ActionBarColorTheme.closeColor;
      this.titleColor = param1ActionBarColorTheme.titleColor;
      this.progressColor = param1ActionBarColorTheme.progressColor;
      this.backgroundColor = param1ActionBarColorTheme.backgroundColor;
    }
    
    public boolean equals(Object param1Object) {
      param1Object = param1Object;
      return (this.backgroundColor == ((ActionBarColorTheme)param1Object).backgroundColor && this.titleColor == ((ActionBarColorTheme)param1Object).titleColor && this.closeColor == ((ActionBarColorTheme)param1Object).closeColor && this.progressColor == ((ActionBarColorTheme)param1Object).progressColor);
    }
    
    public int getBackgroundColor() {
      return this.backgroundColor;
    }
    
    public int getCloseColor() {
      return this.closeColor;
    }
    
    public int getProgressColor() {
      return this.progressColor;
    }
    
    public int getTitleColor() {
      return this.titleColor;
    }
    
    public void setBackgroundColor(int param1Int) {
      this.backgroundColor = param1Int;
    }
    
    public void setCloseColor(int param1Int) {
      this.closeColor = param1Int;
    }
    
    public void setProgressColor(int param1Int) {
      this.progressColor = param1Int;
    }
    
    public void setTitleColor(int param1Int) {
      this.titleColor = param1Int;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\AppActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */