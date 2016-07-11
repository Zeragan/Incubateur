package com.aurya.communs.interactors.boundaries.out;

import com.aurya.communs.interactors.boundaries.Boundary;

public interface OutBoundary extends Boundary
{

    void onError(String message);

}
