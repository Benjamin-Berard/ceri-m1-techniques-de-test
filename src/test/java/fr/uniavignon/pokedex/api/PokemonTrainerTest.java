package fr.uniavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTrainerTest {
    PokemonFactory pokemonFactory = new PokemonFactory();
    PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
    Pokedex pokedex = new Pokedex(pokemonFactory,pokemonMetadataProvider);
    PokedexFactory pokedexFactory = new PokedexFactory();
    PokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory();


    @Test
        void shouldReturnGoodValue(){
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("sacha", Team.MYSTIC, pokedexFactory);

        assertEquals("sacha",pokemonTrainer.getName());
        assertEquals(Team.MYSTIC,pokemonTrainer.getTeam());
        assertEquals(Pokedex.class,pokemonTrainer.getPokedex().getClass());

    }

}
