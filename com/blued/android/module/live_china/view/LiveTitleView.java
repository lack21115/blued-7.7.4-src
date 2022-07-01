package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRoomTitleModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

public class LiveTitleView extends FrameLayout implements View.OnClickListener {
  public View a;
  
  private Context b;
  
  private LayoutInflater c;
  
  private View d;
  
  private View e;
  
  private EditText f;
  
  private TextView g;
  
  private RecordingOnliveFragment h;
  
  private View i;
  
  private boolean j;
  
  private TextWatcher k = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = LiveTitleView.c(this.a).getSelectionStart();
        this.c = LiveTitleView.c(this.a).getSelectionEnd();
        LiveTitleView.c(this.a).removeTextChangedListener(LiveTitleView.d(this.a));
        String str = LiveTitleView.c(this.a).getText().toString().trim();
        if (param1Editable.length() > 0) {
          LiveTitleView.e(this.a).setVisibility(0);
        } else {
          LiveTitleView.e(this.a).setVisibility(8);
        } 
        int i = 0;
        int j;
        for (j = 20; i < str.length(); j = k) {
          int k = str.charAt(i);
          if (k >= 32 && k <= 122) {
            k = j;
          } else {
            k = j;
            if (j > 10)
              k = j - 1; 
          } 
          i++;
        } 
        Logger.a("drb", new Object[] { "mTextMaxLength - ", Integer.valueOf(j) });
        while (param1Editable.length() > j) {
          param1Editable.delete(this.b - 1, this.c);
          this.b--;
          this.c--;
        } 
        LiveTitleView.c(this.a).setSelection(this.b);
        LiveTitleView.c(this.a).addTextChangedListener(LiveTitleView.d(this.a));
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  public LiveTitleView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LiveTitleView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveTitleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
  }
  
  public void a() {
    d();
  }
  
  public void a(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      this.j = false;
      return;
    } 
    this.j = true;
  }
  
  public void a(boolean paramBoolean, RecordingOnliveFragment paramRecordingOnliveFragment) {
    int i;
    this.h = paramRecordingOnliveFragment;
    this.c = LayoutInflater.from(this.b);
    LayoutInflater layoutInflater = this.c;
    if (paramBoolean) {
      i = R.layout.live_title_view_land;
    } else {
      i = R.layout.live_title_view;
    } 
    View view = layoutInflater.inflate(i, (ViewGroup)this);
    this.d = view.findViewById(R.id.ll_content);
    this.e = view.findViewById(R.id.live_title_layer);
    this.a = view.findViewById(R.id.ll_loading);
    this.f = (EditText)view.findViewById(R.id.live_title_edit);
    this.g = (TextView)view.findViewById(R.id.live_title_save);
    this.i = view.findViewById(R.id.live_title_edit_del);
    this.f.addTextChangedListener(this.k);
    this.e.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  public boolean b() {
    return (getVisibility() == 0);
  }
  
  public void c() {
    setVisibility(0);
    this.d.setVisibility(0);
    this.d.clearAnimation();
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
    this.d.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public void d() {
    if (this.d.getVisibility() == 8)
      return; 
    this.d.setVisibility(8);
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out);
    this.d.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.setVisibility(8);
            if (LiveTitleView.a(this.a))
              KeyboardUtils.a((Activity)LiveTitleView.b(this.a).getActivity()); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public void e() {
    if (this.f.getText().length() == 0)
      return; 
    LiveRoomHttpUtils.l(new BluedUIHttpResponse<BluedEntity<LiveRoomTitleModel, LiveRoomTitleModel>>(this, (IRequestHost)this.h.w_()) {
          public void onUIFinish() {
            super.onUIFinish();
            this.a.a.setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.a.setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity<LiveRoomTitleModel, LiveRoomTitleModel> param1BluedEntity) {
            LiveRoomTitleModel liveRoomTitleModel = (LiveRoomTitleModel)param1BluedEntity.extra;
            if (liveRoomTitleModel != null && !TextUtils.isEmpty(liveRoomTitleModel.title)) {
              LiveTitleView.c(this.a).setText(liveRoomTitleModel.title);
              this.a.d();
              AppMethods.d(R.string.live_title_save_success);
            } 
          }
        }this.f.getText().toString());
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_title_layer) {
      d();
      return;
    } 
    if (paramView.getId() == R.id.live_title_edit_del) {
      this.f.setText("");
      return;
    } 
    if (paramView.getId() == R.id.live_title_save) {
      EventTrackLive.a(LiveProtos.Event.LIVE_SETTING_TITLE_SAVE_BTN_CLICK);
      e();
      KeyboardUtils.b(getContext(), (View)this.f);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveTitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */