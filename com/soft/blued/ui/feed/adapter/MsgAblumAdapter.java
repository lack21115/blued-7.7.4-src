package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import java.util.ArrayList;
import java.util.List;

public class MsgAblumAdapter extends RecyclerView.Adapter<MsgAblumAdapter.AblumHolder> {
  protected Context a;
  
  private IRequestHost b;
  
  private int c = -1;
  
  private List<ChildImageInfo> d = new ArrayList<ChildImageInfo>();
  
  private List<AblumHolder> e = new ArrayList<AblumHolder>();
  
  private RecyclerView f;
  
  private OnItemClickListener g;
  
  public MsgAblumAdapter(Context paramContext, IRequestHost paramIRequestHost, RecyclerView paramRecyclerView, ChildImageInfo paramChildImageInfo) {
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.f = paramRecyclerView;
    this.d.addAll(SelectPhotoManager.a().c());
    if (paramChildImageInfo != null) {
      int i;
      for (i = 0; i < this.d.size(); i++) {
        if (TextUtils.equals(((ChildImageInfo)this.d.get(i)).mImagePath, paramChildImageInfo.mImagePath)) {
          this.c = i;
          break;
        } 
      } 
    } 
    if (this.d.size() == 0) {
      paramRecyclerView.setVisibility(8);
    } else {
      paramRecyclerView.setVisibility(0);
    } 
    notifyDataSetChanged();
  }
  
  public AblumHolder a(ViewGroup paramViewGroup, int paramInt) {
    View view = LayoutInflater.from(this.a).inflate(2131493949, paramViewGroup, false);
    AblumHolder ablumHolder = new AblumHolder(this, view);
    ablumHolder.p = (ImageView)view.findViewById(2131299299);
    ablumHolder.q = view.findViewById(2131299300);
    this.e.add(ablumHolder);
    return ablumHolder;
  }
  
  public void a(AblumHolder paramAblumHolder, int paramInt) {
    if (paramInt >= this.d.size())
      return; 
    if (paramInt == this.c) {
      paramAblumHolder.q.setVisibility(0);
    } else {
      paramAblumHolder.q.setVisibility(8);
    } 
    paramAblumHolder.r = ((ChildImageInfo)this.d.get(paramInt)).mImagePath;
    ImageLoader.d(this.b, ((ChildImageInfo)this.d.get(paramInt)).mImagePath).a(2131231369).a(6.0F).a(paramAblumHolder.p);
    String str = ((ChildImageInfo)this.d.get(paramInt)).mImagePath;
    paramAblumHolder.p.setOnClickListener(new View.OnClickListener(this, str) {
          public void onClick(View param1View) {
            for (int i = 0; i < MsgAblumAdapter.a(this.b).size(); i++) {
              if (TextUtils.equals(((ChildImageInfo)MsgAblumAdapter.a(this.b).get(i)).mImagePath, this.a)) {
                MsgAblumAdapter.a(this.b, i);
                break;
              } 
            } 
            if (MsgAblumAdapter.b(this.b) >= 0 && MsgAblumAdapter.b(this.b) < MsgAblumAdapter.a(this.b).size()) {
              MsgAblumAdapter msgAblumAdapter = this.b;
              msgAblumAdapter.d(MsgAblumAdapter.a(msgAblumAdapter).get(MsgAblumAdapter.b(this.b)));
              if (MsgAblumAdapter.c(this.b) != null)
                MsgAblumAdapter.c(this.b).a(MsgAblumAdapter.a(this.b).get(MsgAblumAdapter.b(this.b))); 
            } 
          }
        });
  }
  
  public void a(OnItemClickListener paramOnItemClickListener) {
    this.g = paramOnItemClickListener;
  }
  
  public void a(ChildImageInfo paramChildImageInfo) {
    if (paramChildImageInfo == null)
      return; 
    ChildImageInfo childImageInfo = new ChildImageInfo(paramChildImageInfo);
    this.d.add(childImageInfo);
    this.c = this.d.size() - 1;
    if (this.d.size() == 1) {
      notifyDataSetChanged();
    } else {
      notifyItemInserted(this.d.size() - 1);
      d(paramChildImageInfo);
    } 
    if (this.f.getVisibility() != 0)
      this.f.setVisibility(0); 
  }
  
  public void b(ChildImageInfo paramChildImageInfo) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_0
    //   6: iconst_m1
    //   7: putfield c : I
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: aload_0
    //   14: getfield d : Ljava/util/List;
    //   17: invokeinterface size : ()I
    //   22: if_icmpge -> 61
    //   25: aload_0
    //   26: getfield d : Ljava/util/List;
    //   29: iload_2
    //   30: invokeinterface get : (I)Ljava/lang/Object;
    //   35: checkcast com/soft/blued/ui/feed/model/ChildImageInfo
    //   38: getfield mImagePath : Ljava/lang/String;
    //   41: aload_1
    //   42: getfield mImagePath : Ljava/lang/String;
    //   45: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   48: ifeq -> 54
    //   51: goto -> 63
    //   54: iload_2
    //   55: iconst_1
    //   56: iadd
    //   57: istore_2
    //   58: goto -> 12
    //   61: iconst_m1
    //   62: istore_2
    //   63: iload_2
    //   64: iconst_m1
    //   65: if_icmpeq -> 89
    //   68: aload_0
    //   69: getfield d : Ljava/util/List;
    //   72: iload_2
    //   73: invokeinterface remove : (I)Ljava/lang/Object;
    //   78: pop
    //   79: aload_0
    //   80: iload_2
    //   81: invokevirtual notifyItemRemoved : (I)V
    //   84: aload_0
    //   85: aload_1
    //   86: invokevirtual d : (Lcom/soft/blued/ui/feed/model/ChildImageInfo;)V
    //   89: aload_0
    //   90: getfield d : Ljava/util/List;
    //   93: invokeinterface size : ()I
    //   98: ifne -> 120
    //   101: aload_0
    //   102: getfield f : Landroidx/recyclerview/widget/RecyclerView;
    //   105: invokevirtual getVisibility : ()I
    //   108: ifne -> 120
    //   111: aload_0
    //   112: getfield f : Landroidx/recyclerview/widget/RecyclerView;
    //   115: bipush #8
    //   117: invokevirtual setVisibility : (I)V
    //   120: return
  }
  
  public void c(ChildImageInfo paramChildImageInfo) {
    for (int i = 0; i < this.d.size(); i++) {
      if (TextUtils.equals(((ChildImageInfo)this.d.get(i)).mImagePath, paramChildImageInfo.mImagePath)) {
        this.c = i;
        this.f.scrollToPosition(i);
        break;
      } 
    } 
    d(paramChildImageInfo);
  }
  
  public void d(ChildImageInfo paramChildImageInfo) {
    for (AblumHolder ablumHolder : this.e) {
      if (TextUtils.equals(ablumHolder.r, paramChildImageInfo.mImagePath)) {
        ablumHolder.q.setVisibility(0);
        continue;
      } 
      ablumHolder.q.setVisibility(8);
    } 
  }
  
  public int getItemCount() {
    List<ChildImageInfo> list = this.d;
    return (list == null) ? 0 : list.size();
  }
  
  class AblumHolder extends RecyclerView.ViewHolder {
    ImageView p;
    
    View q;
    
    String r;
    
    public AblumHolder(MsgAblumAdapter this$0, View param1View) {
      super(param1View);
    }
  }
  
  public static interface OnItemClickListener {
    void a(ChildImageInfo param1ChildImageInfo);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\MsgAblumAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */