package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.NetworkOnMainThreadException;
import android.widget.ImageView;
import com.blued.android.core.imagecache.BaseImageLoadingListener;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.imagecache.view.RecyclingImageView;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ApngImageLoadingListener extends BaseImageLoadingListener {
  private ApngPlayListener a;
  
  private boolean b;
  
  private ApngDrawable a(String paramString, ImageView.ScaleType paramScaleType, Drawable paramDrawable) {
    boolean bool;
    File file = a(paramString);
    if (file != null && file.exists()) {
      bool = ApngDrawable.a(file);
    } else {
      bool = false;
    } 
    Bitmap bitmap = null;
    if (bool) {
      if (paramDrawable instanceof BitmapDrawable)
        bitmap = ((BitmapDrawable)paramDrawable).getBitmap(); 
      return new RecyclingApngDrawable(paramString, bitmap, Uri.fromFile(file), paramScaleType);
    } 
    return null;
  }
  
  protected File a(String paramString) {
    File file = new File(RecyclingUtils.d(paramString));
    if (!file.exists()) {
      if (RecyclingUtils.Scheme.a(paramString) == RecyclingUtils.Scheme.e)
        try {
          RecyclingUtils.a(RecyclingUtils.c(paramString), file);
          return file;
        } catch (IOException iOException) {
          iOException.printStackTrace();
          return file;
        }  
      try {
        RecyclingUtils.a((new URL((String)iOException)).openStream(), file);
        return file;
      } catch (MalformedURLException malformedURLException) {
        malformedURLException.printStackTrace();
      } catch (IOException iOException1) {
        iOException1.printStackTrace();
        return file;
      } catch (NetworkOnMainThreadException networkOnMainThreadException) {
        networkOnMainThreadException.printStackTrace();
        return file;
      } 
    } 
    return file;
  }
  
  public void a(String paramString, RecyclingImageView paramRecyclingImageView, LoadOptions paramLoadOptions, Drawable paramDrawable, boolean paramBoolean) {
    ApngDrawable apngDrawable;
    if (paramDrawable instanceof ApngDrawable) {
      super.a(paramString, paramRecyclingImageView, paramLoadOptions, paramDrawable, paramBoolean);
      apngDrawable = (ApngDrawable)paramDrawable;
    } else {
      ApngDrawable apngDrawable1 = a((String)apngDrawable, paramRecyclingImageView.getScaleType(), paramDrawable);
      if (apngDrawable1 != null) {
        paramRecyclingImageView.setImageDrawable(apngDrawable1);
      } else {
        super.a((String)apngDrawable, paramRecyclingImageView, paramLoadOptions, paramDrawable, paramBoolean);
      } 
      apngDrawable = apngDrawable1;
    } 
    if (apngDrawable != null) {
      apngDrawable.g();
      apngDrawable.a(this.a);
      if (this.b)
        apngDrawable.a(1); 
      apngDrawable.start();
      return;
    } 
    ApngPlayListener apngPlayListener = this.a;
    if (apngPlayListener != null)
      apngPlayListener.b(null); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\apng\ApngImageLoadingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */