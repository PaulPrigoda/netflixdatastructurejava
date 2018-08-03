public class movie{
	
	public static void main(String[] args){
		BSTmovie a=new BSTmovie();
		MNode movie1 = new MNode("Step Brothers", 20110616,10000, 98, true);
		MNode movie2 = new MNode("Up", 20090411,10001, 87, true);
		MNode movie3 = new MNode("Mighty Ducks", 19861008,10002, 92, true);
		MNode movie4 = new MNode("Doogle", 20070819,10003, 6, true);
		MNode movie5 = new MNode("Ping Pong Summer", 20120612,10004, 2, true);
		MNode movie6 = new MNode("Catch Me if You Can", 20030906,10005, 99, true);
		MNode movie7 = new MNode("Dylan's Feeling 22'", 20150416,10006, 22, true);
		MNode movie8 = new MNode("This Weekend", 20160422,10007,91, true);
		MNode movie9 = new MNode("Everybody Loves Ray", 20021114,10008, 63, true);
		MNode movie10 = new MNode("Sub-par Programmer", 20150902,10009, 43, true);

		a.insert(movie1);
		a.insert(movie2);
		a.insert(movie3);
		a.insert(movie4);
		a.insert(movie5);
		a.insert(movie6);
		a.insert(movie7);
		a.insert(movie8);
		a.insert(movie9);
		a.insert(movie10);

		/*System.out.println(a.search(10009).getTitle());
		System.out.println(a.search(10009).getRdate());
		System.out.println(a.search(10009).getRTscore());
		System.out.println(a.search(10009).getCode());
		*/
		a.traverse();


		//a.delete(movie10);
		//ask about this tomorrow System.out.println(a.search(10009).checkStock());


}
}






