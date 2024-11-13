package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public  class PokemonMetadataProvider implements  IPokemonMetadataProvider{
    static List<PokemonMetadata> pokemonMetadata ;



    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {

        if(pokemonMetadata.get(index)==null) throw new PokedexException("invalid id");
        return pokemonMetadata.get(index);

    }

    public static void setPokemonMetadata(List<PokemonMetadata> pokemonMetadata) {
        PokemonMetadataProvider.pokemonMetadata = pokemonMetadata;
    }

    public static List<PokemonMetadata> getPokemonMetadata() {
        return pokemonMetadata;
    }
}
