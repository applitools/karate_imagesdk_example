
Feature: Karate browser automation 

  Background:
    #* configure driver = { type: 'chromedriver', port: 9515, executable: '/usr/local/bin/chromedriver' }
    * configure driver = { type: 'chrome' }

  	* def getEyes = Java.type('karatetest.runEyes')
    * def eyesWrap = new getEyes()
  
  Scenario: google search, land on the YouTube, and search for knoldus.
	  	  
    Given driver 'https://google.com'
    And input('input[name=q]', 'applitools')
    And click('input[name=btnK]')
    When click("h3[class='LC20lb DKV0Md']")
    And waitForUrl('applitools.com')
    And waitFor('#site-footer')
    Then eyesWrap.check(driver)
    
    * eyesWrap.close()
    