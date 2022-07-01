package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class YYFloatVoteView extends FrameLayout {
  private BaseYYStudioFragment a;
  
  private TextView b;
  
  private ImageView c;
  
  public YYFloatVoteView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYFloatVoteView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYFloatVoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_float_vote, (ViewGroup)this, true);
    this.b = (TextView)findViewById(R.id.tv_vote_time);
    this.c = (ImageView)findViewById(R.id.to_vote);
    this.c.setEnabled(true);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_VOTE_WINDOW_CLICK, yYRoomModel.room_id, yYRoomModel.uid); 
            YYFloatVoteView.a(this.a).a("");
          }
        });
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.a = paramBaseYYStudioFragment;
    LiveEventBus.get("show_vote_time", String.class).observe((LifecycleOwner)paramBaseYYStudioFragment, new Observer<String>(this) {
          public void a(String param1String) {
            if (TextUtils.isEmpty(param1String)) {
              YYFloatVoteView.b(this.a).setText("00:00");
              this.a.setVisibility(8);
              return;
            } 
            if (this.a.getVisibility() != 0)
              this.a.setVisibility(0); 
            YYFloatVoteView.b(this.a).setText(param1String);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYFloatVoteView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */