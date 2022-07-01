package a.a.a.a.a.b;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.ui.FocusIndicator;
import java.util.ArrayList;
import java.util.List;

public class g {
  public static final int a = h.a(120);
  
  public static final int b = h.a(120);
  
  public int c = 0;
  
  public boolean d;
  
  public boolean e;
  
  public boolean f;
  
  public Matrix g;
  
  public ViewGroup h;
  
  public View i;
  
  public int j;
  
  public int k;
  
  public boolean l;
  
  public int m;
  
  public List<Camera.Area> n;
  
  public List<Camera.Area> o;
  
  public String p;
  
  public String[] q;
  
  public String r;
  
  public Camera.Parameters s;
  
  public Handler t;
  
  public a u;
  
  public CameraStreamingSetting v;
  
  public g(CameraStreamingSetting paramCameraStreamingSetting, String[] paramArrayOfString, ViewGroup paramViewGroup, Camera.Parameters paramParameters, a parama, boolean paramBoolean, Looper paramLooper, View paramView) {
    this.t = new b(this, paramLooper);
    this.g = new Matrix();
    this.v = paramCameraStreamingSetting;
    this.q = paramArrayOfString;
    a(paramViewGroup, paramView);
    a(paramParameters);
    this.u = parama;
    a(paramBoolean);
  }
  
  public void a() {
    this.c = 0;
  }
  
  public void a(int paramInt) {
    this.m = paramInt;
    p();
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (this.j != paramInt1 || this.k != paramInt2) {
      this.j = paramInt1;
      this.k = paramInt2;
      p();
      paramInt1 = Math.min(this.j, this.k) / 4;
      View view = this.i;
      if (view != null) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = paramInt1;
        layoutParams.height = paramInt1;
      } 
    } 
  }
  
  public final void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Rect paramRect) {
    paramInt1 = (int)(paramInt1 * paramFloat);
    paramInt2 = (int)(paramInt2 * paramFloat);
    paramInt3 = h.a(paramInt3 - paramInt1 / 2, 0, paramInt5 - paramInt1);
    paramInt4 = h.a(paramInt4 - paramInt2 / 2, 0, paramInt6 - paramInt2);
    RectF rectF = new RectF(paramInt3, paramInt4, (paramInt3 + paramInt1), (paramInt4 + paramInt2));
    this.g.mapRect(rectF);
    h.a(rectF, paramRect);
  }
  
  public void a(Camera.Parameters paramParameters) {
    if (paramParameters != null) {
      boolean bool;
      this.s = paramParameters;
      if (paramParameters.getMaxNumFocusAreas() > 0 && h.a("auto", this.s.getSupportedFocusModes())) {
        bool = true;
      } else {
        bool = false;
      } 
      this.e = bool;
      if (!this.s.isAutoExposureLockSupported()) {
        this.s.isAutoWhiteBalanceLockSupported();
        return;
      } 
    } else {
      e.g.d("FocusManager", "Param is null while init FocusManager");
    } 
  }
  
  public void a(ViewGroup paramViewGroup, View paramView) {
    this.h = paramViewGroup;
    this.i = paramView;
  }
  
  public void a(boolean paramBoolean) {
    this.l = paramBoolean;
    p();
  }
  
  public void b() {
    this.c = 0;
    this.t.removeMessages(0);
    this.t.sendEmptyMessage(0);
    g();
  }
  
  public void b(int paramInt1, int paramInt2) {
    int i;
    int j;
    if (!this.d)
      return; 
    if (this.n != null) {
      i = this.c;
      if (i == 1 || i == 2 || i == 3)
        l(); 
    } 
    if (this.n == null) {
      ArrayList<Camera.Area> arrayList = new ArrayList();
      this.n = arrayList;
      arrayList.add(new Camera.Area(new Rect(), 1));
      arrayList = new ArrayList<Camera.Area>();
      this.o = arrayList;
      arrayList.add(new Camera.Area(new Rect(), 1));
    } 
    int k = this.j;
    int m = this.k;
    ViewGroup viewGroup = this.h;
    if (viewGroup != null) {
      i = viewGroup.getWidth();
      j = this.h.getHeight();
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.h.getLayoutParams();
      layoutParams.setMargins(h.a(paramInt1 - i / 2, 0, k - i), h.a(paramInt2 - j / 2, 0, m - j), 0, 0);
      layoutParams.gravity = 0;
      this.h.requestLayout();
    } else {
      i = a;
      j = b;
    } 
    a(i, j, 1.0F, paramInt1, paramInt2, k, m, ((Camera.Area)this.n.get(0)).rect);
    a(i, j, 1.5F, paramInt1, paramInt2, k, m, ((Camera.Area)this.o.get(0)).rect);
    this.u.t();
    if (this.e) {
      k();
      return;
    } 
    g();
    this.t.removeMessages(1);
    this.t.sendEmptyMessageDelayed(1, r());
  }
  
  public void b(boolean paramBoolean) {
    if (this.c == 1) {
      if (paramBoolean) {
        this.c = 2;
        if (!"continuous-picture".equals(this.p))
          this.u.d(1); 
      } else {
        this.c = 3;
      } 
      g();
      if (this.n != null)
        this.t.sendEmptyMessageDelayed(1, r()); 
    } 
  }
  
  public void c() {
    b();
  }
  
  public void c(boolean paramBoolean) {
    if (this.h != null) {
      this.t.removeMessages(3);
      Handler handler = this.t;
      handler.sendMessage(handler.obtainMessage(3, Boolean.valueOf(paramBoolean)));
    } 
  }
  
  public String d() {
    String str = this.r;
    if (str != null)
      return str; 
    Camera.Parameters parameters = this.s;
    if (parameters == null)
      return m(); 
    List list = parameters.getSupportedFocusModes();
    if (this.e && this.n != null) {
      this.p = "auto";
    } else {
      String str1 = m();
      this.p = str1;
      if (str1 == null)
        for (String str2 : this.q) {
          if (h.a(str2, list)) {
            this.p = str2;
            break;
          } 
        }  
    } 
    if (!h.a(this.p, list))
      if (h.a("auto", this.s.getSupportedFocusModes())) {
        this.p = "auto";
      } else {
        this.p = this.s.getFocusMode();
      }  
    e e = e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getFocusMode focusMode:");
    stringBuilder.append(this.p);
    e.c("FocusManager", stringBuilder.toString());
    return this.p;
  }
  
  public final void d(boolean paramBoolean) {
    if (this.c != 0)
      return; 
    ViewGroup viewGroup = this.h;
    if (viewGroup instanceof FocusIndicator) {
      FocusIndicator focusIndicator = (FocusIndicator)viewGroup;
      if (paramBoolean) {
        focusIndicator.showStart();
        return;
      } 
      focusIndicator.showSuccess(true);
      return;
    } 
    e.g.d("FocusManager", "Not the FocusIndicator type!");
  }
  
  public List<Camera.Area> e() {
    return this.n;
  }
  
  public List<Camera.Area> f() {
    return this.o;
  }
  
  public void g() {
    this.t.removeMessages(2);
    this.t.sendEmptyMessage(2);
  }
  
  public void h() {
    this.t.removeMessages(0);
    this.t.sendEmptyMessage(0);
  }
  
  public void i() {
    this.t.removeMessages(1);
  }
  
  public boolean j() {
    return this.f;
  }
  
  public final void k() {
    e.g.a("FocusManager", "Start autofocus.");
    this.u.r();
    this.c = 1;
    g();
    this.t.removeMessages(1);
  }
  
  public final void l() {
    e.g.a("FocusManager", "Cancel autofocus.");
    n();
    this.u.s();
    this.c = 0;
    o();
    this.t.removeMessages(1);
  }
  
  public final String m() {
    if (q() < 0)
      return null; 
    CameraStreamingSetting cameraStreamingSetting = this.v;
    return (cameraStreamingSetting != null) ? (!cameraStreamingSetting.isCAFEnabled() ? null : this.v.getFocusMode()) : "continuous-video";
  }
  
  public final void n() {
    if (!this.d)
      return; 
    ViewGroup viewGroup = this.h;
    if (viewGroup != null) {
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)viewGroup.getLayoutParams();
      layoutParams.setMargins(0, 0, 0, 0);
      layoutParams.gravity = 17;
      this.h.requestLayout();
      ViewGroup viewGroup1 = this.h;
      if (viewGroup1 instanceof FocusIndicator) {
        ((FocusIndicator)viewGroup1).clear();
      } else {
        e.g.d("FocusManager", "Not the FocusIndicator type!");
        return;
      } 
    } 
    this.n = null;
    this.o = null;
  }
  
  public final void o() {
    if (this.d) {
      ViewGroup viewGroup = this.h;
      if (viewGroup == null)
        return; 
      if (viewGroup instanceof FocusIndicator) {
        FocusIndicator focusIndicator = (FocusIndicator)viewGroup;
        e e = e.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mState:");
        stringBuilder.append(this.c);
        e.c("FocusManager", stringBuilder.toString());
        int i = this.c;
        if (i == 0) {
          if (this.n == null) {
            focusIndicator.clear();
            return;
          } 
          focusIndicator.showStart();
          return;
        } 
        if (i == 1) {
          focusIndicator.showStart();
          return;
        } 
        if ("continuous-picture".equals(this.p)) {
          focusIndicator.showSuccess(false);
          return;
        } 
        i = this.c;
        if (i == 2) {
          focusIndicator.showSuccess(false);
          return;
        } 
        if (i == 3)
          focusIndicator.showFail(false); 
        return;
      } 
      e.g.d("FocusManager", "Not the FocusIndicator type!");
    } 
  }
  
  public final void p() {
    if (this.j != 0 && this.k != 0) {
      Matrix matrix = new Matrix();
      h.a(matrix, this.l, this.m, this.j, this.k);
      matrix.invert(this.g);
      this.d = true;
    } 
  }
  
  public final int q() {
    CameraStreamingSetting cameraStreamingSetting = this.v;
    return (cameraStreamingSetting != null) ? cameraStreamingSetting.getResetTouchFocusDelay() : 3000;
  }
  
  public final int r() {
    int j = q();
    int i = j;
    if (j < 0)
      i = j * -1; 
    return i;
  }
  
  public static interface a {
    void d(int param1Int);
    
    void r();
    
    void s();
    
    void t();
  }
  
  public class b extends Handler {
    public b(g this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3)
              return; 
            g.a(this.a, ((Boolean)param1Message.obj).booleanValue());
            return;
          } 
          g.c(this.a);
          return;
        } 
        g.b(this.a);
        return;
      } 
      g.a(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */