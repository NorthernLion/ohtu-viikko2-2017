/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Pesonen
 */
public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
 
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void pelaajanEtsiminenKunLoytyy() {
        String nimi = "Kurri";
        Player etsitty = stats.search(nimi);
        assertEquals(etsitty.getName(), nimi);
    }
    
    @Test
    public void pelaajanEtsiminenKunEiLoydy() {
        String nimi = "EiKurri";
        Player etsitty = stats.search(nimi);
        assertEquals(etsitty, null);   
    }
    
    @Test
    public void tiiminPelaajienEtsiminen () {
        String tiimi = "EDM";
        List<Player> lista = stats.team(tiimi);
        assertEquals(lista.size(), 3);
    }
    
    @Test
    public void topPisteidenSelvittäminenToimii() {
        int montako = 3;
        List<Player> lista = stats.topScorers(montako);
        assertEquals(lista.get(0).getName(), "Gretzky");  
        assertEquals(lista.get(1).getName(), "Lemieux");  
        assertEquals(lista.get(2).getName(), "Yzerman");  
    }
    
}

