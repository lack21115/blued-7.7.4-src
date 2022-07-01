package com.soft.blued.ui.circle.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import java.util.List;

public class CircleTextVoteEditPresenter extends MvpPresenter {
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      String str = paramBundle1.getString("circle_vote_title");
      List list = (List)paramBundle1.getSerializable("circle_vote_content");
      a("title", str);
      a("content", list);
    } 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\presenter\CircleTextVoteEditPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */