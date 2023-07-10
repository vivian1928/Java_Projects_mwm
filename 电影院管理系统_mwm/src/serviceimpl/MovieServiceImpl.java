package serviceimpl;

import java.util.ArrayList;

import dao.MovieDao;
import daoimpl.MovieDaoImpl;
import entry.Movie;
import service.MovieService;

public class MovieServiceImpl implements MovieService {
	MovieDao movieDao = new MovieDaoImpl();

	@Override
	public int addMovie(Movie movie) throws Exception {// 添加电影

		return movieDao.insertMovie(movie);
	}

	@Override
	public int deleteMovie(int mId) throws Exception {// 通过id删除电影

		return movieDao.deleteMovie(mId);
	}

	@Override
	public int updateMovie(Movie movie) throws Exception {// 更新电影信息

		return movieDao.updateMovie(movie);
	}

	@Override
	public ArrayList<Movie> getAllMovies() throws Exception {// 获取所有电影信息

		return movieDao.getAllMovies();
	}

	@Override
	public ArrayList<Movie> findMovieByName(String mName) throws Exception {// 通过名字模糊查找电影

		return movieDao.findMovieByName(mName);
	}

	@Override
	public ArrayList<Movie> findMovieById(int mId) throws Exception {// 通过id精确查找电影

		return movieDao.findMovieById(mId);
	}

	@Override
	public ArrayList<Movie> findMovieByMName(String mName) throws Exception {// 通过名字精确查找电影
		
		return movieDao.findMovieByMName(mName);
	}

}
