package com.aurya.pointeuse.gateways;

import java.util.Date;
import java.util.List;

import com.aurya.communs.gateways.Repository;
import com.aurya.pointeuse.entities.Pointage;

public interface PointageRepository extends Repository<Long, Pointage>
{

    List<Pointage> recuperer(Date debut, Date fin);

    Pointage recupererDernier();

}
