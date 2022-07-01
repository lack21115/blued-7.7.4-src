package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;

public class AppWidgetTarget extends CustomTarget<Bitmap> {
  private final int[] a;
  
  private final ComponentName b;
  
  private final RemoteViews c;
  
  private final Context d;
  
  private final int e;
  
  private void a(Bitmap paramBitmap) {
    this.c.setImageViewBitmap(this.e, paramBitmap);
    e();
  }
  
  private void e() {
    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.d);
    ComponentName componentName = this.b;
    if (componentName != null) {
      appWidgetManager.updateAppWidget(componentName, this.c);
      return;
    } 
    appWidgetManager.updateAppWidget(this.a, this.c);
  }
  
  public void a(Bitmap paramBitmap, Transition<? super Bitmap> paramTransition) {
    a(paramBitmap);
  }
  
  public void c(Drawable paramDrawable) {
    a(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\AppWidgetTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */