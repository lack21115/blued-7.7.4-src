package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.base.zaq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
  private static final Object zaa = new Object();
  
  private static HashSet<Uri> zab = new HashSet<Uri>();
  
  private static ImageManager zac;
  
  private final Context zad;
  
  private final Handler zae;
  
  private final ExecutorService zaf;
  
  private final zaa zag;
  
  private final zak zah;
  
  private final Map<zaa, ImageReceiver> zai;
  
  private final Map<Uri, ImageReceiver> zaj;
  
  private final Map<Uri, Long> zak;
  
  private ImageManager(Context paramContext, boolean paramBoolean) {
    this.zad = paramContext.getApplicationContext();
    this.zae = (Handler)new zap(Looper.getMainLooper());
    this.zaf = zal.zaa().zaa(4, zaq.zab);
    this.zag = null;
    this.zah = new zak();
    this.zai = new HashMap<zaa, ImageReceiver>();
    this.zaj = new HashMap<Uri, ImageReceiver>();
    this.zak = new HashMap<Uri, Long>();
  }
  
  public static ImageManager create(Context paramContext) {
    if (zac == null)
      zac = new ImageManager(paramContext, false); 
    return zac;
  }
  
  private final Bitmap zaa(zac paramzac) {
    zaa zaa1 = this.zag;
    return (zaa1 == null) ? null : (Bitmap)zaa1.get(paramzac);
  }
  
  private final void zaa(zaa paramzaa) {
    Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
    (new zad(this, paramzaa)).run();
  }
  
  public final void loadImage(ImageView paramImageView, int paramInt) {
    zaa(new zab(paramImageView, paramInt));
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri) {
    zaa(new zab(paramImageView, paramUri));
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri, int paramInt) {
    zab zab = new zab(paramImageView, paramUri);
    zab.zab = paramInt;
    zaa(zab);
  }
  
  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri) {
    zaa(new zad(paramOnImageLoadedListener, paramUri));
  }
  
  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt) {
    zad zad = new zad(paramOnImageLoadedListener, paramUri);
    zad.zab = paramInt;
    zaa(zad);
  }
  
  final class ImageReceiver extends ResultReceiver {
    private final Uri zaa;
    
    private final ArrayList<zaa> zab;
    
    ImageReceiver(ImageManager this$0, Uri param1Uri) {
      super((Handler)new zap(Looper.getMainLooper()));
      this.zaa = param1Uri;
      this.zab = new ArrayList<zaa>();
    }
    
    public final void onReceiveResult(int param1Int, Bundle param1Bundle) {
      ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor)param1Bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zaf(this.zac).execute(new ImageManager.zab(this.zac, this.zaa, parcelFileDescriptor));
    }
    
    public final void zaa() {
      Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      intent.setPackage("com.google.android.gms");
      intent.putExtra("com.google.android.gms.extras.uri", (Parcelable)this.zaa);
      intent.putExtra("com.google.android.gms.extras.resultReceiver", (Parcelable)this);
      intent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.zab(this.zac).sendBroadcast(intent);
    }
    
    public final void zaa(zaa param1zaa) {
      Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
      this.zab.add(param1zaa);
    }
    
    public final void zab(zaa param1zaa) {
      Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.zab.remove(param1zaa);
    }
  }
  
  public static interface OnImageLoadedListener {
    void onImageLoaded(Uri param1Uri, Drawable param1Drawable, boolean param1Boolean);
  }
  
  static final class zaa extends LruCache<zac, Bitmap> {}
  
  final class zab implements Runnable {
    private final Uri zaa;
    
    private final ParcelFileDescriptor zab;
    
    public zab(ImageManager this$0, Uri param1Uri, ParcelFileDescriptor param1ParcelFileDescriptor) {
      this.zaa = param1Uri;
      this.zab = param1ParcelFileDescriptor;
    }
    
    public final void run() {
      Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      ParcelFileDescriptor parcelFileDescriptor = this.zab;
      boolean bool = false;
      Bitmap bitmap = null;
      if (parcelFileDescriptor != null) {
        try {
          Bitmap bitmap1 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
          bitmap = bitmap1;
        } catch (OutOfMemoryError outOfMemoryError) {
          String str = String.valueOf(this.zaa);
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 34);
          stringBuilder.append("OOM while loading bitmap for uri: ");
          stringBuilder.append(str);
          Log.e("ImageManager", stringBuilder.toString(), outOfMemoryError);
          bool = true;
        } 
        try {
          this.zab.close();
        } catch (IOException iOException) {
          Log.e("ImageManager", "closed failed", iOException);
        } 
      } else {
        bitmap = null;
        bool = false;
      } 
      CountDownLatch countDownLatch = new CountDownLatch(1);
      ImageManager.zag(this.zac).post(new ImageManager.zac(this.zac, this.zaa, bitmap, bool, countDownLatch));
      try {
        countDownLatch.await();
        return;
      } catch (InterruptedException interruptedException) {
        String str = String.valueOf(this.zaa);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 32);
        stringBuilder.append("Latch interrupted while posting ");
        stringBuilder.append(str);
        Log.w("ImageManager", stringBuilder.toString());
        return;
      } 
    }
  }
  
  final class zac implements Runnable {
    private final Uri zaa;
    
    private final Bitmap zab;
    
    private final CountDownLatch zac;
    
    private boolean zad;
    
    public zac(ImageManager this$0, Uri param1Uri, Bitmap param1Bitmap, boolean param1Boolean, CountDownLatch param1CountDownLatch) {
      this.zaa = param1Uri;
      this.zab = param1Bitmap;
      this.zad = param1Boolean;
      this.zac = param1CountDownLatch;
    }
    
    public final void run() {
      boolean bool;
      Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
      if (this.zab != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (ImageManager.zah(this.zae) != null) {
        if (this.zad) {
          ImageManager.zah(this.zae).evictAll();
          System.gc();
          this.zad = false;
          ImageManager.zag(this.zae).post(this);
          return;
        } 
        if (this.zab != null)
          ImageManager.zah(this.zae).put(new zac(this.zaa), this.zab); 
      } 
      ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver)ImageManager.zae(this.zae).remove(this.zaa);
      if (imageReceiver != null) {
        ArrayList<zaa> arrayList = ImageManager.ImageReceiver.zaa(imageReceiver);
        int j = arrayList.size();
        for (int i = 0; i < j; i++) {
          zaa zaa = arrayList.get(i);
          if (this.zab != null && bool) {
            zaa.zaa(ImageManager.zab(this.zae), this.zab, false);
          } else {
            ImageManager.zad(this.zae).put(this.zaa, Long.valueOf(SystemClock.elapsedRealtime()));
            zaa.zaa(ImageManager.zab(this.zae), ImageManager.zac(this.zae), false);
          } 
          if (!(zaa instanceof zad))
            ImageManager.zaa(this.zae).remove(zaa); 
        } 
      } 
      this.zac.countDown();
      synchronized (ImageManager.zaa()) {
        ImageManager.zab().remove(this.zaa);
        return;
      } 
    }
  }
  
  final class zad implements Runnable {
    private final zaa zaa;
    
    public zad(ImageManager this$0, zaa param1zaa) {
      this.zaa = param1zaa;
    }
    
    public final void run() {
      Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
      ImageManager.ImageReceiver imageReceiver1 = (ImageManager.ImageReceiver)ImageManager.zaa(this.zab).get(this.zaa);
      if (imageReceiver1 != null) {
        ImageManager.zaa(this.zab).remove(this.zaa);
        imageReceiver1.zab(this.zaa);
      } 
      zac zac = this.zaa.zaa;
      if (zac.zaa == null) {
        this.zaa.zaa(ImageManager.zab(this.zab), ImageManager.zac(this.zab), true);
        return;
      } 
      Bitmap bitmap = ImageManager.zaa(this.zab, zac);
      if (bitmap != null) {
        this.zaa.zaa(ImageManager.zab(this.zab), bitmap, true);
        return;
      } 
      Long long_ = (Long)ImageManager.zad(this.zab).get(zac.zaa);
      if (long_ != null) {
        if (SystemClock.elapsedRealtime() - long_.longValue() < 3600000L) {
          this.zaa.zaa(ImageManager.zab(this.zab), ImageManager.zac(this.zab), true);
          return;
        } 
        ImageManager.zad(this.zab).remove(zac.zaa);
      } 
      this.zaa.zaa(ImageManager.zab(this.zab), ImageManager.zac(this.zab));
      ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver)ImageManager.zae(this.zab).get(zac.zaa);
      null = imageReceiver2;
      if (imageReceiver2 == null) {
        null = new ImageManager.ImageReceiver(this.zab, zac.zaa);
        ImageManager.zae(this.zab).put(zac.zaa, null);
      } 
      null.zaa(this.zaa);
      if (!(this.zaa instanceof zad))
        ImageManager.zaa(this.zab).put(this.zaa, null); 
      synchronized (ImageManager.zaa()) {
        if (!ImageManager.zab().contains(zac.zaa)) {
          ImageManager.zab().add(zac.zaa);
          null.zaa();
        } 
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\images\ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */