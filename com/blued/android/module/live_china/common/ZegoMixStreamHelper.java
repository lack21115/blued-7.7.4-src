package com.blued.android.module.live_china.common;

import android.text.TextUtils;
import android.util.Log;
import com.zego.zegoavkit2.mixstream.IZegoMixStreamExCallback;
import com.zego.zegoavkit2.mixstream.IZegoSoundLevelInMixStreamCallback;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamConfig;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamInfo;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamOutput;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamResultEx;
import com.zego.zegoavkit2.mixstream.ZegoSoundLevelInMixStreamInfo;
import com.zego.zegoavkit2.mixstream.ZegoStreamMixer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZegoMixStreamHelper implements IZegoMixStreamExCallback, IZegoSoundLevelInMixStreamCallback {
  private static ZegoMixStreamHelper a;
  
  private ZegoStreamMixer b = null;
  
  private ZegoMixStreamConfig c = null;
  
  private List<ZegoMixStreamInfo> d = new ArrayList<ZegoMixStreamInfo>();
  
  private MixStreamCallback e = null;
  
  private String f = "rtmp://pili-publish.blued.cn/blued/test-zego-deploy-1?key=e437838e9cc37958";
  
  public static ZegoMixStreamHelper a() {
    // Byte code:
    //   0: ldc com/blued/android/module/live_china/common/ZegoMixStreamHelper
    //   2: monitorenter
    //   3: getstatic com/blued/android/module/live_china/common/ZegoMixStreamHelper.a : Lcom/blued/android/module/live_china/common/ZegoMixStreamHelper;
    //   6: ifnonnull -> 19
    //   9: new com/blued/android/module/live_china/common/ZegoMixStreamHelper
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/blued/android/module/live_china/common/ZegoMixStreamHelper.a : Lcom/blued/android/module/live_china/common/ZegoMixStreamHelper;
    //   19: ldc com/blued/android/module/live_china/common/ZegoMixStreamHelper
    //   21: monitorexit
    //   22: getstatic com/blued/android/module/live_china/common/ZegoMixStreamHelper.a : Lcom/blued/android/module/live_china/common/ZegoMixStreamHelper;
    //   25: areturn
    //   26: astore_0
    //   27: ldc com/blued/android/module/live_china/common/ZegoMixStreamHelper
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	26	finally
    //   19	22	26	finally
    //   27	30	26	finally
  }
  
  public int a(ZegoMixStreamInfo paramZegoMixStreamInfo, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("addMixStreamInfo:");
    stringBuilder.append(paramString);
    Log.i("==record", stringBuilder.toString());
    Iterator<ZegoMixStreamInfo> iterator = this.d.iterator();
    while (iterator.hasNext()) {
      ZegoMixStreamInfo zegoMixStreamInfo = iterator.next();
      if (zegoMixStreamInfo != null && TextUtils.equals(zegoMixStreamInfo.streamID, paramZegoMixStreamInfo.streamID)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("remove MixStreamInfo:");
        stringBuilder1.append(zegoMixStreamInfo.streamID);
        Log.i("==record", stringBuilder1.toString());
        this.d.remove(zegoMixStreamInfo);
        break;
      } 
    } 
    this.d.add(paramZegoMixStreamInfo);
    return a(paramString);
  }
  
  public int a(String paramString) {
    if (this.b == null)
      this.b = new ZegoStreamMixer(); 
    int j = this.d.size();
    ZegoMixStreamInfo[] arrayOfZegoMixStreamInfo = new ZegoMixStreamInfo[j];
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++)
      arrayOfZegoMixStreamInfo[i] = this.d.get(i); 
    if (this.c == null)
      this.c = new ZegoMixStreamConfig(); 
    this.c.outputBitrate = (ZegoCommonHelper.b()).m;
    this.c.outputFps = (ZegoCommonHelper.b()).l;
    this.c.outputWidth = (ZegoCommonHelper.b()).h;
    this.c.outputHeight = (ZegoCommonHelper.b()).i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("outputWidth:");
    stringBuilder.append(this.c.outputWidth);
    stringBuilder.append("  outputHeight:");
    stringBuilder.append(this.c.outputHeight);
    Log.i("==record mixConfig", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("outputFps:");
    stringBuilder.append(this.c.outputFps);
    Log.i("==record mixConfig", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("outputBitrate:");
    stringBuilder.append(this.c.outputBitrate);
    Log.i("==record mixConfig", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("startMixStream:");
    stringBuilder.append(paramString);
    Log.i("==record mixConfig", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("mOutputURL:");
    stringBuilder.append(this.f);
    Log.i("==record mixConfig", stringBuilder.toString());
    this.c.inputStreamList = arrayOfZegoMixStreamInfo;
    ZegoMixStreamOutput zegoMixStreamOutput = new ZegoMixStreamOutput();
    zegoMixStreamOutput.isUrl = true;
    zegoMixStreamOutput.target = this.f;
    ZegoMixStreamConfig zegoMixStreamConfig = this.c;
    zegoMixStreamConfig.outputList = new ZegoMixStreamOutput[] { zegoMixStreamOutput };
    zegoMixStreamConfig.withSoundLevel = false;
    zegoMixStreamConfig.outputAudioConfig = 1;
    ZegoStreamMixer zegoStreamMixer = this.b;
    i = bool;
    if (zegoStreamMixer != null) {
      i = bool;
      if (paramString != null) {
        i = zegoStreamMixer.mixStreamEx(zegoMixStreamConfig, paramString);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("mixStreamEx result:");
        stringBuilder1.append(i);
        Log.i("==record", stringBuilder1.toString());
      } 
    } 
    return i;
  }
  
  public void a(MixStreamCallback paramMixStreamCallback) {
    if (this.b == null)
      this.b = new ZegoStreamMixer(); 
    this.b.setMixStreamExCallback(this);
    this.b.setSoundLevelInMixStreamCallback(this);
    this.e = paramMixStreamCallback;
  }
  
  public void a(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("handleMixStreamDeleted:");
    stringBuilder.append(paramString2);
    Log.i("==makelover==", stringBuilder.toString());
    for (ZegoMixStreamInfo zegoMixStreamInfo : this.d) {
      if (paramString1.equals(zegoMixStreamInfo.streamID)) {
        this.d.remove(zegoMixStreamInfo);
        break;
      } 
    } 
    a(paramString2);
  }
  
  public void b() {
    this.d.clear();
  }
  
  public void b(String paramString) {
    this.f = paramString;
  }
  
  public void c() {
    if (this.b != null)
      this.b = null; 
    if (this.e != null)
      this.e = null; 
    a = null;
  }
  
  public void c(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stopMixStream:");
    stringBuilder.append(paramString);
    Log.i("==makelover==", stringBuilder.toString());
    this.d.clear();
    a(paramString);
  }
  
  public void onMixStreamExConfigUpdate(int paramInt, String paramString, ZegoMixStreamResultEx paramZegoMixStreamResultEx) {
    MixStreamCallback mixStreamCallback = this.e;
    if (mixStreamCallback != null)
      mixStreamCallback.a(paramInt); 
  }
  
  public void onSoundLevelInMixStream(ArrayList<ZegoSoundLevelInMixStreamInfo> paramArrayList) {
    MixStreamCallback mixStreamCallback = this.e;
    if (mixStreamCallback != null)
      mixStreamCallback.a(paramArrayList); 
  }
  
  public static interface MixStreamCallback {
    void a(int param1Int);
    
    void a(ArrayList<ZegoSoundLevelInMixStreamInfo> param1ArrayList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\common\ZegoMixStreamHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */