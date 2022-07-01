package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingDeque;
import java.util.concurrent.BlockingDeque;

public abstract class ForwardingBlockingDeque<E> extends ForwardingDeque<E> implements BlockingDeque<E> {}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ForwardingBlockingDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */