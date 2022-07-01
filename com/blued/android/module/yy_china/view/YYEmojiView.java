package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYEmojiAdapter;
import com.blued.android.module.yy_china.adapter.YYSoundAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYEmojiModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgEmojiExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSoundModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;

public class YYEmojiView extends LinearLayout {
  private RecyclerView a;
  
  private TextView b;
  
  private BaseYYStudioFragment c;
  
  private YYEmojiAdapter d;
  
  private YYSoundAdapter e;
  
  public YYEmojiView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYEmojiView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_emoji_layout, (ViewGroup)this, true);
    this.b = (TextView)findViewById(R.id.rv_text);
    this.a = (RecyclerView)findViewById(R.id.rv_list);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(0);
    this.a.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
  }
  
  private void a(YYEmojiModel paramYYEmojiModel, YYRoomModel paramYYRoomModel) {
    EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_EMOJI_CLICK, paramYYRoomModel.room_id, paramYYRoomModel.uid, paramYYEmojiModel.id);
    YYRoomHttpUtils.d(paramYYRoomModel.room_id, paramYYEmojiModel.id, new BluedUIHttpResponse<BluedEntityA<YYMsgEmojiExtra>>(this, (IRequestHost)this.c.w_()) {
          protected void a(BluedEntityA<YYMsgEmojiExtra> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (!param1BluedEntityA.hasData())
                return; 
              YYEmojiView.a(this.a, (YYMsgEmojiExtra)param1BluedEntityA.getSingleData());
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (YYEmojiView.c(this.a) != null)
              YYEmojiView.c(this.a).H(); 
          }
        }(IRequestHost)this.c.w_());
  }
  
  private void a(YYMsgEmojiExtra paramYYMsgEmojiExtra) {
    YYImModel yYImModel = new YYImModel();
    yYImModel.type = 27;
    YYAudienceModel yYAudienceModel = new YYAudienceModel();
    yYAudienceModel.setUid(YYRoomInfoManager.d().e());
    yYAudienceModel.setName(YYRoomInfoManager.d().f());
    yYAudienceModel.setAvatar(YYRoomInfoManager.d().g());
    yYImModel.source_profile = yYAudienceModel;
    yYImModel.setMsgExtra(AppInfo.f().toJson(paramYYMsgEmojiExtra));
    this.c.a(YYRoomInfoManager.d().e(), paramYYMsgEmojiExtra.apng, yYImModel);
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    YYRoomHttpUtils.e(paramString1, stringBuilder.toString(), new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.c.w_(), paramString2) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            if (YYEmojiView.c(this.b) != null)
              YYEmojiView.c(this.b).H(); 
            AudioChannelManager.e().a(2, this.a);
          }
        }(IRequestHost)this.c.w_());
  }
  
  private void getEmojiList() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.i(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYEmojiModel>>(this, (IRequestHost)this.c.w_()) {
          protected void a(BluedEntityA<YYEmojiModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (!param1BluedEntityA.hasData())
                return; 
              YYEmojiView.a(this.a).c(param1BluedEntityA.data);
            } 
          }
        }(IRequestHost)this.c.w_());
  }
  
  private void getSoundList() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.j(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYSoundModel>>(this, (IRequestHost)this.c.w_()) {
          protected void a(BluedEntityA<YYSoundModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (!param1BluedEntityA.hasData())
                return; 
              YYEmojiView.b(this.a).c(param1BluedEntityA.data);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
        }(IRequestHost)this.c.w_());
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.c = paramBaseYYStudioFragment;
    this.b.setText(getResources().getString(R.string.yy_mic_emoji));
    this.d = new YYEmojiAdapter((IRequestHost)paramBaseYYStudioFragment.w_());
    this.a.setAdapter((RecyclerView.Adapter)this.d);
    this.d.a(new BaseQuickAdapter.OnItemClickListener(this, paramBaseYYStudioFragment) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (ClickUtils.a(param1View.getId()))
              return; 
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            if (yYRoomModel.isExistEmojiByUid(YYRoomInfoManager.d().e())) {
              ToastUtils.a("请不要频繁操作!", 0);
              return;
            } 
            YYEmojiModel yYEmojiModel = param1BaseQuickAdapter.n().get(param1Int);
            YYEmojiView.a(this.b, yYEmojiModel, yYRoomModel);
            this.a.H();
          }
        });
    getEmojiList();
  }
  
  public void b(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.c = paramBaseYYStudioFragment;
    this.b.setText(getResources().getString(R.string.yy_mic_sound));
    this.e = new YYSoundAdapter((IRequestHost)paramBaseYYStudioFragment.w_());
    this.a.setAdapter((RecyclerView.Adapter)this.e);
    this.e.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            YYSoundModel yYSoundModel = param1BaseQuickAdapter.n().get(param1Int);
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null) {
              ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK;
              String str1 = yYRoomModel.room_id;
              String str2 = yYRoomModel.uid;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(yYSoundModel.effect_id);
              stringBuilder.append("");
              EventTrackYY.f(event, str1, str2, stringBuilder.toString());
            } 
            YYEmojiView.a(this.a, yYRoomModel.room_id, yYSoundModel.effect_id, yYSoundModel.media);
          }
        });
    getSoundList();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYEmojiView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */