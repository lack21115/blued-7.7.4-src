package com.qiniu.pili.droid.streaming.core;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import a.a.a.a.a.f.d;
import android.content.Intent;
import com.qiniu.android.dns.DnsManager;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.Map;

public class PLDroidStreamingCore {
  public static int ERROR_CODE_DISCONNECTED = 0;
  
  public static int ERROR_CODE_TIME_OUT = 0;
  
  public static int ERROR_CODE_UNAUTHORIZED_URL = 0;
  
  public static int ERROR_CODE_UNINITIALIZED = 0;
  
  public static final String TAG = "PLDroidStreamingCore";
  
  public static final boolean isLoadOk = SharedLibraryNameHelper.getInstance().e();
  
  public static String mDomain;
  
  public static String mPath;
  
  public static String mRemoteIP;
  
  public static String mReqID;
  
  public static String mScheme;
  
  public String currentUrl;
  
  public boolean isUnauthorized = false;
  
  public final a.a.a.a.a.n.b.g listener = new a(this);
  
  public b mErrorListener;
  
  public boolean mInitialized = false;
  
  static {
    ERROR_CODE_TIME_OUT = -110;
    ERROR_CODE_UNINITIALIZED = -1;
    ERROR_CODE_DISCONNECTED = -2;
    ERROR_CODE_UNAUTHORIZED_URL = -3;
  }
  
  private void checkAVOptions(AVOptions paramAVOptions) {
    e.f.b("PLDroidStreamingCore", "checkAVOptions");
    if (paramAVOptions.ispName == null) {
      paramAVOptions.ispName = "";
      e.f.e("PLDroidStreamingCore", "AVOptions: ispName is null");
    } 
    if (paramAVOptions.appName == null) {
      paramAVOptions.appName = "";
      e.f.e("PLDroidStreamingCore", "AVOptions: appName is null");
    } 
    if (paramAVOptions.appVersion == null) {
      paramAVOptions.appVersion = "";
      e.f.e("PLDroidStreamingCore", "AVOptions: appVersion is null");
    } 
    if (paramAVOptions.networkType == null) {
      paramAVOptions.networkType = "Unknown";
      e.f.e("PLDroidStreamingCore", "AVOptions: networkType is unknown");
    } 
  }
  
  private native void doFinalize(boolean paramBoolean);
  
  public static void getDomain(String paramString) throws IOException {
    try {
      mDomain = a.a.a.a.a.n.b.a(paramString);
      return;
    } catch (URISyntaxException uRISyntaxException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("invalid url=>");
      stringBuilder.append(paramString);
      throw new IOException(stringBuilder.toString());
    } 
  }
  
  public static String getOutputUrlByDns(String paramString) throws IOException {
    DnsManager dnsManager = StreamingProfile.getDnsManager();
    if (dnsManager != null)
      try {
        URI uRI = new URI(paramString);
        mScheme = uRI.getScheme();
        mPath = uRI.getPath();
        if (DnsManager.validIP(uRI.getHost()))
          return paramString; 
        String[] arrayOfString = dnsManager.query(uRI.getHost());
        if (arrayOfString != null && arrayOfString.length > 0) {
          String str = uRI.getQuery();
          if (uRI.getPort() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(":");
            stringBuilder.append(Integer.toString(uRI.getPort()));
            String str1 = stringBuilder.toString();
          } else {
            paramString = "";
          } 
          return (str == null || str.equals("")) ? String.format("rtmp://%s%s%s?domain=%s", new Object[] { arrayOfString[0], paramString, uRI.getPath(), uRI.getHost() }) : String.format("rtmp://%s%s%s?%s&domain=%s", new Object[] { arrayOfString[0], paramString, uRI.getPath(), uRI.getQuery(), uRI.getHost() });
        } 
      } catch (URISyntaxException uRISyntaxException) {
        uRISyntaxException.printStackTrace();
        throw new IOException(uRISyntaxException.getMessage());
      }  
    return (String)uRISyntaxException;
  }
  
  public static String getOutputUrlByZeus(String paramString) throws IOException, URISyntaxException {
    return a.a.a.a.a.n.b.a().b(paramString);
  }
  
  private native String getPushIP();
  
  public static Integer[] getQuicConfig() {
    return a.a.a.a.a.n.b.a().c(mDomain);
  }
  
  private native String getReqID();
  
  private String getRtmpOptions(Map<String, String> paramMap) {
    if (paramMap != null && !paramMap.isEmpty()) {
      StringBuilder stringBuilder = new StringBuilder();
      for (Map.Entry<String, String> entry : paramMap.entrySet()) {
        stringBuilder.append(" ");
        stringBuilder.append((String)entry.getKey());
        stringBuilder.append("=");
        stringBuilder.append((String)entry.getValue());
      } 
      return stringBuilder.toString();
    } 
    return null;
  }
  
  private native void initialize(AVOptions paramAVOptions) throws IOException;
  
  private void initializeInternal(AVOptions paramAVOptions) throws IOException {
    String str1;
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isLoggingEnabled:");
    stringBuilder.append(paramAVOptions.isLoggingEnabled);
    e.c("PLDroidStreamingCore", stringBuilder.toString());
    this.currentUrl = paramAVOptions.outputUrl;
    this.isUnauthorized = false;
    a.a.a.a.a.n.b.a().a(this.listener);
    updateOutputUrl(paramAVOptions);
    checkAVOptions(paramAVOptions);
    String str2 = getRtmpOptions(paramAVOptions.rtmpOptions);
    if (str2 != null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramAVOptions.outputUrl);
      stringBuilder.append(str2);
      paramAVOptions.outputUrl = stringBuilder.toString();
    } 
    getDomain(this.currentUrl);
    if (a.a.a.a.a.n.b.a) {
      Integer[] arrayOfInteger = getQuicConfig();
      if (arrayOfInteger.length == 2) {
        int i = arrayOfInteger[0].intValue();
        paramAVOptions.quicPort = arrayOfInteger[1].intValue();
        if (i == 1) {
          paramAVOptions.quicEnable = true;
        } else if (i == 2) {
          paramAVOptions.quicEnable = false;
        } 
        e e1 = e.f;
        stringBuilder = new StringBuilder();
        stringBuilder.append("quic mode = ");
        stringBuilder.append(i);
        stringBuilder.append(", port = ");
        stringBuilder.append(paramAVOptions.quicPort);
        stringBuilder.append(", enable = ");
        stringBuilder.append(paramAVOptions.quicEnable);
        e1.a(stringBuilder.toString());
      } 
    } else {
      paramAVOptions.quicEnable = false;
    } 
    initialize(paramAVOptions);
    mRemoteIP = getPushIP();
    mReqID = getReqID();
    this.mInitialized = true;
    Intent intent = new Intent("pldroid-qos-filter");
    intent.putExtra("pldroid-qos-msg-type", 4);
    if (paramAVOptions.quicEnable) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(mScheme);
      stringBuilder1.append(".quic");
      str1 = stringBuilder1.toString();
    } else {
      str1 = mScheme;
    } 
    intent.putExtra("scheme", str1);
    intent.putExtra("domain", mDomain);
    intent.putExtra("remoteIp", mRemoteIP);
    intent.putExtra("path", mPath);
    intent.putExtra("reqid", mReqID);
    a.a.a.a.a.j.a.a().a(intent);
  }
  
  private native void prepareAudioExtraData(byte[] paramArrayOfbyte, int paramInt, long paramLong);
  
  private native void prepareVideoExtraData(byte[] paramArrayOfbyte, int paramInt, long paramLong);
  
  public static void updateOutputUrl(AVOptions paramAVOptions) throws IOException {
    paramAVOptions.sendTimeout = StreamingProfile.getSendTimeout();
    if (a.a.a.a.a.n.b.a && !a.a.a.a.a.c.a.a().b())
      try {
        paramAVOptions.outputUrl = getOutputUrlByZeus(paramAVOptions.outputUrl);
        paramAVOptions.outputUrl = getOutputUrlByDns(paramAVOptions.outputUrl);
        return;
      } catch (URISyntaxException uRISyntaxException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid url=>");
        stringBuilder.append(paramAVOptions.outputUrl);
        throw new IOException(stringBuilder.toString());
      }  
    paramAVOptions.outputUrl = getOutputUrlByDns(paramAVOptions.outputUrl);
  }
  
  private native int writePacket(ByteBuffer paramByteBuffer, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, byte[] paramArrayOfbyte, int paramInt2);
  
  public void errorCallback(int paramInt) {
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("errorCode:");
    stringBuilder.append(paramInt);
    e.c("PLDroidStreamingCore", stringBuilder.toString());
  }
  
  public void errorCallback(int paramInt, String paramString) {
    b b1 = this.mErrorListener;
    if (b1 != null)
      b1.a(paramInt, paramString); 
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("errorCode:");
    stringBuilder.append(paramInt);
    stringBuilder.append(", msg:");
    stringBuilder.append(paramString);
    e.c("PLDroidStreamingCore", stringBuilder.toString());
  }
  
  public String getPath() {
    return mPath;
  }
  
  public String getRemoteIP() {
    String str2 = mRemoteIP;
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  public void initCore(AVOptions paramAVOptions) throws IOException {
    initializeInternal(paramAVOptions);
  }
  
  public boolean isInitialized() {
    return this.mInitialized;
  }
  
  public int sendFrame(ByteBuffer paramByteBuffer, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {
    return sendFrame(paramByteBuffer, paramInt, paramLong1, paramLong2, paramBoolean1, paramBoolean2, null);
  }
  
  public int sendFrame(ByteBuffer paramByteBuffer, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, String paramString) {
    boolean bool;
    if (this.isUnauthorized) {
      errorCallback(ERROR_CODE_UNAUTHORIZED_URL, "ERROR_CODE_UNAUTHORIZED_URL");
      return ERROR_CODE_UNAUTHORIZED_URL;
    } 
    if (!this.mInitialized)
      return ERROR_CODE_UNINITIALIZED; 
    if (paramString != null && !paramString.isEmpty()) {
      byte[] arrayOfByte2 = paramString.getBytes();
      bool = arrayOfByte2.length;
      e e = e.i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("send sei  : ");
      stringBuilder.append(paramString);
      stringBuilder.append(" size ： ");
      stringBuilder.append(bool);
      e.e("PLDroidStreamingCore", stringBuilder.toString());
      byte[] arrayOfByte1 = arrayOfByte2;
    } else {
      paramString = null;
      bool = false;
    } 
    return writePacket(paramByteBuffer, paramInt, paramLong1, paramLong2, paramBoolean1, paramBoolean2, (byte[])paramString, bool);
  }
  
  public final void setOnErrorListener(b paramb) {
    if (paramb == null) {
      e.f.e("PLDroidStreamingCore", "Error!!! listener cannot be null");
      return;
    } 
    this.mErrorListener = paramb;
  }
  
  public void shutDown(boolean paramBoolean) {
    a.a.a.a.a.n.b.a().b(this.listener);
    this.mErrorListener = null;
    doFinalize(paramBoolean);
    this.mInitialized = false;
  }
  
  public native void updateAVOptions(AVOptions paramAVOptions, boolean paramBoolean);
  
  public void writeAudioSeqHeader(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    prepareAudioExtraData(paramArrayOfbyte, paramInt, paramLong);
  }
  
  public void writeVideoSeqHeader(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    prepareVideoExtraData(paramArrayOfbyte, paramInt, paramLong);
  }
  
  public static class AVOptions implements Cloneable {
    public String appName = "";
    
    public String appVersion = "";
    
    public int audioBitRate = 128000;
    
    public String audioEncodeType = "voaac";
    
    public int audioNumChannels = 1;
    
    public int audioSampleRate = 44100;
    
    public boolean avcc = true;
    
    public String componentsVersion = "librtmp-1.1.0;PLDroidCameraStreaming-3.0.0";
    
    public long cuBasetime = 0L;
    
    public String deviceModel = h.i();
    
    public boolean enablePhonePermission = false;
    
    public boolean enableWifiPermission = false;
    
    public long gopTimeMS = 0L;
    
    public boolean isLoggingEnabled = e.a();
    
    public boolean isWifiNetwork = true;
    
    public String ispName = "";
    
    public String networkType = "";
    
    public String osPlatform = "Android";
    
    public String osVersion = h.j();
    
    public String outputFormatName = "flv";
    
    public String outputUrl = "test.flv";
    
    public boolean quicEnable = false;
    
    public int quicPort = 6935;
    
    public Map<String, String> rtmpOptions = null;
    
    public int sendTimeout = 3;
    
    public int signalDB = 0;
    
    public int type = PLDroidStreamingCore.c.a.ordinal();
    
    public int videoBitRate = 1500000;
    
    public String videoEncodeType = "x264";
    
    public int videoFps = 30;
    
    public int videoHeight = 1280;
    
    public int videoWidth = 720;
    
    public Object clone() throws CloneNotSupportedException {
      return super.clone();
    }
  }
  
  public class a implements a.a.a.a.a.n.b.g {
    public a(PLDroidStreamingCore this$0) {}
    
    public void a() {
      if (this.a.currentUrl != null)
        try {
          a.a.a.a.a.n.b.a().b(this.a.currentUrl);
          return;
        } catch (URISyntaxException uRISyntaxException) {
          uRISyntaxException.printStackTrace();
          return;
        } catch (d d) {
          PLDroidStreamingCore.access$102(this.a, true);
          return;
        }  
    }
  }
  
  public static interface b {
    void a(int param1Int, String param1String);
  }
  
  public enum c {
    a, b, c;
    
    static {
      c c1 = new c("AUDIO", 2);
      c = c1;
      d = new c[] { a, b, c1 };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\core\PLDroidStreamingCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */