package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class ViewPortJob extends ObjectPool.Poolable implements Runnable {
  protected float[] l = new float[2];
  
  protected ViewPortHandler m;
  
  protected float n = 0.0F;
  
  protected float o = 0.0F;
  
  protected Transformer p;
  
  protected View q;
  
  public ViewPortJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView) {
    this.m = paramViewPortHandler;
    this.n = paramFloat1;
    this.o = paramFloat2;
    this.p = paramTransformer;
    this.q = paramView;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\jobs\ViewPortJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */