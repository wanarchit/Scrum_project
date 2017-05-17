/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noyau_fonctionnel;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Marin
 */
public class TestSpeciesCategory {
    private SpecieCategory cat;
    private Specie sp1= new Specie("colibri");
    private Specie sp2= new Specie("autruche");
    
    @Before
    public void setUp()
    {
        cat=new SpecieCategory("bird");
    }
    
    /**
     * S'execute apres les test (pas utile ici)
     */
    @After
    public void tearDown()
    {
    }
    /**
     * Test qu'on récupere bien le nom
     */
    @Test
    public void testGetName() {
        assertEquals("bird", cat.getName());
    }
    
   
    /**
     * Test de addSpecies et getSpecies
     */
    @Test
    public void testAdd_GetSpecies(){
        cat.addSpecie(sp1);
        assertEquals(true,cat.getSpecies().contains(sp1));
        cat.addSpecie(sp2);
        assertEquals(true,cat.getSpecies().contains(sp2));
    }
}
