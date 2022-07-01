package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RepeatedFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
  private List<SingleFieldBuilderV3<MType, BType, IType>> builders;
  
  private BuilderExternalList<MType, BType, IType> externalBuilderList;
  
  private MessageExternalList<MType, BType, IType> externalMessageList;
  
  private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
  
  private boolean isClean;
  
  private boolean isMessagesListMutable;
  
  private List<MType> messages;
  
  private AbstractMessage.BuilderParent parent;
  
  public RepeatedFieldBuilderV3(List<MType> paramList, boolean paramBoolean1, AbstractMessage.BuilderParent paramBuilderParent, boolean paramBoolean2) {
    this.messages = paramList;
    this.isMessagesListMutable = paramBoolean1;
    this.parent = paramBuilderParent;
    this.isClean = paramBoolean2;
  }
  
  private void ensureBuilders() {
    if (this.builders == null) {
      this.builders = new ArrayList<SingleFieldBuilderV3<MType, BType, IType>>(this.messages.size());
      for (int i = 0; i < this.messages.size(); i++)
        this.builders.add(null); 
    } 
  }
  
  private void ensureMutableMessageList() {
    if (!this.isMessagesListMutable) {
      this.messages = new ArrayList<MType>(this.messages);
      this.isMessagesListMutable = true;
    } 
  }
  
  private MType getMessage(int paramInt, boolean paramBoolean) {
    List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
    if (list == null)
      return this.messages.get(paramInt); 
    SingleFieldBuilderV3 singleFieldBuilderV3 = list.get(paramInt);
    return (MType)((singleFieldBuilderV3 == null) ? (AbstractMessage)this.messages.get(paramInt) : (paramBoolean ? singleFieldBuilderV3.build() : singleFieldBuilderV3.getMessage()));
  }
  
  private void incrementModCounts() {
    MessageExternalList<MType, BType, IType> messageExternalList = this.externalMessageList;
    if (messageExternalList != null)
      messageExternalList.incrementModCount(); 
    BuilderExternalList<MType, BType, IType> builderExternalList = this.externalBuilderList;
    if (builderExternalList != null)
      builderExternalList.incrementModCount(); 
    MessageOrBuilderExternalList<MType, BType, IType> messageOrBuilderExternalList = this.externalMessageOrBuilderList;
    if (messageOrBuilderExternalList != null)
      messageOrBuilderExternalList.incrementModCount(); 
  }
  
  private void onChanged() {
    if (this.isClean) {
      AbstractMessage.BuilderParent builderParent = this.parent;
      if (builderParent != null) {
        builderParent.markDirty();
        this.isClean = false;
      } 
    } 
  }
  
  public RepeatedFieldBuilderV3<MType, BType, IType> addAllMessages(Iterable<? extends MType> paramIterable) {
    Iterator<? extends MType> iterator2 = paramIterable.iterator();
    while (iterator2.hasNext())
      Internal.checkNotNull((AbstractMessage)iterator2.next()); 
    int i = -1;
    if (paramIterable instanceof Collection) {
      Collection collection = (Collection)paramIterable;
      if (collection.isEmpty())
        return this; 
      i = collection.size();
    } 
    ensureMutableMessageList();
    if (i >= 0) {
      List<MType> list = this.messages;
      if (list instanceof ArrayList)
        ((ArrayList)list).ensureCapacity(list.size() + i); 
    } 
    Iterator<? extends MType> iterator1 = paramIterable.iterator();
    while (iterator1.hasNext())
      addMessage(iterator1.next()); 
    onChanged();
    incrementModCounts();
    return this;
  }
  
  public BType addBuilder(int paramInt, MType paramMType) {
    ensureMutableMessageList();
    ensureBuilders();
    SingleFieldBuilderV3<MType, AbstractMessage.Builder, MessageOrBuilder> singleFieldBuilderV3 = new SingleFieldBuilderV3<MType, AbstractMessage.Builder, MessageOrBuilder>(paramMType, this, this.isClean);
    this.messages.add(paramInt, null);
    this.builders.add(paramInt, singleFieldBuilderV3);
    onChanged();
    incrementModCounts();
    return (BType)singleFieldBuilderV3.getBuilder();
  }
  
  public BType addBuilder(MType paramMType) {
    ensureMutableMessageList();
    ensureBuilders();
    SingleFieldBuilderV3<MType, AbstractMessage.Builder, MessageOrBuilder> singleFieldBuilderV3 = new SingleFieldBuilderV3<MType, AbstractMessage.Builder, MessageOrBuilder>(paramMType, this, this.isClean);
    this.messages.add(null);
    this.builders.add(singleFieldBuilderV3);
    onChanged();
    incrementModCounts();
    return (BType)singleFieldBuilderV3.getBuilder();
  }
  
  public RepeatedFieldBuilderV3<MType, BType, IType> addMessage(int paramInt, MType paramMType) {
    Internal.checkNotNull(paramMType);
    ensureMutableMessageList();
    this.messages.add(paramInt, paramMType);
    List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
    if (list != null)
      list.add(paramInt, null); 
    onChanged();
    incrementModCounts();
    return this;
  }
  
  public RepeatedFieldBuilderV3<MType, BType, IType> addMessage(MType paramMType) {
    Internal.checkNotNull(paramMType);
    ensureMutableMessageList();
    this.messages.add(paramMType);
    List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
    if (list != null)
      list.add(null); 
    onChanged();
    incrementModCounts();
    return this;
  }
  
  public List<MType> build() {
    this.isClean = true;
    if (!this.isMessagesListMutable && this.builders == null)
      return this.messages; 
    if (!this.isMessagesListMutable) {
      int j = 0;
      while (true) {
        if (j < this.messages.size()) {
          Message message = (Message)this.messages.get(j);
          SingleFieldBuilderV3 singleFieldBuilderV3 = this.builders.get(j);
          if (singleFieldBuilderV3 != null && singleFieldBuilderV3.build() != message) {
            j = 0;
            break;
          } 
          j++;
          continue;
        } 
        j = 1;
        break;
      } 
      if (j != 0)
        return this.messages; 
    } 
    ensureMutableMessageList();
    for (int i = 0; i < this.messages.size(); i++)
      this.messages.set(i, getMessage(i, true)); 
    this.messages = Collections.unmodifiableList(this.messages);
    this.isMessagesListMutable = false;
    return this.messages;
  }
  
  public void clear() {
    this.messages = Collections.emptyList();
    this.isMessagesListMutable = false;
    List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
    if (list != null) {
      for (SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 : list) {
        if (singleFieldBuilderV3 != null)
          singleFieldBuilderV3.dispose(); 
      } 
      this.builders = null;
    } 
    onChanged();
    incrementModCounts();
  }
  
  public void dispose() {
    this.parent = null;
  }
  
  public BType getBuilder(int paramInt) {
    ensureBuilders();
    SingleFieldBuilderV3<AbstractMessage, AbstractMessage.Builder, MessageOrBuilder> singleFieldBuilderV32 = this.builders.get(paramInt);
    SingleFieldBuilderV3<AbstractMessage, AbstractMessage.Builder, MessageOrBuilder> singleFieldBuilderV31 = singleFieldBuilderV32;
    if (singleFieldBuilderV32 == null) {
      singleFieldBuilderV31 = new SingleFieldBuilderV3<AbstractMessage, AbstractMessage.Builder, MessageOrBuilder>((AbstractMessage)this.messages.get(paramInt), this, this.isClean);
      this.builders.set(paramInt, singleFieldBuilderV31);
    } 
    return (BType)singleFieldBuilderV31.getBuilder();
  }
  
  public List<BType> getBuilderList() {
    if (this.externalBuilderList == null)
      this.externalBuilderList = new BuilderExternalList<MType, BType, IType>(this); 
    return this.externalBuilderList;
  }
  
  public int getCount() {
    return this.messages.size();
  }
  
  public MType getMessage(int paramInt) {
    return getMessage(paramInt, false);
  }
  
  public List<MType> getMessageList() {
    if (this.externalMessageList == null)
      this.externalMessageList = new MessageExternalList<MType, BType, IType>(this); 
    return this.externalMessageList;
  }
  
  public IType getMessageOrBuilder(int paramInt) {
    List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
    if (list == null)
      return (IType)this.messages.get(paramInt); 
    SingleFieldBuilderV3 singleFieldBuilderV3 = list.get(paramInt);
    return (IType)((singleFieldBuilderV3 == null) ? (MessageOrBuilder)this.messages.get(paramInt) : singleFieldBuilderV3.getMessageOrBuilder());
  }
  
  public List<IType> getMessageOrBuilderList() {
    if (this.externalMessageOrBuilderList == null)
      this.externalMessageOrBuilderList = new MessageOrBuilderExternalList<MType, BType, IType>(this); 
    return this.externalMessageOrBuilderList;
  }
  
  public boolean isEmpty() {
    return this.messages.isEmpty();
  }
  
  public void markDirty() {
    onChanged();
  }
  
  public void remove(int paramInt) {
    ensureMutableMessageList();
    this.messages.remove(paramInt);
    List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
    if (list != null) {
      SingleFieldBuilderV3 singleFieldBuilderV3 = list.remove(paramInt);
      if (singleFieldBuilderV3 != null)
        singleFieldBuilderV3.dispose(); 
    } 
    onChanged();
    incrementModCounts();
  }
  
  public RepeatedFieldBuilderV3<MType, BType, IType> setMessage(int paramInt, MType paramMType) {
    Internal.checkNotNull(paramMType);
    ensureMutableMessageList();
    this.messages.set(paramInt, paramMType);
    List<SingleFieldBuilderV3<MType, BType, IType>> list = this.builders;
    if (list != null) {
      SingleFieldBuilderV3 singleFieldBuilderV3 = list.set(paramInt, null);
      if (singleFieldBuilderV3 != null)
        singleFieldBuilderV3.dispose(); 
    } 
    onChanged();
    incrementModCounts();
    return this;
  }
  
  static class BuilderExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements List<BType> {
    RepeatedFieldBuilderV3<MType, BType, IType> builder;
    
    BuilderExternalList(RepeatedFieldBuilderV3<MType, BType, IType> param1RepeatedFieldBuilderV3) {
      this.builder = param1RepeatedFieldBuilderV3;
    }
    
    public BType get(int param1Int) {
      return this.builder.getBuilder(param1Int);
    }
    
    void incrementModCount() {
      this.modCount++;
    }
    
    public int size() {
      return this.builder.getCount();
    }
  }
  
  static class MessageExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements List<MType> {
    RepeatedFieldBuilderV3<MType, BType, IType> builder;
    
    MessageExternalList(RepeatedFieldBuilderV3<MType, BType, IType> param1RepeatedFieldBuilderV3) {
      this.builder = param1RepeatedFieldBuilderV3;
    }
    
    public MType get(int param1Int) {
      return this.builder.getMessage(param1Int);
    }
    
    void incrementModCount() {
      this.modCount++;
    }
    
    public int size() {
      return this.builder.getCount();
    }
  }
  
  static class MessageOrBuilderExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements List<IType> {
    RepeatedFieldBuilderV3<MType, BType, IType> builder;
    
    MessageOrBuilderExternalList(RepeatedFieldBuilderV3<MType, BType, IType> param1RepeatedFieldBuilderV3) {
      this.builder = param1RepeatedFieldBuilderV3;
    }
    
    public IType get(int param1Int) {
      return this.builder.getMessageOrBuilder(param1Int);
    }
    
    void incrementModCount() {
      this.modCount++;
    }
    
    public int size() {
      return this.builder.getCount();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\RepeatedFieldBuilderV3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */