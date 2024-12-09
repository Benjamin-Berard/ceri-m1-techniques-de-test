package fr.uniavignon.pokedex.api;
import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class RocketPokemonFactoryTest {

    Pokemon pokemon;
    Pokemon pokemon2;
    Pokemon pokemon3;
    RocketPokemonFactory rocketPokemonFactory;

    @BeforeEach
    void setUp()
    {
        rocketPokemonFactory = new RocketPokemonFactory();
        pokemon = rocketPokemonFactory.createPokemon(-1,800,100,4000,4);
        pokemon2 = rocketPokemonFactory.createPokemon(0,1,1,0,1);
        pokemon3 = rocketPokemonFactory.createPokemon(1,613,64,4000,4);
    }
    @Test
    void shouldReturn1000ToStats()
    {
        assertEquals(1000,pokemon.getAttack());
        assertEquals(1000,pokemon.getStamina());
        assertEquals(1000,pokemon.getDefense());
    }

    @Test
    void shouldReturnCorrectName()
    {
        assertEquals("Ash's Pikachu",pokemon.getName());
        assertEquals("MISSINGNO",pokemon2.getName());
        assertEquals("Bulbasaur",pokemon3.getName());
        assertEquals("MISSINGNO", rocketPokemonFactory.createPokemon(50,0,0,0,0).getName());
    }
    @Test
    void shouldReturnCorrectIv()
    {
        assertEquals(0,pokemon.getIv());
        assertEquals(1,pokemon2.getIv());
    }
}
