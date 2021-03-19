package model;
/**
 *
 * @author Lucas Sales
 */
public class Treinador {
    private String name;
    private int years;
    private Pokemon pokemons[];
    
    public Treinador(String name, int years, Pokemon pokemons[]) {
        this.name = name;
        this.years = years;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }
}
