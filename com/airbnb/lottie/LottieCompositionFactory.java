package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.LottieCompositionParser;
import com.airbnb.lottie.utils.Utils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

public class LottieCompositionFactory {
  private static final Map<String, LottieTask<LottieComposition>> a = new HashMap<String, LottieTask<LottieComposition>>();
  
  private static LottieImageAsset a(LottieComposition paramLottieComposition, String paramString) {
    for (LottieImageAsset lottieImageAsset : paramLottieComposition.l().values()) {
      if (lottieImageAsset.b().equals(paramString))
        return lottieImageAsset; 
    } 
    return null;
  }
  
  private static LottieResult<LottieComposition> a(JsonReader paramJsonReader, String paramString, boolean paramBoolean) {
    try {
      LottieComposition lottieComposition = LottieCompositionParser.a(paramJsonReader);
      LottieCompositionCache.a().a(paramString, lottieComposition);
      LottieResult<LottieComposition> lottieResult = new LottieResult<LottieComposition>(lottieComposition);
      if (paramBoolean)
        Utils.a((Closeable)paramJsonReader); 
      return lottieResult;
    } catch (Exception exception) {
      LottieResult<LottieComposition> lottieResult = new LottieResult(exception);
      if (paramBoolean)
        Utils.a((Closeable)paramJsonReader); 
      return lottieResult;
    } finally {}
    if (paramBoolean)
      Utils.a((Closeable)paramJsonReader); 
    throw paramString;
  }
  
  public static LottieResult<LottieComposition> a(InputStream paramInputStream, String paramString) {
    return a(paramInputStream, paramString, true);
  }
  
  private static LottieResult<LottieComposition> a(InputStream paramInputStream, String paramString, boolean paramBoolean) {
    try {
      return b(new JsonReader(new InputStreamReader(paramInputStream)), paramString);
    } finally {
      if (paramBoolean)
        Utils.a(paramInputStream); 
    } 
  }
  
  public static LottieResult<LottieComposition> a(String paramString1, String paramString2) {
    return b(new JsonReader(new StringReader(paramString1)), paramString2);
  }
  
  public static LottieResult<LottieComposition> a(ZipInputStream paramZipInputStream, String paramString) {
    try {
      return b(paramZipInputStream, paramString);
    } finally {
      Utils.a(paramZipInputStream);
    } 
  }
  
  @Deprecated
  public static LottieResult<LottieComposition> a(JSONObject paramJSONObject, String paramString) {
    return a(paramJSONObject.toString(), paramString);
  }
  
  public static LottieTask<LottieComposition> a(Context paramContext, int paramInt) {
    paramContext = paramContext.getApplicationContext();
    return a(a(paramInt), new Callable<LottieResult<LottieComposition>>(paramContext, paramInt) {
          public LottieResult<LottieComposition> a() {
            return LottieCompositionFactory.b(this.a, this.b);
          }
        });
  }
  
  public static LottieTask<LottieComposition> a(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("url_");
    stringBuilder.append(paramString);
    return a(stringBuilder.toString(), new Callable<LottieResult<LottieComposition>>(paramContext, paramString) {
          public LottieResult<LottieComposition> a() {
            return NetworkFetcher.a(this.a, this.b);
          }
        });
  }
  
  public static LottieTask<LottieComposition> a(JsonReader paramJsonReader, String paramString) {
    return a(paramString, new Callable<LottieResult<LottieComposition>>(paramJsonReader, paramString) {
          public LottieResult<LottieComposition> a() {
            return LottieCompositionFactory.b(this.a, this.b);
          }
        });
  }
  
  private static LottieTask<LottieComposition> a(String paramString, Callable<LottieResult<LottieComposition>> paramCallable) {
    LottieComposition lottieComposition;
    if (paramString == null) {
      lottieComposition = null;
    } else {
      lottieComposition = LottieCompositionCache.a().a(paramString);
    } 
    if (lottieComposition != null)
      return new LottieTask<LottieComposition>(new Callable<LottieResult<LottieComposition>>(lottieComposition) {
            public LottieResult<LottieComposition> a() {
              return new LottieResult<LottieComposition>(this.a);
            }
          }); 
    if (paramString != null && a.containsKey(paramString))
      return a.get(paramString); 
    LottieTask<LottieComposition> lottieTask = new LottieTask<LottieComposition>(paramCallable);
    lottieTask.a(new LottieListener<LottieComposition>(paramString) {
          public void a(LottieComposition param1LottieComposition) {
            if (this.a != null)
              LottieCompositionCache.a().a(this.a, param1LottieComposition); 
            LottieCompositionFactory.a().remove(this.a);
          }
        });
    lottieTask.c(new LottieListener<Throwable>(paramString) {
          public void a(Throwable param1Throwable) {
            LottieCompositionFactory.a().remove(this.a);
          }
        });
    a.put(paramString, lottieTask);
    return lottieTask;
  }
  
  private static String a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("rawRes_");
    stringBuilder.append(paramInt);
    return stringBuilder.toString();
  }
  
  public static LottieResult<LottieComposition> b(Context paramContext, int paramInt) {
    try {
      return a(paramContext.getResources().openRawResource(paramInt), a(paramInt));
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      return new LottieResult<LottieComposition>((Throwable)notFoundException);
    } 
  }
  
  public static LottieResult<LottieComposition> b(JsonReader paramJsonReader, String paramString) {
    return a(paramJsonReader, paramString, true);
  }
  
  private static LottieResult<LottieComposition> b(ZipInputStream paramZipInputStream, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      StringBuilder stringBuilder;
      ZipEntry zipEntry = paramZipInputStream.getNextEntry();
      LottieComposition lottieComposition = null;
      while (zipEntry != null) {
        String str = zipEntry.getName();
        if (str.contains("__MACOSX")) {
          paramZipInputStream.closeEntry();
        } else if (str.contains(".json")) {
          lottieComposition = a(new JsonReader(new InputStreamReader(paramZipInputStream)), (String)null, false).a();
        } else if (str.contains(".png") || str.contains(".webp")) {
          String[] arrayOfString = str.split("/");
          hashMap.put(arrayOfString[arrayOfString.length - 1], BitmapFactory.decodeStream(paramZipInputStream));
        } else {
          paramZipInputStream.closeEntry();
        } 
        ZipEntry zipEntry1 = paramZipInputStream.getNextEntry();
      } 
      if (lottieComposition == null)
        return new LottieResult<LottieComposition>(new IllegalArgumentException("Unable to parse composition")); 
      for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
        LottieImageAsset lottieImageAsset = a(lottieComposition, (String)entry.getKey());
        if (lottieImageAsset != null)
          lottieImageAsset.a((Bitmap)entry.getValue()); 
      } 
      for (Map.Entry<String, LottieImageAsset> entry : lottieComposition.l().entrySet()) {
        if (((LottieImageAsset)entry.getValue()).c() == null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("There is no image for ");
          stringBuilder.append(((LottieImageAsset)entry.getValue()).b());
          return new LottieResult<LottieComposition>(new IllegalStateException(stringBuilder.toString()));
        } 
      } 
      LottieCompositionCache.a().a((String)stringBuilder, lottieComposition);
      return new LottieResult<LottieComposition>(lottieComposition);
    } catch (IOException iOException) {
      return new LottieResult<LottieComposition>(iOException);
    } 
  }
  
  public static LottieTask<LottieComposition> b(Context paramContext, String paramString) {
    return a(paramString, new Callable<LottieResult<LottieComposition>>(paramContext.getApplicationContext(), paramString) {
          public LottieResult<LottieComposition> a() {
            return LottieCompositionFactory.c(this.a, this.b);
          }
        });
  }
  
  public static LottieResult<LottieComposition> c(Context paramContext, String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("asset_");
      stringBuilder.append(paramString);
      String str = stringBuilder.toString();
      return paramString.endsWith(".zip") ? a(new ZipInputStream(paramContext.getAssets().open(paramString)), str) : a(paramContext.getAssets().open(paramString), str);
    } catch (IOException iOException) {
      return new LottieResult<LottieComposition>(iOException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\LottieCompositionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */