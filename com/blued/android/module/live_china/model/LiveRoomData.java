package com.blued.android.module.live_china.model;

import com.blued.android.chat.data.BadgeData;
import com.blued.android.module.common.utils.ReflectionUtils;
import java.io.Serializable;
import java.util.List;

public class LiveRoomData implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public List<LiveActivityItemModel> activity;
  
  public String anchor_liang_id;
  
  public int anchor_liang_type;
  
  public List<BadgeData> badges;
  
  public double beans_count;
  
  public double beans_current_count;
  
  public String comeCode = "";
  
  public String conference_id;
  
  public long count;
  
  public String description;
  
  public LiveRoomEntranceData effects;
  
  public long elapse_time;
  
  public int entrance_status;
  
  public LiveRoomLineFriendsModel friends_line;
  
  public String gap_exp;
  
  public boolean hasTransition = true;
  
  public String icon;
  
  public boolean isFollow;
  
  public int is_first;
  
  public int is_manager;
  
  public int level;
  
  public String liang_id;
  
  public int liang_type;
  
  public long lid;
  
  public LiveRoomLineModel line;
  
  public int link_type;
  
  public String liveFrom;
  
  public LiveOneKissModel liveOneKissModel;
  
  public int livePosition;
  
  public int live_quic;
  
  public int live_type;
  
  public String live_url;
  
  public LiveMakeLoverModel matchmaking;
  
  public int next_level;
  
  public float percent;
  
  public LiveRoomPkModel pk;
  
  public LiveRoomAnchorModel profile;
  
  public String publish_url;
  
  public long rank;
  
  public RankingExtra rankingExtra;
  
  public LiveRecordRecommendModel recommend;
  
  public String recommendType;
  
  public String relationship;
  
  public int screen_pattern;
  
  public String stream;
  
  public int stream_level;
  
  public String token;
  
  public LiveRecordLevelStickerModel watermark;
  
  public LiveRoomData() {
    this.profile = new LiveRoomAnchorModel();
  }
  
  public LiveRoomData(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2) {
    this.lid = paramLong;
    this.screen_pattern = paramInt1;
    this.comeCode = paramString1;
    this.profile = new LiveRoomAnchorModel(paramString2, paramString3, paramString4, paramInt2);
  }
  
  public void copyModel(LiveRoomData paramLiveRoomData) {
    ReflectionUtils.a(paramLiveRoomData, this);
  }
  
  public void reset() {
    ReflectionUtils.a(new LiveRoomData(), this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveRoomData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */