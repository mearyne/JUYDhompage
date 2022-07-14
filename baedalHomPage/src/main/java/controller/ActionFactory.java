package controller;

import controller.action.AddFavoriteAction;
import controller.action.ChangePwAction;
import controller.action.JoinMasterAction;
import controller.action.JoinUserAction;
import controller.action.LoginMasterAction;
import controller.action.LoginUserAction;
import controller.action.logOutAction;

public class ActionFactory {
	
	// 공장도 여러개 있을 필요가 없기 때문에 싱글톤 패턴 사용함
	
	private ActionFactory() {
		// TODO Auto-generated constructor stub
	}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		
		if (command.equals("loginUser")) action = new LoginUserAction();
		else if (command.equals("loginMaster")) action = new LoginMasterAction();
		else if (command.equals("joinuser")) action = new JoinUserAction();
		else if (command.equals("joinmaster")) action = new JoinMasterAction();
		else if (command.equals("logOut")) action = new logOutAction();
		else if (command.equals("changePwAction")) action = new ChangePwAction();
		else if (command.equals("addfavo")) action = new AddFavoriteAction();
		
		return action;
	}
	
}
