import datetime as dt
import yfinance as yf
import pandas as pd

def downloadData(startTime,endTime,tickerName,timeperiod,interval):
    data = yf.download(tickers=tickerName,start=startTime,end=endTime,period=timeperiod,interval=interval)
    print(type(data))
    return data