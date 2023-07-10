package dao;

import java.util.ArrayList;

import entry.Movie;

public interface MovieDao {
	public int insertMovie(Movie movie) throws Exception;//添加电影

	public int deleteMovie(int mId) throws Exception;//通过id删除电影
	
	public int updateMovie(Movie movie) throws Exception;//更新电影信息
	
	public ArrayList<Movie> getAllMovies() throws Exception;//获取所有电影信息
	
	public ArrayList<Movie> findMovieByName(String mName) throws Exception;//通过名字模糊查找电影
	
	public ArrayList<Movie> findMovieById(int mId) throws Exception;//通过id精确查找电影
	
	public ArrayList<Movie> findMovieByMName(String mName) throws Exception;//通过名字精确查找电影
}
