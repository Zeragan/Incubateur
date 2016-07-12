package com.aurya.pointeuse.gateways;

import com.aurya.communs.gateways.System;
import com.aurya.pointeuse.entities.Rappel;

public interface PointageGestionRappels extends System
{

    void positionnerRappel(Rappel rappel);

}
