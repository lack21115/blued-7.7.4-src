package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;

public class YYLateAcceptView extends LinearLayout implements View.OnClickListener {
  private TextView a;
  
  private TextView b;
  
  private TextView c;
  
  private CountDownTimer d;
  
  private BaseYYStudioFragment e;
  
  private PopupWindow f;
  
  public YYLateAcceptView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYLateAcceptView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYLateAcceptView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.dialog_late_accept_layout, (ViewGroup)this, true);
    this.a = (TextView)findViewById(R.id.tv_apply_content);
    this.b = (TextView)findViewById(R.id.tv_apply_reject);
    this.c = (TextView)findViewById(R.id.tv_apply_now);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  private void a(int paramInt) {
    c();
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.a(paramInt, yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.e.w_()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            YYLateAcceptView.a(this.a, (BaseYYStudioFragment)null);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (YYLateAcceptView.b(this.a) != null)
              YYLateAcceptView.b(this.a).dismiss(); 
          }
        }(IRequestHost)this.e.w_());
  }
  
  private void b() {
    c();
    this.d = (new CountDownTimer(this, 5000L, 1000L) {
        public void onFinish() {
          YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
          if (yYRoomModel != null)
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_POP_AUTO_SUCCESS, yYRoomModel.room_id, yYRoomModel.uid); 
          YYLateAcceptView.a(this.a, 1);
        }
        
        public void onTick(long param1Long) {
          param1Long /= 1000L;
          YYLateAcceptView.a(this.a).setText(String.format(this.a.getContext().getResources().getString(R.string.yy_late_apply_des), new Object[] { Long.valueOf(param1Long + 1L) }));
        }
      }).start();
  }
  
  private void c() {
    CountDownTimer countDownTimer = this.d;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.e = paramBaseYYStudioFragment;
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_POP_SHOW, yYRoomModel.room_id, yYRoomModel.uid); 
    this.f = new PopupWindow((View)this, (int)(AppInfo.l * 0.8D), -2);
    this.f.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    this.f.setTouchable(true);
    this.f.setOutsideTouchable(true);
    this.f.setFocusable(true);
    this.f.update();
    this.f.showAtLocation(paramBaseYYStudioFragment.getActivity().getWindow().getDecorView(), 17, 0, 0);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    b();
  }
  
  public void onClick(View paramView) {
    YYRoomModel yYRoomModel;
    if (paramView.getId() == R.id.tv_apply_reject) {
      yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null)
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_POP_REFUSE_CLICK, yYRoomModel.room_id, yYRoomModel.uid); 
      a(0);
      return;
    } 
    if (yYRoomModel.getId() == R.id.tv_apply_now) {
      yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null)
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_POP_ACCEPT_CLICK, yYRoomModel.room_id, yYRoomModel.uid); 
      a(1);
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    c();
    PopupWindow popupWindow = this.f;
    if (popupWindow != null)
      popupWindow.dismiss(); 
    this.e = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYLateAcceptView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */