package com.aurya.communs.gateways;

import java.util.List;

import com.aurya.communs.entities.Entity;

public interface Repository<T extends Entity>
{

    void persister(T entity);

    T recuperer(long id);

    List<T> recupererTout();

}
