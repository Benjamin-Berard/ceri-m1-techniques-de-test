package fr.uniavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonTrainerFactoryTest {
    @Mock
    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;

    private IPokedex pokedex;
    private PokemonTrainer mockTrainer = new PokemonTrainer("jessie",Team.MYSTIC,pokedex);


    @Test
    public void shouldReturnPokemonTrainerWhenCreateTrainer(){
        when(pokemonTrainerFactory.createTrainer("jessie", Team.MYSTIC, pokedexFactory)).thenReturn(mockTrainer);
        assertEquals(mockTrainer, pokemonTrainerFactory.createTrainer("jessie", Team.MYSTIC, pokedexFactory));
        assertEquals("jessie",mockTrainer.getName());
        assertEquals(Team.MYSTIC,mockTrainer.getTeam());
        assertEquals(pokedex,mockTrainer.getPokedex());
    }

}
