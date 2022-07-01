package com.qiniu.pili.droid.shortvideo.f;

import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class f {
  private String a;
  
  private MediaExtractor b;
  
  private MediaExtractor c;
  
  private MediaFormat d;
  
  private MediaFormat e;
  
  private List<Long> f;
  
  private List<Long> g;
  
  private boolean h;
  
  public f(String paramString) {
    this(paramString, true, true);
  }
  
  public f(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramString == null) {
      e.w.e("MediaFile", "Create MediaFile failed, empty path");
      return;
    } 
    this.a = paramString;
    if (paramBoolean1)
      a(paramString); 
    if (paramBoolean2)
      b(paramString); 
  }
  
  private int a(MediaExtractor paramMediaExtractor, String paramString) {
    int j = paramMediaExtractor.getTrackCount();
    for (int i = 0; i < j; i++) {
      MediaFormat mediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str = mediaFormat.getString("mime");
      if (str.startsWith(paramString)) {
        e e = e.w;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Extractor selected track ");
        stringBuilder.append(i);
        stringBuilder.append(" (");
        stringBuilder.append(str);
        stringBuilder.append("): ");
        stringBuilder.append(mediaFormat);
        e.b("MediaFile", stringBuilder.toString());
        return i;
      } 
    } 
    return -1;
  }
  
  private List<Long> a(MediaExtractor paramMediaExtractor, long paramLong) {
    LinkedList<Long> linkedList = new LinkedList();
    if (paramMediaExtractor == null)
      return linkedList; 
    while (true) {
      long l = paramMediaExtractor.getSampleTime();
      if (l >= 0L) {
        l += paramLong;
        linkedList.add(Long.valueOf(l));
        e e = e.w;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cache video timestamp: ");
        stringBuilder.append(l);
        e.b("MediaFile", stringBuilder.toString());
      } 
      if (!paramMediaExtractor.advance()) {
        Collections.sort(linkedList);
        paramMediaExtractor.seekTo(0L, 0);
        return linkedList;
      } 
    } 
  }
  
  private boolean a(String paramString) {
    this.b = new MediaExtractor();
    try {
      this.b.setDataSource(paramString);
      int i = a(this.b, "video/");
      if (i >= 0) {
        this.b.selectTrack(i);
        this.d = this.b.getTrackFormat(i);
        return true;
      } 
      e e = e.w;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed to select video track: ");
      stringBuilder.append(this.a);
      e.e("MediaFile", stringBuilder.toString());
    } catch (IOException iOException) {
      e.w.e("MediaFile", iOException.getMessage());
    } 
    return false;
  }
  
  private PLVideoFrame b(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2) {
    e e = e.w;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getVideoFrame at in Us: ");
    stringBuilder.append(paramLong);
    stringBuilder.append(" is key frame: ");
    stringBuilder.append(paramBoolean);
    e.c("MediaFile", stringBuilder.toString());
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    try {
      byte b;
      mediaMetadataRetriever.setDataSource(this.a);
      if (paramBoolean) {
        b = 2;
      } else {
        b = 3;
      } 
      Bitmap bitmap = mediaMetadataRetriever.getFrameAtTime(paramLong, b);
      if (bitmap != null) {
        PLVideoFrame.a a;
        Bitmap bitmap1;
        StringBuilder stringBuilder1;
        Bitmap.Config config = bitmap.getConfig();
        if (config == Bitmap.Config.RGB_565) {
          a = PLVideoFrame.a.b;
        } else if (a == Bitmap.Config.ARGB_8888) {
          a = PLVideoFrame.a.a;
        } else {
          e e1 = e.w;
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(a);
          stringBuilder1.append(" config not supported");
          e1.d("MediaFile", stringBuilder1.toString());
          return null;
        } 
        stringBuilder = stringBuilder1;
        if (paramInt1 != 0) {
          stringBuilder = stringBuilder1;
          if (paramInt2 != 0)
            bitmap1 = ThumbnailUtils.extractThumbnail((Bitmap)stringBuilder1, paramInt1, paramInt2); 
        } 
        ByteBuffer byteBuffer = ByteBuffer.allocate(bitmap1.getByteCount());
        bitmap1.copyPixelsToBuffer(byteBuffer);
        PLVideoFrame pLVideoFrame = new PLVideoFrame();
        pLVideoFrame.setTimestampMs(paramLong / 1000L);
        pLVideoFrame.setData(byteBuffer.array());
        pLVideoFrame.setDataFormat(a);
        pLVideoFrame.setIsKeyFrame(paramBoolean);
        pLVideoFrame.setWidth(bitmap1.getWidth());
        pLVideoFrame.setHeight(bitmap1.getHeight());
        pLVideoFrame.setRotation(0);
        return pLVideoFrame;
      } 
      return null;
    } catch (RuntimeException runtimeException) {
      e.w.e("MediaFile", "Illegal file path for MediaMetadataRetriever");
      return null;
    } 
  }
  
  private boolean b(String paramString) {
    this.c = new MediaExtractor();
    try {
      this.c.setDataSource(paramString);
      int i = a(this.c, "audio/");
      if (i >= 0) {
        this.c.selectTrack(i);
        this.e = this.c.getTrackFormat(i);
        return true;
      } 
      e e = e.w;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed to select audio track: ");
      stringBuilder.append(this.a);
      e.e("MediaFile", stringBuilder.toString());
    } catch (IOException iOException) {
      e.w.e("MediaFile", iOException.getMessage());
    } 
    return false;
  }
  
  private boolean q() {
    // Byte code:
    //   0: getstatic com/qiniu/pili/droid/shortvideo/f/e.w : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   3: ldc 'MediaFile'
    //   5: ldc_w 'initFrameInfo +'
    //   8: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   11: invokestatic currentTimeMillis : ()J
    //   14: lstore_2
    //   15: aload_0
    //   16: new java/util/ArrayList
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: putfield f : Ljava/util/List;
    //   26: aload_0
    //   27: new java/util/ArrayList
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: putfield g : Ljava/util/List;
    //   37: new android/media/MediaExtractor
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore #6
    //   46: aload #6
    //   48: aload_0
    //   49: getfield a : Ljava/lang/String;
    //   52: invokevirtual setDataSource : (Ljava/lang/String;)V
    //   55: iconst_0
    //   56: istore_1
    //   57: iload_1
    //   58: aload #6
    //   60: invokevirtual getTrackCount : ()I
    //   63: if_icmpge -> 96
    //   66: aload #6
    //   68: iload_1
    //   69: invokevirtual getTrackFormat : (I)Landroid/media/MediaFormat;
    //   72: ldc 'mime'
    //   74: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   77: ldc_w 'video'
    //   80: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   83: ifeq -> 89
    //   86: goto -> 98
    //   89: iload_1
    //   90: iconst_1
    //   91: iadd
    //   92: istore_1
    //   93: goto -> 57
    //   96: iconst_m1
    //   97: istore_1
    //   98: iload_1
    //   99: iconst_m1
    //   100: if_icmpne -> 116
    //   103: getstatic com/qiniu/pili/droid/shortvideo/f/e.w : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   106: ldc 'MediaFile'
    //   108: ldc_w 'cannot find video track'
    //   111: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   114: iconst_0
    //   115: ireturn
    //   116: aload #6
    //   118: iload_1
    //   119: invokevirtual selectTrack : (I)V
    //   122: aload #6
    //   124: invokevirtual getSampleFlags : ()I
    //   127: iconst_1
    //   128: iand
    //   129: ifle -> 150
    //   132: aload_0
    //   133: getfield f : Ljava/util/List;
    //   136: aload #6
    //   138: invokevirtual getSampleTime : ()J
    //   141: invokestatic valueOf : (J)Ljava/lang/Long;
    //   144: invokeinterface add : (Ljava/lang/Object;)Z
    //   149: pop
    //   150: aload_0
    //   151: getfield g : Ljava/util/List;
    //   154: aload #6
    //   156: invokevirtual getSampleTime : ()J
    //   159: invokestatic valueOf : (J)Ljava/lang/Long;
    //   162: invokeinterface add : (Ljava/lang/Object;)Z
    //   167: pop
    //   168: aload #6
    //   170: invokevirtual advance : ()Z
    //   173: ifeq -> 186
    //   176: aload #6
    //   178: invokevirtual getSampleTime : ()J
    //   181: lconst_0
    //   182: lcmp
    //   183: ifge -> 122
    //   186: invokestatic currentTimeMillis : ()J
    //   189: lstore #4
    //   191: getstatic com/qiniu/pili/droid/shortvideo/f/e.w : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   194: astore #6
    //   196: new java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial <init> : ()V
    //   203: astore #7
    //   205: aload #7
    //   207: ldc_w 'frame count: '
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload #7
    //   216: aload_0
    //   217: getfield g : Ljava/util/List;
    //   220: invokeinterface size : ()I
    //   225: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload #7
    //   231: ldc_w ' key frame count: '
    //   234: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload #7
    //   240: aload_0
    //   241: getfield f : Ljava/util/List;
    //   244: invokeinterface size : ()I
    //   249: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload #7
    //   255: ldc_w ' cost timeMs: '
    //   258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload #7
    //   264: lload #4
    //   266: lload_2
    //   267: lsub
    //   268: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload #6
    //   274: ldc 'MediaFile'
    //   276: aload #7
    //   278: invokevirtual toString : ()Ljava/lang/String;
    //   281: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   284: getstatic com/qiniu/pili/droid/shortvideo/f/e.w : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   287: ldc 'MediaFile'
    //   289: ldc_w 'initFrameInfo -'
    //   292: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   295: iconst_1
    //   296: ireturn
    //   297: astore #6
    //   299: getstatic com/qiniu/pili/droid/shortvideo/f/e.w : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   302: ldc 'MediaFile'
    //   304: aload #6
    //   306: invokevirtual getMessage : ()Ljava/lang/String;
    //   309: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   312: iconst_0
    //   313: ireturn
    // Exception table:
    //   from	to	target	type
    //   46	55	297	java/io/IOException
  }
  
  public int a(boolean paramBoolean) {
    List<Long> list;
    if (this.g == null || this.f == null)
      this.h = q(); 
    if (!this.h)
      return -1; 
    if (paramBoolean && !this.f.isEmpty()) {
      e e = e.w;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("already got key frame count: ");
      stringBuilder.append(this.f.size());
      e.b("MediaFile", stringBuilder.toString());
      return this.f.size();
    } 
    if (!paramBoolean && !this.g.isEmpty()) {
      e e = e.w;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("already got frame count: ");
      stringBuilder.append(this.g.size());
      e.b("MediaFile", stringBuilder.toString());
      return this.g.size();
    } 
    if (paramBoolean) {
      list = this.f;
    } else {
      list = this.g;
    } 
    return list.size();
  }
  
  public PLVideoFrame a(int paramInt, boolean paramBoolean) {
    return a(paramInt, paramBoolean, 0, 0);
  }
  
  public PLVideoFrame a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
    List<Long> list;
    if (this.g == null || this.f == null)
      this.h = q(); 
    if (!this.h)
      return null; 
    if (paramBoolean) {
      list = this.f;
    } else {
      list = this.g;
    } 
    return b(((Long)list.get(paramInt1)).longValue(), paramBoolean, paramInt2, paramInt3);
  }
  
  public PLVideoFrame a(long paramLong, boolean paramBoolean) {
    return a(paramLong, paramBoolean, 0, 0);
  }
  
  public PLVideoFrame a(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2) {
    return b(paramLong * 1000L, paramBoolean, paramInt1, paramInt2);
  }
  
  public void a() {
    MediaExtractor mediaExtractor = this.b;
    if (mediaExtractor != null) {
      mediaExtractor.release();
      this.b = null;
    } 
    mediaExtractor = this.c;
    if (mediaExtractor != null) {
      mediaExtractor.release();
      this.c = null;
    } 
  }
  
  public String b() {
    return this.a;
  }
  
  public MediaExtractor c() {
    return this.b;
  }
  
  public MediaExtractor d() {
    return this.c;
  }
  
  public MediaFormat e() {
    return this.d;
  }
  
  public MediaFormat f() {
    return this.e;
  }
  
  public long g() {
    return g.a(this.a);
  }
  
  public int h() {
    MediaFormat mediaFormat = this.d;
    if (mediaFormat != null && mediaFormat.containsKey("width"))
      return this.d.getInteger("width"); 
    e e = e.w;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("failed to get video width: ");
    stringBuilder.append(this.a);
    e.d("MediaFile", stringBuilder.toString());
    return 0;
  }
  
  public int i() {
    MediaFormat mediaFormat = this.d;
    if (mediaFormat != null && mediaFormat.containsKey("height"))
      return this.d.getInteger("height"); 
    e e = e.w;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("failed to get video height: ");
    stringBuilder.append(this.a);
    e.d("MediaFile", stringBuilder.toString());
    return 0;
  }
  
  public int j() {
    boolean bool;
    MediaFormat mediaFormat = this.d;
    if (mediaFormat != null && mediaFormat.containsKey("frame-rate")) {
      bool = this.d.getInteger("frame-rate");
    } else {
      bool = false;
    } 
    if (!bool) {
      if (g() != 0L)
        return (int)((a(false) * 1000) / g()); 
      e e = e.w;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed to get video framerate: ");
      stringBuilder.append(this.a);
      stringBuilder.append(", illegal video duration value.");
      e.d("MediaFile", stringBuilder.toString());
    } 
    return bool;
  }
  
  public int k() {
    MediaFormat mediaFormat = this.d;
    if (mediaFormat != null && mediaFormat.containsKey("bitrate"))
      return this.d.getInteger("bitrate"); 
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    mediaMetadataRetriever.setDataSource(this.a);
    String str = mediaMetadataRetriever.extractMetadata(20);
    if (str != null)
      return Integer.parseInt(str); 
    e e = e.w;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("failed to get video bitrate: ");
    stringBuilder.append(this.a);
    e.d("MediaFile", stringBuilder.toString());
    return 0;
  }
  
  public int l() {
    MediaFormat mediaFormat = this.d;
    if (mediaFormat != null && mediaFormat.containsKey("i-frame-interval"))
      return this.d.getInteger("i-frame-interval"); 
    e e = e.w;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("failed to get video i interval: ");
    stringBuilder.append(this.a);
    e.d("MediaFile", stringBuilder.toString());
    return 0;
  }
  
  public int m() {
    return g.d(this.a);
  }
  
  public int n() {
    MediaFormat mediaFormat = this.e;
    if (mediaFormat != null && mediaFormat.containsKey("channel-count"))
      return this.e.getInteger("channel-count"); 
    e e = e.w;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("failed to get audio channels: ");
    stringBuilder.append(this.a);
    e.d("MediaFile", stringBuilder.toString());
    return 0;
  }
  
  public int o() {
    MediaFormat mediaFormat = this.e;
    if (mediaFormat != null && mediaFormat.containsKey("sample-rate"))
      return this.e.getInteger("sample-rate"); 
    e e = e.w;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("failed to get audio samplerate: ");
    stringBuilder.append(this.a);
    e.d("MediaFile", stringBuilder.toString());
    return 0;
  }
  
  public List<Long> p() {
    return a(this.b, 0L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\f\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */