package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class MoveViewJob extends ViewPortJob {
  private static ObjectPool<MoveViewJob> a = ObjectPool.a(2, new MoveViewJob(null, 0.0F, 0.0F, null, null));
  
  static {
    a.a(0.5F);
  }
  
  public MoveViewJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView) {
    super(paramViewPortHandler, paramFloat1, paramFloat2, paramTransformer, paramView);
  }
  
  public static void a(MoveViewJob paramMoveViewJob) {
    a.a(paramMoveViewJob);
  }
  
  public ObjectPool.Poolable b() {
    return new MoveViewJob(this.m, this.n, this.o, this.p, this.q);
  }
  
  public void run() {
    this.l[0] = this.n;
    this.l[1] = this.o;
    this.p.a(this.l);
    this.m.a(this.l, this.q);
    a(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\jobs\MoveViewJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */