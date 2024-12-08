package fr.univavignon.pokedex.api;

/**
 * Class that implements IPokemonTrainerFactory
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    /**
     * Add empty constructor to not use default constructor
     */
    public PokemonTrainerFactory() {

    }

    /**
     * Create a trainer
     * @param name Name of the created trainer.
     * @param team Team of the created trainer.
     * @param pokedexFactory Factory to use for creating associated pokedex instance.
     * @return new PokemonTrainer
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        PokemonFactory pokemonFactory = new PokemonFactory();
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        Pokedex pokedex = (Pokedex) pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        return new PokemonTrainer(name,team, pokedex);
    }
}
