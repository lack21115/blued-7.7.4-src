package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;

public class LiveMakeFriendManageView extends LinearLayout implements View.OnClickListener {
  public LinearLayout a;
  
  public int b;
  
  public boolean c = false;
  
  private Context d;
  
  private LayoutInflater e;
  
  private View f;
  
  private TextView g;
  
  private ImageView h;
  
  private TextView i;
  
  private LiveManageOnClickListener j;
  
  private PlayingOnliveFragment k;
  
  public LiveMakeFriendManageView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LiveMakeFriendManageView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveMakeFriendManageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    e();
  }
  
  private void e() {
    this.e = LayoutInflater.from(this.d);
    this.f = this.e.inflate(R.layout.live_make_friend_manage, (ViewGroup)this, true);
    this.a = (LinearLayout)this.f.findViewById(R.id.live_make_friend_wait_layout);
    this.g = (TextView)this.f.findViewById(R.id.live_make_friend_wait_num);
    this.i = (TextView)this.f.findViewById(R.id.live_make_friend_wait_text);
    this.h = (ImageView)this.f.findViewById(R.id.live_make_friend_manage_head);
    this.a.setOnClickListener(this);
  }
  
  public void a(int paramInt) {
    this.b = paramInt;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3)
            return; 
          this.h.setImageResource(R.drawable.live_make_friend_user_set_icon);
          this.g.setVisibility(8);
          this.i.setText(R.string.live_make_friend_setting);
          return;
        } 
        this.h.setImageResource(R.drawable.live_make_friend_user_wait_icon);
        this.g.setVisibility(8);
        this.i.setText(R.string.live_make_friend_waiting);
        this.k.aN.a(false);
        return;
      } 
      this.h.setImageResource(R.drawable.live_make_friend_user_icon);
      this.g.setVisibility(0);
      this.i.setText(R.string.live_make_friend_apply);
      this.k.aN.a(true);
      return;
    } 
    this.h.setImageResource(R.drawable.live_make_friend_manage_icon);
    this.g.setVisibility(0);
    this.i.setText(R.string.live_make_friend_manage);
  }
  
  public void a(boolean paramBoolean, LiveManageOnClickListener paramLiveManageOnClickListener) {
    a(paramBoolean, paramLiveManageOnClickListener, null);
  }
  
  public void a(boolean paramBoolean, LiveManageOnClickListener paramLiveManageOnClickListener, PlayingOnliveFragment paramPlayingOnliveFragment) {
    this.j = paramLiveManageOnClickListener;
    this.k = paramPlayingOnliveFragment;
    if (paramBoolean) {
      this.b = 0;
      this.h.setImageResource(R.drawable.live_make_friend_manage_icon);
      return;
    } 
    this.b = 1;
    this.h.setImageResource(R.drawable.live_make_friend_user_icon);
  }
  
  public boolean a() {
    return (this.b == 2);
  }
  
  public void b() {
    int j = DensityUtils.a(this.d, 55.0F);
    int i = j;
    if (this.k.bT.getVisibility() == 0)
      i = j + this.k.bT.getHeight(); 
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    layoutParams.bottomMargin = i;
    layoutParams.gravity = 85;
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void b(int paramInt) {
    TextView textView = this.g;
    String str = this.d.getString(R.string.live_make_friend_wait);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    textView.setText(String.format(str, new Object[] { stringBuilder.toString() }));
  }
  
  public void c() {
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    layoutParams.bottomMargin = DensityUtils.a(this.d, 55.0F);
    layoutParams.gravity = 85;
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void c(int paramInt) {
    this.c = true;
    setVisibility(0);
    this.a.clearAnimation();
    this.a.setVisibility(0);
    this.a.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_in));
    TextView textView = this.g;
    String str = this.d.getString(R.string.live_make_friend_wait);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    textView.setText(String.format(str, new Object[] { stringBuilder.toString() }));
    a(this.b);
  }
  
  public void d() {
    this.c = false;
    if (this.a.getVisibility() == 8)
      return; 
    setVisibility(8);
    this.a.setVisibility(8);
    Animation animation = AnimationUtils.loadAnimation(this.d, R.anim.push_center_out);
    this.a.startAnimation(animation);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_make_friend_wait_layout) {
      LiveManageOnClickListener liveManageOnClickListener = this.j;
      if (liveManageOnClickListener != null)
        liveManageOnClickListener.a(); 
    } 
  }
  
  public boolean performClick() {
    return this.a.performClick();
  }
  
  public static interface LiveManageOnClickListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMakeFriendManageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */