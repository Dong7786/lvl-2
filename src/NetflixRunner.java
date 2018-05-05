
public class NetflixRunner {
public static void main(String[] args) {
	Movie Movie1 = new Movie("The Man Who Invented Christmas", 7);
	Movie Movie2 = new Movie("Twilight", 5);
	Movie Movie3 = new Movie("The Star", 6);
	Movie Movie4 = new Movie("The Hunger Games: Mockingjay - Part 2", 7);
	Movie Movie5 = new Movie("Pirates of the Caribbean: The Curse of the Black Pearl", 8);
	Movie Movie6 = new Movie( "The Legends of the Titanic", 2);
	Movie1.getTicketPrice();
			NetflixQueue bob = new NetflixQueue();
			
			bob.addMovie(Movie1);
			bob.addMovie(Movie2);
			bob.addMovie(Movie3);
			bob.addMovie(Movie4);
			bob.addMovie(Movie5);
			bob.addMovie(Movie6);
			bob.sortMoviesByRating();
			System.out.println("------------------------------");
			bob.printMovies();
			System.out.println("------------------------------");
			System.out.println("The best movies is " + bob.movies.get(0));
			System.out.println("The second best movies is " + bob.movies.get(1));
}
}
