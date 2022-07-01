package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class NotificationTarget extends CustomTarget<Bitmap> {
  private final RemoteViews a;
  
  private final Context b;
  
  private final int c;
  
  private final String d;
  
  private final Notification e;
  
  private final int f;
  
  private void a(Bitmap paramBitmap) {
    this.a.setImageViewBitmap(this.f, paramBitmap);
    e();
  }
  
  private void e() {
    ((NotificationManager)Preconditions.a(this.b.getSystemService("notification"))).notify(this.d, this.c, this.e);
  }
  
  public void a(Bitmap paramBitmap, Transition<? super Bitmap> paramTransition) {
    a(paramBitmap);
  }
  
  public void c(Drawable paramDrawable) {
    a(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\NotificationTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */