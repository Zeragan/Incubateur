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

import com.aurya.pointeuse.interactors.internal.Periode;

@RunWith(Parameterized.class)
public class PeriodeCalculateurTest
{

    private final String input;

    private Periode periode;

    private String expectedDebut;

    private String expectedFin;

    // @formatter:off
    public static Object[][] PARAMETERS = new Object[][] {
            new Object[] { "2016/07/10 10:15:55", Periode.JOUR,    "2016/07/10 00:00:00", "2016/07/11 00:00:00" },
            new Object[] { "2016/07/10 10:15:55", Periode.SEMAINE, "2016/07/04 00:00:00", "2016/07/11 00:00:00" },
            new Object[] { "2016/07/10 10:15:55", Periode.MOIS,    "2016/07/01 00:00:00", "2016/08/01 00:00:00" },
            new Object[] { "2016/07/10 10:15:55", Periode.ANNEE,   "2016/01/01 00:00:00", "2017/01/01 00:00:00" },
            new Object[] { "2016/01/01 00:00:00", Periode.JOUR,    "2016/01/01 00:00:00", "2016/01/02 00:00:00" },
            new Object[] { "2016/01/01 00:00:00", Periode.SEMAINE, "2015/12/28 00:00:00", "2016/01/04 00:00:00" },
            new Object[] { "2016/01/01 00:00:00", Periode.MOIS,    "2016/01/01 00:00:00", "2016/02/01 00:00:00" },
            new Object[] { "2016/01/01 00:00:00", Periode.ANNEE,   "2016/01/01 00:00:00", "2017/01/01 00:00:00" },
            new Object[] { "2015/12/28 00:00:00", Periode.JOUR,    "2015/12/28 00:00:00", "2015/12/29 00:00:00" },
            new Object[] { "2015/12/28 00:00:00", Periode.SEMAINE, "2015/12/28 00:00:00", "2016/01/04 00:00:00" },
            new Object[] { "2015/12/28 00:00:00", Periode.MOIS,    "2015/12/01 00:00:00", "2016/01/01 00:00:00" },
            new Object[] { "2015/12/28 00:00:00", Periode.ANNEE,   "2015/01/01 00:00:00", "2016/01/01 00:00:00" }
    };
    // @formatter:on

    @Parameters(name = "{0} {1}")
    public static Collection<Object[]> data()
    {
        return Arrays.asList(PARAMETERS);
    }

    public PeriodeCalculateurTest(String input, Periode periode, String expectedDebut, String expectedFin)
    {
        this.input = input;
        this.periode = periode;
        this.expectedDebut = expectedDebut;
        this.expectedFin = expectedFin;
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testGetDebutPeriode() throws ParseException
    {
        Date reference = getDate(input);
        Date resultat = periode.getDebutPeriode(reference);
        Assert.assertEquals(expectedDebut, getFormat(resultat));
    }

    @Test
    public void testGetFinPeriode() throws ParseException
    {
        Date reference = getDate(input);
        Date resultat = periode.getFinPeriode(reference);
        Assert.assertEquals(expectedFin, getFormat(resultat));
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
