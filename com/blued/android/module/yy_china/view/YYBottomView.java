package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.live.base.view.LiveCircleProgressView;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMuteStatusModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.observer.RoleStatusObserver;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import java.io.File;

public class YYBottomView extends LinearLayout implements View.OnClickListener, RoleStatusObserver {
  private BaseYYStudioFragment a;
  
  private ShapeTextView b;
  
  private ImageView c;
  
  private ImageView d;
  
  private ImageView e;
  
  private ImageView f;
  
  private ImageView g;
  
  private LiveCircleProgressView h;
  
  private FrameLayout i;
  
  public YYBottomView(Context paramContext) {
    super(paramContext);
    c();
  }
  
  public YYBottomView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public YYBottomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void b(int paramInt) {
    YYRoomHttpUtils.b((YYRoomInfoManager.d().b()).room_id, YYRoomInfoManager.d().e(), paramInt, new BluedUIHttpResponse<BluedEntityA<YYMuteStatusModel>>(this, (IRequestHost)this.a.w_()) {
          protected void a(BluedEntityA<YYMuteStatusModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (param1BluedEntityA.getSingleData() == null)
                return; 
              this.a.a(((YYMuteStatusModel)param1BluedEntityA.getSingleData()).mic_status);
            } 
          }
        }(IRequestHost)this.a.w_());
  }
  
  private void c() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_bottom_menu_layout, (ViewGroup)this, true);
    this.b = (ShapeTextView)findViewById(R.id.tv_chat);
    this.d = (ImageView)findViewById(R.id.iv_share);
    this.e = (ImageView)findViewById(R.id.iv_gift);
    this.c = (ImageView)findViewById(R.id.tv_up_seat);
    this.f = (ImageView)findViewById(R.id.iv_audio);
    this.g = (ImageView)findViewById(R.id.iv_anim);
    this.i = (FrameLayout)findViewById(R.id.fl_progress_content);
    a();
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
  }
  
  private void d() {
    this.h = YYRoomInfoManager.d().i();
    LiveCircleProgressView liveCircleProgressView = this.h;
    if (liveCircleProgressView == null) {
      this.h = (LiveCircleProgressView)LayoutInflater.from(getContext()).inflate(R.layout.view_circle_progress, null);
      this.h.setValue(0.0F);
      this.h.setBarColor(new int[] { getContext().getResources().getColor(R.color.syc_dark_b) });
      this.h.setRimWidth(DensityUtils.a(getContext(), 1.0F));
      this.h.setRimColor(getContext().getResources().getColor(R.color.transparent));
      this.h.setBarWidth(DensityUtils.a(getContext(), 1.0F));
      this.h.setText("");
      YYRoomInfoManager.d().a(this.h);
      return;
    } 
    ViewGroup viewGroup = (ViewGroup)liveCircleProgressView.getParent();
    if (viewGroup != null)
      viewGroup.removeView((View)this.h); 
  }
  
  private void e() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    if (!yYRoomModel.enableRequestMic()) {
      ToastUtils.a("相亲交友活动已开始，不可以上麦喽！", 0);
      return;
    } 
    YYRoomHttpUtils.c(yYRoomModel.room_id, 0, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.a.w_()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            YYImModel yYImModel = new YYImModel();
            yYImModel.type = -2;
            yYImModel.contents = this.a.getResources().getString(R.string.yy_msg_apply_mic);
            YYImMsgManager.a().f(yYImModel);
          }
        }(IRequestHost)this.a.w_());
  }
  
  public void a() {
    this.i.removeAllViews();
    d();
    this.i.addView((View)this.h);
  }
  
  public void a(int paramInt) {
    if (paramInt == 0) {
      AudioChannelManager.e().a(true);
      this.f.setImageResource(R.drawable.icon_microphone_disable);
    } else {
      AudioChannelManager.e().a(false);
      this.f.setImageResource(R.drawable.icon_microphone);
    } 
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo != null)
      yYUserInfo.is_open_mic = paramInt; 
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment, boolean paramBoolean) {
    this.a = paramBaseYYStudioFragment;
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo == null)
      return; 
    a(yYUserInfo.is_open_mic);
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null && yYRoomModel.countdown == 1 && !paramBoolean)
      b(); 
  }
  
  public void a(String paramString) {
    this.a.a(new Runnable(this, paramString) {
          public void run() {
            if (TextUtils.equals("2", this.a) || TextUtils.equals("0", this.a)) {
              AudioChannelManager.e().d();
              AudioChannelManager.e().a(21);
              this.b.a(true);
              return;
            } 
            if (TextUtils.equals("1", this.a)) {
              if (YYRoomInfoManager.d().b() != null)
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_SUCCESS_SHOW, (YYRoomInfoManager.d().b()).room_id, (YYRoomInfoManager.d().b()).uid); 
              YYBottomView.a(this.b).c((YYRoomInfoManager.d()).a.push_url);
              AudioChannelManager.e().a(20);
              ToastUtils.a("你已上麦，麦克风已开启，可以开始聊天了", 0);
              this.b.a(false);
              return;
            } 
            this.b.a(true);
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    ImageView imageView = this.c;
    boolean bool = false;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
    imageView = this.f;
    if (paramBoolean) {
      b = 8;
    } else {
      b = 0;
    } 
    imageView.setVisibility(b);
    imageView = this.g;
    byte b = bool;
    if (paramBoolean)
      b = 8; 
    imageView.setVisibility(b);
  }
  
  public void b() {
    if (this.h == null)
      return; 
    YYRoomInfoManager.d().j();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    YYObserverManager.a().a(this);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (ClickUtils.a(i))
      return; 
    if (this.a == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    if (i == R.id.tv_chat) {
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_SEND_MSG_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
      this.a.a("", "");
      return;
    } 
    if (i == R.id.iv_gift) {
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_GIFT_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
      this.a.a(true, "gift_icon", "");
      return;
    } 
    if (i == R.id.iv_share) {
      if (this.a.G())
        this.a.H(); 
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_SHARE_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
      YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
      if (yYUserInfo == null)
        return; 
      ImageFileLoader.a((IRequestHost)this.a.w_()).b(yYUserInfo.getAvatar()).a(new ImageFileLoader.OnLoadFileListener(this, yYUserInfo, yYRoomModel) {
            public void onUIFinish(File param1File, Exception param1Exception) {
              if (param1File != null && param1File.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(param1File.getPath());
              } else {
                param1File = null;
              } 
              IYYRoomInfoCallback iYYRoomInfoCallback = YYRoomInfoManager.d().c();
              Context context = this.c.getContext();
              YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.a.chat_anchor);
              stringBuilder.append("邀请您进入");
              stringBuilder.append(this.b.name);
              iYYRoomInfoCallback.a(context, yYRoomModel, (Bitmap)param1File, stringBuilder.toString());
            }
          }).a();
      return;
    } 
    if (i == R.id.tv_up_seat) {
      if (YYRoomInfoManager.d().c().a(getContext(), null))
        return; 
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
      PermissionHelper.a(new PermissionCallbacks(this, yYRoomModel) {
            public void a(String[] param1ArrayOfString) {
              AppMethods.a("麦克风已被禁用，请在设置中授权麦克风使用");
            }
            
            public void aa_() {
              LiveAlterDialog.a(this.b.getContext(), R.layout.dialog_apply_mic_layout, null, new View.OnClickListener(this) {
                    public void onClick(View param2View) {
                      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MIKE_CONFIRM_CLICK, this.a.a.room_id, this.a.a.uid);
                      YYBottomView.b(this.a.b);
                    }
                  }true, false);
            }
          });
      return;
    } 
    if (i == R.id.iv_audio) {
      if ((YYRoomInfoManager.d()).a.is_open_mic == 0) {
        ToastUtils.a("已开麦", 0);
        b(1);
        return;
      } 
      ToastUtils.a("已闭麦", 0);
      b(0);
      return;
    } 
    if (i == R.id.iv_anim) {
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
      this.a.D();
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    YYObserverManager.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYBottomView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */