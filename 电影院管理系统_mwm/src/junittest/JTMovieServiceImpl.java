package junittest;

import java.util.ArrayList;

import org.junit.Test;

import entry.Movie;
import service.MovieService;
import serviceimpl.MovieServiceImpl;

public class JTMovieServiceImpl {
	MovieService ms = new MovieServiceImpl();
	Movie movie1 = new Movie("爱情公寓", "韦正", "陈赫 娄艺潇 邓家佳", "剧情", 113,
			"《爱情公寓》电影版归来,原班人马十年催泪重聚。曾小贤、胡一菲、吕子乔、张伟、唐悠悠、陈美嘉悉数回归,"
			+ "还是熟悉的场景和熟悉的人,嘻嘻哈哈、打打闹闹,笑声从没停过。老朋友的故事将继续展开,印证了电视剧的那"
			+ "句主题语——“最好的朋友在身边,最爱的人就在对面”。不过这一次,他们打算搞个大事情…… ", "无");
	
	Movie movie2 = new Movie("阳台上", "张猛", "周冬雨 王锵", "文艺、剧情", 120, "该片根据同名小说改编,"
			+ "围绕“复仇”主题,讲述了因父亲被拆迁逼死的男主,在“复仇”过程中对周冬雨饰演的“仇人”女儿产生复杂情愫"
			+ "的故事", "无");
	
	Movie movie3 = new Movie("阳台上", "张猛", "周冬雨 王锵", "文艺、剧情", 115, "该片根据同名小说改编,"
			+ "围绕“复仇”主题,讲述了因父亲被拆迁逼死的男主,在“复仇”过程中对周冬雨饰演的“仇人”女儿产生复杂情愫"
			+ "的故事", "无");//供修改用
	
	@Test
	public void test() throws Exception {
		ms.addMovie(movie1);
		ms.addMovie(movie2);
	}
	
	@Test
	public void test2() throws Exception {
		ms.deleteMovie(1);
	}
	
	@Test
	public void test3() throws Exception {
		ms.updateMovie(movie3);
	}
	
	@Test
	public void test4() throws Exception {
		ArrayList<Movie> movieList = ms.getAllMovies();
		for (Movie m : movieList) {
			System.out.println(m.toString());
		}
	}
	

	@Test
	public void test5() throws Exception {
		ArrayList<Movie> movieList = ms.findMovieById(1);
		for (Movie m : movieList) {
			System.out.println(m.toString());
		}
	}
	
	@Test
	public void test6() throws Exception {
		ArrayList<Movie> movieList = ms.findMovieByName("爱情");
		for (Movie m : movieList) {
			System.out.println(m.toString());
		}
	}
	
	@Test
	public void test7() throws Exception {
		ArrayList<Movie> movieList = ms.findMovieByMName("爱情公寓");
		for (Movie m : movieList) {
			System.out.println(m.toString());
		}
	}
}
