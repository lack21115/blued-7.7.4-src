package com.blued.android.module.live_china.view;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.List;

public class LiveMakeLoverRootGuestView extends FrameLayout implements View.OnClickListener {
  public ImageView A;
  
  public ImageView B;
  
  public ImageView C;
  
  public ImageView D;
  
  public ImageView E;
  
  public View F;
  
  public View G;
  
  public View H;
  
  public View I;
  
  public View J;
  
  public ShapeTextView K;
  
  public ShapeTextView L;
  
  public ShapeTextView M;
  
  public ShapeTextView N;
  
  public ShapeTextView O;
  
  public LiveEventListener P;
  
  GestureDetector Q = new GestureDetector(this.V, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          Log.i("ldp", "onDoubleTap");
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          Log.i("ldp", "onSingleTapConfirmed");
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector R = new GestureDetector(this.V, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector S = new GestureDetector(this.V, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector T = new GestureDetector(this.V, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector U = new GestureDetector(this.V, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  private Context V;
  
  private LayoutInflater W;
  
  public View a;
  
  private View aa;
  
  private View ab;
  
  private View ac;
  
  private View ad;
  
  private View ae;
  
  private Dialog af;
  
  private PlayingOnliveFragment ag;
  
  public View b;
  
  public View c;
  
  public View d;
  
  public View e;
  
  public View f;
  
  public View g;
  
  public View h;
  
  public View i;
  
  public View j;
  
  public View k;
  
  public View l;
  
  public View m;
  
  public View n;
  
  public View o;
  
  public View p;
  
  public View q;
  
  public View r;
  
  public View s;
  
  public View t;
  
  public View u;
  
  public ImageView v;
  
  public ImageView w;
  
  public ImageView x;
  
  public ImageView y;
  
  public ImageView z;
  
  public LiveMakeLoverRootGuestView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LiveMakeLoverRootGuestView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveMakeLoverRootGuestView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.V = paramContext;
  }
  
  public void a() {
    List<LiveMakeLoverFansModel> list = this.ag.bM.a();
    if (list != null)
      for (int i = 0; i < list.size(); i++) {
        LiveMakeLoverFansModel liveMakeLoverFansModel = list.get(i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("  setLoverLightStatus:");
        stringBuilder.append(liveMakeLoverFansModel.lamp);
        stringBuilder.append("  :");
        stringBuilder.append(liveMakeLoverFansModel.uid);
        Log.i("==makelover==", stringBuilder.toString());
        if (i == 1) {
          if (liveMakeLoverFansModel != null && !liveMakeLoverFansModel.isEmpty()) {
            int j;
            this.w.setVisibility(0);
            ImageView imageView = this.w;
            if (liveMakeLoverFansModel.lamp == 1) {
              j = R.drawable.live_make_lover_like_open;
            } else {
              j = R.drawable.live_make_lover_like_disopen;
            } 
            imageView.setImageResource(j);
          } else {
            this.w.setVisibility(8);
          } 
        } else if (i == 2) {
          if (liveMakeLoverFansModel != null && !liveMakeLoverFansModel.isEmpty()) {
            int j;
            this.x.setVisibility(0);
            ImageView imageView = this.x;
            if (liveMakeLoverFansModel.lamp == 1) {
              j = R.drawable.live_make_lover_like_open;
            } else {
              j = R.drawable.live_make_lover_like_disopen;
            } 
            imageView.setImageResource(j);
          } else {
            this.x.setVisibility(8);
          } 
        } else if (i == 3) {
          if (liveMakeLoverFansModel != null && !liveMakeLoverFansModel.isEmpty()) {
            int j;
            this.y.setVisibility(0);
            ImageView imageView = this.y;
            if (liveMakeLoverFansModel.lamp == 1) {
              j = R.drawable.live_make_lover_like_open;
            } else {
              j = R.drawable.live_make_lover_like_disopen;
            } 
            imageView.setImageResource(j);
          } else {
            this.y.setVisibility(8);
          } 
        } else if (i == 4) {
          if (liveMakeLoverFansModel != null && !liveMakeLoverFansModel.isEmpty()) {
            int j;
            this.z.setVisibility(0);
            ImageView imageView = this.z;
            if (liveMakeLoverFansModel.lamp == 1) {
              j = R.drawable.live_make_lover_like_open;
            } else {
              j = R.drawable.live_make_lover_like_disopen;
            } 
            imageView.setImageResource(j);
          } else {
            this.z.setVisibility(8);
          } 
        } 
      }  
  }
  
  public void a(int paramInt) {
    if (!LivePreferencesUtils.e()) {
      LivePreferencesUtils.c(true);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("position:");
      stringBuilder.append(paramInt);
      Log.i("==makelover==", stringBuilder.toString());
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt != 2) {
            if (paramInt != 3) {
              if (paramInt != 4) {
                this.K.setVisibility(8);
                this.L.setVisibility(8);
                this.M.setVisibility(8);
                this.N.setVisibility(8);
                this.O.setVisibility(8);
                return;
              } 
              this.K.setVisibility(8);
              this.L.setVisibility(8);
              this.M.setVisibility(8);
              this.N.setVisibility(8);
              this.O.setVisibility(0);
              return;
            } 
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            this.M.setVisibility(8);
            this.N.setVisibility(0);
            this.O.setVisibility(8);
            return;
          } 
          this.K.setVisibility(8);
          this.L.setVisibility(8);
          this.M.setVisibility(0);
          this.N.setVisibility(8);
          this.O.setVisibility(8);
          return;
        } 
        this.K.setVisibility(8);
        this.L.setVisibility(0);
        this.M.setVisibility(8);
        this.N.setVisibility(8);
        this.O.setVisibility(8);
        return;
      } 
      this.K.setVisibility(0);
      this.L.setVisibility(8);
      this.M.setVisibility(8);
      this.N.setVisibility(8);
      this.O.setVisibility(8);
    } 
  }
  
  public void a(PlayingOnliveFragment paramPlayingOnliveFragment) {
    this.ag = paramPlayingOnliveFragment;
    this.W = LayoutInflater.from(this.V);
    this.af = DialogUtils.a(this.V);
    View view = this.W.inflate(R.layout.live_make_lover_guest_view, (ViewGroup)this);
    this.a = view.findViewById(R.id.fl_make_lover_window_root);
    this.b = view.findViewById(R.id.live_make_lover_windows_B);
    this.c = view.findViewById(R.id.live_make_lover_windows_C);
    this.d = view.findViewById(R.id.live_make_lover_windows_D);
    this.e = view.findViewById(R.id.live_make_lover_windows_E);
    this.f = view.findViewById(R.id.live_make_lover_windows_F);
    this.g = view.findViewById(R.id.live_lover_free_B);
    this.h = view.findViewById(R.id.live_lover_free_C);
    this.i = view.findViewById(R.id.live_lover_free_D);
    this.j = view.findViewById(R.id.live_lover_free_E);
    this.k = view.findViewById(R.id.live_lover_free_F);
    this.l = view.findViewById(R.id.live_lover_mic_B);
    this.m = view.findViewById(R.id.live_lover_mic_C);
    this.n = view.findViewById(R.id.live_lover_mic_D);
    this.o = view.findViewById(R.id.live_lover_mic_E);
    this.p = view.findViewById(R.id.live_lover_mic_F);
    this.q = view.findViewById(R.id.fl_lover_heart_b);
    this.r = view.findViewById(R.id.fl_lover_heart_c);
    this.s = view.findViewById(R.id.fl_lover_heart_d);
    this.t = view.findViewById(R.id.fl_lover_heart_e);
    this.u = view.findViewById(R.id.fl_lover_heart_f);
    this.aa = view.findViewById(R.id.fl_lover_heart_gray_b);
    this.ab = view.findViewById(R.id.fl_lover_heart_gray_c);
    this.ac = view.findViewById(R.id.fl_lover_heart_gray_d);
    this.ad = view.findViewById(R.id.fl_lover_heart_gray_e);
    this.ae = view.findViewById(R.id.fl_lover_heart_gray_f);
    this.v = (ImageView)view.findViewById(R.id.iv_like_state_b);
    this.w = (ImageView)view.findViewById(R.id.iv_like_state_c);
    this.x = (ImageView)view.findViewById(R.id.iv_like_state_d);
    this.y = (ImageView)view.findViewById(R.id.iv_like_state_e);
    this.z = (ImageView)view.findViewById(R.id.iv_like_state_f);
    this.A = (ImageView)view.findViewById(R.id.live_lover_photo_B);
    this.B = (ImageView)view.findViewById(R.id.live_lover_photo_C);
    this.C = (ImageView)view.findViewById(R.id.live_lover_photo_D);
    this.D = (ImageView)view.findViewById(R.id.live_lover_photo_E);
    this.E = (ImageView)view.findViewById(R.id.live_lover_photo_F);
    this.F = view.findViewById(R.id.live_lover_close_B);
    this.G = view.findViewById(R.id.live_lover_close_C);
    this.H = view.findViewById(R.id.live_lover_close_D);
    this.I = view.findViewById(R.id.live_lover_close_E);
    this.J = view.findViewById(R.id.live_lover_close_F);
    this.K = (ShapeTextView)view.findViewById(R.id.live_lover_pic_B);
    this.L = (ShapeTextView)view.findViewById(R.id.live_lover_pic_C);
    this.M = (ShapeTextView)view.findViewById(R.id.live_lover_pic_D);
    this.N = (ShapeTextView)view.findViewById(R.id.live_lover_pic_E);
    this.O = (ShapeTextView)view.findViewById(R.id.live_lover_pic_F);
    this.F.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.b.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.Q.onTouchEvent(param1MotionEvent);
          }
        });
    this.c.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.R.onTouchEvent(param1MotionEvent);
          }
        });
    this.d.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.S.onTouchEvent(param1MotionEvent);
          }
        });
    this.e.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.T.onTouchEvent(param1MotionEvent);
          }
        });
    this.f.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.U.onTouchEvent(param1MotionEvent);
          }
        });
  }
  
  public void a(String paramString) {
    this.ag.bM.c(paramString);
    a();
  }
  
  public void a(String paramString1, String paramString2) {
    LiveRoomHttpUtils.b(paramString1, String.valueOf(this.ag.u), new BluedUIHttpResponse(this, (IRequestHost)this.ag.w_(), paramString1, paramString2) {
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(LiveMakeLoverRootGuestView.a(this.c));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(LiveMakeLoverRootGuestView.a(this.c));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.c.a(LiveRoomInfo.a().f(), this.a, this.b);
          }
        });
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {
    this.ag.bM.a(paramString1, paramString2, paramString3);
  }
  
  public void b() {
    if (this.ag.aG())
      LiveSetDataObserver.a().a(false, false); 
    AppMethods.d(R.string.live_make_lover_reset);
    this.ag.bM.b();
    a();
  }
  
  public void c() {
    this.K.setVisibility(8);
    this.L.setVisibility(8);
    this.M.setVisibility(8);
    this.N.setVisibility(8);
    this.O.setVisibility(8);
  }
  
  public void d() {
    if (!this.ag.bM.c()) {
      AppMethods.d(R.string.live_make_lover_wait);
      return;
    } 
    LiveRoomHttpUtils.b(String.valueOf(this.ag.u), new BluedUIHttpResponse(this, (IRequestHost)this.ag.w_()) {
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(LiveMakeLoverRootGuestView.a(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(LiveMakeLoverRootGuestView.a(this.a));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.a(LiveRoomInfo.a().f());
            LiveSetDataObserver.a().a(true, false);
            LiveSetDataObserver.a().c(this.a.getResources().getString(R.string.live_make_lover_light_gray));
          }
        });
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_lover_close_B) {
      Log.i("ldp", "live_lover_close_B");
      return;
    } 
    if (paramView.getId() == R.id.live_lover_close_C)
      return; 
    if (paramView.getId() == R.id.live_lover_close_D)
      return; 
    if (paramView.getId() == R.id.live_lover_close_E)
      return; 
    paramView.getId();
    int i = R.id.live_lover_close_F;
  }
  
  public void setLiveEventListener(LiveEventListener paramLiveEventListener) {
    this.P = paramLiveEventListener;
  }
  
  public static interface LiveEventListener {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMakeLoverRootGuestView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */