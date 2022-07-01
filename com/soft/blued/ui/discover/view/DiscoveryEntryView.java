package com.soft.blued.ui.discover.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.http.ActivityUrl;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.fragment.CircleNewFragment;
import com.soft.blued.ui.discover.fragment.ImageFeedFragment;
import com.soft.blued.ui.discover.fragment.ShineVideoListFragment;
import com.soft.blued.ui.discover.fragment.SuperTopicFragment;
import com.soft.blued.ui.discover.model.DiscoverSquareExtra;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.yy_room.fragment.YYChatRoomsFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.click.SingleClickProxy;

public class DiscoveryEntryView extends LinearLayout implements View.OnClickListener {
  private ImageView a;
  
  private ImageView b;
  
  private TextView c;
  
  private DiscoverSquareExtra.Explore d;
  
  public DiscoveryEntryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, IRequestHost paramIRequestHost) {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131494234, (ViewGroup)this, true);
    this.a = (ImageView)findViewById(2131297804);
    this.b = (ImageView)findViewById(2131297872);
    this.c = (TextView)findViewById(2131301088);
    setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    boolean bool = BluedSkinUtils.c();
    String str = "new_icon";
    if (!bool) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("new_icon");
      stringBuilder1.append("_dark");
      str = stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(".png");
    ImageLoader.c(paramIRequestHost, stringBuilder.toString()).f().e(-1).a(this.b);
  }
  
  public DiscoveryEntryView(Context paramContext, AttributeSet paramAttributeSet, IRequestHost paramIRequestHost) {
    this(paramContext, paramAttributeSet, 0, paramIRequestHost);
  }
  
  public DiscoveryEntryView(Context paramContext, IRequestHost paramIRequestHost) {
    this(paramContext, (AttributeSet)null, paramIRequestHost);
  }
  
  private void a(IRequestHost paramIRequestHost, int paramInt) {
    boolean bool;
    ImageWrapper imageWrapper = ImageLoader.a(paramIRequestHost, this.d.getIcon()).d(getId());
    if (this.d.loop != 0) {
      bool = this.d.loop;
    } else {
      bool = true;
    } 
    imageWrapper.e(bool).a(paramInt).c(paramInt).a(this.a);
  }
  
  private void setTextView(int paramInt) {
    String str2 = this.d.getTitle();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = getContext().getString(paramInt); 
    this.c.setText(str1);
  }
  
  public void a(IRequestHost paramIRequestHost) {
    post(new Runnable(this, paramIRequestHost) {
          public void run() {
            DiscoveryEntryView discoveryEntryView = this.b;
            discoveryEntryView.a(DiscoveryEntryView.a(discoveryEntryView), this.a);
          }
        });
  }
  
  public void a(DiscoverSquareExtra.Explore paramExplore, IRequestHost paramIRequestHost) {
    if (paramExplore == null || paramExplore.name <= 0) {
      setVisibility(8);
      return;
    } 
    this.d = paramExplore;
    if ("en".equals(BlueAppLocal.a())) {
      this.c.setTextSize(11.0F);
    } else {
      this.c.setTextSize(13.0F);
    } 
    setId(this.d.name);
    setVisibility(0);
    this.b.setVisibility(8);
    switch (this.d.name) {
      default:
        setVisibility(8);
        return;
      case 6:
        if (BluedPreferences.aA((UserInfo.a().i()).uid)) {
          EventTrackFeed.a(FeedProtos.Event.NEW_TAG_CLICK, FeedProtos.TagSource.VOICE_CHATROOM);
          this.b.setVisibility(0);
        } 
        a(paramIRequestHost, 2131231381);
        setTextView(2131759420);
        return;
      case 5:
        a(paramIRequestHost, 2131231383);
        setTextView(2131757051);
        return;
      case 4:
        a(paramIRequestHost, 2131231384);
        setTextView(2131758419);
        return;
      case 3:
        a(paramIRequestHost, 2131231386);
        setTextView(2131756358);
        return;
      case 2:
        a(paramIRequestHost, 2131231385);
        setTextView(2131758956);
        return;
      case 1:
        break;
    } 
    a(paramIRequestHost, 2131231382);
    setTextView(2131755405);
  }
  
  public void onClick(View paramView) {
    EventTrackFeed.a(FeedProtos.Event.FIND_RECOMMEND_SECOND_PAGE_SHOW, this.d.name, this.d.getIcon(), this.d.getIconType());
    switch (this.d.name) {
      default:
        return;
      case 6:
        YYChatRoomsFragment.a(getContext(), "find_chat_room");
        if (BluedPreferences.aA((UserInfo.a().i()).uid)) {
          EventTrackFeed.a(FeedProtos.Event.NEW_TAG_CLICK, FeedProtos.TagSource.VOICE_CHATROOM);
          BluedPreferences.aB((UserInfo.a().i()).uid);
          this.b.setVisibility(8);
          return;
        } 
        return;
      case 5:
        ImageFeedFragment.a(getContext());
        return;
      case 4:
        ShineVideoListFragment.a(getContext());
        return;
      case 3:
        WebViewShowInfoFragment.show(getContext(), ActivityUrl.a(0), -1);
        return;
      case 2:
        SuperTopicFragment.a(getContext());
        return;
      case 1:
        break;
    } 
    CircleNewFragment.a(getContext());
  }
  
  public static @interface Entry {
    public static final int CHAT_ROOM = 6;
    
    public static final int CIRCLE = 1;
    
    public static final int IMAGE = 5;
    
    public static final int SCAN = 4;
    
    public static final int TOPIC = 2;
    
    public static final int VIDEO = 3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\view\DiscoveryEntryView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */