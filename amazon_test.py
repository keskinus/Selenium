import unittest
from selenium import webdriver


class AmazonTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome(
            executable_path='./drivers/chromedriver'
        )
        self.driver.get('http://www.amazon.com/')

    def tearDown(self):
        self.driver.quit()

    def test_amazon_search(self):
        # I am in the amazon home page.
        input_elem = self.driver.find_element_by_id('twotabsearchtextbox')
        input_elem.send_keys('Harry Potter')
        search_icon = self.driver.find_element_by_id('nav-search-submit-button')
        search_icon.click()
        # I am in the search result page
        status = self.driver.find_element_by_css_selector(
            '#search > span > div > span > h1 > div > div.sg-col-14-of-20.sg-col.s-breadcrumb.sg-col-10-of-16.sg-col-6-of-12 > div > div > span:nth-child(1)'
        )
        self.assertTrue(status.text.startswith('1-16'))
