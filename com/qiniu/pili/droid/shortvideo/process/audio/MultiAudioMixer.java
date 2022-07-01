package com.qiniu.pili.droid.shortvideo.process.audio;

import com.qiniu.pili.droid.shortvideo.PLMixAudioFile;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class MultiAudioMixer implements Runnable {
  private static final boolean a = h.a().c();
  
  private ArrayList<PLMixAudioFile> b;
  
  private a c;
  
  private volatile boolean d = false;
  
  private volatile boolean e = false;
  
  private volatile boolean f = false;
  
  private volatile long g;
  
  private long mMixerId = 0L;
  
  private static void a(a parama) {
    e.q.c("MultiAudioMixer", "onAudioMixCompleted !");
    if (parama != null)
      parama.a(); 
  }
  
  private static void a(a parama, int paramInt) {
    e e = e.q;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onAudioMixFailed: ");
    stringBuilder.append(paramInt);
    e.e("MultiAudioMixer", stringBuilder.toString());
    if (parama != null)
      parama.a(paramInt); 
  }
  
  private static void a(a parama, byte[] paramArrayOfbyte, long paramLong) {
    e e = e.q;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onAudioMixed: ");
    stringBuilder.append(paramLong);
    e.a("MultiAudioMixer", stringBuilder.toString());
    if (parama != null)
      parama.a(paramArrayOfbyte, paramLong); 
  }
  
  private void a(ByteBuffer[] paramArrayOfByteBuffer, float[] paramArrayOffloat, long paramLong) {
    byte[] arrayOfByte = mix(paramArrayOfByteBuffer, paramArrayOffloat);
    if (arrayOfByte != null)
      a(this.c, arrayOfByte, paramLong); 
  }
  
  private void b(long paramLong) {
    ByteBuffer[] arrayOfByteBuffer;
    float[] arrayOfFloat;
    e.q.b("MultiAudioMixer", "doAudioMixing +");
    ArrayList<PLMixAudioFile> arrayList = c(paramLong);
    if (paramLong >= this.g * 1000L) {
      this.f = true;
      a(this.c);
      return;
    } 
    boolean bool = arrayList.isEmpty();
    int i = 0;
    if (bool) {
      arrayOfByteBuffer = new ByteBuffer[1];
      arrayOfFloat = new float[1];
      arrayOfByteBuffer[0] = ByteBuffer.allocateDirect(2048);
      arrayOfFloat[0] = 0.0F;
    } else {
      arrayOfByteBuffer = new ByteBuffer[arrayList.size()];
      arrayOfFloat = new float[arrayList.size()];
      while (i < arrayList.size()) {
        arrayOfByteBuffer[i] = ((PLMixAudioFile)arrayList.get(i)).e();
        arrayOfFloat[i] = ((PLMixAudioFile)arrayList.get(i)).getVolume();
        i++;
      } 
    } 
    a(arrayOfByteBuffer, arrayOfFloat, paramLong);
    e.q.b("MultiAudioMixer", "doAudioMixing -");
  }
  
  private boolean b() {
    return (this.g > 0L);
  }
  
  private ArrayList<PLMixAudioFile> c(long paramLong) {
    ArrayList<PLMixAudioFile> arrayList = new ArrayList();
    for (PLMixAudioFile pLMixAudioFile : this.b) {
      if (pLMixAudioFile.a(paramLong) && !pLMixAudioFile.b().c() && pLMixAudioFile.b().a(pLMixAudioFile.e()) > 0)
        arrayList.add(pLMixAudioFile); 
    } 
    return arrayList;
  }
  
  private void c() {
    e.q.c("MultiAudioMixer", "triggerAudioResample +");
    for (PLMixAudioFile pLMixAudioFile : this.b)
      pLMixAudioFile.b().a(pLMixAudioFile.getFilepath(), pLMixAudioFile.getStartTime(), pLMixAudioFile.getEndTime(), 44100, 1, 2048); 
    init(2048);
    e.q.c("MultiAudioMixer", "triggerAudioResample -");
  }
  
  private void d() {
    e.q.c("MultiAudioMixer", "releaseAudioResample +");
    for (PLMixAudioFile pLMixAudioFile : this.b) {
      if (this.e) {
        pLMixAudioFile.d();
        continue;
      } 
      pLMixAudioFile.c();
    } 
    release();
    e.q.c("MultiAudioMixer", "releaseAudioResample -");
  }
  
  private void e() {
    for (long l = 0L; !this.e && !this.f; l += 23219L)
      b(l); 
  }
  
  private void f() {
    while (!this.e && !this.f)
      g(); 
  }
  
  private void g() {
    e.q.b("MultiAudioMixer", "doAudioMixing +");
    ArrayList<PLMixAudioFile> arrayList = this.b;
    int i = 0;
    long l = ((PLMixAudioFile)arrayList.get(0)).b().d();
    arrayList = c(l);
    if (((PLMixAudioFile)this.b.get(0)).b().c() || arrayList.isEmpty() || !arrayList.contains(this.b.get(0))) {
      this.f = true;
      a(this.c);
      return;
    } 
    ByteBuffer[] arrayOfByteBuffer = new ByteBuffer[arrayList.size()];
    float[] arrayOfFloat = new float[arrayList.size()];
    while (i < arrayList.size()) {
      arrayOfByteBuffer[i] = ((PLMixAudioFile)arrayList.get(i)).e();
      arrayOfFloat[i] = ((PLMixAudioFile)arrayList.get(i)).getVolume();
      i++;
    } 
    a(arrayOfByteBuffer, arrayOfFloat, l);
    e.q.b("MultiAudioMixer", "doAudioMixing -");
  }
  
  private native boolean init(int paramInt);
  
  private native byte[] mix(ByteBuffer[] paramArrayOfByteBuffer, float[] paramArrayOffloat);
  
  private native boolean release();
  
  public void a() {
    e.q.c("MultiAudioMixer", "cancel +");
    this.e = true;
    e.q.c("MultiAudioMixer", "cancel -");
  }
  
  public void a(long paramLong) {
    this.g = paramLong;
  }
  
  public void a(List<PLMixAudioFile> paramList, a parama) {
    if (!a) {
      e.r.c("can't found pldroid_amix.so !");
      a(parama, 12);
      return;
    } 
    e.q.c("MultiAudioMixer", "mix +");
    if (this.d) {
      e.q.e("MultiAudioMixer", "mix already started");
      a(parama, 1);
      return;
    } 
    if (paramList == null || (paramList.size() < 2 && !b())) {
      e.q.e("MultiAudioMixer", "invalid params !");
      a(parama, 10);
      return;
    } 
    this.b = new ArrayList<PLMixAudioFile>(paramList);
    this.c = parama;
    this.e = false;
    this.f = false;
    (new Thread(this)).start();
    e.q.c("MultiAudioMixer", "mix -");
  }
  
  public void run() {
    e.q.c("MultiAudioMixer", "run +");
    this.d = true;
    c();
    if (b()) {
      e();
    } else {
      f();
    } 
    d();
    if (this.e)
      a(this.c); 
    this.d = false;
    this.e = false;
    e.q.c("MultiAudioMixer", "run -");
  }
  
  public static interface a {
    void a();
    
    void a(int param1Int);
    
    void a(byte[] param1ArrayOfbyte, long param1Long);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\process\audio\MultiAudioMixer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */