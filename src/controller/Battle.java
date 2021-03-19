package controller;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Pokemon;
import model.Treinador;
import view.BattleInterface;
import view.EndGame;

/**
 *
 * @author Lucas Sales
 */
public class Battle {
    
    private Treinador treinadores[];
    private int contRound = 0;
    
    public Battle(Treinador treinadores[]) {
        this.treinadores = treinadores;
    }
    
    public EndGame toFight() {
        switch (contRound) {
            case 0:
                BattleInterface.btFight.setText("PRÓXIMA LUTA ->");
                return verifyWinner();
                
            case 1:
                BattleInterface.btFight.setText("ÚLTIMA LUTA ->");
                return verifyWinner();
                
            case 2:
                return verifyWinner();
                
            default:
                contRound = 0;
                return null;
        }
    }
    
    private EndGame verifyWinner() {
        Pokemon pokemonsTreinador_0[] = treinadores[0].getPokemons();
        Pokemon pokemonsTreinador_1[] = treinadores[1].getPokemons();
        
        BattleInterface.lblNameP1.setText(pokemonsTreinador_0[contRound].getName());
        BattleInterface.lblNameP2.setText(pokemonsTreinador_1[contRound].getName());
        BattleInterface.lblP1.setIcon(new ImageIcon(pokemonsTreinador_0[contRound].getPath()));
        BattleInterface.lblP2.setIcon(new ImageIcon(pokemonsTreinador_1[contRound].getPath()));
        
        if (pokemonsTreinador_0[contRound].getPower() > pokemonsTreinador_1[contRound].getPower()) {
            
            treinadores[0].setVictories(treinadores[0].getVictories() + 1);        
            JOptionPane.showMessageDialog(null, treinadores[0].getName() + " ganhou o round!");
        
        } else if (pokemonsTreinador_0[contRound].getPower() < pokemonsTreinador_1[contRound].getPower()) {
            
            treinadores[1].setVictories(treinadores[1].getVictories() + 1);
            JOptionPane.showMessageDialog(null, treinadores[1].getName() + " ganhou o round!");
            
        } else {
            // Em caso de empate o vencedor é sorteado!
            if (new Random().nextBoolean()) {
                
                treinadores[0].setVictories(treinadores[0].getVictories() + 1);
                JOptionPane.showMessageDialog(null, treinadores[0].getName() + " ganhou o round!");
            
            } else {
                
                treinadores[1].setVictories(treinadores[1].getVictories() + 1);
                JOptionPane.showMessageDialog(null, treinadores[1].getName() + " ganhou o round!");
            
            }
        }
        
        if (contRound == 2)
            return finish();
        else
            contRound++;
        
        return null;
    }
    
    private EndGame finish() {
        contRound = 0;
        System.out.println("Finish!");
        int scoreT0 = treinadores[0].getVictories();
        int scoreT1 = treinadores[1].getVictories();
        String placar = null;
        
        if (scoreT0 > scoreT1) {
            placar = treinadores[0].getName() + " venceu a batelha por " + scoreT0 + " a " + scoreT1;
            return new EndGame(treinadores[0], placar);
        } else {
            placar = treinadores[1].getName() + " venceu a batelha por " + scoreT1 + " a " + scoreT0;
            return new EndGame(treinadores[1], placar);
        }
    }
}


