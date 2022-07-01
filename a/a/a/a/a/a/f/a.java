package a.a.a.a.a.a.f;

import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class a {
  public List<PLAVFrame> a = new ArrayList<PLAVFrame>();
  
  public final Object b = new Object();
  
  public int c = 3;
  
  public a(int paramInt) {
    this.c = paramInt;
  }
  
  public PLAVFrame a(int paramInt) {
    synchronized (this.b) {
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("remove:reqSize:");
      stringBuilder.append(paramInt);
      e.a("PLAVFramePool", stringBuilder.toString());
      if (paramInt <= 0)
        return null; 
      if (this.a.isEmpty()) {
        PLAVFrame pLAVFrame1 = new PLAVFrame(ByteBuffer.allocateDirect(paramInt), 0, 0L);
        pLAVFrame1.usedCounter++;
        return pLAVFrame1;
      } 
    } 
    int i = 0;
    while (i < this.a.size()) {
      int j = ((PLAVFrame)this.a.get(i)).mBuffer.capacity();
      if (j < paramInt) {
        i++;
        continue;
      } 
      if (j == paramInt || (j * 0.8F <= paramInt && paramInt < j)) {
        PLAVFrame pLAVFrame1 = this.a.remove(i);
        pLAVFrame1.usedCounter++;
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_4} */
        return pLAVFrame1;
      } 
    } 
    PLAVFrame pLAVFrame = new PLAVFrame(ByteBuffer.allocateDirect(paramInt), 0, 0L);
    pLAVFrame.usedCounter++;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_4} */
    return pLAVFrame;
  }
  
  public void a() {
    synchronized (this.b) {
      this.a.clear();
      return;
    } 
  }
  
  public void a(PLAVFrame paramPLAVFrame) {
    synchronized (this.b) {
      if (this.a.isEmpty()) {
        paramPLAVFrame.mBuffer.clear();
        this.a.add(paramPLAVFrame);
        return;
      } 
      int j = paramPLAVFrame.mBuffer.capacity();
      if (((PLAVFrame)this.a.get(this.a.size() - 1)).mBuffer.capacity() < j) {
        paramPLAVFrame.mBuffer.clear();
        this.a.add(this.a.size(), paramPLAVFrame);
        b(this.a.size());
        return;
      } 
      int k = this.a.size();
      for (int i = 0;; i++) {
        if (i < k) {
          int m = ((PLAVFrame)this.a.get(i)).mBuffer.capacity();
          if (m > j) {
            paramPLAVFrame.mBuffer.clear();
            this.a.add(i, paramPLAVFrame);
            b(i);
            return;
          } 
          if (m == j)
            return; 
        } else {
          return;
        } 
      } 
    } 
  }
  
  public final void b(int paramInt) {
    if (this.a.size() > this.c) {
      List<PLAVFrame> list = this.a;
      int j = 0;
      long l = ((PLAVFrame)list.get(0)).usedCounter;
      int i = 1;
      while (i < this.a.size()) {
        int k = j;
        long l1 = l;
        if (i != paramInt) {
          k = j;
          l1 = l;
          if (((PLAVFrame)this.a.get(i)).usedCounter < l) {
            l1 = ((PLAVFrame)this.a.get(i)).usedCounter;
            k = i;
          } 
        } 
        i++;
        j = k;
        l = l1;
      } 
      PLAVFrame pLAVFrame = this.a.remove(j);
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("usedCounter:");
      stringBuilder.append(pLAVFrame.usedCounter);
      stringBuilder.append(",buffer:");
      stringBuilder.append(pLAVFrame.mBuffer);
      stringBuilder.append(",index:");
      stringBuilder.append(j);
      e.a("PLAVFramePool", stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */