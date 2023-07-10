package junittest;

import java.util.ArrayList;

import org.junit.Test;

import entry.Hall;
import service.HallService;
import serviceimpl.HallServiceImpl;

public class JTHallServiceImpl {
	HallService hallService = new HallServiceImpl();
	Hall hall1 = new Hall("一号厅", 1, 40);
	Hall hall2 = new Hall("二号厅", 1, 50);
	Hall hall3 = new Hall("二号厅", 1, 60);//供修改用
	
	@Test
	public void test() throws Exception {
		hallService.addHall(hall1);
		hallService.addHall(hall2);
	}
	
	@Test
	public void test2() throws Exception {
		hallService.deleteHall(1);
	}
	
	@Test
	public void test3() throws Exception {
		hallService.updateHall(hall3);
	}
	
	@Test
	public void test4() throws Exception {
		ArrayList<Hall> hallList = hallService.getAllHalls();
		for (Hall hall : hallList) {
			System.out.println(hall.toString());
		}
	}
	
	@Test
	public void test5() throws Exception {
		ArrayList<Hall> hallList = hallService.findHallById(7);
		for (Hall hall : hallList) {
			System.out.println(hall.toString());
		}
	}
}
