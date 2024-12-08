package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the IPpokemonMetadataProvider class
 * @author Benjamin
 */
public  class PokemonMetadataProvider implements  IPokemonMetadataProvider {
    static List<PokemonMetadata> pokemonMetadata = new ArrayList<>();
    PokemonMetadata pokemondata = new PokemonMetadata(0,"Bulbizarre",126,126,90);

    /**
     * construct that initialise the pokemonmetadata list
     */
    public PokemonMetadataProvider() {
        pokemonMetadata.add(pokemondata);
    }

    /**
     * override the IPokemonMetadataProvider getPokemonMetadata fonction
     * @param index Index of the pokemon to retrieve metadata for.
     * @return
     * @throws PokedexException
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {

        if (index > pokemonMetadata.size() - 1) throw new PokedexException("invalid id");
        return pokemonMetadata.get(index);

    }

    /**
     * set metadata of the pokemons
     * @param pokemonMetadata
     */
    public static void setPokemonMetadata(List<PokemonMetadata> pokemonMetadata) {
        PokemonMetadataProvider.pokemonMetadata = pokemonMetadata;
    }

    /**
     * add new metadata to the list
     * @param index
     */
    public static void addPokemonMetadata(int index) {
        //Pour les tests
        pokemonMetadata.add(new PokemonMetadata(index,"salameche",130,130,200));
    }

    /**
     * get the pokemonmetadata list
     * @return the pokemonmetadata list
     */
    public static List<PokemonMetadata> getPokemonMetadata() {
        return pokemonMetadata;
    }
}
