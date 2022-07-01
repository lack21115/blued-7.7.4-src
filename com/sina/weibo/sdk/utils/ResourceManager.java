package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.http.util.EncodingUtils;
import org.xmlpull.v1.XmlPullParser;

public class ResourceManager {
  private static final String DRAWABLE = "drawable";
  
  private static final String DRAWABLE_HDPI = "drawable-hdpi";
  
  private static final String DRAWABLE_LDPI = "drawable-ldpi";
  
  private static final String DRAWABLE_MDPI = "drawable-mdpi";
  
  private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
  
  private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
  
  private static final String[] PRE_INSTALL_DRAWBLE_PATHS;
  
  private static final String TAG = ResourceManager.class.getName();
  
  static {
    PRE_INSTALL_DRAWBLE_PATHS = new String[] { "drawable-xxhdpi", "drawable-xhdpi", "drawable-hdpi", "drawable-mdpi", "drawable-ldpi", "drawable" };
  }
  
  public static ColorStateList createColorStateList(int paramInt1, int paramInt2) {
    int[] arrayOfInt2 = { 16842919 };
    int[] arrayOfInt3 = { 16842913 };
    int[] arrayOfInt1 = StateSet.WILD_CARD;
    return new ColorStateList(new int[][] { arrayOfInt2, arrayOfInt3, { 16842908 }, , arrayOfInt1 }, new int[] { paramInt2, paramInt2, paramInt2, paramInt1 });
  }
  
  public static StateListDrawable createStateListDrawable(Context paramContext, String paramString1, String paramString2) {
    Drawable drawable1;
    Drawable drawable2;
    if (paramString1.indexOf(".9") > -1) {
      drawable2 = getNinePatchDrawable(paramContext, paramString1);
    } else {
      drawable2 = getDrawable(paramContext, (String)drawable2);
    } 
    if (paramString2.indexOf(".9") > -1) {
      drawable1 = getNinePatchDrawable(paramContext, paramString2);
    } else {
      drawable1 = getDrawable((Context)drawable1, paramString2);
    } 
    StateListDrawable stateListDrawable = new StateListDrawable();
    stateListDrawable.addState(new int[] { 16842919 }, drawable1);
    stateListDrawable.addState(new int[] { 16842913 }, drawable1);
    stateListDrawable.addState(new int[] { 16842908 }, drawable1);
    stateListDrawable.addState(StateSet.WILD_CARD, drawable2);
    return stateListDrawable;
  }
  
  public static StateListDrawable createStateListDrawable(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Drawable drawable1;
    Drawable drawable2;
    Drawable drawable3;
    if (paramString1.indexOf(".9") > -1) {
      drawable2 = getNinePatchDrawable(paramContext, paramString1);
    } else {
      drawable2 = getDrawable(paramContext, (String)drawable2);
    } 
    if (paramString3.indexOf(".9") > -1) {
      drawable3 = getNinePatchDrawable(paramContext, paramString3);
    } else {
      drawable3 = getDrawable(paramContext, (String)drawable3);
    } 
    if (paramString2.indexOf(".9") > -1) {
      drawable1 = getNinePatchDrawable(paramContext, paramString2);
    } else {
      drawable1 = getDrawable((Context)drawable1, paramString2);
    } 
    StateListDrawable stateListDrawable = new StateListDrawable();
    stateListDrawable.addState(new int[] { 16842919 }, drawable1);
    stateListDrawable.addState(new int[] { 16842913 }, drawable1);
    stateListDrawable.addState(new int[] { 16842908 }, drawable1);
    stateListDrawable.addState(new int[] { 16842766 }, drawable3);
    stateListDrawable.addState(StateSet.WILD_CARD, drawable2);
    return stateListDrawable;
  }
  
  public static int dp2px(Context paramContext, int paramInt) {
    DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
    return (int)((paramInt * displayMetrics.density) + 0.5D);
  }
  
  private static Drawable extractDrawable(Context paramContext, String paramString) throws Exception {
    InputStream inputStream = paramContext.getAssets().open(paramString);
    DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
    TypedValue typedValue = new TypedValue();
    typedValue.density = displayMetrics.densityDpi;
    Drawable drawable = Drawable.createFromResourceStream(paramContext.getResources(), typedValue, inputStream, paramString);
    inputStream.close();
    return drawable;
  }
  
  private static View extractView(Context paramContext, String paramString, ViewGroup paramViewGroup) throws Exception {
    XmlResourceParser xmlResourceParser = paramContext.getAssets().openXmlResourceParser(paramString);
    return ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate((XmlPullParser)xmlResourceParser, paramViewGroup);
  }
  
  private static String getAppropriatePathOfDrawable(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 17
    //   7: getstatic com/sina/weibo/sdk/utils/ResourceManager.TAG : Ljava/lang/String;
    //   10: ldc 'id is NOT correct!'
    //   12: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: invokestatic getCurrentDpiFolder : (Landroid/content/Context;)Ljava/lang/String;
    //   21: astore #8
    //   23: getstatic com/sina/weibo/sdk/utils/ResourceManager.TAG : Ljava/lang/String;
    //   26: ldc 'find Appropriate path...'
    //   28: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   31: iconst_0
    //   32: istore_2
    //   33: iconst_m1
    //   34: istore #7
    //   36: iconst_m1
    //   37: istore #4
    //   39: iconst_m1
    //   40: istore_3
    //   41: getstatic com/sina/weibo/sdk/utils/ResourceManager.PRE_INSTALL_DRAWBLE_PATHS : [Ljava/lang/String;
    //   44: astore #9
    //   46: iload_2
    //   47: aload #9
    //   49: arraylength
    //   50: if_icmplt -> 63
    //   53: iconst_m1
    //   54: istore #5
    //   56: iload #4
    //   58: istore #6
    //   60: goto -> 156
    //   63: aload #9
    //   65: iload_2
    //   66: aaload
    //   67: aload #8
    //   69: invokevirtual equals : (Ljava/lang/Object;)Z
    //   72: ifeq -> 78
    //   75: iload_2
    //   76: istore #4
    //   78: new java/lang/StringBuilder
    //   81: dup
    //   82: getstatic com/sina/weibo/sdk/utils/ResourceManager.PRE_INSTALL_DRAWBLE_PATHS : [Ljava/lang/String;
    //   85: iload_2
    //   86: aaload
    //   87: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   90: invokespecial <init> : (Ljava/lang/String;)V
    //   93: astore #9
    //   95: aload #9
    //   97: ldc '/'
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload #9
    //   105: aload_1
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload #9
    //   112: invokevirtual toString : ()Ljava/lang/String;
    //   115: astore #9
    //   117: iload_3
    //   118: istore #5
    //   120: aload_0
    //   121: aload #9
    //   123: invokestatic isFileExisted : (Landroid/content/Context;Ljava/lang/String;)Z
    //   126: ifeq -> 274
    //   129: iload #4
    //   131: iload_2
    //   132: if_icmpne -> 138
    //   135: aload #9
    //   137: areturn
    //   138: iload_2
    //   139: istore #5
    //   141: iload #4
    //   143: istore #6
    //   145: iload #4
    //   147: ifge -> 156
    //   150: iload_2
    //   151: istore #5
    //   153: goto -> 274
    //   156: iload_3
    //   157: ifle -> 186
    //   160: iload #5
    //   162: ifle -> 186
    //   165: iload #6
    //   167: iload #5
    //   169: isub
    //   170: invokestatic abs : (I)I
    //   173: iload #6
    //   175: iload_3
    //   176: isub
    //   177: invokestatic abs : (I)I
    //   180: if_icmpgt -> 195
    //   183: goto -> 209
    //   186: iload_3
    //   187: ifle -> 200
    //   190: iload #5
    //   192: ifge -> 200
    //   195: iload_3
    //   196: istore_2
    //   197: goto -> 226
    //   200: iload_3
    //   201: ifge -> 215
    //   204: iload #5
    //   206: ifle -> 215
    //   209: iload #5
    //   211: istore_2
    //   212: goto -> 226
    //   215: getstatic com/sina/weibo/sdk/utils/ResourceManager.TAG : Ljava/lang/String;
    //   218: ldc 'Not find the appropriate path for drawable'
    //   220: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   223: iload #7
    //   225: istore_2
    //   226: iload_2
    //   227: ifge -> 240
    //   230: getstatic com/sina/weibo/sdk/utils/ResourceManager.TAG : Ljava/lang/String;
    //   233: ldc 'Not find the appropriate path for drawable'
    //   235: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   238: aconst_null
    //   239: areturn
    //   240: new java/lang/StringBuilder
    //   243: dup
    //   244: getstatic com/sina/weibo/sdk/utils/ResourceManager.PRE_INSTALL_DRAWBLE_PATHS : [Ljava/lang/String;
    //   247: iload_2
    //   248: aaload
    //   249: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   252: invokespecial <init> : (Ljava/lang/String;)V
    //   255: astore_0
    //   256: aload_0
    //   257: ldc '/'
    //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_0
    //   270: invokevirtual toString : ()Ljava/lang/String;
    //   273: areturn
    //   274: iload_2
    //   275: iconst_1
    //   276: iadd
    //   277: istore_2
    //   278: iload #5
    //   280: istore_3
    //   281: goto -> 41
  }
  
  private static String getCurrentDpiFolder(Context paramContext) {
    int i = (paramContext.getResources().getDisplayMetrics()).densityDpi;
    return (i <= 120) ? "drawable-ldpi" : ((i > 120 && i <= 160) ? "drawable-mdpi" : ((i > 160 && i <= 240) ? "drawable-hdpi" : ((i > 240 && i <= 320) ? "drawable-xhdpi" : "drawable-xxhdpi")));
  }
  
  public static Drawable getDrawable(Context paramContext, String paramString) {
    return getDrawableFromAssert(paramContext, getAppropriatePathOfDrawable(paramContext, paramString), false);
  }
  
  private static Drawable getDrawableFromAssert(Context paramContext, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore #6
    //   8: aconst_null
    //   9: astore #5
    //   11: aconst_null
    //   12: astore #4
    //   14: aload_3
    //   15: aload_1
    //   16: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_3
    //   20: aload #4
    //   22: astore_1
    //   23: aload_3
    //   24: ifnull -> 150
    //   27: aload_3
    //   28: astore_1
    //   29: aload_3
    //   30: invokestatic decodeStream : (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   33: astore #4
    //   35: aload_3
    //   36: astore_1
    //   37: aload_0
    //   38: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   41: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   44: astore #7
    //   46: iload_2
    //   47: ifeq -> 110
    //   50: aload_3
    //   51: astore_1
    //   52: aload_0
    //   53: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   56: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   59: astore #8
    //   61: aload_3
    //   62: astore_1
    //   63: new android/graphics/drawable/NinePatchDrawable
    //   66: dup
    //   67: new android/content/res/Resources
    //   70: dup
    //   71: aload_0
    //   72: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   75: aload #7
    //   77: aload #8
    //   79: invokespecial <init> : (Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
    //   82: aload #4
    //   84: aload #4
    //   86: invokevirtual getNinePatchChunk : ()[B
    //   89: new android/graphics/Rect
    //   92: dup
    //   93: iconst_0
    //   94: iconst_0
    //   95: iconst_0
    //   96: iconst_0
    //   97: invokespecial <init> : (IIII)V
    //   100: aconst_null
    //   101: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;[BLandroid/graphics/Rect;Ljava/lang/String;)V
    //   104: astore_0
    //   105: aload_0
    //   106: astore_1
    //   107: goto -> 150
    //   110: aload_3
    //   111: astore_1
    //   112: aload #4
    //   114: aload #7
    //   116: getfield densityDpi : I
    //   119: invokevirtual setDensity : (I)V
    //   122: aload_3
    //   123: astore_1
    //   124: new android/graphics/drawable/BitmapDrawable
    //   127: dup
    //   128: aload_0
    //   129: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   132: aload #4
    //   134: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   137: astore_0
    //   138: aload_0
    //   139: astore_1
    //   140: goto -> 150
    //   143: astore #4
    //   145: aload_3
    //   146: astore_0
    //   147: goto -> 184
    //   150: aload_1
    //   151: astore #4
    //   153: aload_3
    //   154: ifnull -> 211
    //   157: aload_1
    //   158: astore #4
    //   160: aload_3
    //   161: invokevirtual close : ()V
    //   164: aload_1
    //   165: areturn
    //   166: astore_0
    //   167: aload_0
    //   168: invokevirtual printStackTrace : ()V
    //   171: aload #4
    //   173: areturn
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_1
    //   177: goto -> 215
    //   180: astore #4
    //   182: aconst_null
    //   183: astore_0
    //   184: aload_0
    //   185: astore_1
    //   186: aload #4
    //   188: invokevirtual printStackTrace : ()V
    //   191: aload #5
    //   193: astore #4
    //   195: aload_0
    //   196: ifnull -> 211
    //   199: aload #6
    //   201: astore #4
    //   203: aload_0
    //   204: invokevirtual close : ()V
    //   207: aload #5
    //   209: astore #4
    //   211: aload #4
    //   213: areturn
    //   214: astore_0
    //   215: aload_1
    //   216: ifnull -> 231
    //   219: aload_1
    //   220: invokevirtual close : ()V
    //   223: goto -> 231
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual printStackTrace : ()V
    //   231: aload_0
    //   232: athrow
    // Exception table:
    //   from	to	target	type
    //   14	20	180	java/io/IOException
    //   14	20	174	finally
    //   29	35	143	java/io/IOException
    //   29	35	214	finally
    //   37	46	143	java/io/IOException
    //   37	46	214	finally
    //   52	61	143	java/io/IOException
    //   52	61	214	finally
    //   63	105	143	java/io/IOException
    //   63	105	214	finally
    //   112	122	143	java/io/IOException
    //   112	122	214	finally
    //   124	138	143	java/io/IOException
    //   124	138	214	finally
    //   160	164	166	java/io/IOException
    //   186	191	214	finally
    //   203	207	166	java/io/IOException
    //   219	223	226	java/io/IOException
  }
  
  public static Locale getLanguage() {
    Locale locale2 = Locale.getDefault();
    Locale locale1 = locale2;
    if (!Locale.SIMPLIFIED_CHINESE.equals(locale2)) {
      if (Locale.TRADITIONAL_CHINESE.equals(locale2))
        return locale2; 
      locale1 = Locale.ENGLISH;
    } 
    return locale1;
  }
  
  public static Drawable getNinePatchDrawable(Context paramContext, String paramString) {
    return getDrawableFromAssert(paramContext, getAppropriatePathOfDrawable(paramContext, paramString), true);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Locale locale = getLanguage();
    return Locale.SIMPLIFIED_CHINESE.equals(locale) ? paramString2 : (Locale.TRADITIONAL_CHINESE.equals(locale) ? paramString3 : paramString1);
  }
  
  private static boolean isFileExisted(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      AssetManager assetManager = paramContext.getAssets();
      InputStream inputStream = null;
      paramContext = null;
      try {
        InputStream inputStream2 = assetManager.open(paramString);
        InputStream inputStream1 = inputStream2;
        inputStream = inputStream2;
        String str = TAG;
        inputStream1 = inputStream2;
        inputStream = inputStream2;
        StringBuilder stringBuilder = new StringBuilder("file [");
        inputStream1 = inputStream2;
        inputStream = inputStream2;
        stringBuilder.append(paramString);
        inputStream1 = inputStream2;
        inputStream = inputStream2;
        stringBuilder.append("] existed");
        inputStream1 = inputStream2;
        inputStream = inputStream2;
        LogUtil.d(str, stringBuilder.toString());
        return true;
      } catch (IOException iOException1) {
        InputStream inputStream1 = inputStream;
        String str = TAG;
        inputStream1 = inputStream;
        StringBuilder stringBuilder = new StringBuilder("file [");
        inputStream1 = inputStream;
        stringBuilder.append(paramString);
        inputStream1 = inputStream;
        stringBuilder.append("] NOT existed");
        inputStream1 = inputStream;
        LogUtil.d(str, stringBuilder.toString());
        return false;
      } finally {
        if (iOException != null)
          try {
            iOException.close();
          } catch (IOException iOException1) {
            iOException1.printStackTrace();
          }  
      } 
    } 
    return false;
  }
  
  public static String readCountryFromAsset(Context paramContext, String paramString) {
    String str2 = "";
    String str1 = str2;
    try {
      InputStream inputStream = paramContext.getAssets().open(paramString);
      str1 = str2;
      if (inputStream != null) {
        str1 = str2;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        str1 = str2;
        byte[] arrayOfByte = new byte[dataInputStream.available()];
        str1 = str2;
        dataInputStream.read(arrayOfByte);
        str1 = str2;
        String str = EncodingUtils.getString(arrayOfByte, "UTF-8");
        str1 = str;
        inputStream.close();
        return str;
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return str1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sd\\utils\ResourceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */