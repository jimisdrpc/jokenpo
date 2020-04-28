package poc;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		//Fake returned list from database
		List<User> usersList = List.of(
				new User(1L, "Jogador 1", PlayType.PEDRA),
				new User(2L, "Jogador 2", PlayType.TESOURA),
				new User(3L, "Jogador 3", PlayType.TESOURA),
				new User(4L, "Jogador 4", PlayType.SPOCK)
				);
		
		
        Optional<User> winnerUser  = usersList.stream().reduce( (a, b) ->
        	returnWinnerBetweenTwoPlayers(a , b));
        
        System.out.print(winnerUser.get().getName());

	}

	private final static Map<PlayType, Set<PlayType>> CONFIG = Map.of(
			PlayType.SPOCK,
				Set.of(PlayType.TESOURA, PlayType.PEDRA), 
			PlayType.TESOURA, 
				Set.of(PlayType.PAPEL, PlayType.LAGARTO),
			PlayType.PAPEL, 
				Set.of(PlayType.SPOCK, PlayType.PEDRA),
			PlayType.PEDRA,
				Set.of(PlayType.LAGARTO, PlayType.TESOURA),
			PlayType.LAGARTO, 
				Set.of(PlayType.SPOCK, PlayType.PAPEL)
	);

	private static User returnWinnerBetweenTwoPlayers(User u1, User u2) {
		if (CONFIG.get(u1.getPlay()).contains(u2.getPlay())) {
			return u1;
		}
		return u2;
	}
}
