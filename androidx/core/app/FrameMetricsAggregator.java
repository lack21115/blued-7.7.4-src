package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FrameMetricsAggregator {
  public static final int ANIMATION_DURATION = 256;
  
  public static final int ANIMATION_INDEX = 8;
  
  public static final int COMMAND_DURATION = 32;
  
  public static final int COMMAND_INDEX = 5;
  
  public static final int DELAY_DURATION = 128;
  
  public static final int DELAY_INDEX = 7;
  
  public static final int DRAW_DURATION = 8;
  
  public static final int DRAW_INDEX = 3;
  
  public static final int EVERY_DURATION = 511;
  
  public static final int INPUT_DURATION = 2;
  
  public static final int INPUT_INDEX = 1;
  
  public static final int LAYOUT_MEASURE_DURATION = 4;
  
  public static final int LAYOUT_MEASURE_INDEX = 2;
  
  public static final int SWAP_DURATION = 64;
  
  public static final int SWAP_INDEX = 6;
  
  public static final int SYNC_DURATION = 16;
  
  public static final int SYNC_INDEX = 4;
  
  public static final int TOTAL_DURATION = 1;
  
  public static final int TOTAL_INDEX = 0;
  
  private FrameMetricsBaseImpl a;
  
  public FrameMetricsAggregator() {
    this(1);
  }
  
  public FrameMetricsAggregator(int paramInt) {
    if (Build.VERSION.SDK_INT >= 24) {
      this.a = new FrameMetricsApi24Impl(paramInt);
      return;
    } 
    this.a = new FrameMetricsBaseImpl();
  }
  
  public void add(Activity paramActivity) {
    this.a.add(paramActivity);
  }
  
  public SparseIntArray[] getMetrics() {
    return this.a.getMetrics();
  }
  
  public SparseIntArray[] remove(Activity paramActivity) {
    return this.a.remove(paramActivity);
  }
  
  public SparseIntArray[] reset() {
    return this.a.reset();
  }
  
  public SparseIntArray[] stop() {
    return this.a.stop();
  }
  
  static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {
    private static HandlerThread e;
    
    private static Handler f;
    
    int a;
    
    SparseIntArray[] b = new SparseIntArray[9];
    
    Window.OnFrameMetricsAvailableListener c = new Window.OnFrameMetricsAvailableListener(this) {
        public void onFrameMetricsAvailable(Window param2Window, FrameMetrics param2FrameMetrics, int param2Int) {
          if ((this.a.a & 0x1) != 0) {
            FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
            frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[0], param2FrameMetrics.getMetric(8));
          } 
          if ((this.a.a & 0x2) != 0) {
            FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
            frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[1], param2FrameMetrics.getMetric(1));
          } 
          if ((this.a.a & 0x4) != 0) {
            FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
            frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[2], param2FrameMetrics.getMetric(3));
          } 
          if ((this.a.a & 0x8) != 0) {
            FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
            frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[3], param2FrameMetrics.getMetric(4));
          } 
          if ((this.a.a & 0x10) != 0) {
            FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
            frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[4], param2FrameMetrics.getMetric(5));
          } 
          if ((this.a.a & 0x40) != 0) {
            FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
            frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[6], param2FrameMetrics.getMetric(7));
          } 
          if ((this.a.a & 0x20) != 0) {
            FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
            frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[5], param2FrameMetrics.getMetric(6));
          } 
          if ((this.a.a & 0x80) != 0) {
            FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
            frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[7], param2FrameMetrics.getMetric(0));
          } 
          if ((this.a.a & 0x100) != 0) {
            FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
            frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[8], param2FrameMetrics.getMetric(2));
          } 
        }
      };
    
    private ArrayList<WeakReference<Activity>> d = new ArrayList<WeakReference<Activity>>();
    
    FrameMetricsApi24Impl(int param1Int) {
      this.a = param1Int;
    }
    
    void a(SparseIntArray param1SparseIntArray, long param1Long) {
      if (param1SparseIntArray != null) {
        int i = (int)((500000L + param1Long) / 1000000L);
        if (param1Long >= 0L)
          param1SparseIntArray.put(i, param1SparseIntArray.get(i) + 1); 
      } 
    }
    
    public void add(Activity param1Activity) {
      if (e == null) {
        e = new HandlerThread("FrameMetricsAggregator");
        e.start();
        f = new Handler(e.getLooper());
      } 
      for (int i = 0; i <= 8; i++) {
        SparseIntArray[] arrayOfSparseIntArray = this.b;
        if (arrayOfSparseIntArray[i] == null && (this.a & 1 << i) != 0)
          arrayOfSparseIntArray[i] = new SparseIntArray(); 
      } 
      param1Activity.getWindow().addOnFrameMetricsAvailableListener(this.c, f);
      this.d.add(new WeakReference<Activity>(param1Activity));
    }
    
    public SparseIntArray[] getMetrics() {
      return this.b;
    }
    
    public SparseIntArray[] remove(Activity param1Activity) {
      for (WeakReference<Activity> weakReference : this.d) {
        if (weakReference.get() == param1Activity) {
          this.d.remove(weakReference);
          break;
        } 
      } 
      param1Activity.getWindow().removeOnFrameMetricsAvailableListener(this.c);
      return this.b;
    }
    
    public SparseIntArray[] reset() {
      SparseIntArray[] arrayOfSparseIntArray = this.b;
      this.b = new SparseIntArray[9];
      return arrayOfSparseIntArray;
    }
    
    public SparseIntArray[] stop() {
      for (int i = this.d.size() - 1; i >= 0; i--) {
        WeakReference<Activity> weakReference = this.d.get(i);
        Activity activity = weakReference.get();
        if (weakReference.get() != null) {
          activity.getWindow().removeOnFrameMetricsAvailableListener(this.c);
          this.d.remove(i);
        } 
      } 
      return this.b;
    }
  }
  
  class null implements Window.OnFrameMetricsAvailableListener {
    null(FrameMetricsAggregator this$0) {}
    
    public void onFrameMetricsAvailable(Window param1Window, FrameMetrics param1FrameMetrics, int param1Int) {
      if ((this.a.a & 0x1) != 0) {
        FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
        frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[0], param1FrameMetrics.getMetric(8));
      } 
      if ((this.a.a & 0x2) != 0) {
        FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
        frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[1], param1FrameMetrics.getMetric(1));
      } 
      if ((this.a.a & 0x4) != 0) {
        FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
        frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[2], param1FrameMetrics.getMetric(3));
      } 
      if ((this.a.a & 0x8) != 0) {
        FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
        frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[3], param1FrameMetrics.getMetric(4));
      } 
      if ((this.a.a & 0x10) != 0) {
        FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
        frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[4], param1FrameMetrics.getMetric(5));
      } 
      if ((this.a.a & 0x40) != 0) {
        FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
        frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[6], param1FrameMetrics.getMetric(7));
      } 
      if ((this.a.a & 0x20) != 0) {
        FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
        frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[5], param1FrameMetrics.getMetric(6));
      } 
      if ((this.a.a & 0x80) != 0) {
        FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
        frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[7], param1FrameMetrics.getMetric(0));
      } 
      if ((this.a.a & 0x100) != 0) {
        FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = this.a;
        frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[8], param1FrameMetrics.getMetric(2));
      } 
    }
  }
  
  static class FrameMetricsBaseImpl {
    public void add(Activity param1Activity) {}
    
    public SparseIntArray[] getMetrics() {
      return null;
    }
    
    public SparseIntArray[] remove(Activity param1Activity) {
      return null;
    }
    
    public SparseIntArray[] reset() {
      return null;
    }
    
    public SparseIntArray[] stop() {
      return null;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MetricType {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\FrameMetricsAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */