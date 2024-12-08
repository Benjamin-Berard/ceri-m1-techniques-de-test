package fr.univavignon.pokedex.api;

/**
 * Class that implements IPokedexFactory
 */
public class PokedexFactory implements IPokedexFactory {
    /**
     * Add constructor to not use the default one
     */
    public PokedexFactory() { }

    /**
     * Create a new pokedex
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
     * @return new Pokedex
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex((PokemonFactory) pokemonFactory, (PokemonMetadataProvider) metadataProvider);
    }
}
