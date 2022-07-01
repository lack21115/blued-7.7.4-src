package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements GeneratedMessage.BuilderParent {
  private List<SingleFieldBuilder<MType, BType, IType>> builders;
  
  private BuilderExternalList<MType, BType, IType> externalBuilderList;
  
  private MessageExternalList<MType, BType, IType> externalMessageList;
  
  private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
  
  private boolean isClean;
  
  private boolean isMessagesListMutable;
  
  private List<MType> messages;
  
  private GeneratedMessage.BuilderParent parent;
  
  public RepeatedFieldBuilder(List<MType> paramList, boolean paramBoolean1, GeneratedMessage.BuilderParent paramBuilderParent, boolean paramBoolean2) {
    this.messages = paramList;
    this.isMessagesListMutable = paramBoolean1;
    this.parent = paramBuilderParent;
    this.isClean = paramBoolean2;
  }
  
  private void ensureBuilders() {
    if (this.builders == null) {
      this.builders = new ArrayList<SingleFieldBuilder<MType, BType, IType>>(this.messages.size());
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
    List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
    if (list == null)
      return this.messages.get(paramInt); 
    SingleFieldBuilder singleFieldBuilder = list.get(paramInt);
    return (MType)((singleFieldBuilder == null) ? (GeneratedMessage)this.messages.get(paramInt) : (paramBoolean ? singleFieldBuilder.build() : singleFieldBuilder.getMessage()));
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
      GeneratedMessage.BuilderParent builderParent = this.parent;
      if (builderParent != null) {
        builderParent.markDirty();
        this.isClean = false;
      } 
    } 
  }
  
  public RepeatedFieldBuilder<MType, BType, IType> addAllMessages(Iterable<? extends MType> paramIterable) {
    Iterator<? extends MType> iterator2 = paramIterable.iterator();
    while (iterator2.hasNext())
      Internal.checkNotNull((GeneratedMessage)iterator2.next()); 
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
    SingleFieldBuilder<MType, GeneratedMessage.Builder, MessageOrBuilder> singleFieldBuilder = new SingleFieldBuilder<MType, GeneratedMessage.Builder, MessageOrBuilder>(paramMType, this, this.isClean);
    this.messages.add(paramInt, null);
    this.builders.add(paramInt, singleFieldBuilder);
    onChanged();
    incrementModCounts();
    return (BType)singleFieldBuilder.getBuilder();
  }
  
  public BType addBuilder(MType paramMType) {
    ensureMutableMessageList();
    ensureBuilders();
    SingleFieldBuilder<MType, GeneratedMessage.Builder, MessageOrBuilder> singleFieldBuilder = new SingleFieldBuilder<MType, GeneratedMessage.Builder, MessageOrBuilder>(paramMType, this, this.isClean);
    this.messages.add(null);
    this.builders.add(singleFieldBuilder);
    onChanged();
    incrementModCounts();
    return (BType)singleFieldBuilder.getBuilder();
  }
  
  public RepeatedFieldBuilder<MType, BType, IType> addMessage(int paramInt, MType paramMType) {
    Internal.checkNotNull(paramMType);
    ensureMutableMessageList();
    this.messages.add(paramInt, paramMType);
    List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
    if (list != null)
      list.add(paramInt, null); 
    onChanged();
    incrementModCounts();
    return this;
  }
  
  public RepeatedFieldBuilder<MType, BType, IType> addMessage(MType paramMType) {
    Internal.checkNotNull(paramMType);
    ensureMutableMessageList();
    this.messages.add(paramMType);
    List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
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
          SingleFieldBuilder singleFieldBuilder = this.builders.get(j);
          if (singleFieldBuilder != null && singleFieldBuilder.build() != message) {
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
    List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
    if (list != null) {
      for (SingleFieldBuilder<MType, BType, IType> singleFieldBuilder : list) {
        if (singleFieldBuilder != null)
          singleFieldBuilder.dispose(); 
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
    SingleFieldBuilder<GeneratedMessage, GeneratedMessage.Builder, MessageOrBuilder> singleFieldBuilder2 = this.builders.get(paramInt);
    SingleFieldBuilder<GeneratedMessage, GeneratedMessage.Builder, MessageOrBuilder> singleFieldBuilder1 = singleFieldBuilder2;
    if (singleFieldBuilder2 == null) {
      singleFieldBuilder1 = new SingleFieldBuilder<GeneratedMessage, GeneratedMessage.Builder, MessageOrBuilder>((GeneratedMessage)this.messages.get(paramInt), this, this.isClean);
      this.builders.set(paramInt, singleFieldBuilder1);
    } 
    return (BType)singleFieldBuilder1.getBuilder();
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
    List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
    if (list == null)
      return (IType)this.messages.get(paramInt); 
    SingleFieldBuilder singleFieldBuilder = list.get(paramInt);
    return (IType)((singleFieldBuilder == null) ? (MessageOrBuilder)this.messages.get(paramInt) : singleFieldBuilder.getMessageOrBuilder());
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
    List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
    if (list != null) {
      SingleFieldBuilder singleFieldBuilder = list.remove(paramInt);
      if (singleFieldBuilder != null)
        singleFieldBuilder.dispose(); 
    } 
    onChanged();
    incrementModCounts();
  }
  
  public RepeatedFieldBuilder<MType, BType, IType> setMessage(int paramInt, MType paramMType) {
    Internal.checkNotNull(paramMType);
    ensureMutableMessageList();
    this.messages.set(paramInt, paramMType);
    List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
    if (list != null) {
      SingleFieldBuilder singleFieldBuilder = list.set(paramInt, null);
      if (singleFieldBuilder != null)
        singleFieldBuilder.dispose(); 
    } 
    onChanged();
    incrementModCounts();
    return this;
  }
  
  static class BuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements List<BType> {
    RepeatedFieldBuilder<MType, BType, IType> builder;
    
    BuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> param1RepeatedFieldBuilder) {
      this.builder = param1RepeatedFieldBuilder;
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
  
  static class MessageExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements List<MType> {
    RepeatedFieldBuilder<MType, BType, IType> builder;
    
    MessageExternalList(RepeatedFieldBuilder<MType, BType, IType> param1RepeatedFieldBuilder) {
      this.builder = param1RepeatedFieldBuilder;
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
  
  static class MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements List<IType> {
    RepeatedFieldBuilder<MType, BType, IType> builder;
    
    MessageOrBuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> param1RepeatedFieldBuilder) {
      this.builder = param1RepeatedFieldBuilder;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\RepeatedFieldBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */