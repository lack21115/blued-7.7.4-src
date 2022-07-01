package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import java.util.List;

public class VisitorGitVipAvatarAdapter extends BaseQuickAdapter<BluedMyVisitorList.ProfilePicture, BaseViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  public VisitorGitVipAvatarAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493693, null);
    this.a = paramContext;
    this.b = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedMyVisitorList.ProfilePicture paramProfilePicture) {
    if (paramBaseViewHolder != null && paramBaseViewHolder.getAdapterPosition() != -1) {
      int j = paramBaseViewHolder.getAdapterPosition();
      List list = n();
      ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297433);
      ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297434);
      ImageLoader.a(this.b, ((BluedMyVisitorList.ProfilePicture)list.get(j)).url).a(2131234358).a(2.0F, this.a.getResources().getColor(2131100528)).a(imageView2);
      int i = list.size();
      if (i > ++j)
        ImageLoader.a(this.b, ((BluedMyVisitorList.ProfilePicture)list.get(j)).url).a(2131234358).a(2.0F, this.a.getResources().getColor(2131100528)).a(imageView1); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\VisitorGitVipAvatarAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */