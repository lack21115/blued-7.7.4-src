package com.google.android.cameraview;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.OrientationEventListener;

abstract class DisplayOrientationDetector {
  static final SparseIntArray b = new SparseIntArray();
  
  private final OrientationEventListener a;
  
  Display c;
  
  private int d = 0;
  
  static {
    b.put(0, 0);
    b.put(1, 90);
    b.put(2, 180);
    b.put(3, 270);
  }
  
  public DisplayOrientationDetector(Context paramContext) {
    this.a = new OrientationEventListener(this, paramContext) {
        private int b = -1;
        
        public void onOrientationChanged(int param1Int) {
          if (param1Int != -1) {
            if (this.a.c == null)
              return; 
            param1Int = this.a.c.getRotation();
            if (this.b != param1Int) {
              this.b = param1Int;
              this.a.b(DisplayOrientationDetector.b.get(param1Int));
            } 
          } 
        }
      };
  }
  
  public void a() {
    this.a.disable();
    this.c = null;
  }
  
  public abstract void a(int paramInt);
  
  public void a(Display paramDisplay) {
    this.c = paramDisplay;
    this.a.enable();
    b(b.get(paramDisplay.getRotation()));
  }
  
  public int b() {
    return this.d;
  }
  
  void b(int paramInt) {
    this.d = paramInt;
    a(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\DisplayOrientationDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */