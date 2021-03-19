package controller;

import javax.swing.ImageIcon;
import model.Pokemon;
import view.GameInterface;

/**
 *
 * @author Lucas Sales
 */
public class PokemonSelection {
    
    private final String pathBoll = "src/util/img/boll.png";
    private int cont1 = -1;
    private int cont2 = -1;
    private int cont3 = -1;
    private boolean control;
    public boolean reseted = false;
    
    public void incrementImage(int number) {
        switch (number) {
            case 1:
                cont1++;
                break;
            case 2:
                cont2++;
                break;
            case 3:
                cont3++;
                break;
        }
    }
    
    public int decrementImage(int number) {
        switch (number) {
            case 1:
                cont1--;
                return cont1;
            case 2:
                cont2--;
                return cont2;
            case 3:
                cont3--;
                return cont3;
            default:
                return 0;
        }
    }
    
    private final String pokemonNames[] = {
        "Bulbasaur", "Zapdos", "Pikachu", "Marill", 
        "Raticate", "Meowth", "Charizard", "Jigglypuff", 
        "Sandshrew", "Dragonair" };
    
    private final String iconPaths[] = {
        "src/util/img/1.png", "src/util/img/2.png", "src/util/img/3.png", 
        "src/util/img/4.png", "src/util/img/5.png", "src/util/img/6.png",
        "src/util/img/7.png", "src/util/img/8.png", "src/util/img/9.png",
        "src/util/img/10.png" };
    
    private final String type[] = {
        "Tipo: PLANTA", "Tipo: ELÉTRICO", "Tipo: ELÉTRICO", 
        "Tipo: ÁGUA", "Tipo: NORMAL", "Tipo: NORMAL", 
        "Tipo: FOGO", "Tipo: FADA", "Tipo: TERRA", "Tipo: DRAGÃO" };
    
    private final int power[] = { 100, 110, 190, 60, 72, 60, 170, 70, 71, 90 };
    
    public boolean selectPokemon(int pokNumber) {        
        switch (pokNumber) {
            case 1:
                if (cont1 > iconPaths.length - 1)
                    cont1 = iconPaths.length - 1;
                if (cont1 < 0)
                    cont1 = 0;
                GameInterface.lblName1.setText(pokemonNames[cont1]);
                GameInterface.lblImg1.setIcon(new ImageIcon(iconPaths[cont1]));
                GameInterface.lblType1.setText(type[cont1]);
                GameInterface.lblPower1.setText("Nível de poder: " + String.valueOf(power[cont1]));
                break;
            case 2:
                if (cont2 > iconPaths.length - 1)
                    cont2 = iconPaths.length - 1;
                if (cont2 < 0)
                    cont2 = 0;
                GameInterface.lblName2.setText(pokemonNames[cont2]);
                GameInterface.lblImg2.setIcon(new ImageIcon(iconPaths[cont2]));
                GameInterface.lblType2.setText(type[cont2]);
                GameInterface.lblPower2.setText("Nível de poder: " + String.valueOf(power[cont2]));
                break;
            case 3:
                if (cont3 > iconPaths.length - 1)
                    cont3 = iconPaths.length - 1;
                if (cont3 < 0)
                    cont3 = 0;
                GameInterface.lblName3.setText(pokemonNames[cont3]);
                GameInterface.lblImg3.setIcon(new ImageIcon(iconPaths[cont3]));
                GameInterface.lblType3.setText(type[cont3]);
                GameInterface.lblPower3.setText("Nível de poder: " + String.valueOf(power[cont3]));
                break;
        }
        
        System.out.println(cont1 + " - " + cont2 + " - " + cont3);

        control = !(cont1 == cont2 || cont1 == cont3 || cont2 == cont3
                || cont1 == -1 || cont2 == -1 || cont3 == -1);
        
        return control;
    }
    
    public void nextPlayer() {
        cont1 = -1;
        cont2 = -1;
        cont3 = -1;
        control = false;
        GameInterface.lblName1.setText(null);
        GameInterface.lblImg1.setIcon(new ImageIcon(pathBoll));
        GameInterface.lblName2.setText(null);
        GameInterface.lblImg2.setIcon(new ImageIcon(pathBoll));
        GameInterface.lblName3.setText(null);
        GameInterface.lblImg3.setIcon(new ImageIcon(pathBoll));
        GameInterface.txtName.setText(null);
        GameInterface.txtYears.setText(null);
        GameInterface.lblPlayer.setText("2º TREINADOR");
        reseted = true;
    }
    
    public Pokemon[] getInstancesArray() {
        Pokemon pokemons[] = { 
            new Pokemon(pokemonNames[cont1], type[cont1], power[cont1], iconPaths[cont1]),
            new Pokemon(pokemonNames[cont2], type[cont2], power[cont2], iconPaths[cont2]),
            new Pokemon(pokemonNames[cont3], type[cont3], power[cont3], iconPaths[cont3]) };
        return pokemons;
    }
}
