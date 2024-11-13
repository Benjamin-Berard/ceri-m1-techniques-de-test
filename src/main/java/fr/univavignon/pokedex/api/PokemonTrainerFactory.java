package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        PokemonFactory pokemonFactory = new PokemonFactory();
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        Pokedex pokedex = (Pokedex) pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        return new PokemonTrainer(name,team, pokedex);
    }
}
