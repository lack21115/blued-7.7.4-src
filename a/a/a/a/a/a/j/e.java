package a.a.a.a.a.a.j;

import a.a.a.a.a.a.a;
import a.a.a.a.a.a.b;
import a.a.a.a.a.a.g.a;
import a.a.a.a.a.a.g.b;
import a.a.a.a.a.a.g.c;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.e.h;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.io.IOException;

public class e extends a implements a {
  public Surface d;
  
  public e(c paramc) throws IOException {
    super(paramc);
    paramc.a((c.d)this);
    b b = paramc.d();
    MediaFormat mediaFormat = a(2130708361, b, b.f().getVideoProfile());
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("format: ");
    stringBuilder.append(mediaFormat);
    e1.a("VideoEncoderCore", stringBuilder.toString());
    c c1 = new c(mediaFormat, "video/avc", true);
    this.b = (b)c1;
    this.d = c1.e();
    this.b.d();
    this.c = 1;
  }
  
  public e(f.a parama) {
    super(parama.a);
    parama.a.a((c.d)this);
    MediaCodecInfo mediaCodecInfo = a("video/avc");
    if (mediaCodecInfo == null) {
      a.a.a.a.a.e.e.i.e("VideoEncoderCore", "Unable to find an appropriate codec for video/avc");
      return;
    } 
    a.a.a.a.a.e.e e3 = a.a.a.a.a.e.e.i;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("found codec: ");
    stringBuilder2.append(mediaCodecInfo.getName());
    e3.c("VideoEncoderCore", stringBuilder2.toString());
    int[] arrayOfInt = a(mediaCodecInfo, "video/avc");
    if (arrayOfInt == null) {
      a.a.a.a.a.e.e.i.e("VideoEncoderCore", "Unable to find an appropriate colorFormat for video/avc");
      return;
    } 
    e3 = a.a.a.a.a.e.e.i;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("found colorFormat:[");
    stringBuilder2.append(arrayOfInt[0]);
    stringBuilder2.append(",");
    stringBuilder2.append(arrayOfInt[1]);
    stringBuilder2.append("]");
    e3.c("VideoEncoderCore", stringBuilder2.toString());
    parama.k = arrayOfInt[1];
    b b = parama.a.d();
    a.a.a.a.a.e.e e4 = a.a.a.a.a.e.e.i;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("encoding rotation:");
    stringBuilder3.append(parama.e);
    e4.c("VideoEncoderCore", stringBuilder3.toString());
    StreamingProfile.VideoProfile videoProfile = b.f().getVideoProfile();
    MediaFormat mediaFormat = a(arrayOfInt[0], b, videoProfile);
    a.a.a.a.a.e.e e2 = a.a.a.a.a.e.e.i;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("format: ");
    stringBuilder1.append(mediaFormat);
    e2.c("VideoEncoderCore", stringBuilder1.toString());
    a.a.a.a.a.a.g.e e1 = new a.a.a.a.a.a.g.e(mediaFormat, "video/avc", true, parama);
    this.b = (b)e1;
    e1.d();
    this.c = 1;
  }
  
  public static MediaCodecInfo a(String paramString) {
    int j = MediaCodecList.getCodecCount();
    for (int i = 0; i < j; i++) {
      MediaCodecInfo mediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (mediaCodecInfo.isEncoder()) {
        String[] arrayOfString = mediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        for (int k = 0; k < m; k++) {
          if (arrayOfString[k].equalsIgnoreCase(paramString))
            return mediaCodecInfo; 
        } 
      } 
    } 
    return null;
  }
  
  public static int[] a(MediaCodecInfo paramMediaCodecInfo, String paramString) {
    MediaCodecInfo.CodecCapabilities codecCapabilities = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    int i = 0;
    while (true) {
      int[] arrayOfInt = codecCapabilities.colorFormats;
      if (i < arrayOfInt.length) {
        int j = arrayOfInt[i];
        int k = c(j);
        if (k != -1)
          return new int[] { j, k }; 
        i++;
        continue;
      } 
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("couldn't find a good color format for ");
      stringBuilder.append(paramMediaCodecInfo.getName());
      stringBuilder.append(" / ");
      stringBuilder.append(paramString);
      e1.e("VideoEncoderCore", stringBuilder.toString());
      return null;
    } 
  }
  
  public static int c(int paramInt) {
    return (paramInt != 19) ? ((paramInt != 21) ? -1 : PLFourCC.FOURCC_NV12) : PLFourCC.FOURCC_I420;
  }
  
  public final MediaFormat a(int paramInt, b paramb, StreamingProfile.VideoProfile paramVideoProfile) {
    int j = paramb.a().a();
    int k = paramb.a().b();
    int i = j;
    if (h.e())
      i = h.a(j, k); 
    MediaFormat mediaFormat = MediaFormat.createVideoFormat("video/avc", i, k);
    mediaFormat.setInteger("color-format", paramInt);
    paramInt = Math.round(paramb.p() * 1.0F / paramb.r());
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("w:");
    stringBuilder.append(i);
    stringBuilder.append(", h:");
    stringBuilder.append(k);
    stringBuilder.append(",iFrameInterval:");
    stringBuilder.append(paramInt);
    stringBuilder.append(",fps:");
    stringBuilder.append(paramb.r());
    stringBuilder.append(",bitrate:");
    stringBuilder.append(paramb.d());
    e1.c("VideoEncoderCore", stringBuilder.toString());
    mediaFormat.setInteger("bitrate", paramb.d());
    mediaFormat.setInteger("frame-rate", paramb.r());
    mediaFormat.setInteger("i-frame-interval", paramInt);
    mediaFormat.setInteger("level", 128);
    i = a.a[paramVideoProfile.getH264Profile().ordinal()];
    paramInt = 2;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          paramInt = 1;
          mediaFormat.setInteger("profile", paramInt);
          return mediaFormat;
        } 
        paramInt = 8;
      } 
      mediaFormat.setInteger("profile", paramInt);
      return mediaFormat;
    } 
    paramInt = 1;
    mediaFormat.setInteger("profile", paramInt);
    return mediaFormat;
  }
  
  public void a(PLAVFrame paramPLAVFrame, PLBufferInfo paramPLBufferInfo) {
    this.b.a(this.a, paramPLAVFrame, paramPLBufferInfo, false);
  }
  
  public Surface e() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\j\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */