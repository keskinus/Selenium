from selenium import webdriver

driver = webdriver.Chrome(
    executable_path='./drivers/chromedriver'
)

driver.get('http://www.amazon.com/')
# I am in the amazon home page.
input_elem = driver.find_element_by_id('twotabsearchtextbox')
input_elem.send_keys('Harry Potter')
search_icon = driver.find_element_by_id('nav-search-submit-button')
search_icon.click()