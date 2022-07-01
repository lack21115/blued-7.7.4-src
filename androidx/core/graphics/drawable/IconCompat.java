package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {
  public static final int TYPE_UNKNOWN = -1;
  
  static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
  
  Object a;
  
  PorterDuff.Mode c = b;
  
  public byte[] mData = null;
  
  public int mInt1 = 0;
  
  public int mInt2 = 0;
  
  public Parcelable mParcelable = null;
  
  public ColorStateList mTintList = null;
  
  public String mTintModeStr = null;
  
  public int mType = -1;
  
  public IconCompat() {}
  
  private IconCompat(int paramInt) {
    this.mType = paramInt;
  }
  
  private static int a(Icon paramIcon) {
    if (Build.VERSION.SDK_INT >= 28)
      return paramIcon.getType(); 
    try {
      return ((Integer)paramIcon.getClass().getMethod("getType", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to get icon type ");
      stringBuilder.append(paramIcon);
      Log.e("IconCompat", stringBuilder.toString(), illegalAccessException);
      return -1;
    } catch (InvocationTargetException invocationTargetException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to get icon type ");
      stringBuilder.append(paramIcon);
      Log.e("IconCompat", stringBuilder.toString(), invocationTargetException);
      return -1;
    } catch (NoSuchMethodException noSuchMethodException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to get icon type ");
      stringBuilder.append(paramIcon);
      Log.e("IconCompat", stringBuilder.toString(), noSuchMethodException);
      return -1;
    } 
  }
  
  private static Resources a(Context paramContext, String paramString) {
    if ("android".equals(paramString))
      return Resources.getSystem(); 
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      ApplicationInfo applicationInfo = packageManager.getApplicationInfo(paramString, 8192);
      return (applicationInfo != null) ? packageManager.getResourcesForApplication(applicationInfo) : null;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", new Object[] { paramString }), (Throwable)nameNotFoundException);
      return null;
    } 
  }
  
  static Bitmap a(Bitmap paramBitmap, boolean paramBoolean) {
    int i = (int)(Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) * 0.6666667F);
    Bitmap bitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    Paint paint = new Paint(3);
    float f1 = i;
    float f2 = 0.5F * f1;
    float f3 = 0.9166667F * f2;
    if (paramBoolean) {
      float f = 0.010416667F * f1;
      paint.setColor(0);
      paint.setShadowLayer(f, 0.0F, f1 * 0.020833334F, 1023410176);
      canvas.drawCircle(f2, f2, f3, paint);
      paint.setShadowLayer(f, 0.0F, 0.0F, 503316480);
      canvas.drawCircle(f2, f2, f3, paint);
      paint.clearShadowLayer();
    } 
    paint.setColor(-16777216);
    BitmapShader bitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    Matrix matrix = new Matrix();
    matrix.setTranslate((-(paramBitmap.getWidth() - i) / 2), (-(paramBitmap.getHeight() - i) / 2));
    bitmapShader.setLocalMatrix(matrix);
    paint.setShader((Shader)bitmapShader);
    canvas.drawCircle(f2, f2, f3, paint);
    canvas.setBitmap(null);
    return bitmap;
  }
  
  private Drawable a(Context paramContext) {
    int i = this.mType;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4)
            return (Drawable)((i != 5) ? null : new BitmapDrawable(paramContext.getResources(), a((Bitmap)this.a, false))); 
          Uri uri = Uri.parse((String)this.a);
          String str = uri.getScheme();
          if ("content".equals(str) || "file".equals(str)) {
            try {
              InputStream inputStream = paramContext.getContentResolver().openInputStream(uri);
            } catch (Exception null) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Unable to load image from URI: ");
              stringBuilder.append(uri);
              Log.w("IconCompat", stringBuilder.toString(), exception);
              exception = null;
            } 
          } else {
            try {
              FileInputStream fileInputStream = new FileInputStream(new File((String)this.a));
            } catch (FileNotFoundException exception) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Unable to load image from path: ");
              stringBuilder.append(uri);
              Log.w("IconCompat", stringBuilder.toString(), exception);
              exception = null;
            } 
          } 
          if (exception != null)
            return (Drawable)new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeStream((InputStream)exception)); 
        } else {
          return (Drawable)new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeByteArray((byte[])this.a, this.mInt1, this.mInt2));
        } 
      } else {
        String str2 = getResPackage();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = paramContext.getPackageName(); 
        Resources resources = a(paramContext, str1);
        try {
          return ResourcesCompat.getDrawable(resources, this.mInt1, paramContext.getTheme());
        } catch (RuntimeException runtimeException) {
          Log.e("IconCompat", String.format("Unable to load resource 0x%08x from pkg=%s", new Object[] { Integer.valueOf(this.mInt1), this.a }), runtimeException);
        } 
      } 
      return null;
    } 
    return (Drawable)new BitmapDrawable(runtimeException.getResources(), (Bitmap)this.a);
  }
  
  private static String a(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? ((paramInt != 4) ? ((paramInt != 5) ? "UNKNOWN" : "BITMAP_MASKABLE") : "URI") : "DATA") : "RESOURCE") : "BITMAP";
  }
  
  private static String b(Icon paramIcon) {
    if (Build.VERSION.SDK_INT >= 28)
      return paramIcon.getResPackage(); 
    try {
      return (String)paramIcon.getClass().getMethod("getResPackage", new Class[0]).invoke(paramIcon, new Object[0]);
    } catch (IllegalAccessException illegalAccessException) {
      Log.e("IconCompat", "Unable to get icon package", illegalAccessException);
      return null;
    } catch (InvocationTargetException invocationTargetException) {
      Log.e("IconCompat", "Unable to get icon package", invocationTargetException);
      return null;
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.e("IconCompat", "Unable to get icon package", noSuchMethodException);
      return null;
    } 
  }
  
  private static int c(Icon paramIcon) {
    if (Build.VERSION.SDK_INT >= 28)
      return paramIcon.getResId(); 
    try {
      return ((Integer)paramIcon.getClass().getMethod("getResId", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
    } catch (IllegalAccessException illegalAccessException) {
      Log.e("IconCompat", "Unable to get icon resource", illegalAccessException);
      return 0;
    } catch (InvocationTargetException invocationTargetException) {
      Log.e("IconCompat", "Unable to get icon resource", invocationTargetException);
      return 0;
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.e("IconCompat", "Unable to get icon resource", noSuchMethodException);
      return 0;
    } 
  }
  
  public static IconCompat createFromBundle(Bundle paramBundle) {
    StringBuilder stringBuilder;
    int i = paramBundle.getInt("type");
    IconCompat iconCompat = new IconCompat(i);
    iconCompat.mInt1 = paramBundle.getInt("int1");
    iconCompat.mInt2 = paramBundle.getInt("int2");
    if (paramBundle.containsKey("tint_list"))
      iconCompat.mTintList = (ColorStateList)paramBundle.getParcelable("tint_list"); 
    if (paramBundle.containsKey("tint_mode"))
      iconCompat.c = PorterDuff.Mode.valueOf(paramBundle.getString("tint_mode")); 
    if (i != -1 && i != 1)
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5) {
              stringBuilder = new StringBuilder();
              stringBuilder.append("Unknown type ");
              stringBuilder.append(i);
              Log.w("IconCompat", stringBuilder.toString());
              return null;
            } 
          } else {
            iconCompat.a = stringBuilder.getString("obj");
            return iconCompat;
          } 
        } else {
          iconCompat.a = stringBuilder.getByteArray("obj");
          return iconCompat;
        } 
      } else {
        iconCompat.a = stringBuilder.getString("obj");
        return iconCompat;
      }  
    iconCompat.a = stringBuilder.getParcelable("obj");
    return iconCompat;
  }
  
  public static IconCompat createFromIcon(Context paramContext, Icon paramIcon) {
    IconCompat iconCompat;
    Preconditions.checkNotNull(paramIcon);
    int i = a(paramIcon);
    if (i != 2) {
      if (i != 4) {
        iconCompat = new IconCompat(-1);
        iconCompat.a = paramIcon;
        return iconCompat;
      } 
      return createWithContentUri(d(paramIcon));
    } 
    String str = b(paramIcon);
    try {
      return createWithResource(a((Context)iconCompat, str), str, c(paramIcon));
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      throw new IllegalArgumentException("Icon resource cannot be found");
    } 
  }
  
  public static IconCompat createFromIcon(Icon paramIcon) {
    Preconditions.checkNotNull(paramIcon);
    int i = a(paramIcon);
    if (i != 2) {
      if (i != 4) {
        IconCompat iconCompat = new IconCompat(-1);
        iconCompat.a = paramIcon;
        return iconCompat;
      } 
      return createWithContentUri(d(paramIcon));
    } 
    return createWithResource(null, b(paramIcon), c(paramIcon));
  }
  
  public static IconCompat createFromIconOrNullIfZeroResId(Icon paramIcon) {
    return (a(paramIcon) == 2 && c(paramIcon) == 0) ? null : createFromIcon(paramIcon);
  }
  
  public static IconCompat createWithAdaptiveBitmap(Bitmap paramBitmap) {
    if (paramBitmap != null) {
      IconCompat iconCompat = new IconCompat(5);
      iconCompat.a = paramBitmap;
      return iconCompat;
    } 
    throw new IllegalArgumentException("Bitmap must not be null.");
  }
  
  public static IconCompat createWithBitmap(Bitmap paramBitmap) {
    if (paramBitmap != null) {
      IconCompat iconCompat = new IconCompat(1);
      iconCompat.a = paramBitmap;
      return iconCompat;
    } 
    throw new IllegalArgumentException("Bitmap must not be null.");
  }
  
  public static IconCompat createWithContentUri(Uri paramUri) {
    if (paramUri != null)
      return createWithContentUri(paramUri.toString()); 
    throw new IllegalArgumentException("Uri must not be null.");
  }
  
  public static IconCompat createWithContentUri(String paramString) {
    if (paramString != null) {
      IconCompat iconCompat = new IconCompat(4);
      iconCompat.a = paramString;
      return iconCompat;
    } 
    throw new IllegalArgumentException("Uri must not be null.");
  }
  
  public static IconCompat createWithData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null) {
      IconCompat iconCompat = new IconCompat(3);
      iconCompat.a = paramArrayOfbyte;
      iconCompat.mInt1 = paramInt1;
      iconCompat.mInt2 = paramInt2;
      return iconCompat;
    } 
    throw new IllegalArgumentException("Data must not be null.");
  }
  
  public static IconCompat createWithResource(Context paramContext, int paramInt) {
    if (paramContext != null)
      return createWithResource(paramContext.getResources(), paramContext.getPackageName(), paramInt); 
    throw new IllegalArgumentException("Context must not be null.");
  }
  
  public static IconCompat createWithResource(Resources paramResources, String paramString, int paramInt) {
    if (paramString != null) {
      if (paramInt != 0) {
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.mInt1 = paramInt;
        if (paramResources != null)
          try {
            iconCompat.a = paramResources.getResourceName(paramInt);
            return iconCompat;
          } catch (android.content.res.Resources.NotFoundException notFoundException) {
            throw new IllegalArgumentException("Icon resource cannot be found");
          }  
        iconCompat.a = paramString;
        return iconCompat;
      } 
      throw new IllegalArgumentException("Drawable resource ID must not be 0");
    } 
    throw new IllegalArgumentException("Package must not be null.");
  }
  
  private static Uri d(Icon paramIcon) {
    if (Build.VERSION.SDK_INT >= 28)
      return paramIcon.getUri(); 
    try {
      return (Uri)paramIcon.getClass().getMethod("getUri", new Class[0]).invoke(paramIcon, new Object[0]);
    } catch (IllegalAccessException illegalAccessException) {
      Log.e("IconCompat", "Unable to get icon uri", illegalAccessException);
      return null;
    } catch (InvocationTargetException invocationTargetException) {
      Log.e("IconCompat", "Unable to get icon uri", invocationTargetException);
      return null;
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.e("IconCompat", "Unable to get icon uri", noSuchMethodException);
      return null;
    } 
  }
  
  public void addToShortcutIntent(Intent paramIntent, Drawable paramDrawable, Context paramContext) {
    StringBuilder stringBuilder;
    Bitmap bitmap;
    checkResource(paramContext);
    int i = this.mType;
    if (i != 1) {
      if (i != 2) {
        if (i == 5) {
          bitmap = a((Bitmap)this.a, true);
        } else {
          throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
        } 
      } else {
        try {
          Bitmap bitmap1;
          Context context = bitmap.createPackageContext(getResPackage(), 0);
          if (paramDrawable == null) {
            paramIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", (Parcelable)Intent.ShortcutIconResource.fromContext(context, this.mInt1));
            return;
          } 
          Drawable drawable = ContextCompat.getDrawable(context, this.mInt1);
          if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            i = ((ActivityManager)context.getSystemService("activity")).getLauncherLargeIconSize();
            bitmap1 = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
          } else {
            bitmap1 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
          } 
          drawable.setBounds(0, 0, bitmap1.getWidth(), bitmap1.getHeight());
          drawable.draw(new Canvas(bitmap1));
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Can't find package ");
          stringBuilder.append(this.a);
          throw new IllegalArgumentException(stringBuilder.toString(), nameNotFoundException);
        } 
      } 
    } else {
      Bitmap bitmap1 = (Bitmap)this.a;
      bitmap = bitmap1;
      if (stringBuilder != null)
        bitmap = bitmap1.copy(bitmap1.getConfig(), true); 
    } 
    if (stringBuilder != null) {
      i = bitmap.getWidth();
      int j = bitmap.getHeight();
      stringBuilder.setBounds(i / 2, j / 2, i, j);
      stringBuilder.draw(new Canvas(bitmap));
    } 
    nameNotFoundException.putExtra("android.intent.extra.shortcut.ICON", (Parcelable)bitmap);
  }
  
  public void checkResource(Context paramContext) {
    if (this.mType == 2) {
      String str3 = (String)this.a;
      if (!str3.contains(":"))
        return; 
      String str2 = str3.split(":", -1)[1];
      String str1 = str2.split("/", -1)[0];
      str2 = str2.split("/", -1)[1];
      str3 = str3.split(":", -1)[0];
      int i = a(paramContext, str3).getIdentifier(str2, str1, str3);
      if (this.mInt1 != i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Id has changed for ");
        stringBuilder.append(str3);
        stringBuilder.append("/");
        stringBuilder.append(str2);
        Log.i("IconCompat", stringBuilder.toString());
        this.mInt1 = i;
      } 
    } 
  }
  
  public Bitmap getBitmap() {
    if (this.mType == -1 && Build.VERSION.SDK_INT >= 23) {
      Object object = this.a;
      return (object instanceof Bitmap) ? (Bitmap)object : null;
    } 
    int i = this.mType;
    if (i == 1)
      return (Bitmap)this.a; 
    if (i == 5)
      return a((Bitmap)this.a, true); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("called getBitmap() on ");
    stringBuilder.append(this);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public int getResId() {
    if (this.mType == -1 && Build.VERSION.SDK_INT >= 23)
      return c((Icon)this.a); 
    if (this.mType == 2)
      return this.mInt1; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("called getResId() on ");
    stringBuilder.append(this);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public String getResPackage() {
    if (this.mType == -1 && Build.VERSION.SDK_INT >= 23)
      return b((Icon)this.a); 
    if (this.mType == 2)
      return ((String)this.a).split(":", -1)[0]; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("called getResPackage() on ");
    stringBuilder.append(this);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public int getType() {
    return (this.mType == -1 && Build.VERSION.SDK_INT >= 23) ? a((Icon)this.a) : this.mType;
  }
  
  public Uri getUri() {
    return (this.mType == -1 && Build.VERSION.SDK_INT >= 23) ? d((Icon)this.a) : Uri.parse((String)this.a);
  }
  
  public Drawable loadDrawable(Context paramContext) {
    checkResource(paramContext);
    if (Build.VERSION.SDK_INT >= 23)
      return toIcon().loadDrawable(paramContext); 
    Drawable drawable = a(paramContext);
    if (drawable != null && (this.mTintList != null || this.c != b)) {
      drawable.mutate();
      DrawableCompat.setTintList(drawable, this.mTintList);
      DrawableCompat.setTintMode(drawable, this.c);
    } 
    return drawable;
  }
  
  public void onPostParceling() {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield mTintModeStr : Ljava/lang/String;
    //   5: invokestatic valueOf : (Ljava/lang/String;)Landroid/graphics/PorterDuff$Mode;
    //   8: putfield c : Landroid/graphics/PorterDuff$Mode;
    //   11: aload_0
    //   12: getfield mType : I
    //   15: istore_1
    //   16: iload_1
    //   17: iconst_m1
    //   18: if_icmpeq -> 120
    //   21: iload_1
    //   22: iconst_1
    //   23: if_icmpeq -> 78
    //   26: iload_1
    //   27: iconst_2
    //   28: if_icmpeq -> 56
    //   31: iload_1
    //   32: iconst_3
    //   33: if_icmpeq -> 47
    //   36: iload_1
    //   37: iconst_4
    //   38: if_icmpeq -> 56
    //   41: iload_1
    //   42: iconst_5
    //   43: if_icmpeq -> 78
    //   46: return
    //   47: aload_0
    //   48: aload_0
    //   49: getfield mData : [B
    //   52: putfield a : Ljava/lang/Object;
    //   55: return
    //   56: aload_0
    //   57: new java/lang/String
    //   60: dup
    //   61: aload_0
    //   62: getfield mData : [B
    //   65: ldc_w 'UTF-16'
    //   68: invokestatic forName : (Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   71: invokespecial <init> : ([BLjava/nio/charset/Charset;)V
    //   74: putfield a : Ljava/lang/Object;
    //   77: return
    //   78: aload_0
    //   79: getfield mParcelable : Landroid/os/Parcelable;
    //   82: astore_2
    //   83: aload_2
    //   84: ifnull -> 93
    //   87: aload_0
    //   88: aload_2
    //   89: putfield a : Ljava/lang/Object;
    //   92: return
    //   93: aload_0
    //   94: getfield mData : [B
    //   97: astore_2
    //   98: aload_0
    //   99: aload_2
    //   100: putfield a : Ljava/lang/Object;
    //   103: aload_0
    //   104: iconst_3
    //   105: putfield mType : I
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield mInt1 : I
    //   113: aload_0
    //   114: aload_2
    //   115: arraylength
    //   116: putfield mInt2 : I
    //   119: return
    //   120: aload_0
    //   121: getfield mParcelable : Landroid/os/Parcelable;
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull -> 135
    //   129: aload_0
    //   130: aload_2
    //   131: putfield a : Ljava/lang/Object;
    //   134: return
    //   135: new java/lang/IllegalArgumentException
    //   138: dup
    //   139: ldc_w 'Invalid icon'
    //   142: invokespecial <init> : (Ljava/lang/String;)V
    //   145: athrow
  }
  
  public void onPreParceling(boolean paramBoolean) {
    this.mTintModeStr = this.c.name();
    int i = this.mType;
    if (i != -1) {
      if (i != 1)
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i != 5)
                return; 
            } else {
              this.mData = this.a.toString().getBytes(Charset.forName("UTF-16"));
              return;
            } 
          } else {
            this.mData = (byte[])this.a;
            return;
          } 
        } else {
          this.mData = ((String)this.a).getBytes(Charset.forName("UTF-16"));
          return;
        }  
      if (paramBoolean) {
        Bitmap bitmap = (Bitmap)this.a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
        this.mData = byteArrayOutputStream.toByteArray();
        return;
      } 
      this.mParcelable = (Parcelable)this.a;
      return;
    } 
    if (!paramBoolean) {
      this.mParcelable = (Parcelable)this.a;
      return;
    } 
    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
  }
  
  public IconCompat setTint(int paramInt) {
    return setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public IconCompat setTintList(ColorStateList paramColorStateList) {
    this.mTintList = paramColorStateList;
    return this;
  }
  
  public IconCompat setTintMode(PorterDuff.Mode paramMode) {
    this.c = paramMode;
    return this;
  }
  
  public Bundle toBundle() {
    // Byte code:
    //   0: new android/os/Bundle
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield mType : I
    //   12: istore_1
    //   13: iload_1
    //   14: iconst_m1
    //   15: if_icmpeq -> 111
    //   18: iload_1
    //   19: iconst_1
    //   20: if_icmpeq -> 94
    //   23: iload_1
    //   24: iconst_2
    //   25: if_icmpeq -> 77
    //   28: iload_1
    //   29: iconst_3
    //   30: if_icmpeq -> 57
    //   33: iload_1
    //   34: iconst_4
    //   35: if_icmpeq -> 77
    //   38: iload_1
    //   39: iconst_5
    //   40: if_icmpne -> 46
    //   43: goto -> 94
    //   46: new java/lang/IllegalArgumentException
    //   49: dup
    //   50: ldc_w 'Invalid icon'
    //   53: invokespecial <init> : (Ljava/lang/String;)V
    //   56: athrow
    //   57: aload_2
    //   58: ldc_w 'obj'
    //   61: aload_0
    //   62: getfield a : Ljava/lang/Object;
    //   65: checkcast [B
    //   68: checkcast [B
    //   71: invokevirtual putByteArray : (Ljava/lang/String;[B)V
    //   74: goto -> 125
    //   77: aload_2
    //   78: ldc_w 'obj'
    //   81: aload_0
    //   82: getfield a : Ljava/lang/Object;
    //   85: checkcast java/lang/String
    //   88: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   91: goto -> 125
    //   94: aload_2
    //   95: ldc_w 'obj'
    //   98: aload_0
    //   99: getfield a : Ljava/lang/Object;
    //   102: checkcast android/graphics/Bitmap
    //   105: invokevirtual putParcelable : (Ljava/lang/String;Landroid/os/Parcelable;)V
    //   108: goto -> 125
    //   111: aload_2
    //   112: ldc_w 'obj'
    //   115: aload_0
    //   116: getfield a : Ljava/lang/Object;
    //   119: checkcast android/os/Parcelable
    //   122: invokevirtual putParcelable : (Ljava/lang/String;Landroid/os/Parcelable;)V
    //   125: aload_2
    //   126: ldc_w 'type'
    //   129: aload_0
    //   130: getfield mType : I
    //   133: invokevirtual putInt : (Ljava/lang/String;I)V
    //   136: aload_2
    //   137: ldc_w 'int1'
    //   140: aload_0
    //   141: getfield mInt1 : I
    //   144: invokevirtual putInt : (Ljava/lang/String;I)V
    //   147: aload_2
    //   148: ldc_w 'int2'
    //   151: aload_0
    //   152: getfield mInt2 : I
    //   155: invokevirtual putInt : (Ljava/lang/String;I)V
    //   158: aload_0
    //   159: getfield mTintList : Landroid/content/res/ColorStateList;
    //   162: astore_3
    //   163: aload_3
    //   164: ifnull -> 175
    //   167: aload_2
    //   168: ldc_w 'tint_list'
    //   171: aload_3
    //   172: invokevirtual putParcelable : (Ljava/lang/String;Landroid/os/Parcelable;)V
    //   175: aload_0
    //   176: getfield c : Landroid/graphics/PorterDuff$Mode;
    //   179: astore_3
    //   180: aload_3
    //   181: getstatic androidx/core/graphics/drawable/IconCompat.b : Landroid/graphics/PorterDuff$Mode;
    //   184: if_acmpeq -> 198
    //   187: aload_2
    //   188: ldc_w 'tint_mode'
    //   191: aload_3
    //   192: invokevirtual name : ()Ljava/lang/String;
    //   195: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_2
    //   199: areturn
  }
  
  public Icon toIcon() {
    int i = this.mType;
    if (i != -1) {
      Icon icon;
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i == 5) {
                if (Build.VERSION.SDK_INT >= 26) {
                  icon = Icon.createWithAdaptiveBitmap((Bitmap)this.a);
                } else {
                  icon = Icon.createWithBitmap(a((Bitmap)this.a, false));
                } 
              } else {
                throw new IllegalArgumentException("Unknown type");
              } 
            } else {
              icon = Icon.createWithContentUri((String)this.a);
            } 
          } else {
            icon = Icon.createWithData((byte[])this.a, this.mInt1, this.mInt2);
          } 
        } else {
          icon = Icon.createWithResource(getResPackage(), this.mInt1);
        } 
      } else {
        icon = Icon.createWithBitmap((Bitmap)this.a);
      } 
      ColorStateList colorStateList = this.mTintList;
      if (colorStateList != null)
        icon.setTintList(colorStateList); 
      PorterDuff.Mode mode = this.c;
      if (mode != b)
        icon.setTintMode(mode); 
      return icon;
    } 
    return (Icon)this.a;
  }
  
  public String toString() {
    if (this.mType == -1)
      return String.valueOf(this.a); 
    StringBuilder stringBuilder = new StringBuilder("Icon(typ=");
    stringBuilder.append(a(this.mType));
    int i = this.mType;
    if (i != 1)
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5)
              if (this.mTintList != null) {
                stringBuilder.append(" tint=");
                stringBuilder.append(this.mTintList);
              }  
          } else {
            stringBuilder.append(" uri=");
            stringBuilder.append(this.a);
            if (this.mTintList != null) {
              stringBuilder.append(" tint=");
              stringBuilder.append(this.mTintList);
            } 
          } 
        } else {
          stringBuilder.append(" len=");
          stringBuilder.append(this.mInt1);
          if (this.mInt2 != 0) {
            stringBuilder.append(" off=");
            stringBuilder.append(this.mInt2);
          } 
          if (this.mTintList != null) {
            stringBuilder.append(" tint=");
            stringBuilder.append(this.mTintList);
          } 
        } 
      } else {
        stringBuilder.append(" pkg=");
        stringBuilder.append(getResPackage());
        stringBuilder.append(" id=");
        stringBuilder.append(String.format("0x%08x", new Object[] { Integer.valueOf(getResId()) }));
        if (this.mTintList != null) {
          stringBuilder.append(" tint=");
          stringBuilder.append(this.mTintList);
        } 
      }  
    stringBuilder.append(" size=");
    stringBuilder.append(((Bitmap)this.a).getWidth());
    stringBuilder.append("x");
    stringBuilder.append(((Bitmap)this.a).getHeight());
    if (this.mTintList != null) {
      stringBuilder.append(" tint=");
      stringBuilder.append(this.mTintList);
    } 
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface IconType {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\drawable\IconCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */