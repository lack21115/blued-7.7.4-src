package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

public final class zab extends zaa {
  private WeakReference<ImageView> zac;
  
  public zab(ImageView paramImageView, int paramInt) {
    super(Uri.EMPTY, paramInt);
    Asserts.checkNotNull(paramImageView);
    this.zac = new WeakReference<ImageView>(paramImageView);
  }
  
  public zab(ImageView paramImageView, Uri paramUri) {
    super(paramUri, 0);
    Asserts.checkNotNull(paramImageView);
    this.zac = new WeakReference<ImageView>(paramImageView);
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zab))
      return false; 
    zab zab1 = (zab)paramObject;
    paramObject = this.zac.get();
    ImageView imageView = zab1.zac.get();
    return (imageView != null && paramObject != null && Objects.equal(imageView, paramObject));
  }
  
  public final int hashCode() {
    return 0;
  }
  
  protected final void zaa(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zac : Ljava/lang/ref/WeakReference;
    //   4: invokevirtual get : ()Ljava/lang/Object;
    //   7: checkcast android/widget/ImageView
    //   10: astore #10
    //   12: aload #10
    //   14: ifnull -> 226
    //   17: iconst_0
    //   18: istore #6
    //   20: iload_3
    //   21: ifne -> 35
    //   24: iload #4
    //   26: ifne -> 35
    //   29: iconst_1
    //   30: istore #5
    //   32: goto -> 38
    //   35: iconst_0
    //   36: istore #5
    //   38: iload #5
    //   40: ifeq -> 79
    //   43: aload #10
    //   45: instanceof com/google/android/gms/internal/base/zai
    //   48: ifeq -> 79
    //   51: aload #10
    //   53: checkcast com/google/android/gms/internal/base/zai
    //   56: astore #8
    //   58: invokestatic zaa : ()I
    //   61: istore #7
    //   63: aload_0
    //   64: getfield zab : I
    //   67: ifeq -> 79
    //   70: iload #7
    //   72: aload_0
    //   73: getfield zab : I
    //   76: if_icmpeq -> 226
    //   79: aload_0
    //   80: iload_2
    //   81: iload_3
    //   82: invokevirtual zaa : (ZZ)Z
    //   85: istore_2
    //   86: aload_1
    //   87: astore #8
    //   89: iload_2
    //   90: ifeq -> 145
    //   93: aload #10
    //   95: invokevirtual getDrawable : ()Landroid/graphics/drawable/Drawable;
    //   98: astore #9
    //   100: aload #9
    //   102: ifnull -> 130
    //   105: aload #9
    //   107: astore #8
    //   109: aload #9
    //   111: instanceof com/google/android/gms/internal/base/zaf
    //   114: ifeq -> 133
    //   117: aload #9
    //   119: checkcast com/google/android/gms/internal/base/zaf
    //   122: invokevirtual zaa : ()Landroid/graphics/drawable/Drawable;
    //   125: astore #8
    //   127: goto -> 133
    //   130: aconst_null
    //   131: astore #8
    //   133: new com/google/android/gms/internal/base/zaf
    //   136: dup
    //   137: aload #8
    //   139: aload_1
    //   140: invokespecial <init> : (Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   143: astore #8
    //   145: aload #10
    //   147: aload #8
    //   149: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   152: aload #10
    //   154: instanceof com/google/android/gms/internal/base/zai
    //   157: ifeq -> 206
    //   160: aload #10
    //   162: checkcast com/google/android/gms/internal/base/zai
    //   165: astore_1
    //   166: iload #4
    //   168: ifeq -> 182
    //   171: aload_0
    //   172: getfield zaa : Lcom/google/android/gms/common/images/zac;
    //   175: getfield zaa : Landroid/net/Uri;
    //   178: astore_1
    //   179: goto -> 186
    //   182: getstatic android/net/Uri.EMPTY : Landroid/net/Uri;
    //   185: astore_1
    //   186: aload_1
    //   187: invokestatic zaa : (Landroid/net/Uri;)V
    //   190: iload #5
    //   192: ifeq -> 201
    //   195: aload_0
    //   196: getfield zab : I
    //   199: istore #6
    //   201: iload #6
    //   203: invokestatic zaa : (I)V
    //   206: aload #8
    //   208: ifnull -> 226
    //   211: iload_2
    //   212: ifeq -> 226
    //   215: aload #8
    //   217: checkcast com/google/android/gms/internal/base/zaf
    //   220: sipush #250
    //   223: invokevirtual zaa : (I)V
    //   226: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\images\zab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */