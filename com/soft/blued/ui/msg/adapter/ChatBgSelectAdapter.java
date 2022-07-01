package com.soft.blued.ui.msg.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.das.vip.VipProtos;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.msg.contract.IChatBgSelectOptionCallback;
import com.soft.blued.ui.msg.manager.ChatBgManager;
import com.soft.blued.ui.msg.model.MsgChattingBgModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ChatBgSelectAdapter extends RecyclerView.Adapter {
  private static List<String> d = new ArrayList<String>();
  
  private IRequestHost a;
  
  private IChatBgSelectOptionCallback b;
  
  private List<MsgChattingBgModel> c;
  
  private LoadOptions e;
  
  public ChatBgSelectAdapter(IRequestHost paramIRequestHost, IChatBgSelectOptionCallback paramIChatBgSelectOptionCallback) {
    this.b = paramIChatBgSelectOptionCallback;
    this.a = paramIRequestHost;
  }
  
  private void a(Context paramContext, View paramView) {
    paramView.startAnimation(AnimationUtils.loadAnimation(paramContext, 2130772027));
  }
  
  private void a(View paramView) {
    if (paramView != null)
      paramView.clearAnimation(); 
  }
  
  public void a(List<MsgChattingBgModel> paramList) {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public int getItemCount() {
    List<MsgChattingBgModel> list = this.c;
    return (list == null) ? 0 : list.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    List<MsgChattingBgModel> list = this.c;
    if (list != null && list.size() > 0) {
      paramViewHolder = paramViewHolder;
      MsgChattingBgModel msgChattingBgModel = this.c.get(paramInt);
      if (paramViewHolder != null && msgChattingBgModel != null)
        paramViewHolder.a(msgChattingBgModel); 
    } 
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return new ViewHolder(this, LayoutInflater.from(this.b.a()).inflate(2131494225, null));
  }
  
  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ImageView q;
    
    private ImageView r;
    
    private MsgChattingBgModel s;
    
    private int t;
    
    public ViewHolder(ChatBgSelectAdapter this$0, View param1View) {
      super(param1View);
      this.q = (ImageView)param1View.findViewById(2131296699);
      this.r = (ImageView)param1View.findViewById(2131296698);
      param1View.setOnClickListener(this);
    }
    
    private void a(View param1View, ImageView param1ImageView, MsgChattingBgModel param1MsgChattingBgModel) {
      if (param1View != null)
        param1View.setEnabled(false); 
      if (param1ImageView != null) {
        param1ImageView.setVisibility(0);
        param1ImageView.setImageResource(2131231241);
        ChatBgSelectAdapter.a(this.p, param1ImageView.getContext(), (View)param1ImageView);
      } 
      FileDownloader.a(param1MsgChattingBgModel.getUrl(), ChatBgManager.c(param1MsgChattingBgModel.getUrl()), new FileHttpResponseHandler(this, param1MsgChattingBgModel, param1View, param1ImageView) {
            boolean a = false;
            
            public void a(File param2File) {
              if (ChatBgSelectAdapter.a() != null)
                ChatBgSelectAdapter.a().remove(this.b.getUrl()); 
            }
            
            public void a(Throwable param2Throwable, int param2Int, File param2File) {
              super.onFailure(param2Throwable, param2Int, param2File);
              this.a = true;
              if (ChatBgSelectAdapter.a() != null)
                ChatBgSelectAdapter.a().remove(this.b.getUrl()); 
            }
            
            public void onCancel() {
              super.onCancel();
              this.a = true;
              if (ChatBgSelectAdapter.a() != null)
                ChatBgSelectAdapter.a().remove(this.b.getUrl()); 
            }
            
            public void onFinish() {
              super.onFinish();
              if (ChatBgSelectAdapter.a() != null)
                ChatBgSelectAdapter.a().remove(this.b.getUrl()); 
              AppInfo.n().post(new Runnable(this) {
                    public void run() {
                      if (this.a.c != null)
                        this.a.c.setEnabled(true); 
                      if (this.a.d != null) {
                        ChatBgSelectAdapter.a(this.a.e.p, (View)this.a.d);
                        if (!this.a.a) {
                          if (this.a.e.a(this.a.b.getUrl())) {
                            this.a.d.setVisibility(8);
                            ChatBgSelectAdapter.ViewHolder.a(this.a.e, 3);
                            return;
                          } 
                          this.a.d.setVisibility(0);
                          ChatBgSelectAdapter.ViewHolder.a(this.a.e).setImageResource(2131231242);
                          return;
                        } 
                        this.a.d.setVisibility(0);
                        ChatBgSelectAdapter.ViewHolder.a(this.a.e).setImageResource(2131231242);
                      } 
                    }
                  });
            }
            
            public void onStart() {
              super.onStart();
              if (ChatBgSelectAdapter.a() != null)
                ChatBgSelectAdapter.a().add(this.b.getUrl()); 
            }
          }ChatBgSelectAdapter.b(this.p).aU_());
    }
    
    public void a(MsgChattingBgModel param1MsgChattingBgModel) {
      this.s = param1MsgChattingBgModel;
      if (param1MsgChattingBgModel != null) {
        if (param1MsgChattingBgModel.type == 1) {
          ImageLoader.a(ChatBgSelectAdapter.a(this.p), 2131100533).a(3.0F).a(this.q);
          if (ChatBgSelectAdapter.b(this.p).d()) {
            this.r.setVisibility(8);
            return;
          } 
          this.t = 4;
          this.r.setVisibility(0);
          this.r.setImageResource(2131233447);
          return;
        } 
        if (!TextUtils.isEmpty(param1MsgChattingBgModel.getUrl())) {
          if (ChatBgSelectAdapter.c(this.p) == null) {
            ChatBgSelectAdapter.a(this.p, new LoadOptions());
            (ChatBgSelectAdapter.c(this.p)).d = 2131232201;
            (ChatBgSelectAdapter.c(this.p)).b = 2131232201;
            (ChatBgSelectAdapter.c(this.p)).j = true;
            (ChatBgSelectAdapter.c(this.p)).l = false;
          } 
          ImageLoader.a(ChatBgSelectAdapter.a(this.p), param1MsgChattingBgModel.getPreview()).a(2131232201).a(3.0F).a(this.q);
          if (a(param1MsgChattingBgModel.getUrl())) {
            this.t = 3;
            if (ChatBgSelectAdapter.b(this.p).a(RecyclingUtils.Scheme.c.b(ChatBgManager.c(this.s.getUrl())))) {
              this.t = 4;
              this.r.setVisibility(0);
              this.r.setImageResource(2131233447);
              return;
            } 
            this.r.setVisibility(8);
            return;
          } 
          if (ChatBgSelectAdapter.a().contains(param1MsgChattingBgModel.getUrl())) {
            this.t = 2;
            this.r.setVisibility(0);
            this.r.setImageResource(2131231241);
            return;
          } 
          this.t = 1;
          this.r.setVisibility(0);
          this.r.setImageResource(2131231242);
        } 
      } 
    }
    
    public boolean a(String param1String) {
      return (new File(ChatBgManager.c(param1String))).exists();
    }
    
    public void onClick(View param1View) {
      MsgChattingBgModel msgChattingBgModel = this.s;
      if (msgChattingBgModel != null)
        if (msgChattingBgModel.type == 1) {
          EventTrackVIP.a(VipProtos.Event.VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK);
          this.r.setImageResource(2131233447);
          if (ChatBgSelectAdapter.b(this.p) != null) {
            ChatBgSelectAdapter.b(this.p).b("default");
            return;
          } 
        } else {
          EventTrackVIP.b(VipProtos.Event.VIP_BACKFROUND_CHOOSE_SYSTEM_BTN_CLICK, this.s.getUrl());
          int i = this.t;
          if (i == 1) {
            a(this.itemView, this.r, this.s);
            return;
          } 
          if (i == 3) {
            this.r.setImageResource(2131233447);
            if (ChatBgSelectAdapter.b(this.p) != null)
              ChatBgSelectAdapter.b(this.p).b(RecyclingUtils.Scheme.c.b(ChatBgManager.c(this.s.getUrl()))); 
          } 
        }  
    }
  }
  
  class null extends FileHttpResponseHandler {
    boolean a = false;
    
    null(ChatBgSelectAdapter this$0, MsgChattingBgModel param1MsgChattingBgModel, View param1View, ImageView param1ImageView) {}
    
    public void a(File param1File) {
      if (ChatBgSelectAdapter.a() != null)
        ChatBgSelectAdapter.a().remove(this.b.getUrl()); 
    }
    
    public void a(Throwable param1Throwable, int param1Int, File param1File) {
      super.onFailure(param1Throwable, param1Int, param1File);
      this.a = true;
      if (ChatBgSelectAdapter.a() != null)
        ChatBgSelectAdapter.a().remove(this.b.getUrl()); 
    }
    
    public void onCancel() {
      super.onCancel();
      this.a = true;
      if (ChatBgSelectAdapter.a() != null)
        ChatBgSelectAdapter.a().remove(this.b.getUrl()); 
    }
    
    public void onFinish() {
      super.onFinish();
      if (ChatBgSelectAdapter.a() != null)
        ChatBgSelectAdapter.a().remove(this.b.getUrl()); 
      AppInfo.n().post(new Runnable(this) {
            public void run() {
              if (this.a.c != null)
                this.a.c.setEnabled(true); 
              if (this.a.d != null) {
                ChatBgSelectAdapter.a(this.a.e.p, (View)this.a.d);
                if (!this.a.a) {
                  if (this.a.e.a(this.a.b.getUrl())) {
                    this.a.d.setVisibility(8);
                    ChatBgSelectAdapter.ViewHolder.a(this.a.e, 3);
                    return;
                  } 
                  this.a.d.setVisibility(0);
                  ChatBgSelectAdapter.ViewHolder.a(this.a.e).setImageResource(2131231242);
                  return;
                } 
                this.a.d.setVisibility(0);
                ChatBgSelectAdapter.ViewHolder.a(this.a.e).setImageResource(2131231242);
              } 
            }
          });
    }
    
    public void onStart() {
      super.onStart();
      if (ChatBgSelectAdapter.a() != null)
        ChatBgSelectAdapter.a().add(this.b.getUrl()); 
    }
  }
  
  class null implements Runnable {
    public void run() {
      if (this.a.c != null)
        this.a.c.setEnabled(true); 
      if (this.a.d != null) {
        ChatBgSelectAdapter.a(this.a.e.p, (View)this.a.d);
        if (!this.a.a) {
          if (this.a.e.a(this.a.b.getUrl())) {
            this.a.d.setVisibility(8);
            ChatBgSelectAdapter.ViewHolder.a(this.a.e, 3);
            return;
          } 
          this.a.d.setVisibility(0);
          ChatBgSelectAdapter.ViewHolder.a(this.a.e).setImageResource(2131231242);
          return;
        } 
        this.a.d.setVisibility(0);
        ChatBgSelectAdapter.ViewHolder.a(this.a.e).setImageResource(2131231242);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\ChatBgSelectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */