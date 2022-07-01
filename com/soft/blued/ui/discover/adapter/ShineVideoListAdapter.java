package com.soft.blued.ui.discover.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.video.fragment.VideoScanFragment;
import com.soft.blued.ui.video.manager.ShineVideoDataManager;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShineVideoListAdapter extends BaseQuickAdapter<BluedIngSelfFeed, BaseViewHolder> {
  public Context a;
  
  public LayoutInflater b;
  
  public LoadOptions c;
  
  public LoadOptions d;
  
  public IRequestHost e;
  
  public int f;
  
  public int g;
  
  public ShineVideoListAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493677, new ArrayList());
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    int i = AppInfo.l;
    this.c = new LoadOptions();
    LoadOptions loadOptions = this.c;
    loadOptions.l = false;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    i >>= 1;
    loadOptions.a(i, i);
    this.d = new LoadOptions();
    loadOptions = this.d;
    loadOptions.d = 2131231369;
    loadOptions.b = 2131231369;
    this.e = paramIRequestHost;
    this.f = a(this.a)[0];
    this.g = a(this.a)[1];
  }
  
  private void a(TextView paramTextView, String paramString) {
    paramTextView.setText(StringUtils.a(StringUtils.a(paramString, (int)paramTextView.getTextSize(), 0), false, true, false, ""));
  }
  
  public static int[] a(Context paramContext) {
    int i = (AppInfo.l - DensityUtils.a(paramContext, 23.0F)) / 2;
    return new int[] { i, i * 12 / 7 };
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBaseViewHolder != null) {
      ViewHolder viewHolder = new ViewHolder(this);
      ViewHolder.a(viewHolder, (ImageView)paramBaseViewHolder.d(2131297463));
      ViewHolder.b(viewHolder, (ImageView)paramBaseViewHolder.d(2131297490));
      ViewHolder.c(viewHolder, (ImageView)paramBaseViewHolder.d(2131297484));
      ViewHolder.a(viewHolder, (TextView)paramBaseViewHolder.d(2131300954));
      ViewHolder.b(viewHolder, (TextView)paramBaseViewHolder.d(2131300663));
      ViewHolder.c(viewHolder, (TextView)paramBaseViewHolder.d(2131301242));
      ViewHolder.a(viewHolder, (RelativeLayout)paramBaseViewHolder.d(2131299719));
      ViewHolder.d(viewHolder, (ImageView)paramBaseViewHolder.d(2131297445));
      ViewHolder.d(viewHolder, (TextView)paramBaseViewHolder.d(2131301006));
      if (paramBluedIngSelfFeed.feed_videos_duration * 1000.0D >= 60000.0D) {
        ViewHolder.a(viewHolder).setVisibility(0);
      } else {
        ViewHolder.a(viewHolder).setVisibility(8);
      } 
      ViewGroup.LayoutParams layoutParams1 = ViewHolder.b(viewHolder).getLayoutParams();
      layoutParams1.width = this.f;
      layoutParams1.height = this.g;
      ViewHolder.b(viewHolder).setLayoutParams(layoutParams1);
      if (paramBluedIngSelfFeed.feed_videos != null && paramBluedIngSelfFeed.feed_videos.length > 0) {
        ImageLoader.a(this.e, paramBluedIngSelfFeed.feed_videos[0]).a(2131100257).a(new ImageLoadResult(this, this.e, viewHolder) {
              public void a() {
                Drawable drawable = ShineVideoListAdapter.ViewHolder.c(this.a).getDrawable();
                if (drawable != null) {
                  if (drawable.getIntrinsicWidth() > drawable.getIntrinsicHeight()) {
                    ShineVideoListAdapter.ViewHolder.c(this.a).setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return;
                  } 
                  ShineVideoListAdapter.ViewHolder.c(this.a).setScaleType(ImageView.ScaleType.CENTER_CROP);
                  return;
                } 
                ShineVideoListAdapter.ViewHolder.c(this.a).setScaleType(ImageView.ScaleType.CENTER_CROP);
              }
            }).a(ViewHolder.c(viewHolder));
      } else {
        ViewHolder.c(viewHolder).setImageResource(2131231369);
      } 
      ViewHolder.c(viewHolder).setOnClickListener(new View.OnClickListener(this, paramBluedIngSelfFeed) {
            public void onClick(View param1View) {
              if (AudioChannelManager.e().h()) {
                AppMethods.a(this.b.a.getResources().getText(2131759450));
                return;
              } 
              EventTrackFeed.a(FeedProtos.Event.FLASH_PLAY_LIST_ONE_CLICK, this.a.feed_id);
              FindHttpUtils.a(this.a.click_url);
              InstantLog.h("shine_video_list_click", this.a.feed_id);
              VideoScanFragment.a(this.b.a, this.a);
            }
          });
      RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)ViewHolder.d(viewHolder).getLayoutParams();
      if (!StringUtils.e(paramBluedIngSelfFeed.feed_content)) {
        layoutParams.height = -2;
        a(ViewHolder.d(viewHolder), paramBluedIngSelfFeed.feed_content);
      } else {
        layoutParams.height = DensityUtils.a(this.a, 5.0F);
        ViewHolder.d(viewHolder).setText("");
      } 
      ViewHolder.d(viewHolder).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      if (paramBluedIngSelfFeed.is_recommend_ticktocks == 1 && !StringUtils.e(paramBluedIngSelfFeed.recommend_text)) {
        ViewHolder.e(viewHolder).setVisibility(0);
        ViewHolder.e(viewHolder).setText(paramBluedIngSelfFeed.recommend_text);
      } else {
        ViewHolder.e(viewHolder).setVisibility(8);
      } 
      if (StringUtils.e(paramBluedIngSelfFeed.feed_content) && (paramBluedIngSelfFeed.is_recommend_ticktocks != 1 || StringUtils.e(paramBluedIngSelfFeed.recommend_text))) {
        ViewHolder.f(viewHolder).setVisibility(8);
      } else {
        ViewHolder.f(viewHolder).setVisibility(0);
      } 
      ImageLoader.a(this.e, AvatarUtils.a(0, paramBluedIngSelfFeed.user_avatar)).a(2131234356).a(1.0F, this.a.getResources().getColor(2131100858)).a(ViewHolder.g(viewHolder));
      ViewHolder.g(viewHolder).setOnClickListener(new View.OnClickListener(this, paramBluedIngSelfFeed) {
            public void onClick(View param1View) {
              UserBasicModel userBasicModel = new UserBasicModel();
              userBasicModel.uid = this.a.feed_uid;
              userBasicModel.avatar = this.a.user_avatar;
              userBasicModel.name = this.a.user_name;
              LogData logData = new LogData();
              logData.I = this.a.feed_id;
              UserInfoFragmentNew.a(this.b.a, userBasicModel, "shine_video_list", null, logData, new MsgSourceEntity(MessageProtos.StrangerSource.FIND_PLAZA_FLASH, EncryptTool.b(this.a.feed_id)));
            }
          });
      if (paramBluedIngSelfFeed.feed_dig == 0) {
        ViewHolder.h(viewHolder).setText("");
      } else {
        ViewHolder.h(viewHolder).setText(AreaUtils.a(this.a, Long.valueOf(paramBluedIngSelfFeed.feed_dig)));
      } 
      if ("1".equalsIgnoreCase(paramBluedIngSelfFeed.relationship) || "3".equalsIgnoreCase(paramBluedIngSelfFeed.relationship)) {
        ViewHolder.i(viewHolder).setVisibility(8);
      } else {
        ViewHolder.i(viewHolder).setImageResource(2131232809);
        ViewHolder.i(viewHolder).setVisibility(0);
        ViewHolder.i(viewHolder).setScaleX(1.0F);
        ViewHolder.i(viewHolder).setScaleY(1.0F);
        ViewHolder.i(viewHolder).setOnClickListener(new View.OnClickListener(this, paramBluedIngSelfFeed, viewHolder) {
              public void onClick(View param1View) {
                boolean bool1;
                boolean bool2;
                InstantLog.b(0, this.a.feed_uid);
                this.a.relationship = "1";
                ShineVideoListAdapter.ViewHolder.i(this.b).setImageResource(2131232810);
                UserHttpUtils.b(this.c.a, new UserRelationshipUtils.IAddOrRemoveAttentionDone(this) {
                      public void a() {}
                      
                      public void a(String param2String) {}
                      
                      public void b() {}
                      
                      public void b(String param2String) {}
                      
                      public void c() {
                        this.a.a.relationship = "0";
                        this.a.c.notifyDataSetChanged();
                      }
                    },  this.a.feed_uid, "shine_video_list", this.c.e);
                ShineVideoListAdapter.ViewHolder.i(this.b).setImageResource(2131232810);
                ShineVideoDataManager.a().a(this.a.feed_id, this.a.relationship);
                FeedProtos.FollowLocation followLocation = FeedProtos.FollowLocation.FOLLOW_PLAZA_FLASH;
                FeedProtos.Event event = FeedProtos.Event.OTHER_FOLLOW_CLICK;
                String str = this.a.feed_uid;
                if (this.a.live > 0) {
                  bool1 = true;
                } else {
                  bool1 = false;
                } 
                if (this.a.in_promotion == 1) {
                  bool2 = true;
                } else {
                  bool2 = false;
                } 
                EventTrackFeed.a(event, str, "", "", followLocation, true, bool1, bool2);
              }
            });
      } 
      if (!paramBluedIngSelfFeed.isShowUrlVisited) {
        String str1;
        boolean bool1;
        boolean bool2;
        if (TextUtils.isEmpty(paramBluedIngSelfFeed.super_did)) {
          str1 = "";
        } else {
          str1 = paramBluedIngSelfFeed.super_did;
        } 
        FeedProtos.Event event = FeedProtos.Event.FEED_DRAW;
        String str2 = paramBluedIngSelfFeed.feed_id;
        FeedProtos.FeedClass feedClass = FeedProtos.FeedClass.FEED_VIDEO;
        FeedProtos.FeedPage feedPage = FeedProtos.FeedPage.PLAZA_FLASH_LIST;
        String str3 = paramBluedIngSelfFeed.feed_uid;
        if (paramBluedIngSelfFeed.in_promotion == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (paramBluedIngSelfFeed.feed_pics != null && paramBluedIngSelfFeed.feed_pics.length > 1) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramBluedIngSelfFeed.join_circle_id);
        stringBuilder.append("");
        EventTrackFeed.a(event, str2, str1, feedClass, feedPage, str3, bool1, bool2, stringBuilder.toString(), "");
        InstantLog.a(5, paramBluedIngSelfFeed.feed_id, paramBluedIngSelfFeed.recommend_text, paramBluedIngSelfFeed.feed_uid);
        FindHttpUtils.a(paramBluedIngSelfFeed.show_url);
        paramBluedIngSelfFeed.isShowUrlVisited = true;
      } 
    } 
  }
  
  public void a(Collection<? extends BluedIngSelfFeed> paramCollection) {
    super.a(b(paramCollection));
    notifyDataSetChanged();
  }
  
  public List<BluedIngSelfFeed> b(Collection<? extends BluedIngSelfFeed> paramCollection) {
    paramCollection = paramCollection;
    ArrayList<BluedIngSelfFeed> arrayList = new ArrayList();
    if (paramCollection != null)
      for (int i = 0; i < paramCollection.size(); i++)
        arrayList.add(paramCollection.get(i));  
    return arrayList;
  }
  
  public void c(List<BluedIngSelfFeed> paramList) {
    super.c(b(paramList));
    notifyDataSetChanged();
  }
  
  public class ViewHolder {
    private ImageView b;
    
    private ImageView c;
    
    private ImageView d;
    
    private ImageView e;
    
    private TextView f;
    
    private TextView g;
    
    private TextView h;
    
    private RelativeLayout i;
    
    private TextView j;
    
    public ViewHolder(ShineVideoListAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\adapter\ShineVideoListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */