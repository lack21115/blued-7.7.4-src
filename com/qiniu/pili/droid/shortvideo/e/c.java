package com.qiniu.pili.droid.shortvideo.e;

import com.qiniu.pili.droid.shortvideo.PLMixAudioFile;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.util.LinkedList;
import java.util.List;

public class c {
  private List<PLMixAudioFile> a = new LinkedList<PLMixAudioFile>();
  
  public PLMixAudioFile a() {
    return (this.a.size() <= 0) ? null : this.a.get(0);
  }
  
  public void a(int paramInt) {
    for (int i = 1; i < this.a.size(); i++) {
      PLMixAudioFile pLMixAudioFile = this.a.get(i);
      a a = pLMixAudioFile.a();
      if (pLMixAudioFile.a((paramInt * 1000))) {
        if (a != null)
          a.d(); 
        pLMixAudioFile.setNeedUpdatePosition(true);
      } 
    } 
  }
  
  public void a(long paramLong) {
    for (int i = 1; i < this.a.size(); i++) {
      PLMixAudioFile pLMixAudioFile = this.a.get(i);
      if (pLMixAudioFile.a(1000L * paramLong) && pLMixAudioFile.a() != null)
        pLMixAudioFile.a().b(); 
    } 
  }
  
  public void a(long paramLong, boolean paramBoolean) {
    paramLong *= 1000L;
    int i;
    for (i = 1; i < this.a.size(); i++) {
      PLMixAudioFile pLMixAudioFile = this.a.get(i);
      a a = pLMixAudioFile.a();
      if (a == null)
        return; 
      if (!pLMixAudioFile.a(paramLong)) {
        if (a.c())
          a.e(); 
      } else if (paramBoolean) {
        if (!a.c())
          a.b(); 
        if (pLMixAudioFile.f()) {
          a.a(pLMixAudioFile.b(paramLong));
          pLMixAudioFile.setNeedUpdatePosition(false);
        } 
      } 
    } 
  }
  
  public void a(PLMixAudioFile paramPLMixAudioFile) {
    this.a.add(paramPLMixAudioFile);
  }
  
  public int b() {
    return this.a.size();
  }
  
  public void b(long paramLong) {
    for (int i = 1; i < this.a.size(); i++) {
      PLMixAudioFile pLMixAudioFile = this.a.get(i);
      if (pLMixAudioFile.a(1000L * paramLong) && pLMixAudioFile.a() != null)
        pLMixAudioFile.a().f(); 
    } 
  }
  
  public void b(PLMixAudioFile paramPLMixAudioFile) {
    if (!this.a.contains(paramPLMixAudioFile)) {
      e.q.e("MultiMixAudioPlayer", "can not find the mix audio file!");
      return;
    } 
    this.a.remove(paramPLMixAudioFile);
    if (paramPLMixAudioFile.a() != null)
      paramPLMixAudioFile.a().d(); 
    paramPLMixAudioFile.c();
  }
  
  public List<PLMixAudioFile> c() {
    return this.a;
  }
  
  public void c(PLMixAudioFile paramPLMixAudioFile) {
    if (this.a.size() <= 0) {
      this.a.add(paramPLMixAudioFile);
      return;
    } 
    this.a.set(0, paramPLMixAudioFile);
  }
  
  public void d() {
    for (int i = 1; i < this.a.size(); i++) {
      if (((PLMixAudioFile)this.a.get(i)).a() != null)
        ((PLMixAudioFile)this.a.get(i)).a().e(); 
    } 
  }
  
  public void e() {
    for (int i = 1; i < this.a.size(); i++) {
      if (((PLMixAudioFile)this.a.get(i)).a() != null)
        ((PLMixAudioFile)this.a.get(i)).a().d(); 
    } 
  }
  
  public void f() {
    for (int i = 1; i < this.a.size(); i++) {
      PLMixAudioFile pLMixAudioFile = this.a.get(i);
      if (pLMixAudioFile.a() != null)
        pLMixAudioFile.a().a(pLMixAudioFile.getStartTime() / 1000L); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */