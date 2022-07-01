package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.widget.SectionIndexer;

class SectionIndexerAdapterWrapper extends AdapterWrapper implements SectionIndexer {
  final SectionIndexer b;
  
  SectionIndexerAdapterWrapper(Context paramContext, StickyListHeadersAdapter paramStickyListHeadersAdapter) {
    super(paramContext, paramStickyListHeadersAdapter);
    this.b = (SectionIndexer)paramStickyListHeadersAdapter;
  }
  
  public int getPositionForSection(int paramInt) {
    return this.b.getPositionForSection(paramInt);
  }
  
  public int getSectionForPosition(int paramInt) {
    return this.b.getSectionForPosition(paramInt);
  }
  
  public Object[] getSections() {
    return this.b.getSections();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickylistheaders\SectionIndexerAdapterWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */