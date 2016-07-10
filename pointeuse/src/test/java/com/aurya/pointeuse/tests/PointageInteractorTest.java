package com.aurya.pointeuse.tests;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aurya.pointeuse.entities.Pointage;
import com.aurya.pointeuse.gateways.PointagePreferences;
import com.aurya.pointeuse.gateways.PointagePreferences.DelaiFormat;
import com.aurya.pointeuse.gateways.PointageRepository;
import com.aurya.pointeuse.interactors.PointageInteractor;
import com.aurya.pointeuse.interactors.boundaries.out.PointageOut;

@RunWith(MockitoJUnitRunner.class)
public class PointageInteractorTest
{

    @Mock
    private PointageOut pointageBoundaryOut;

    @Mock
    private PointageRepository repository;

    @Mock
    private PointagePreferences preferences;

    private PointageInteractor interacteur;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        interacteur = new PointageInteractor(pointageBoundaryOut, repository, preferences);
    }

    @Test
    public void test()
    {
        Pointage dernier = new Pointage(new Date());
        dernier.setId(0L);

        Mockito.when(repository.recupererDernier()).thenReturn(dernier);
        Mockito.when(preferences.getDateFormat()).thenReturn("yyyy/MM/dd HH:mm:ss");
        Mockito.when(preferences.getDelaiFormat()).thenReturn(DelaiFormat.DIXIEME_HEURE);

        interacteur.pointer();

        // TODO : Ecrire des tests
    }

}
