package com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

public class NetworkFetcher {
  private final Context a;
  
  private final String b;
  
  private final NetworkCache c;
  
  private NetworkFetcher(Context paramContext, String paramString) {
    this.a = paramContext.getApplicationContext();
    this.b = paramString;
    this.c = new NetworkCache(this.a, paramString);
  }
  
  public static LottieResult<LottieComposition> a(Context paramContext, String paramString) {
    return (new NetworkFetcher(paramContext, paramString)).a();
  }
  
  private LottieComposition b() {
    LottieResult lottieResult;
    Pair<FileExtension, InputStream> pair = this.c.a();
    if (pair == null)
      return null; 
    FileExtension fileExtension = (FileExtension)pair.first;
    InputStream inputStream = (InputStream)pair.second;
    if (fileExtension == FileExtension.b) {
      lottieResult = LottieCompositionFactory.a(new ZipInputStream(inputStream), this.b);
    } else {
      lottieResult = LottieCompositionFactory.a(inputStream, this.b);
    } 
    return (lottieResult.a() != null) ? (LottieComposition)lottieResult.a() : null;
  }
  
  private LottieResult<LottieComposition> c() {
    try {
      return d();
    } catch (IOException iOException) {
      return new LottieResult(iOException);
    } 
  }
  
  private LottieResult d() throws IOException {
    LottieResult lottieResult;
    Exception exception;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fetching ");
    stringBuilder.append(this.b);
    Logger.a(stringBuilder.toString());
    HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(this.b)).openConnection();
    httpURLConnection.setRequestMethod("GET");
    try {
      LottieResult lottieResult1;
      httpURLConnection.connect();
      if (httpURLConnection.getErrorStream() == null) {
        int j = httpURLConnection.getResponseCode();
        if (j == 200) {
          FileExtension fileExtension;
          httpURLConnection.disconnect();
          String str = httpURLConnection.getContentType();
          j = -1;
          int k = str.hashCode();
          boolean bool = true;
          if (k != -1248325150) {
            if (k == -43840953 && str.equals("application/json"))
              j = 1; 
          } else if (str.equals("application/zip")) {
            j = 0;
          } 
          if (j != 0) {
            Logger.a("Received json response.");
            fileExtension = FileExtension.a;
            lottieResult = LottieCompositionFactory.a(new FileInputStream(new File(this.c.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.b);
          } else {
            Logger.a("Handling zip response.");
            fileExtension = FileExtension.b;
            lottieResult = LottieCompositionFactory.a(new ZipInputStream(new FileInputStream(this.c.a(lottieResult.getInputStream(), fileExtension))), this.b);
          } 
          if (lottieResult.a() != null)
            this.c.a(fileExtension); 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Completed fetch from network. Success: ");
          if (lottieResult.a() == null)
            bool = false; 
          stringBuilder2.append(bool);
          Logger.a(stringBuilder2.toString());
          return lottieResult;
        } 
      } 
      int i = lottieResult.getResponseCode();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(lottieResult.getErrorStream()));
      StringBuilder stringBuilder1 = new StringBuilder();
      try {
        while (true) {
          String str = bufferedReader.readLine();
          if (str != null) {
            stringBuilder1.append(str);
            stringBuilder1.append('\n');
            continue;
          } 
          bufferedReader.close();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Unable to fetch ");
          stringBuilder2.append(this.b);
          stringBuilder2.append(". Failed with ");
          stringBuilder2.append(i);
          stringBuilder2.append("\n");
          stringBuilder2.append(stringBuilder1);
          lottieResult1 = new LottieResult(new IllegalArgumentException(stringBuilder2.toString()));
          lottieResult.disconnect();
          return lottieResult1;
        } 
      } catch (Exception exception1) {
        throw exception1;
      } finally {}
      lottieResult1.close();
      throw stringBuilder1;
    } catch (Exception exception1) {
      LottieResult lottieResult1 = new LottieResult(exception1);
      lottieResult.disconnect();
      return lottieResult1;
    } finally {}
    lottieResult.disconnect();
    throw exception;
  }
  
  public LottieResult<LottieComposition> a() {
    LottieComposition lottieComposition = b();
    if (lottieComposition != null)
      return new LottieResult(lottieComposition); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Animation for ");
    stringBuilder.append(this.b);
    stringBuilder.append(" not found in cache. Fetching from network.");
    Logger.a(stringBuilder.toString());
    return c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\network\NetworkFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */