package com.aurya.communs.gateways;

import java.util.List;

import com.aurya.communs.entities.Entity;

public interface Repository<T, U extends Entity<T>>
{

    void persister(U entity);

    U recuperer(T id);

    List<U> recupererTout();

}
