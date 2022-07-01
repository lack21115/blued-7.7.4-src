package a.a.a.a.a.g;

import a.a.a.a.a.e.e;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.qiniu.pili.droid.streaming.microphone.OnAudioMixListener;
import java.io.IOException;
import java.nio.ByteBuffer;

public class a {
  public MediaExtractor a;
  
  public MediaCodec b;
  
  public MediaFormat c;
  
  public ByteBuffer d;
  
  public int e;
  
  public long f;
  
  public long g;
  
  public boolean h = false;
  
  public boolean i = false;
  
  public OnAudioMixListener j;
  
  public int a() {
    MediaCodec mediaCodec = this.b;
    int i = 0;
    int j = 0;
    if (mediaCodec != null) {
      ByteBuffer[] arrayOfByteBuffer = mediaCodec.getOutputBuffers();
      for (i = 0; j < arrayOfByteBuffer.length; i = k) {
        int m = arrayOfByteBuffer[j].capacity();
        e e1 = e.j;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("output buffer ");
        stringBuilder1.append(j);
        stringBuilder1.append(" position:");
        stringBuilder1.append(arrayOfByteBuffer[j].position());
        stringBuilder1.append(" limit:");
        stringBuilder1.append(arrayOfByteBuffer[j].limit());
        stringBuilder1.append(" capacity:");
        stringBuilder1.append(m);
        e1.b("AudioDecoder", stringBuilder1.toString());
        int k = i;
        if (m > i)
          k = m; 
        j++;
      } 
    } 
    e e = e.j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("max output buffer size ");
    stringBuilder.append(i);
    e.c("AudioDecoder", stringBuilder.toString());
    return i;
  }
  
  public void a(long paramLong) {
    this.a.seekTo(paramLong, 0);
  }
  
  public void a(OnAudioMixListener paramOnAudioMixListener) {
    this.j = paramOnAudioMixListener;
  }
  
  public boolean a(String paramString, boolean paramBoolean) throws IOException {
    this.h = paramBoolean;
    MediaExtractor mediaExtractor = new MediaExtractor();
    this.a = mediaExtractor;
    mediaExtractor.setDataSource(paramString);
    MediaFormat mediaFormat = i();
    this.c = mediaFormat;
    if (mediaFormat == null) {
      e e = e.j;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cannot find audio track in ");
      stringBuilder.append(paramString);
      e.e("AudioDecoder", stringBuilder.toString());
      return false;
    } 
    MediaCodec mediaCodec = j();
    this.b = mediaCodec;
    if (mediaCodec == null) {
      e.j.e("AudioDecoder", "init decoder failed!!!");
      return false;
    } 
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    mediaMetadataRetriever.setDataSource(paramString);
    this.f = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000L;
    return true;
  }
  
  public long b() {
    return this.f;
  }
  
  public int c() {
    return (this.c == null) ? -1 : 16;
  }
  
  public int d() {
    MediaFormat mediaFormat = this.c;
    return (mediaFormat == null) ? -1 : mediaFormat.getInteger("sample-rate");
  }
  
  public int e() {
    MediaFormat mediaFormat = this.c;
    return (mediaFormat == null) ? -1 : mediaFormat.getInteger("channel-count");
  }
  
  public ByteBuffer f() {
    while (true) {
      int i = this.b.dequeueInputBuffer(1000L);
      if (i >= 0) {
        int k = this.a.readSampleData(this.b.getInputBuffers()[i], 0);
        int j = k;
        if (k < 0) {
          j = k;
          if (this.h) {
            this.a.seekTo(0L, 0);
            j = this.a.readSampleData(this.b.getInputBuffers()[i], 0);
          } 
        } 
        if (j < 0) {
          e.j.c("AudioDecoder", "EOF, no more encoded samples.");
          this.i = true;
          return null;
        } 
        this.i = false;
        long l = this.a.getSampleTime();
        if (this.j != null && Math.abs(l - this.g) > 1000000L) {
          this.j.onProgress(l, this.f);
          this.g = l;
        } 
        this.b.queueInputBuffer(i, 0, j, l, 0);
        this.a.advance();
        e e = e.j;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("input: index = ");
        stringBuilder.append(i);
        stringBuilder.append(", sample size = ");
        stringBuilder.append(j);
        e.b("AudioDecoder", stringBuilder.toString());
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        j = this.b.dequeueOutputBuffer(bufferInfo, 1000L);
        if (j != -3) {
          if (j != -2) {
            if (j != -1) {
              ByteBuffer byteBuffer = this.b.getOutputBuffers()[j];
              this.d = byteBuffer;
              byteBuffer.position(bufferInfo.offset);
              this.d.limit(bufferInfo.offset + bufferInfo.size);
              this.e = j;
              return this.d;
            } 
            e.j.c("AudioDecoder", "wait for available output buffer timed out!!!");
            continue;
          } 
          e.j.c("AudioDecoder", "new format");
          continue;
        } 
        e.j.c("AudioDecoder", "output buffers changed");
        continue;
      } 
      e.j.c("AudioDecoder", "wait for available input buffer timeout!!!");
    } 
  }
  
  public void g() {
    this.d.clear();
    if (!this.i)
      this.b.releaseOutputBuffer(this.e, false); 
  }
  
  public void h() {
    MediaCodec mediaCodec = this.b;
    if (mediaCodec != null) {
      mediaCodec.stop();
      this.b.release();
      this.b = null;
    } 
    this.c = null;
    MediaExtractor mediaExtractor = this.a;
    if (mediaExtractor != null) {
      mediaExtractor.release();
      this.a = null;
    } 
  }
  
  public final MediaFormat i() {
    int j = this.a.getTrackCount();
    e e = e.j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tracks count :");
    stringBuilder.append(j);
    e.c("AudioDecoder", stringBuilder.toString());
    for (int i = 0; i < j; i++) {
      MediaFormat mediaFormat = this.a.getTrackFormat(i);
      if (mediaFormat.getString("mime").startsWith("audio")) {
        e e1 = e.j;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("selected track:");
        stringBuilder1.append(i);
        e1.c("AudioDecoder", stringBuilder1.toString());
        this.a.selectTrack(i);
        return mediaFormat;
      } 
    } 
    return null;
  }
  
  public final MediaCodec j() {
    String str = this.c.getString("mime");
    int i = this.c.getInteger("sample-rate");
    int j = this.c.getInteger("channel-count");
    e e = e.j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mime:");
    stringBuilder.append(str);
    stringBuilder.append(" sampleRate:");
    stringBuilder.append(i);
    stringBuilder.append(" channels:");
    stringBuilder.append(j);
    e.c("AudioDecoder", stringBuilder.toString());
    try {
      MediaCodec mediaCodec = MediaCodec.createDecoderByType(str);
      mediaCodec.configure(this.c, null, null, 0);
      mediaCodec.start();
      return mediaCodec;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */