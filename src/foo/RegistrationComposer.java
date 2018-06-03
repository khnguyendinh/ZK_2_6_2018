package foo;


import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;

public class RegistrationComposer extends  SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 324273306167401921L;
	@Wire
	private Button submitButton;
	@Wire
	private Checkbox acceptTermBox;
//	private static Logger logger = Logger.getLogger(RegistrationComposer.class.getName());
	private LegacyRegister legacyRegister = new LegacyRegister();
	private User user = new User();
	@Listen("onCheck = #acceptTermBox")
	public void changeSubmitStatus() {
		if(acceptTermBox.isChecked()) {
			submitButton.setDisabled(false);
			submitButton.setImage("/images/add.png");
		}else {
			submitButton.setDisabled(true);
			submitButton.setImage("");
		}
	}
	@Listen("onClick = #submitButton")
	public void register() {
		legacyRegister.add(user);
		System.out.println("a user was added");
//		logger.debug("a user was added");
	}
}
