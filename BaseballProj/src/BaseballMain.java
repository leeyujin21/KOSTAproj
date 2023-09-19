import service.BaseBallService;

public class BaseballMain {
	public static void main(String[] args) {
		BaseBallService service = new BaseBallService();
		int sel = 0;
		while(true) {
			sel = service.menu();
			if(sel==0) break;
			switch(sel) {
			case 1: service.regTeam(); break;
			case 2: service.teamInfo(); break;
			case 3: service.teamListInfo(); break;
			case 4: service.regPlayer(); break;
			case 5: service.playerInfoByName(); break;
			case 6: service.playerInfoByBacknum(); break;
			case 7: service.playerInfoByNum(); break;
			case 8: service.playerListInTeam(); break;
			}
		}
	}
}