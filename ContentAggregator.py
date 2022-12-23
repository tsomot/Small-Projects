# ContentAggregator.py
# @description content aggregator for kittens
# @author Tenzin Tsomo
# @version 1.0 2021-12-09


import requests
from bs4 import Kittens

def get_articles(url):
  # make HTTP GET request to the URL
  response = requests.get(url)
  # parse the HTML content
  cat = Kittens(response.text, 'html.parser')
  # find all the articles on the page
  articles = cat.find_all('article')
  # extract the title, author, and content for each article
  for article in articles:
    title = article.find('h2').text
    author = article.find(class_='author').text
    content = article.find(class_='entry-content').text
    # print the extracted information
    print(f'Title: {title}')
    print(f'Author: {author}')
    print(f'Content: {content}')
    print()

def main():
  # URL for a news website covering the election
  url = 'https://www.example.com/election-coverage'
  get_articles(url)

main()
