package com.soft.blued.ui.circle.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.utils.MarkDownLinkHelper;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CircleTalkAdapter extends BaseQuickAdapter<BluedIngSelfFeed, BaseViewHolder> {
  protected Context a;
  
  protected IRequestHost b;
  
  public boolean c = true;
  
  public Set<String> d = new HashSet<String>();
  
  private HashSet<String> e = new HashSet<String>();
  
  public CircleTalkAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493486);
    this.a = paramContext;
    this.b = paramIRequestHost;
  }
  
  private List<BluedIngSelfFeed> b(Collection<? extends BluedIngSelfFeed> paramCollection) {
    ArrayList<BluedIngSelfFeed> arrayList = new ArrayList();
    for (BluedIngSelfFeed bluedIngSelfFeed : paramCollection) {
      if (!this.e.contains(bluedIngSelfFeed.feed_id)) {
        arrayList.add(bluedIngSelfFeed);
        this.e.add(bluedIngSelfFeed.feed_id);
      } 
    } 
    return arrayList;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBaseViewHolder != null) {
      if (paramBluedIngSelfFeed.feed_comment > 999) {
        paramBaseViewHolder.a(2131299368, "999+");
      } else {
        paramBaseViewHolder.a(2131299368, Integer.toString(paramBluedIngSelfFeed.feed_comment));
      } 
      if (TextUtils.isEmpty(paramBluedIngSelfFeed.feed_content)) {
        if (this.c) {
          paramBaseViewHolder.a(2131299369, (CharSequence)CircleMethods.setEssence(paramBluedIngSelfFeed, this.a.getResources().getString(2131755914), false));
        } else {
          paramBaseViewHolder.b(2131299369, 2131755914);
        } 
      } else {
        TextView textView = (TextView)paramBaseViewHolder.d(2131299369);
        CharSequence charSequence = StringUtils.a(paramBluedIngSelfFeed.feed_content.replaceAll("\r|\n", ""), (int)textView.getTextSize(), 1);
        charSequence = MarkDownLinkHelper.a(this.a, charSequence);
        textView.setLineSpacing(12.0F, 1.0F);
        if (paramBluedIngSelfFeed.is_posts_vote == 1) {
          textView.setText((CharSequence)CircleMethods.addTop(paramBluedIngSelfFeed, (CharSequence)CircleMethods.addVote(paramBluedIngSelfFeed, charSequence)));
        } else if (this.c) {
          textView.setText((CharSequence)CircleMethods.addTop(paramBluedIngSelfFeed, (CharSequence)CircleMethods.setEssence(paramBluedIngSelfFeed, charSequence, false)));
        } else {
          textView.setText((CharSequence)CircleMethods.addTop(paramBluedIngSelfFeed, (CharSequence)CircleMethods.addVote(paramBluedIngSelfFeed, charSequence)));
        } 
      } 
      if (this.d.contains(paramBluedIngSelfFeed.feed_id)) {
        paramBaseViewHolder.f(2131299369, BluedSkinUtils.a(this.a, 2131100844));
      } else {
        paramBaseViewHolder.f(2131299369, BluedSkinUtils.a(this.a, 2131100838));
      } 
      ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131299371);
      ImageLoader.a(this.b, paramBluedIngSelfFeed.cover).a(2131231281).a(imageView2);
      paramBaseViewHolder.a(2131299375, paramBluedIngSelfFeed.circle_title);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(TimeAndDateUtils.c(this.a, TimeAndDateUtils.b(paramBluedIngSelfFeed.last_comment_time)));
      stringBuilder.append(this.a.getString(2131755961));
      paramBaseViewHolder.a(2131299377, stringBuilder.toString());
      ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131299372);
      if (paramBluedIngSelfFeed.is_video_posts == 1 && paramBluedIngSelfFeed.feed_videos != null && paramBluedIngSelfFeed.feed_videos.length > 0) {
        paramBaseViewHolder.b(2131297897, true);
        ImageLoader.a(this.b, paramBluedIngSelfFeed.feed_videos[0]).a(imageView1);
        paramBaseViewHolder.b(2131299373, true);
      } else {
        paramBaseViewHolder.b(2131297897, false);
        if (paramBluedIngSelfFeed.feed_pics != null && paramBluedIngSelfFeed.feed_pics.length > 0) {
          ImageLoader.a(this.b, paramBluedIngSelfFeed.feed_pics[0]).a(imageView1);
          paramBaseViewHolder.b(2131299373, true);
        } else {
          paramBaseViewHolder.b(2131299373, false);
        } 
      } 
      c(paramBaseViewHolder);
      b(paramBaseViewHolder);
      a(paramBluedIngSelfFeed);
    } 
  }
  
  protected void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (!paramBluedIngSelfFeed.isShowUrlVisited) {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_DRAW;
      String str1 = paramBluedIngSelfFeed.circle_id;
      String str2 = paramBluedIngSelfFeed.feed_id;
      FeedProtos.NoteSource noteSource = FeedProtos.NoteSource.NOTE_LIST;
      if (paramBluedIngSelfFeed.is_top == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      FeedProtos.NoteType noteType = EventTrackFeed.b(paramBluedIngSelfFeed);
      String str3 = paramBluedIngSelfFeed.note_from;
      if (paramBluedIngSelfFeed.is_anonym == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (paramBluedIngSelfFeed.is_essence == 1) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      EventTrackFeed.a(event, str1, str2, noteSource, bool1, noteType, str3, bool2, bool3, MarkDownLinkHelper.a(paramBluedIngSelfFeed.feed_pure_content));
      paramBluedIngSelfFeed.isShowUrlVisited = true;
    } 
  }
  
  public void a(String paramString) {
    this.d.add(paramString);
  }
  
  public void a(Collection<? extends BluedIngSelfFeed> paramCollection) {
    super.a(b(paramCollection));
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  protected void b(BaseViewHolder paramBaseViewHolder) {
    paramBaseViewHolder.c(2131299371);
    paramBaseViewHolder.c(2131299375);
  }
  
  protected void b(BaseViewHolder paramBaseViewHolder, BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBaseViewHolder != null)
      a(paramBaseViewHolder, paramBluedIngSelfFeed); 
  }
  
  public void b(String paramString) {
    if (this.n != null && !TextUtils.isEmpty(paramString))
      for (BluedIngSelfFeed bluedIngSelfFeed : this.n) {
        if (paramString.equals(bluedIngSelfFeed.feed_id)) {
          this.n.remove(bluedIngSelfFeed);
          notifyDataSetChanged();
          break;
        } 
      }  
  }
  
  protected void c(BaseViewHolder paramBaseViewHolder) {
    LinearLayout linearLayout = (LinearLayout)paramBaseViewHolder.d(2131299374);
    CardView cardView = (CardView)paramBaseViewHolder.d(2131296651);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131299375);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297682);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131299377);
    if (textView1.getText().toString().length() <= 10)
      return; 
    String str = textView2.getText().toString();
    textView2.setText(null);
    linearLayout.post(new Runnable(this, textView2, linearLayout, cardView, imageView, textView1, str) {
          public void run() {
            TextView textView = this.a;
            if (textView != null) {
              textView.setMaxWidth(this.b.getWidth() - this.c.getWidth() - this.d.getWidth() - this.e.getWidth() - DensityUtils.a(this.g.a, 25.0F));
              this.a.setText(this.f);
            } 
          }
        });
  }
  
  public void c(List<BluedIngSelfFeed> paramList) {
    this.e.clear();
    if (paramList != null) {
      super.c(b(paramList));
      return;
    } 
    super.c(null);
  }
  
  public static interface OnItemClickListener {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\CircleTalkAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */