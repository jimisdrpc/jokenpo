package poc;

public class User {

	Long id;
	String name;
	PlayType play;

	public User(Long id, String name, PlayType play) {
		super();
		this.id = id;
		this.name = name;
		this.play = play;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayType getPlay() {
		return play;
	}

	public void setPlay(PlayType play) {
		this.play = play;
	}

}
