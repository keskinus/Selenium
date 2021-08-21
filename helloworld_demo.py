from selenium import webdriver

driver = webdriver.Chrome(
    executable_path='./drivers/chromedriver'
)

driver.get('http://localhost:8080/workspace/helloworld.html')