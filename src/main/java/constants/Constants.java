package constants;

import org.openqa.selenium.By;

public class Constants {
    
	
	public static final String SIGNIN_BUTTON =".signupcontainer>a:nth-child(1)";
	public static final By SIGNIN_BUTTON_LOCATOR = By.cssSelector(SIGNIN_BUTTON);
	
	public static final String EMAIL_TEXTFIELD ="#login_id";
	public static final By EMAIL_TEXTFIELD_LOCATOR = By.cssSelector(EMAIL_TEXTFIELD );
	
	public static final String NEXT_BUTTON ="#nextbtn span";
	public static final By NEXT_BUTTON_LOCATOR = By.cssSelector(NEXT_BUTTON );
	
	public static final String PASSWORD_FIELD ="#password";
	public static final By PASSWORD_FIELD_LOCATOR = By.cssSelector(PASSWORD_FIELD );
	
	public static final String TEXTCONTENT = "A unique and powerful software suite to transform the way you work. Designed for businesses of all sizes, built by a company that";
	public static final String TEXTCONTENT_FIELD= "//h1";
	public static final By  TEXTCONTENT_FIELD_LOCATOR = By.xpath(TEXTCONTENT_FIELD);  

}
