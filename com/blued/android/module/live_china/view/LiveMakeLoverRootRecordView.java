package com.blued.android.module.live_china.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.blued.android.module.live_china.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.fragment.LivePictureFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;

public class LiveMakeLoverRootRecordView extends FrameLayout implements View.OnClickListener {
  private static long ap;
  
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
  
  public View P;
  
  public View Q;
  
  public ImageView R;
  
  public FrameLayout S;
  
  public FrameLayout T;
  
  public FrameLayout U;
  
  public LiveEventListener V;
  
  GestureDetector W = new GestureDetector(this.ae, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverRootRecordView.a(this.a)).bb.a(0);
          if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty())
            return super.onSingleTapConfirmed(param1MotionEvent); 
          this.a.d(0);
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverRootRecordView.a(this.a)).bb.a(0);
          if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty())
            return super.onSingleTapConfirmed(param1MotionEvent); 
          if (!LiveMakeLoverRootRecordView.b(this.a))
            this.a.c(0); 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  public View a;
  
  GestureDetector aa = new GestureDetector(this.ae, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverRootRecordView.a(this.a)).bb.a(1);
          if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty())
            return super.onDoubleTap(param1MotionEvent); 
          this.a.d(1);
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverRootRecordView.a(this.a)).bb.a(1);
          if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty())
            return super.onSingleTapConfirmed(param1MotionEvent); 
          if (LiveMakeLoverRootRecordView.b(this.a)) {
            if (liveMakeLoverFansModel.lamp == 0) {
              AppMethods.d(R.string.live_make_lover_can_not_match);
              return super.onSingleTapConfirmed(param1MotionEvent);
            } 
            this.a.setHeartSelectd(1);
            this.a.b(1);
          } else {
            this.a.c(1);
          } 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector ab = new GestureDetector(this.ae, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverRootRecordView.a(this.a)).bb.a(2);
          if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty())
            return super.onDoubleTap(param1MotionEvent); 
          this.a.d(2);
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverRootRecordView.a(this.a)).bb.a(2);
          if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty())
            return super.onSingleTapConfirmed(param1MotionEvent); 
          if (LiveMakeLoverRootRecordView.b(this.a)) {
            if (liveMakeLoverFansModel.lamp == 0) {
              AppMethods.d(R.string.live_make_lover_can_not_match);
              return super.onSingleTapConfirmed(param1MotionEvent);
            } 
            this.a.setHeartSelectd(2);
            this.a.b(2);
          } else {
            this.a.c(2);
          } 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector ac = new GestureDetector(this.ae, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverRootRecordView.a(this.a)).bb.a(3);
          if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty())
            return super.onDoubleTap(param1MotionEvent); 
          this.a.d(3);
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverRootRecordView.a(this.a)).bb.a(3);
          if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty())
            return super.onSingleTapConfirmed(param1MotionEvent); 
          if (LiveMakeLoverRootRecordView.b(this.a)) {
            if (liveMakeLoverFansModel.lamp == 0) {
              AppMethods.d(R.string.live_make_lover_can_not_match);
              return super.onSingleTapConfirmed(param1MotionEvent);
            } 
            this.a.setHeartSelectd(3);
            this.a.b(3);
          } else {
            this.a.c(3);
          } 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector ad = new GestureDetector(this.ae, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverRootRecordView.a(this.a)).bb.a(4);
          if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty())
            return super.onDoubleTap(param1MotionEvent); 
          this.a.d(4);
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          LiveMakeLoverFansModel liveMakeLoverFansModel = (LiveMakeLoverRootRecordView.a(this.a)).bb.a(4);
          if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty())
            return super.onSingleTapConfirmed(param1MotionEvent); 
          if (LiveMakeLoverRootRecordView.b(this.a)) {
            if (liveMakeLoverFansModel.lamp == 0) {
              AppMethods.d(R.string.live_make_lover_can_not_match);
              return super.onSingleTapConfirmed(param1MotionEvent);
            } 
            this.a.setHeartSelectd(4);
            this.a.b(4);
          } else {
            this.a.c(4);
          } 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  private Context ae;
  
  private LayoutInflater af;
  
  private View ag;
  
  private View ah;
  
  private View ai;
  
  private View aj;
  
  private View ak;
  
  private boolean al;
  
  private int am;
  
  private Dialog an;
  
  private RecordingOnliveFragment ao;
  
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
  
  public LiveMakeLoverRootRecordView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LiveMakeLoverRootRecordView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveMakeLoverRootRecordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.ae = paramContext;
  }
  
  private void a(LiveMakeLoverFansModel paramLiveMakeLoverFansModel, String paramString) {
    LiveRoomHttpUtils.a(paramLiveMakeLoverFansModel.uid, paramString, new BluedUIHttpResponse(this, (IRequestHost)this.ao.w_(), paramLiveMakeLoverFansModel) {
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(LiveMakeLoverRootRecordView.c(this.b));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(LiveMakeLoverRootRecordView.c(this.b));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            (LiveMakeLoverRootRecordView.a(this.b)).bb.b(this.a.uid);
            (LiveMakeLoverRootRecordView.a(this.b)).bb.h();
          }
        });
  }
  
  private void f() {
    if (this.al) {
      this.R.setImageResource(R.drawable.live_make_lover_make_gray);
      this.q.setVisibility(0);
      setHeartSelectd(0);
      return;
    } 
    if (this.ao.bb.e()) {
      this.R.setImageResource(R.drawable.live_make_lover_make_ok);
    } else {
      this.R.setImageResource(R.drawable.live_make_lover_make_gray);
    } 
    this.q.setVisibility(8);
    this.r.setVisibility(8);
    this.s.setVisibility(8);
    this.t.setVisibility(8);
    this.u.setVisibility(8);
    this.ag.setVisibility(8);
    this.ah.setVisibility(8);
    this.ai.setVisibility(8);
    this.aj.setVisibility(8);
    this.ak.setVisibility(8);
  }
  
  private void f(int paramInt) {
    if (!LivePreferencesUtils.e()) {
      LivePreferencesUtils.c(true);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("position = ");
      stringBuilder.append(paramInt);
      Logger.d("LiveMakeLoverRootRecordView", new Object[] { stringBuilder.toString() });
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
  
  private void g() {
    this.K.setVisibility(8);
    this.L.setVisibility(8);
    this.M.setVisibility(8);
    this.N.setVisibility(8);
    this.O.setVisibility(8);
  }
  
  public void a() {
    if (this.ao.bb.e()) {
      this.R.setImageResource(R.drawable.live_make_lover_make_ok);
    } else {
      this.R.setImageResource(R.drawable.live_make_lover_make_gray);
    } 
    List<LiveMakeLoverFansModel> list = this.ao.bb.a();
    if (list != null)
      for (int i = 0; i < list.size(); i++) {
        LiveMakeLoverFansModel liveMakeLoverFansModel = list.get(i);
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
    if (paramInt == 0 && paramInt + 1 == this.am) {
      d();
      return;
    } 
    if (paramInt > 0 && paramInt + 1 == this.am)
      f(); 
  }
  
  public void a(RecordingOnliveFragment paramRecordingOnliveFragment) {
    this.ao = paramRecordingOnliveFragment;
    this.af = LayoutInflater.from(this.ae);
    this.an = DialogUtils.a(this.ae);
    View view = this.af.inflate(R.layout.live_make_lover_record_view, (ViewGroup)this);
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
    this.ag = view.findViewById(R.id.fl_lover_heart_gray_b);
    this.ah = view.findViewById(R.id.fl_lover_heart_gray_c);
    this.ai = view.findViewById(R.id.fl_lover_heart_gray_d);
    this.aj = view.findViewById(R.id.fl_lover_heart_gray_e);
    this.ak = view.findViewById(R.id.fl_lover_heart_gray_f);
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
    this.P = view.findViewById(R.id.fl_make_btn);
    this.Q = view.findViewById(R.id.iv_re_start);
    this.R = (ImageView)view.findViewById(R.id.iv_make_ok);
    this.S = (FrameLayout)view.findViewById(R.id.fl_music);
    this.T = (FrameLayout)view.findViewById(R.id.fl_liang_enter);
    this.U = (FrameLayout)view.findViewById(R.id.fl_activity_pop);
    this.Q.setOnClickListener(this);
    this.R.setOnClickListener(this);
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
            return this.a.W.onTouchEvent(param1MotionEvent);
          }
        });
    this.c.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.aa.onTouchEvent(param1MotionEvent);
          }
        });
    this.d.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.ab.onTouchEvent(param1MotionEvent);
          }
        });
    this.e.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.ac.onTouchEvent(param1MotionEvent);
          }
        });
    this.f.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.ad.onTouchEvent(param1MotionEvent);
          }
        });
  }
  
  public void a(String paramString) {
    this.ao.bb.c(paramString);
    a();
  }
  
  public void a(String paramString1, String paramString2) {
    this.ao.bb.a(paramString1, paramString2);
  }
  
  public void b() {
    if (this.ao.bb.e()) {
      this.R.setImageResource(R.drawable.live_make_lover_make_ok);
      return;
    } 
    this.R.setImageResource(R.drawable.live_make_lover_make_gray);
  }
  
  public void b(int paramInt) {
    LiveMakeLoverFansModel liveMakeLoverFansModel1 = this.ao.bb.a(0);
    liveMakeLoverFansModel1.index = 1;
    LiveMakeLoverFansModel liveMakeLoverFansModel2 = this.ao.bb.a(paramInt);
    liveMakeLoverFansModel2.index = paramInt + 1;
    this.ao.a(liveMakeLoverFansModel1, liveMakeLoverFansModel2, "", true);
  }
  
  public void c() {
    AppMethods.d(R.string.live_make_lover_reset);
    d();
    this.ao.bb.b();
    a();
  }
  
  public void c(int paramInt) {
    LiveMakeLoverFansModel liveMakeLoverFansModel = this.ao.bb.a(paramInt);
    if (liveMakeLoverFansModel != null) {
      f(paramInt);
      this.ao.cG.a(liveMakeLoverFansModel.uid);
    } 
  }
  
  public void d() {
    this.al = false;
    f();
  }
  
  public void d(int paramInt) {
    g();
    LiveMakeLoverFansModel liveMakeLoverFansModel = this.ao.bb.a(paramInt);
    if (liveMakeLoverFansModel == null)
      return; 
    String str2 = liveMakeLoverFansModel.pic;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = liveMakeLoverFansModel.avatar; 
    if (TextUtils.isEmpty(str1)) {
      Log.i("==makelover==", "photo is empty");
      return;
    } 
    LivePictureFragment livePictureFragment = new LivePictureFragment();
    livePictureFragment.a(new LiveBaseDialogFragment.IDialogEvent(this) {
          public void a() {
            LiveMakeLoverRootRecordView.a(this.a).C();
          }
          
          public void a(Object param1Object) {}
        });
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(str1);
    Bundle bundle = new Bundle();
    bundle.putStringArrayList("picture_url_list", arrayList);
    livePictureFragment.setArguments(bundle);
    livePictureFragment.show(this.ao.getFragmentManager(), "see_picture");
  }
  
  public void e() {
    LiveRoomHttpUtils.p(new BluedUIHttpResponse(this, (IRequestHost)this.ao.w_()) {
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(LiveMakeLoverRootRecordView.c(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(LiveMakeLoverRootRecordView.c(this.a));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.c();
          }
        });
  }
  
  public void e(int paramInt) {
    String str1;
    if (paramInt == 0) {
      str1 = "0";
    } else {
      str1 = "1";
    } 
    LiveMakeLoverFansModel liveMakeLoverFansModel = this.ao.bb.a(paramInt);
    if (liveMakeLoverFansModel == null)
      return; 
    String str2 = String.format(this.ae.getString(R.string.live_make_lover_kik_tip), new Object[] { liveMakeLoverFansModel.name });
    Context context = this.ae;
    CommonAlertDialog.a(context, "", str2, context.getString(R.string.live_make_lover_confirm), new DialogInterface.OnClickListener(this, liveMakeLoverFansModel, str1) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            LiveMakeLoverRootRecordView.a(this.c, this.a, this.b);
          }
        }null, null, null);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.iv_re_start) {
      EventTrackLive.a(LiveProtos.Event.ANCHOR_RENEW_BTN_CLICK, String.valueOf(this.ao.u));
      e();
      return;
    } 
    if (paramView.getId() == R.id.iv_make_ok) {
      EventTrackLive.a(LiveProtos.Event.ANCHOR_MATCH_SUCCESS_CLICK, String.valueOf(this.ao.u));
      if (!this.ao.bb.c()) {
        AppMethods.d(R.string.live_make_lover_wait);
        return;
      } 
      if (this.ao.bb.e()) {
        this.al ^= 0x1;
        f();
        return;
      } 
    } else {
      if (paramView.getId() == R.id.live_lover_close_B) {
        e(0);
        return;
      } 
      if (paramView.getId() == R.id.live_lover_close_C) {
        e(1);
        return;
      } 
      if (paramView.getId() == R.id.live_lover_close_D) {
        e(2);
        return;
      } 
      if (paramView.getId() == R.id.live_lover_close_E) {
        e(3);
        return;
      } 
      if (paramView.getId() == R.id.live_lover_close_F)
        e(4); 
    } 
  }
  
  public void setHeartSelectd(int paramInt) {
    this.am = paramInt;
    if (paramInt == 0) {
      this.r.setVisibility(8);
      if (this.h.getVisibility() == 8)
        this.ah.setVisibility(0); 
      this.s.setVisibility(8);
      if (this.i.getVisibility() == 8)
        this.ai.setVisibility(0); 
      this.t.setVisibility(8);
      if (this.j.getVisibility() == 8)
        this.aj.setVisibility(0); 
      this.u.setVisibility(8);
      if (this.k.getVisibility() == 8) {
        this.ak.setVisibility(0);
        return;
      } 
    } else if (paramInt == 1) {
      this.r.setVisibility(0);
      this.ah.setVisibility(8);
      this.s.setVisibility(8);
      if (this.i.getVisibility() == 8)
        this.ai.setVisibility(0); 
      this.t.setVisibility(8);
      if (this.j.getVisibility() == 8)
        this.aj.setVisibility(0); 
      this.u.setVisibility(8);
      if (this.k.getVisibility() == 8) {
        this.ak.setVisibility(0);
        return;
      } 
    } else if (paramInt == 2) {
      this.r.setVisibility(8);
      if (this.h.getVisibility() == 8)
        this.ah.setVisibility(0); 
      this.s.setVisibility(0);
      this.ai.setVisibility(8);
      this.t.setVisibility(8);
      if (this.j.getVisibility() == 8)
        this.aj.setVisibility(0); 
      this.u.setVisibility(8);
      if (this.k.getVisibility() == 8) {
        this.ak.setVisibility(0);
        return;
      } 
    } else if (paramInt == 3) {
      this.r.setVisibility(8);
      if (this.h.getVisibility() == 8)
        this.ah.setVisibility(0); 
      this.s.setVisibility(8);
      if (this.i.getVisibility() == 8)
        this.ai.setVisibility(0); 
      this.t.setVisibility(0);
      this.aj.setVisibility(8);
      this.u.setVisibility(8);
      if (this.k.getVisibility() == 8) {
        this.ak.setVisibility(0);
        return;
      } 
    } else if (paramInt == 4) {
      this.r.setVisibility(8);
      if (this.h.getVisibility() == 8)
        this.ah.setVisibility(0); 
      this.s.setVisibility(8);
      if (this.i.getVisibility() == 8)
        this.ai.setVisibility(0); 
      this.t.setVisibility(8);
      if (this.j.getVisibility() == 8)
        this.aj.setVisibility(0); 
      this.u.setVisibility(0);
      this.ak.setVisibility(8);
    } 
  }
  
  public void setLiveEventListener(LiveEventListener paramLiveEventListener) {
    this.V = paramLiveEventListener;
  }
  
  public static interface LiveEventListener {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMakeLoverRootRecordView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */