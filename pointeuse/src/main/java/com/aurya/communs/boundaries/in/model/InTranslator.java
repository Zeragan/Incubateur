package com.aurya.communs.boundaries.in.model;

import java.util.Collection;
import java.util.List;

import com.aurya.communs.boundaries.Translator;
import com.aurya.communs.entities.Entity;

public interface InTranslator<T extends Entity, U> extends Translator<T, U>
{

    T translate(U model);

    List<T> translate(Collection<U> models);

}
