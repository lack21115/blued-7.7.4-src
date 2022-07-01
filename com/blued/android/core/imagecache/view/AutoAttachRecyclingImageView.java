package com.blued.android.core.imagecache.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.blued.android.core.imagecache.ImageLoadingListener;
import com.blued.android.core.imagecache.LoadJob;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.imagecache.RecyclingMultiImageLoader;
import com.blued.blued_core.R;

public class AutoAttachRecyclingImageView extends RecyclingImageView {
  boolean a = false;
  
  String[] b;
  
  String c;
  
  LoadOptions d;
  
  ImageLoadingListener e;
  
  LoadJob f;
  
  int g = 0;
  
  public AutoAttachRecyclingImageView(Context paramContext) {
    super(paramContext);
  }
  
  public AutoAttachRecyclingImageView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AutoAttachRecyclingImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AutoRecyclingImageView, paramInt, 0);
    paramInt = typedArray.getResourceId(R.styleable.AutoRecyclingImageView_recycling_src, 0);
    if (paramInt > 0)
      setImageResource(paramInt); 
    typedArray.recycle();
  }
  
  public static LoadJob a(String paramString, LoadOptions paramLoadOptions, ImageLoadingListener paramImageLoadingListener) {
    return RecyclingImageLoader.a(null, paramString, paramLoadOptions, paramImageLoadingListener);
  }
  
  private void b(String[] paramArrayOfString, LoadOptions paramLoadOptions, ImageLoadingListener paramImageLoadingListener) {
    this.a = false;
    this.c = null;
    this.b = paramArrayOfString;
    this.d = paramLoadOptions;
    this.e = paramImageLoadingListener;
  }
  
  private void c(String paramString, LoadOptions paramLoadOptions, ImageLoadingListener paramImageLoadingListener) {
    this.a = false;
    this.c = paramString;
    this.b = null;
    this.d = paramLoadOptions;
    this.e = paramImageLoadingListener;
  }
  
  public LoadJob a(String[] paramArrayOfString, LoadOptions paramLoadOptions, ImageLoadingListener paramImageLoadingListener) {
    b(paramArrayOfString, paramLoadOptions, paramImageLoadingListener);
    LoadJob loadJob = this.f;
    if (loadJob != null) {
      loadJob.a();
      this.f = null;
    } 
    RecyclingMultiImageLoader.a(this, paramArrayOfString, paramLoadOptions, paramImageLoadingListener);
    return null;
  }
  
  public void a() {
    LoadJob loadJob = this.f;
    if (loadJob != null) {
      loadJob.a();
      this.f = null;
    } 
    if (!TextUtils.isEmpty(this.c)) {
      this.f = b(this.c, this.d, this.e);
      return;
    } 
    String[] arrayOfString = this.b;
    if (arrayOfString != null) {
      this.f = a(arrayOfString, this.d, this.e);
      return;
    } 
    if (LoadOptions.a) {
      int i = this.g;
      if (i > 0)
        setImageResource(i); 
    } 
  }
  
  public LoadJob b(String paramString, LoadOptions paramLoadOptions, ImageLoadingListener paramImageLoadingListener) {
    c(paramString, paramLoadOptions, paramImageLoadingListener);
    LoadJob loadJob = this.f;
    if (loadJob != null) {
      loadJob.a();
      this.f = null;
    } 
    this.f = RecyclingImageLoader.a(this, paramString, paramLoadOptions, paramImageLoadingListener);
    return this.f;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (this.a) {
      a();
      this.a = false;
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.a = true;
    LoadJob loadJob = this.f;
    if (loadJob != null) {
      loadJob.a();
      this.f = null;
    } 
  }
  
  public void setImageResource(int paramInt) {
    this.g = paramInt;
    super.setImageResource(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\view\AutoAttachRecyclingImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */