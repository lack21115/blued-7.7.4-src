package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.av.encoder.PLAACEncoder;
import com.qiniu.pili.droid.streaming.av.encoder.PLH264Encoder;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;
import com.qiniu.pili.droid.streaming.microphone.AudioMixer;

public class SharedLibraryNameHelper {
  public String a = "pldroid_streaming_h264_encoder";
  
  public String b = "pldroid_streaming_aac_encoder";
  
  public String c = "pldroid_streaming_core";
  
  public String d = "pldroid_mmprocessing";
  
  public String e = "pldroid_streaming_amix";
  
  public SharedLibraryNameHelper() {}
  
  public static boolean a(boolean paramBoolean) {
    if (paramBoolean && !PLAACEncoder.c)
      e.c.e("PLSONameHelper", "SW AAC Codec is not available"); 
    return PLAACEncoder.c;
  }
  
  public static boolean b(boolean paramBoolean) {
    if (paramBoolean && !AudioMixer.s)
      e.c.e("PLSONameHelper", "Audio mix is not available"); 
    return AudioMixer.s;
  }
  
  public static boolean c(boolean paramBoolean) {
    if (paramBoolean && !PLH264Encoder.i)
      e.c.e("PLSONameHelper", "SW H264 Codec is not available"); 
    return PLH264Encoder.i;
  }
  
  public static boolean d(boolean paramBoolean) {
    if (paramBoolean && !a.a.a.a.a.i.a.a)
      e.c.e("PLSONameHelper", "MM Processing is not available"); 
    return a.a.a.a.a.i.a.a;
  }
  
  public static boolean e(boolean paramBoolean) {
    if (paramBoolean && !PLDroidStreamingCore.isLoadOk)
      e.c.e("PLSONameHelper", "Streaming Core is not available"); 
    return PLDroidStreamingCore.isLoadOk;
  }
  
  public static SharedLibraryNameHelper getInstance() {
    return b.a;
  }
  
  public boolean a() {
    return a(getSharedLibraryName(PLSharedLibraryType.PL_SO_TYPE_AAC));
  }
  
  public final boolean a(String paramString) {
    if (!StreamingEnv.b())
      return true; 
    if (paramString != null)
      try {
        if (paramString.contains("/")) {
          System.load(paramString);
          return true;
        } 
        System.loadLibrary(paramString);
        return true;
      } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
        e e = e.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Load error:");
        stringBuilder.append(unsatisfiedLinkError.getMessage());
        e.e("PLSONameHelper", stringBuilder.toString());
      }  
    return false;
  }
  
  public boolean b() {
    return a(getSharedLibraryName(PLSharedLibraryType.PL_SO_TYPE_AUDIO_MIX));
  }
  
  public boolean c() {
    return a(getSharedLibraryName(PLSharedLibraryType.PL_SO_TYPE_H264));
  }
  
  public boolean d() {
    return a(getSharedLibraryName(PLSharedLibraryType.PL_SO_TYPE_MM));
  }
  
  public boolean e() {
    return a(getSharedLibraryName(PLSharedLibraryType.PL_SO_TYPE_CORE));
  }
  
  public String getSharedLibraryName(PLSharedLibraryType paramPLSharedLibraryType) {
    int i = a.a[paramPLSharedLibraryType.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i == 5)
              return this.e; 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cannot support the so type:");
            stringBuilder.append(paramPLSharedLibraryType);
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
          return this.d;
        } 
        return this.b;
      } 
      return this.a;
    } 
    return this.c;
  }
  
  public void renameSharedLibrary(PLSharedLibraryType paramPLSharedLibraryType, String paramString) {
    StringBuilder stringBuilder1;
    e e = e.c;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("renameSharedLibrary type:");
    stringBuilder2.append(paramPLSharedLibraryType);
    stringBuilder2.append(",newName:");
    stringBuilder2.append(paramString);
    e.c("PLSONameHelper", stringBuilder2.toString());
    int i = a.a[paramPLSharedLibraryType.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i == 5) {
              this.e = paramString;
              return;
            } 
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("cannot support the so type:");
            stringBuilder1.append(paramPLSharedLibraryType);
            throw new IllegalArgumentException(stringBuilder1.toString());
          } 
          this.d = (String)stringBuilder1;
          return;
        } 
        this.b = (String)stringBuilder1;
        return;
      } 
      this.a = (String)stringBuilder1;
      return;
    } 
    this.c = (String)stringBuilder1;
  }
  
  public enum PLSharedLibraryType {
    PL_SO_TYPE_AAC, PL_SO_TYPE_AUDIO_MIX, PL_SO_TYPE_CORE, PL_SO_TYPE_H264, PL_SO_TYPE_MM;
    
    static {
      PLSharedLibraryType pLSharedLibraryType = new PLSharedLibraryType("PL_SO_TYPE_AUDIO_MIX", 4);
      PL_SO_TYPE_AUDIO_MIX = pLSharedLibraryType;
      $VALUES = new PLSharedLibraryType[] { PL_SO_TYPE_CORE, PL_SO_TYPE_H264, PL_SO_TYPE_AAC, PL_SO_TYPE_MM, pLSharedLibraryType };
    }
  }
  
  public static class b {
    public static final SharedLibraryNameHelper a = new SharedLibraryNameHelper(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\SharedLibraryNameHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */