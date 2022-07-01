package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ai;

public class e {
  private View a;
  
  private TextView b;
  
  private Context c;
  
  private d d;
  
  private b e;
  
  private boolean f = false;
  
  private r g;
  
  private ViewStub h;
  
  private View i;
  
  private void a(r paramr, boolean paramBoolean) {
    if (paramr != null) {
      View view = this.a;
      if (view != null) {
        String str;
        if (this.c == null)
          return; 
        if (view.getVisibility() == 0)
          return; 
        b b1 = this.e;
        if (b1 != null)
          b1.j(); 
        int i = (int)Math.ceil(paramr.c() * 1.0D / 1048576.0D);
        if (paramBoolean) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(ab.a(this.c, "tt_video_without_wifi_tips"));
          stringBuilder.append(i);
          stringBuilder.append(ab.a(this.c, "tt_video_bytesize_MB"));
          stringBuilder.append(ab.a(this.c, "tt_video_bytesize"));
          str = stringBuilder.toString();
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(ab.a(this.c, "tt_video_without_wifi_tips"));
          stringBuilder.append(ab.a(this.c, "tt_video_bytesize"));
          str = stringBuilder.toString();
        } 
        ai.a(this.a, 0);
        ai.a(this.b, str);
        if (ai.c(this.a)) {
          View view1 = this.a;
          if (view1 != null)
            view1.bringToFront(); 
        } 
      } 
    } 
  }
  
  private boolean a(int paramInt) {
    if (a())
      return true; 
    if (!this.f) {
      if (this.d != null) {
        b b1 = this.e;
        if (b1 != null) {
          if (b1.h())
            this.d.e(null, null); 
          this.d.a(a.a, null);
        } 
      } 
      a(this.g, true);
      return false;
    } 
    return true;
  }
  
  private void b() {
    this.g = null;
  }
  
  private void b(Context paramContext, View paramView) {
    if (paramContext != null && paramView != null) {
      ViewStub viewStub = this.h;
      if (viewStub != null && viewStub.getParent() != null) {
        if (this.a != null)
          return; 
        this.h.inflate();
        this.a = paramView.findViewById(ab.e(paramContext, "tt_video_traffic_tip_layout"));
        this.b = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_traffic_tip_tv"));
        paramView.findViewById(ab.e(paramContext, "tt_video_traffic_continue_play_btn")).setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                e.a(this.a);
                if (e.b(this.a) != null)
                  e.b(this.a).a(e.a.c, null); 
              }
            });
      } 
    } 
  }
  
  private void c() {
    if (this.c == null)
      return; 
    d();
  }
  
  private void d() {
    View view = this.a;
    if (view != null)
      view.setVisibility(8); 
  }
  
  public void a(Context paramContext, View paramView) {
    if (paramContext != null && paramView instanceof ViewGroup) {
      this.i = paramView;
      this.c = o.a().getApplicationContext();
      this.h = (ViewStub)LayoutInflater.from(paramContext).inflate(ab.f(paramContext, "tt_video_traffic_tip"), (ViewGroup)paramView, true).findViewById(ab.e(paramContext, "tt_video_traffic_tip_layout_viewStub"));
    } 
  }
  
  public void a(d paramd, b paramb) {
    this.e = paramb;
    this.d = paramd;
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean)
      b(); 
    d();
  }
  
  public boolean a() {
    View view = this.a;
    return (view != null && view.getVisibility() == 0);
  }
  
  public boolean a(int paramInt, r paramr) {
    Context context = this.c;
    if (context != null) {
      if (paramr == null)
        return true; 
      b(context, this.i);
      this.g = paramr;
      return (paramInt != 1 && paramInt != 2) ? true : a(paramInt);
    } 
    return true;
  }
  
  public enum a {
    a, b, c;
  }
  
  public static interface b {
    boolean h();
    
    void j();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */