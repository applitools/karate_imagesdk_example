package karatetest;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.applitools.eyes.NullLogHandler;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.images.Eyes;
import com.intuit.karate.driver.DevToolsDriver;
import com.intuit.karate.driver.chrome.Chrome;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class runEyes {

	private Eyes eyes;
	private DevToolsDriver driver;
		
	public runEyes(DevToolsDriver driver)
	{
		this.driver=driver;
		Init();
	}
	
	private void Init()
	{
		eyes=new Eyes();
		eyes.setApiKey("APPLITOOLS_API_KEY");
		eyes.setHostApp(this.driver.getOptions().type);
	}
	
	public void open(String AppName,String TestName,int width,int height)
	{
		width = width==0 ? 1024: width;
		height = height==0 ? 784: height;
		
		eyes.open(AppName,TestName,new RectangleSize(width, height));
	}
	
	
	public boolean check(byte[] bytes, String Tag)
	{
		try {
			eyes.checkImage(ImageIO.read(new ByteArrayInputStream(bytes)),Tag);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean check(byte[] bytes) {
		return check(bytes,"");
	}
	
	public boolean check()
	{
		return check("");
	}
	
	
	public boolean check(String Tag) {
		try {
			
			eyes.checkImage(ImageIO.read(new ByteArrayInputStream(this.driver.screenshotFull())),Tag);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void close() {
		eyes.close();
	}
	
	
}