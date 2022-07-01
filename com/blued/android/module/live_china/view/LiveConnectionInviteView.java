package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveConnectionInviteView extends FrameLayout implements View.OnClickListener {
  private Context a;
  
  private LayoutInflater b;
  
  private View c;
  
  private LinearLayout d;
  
  private ImageView e;
  
  private TextView f;
  
  private RecordingOnliveFragment g;
  
  public LiveConnectionInviteView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LiveConnectionInviteView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveConnectionInviteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    c();
  }
  
  private void c() {
    this.b = LayoutInflater.from(this.a);
    this.c = this.b.inflate(R.layout.live_connection_invite_loading, (ViewGroup)this);
    this.d = (LinearLayout)this.c.findViewById(R.id.live_connection_invite_layout);
    this.e = (ImageView)this.c.findViewById(R.id.live_connection_invite_header);
    this.f = (TextView)this.c.findViewById(R.id.live_connection_retraction_btn);
    this.f.setOnClickListener(this);
  }
  
  public void a() {
    if (this.d.getVisibility() == 8)
      return; 
    setVisibility(8);
    this.d.setVisibility(8);
    Animation animation = AnimationUtils.loadAnimation(this.a, R.anim.push_center_out);
    this.d.startAnimation(animation);
    this.g.b_(0);
  }
  
  public void a(RecordingOnliveFragment paramRecordingOnliveFragment) {
    this.g = paramRecordingOnliveFragment;
  }
  
  public void a(String paramString) {
    setVisibility(0);
    this.d.clearAnimation();
    this.d.setVisibility(0);
    ImageLoader.a(null, paramString).a(R.drawable.user_bg_round).c().a(this.e);
    this.d.startAnimation(AnimationUtils.loadAnimation(this.a, R.anim.push_center_in));
    this.g.b_(3);
  }
  
  public void b() {
    LiveRoomHttpUtils.l(new BluedUIHttpResponse(this, (IRequestHost)this.g.w_()) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.a();
          }
        });
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_connection_retraction_btn) {
      Context context = this.a;
      CommonAlertDialog.a(context, "", context.getString(R.string.live_connection_cancel_this_invitation), this.a.getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              this.a.b();
            }
          },  this.a.getString(R.string.live_window_permisson_cancel), null, null);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveConnectionInviteView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */