package com.aurya.communs.boundaries.out.model;

import java.util.Collection;
import java.util.List;

import com.aurya.communs.boundaries.Translator;
import com.aurya.communs.entities.Entity;

public interface OutTranslator<T extends Entity, U> extends Translator<T, U>
{

    U translate(T entity);

    List<U> translate(Collection<T> entities);

}
