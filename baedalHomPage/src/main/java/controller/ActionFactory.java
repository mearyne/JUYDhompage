package controller;

import controller.action.AddFavoriteAction;
import controller.action.AddMenuAction;
import controller.action.AddOrderAction;
import controller.action.ChangePwAction;
import controller.action.ChangePwMasterAction;
import controller.action.DeleteMenuAction;
import controller.action.JoinMasterAction;
import controller.action.JoinUserAction;
import controller.action.LoginMasterAction;
import controller.action.LoginUserAction;
import controller.action.QnaDeleteAction;
import controller.action.QnaWriteAction;
import controller.action.UpdateShopAction;
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
		else if (command.equals("changePwMasterAction")) action = new ChangePwMasterAction();
		else if (command.equals("updateShopAction")) action = new UpdateShopAction();
		else if (command.equals("addorder")) action = new AddOrderAction();
		else if (command.equals("delMenu")) action = new DeleteMenuAction();
		else if (command.equals("addMenu")) action = new AddMenuAction();
		else if (command.equals("QnaWriteAction")) action = new QnaWriteAction();
		else if (command.equals("QnaDeleteAction")) action = new QnaDeleteAction();
		return action;
	}
	
}
