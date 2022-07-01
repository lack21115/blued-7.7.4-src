package a.a.a.a.a.h;

import android.media.AudioTrack;
import android.util.Log;

public class a {
  public boolean a = false;
  
  public AudioTrack b;
  
  public byte[] c = new byte[0];
  
  public void a() {
    AudioTrack audioTrack = this.b;
    if (audioTrack != null) {
      this.a = false;
      if (audioTrack.getPlayState() == 3)
        this.b.stop(); 
      this.b.release();
      synchronized (this.c) {
        this.b = null;
        return;
      } 
    } 
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    synchronized (this.c) {
      if (!this.a || this.b == null)
        return; 
      this.b.write(paramArrayOfbyte, paramInt1, paramInt2);
      return;
    } 
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3) {
    if (this.b != null)
      a(); 
    this.a = false;
    int i = AudioTrack.getMinBufferSize(paramInt1, paramInt2, paramInt3);
    if (i == -2) {
      Log.e("PcmPlayer", "Invalid parameter !");
      return false;
    } 
    AudioTrack audioTrack = new AudioTrack(3, paramInt1, paramInt2, paramInt3, i, 1);
    this.b = audioTrack;
    if (audioTrack.getState() == 0) {
      Log.e("PcmPlayer", "AudioTrack initialize fail !");
      return false;
    } 
    return true;
  }
  
  public void b() {
    synchronized (this.c) {
      if (this.b != null) {
        this.b.play();
        this.a = true;
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */