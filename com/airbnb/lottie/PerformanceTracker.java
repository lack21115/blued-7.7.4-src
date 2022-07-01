package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PerformanceTracker {
  private boolean a = false;
  
  private final Set<FrameListener> b = (Set<FrameListener>)new ArraySet();
  
  private final Map<String, MeanCalculator> c = new HashMap<String, MeanCalculator>();
  
  private final Comparator<Pair<String, Float>> d = new Comparator<Pair<String, Float>>(this) {
      public int a(Pair<String, Float> param1Pair1, Pair<String, Float> param1Pair2) {
        float f1 = ((Float)param1Pair1.second).floatValue();
        float f2 = ((Float)param1Pair2.second).floatValue();
        return (f2 > f1) ? 1 : ((f1 > f2) ? -1 : 0);
      }
    };
  
  public void a(String paramString, float paramFloat) {
    if (!this.a)
      return; 
    MeanCalculator meanCalculator2 = this.c.get(paramString);
    MeanCalculator meanCalculator1 = meanCalculator2;
    if (meanCalculator2 == null) {
      meanCalculator1 = new MeanCalculator();
      this.c.put(paramString, meanCalculator1);
    } 
    meanCalculator1.a(paramFloat);
    if (paramString.equals("__container")) {
      Iterator<FrameListener> iterator = this.b.iterator();
      while (iterator.hasNext())
        ((FrameListener)iterator.next()).a(paramFloat); 
    } 
  }
  
  void a(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public static interface FrameListener {
    void a(float param1Float);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\PerformanceTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */