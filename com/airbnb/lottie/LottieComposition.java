package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LottieComposition {
  private final PerformanceTracker a = new PerformanceTracker();
  
  private final HashSet<String> b = new HashSet<String>();
  
  private Map<String, List<Layer>> c;
  
  private Map<String, LottieImageAsset> d;
  
  private Map<String, Font> e;
  
  private List<Marker> f;
  
  private SparseArrayCompat<FontCharacter> g;
  
  private LongSparseArray<Layer> h;
  
  private List<Layer> i;
  
  private Rect j;
  
  private float k;
  
  private float l;
  
  private float m;
  
  private boolean n;
  
  private int o = 0;
  
  public Layer a(long paramLong) {
    return (Layer)this.h.get(paramLong);
  }
  
  public void a(int paramInt) {
    this.o += paramInt;
  }
  
  public void a(Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, List<Layer> paramList, LongSparseArray<Layer> paramLongSparseArray, Map<String, List<Layer>> paramMap, Map<String, LottieImageAsset> paramMap1, SparseArrayCompat<FontCharacter> paramSparseArrayCompat, Map<String, Font> paramMap2, List<Marker> paramList1) {
    this.j = paramRect;
    this.k = paramFloat1;
    this.l = paramFloat2;
    this.m = paramFloat3;
    this.i = paramList;
    this.h = paramLongSparseArray;
    this.c = paramMap;
    this.d = paramMap1;
    this.g = paramSparseArrayCompat;
    this.e = paramMap2;
    this.f = paramList1;
  }
  
  public void a(String paramString) {
    Logger.b(paramString);
    this.b.add(paramString);
  }
  
  public void a(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public boolean a() {
    return this.n;
  }
  
  public int b() {
    return this.o;
  }
  
  public List<Layer> b(String paramString) {
    return this.c.get(paramString);
  }
  
  public void b(boolean paramBoolean) {
    this.a.a(paramBoolean);
  }
  
  public PerformanceTracker c() {
    return this.a;
  }
  
  public Marker c(String paramString) {
    this.f.size();
    for (int i = 0; i < this.f.size(); i++) {
      Marker marker = this.f.get(i);
      if (marker.a(paramString))
        return marker; 
    } 
    return null;
  }
  
  public Rect d() {
    return this.j;
  }
  
  public float e() {
    return (float)(long)(m() / this.m * 1000.0F);
  }
  
  public float f() {
    return this.k;
  }
  
  public float g() {
    return this.l;
  }
  
  public float h() {
    return this.m;
  }
  
  public List<Layer> i() {
    return this.i;
  }
  
  public SparseArrayCompat<FontCharacter> j() {
    return this.g;
  }
  
  public Map<String, Font> k() {
    return this.e;
  }
  
  public Map<String, LottieImageAsset> l() {
    return this.d;
  }
  
  public float m() {
    return this.l - this.k;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("LottieComposition:\n");
    Iterator<Layer> iterator = this.i.iterator();
    while (iterator.hasNext())
      stringBuilder.append(((Layer)iterator.next()).a("\t")); 
    return stringBuilder.toString();
  }
  
  @Deprecated
  public static class Factory {
    static final class ListenerAdapter implements Cancellable, LottieListener<LottieComposition> {
      private final OnCompositionLoadedListener a;
      
      private boolean b;
      
      public void a(LottieComposition param2LottieComposition) {
        if (this.b)
          return; 
        this.a.a(param2LottieComposition);
      }
    }
  }
  
  static final class ListenerAdapter implements Cancellable, LottieListener<LottieComposition> {
    private final OnCompositionLoadedListener a;
    
    private boolean b;
    
    public void a(LottieComposition param1LottieComposition) {
      if (this.b)
        return; 
      this.a.a(param1LottieComposition);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\LottieComposition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */