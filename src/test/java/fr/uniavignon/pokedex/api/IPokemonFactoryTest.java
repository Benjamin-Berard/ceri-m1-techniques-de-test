package fr.uniavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonFactoryTest {
    @Mock
    private IPokemonFactory pokemonFactory;
    private Pokemon pokemon;

    @BeforeEach
    void setUp() {
        pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90,613,64,4000,4,56);
    }


    @Test
    public void shouldReturnIPokedexWhenCreatePokedex() {
        when(pokemonFactory.createPokemon(1,500,200,2,1)).thenReturn(pokemon);
        assertEquals(pokemon,pokemonFactory.createPokemon(1,500,200,2,1));
    }

    @Test
    void shouldReturnCorrectCp() {
        assertEquals(613, pokemon.getCp());
    }

    @Test
    void shouldReturnCorrectHp() {
        assertEquals(64, pokemon.getHp());
    }

    @Test
    void shouldReturnCorrectDust() {
        assertEquals(4000, pokemon.getDust());
    }

    @Test
    void shouldReturnCorrectDefense() {
        assertEquals(4, pokemon.getCandy());
    }

    @Test
    void shouldReturnCorrectStamina() {
        assertEquals(56, pokemon.getIv());
    }
}
