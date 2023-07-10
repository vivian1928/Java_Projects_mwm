package junittest;

import java.util.ArrayList;

import org.junit.Test;

import entry.Cinema;
import serviceimpl.CinemaServiceImpl;

public class JTCinemaServiceImpl {
	CinemaServiceImpl csi = new CinemaServiceImpl();
	Cinema cinema1 = new Cinema("完美世界影城", "闸北区共和新路3308弄2号楼");
	Cinema cinema2 = new Cinema("海上明珠国际影城", "静安区万荣路777号");
	Cinema cinema3 = new Cinema("海上国际影城", "静安区万荣路777号");// 供修改用

	@Test
	public void test() throws Exception {
		csi.addCinema(cinema1);
		csi.addCinema(cinema2);
	}

	@Test
	public void test2() throws Exception {
		csi.deleteCinema(1);
	}

	@Test
	public void test3() throws Exception {
		csi.updateCinema(cinema3);
	}

	@Test
	public void test4() throws Exception {
		ArrayList<Cinema> list = csi.getAllCinemas();
		for (Cinema c : list) {
			System.out.println(c.toString());
		}
	}

	@Test
	public void test5() throws Exception {
		ArrayList<Cinema> list = csi.findCinemaByName("海上");
		for (Cinema c : list) {
			System.out.println(c.toString());
		}
	}
	
	@Test
	public void test6() throws Exception {
		ArrayList<Cinema> list = csi.findCinemaById(2);
		for (Cinema c : list) {
			System.out.println(c.toString());
		}
	}
}
