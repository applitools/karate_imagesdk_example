package karatetest;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.images.Eyes;
import com.intuit.karate.driver.chrome.Chrome;

public class runEyes {

	private Eyes eyes;
		
	public runEyes()
	{
		Init();
	}
	
	private void Init()
	{
		eyes=new Eyes();
		eyes.setApiKey("APPLITOOLS_API_KEY");
		eyes.open("Karate Demo - Images SDK"," POCTest - ImagesSDK",new RectangleSize(1024, 784));
	}
	
//	public void check(byte[] bytes) {
//		try {
//			eyes.checkImage(ImageIO.read(new ByteArrayInputStream(bytes)));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void check(Chrome driver) {
		try {
			eyes.checkImage(ImageIO.read(new ByteArrayInputStream(driver.screenshotFull())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		eyes.close();
	}
	
	
}