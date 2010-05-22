// Modified or written by Ex Machina SAGL for inclusion with lambdaj.
// Copyright (c) 2009 Mario Fusco.
// Licensed under the Apache License, Version 2.0 (the "License")

package ch.lambdaj.collection;

import org.hamcrest.*;

import java.util.*;

import ch.lambdaj.function.convert.*;

/**
 * @author Gianfranco Tognana
 * @author Mario Fusco
 */
public class LambdaList<T> extends LambdaCollection<T> implements List<T> {

	LambdaList(List<? extends T> inner, Class<T> type) {
        super(inner, type);
	}

    private List<T> innerList() {
        return (List<T>) innerIterable;
    }

    /**
     * {@inheritDoc}
     */
    public LambdaList<T> filter(Matcher<?> matcher) {
        return new LambdaList<T>(doFilter(matcher), type);
    }

    /**
     * {@inheritDoc}
     */
    public <V> LambdaList<V> convert(Converter<T, V> converter) {
        return new LambdaList<V>(doConvert(converter), null);
    }

    /**
     * {@inheritDoc}
     */
    public <V> LambdaList<V> extract(V argument) {
        return new LambdaList<V>(doExtract(argument), (Class<V>)argument.getClass());
    }

    // ////////////////////////////////////////////////////////////////////////
    // /// List interface
    // ////////////////////////////////////////////////////////////////////////

    /**
     * {@inheritDoc}
     */
    public void add(int index, T element) {
        innerList().add(index, element);
    }

    /**
     * {@inheritDoc}
     */
    public boolean addAll(int index, Collection<? extends T> c) {
        return innerList().addAll(index, c);
    }

    /**
     * {@inheritDoc}
     */
    public T get(int index) {
        return innerList().get(index);
    }

    /**
     * {@inheritDoc}
     */
    public int indexOf(Object o) {
        return innerList().indexOf(o);
    }

    /**
     * {@inheritDoc}
     */
    public int lastIndexOf(Object o) {
        return innerList().lastIndexOf(o);
    }

    /**
     * {@inheritDoc}
     */
    public ListIterator<T> listIterator() {
        return innerList().listIterator();
    }

    /**
     * {@inheritDoc}
     */
    public ListIterator<T> listIterator(int index) {
        return innerList().listIterator(index);
    }

    /**
     * {@inheritDoc}
     */
    public T remove(int index) {
        return innerList().remove(index);
    }

    /**
     * {@inheritDoc}
     */
    public T set(int index, T element) {
        return innerList().set(index, element);
    }

    /**
     * {@inheritDoc}
     */
    public LambdaList<T> subList(int fromIndex, int toIndex) {
        return new LambdaList(innerList().subList(fromIndex, toIndex), type);
    }
}
