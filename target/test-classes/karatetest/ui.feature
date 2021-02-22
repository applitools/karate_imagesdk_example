
Feature: Karate browser automation 

  Background:
    #* configure driver = { type: 'chromedriver', port: 9515, executable: '/usr/local/bin/chromedriver' }
    * configure driver = { type: 'chrome' }

  	* def getEyes = Java.type('karatetest.runEyes')
  
  Scenario: google search, land on the YouTube, and search for knoldus.
	  
	  Given driver 'https://google.com'
	  
	  * def eyesWrap = new getEyes(driver)	  
	  * eyesWrap.open(karate.info.scenarioName,karate.info.featureFileName,0,0)
	  
    And input('input[name=q]', 'applitools')
    And click('input[name=btnK]')
    And waitFor('#footcnt')
    And eyesWrap.check(driver.screenshot(),"Search Step")
    When waitFor("h3[class='LC20lb DKV0Md']").click();
    And waitForUrl('applitools.com')
    And waitFor('#site-footer')
    Then eyesWrap.check("Applitools Page")
    
    * eyesWrap.close()
    