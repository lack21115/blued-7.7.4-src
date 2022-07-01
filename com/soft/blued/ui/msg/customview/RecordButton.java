package com.soft.blued.ui.msg.customview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.soft.blued.ui.msg.controller.tools.MediaRecordHelper;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.io.File;
import java.io.IOException;
import skin.support.widget.SkinCompatTextView;

public class RecordButton extends SkinCompatTextView {
  public int a = -1;
  
  private final String b = "RecordButton";
  
  private final int c = 1000;
  
  private Long d = Long.valueOf(0L);
  
  private boolean e = true;
  
  private Dialog f;
  
  private String g;
  
  private ImageView h;
  
  private ImageView i;
  
  private TextView j;
  
  private int k = 0;
  
  private MediaRecordHelper l;
  
  private TextView m;
  
  private OnRecordListener n;
  
  private long o;
  
  private Bitmap p;
  
  private PowerManager.WakeLock q;
  
  private MediaRecordHelper.OnRecordingListener r;
  
  public RecordButton(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public RecordButton(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a() {
    this.q.acquire();
  }
  
  private void a(int paramInt) {
    AppMethods.d(paramInt);
  }
  
  private void a(Context paramContext) {
    this.q = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(26, "RecordButton");
  }
  
  private void b() {
    if (this.q.isHeld())
      this.q.release(); 
  }
  
  private void c() {
    MediaRecordHelper mediaRecordHelper = this.l;
    if (mediaRecordHelper != null) {
      try {
        mediaRecordHelper.a();
      } catch (IllegalStateException illegalStateException) {
        illegalStateException.printStackTrace();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      if (this.r == null) {
        mediaRecordHelper = this.l;
        MediaRecordHelper.OnRecordingListener onRecordingListener = new MediaRecordHelper.OnRecordingListener(this) {
            public void a() {
              RecordButton.b(this.a, 2131758538);
            }
            
            public void a(int param1Int1, int param1Int2) {
              if (RecordButton.a(this.a) != null && RecordButton.a(this.a).a() != null) {
                if (!RecordButton.a(this.a).a().isAdded())
                  return; 
                RecordButton.a(this.a, param1Int1);
                if (RecordButton.b(this.a) != null) {
                  TextView textView = RecordButton.b(this.a);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(param1Int1);
                  stringBuilder.append("''");
                  textView.setText(stringBuilder.toString());
                } 
                if (param1Int2 <= 40) {
                  RecordButton.c(this.a).setImageBitmap(null);
                } else if (param1Int2 >= 120) {
                  RecordButton.c(this.a).setImageBitmap(RecordButton.d(this.a));
                } else {
                  param1Int2 = (120 - param1Int2) * RecordButton.d(this.a).getHeight() / 120;
                  RecordButton.c(this.a).setImageBitmap(Bitmap.createBitmap(RecordButton.d(this.a), 0, param1Int2, RecordButton.d(this.a).getWidth(), RecordButton.d(this.a).getHeight() - param1Int2));
                } 
                if (this.a.a != -1 && this.a.a - param1Int1 <= 10) {
                  RecordButton.b(this.a).setTextColor(-65536);
                } else {
                  RecordButton.b(this.a).setTextColor(-7829368);
                } 
                if (!RecordButton.e(this.a).c())
                  RecordButton.f(this.a); 
                if (this.a.a != -1 && param1Int1 >= this.a.a)
                  RecordButton.g(this.a); 
              } 
            }
            
            public void b() {
              RecordButton.b(this.a, 2131758544);
              RecordButton.h(this.a).dismiss();
              ThreadManager.a().a(new ThreadExecutor(this, "RecordStartRecord") {
                    public void execute() {
                      try {
                        Thread.sleep(500L);
                      } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                      } 
                      if (RecordButton.h(this.a.a).isShowing())
                        RecordButton.h(this.a.a).dismiss(); 
                    }
                  });
            }
          };
        this.r = onRecordingListener;
        mediaRecordHelper.a(onRecordingListener);
      } 
    } 
  }
  
  private void d() {
    MediaRecordHelper mediaRecordHelper = this.l;
    if (mediaRecordHelper != null) {
      boolean bool;
      if (this.k == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      mediaRecordHelper.a(bool);
    } 
  }
  
  private void e() {
    if (this.f == null) {
      this.d = Long.valueOf(System.currentTimeMillis());
      this.f = new Dialog(getContext(), 2131821476);
      this.f.setContentView(2131493020);
      this.h = (ImageView)this.f.findViewById(2131297860);
      this.i = (ImageView)this.f.findViewById(2131297861);
      this.j = (TextView)this.f.findViewById(2131301243);
      this.m = (TextView)this.f.findViewById(2131301254);
      this.p = BitmapFactory.decodeResource(getResources(), 2131233412);
      this.f.setOnDismissListener(new DialogInterface.OnDismissListener(this) {
            public void onDismiss(DialogInterface param1DialogInterface) {
              RecordButton.i(this.a);
              RecordButton.j(this.a);
            }
          });
    } else {
      this.d = Long.valueOf(System.currentTimeMillis());
      this.k = 0;
      TextView textView = this.j;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.k);
      stringBuilder.append("''");
      textView.setText(stringBuilder.toString());
      this.h.setImageResource(2131233411);
    } 
    c();
    this.f.show();
  }
  
  private void f() {
    // Byte code:
    //   0: aload_0
    //   1: getfield k : I
    //   4: iconst_m1
    //   5: if_icmpne -> 9
    //   8: return
    //   9: aload_0
    //   10: invokespecial d : ()V
    //   13: aload_0
    //   14: getfield f : Landroid/app/Dialog;
    //   17: invokevirtual dismiss : ()V
    //   20: invokestatic currentTimeMillis : ()J
    //   23: aload_0
    //   24: getfield d : Ljava/lang/Long;
    //   27: invokevirtual longValue : ()J
    //   30: lsub
    //   31: ldc2_w 1000
    //   34: lcmp
    //   35: ifge -> 49
    //   38: aload_0
    //   39: ldc 2131758543
    //   41: invokespecial a : (I)V
    //   44: aload_0
    //   45: invokespecial h : ()V
    //   48: return
    //   49: aload_0
    //   50: getfield e : Z
    //   53: ifeq -> 63
    //   56: aload_0
    //   57: invokespecial i : ()V
    //   60: goto -> 102
    //   63: aload_0
    //   64: getfield n : Lcom/soft/blued/ui/msg/customview/RecordButton$OnRecordListener;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnull -> 91
    //   72: aload_0
    //   73: getfield k : I
    //   76: istore_1
    //   77: iload_1
    //   78: ifeq -> 91
    //   81: aload_2
    //   82: iload_1
    //   83: invokeinterface a : (I)V
    //   88: goto -> 102
    //   91: aload_0
    //   92: getfield k : I
    //   95: ifne -> 102
    //   98: aload_0
    //   99: invokespecial h : ()V
    //   102: aload_0
    //   103: iconst_m1
    //   104: putfield k : I
    //   107: return
  }
  
  private void h() {
    if (StringUtils.e(this.g))
      return; 
    File file = new File(this.g);
    if (file.exists())
      file.delete(); 
  }
  
  private void i() {
    if (this.l == null)
      return; 
    this.f.dismiss();
    a(2131758540);
    File file = new File(this.g);
    if (file.exists())
      file.delete(); 
    this.k = -1;
  }
  
  public int getRecordTime() {
    return this.k;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    try {
      if (!AudioChannelManager.e().h()) {
        float f = paramMotionEvent.getY();
        if (f < 0.0F) {
          Logger.b("RecordButton", new Object[] { "onTouchEvent-->向上移动" });
          if (this.f != null && this.f.isShowing()) {
            this.m.setText(2131758539);
            this.h.setImageResource(2131233413);
            this.i.setVisibility(4);
          } 
          this.e = true;
        } else {
          Logger.b("RecordButton", new Object[] { "onTouchEvent-->向下移动." });
          if (this.f != null && this.f.isShowing()) {
            this.m.setText(2131758541);
            this.h.setImageResource(2131233411);
            if (this.i.getVisibility() == 4)
              this.i.setVisibility(0); 
          } 
          this.e = false;
        } 
        int i = paramMotionEvent.getAction();
        if (i != 0) {
          if (i == 1 || i == 3) {
            Logger.b("RecordButton", new Object[] { "onTouchEvent-->抬起" });
            b();
            this.o = System.currentTimeMillis();
            if (this.d.longValue() == -1L)
              return true; 
            f();
            if (this.n != null)
              this.n.b(paramMotionEvent); 
          } 
        } else {
          Logger.b("RecordButton", new Object[] { "onTouchEvent-->按下" });
          if (System.currentTimeMillis() - this.o < 500L) {
            a(2131758544);
            this.d = Long.valueOf(-1L);
            return true;
          } 
          a();
          if (this.n != null)
            this.n.a(paramMotionEvent); 
          e();
        } 
      } else {
        a(2131759450);
      } 
    } catch (Exception exception) {}
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnRecordListener(OnRecordListener paramOnRecordListener) {
    this.n = paramOnRecordListener;
  }
  
  public void setRecordPath(String paramString) {
    this.g = paramString;
    File file = new File(paramString);
    if (file.getParentFile() != null && !file.getParentFile().exists())
      file.getParentFile().mkdirs(); 
    MediaRecordHelper mediaRecordHelper = this.l;
    if (mediaRecordHelper == null) {
      this.l = new MediaRecordHelper(paramString);
      return;
    } 
    mediaRecordHelper.a(paramString);
  }
  
  public static interface OnRecordListener {
    BaseFragment a();
    
    void a(int param1Int);
    
    void a(MotionEvent param1MotionEvent);
    
    void b(MotionEvent param1MotionEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\customview\RecordButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */