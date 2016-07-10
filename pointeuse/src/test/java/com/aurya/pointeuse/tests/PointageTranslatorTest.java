package com.aurya.pointeuse.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.aurya.pointeuse.entities.Pointage;
import com.aurya.pointeuse.gateways.PointagePreferences;
import com.aurya.pointeuse.gateways.PointagePreferences.Arrondi;
import com.aurya.pointeuse.gateways.PointagePreferences.DelaiFormat;
import com.aurya.pointeuse.interactors.boundaries.out.model.PointageInfo;
import com.aurya.pointeuse.interactors.boundaries.out.model.PointageTranslator;

@RunWith(Parameterized.class)
public class PointageTranslatorTest
{

    @Mock
    private PointagePreferences preferences;

    private PointageTranslator translator;

    private Arrondi arrondi;

    private String dateFormat;

    private DelaiFormat delaiFormat;

    private Boolean precision;

    private String dateDebut;

    private String dateFin;

    private String expectedDebut;

    private String expectedFin;

    private String expectedDuree;

    // @formatter:off
    public static Object[][] PARAMETERS = new Object[][] {
            new Object[] { "2016/07/10 10:15:55", "2016/07/10 10:16:00", "yyyy/MM/dd HH:mm:ss", DelaiFormat.DIXIEME_HEURE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/10 10:16:00", "0,0" } // 5 secondes
          , new Object[] { "2016/07/10 10:15:55", "2016/07/10 10:45:55", "yyyy/MM/dd HH:mm:ss", DelaiFormat.DIXIEME_HEURE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/10 10:45:55", "0,5" } // 1/2 heure
          , new Object[] { "2016/07/10 10:15:55", "2016/07/10 11:15:55", "yyyy/MM/dd HH:mm:ss", DelaiFormat.DIXIEME_HEURE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/10 11:15:55", "1,0" } // 1 heure
          , new Object[] { "2016/07/10 10:15:55", "2016/07/11 10:15:55", "yyyy/MM/dd HH:mm:ss", DelaiFormat.DIXIEME_HEURE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/11 10:15:55", "24,0" } // 1 journée

          , new Object[] { "2016/07/10 10:15:55", "2016/07/10 10:16:00", "yyyy/MM/dd HH:mm:ss", DelaiFormat.HEURE_MINUTE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/10 10:16:00", "00h00" } // 5 secondes
          , new Object[] { "2016/07/10 10:15:55", "2016/07/10 10:45:55", "yyyy/MM/dd HH:mm:ss", DelaiFormat.HEURE_MINUTE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/10 10:45:55", "00h30" } // 1/2 heure
          , new Object[] { "2016/07/10 10:15:55", "2016/07/10 11:15:55", "yyyy/MM/dd HH:mm:ss", DelaiFormat.HEURE_MINUTE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/10 11:15:55", "01h00" } // 1 heure
          , new Object[] { "2016/07/10 10:15:55", "2016/07/11 10:15:55", "yyyy/MM/dd HH:mm:ss", DelaiFormat.HEURE_MINUTE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/11 10:15:55", "24h00" } // 1 journée

          , new Object[] { "2016/07/10 10:15:55", "2016/07/10 10:16:00", "yyyy/MM/dd HH:mm:ss", DelaiFormat.JOUR_HEURE_MINUTE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/10 10:16:00", "0j. 00h00" } // 5 secondes
          , new Object[] { "2016/07/10 10:15:55", "2016/07/10 10:45:55", "yyyy/MM/dd HH:mm:ss", DelaiFormat.JOUR_HEURE_MINUTE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/10 10:45:55", "0j. 00h30" } // 1/2 heure
          , new Object[] { "2016/07/10 10:15:55", "2016/07/10 11:15:55", "yyyy/MM/dd HH:mm:ss", DelaiFormat.JOUR_HEURE_MINUTE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/10 11:15:55", "0j. 01h00" } // 1 heure
          , new Object[] { "2016/07/10 10:15:55", "2016/07/11 10:15:55", "yyyy/MM/dd HH:mm:ss", DelaiFormat.JOUR_HEURE_MINUTE, Arrondi.AUCUN, true, "2016/07/10 10:15:55", "2016/07/11 10:15:55", "1j. 00h00" } // 1 journée

          , new Object[] { "2016/07/10 10:15:55", "2016/07/11 10:16:00", "MM/dd HH'h'mm", DelaiFormat.JOUR_HEURE_MINUTE, Arrondi.AUCUN, true, "07/10 10h15", "07/11 10h16", "1j. 00h00" } // 1 j. et 5 secondes
          , new Object[] { "2016/07/10 10:15:55", "2016/07/11 10:45:55", "MM/dd HH'h'mm", DelaiFormat.JOUR_HEURE_MINUTE, Arrondi.AUCUN, true, "07/10 10h15", "07/11 10h45", "1j. 00h30" } // 1 j. et 1/2 heure
          , new Object[] { "2016/07/10 10:15:55", "2016/07/11 11:15:55", "MM/dd HH'h'mm", DelaiFormat.JOUR_HEURE_MINUTE, Arrondi.AUCUN, true, "07/10 10h15", "07/11 11h15", "1j. 01h00" } // 1 j. et 1 heure
          , new Object[] { "2016/07/10 10:15:55", "2016/07/12 10:15:55", "MM/dd HH'h'mm", DelaiFormat.JOUR_HEURE_MINUTE, Arrondi.AUCUN, true, "07/10 10h15", "07/12 10h15", "2j. 00h00" } // 2 jours
    };
    // @formatter:on

    @Parameters(name = "{0} {1} {2} {3} {4} {5}")
    public static Collection<Object[]> data()
    {
        return Arrays.asList(PARAMETERS);
    }

    public PointageTranslatorTest(String dateDebut, String dateFin, String dateFormat, DelaiFormat delaiFormat, Arrondi arrondi, Boolean precision,
            String expectedDebut, String expectedFin, String expectedDuree)
    {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dateFormat = dateFormat;
        this.delaiFormat = delaiFormat;
        this.arrondi = arrondi;
        this.precision = precision;
        this.expectedDebut = expectedDebut;
        this.expectedFin = expectedFin;
        this.expectedDuree = expectedDuree;
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        translator = new PointageTranslator(preferences);
    }

    @Test
    public void testTranslatePointage() throws ParseException
    {
        Mockito.when(preferences.getArrondi()).thenReturn(arrondi);
        Mockito.when(preferences.getDateFormat()).thenReturn(dateFormat);
        Mockito.when(preferences.getDelaiFormat()).thenReturn(delaiFormat);
        Mockito.when(preferences.getPrecision()).thenReturn(precision);
        Pointage pointage = new Pointage(getDate(dateDebut));
        pointage.setFin(getDate(dateFin));
        pointage.setId((long) 0);
        PointageInfo info = translator.translate(pointage);

        Assert.assertEquals(expectedDebut, info.getDebut());
        Assert.assertEquals(expectedFin, info.getFin());
        Assert.assertEquals(expectedDuree, info.getDuree());
    }

    public Date getDate(String format) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.parse(format);
    }

    public String getFormat(Date date) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(date);
    }

}
