package com.blued.android.core.imagecache;

import android.graphics.drawable.Drawable;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.view.RecyclingImageView;
import com.blued.android.core.utils.Log;

public class BaseImageLoadingListener implements PreProcessImageLoadingListener {
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(String paramString, RecyclingImageView paramRecyclingImageView, LoadOptions paramLoadOptions) {}
  
  public void a(String paramString, RecyclingImageView paramRecyclingImageView, LoadOptions paramLoadOptions, Drawable paramDrawable, boolean paramBoolean) {
    // Byte code:
    //   0: aload_2
    //   1: ifnull -> 123
    //   4: aload_2
    //   5: invokevirtual getDrawable : ()Landroid/graphics/drawable/Drawable;
    //   8: astore #6
    //   10: aload #4
    //   12: aload #6
    //   14: if_acmpeq -> 123
    //   17: aload_3
    //   18: getfield l : Z
    //   21: ifeq -> 117
    //   24: iload #5
    //   26: ifne -> 117
    //   29: aload_3
    //   30: getfield k : Z
    //   33: ifne -> 117
    //   36: aload #6
    //   38: ifnull -> 52
    //   41: aload #6
    //   43: astore_1
    //   44: aload #6
    //   46: instanceof android/graphics/drawable/LayerDrawable
    //   49: ifeq -> 71
    //   52: new android/graphics/drawable/ColorDrawable
    //   55: dup
    //   56: invokestatic d : ()Landroid/content/Context;
    //   59: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   62: ldc 17170445
    //   64: invokevirtual getColor : (I)I
    //   67: invokespecial <init> : (I)V
    //   70: astore_1
    //   71: aload_2
    //   72: new android/graphics/drawable/TransitionDrawable
    //   75: dup
    //   76: iconst_2
    //   77: anewarray android/graphics/drawable/Drawable
    //   80: dup
    //   81: iconst_0
    //   82: aload_1
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: aload #4
    //   88: aastore
    //   89: invokespecial <init> : ([Landroid/graphics/drawable/Drawable;)V
    //   92: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   95: aload_2
    //   96: invokevirtual getDrawable : ()Landroid/graphics/drawable/Drawable;
    //   99: astore_1
    //   100: aload_1
    //   101: instanceof android/graphics/drawable/TransitionDrawable
    //   104: ifeq -> 123
    //   107: aload_1
    //   108: checkcast android/graphics/drawable/TransitionDrawable
    //   111: bipush #100
    //   113: invokevirtual startTransition : (I)V
    //   116: return
    //   117: aload_2
    //   118: aload #4
    //   120: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   123: return
  }
  
  public void a(String paramString, RecyclingImageView paramRecyclingImageView, LoadOptions paramLoadOptions, FailReason paramFailReason) {
    String str = FailReason.a(AppInfo.d(), paramFailReason, true);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(", uri:");
    stringBuilder.append(paramString);
    paramString = stringBuilder.toString();
    if (ImageLoaderUtils.a)
      Log.e("BaseImageLoading", paramString); 
    if (paramRecyclingImageView != null) {
      if (paramLoadOptions.d > 0) {
        if (paramLoadOptions.e) {
          paramRecyclingImageView.setImageResourceInner(paramLoadOptions.d);
          return;
        } 
        paramRecyclingImageView.setImageResource(paramLoadOptions.d);
        return;
      } 
      if (paramLoadOptions.d == 0)
        paramRecyclingImageView.setImageDrawable(null); 
    } 
  }
  
  public boolean a() {
    return false;
  }
  
  public void b(String paramString, RecyclingImageView paramRecyclingImageView, LoadOptions paramLoadOptions) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\BaseImageLoadingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */