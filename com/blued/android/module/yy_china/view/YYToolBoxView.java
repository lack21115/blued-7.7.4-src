package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYToolBoxModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

public class YYToolBoxView extends LinearLayout {
  private RecyclerView a;
  
  private BaseYYStudioFragment b;
  
  private ToolBoxAdapter c;
  
  public YYToolBoxView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYToolBoxView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYToolBoxView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_toolbox, (ViewGroup)this, true);
    this.a = (RecyclerView)findViewById(R.id.rv_tool_list);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(0);
    this.a.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.c = new ToolBoxAdapter(this);
    this.a.setAdapter((RecyclerView.Adapter)this.c);
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.b = paramBaseYYStudioFragment;
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    int[] arrayOfInt1 = new int[4];
    int j = R.drawable.icon_mic_emoji;
    int i = 0;
    arrayOfInt1[0] = j;
    arrayOfInt1[1] = R.drawable.icon_mic_sound;
    arrayOfInt1[2] = R.drawable.icon_mic_music;
    arrayOfInt1[3] = R.drawable.icon_mic_vote;
    int[] arrayOfInt2 = new int[4];
    arrayOfInt2[0] = R.string.yy_mic_emoji;
    arrayOfInt2[1] = R.string.yy_mic_sound;
    arrayOfInt2[2] = R.string.yy_mic_music;
    arrayOfInt2[3] = R.string.yy_mic_vote;
    ArrayList<YYToolBoxModel> arrayList = new ArrayList();
    while (i < arrayOfInt2.length) {
      if ((i <= 0 || TextUtils.equals(yYRoomModel.uid, YYRoomInfoManager.d().e())) && i < arrayOfInt1.length) {
        YYToolBoxModel yYToolBoxModel = new YYToolBoxModel();
        yYToolBoxModel.b = getResources().getString(arrayOfInt2[i]);
        yYToolBoxModel.a = arrayOfInt1[i];
        arrayList.add(yYToolBoxModel);
      } 
      i++;
    } 
    this.c.c(arrayList);
    this.c.a(new BaseQuickAdapter.OnItemClickListener(this, yYRoomModel) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (YYToolBoxView.a(this.b) != null) {
              if (YYToolBoxView.a(this.b).isDetached())
                return; 
              if (param1Int != 0) {
                if (param1Int != 1) {
                  if (param1Int != 2) {
                    if (param1Int != 3)
                      return; 
                    EventTrackYY.c(ChatRoomProtos.Event.CHAT_ROOM_VOTE_ICON_CLICK, this.a.room_id);
                    YYToolBoxView.a(this.b).E();
                    return;
                  } 
                  YYToolBoxView.a(this.b).H();
                  YYToolBoxView.a(this.b).x();
                  return;
                } 
                YYToolBoxView.a(this.b).C();
                return;
              } 
              YYToolBoxView.a(this.b).B();
            } 
          }
        });
  }
  
  class ToolBoxAdapter extends BaseQuickAdapter<YYToolBoxModel, BaseViewHolder> {
    public ToolBoxAdapter(YYToolBoxView this$0) {
      super(R.layout.item_tool_box);
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, YYToolBoxModel param1YYToolBoxModel) {
      ImageView imageView = (ImageView)param1BaseViewHolder.d(R.id.tool_img);
      TextView textView = (TextView)param1BaseViewHolder.d(R.id.tool_name);
      imageView.setImageResource(param1YYToolBoxModel.a);
      textView.setText(param1YYToolBoxModel.b);
      if (param1BaseViewHolder.getAdapterPosition() == 2) {
        YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
        if (yYRoomModel == null)
          return; 
        EventTrackYY.c(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW, yYRoomModel.room_id);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYToolBoxView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */