package com.aurya.pointeuse.interactors.boundaries.out;

import com.aurya.communs.boundaries.out.OutBoundary;
import com.aurya.pointeuse.interactors.boundaries.out.model.ListePointageInfo;
import com.aurya.pointeuse.interactors.boundaries.out.model.PointageInfo;

public interface PointageOut extends OutBoundary
{

    void pointage(PointageInfo pointage);

    void listePointages(ListePointageInfo pointages);

    void export(String data);

}
