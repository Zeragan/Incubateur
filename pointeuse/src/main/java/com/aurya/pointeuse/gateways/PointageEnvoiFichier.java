package com.aurya.pointeuse.gateways;

import com.aurya.communs.gateways.System;

public interface PointageEnvoiFichier extends System
{

    void envoyer(String destinataire, String sujet, String corps, String nomFichier, byte[] pieceJointe);

}
