package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFansLevelModel;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BarrageView extends View {
  public int a = 4;
  
  public boolean b = true;
  
  private List<Bubble> c = new ArrayList<Bubble>();
  
  private List<Bubble> d = new ArrayList<Bubble>();
  
  private Random e = new Random();
  
  private int f;
  
  private Context g;
  
  private Paint h = new Paint();
  
  private LayoutInflater i;
  
  private int[] j = new int[] { 0, 40, 80, 120 };
  
  private PopUserCard k;
  
  private int l = 0;
  
  private View m;
  
  private View n;
  
  private View o;
  
  private Bitmap p;
  
  private final int q = 130;
  
  private LoadOptions r;
  
  public BarrageView(Context paramContext) {
    super(paramContext);
    this.g = paramContext;
    a();
  }
  
  public BarrageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.g = paramContext;
    a();
  }
  
  public BarrageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.g = paramContext;
    a();
  }
  
  private void a() {
    this.h.reset();
    this.h.setAntiAlias(true);
    this.h.setFilterBitmap(true);
    this.h.setColor(this.g.getResources().getColor(R.color.transparent));
    this.h.setAlpha(255);
    this.r = new LoadOptions();
    this.r.b = R.drawable.user_bg_round;
    this.r.d = R.drawable.user_bg_round;
    this.i = LayoutInflater.from(this.g);
    this.m = this.i.inflate(R.layout.item_barrage, null);
    this.m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    View view = this.m;
    view.layout(0, 0, view.getMeasuredWidth(), this.m.getMeasuredHeight());
    this.l = this.m.getHeight();
    this.n = this.i.inflate(R.layout.item_wawaji_result, null);
    this.o = this.i.inflate(R.layout.item_wawaji_list_result, null);
    setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (BarrageView.a(this.a) != null) {
              String str = BarrageView.a(this.a, (int)param1MotionEvent.getY());
              if (!TextUtils.isEmpty(str))
                BarrageView.a(this.a).e(str); 
            } 
            return false;
          }
        });
  }
  
  public static void a(Context paramContext, View paramView, int paramInt, boolean paramBoolean) {
    if (paramView != null) {
      if (paramInt <= 15) {
        paramView.setBackground(paramContext.getResources().getDrawable(R.drawable.shape_round_live_msg_item_bg));
        return;
      } 
      if (paramInt <= 20) {
        paramView.setBackground(paramContext.getResources().getDrawable(R.drawable.shape_gradient_name_level_yellow));
        return;
      } 
      if (paramInt <= 25) {
        paramView.setBackground(paramContext.getResources().getDrawable(R.drawable.shape_gradient_name_level_orange));
        return;
      } 
      if (paramInt < 30) {
        paramView.setBackground(paramContext.getResources().getDrawable(R.drawable.shape_gradient_name_level_red));
        return;
      } 
      if (paramInt == 30) {
        paramView.setBackground(paramContext.getResources().getDrawable(R.drawable.shape_gradient_name_level_30));
        return;
      } 
      if (paramInt == 31) {
        paramView.setBackground(paramContext.getResources().getDrawable(R.drawable.shape_gradient_name_level_31));
        return;
      } 
      if (paramInt == 32) {
        paramView.setBackground(paramContext.getResources().getDrawable(R.drawable.shape_gradient_name_level_32));
        return;
      } 
      if (paramInt == 33) {
        paramView.setBackground(paramContext.getResources().getDrawable(R.drawable.shape_gradient_name_level_33));
        return;
      } 
      if (paramInt == 34)
        paramView.setBackground(paramContext.getResources().getDrawable(R.drawable.shape_gradient_name_level_34)); 
    } 
  }
  
  private String b(int paramInt) {
    if (this.l > 0 && this.c.size() > 0) {
      int j;
      int k;
      byte b1 = -1;
      byte b = 0;
      int i = 0;
      while (true) {
        int[] arrayOfInt = this.j;
        j = b1;
        k = b;
        if (i < arrayOfInt.length) {
          j = DensityUtils.a(this.g, arrayOfInt[i]);
          k = DensityUtils.a(this.g, this.j[i]);
          int m = this.l;
          if (paramInt >= j && paramInt <= k + m) {
            j = i;
            k = b;
            break;
          } 
          i++;
          continue;
        } 
        break;
      } 
      while (k < this.c.size()) {
        if (j == ((Bubble)this.c.get(k)).s)
          return ((Bubble)this.c.get(k)).a; 
        k++;
      } 
    } 
    return "";
  }
  
  public int a(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? DensityUtils.a(this.g, this.j[0]) : DensityUtils.a(this.g, this.j[3])) : DensityUtils.a(this.g, this.j[2])) : DensityUtils.a(this.g, this.j[1])) : DensityUtils.a(this.g, this.j[0]);
  }
  
  public void a(ChattingModel paramChattingModel) {
    if (paramChattingModel != null)
      b(paramChattingModel); 
  }
  
  protected void a(ChattingModel paramChattingModel, int paramInt, Map<String, String> paramMap) {
    if (this.f == 0)
      this.f = getWidth(); 
    Bubble bubble = new Bubble();
    if (paramInt != 1) {
      if (paramInt != 2) {
        bubble.q = this.m;
      } else {
        bubble.q = this.o;
      } 
    } else {
      bubble.q = this.n;
    } 
    bubble.a(this.f);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramChattingModel.fromId);
    stringBuilder2.append("");
    bubble.a = stringBuilder2.toString();
    bubble.d = paramChattingModel.fromNickName;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramChattingModel.fromVBadge);
    stringBuilder2.append("");
    bubble.f = stringBuilder2.toString();
    bubble.e = paramChattingModel.msgContent;
    bubble.i = paramInt;
    bubble.b = paramChattingModel.fromAvatar;
    bubble.g = paramChattingModel.fromLiveManager;
    LiveFansLevelModel liveFansLevelModel = LiveMsgContentAdapter.e(paramChattingModel);
    if (liveFansLevelModel != null) {
      bubble.l = liveFansLevelModel.fan_club_name;
      bubble.k = liveFansLevelModel.fan_club_level;
      bubble.j = liveFansLevelModel.in_fan_club;
      bubble.m = liveFansLevelModel.fans_status;
    } 
    LiveLiangModel liveLiangModel = LiveUtils.b(paramChattingModel);
    if (liveLiangModel != null)
      bubble.n = liveLiangModel.liang_type; 
    if (paramInt == 1)
      if (paramMap != null) {
        bubble.o = "1".equals(paramMap.get("ifSuccess"));
      } else {
        bubble.o = false;
      }  
    if (bubble.a.equals(LiveRoomInfo.a().f())) {
      bubble.c = LiveRoomInfo.a().q();
    } else {
      bubble.c = paramChattingModel.fromRichLevel;
    } 
    bubble.r = null;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramChattingModel.fromId);
    stringBuilder1.append("");
    if (stringBuilder1.toString().equals(LiveRoomInfo.a().f()))
      bubble.h = true; 
    bubble.b(-(DensityUtils.a(this.g, 1.0F) + this.e.nextInt(DensityUtils.a(this.g, 1.0F))));
    if (paramInt == 1 || paramInt == 2)
      bubble.b(-DensityUtils.a(this.g, 3.0F)); 
    post(new Runnable(this, bubble) {
          public void run() {
            if (BarrageView.b(this.b).size() < this.b.a) {
              if (BarrageView.c(this.b).size() == 0) {
                this.a.s = this.b.getEmptyPosition();
                BarrageView.Bubble bubble = this.a;
                bubble.p = this.b.a(bubble.s);
                BarrageView.b(this.b).add(this.a);
              } else if (this.a.h) {
                BarrageView.c(this.b).add(0, this.a);
              } else if (BarrageView.c(this.b).size() < 130) {
                BarrageView.c(this.b).add(this.a);
              } 
              this.b.invalidate();
              return;
            } 
            if (this.a.h) {
              BarrageView.c(this.b).add(0, this.a);
              return;
            } 
            if (BarrageView.c(this.b).size() < 130)
              BarrageView.c(this.b).add(this.a); 
          }
        });
  }
  
  protected void b(ChattingModel paramChattingModel) {
    a(paramChattingModel, 0, (Map<String, String>)null);
  }
  
  public int getEmptyPosition() {
    if (this.c.size() < this.a) {
      StringBuffer stringBuffer = new StringBuffer();
      for (int i = 0; i < this.c.size(); i++)
        stringBuffer.append(((Bubble)this.c.get(i)).s); 
      String str = stringBuffer.toString();
      if (this.b && this.a > 1) {
        if (!str.contains("3"))
          return 3; 
        if (!str.contains("2"))
          return 2; 
        if (str.contains("1")) {
          str.contains("0");
          return 0;
        } 
      } else {
        return !str.contains("0") ? 0 : (!str.contains("1") ? 1 : (!str.contains("2") ? 2 : (!str.contains("3") ? 3 : 0)));
      } 
      return 1;
    } 
    return 0;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.c.size() > 0) {
      Iterator<Bubble> iterator = this.c.iterator();
      while (iterator.hasNext()) {
        Bubble bubble = iterator.next();
        if (bubble == null)
          continue; 
        Bitmap bitmap = bubble.a();
        if (bubble.b() + bubble.c() <= -(bitmap.getWidth() - bubble.c())) {
          if (this.d.size() > 0) {
            Bubble bubble1 = this.d.get(0);
            bubble.a = bubble1.a;
            bubble.d = bubble1.d;
            bubble.e = bubble1.e;
            bubble.a(bubble1.b());
            bubble.b(bubble1.c());
            bubble.r = bubble1.a();
            this.d.remove(0);
          } else {
            iterator.remove();
          } 
        } else {
          bubble.a(bubble.b() + bubble.c());
        } 
        paramCanvas.drawBitmap(bubble.a(), bubble.b(), bubble.p, this.h);
      } 
      invalidate();
    } 
  }
  
  public void setUserCard(PopUserCard paramPopUserCard) {
    this.k = paramPopUserCard;
  }
  
  class Bubble {
    public String a = "";
    
    public String b = "";
    
    public int c;
    
    public String d = "";
    
    public String e = "";
    
    public String f = "";
    
    public int g = 0;
    
    public boolean h = false;
    
    public int i = 0;
    
    public int j;
    
    public int k;
    
    public String l;
    
    public int m;
    
    public int n;
    
    public boolean o = false;
    
    public float p;
    
    public View q;
    
    public Bitmap r;
    
    public int s;
    
    private float u;
    
    private float v;
    
    private Bubble(BarrageView this$0) {}
    
    private void d() {
      TextView textView1 = (TextView)this.q.findViewById(R.id.tv_name);
      TextView textView2 = (TextView)this.q.findViewById(R.id.tv_content);
      LinearLayout linearLayout = (LinearLayout)this.q.findViewById(R.id.ll_content);
      ImageView imageView2 = (ImageView)this.q.findViewById(R.id.img_rich_rank);
      ImageView imageView3 = (ImageView)this.q.findViewById(R.id.img_manager_icon);
      ImageView imageView4 = (ImageView)this.q.findViewById(R.id.img_star_invisible);
      ImageView imageView5 = (ImageView)this.q.findViewById(R.id.img_star);
      ImageView imageView1 = (ImageView)this.q.findViewById(R.id.img_liang_id);
      if (this.g == 1) {
        imageView3.setVisibility(0);
      } else {
        imageView3.setVisibility(8);
      } 
      LiveBitmapUtils.a(BarrageView.d(this.t), imageView2, this.c);
      textView1.setText(this.d);
      textView2.setText(this.e);
      BarrageView.a(BarrageView.d(this.t), (View)linearLayout, this.c, this.h);
      if (this.c >= 30) {
        imageView4.setVisibility(4);
        imageView5.setVisibility(0);
        if (this.c >= 34) {
          imageView5.setImageResource(R.drawable.live_msg_list_star_wang);
        } else {
          imageView5.setImageResource(R.drawable.live_msg_list_star);
        } 
      } else {
        imageView4.setVisibility(8);
        imageView5.setVisibility(8);
      } 
      View view = this.q.findViewById(R.id.ll_level);
      if (this.j != 0) {
        view.setVisibility(0);
        textView2 = (TextView)this.q.findViewById(R.id.tv_level_num);
        TextView textView = (TextView)this.q.findViewById(R.id.tv_fans_name);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.k);
        stringBuilder.append("");
        textView2.setText(stringBuilder.toString());
        textView.setText(this.l);
        ImageView imageView = (ImageView)this.q.findViewById(R.id.iv_heart);
        int i = this.m;
        if (i == 1) {
          view.setBackgroundResource(R.drawable.live_fans_level_open_small_bg);
          imageView.setImageResource(R.drawable.live_fans_level_open_small_heart);
        } else if (i == 2) {
          view.setBackgroundResource(R.drawable.live_fans_level_disopen_small_bg);
          imageView.setImageResource(R.drawable.live_fans_level_disopen_small_heart);
        } 
      } else {
        view.setVisibility(8);
      } 
      if (this.n >= 2) {
        imageView1.setVisibility(0);
        imageView1.setImageResource(R.drawable.live_liang);
        return;
      } 
      imageView1.setVisibility(8);
    }
    
    private void e() {
      TextView textView1 = (TextView)this.q.findViewById(R.id.tv_name);
      TextView textView2 = (TextView)this.q.findViewById(R.id.tv_content_part1);
      TextView textView3 = (TextView)this.q.findViewById(R.id.tv_content_part2);
      LinearLayout linearLayout = (LinearLayout)this.q.findViewById(R.id.ll_content);
      ImageView imageView = (ImageView)this.q.findViewById(R.id.img_rich_rank);
      LiveBitmapUtils.a(BarrageView.d(this.t), imageView, this.c);
      LiveBitmapUtils.a(BarrageView.d(this.t), imageView, this.c);
      textView1.setText(this.d);
      if (this.o) {
        textView2.setText(BarrageView.d(this.t).getResources().getString(R.string.claw_game_success_part1));
        textView3.setText(BarrageView.d(this.t).getResources().getString(R.string.claw_game_success_part2));
        textView3.setVisibility(0);
        linearLayout.setBackground(BarrageView.d(this.t).getResources().getDrawable(R.drawable.shape_wawaji_result_success));
        return;
      } 
      textView2.setText(BarrageView.d(this.t).getResources().getString(R.string.claw_game_fail));
      textView3.setVisibility(8);
      linearLayout.setBackground(BarrageView.d(this.t).getResources().getDrawable(R.drawable.shape_wawaji_result_fail));
    }
    
    private void f() {
      ImageView imageView = (ImageView)this.q.findViewById(R.id.img_header);
      TextView textView1 = (TextView)this.q.findViewById(R.id.tv_name);
      TextView textView2 = (TextView)this.q.findViewById(R.id.tv_content);
      ImageLoader.a(null, this.b).a(R.drawable.user_bg_round).c().a(imageView);
      textView1.setText(this.d);
      textView2.setText(this.e);
    }
    
    public Bitmap a() {
      Bitmap bitmap = this.r;
      if (bitmap != null)
        return bitmap; 
      if (this.q != null) {
        int i = this.i;
        if (i != 1) {
          if (i != 2) {
            d();
          } else {
            f();
          } 
        } else {
          e();
        } 
        try {
          this.q.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          this.q.layout(0, 0, this.q.getMeasuredWidth(), this.q.getMeasuredHeight());
          BarrageView.a(this.t, Bitmap.createBitmap(this.q.getMeasuredWidth(), this.q.getMeasuredHeight(), Bitmap.Config.ARGB_8888));
          Canvas canvas = new Canvas(BarrageView.e(this.t));
          this.q.draw(canvas);
          this.r = BarrageView.e(this.t);
          return BarrageView.e(this.t);
        } catch (Exception exception) {
          return null;
        } 
      } 
      return null;
    }
    
    public void a(float param1Float) {
      this.v = param1Float;
    }
    
    public float b() {
      return this.v;
    }
    
    public void b(float param1Float) {
      this.u = param1Float;
    }
    
    public float c() {
      return this.u;
    }
  }
  
  static interface MSG_TYPE {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\BarrageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */